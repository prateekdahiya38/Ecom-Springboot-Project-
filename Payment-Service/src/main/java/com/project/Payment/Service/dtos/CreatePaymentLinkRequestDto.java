package com.project.Payment.Service.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CreatePaymentLinkRequestDto {
    private UUID orderId;
}
