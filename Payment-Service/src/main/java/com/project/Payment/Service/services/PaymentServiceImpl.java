package com.project.Payment.Service.services;

import com.project.Payment.Service.client.OrderServiceClient;
import com.project.Payment.Service.dtos.CreatePaymentLinkRequestDto;
import com.project.Payment.Service.dtos.CreatePaymentLinkResponseDto;
import com.project.Payment.Service.dtos.OrderDto;
import com.project.Payment.Service.paymentgateways.PaymentGateway;
import com.project.Payment.Service.paymentgateways.StripePaymentGatewayAdapter;
import com.stripe.exception.StripeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService{
    @Autowired
    private OrderServiceClient orderServiceClient;
    @Autowired
    private PaymentGateway paymentGateway;


    @Override
    public CreatePaymentLinkResponseDto createPaymentLink(CreatePaymentLinkRequestDto request) throws StripeException {
        CreatePaymentLinkResponseDto response = new CreatePaymentLinkResponseDto();

        OrderDto orderDto = orderServiceClient.getOrder(request.getOrderId());
        long amount = (long)(orderDto.getTotalPrice()*100);
        String paymentUrl = paymentGateway.createPaymentLink(amount);
        response.setPaymentUrl(paymentUrl);
        return response;
    }
}
