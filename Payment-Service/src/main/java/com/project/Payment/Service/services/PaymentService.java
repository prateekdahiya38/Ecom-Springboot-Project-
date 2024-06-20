package com.project.Payment.Service.services;

import com.project.Payment.Service.dtos.CreatePaymentLinkRequestDto;
import com.project.Payment.Service.dtos.CreatePaymentLinkResponseDto;
import com.stripe.exception.StripeException;

public interface PaymentService {
    CreatePaymentLinkResponseDto createPaymentLink(CreatePaymentLinkRequestDto request) throws StripeException;
}
