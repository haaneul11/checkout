package org.example.checkout.entity;

import lombok.Data;

@Data
public class PaymentMethod {
    private String paymentId;
    private String paymentMethod;  // creditcard, kakaopay
    private String paymentDetail;  // cardNo#, kakaoToken
    private String paymentExpireDate;  // card유효기간
}
