package com.project.Payment.Service.paymentgateways;

import com.stripe.exception.StripeException;

public interface PaymentGateway {
    public String createPaymentLink(Long amt) throws StripeException;
}
