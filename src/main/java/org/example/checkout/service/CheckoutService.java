package org.example.checkout.service;

import lombok.RequiredArgsConstructor;
import org.example.checkout.entity.Checkout;
import org.example.checkout.repository.CheckoutRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckoutService {

    private final CheckoutRepository checkoutRepository;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    // api 수신
    public Checkout checkoutProcessor(Checkout checkoutRequest) {

        // mysql 저장
        Checkout returnCheckout = new Checkout();
        returnCheckout = checkoutRepository.save(checkoutRequest);

        // kafka 전달
        kafkaTemplate.send("checkout-requested", checkoutRequest);
        return returnCheckout;
    }



}
