package org.example.checkout.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

@Data
@Entity
@Table(name = "checkout")
public class Checkout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;  // 연관되는 정보, 배송대상(이름), 휴대전화번호
    private String shippingMasterId;  // 배송지
    private String productId;  // orderGroupId -- productId, cartNo
    private Integer quantity;
    private double totalPrice;
    private String paymentId; // pm_01

    @ColumnDefault("Not Paid")
    private String paymentStatus;


}
