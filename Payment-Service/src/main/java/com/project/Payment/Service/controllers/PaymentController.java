package com.project.Payment.Service.controllers;

import com.project.Payment.Service.dtos.CreatePaymentLinkRequestDto;
import com.project.Payment.Service.dtos.CreatePaymentLinkResponseDto;
import com.project.Payment.Service.services.PaymentService;
import com.stripe.exception.StripeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pay")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping()
    public ResponseEntity<CreatePaymentLinkResponseDto> createPaymentLink(@RequestBody CreatePaymentLinkRequestDto request) throws StripeException {
        return ResponseEntity.ok(paymentService.createPaymentLink(request));
    }
}
