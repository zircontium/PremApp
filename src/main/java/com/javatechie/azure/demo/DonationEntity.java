package com.javatechie.azure.demo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@ToString
@AllArgsConstructor
@Entity
@Table(name="DONATION")
public class DonationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(nullable = false)
    private Date date;

    @Getter
    @Setter
    @Column(nullable = false)
    private Long receiptNo;

    @Getter
    @Setter
    @Column(nullable = false)
    private Long amountPerMonth;

    @Getter
    @Setter
    @Column(nullable = false)
    private Date startMonth;

    @Getter
    @Setter
    @Column(nullable = false)
    private Date endMonth;

    @Getter
    @Setter
    @Column(nullable = false)
    private Long totalAmount;

    @Getter
    @Setter
    @Column(nullable = false)
    private Long userId;
}
