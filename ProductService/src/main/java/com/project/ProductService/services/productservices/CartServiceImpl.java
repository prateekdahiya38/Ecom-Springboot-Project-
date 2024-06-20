package com.project.ProductService.services.productservices;


import com.project.ProductService.dtos.productservicedtos.AddProductInCartRequestDto;
import com.project.ProductService.dtos.productservicedtos.AddProductInCartResponseDto;
import com.project.ProductService.dtos.productservicedtos.CartItemDto;
import com.project.ProductService.dtos.productservicedtos.CartResponseDto;
import com.project.ProductService.exceptions.LowQuantityException;
import com.project.ProductService.exceptions.NoProductFoundException;
import com.project.ProductService.exceptions.OutOfStockException;
import com.project.ProductService.mappers.productservicemapper.DBCartMapper;
import com.project.ProductService.models.Cart;
import com.project.ProductService.models.CartItem;
import com.project.ProductService.models.Product;
import com.project.ProductService.repositories.CartItemRepository;
import com.project.ProductService.repositories.CartRepository;
import com.project.ProductService.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartItemRepository cartItemRepository;



    @Override
    public AddProductInCartResponseDto addProductInCart(AddProductInCartRequestDto request) throws LowQuantityException, OutOfStockException {
        AddProductInCartResponseDto response = new AddProductInCartResponseDto();
        Optional<Cart> optionalCart = cartRepository.findByUserId(request.getUserId());
        Cart cart = optionalCart.get();

        Product product = productRepository.findById(request.getProductId()).orElseThrow(
                ()-> new NoProductFoundException("Product Doesn't Found"));

        if(product.getQuantity() == 0){
            throw new OutOfStockException("the product is out of stock");
        }else if (product.getQuantity()<request.getQuantity()){
            throw new LowQuantityException("the quantity you requested is higher then the stock");
        }

        Optional<CartItem> existingCartItem = cart.getCartItems().stream()
                .filter(cartItem -> cartItem.getProduct().getId().equals(product.getId()))
                .findFirst();


        if(existingCartItem.isPresent()){
            CartItem cartItem = existingCartItem.get();
            cartItem.setQuantity(cartItem.getQuantity() + request.getQuantity());
            cartItem.setPrice(cartItem.getQuantity()*product.getPrice());
        }else {
            CartItem cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setQuantity(request.getQuantity());
            cartItem.setPrice(cartItem.getQuantity() * product.getPrice());
            CartItem savedCartItem = cartItemRepository.save(cartItem);
            cart.getCartItems().add(savedCartItem);
        }
        double totalPrice = 0.0;
        for (CartItem item : cart.getCartItems()){
            totalPrice += item.getPrice();
        }
        cart.setTotalPrice(totalPrice);
        Cart savedCart = cartRepository.save(cart);

        product.setQuantity(product.getQuantity()- request.getQuantity());
        productRepository.save(product);

        response.setCartId(savedCart.getId());
        return response;
    }





    @Override
    public CartResponseDto getCartByUser(UUID userId) {
        CartResponseDto response = new CartResponseDto();
        Optional<Cart> optionalCart = cartRepository.findByUserId(userId);
        if (optionalCart.isEmpty()){
            Cart cart = new Cart();
            cart.setUserId(userId);
            Cart savedCart = cartRepository.save(cart);
            response.setCartId(savedCart.getId());
        }else {
            response.setCartId(optionalCart.get().getId());
            List<CartItemDto> cartItemDtos = new ArrayList<>();
            for(CartItem cartItem : optionalCart.get().getCartItems()){
                cartItemDtos.add(DBCartMapper.cartItemToCartItemDtoConvertor(cartItem));
            }
            response.setCartItems(cartItemDtos);
        }
        return response;
    }
}
