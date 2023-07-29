package com.javatechie.azure.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@AllArgsConstructor
@Entity
@Table(name="USER")
public class UserEntity {
    public UserEntity(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column
    private String salutation;

    @Getter
    @Setter
    @Column(nullable = false)
    private String firstName;

    @Getter
    @Setter
    @Column
    private String middleName;

    @Getter
    @Setter
    @Column
    private String lastName;

    @Getter
    @Setter
    @Column(nullable = false)
    private String addressLine1;


    @Getter
    @Setter
    @Column
    private String addressLine2;

    @Getter
    @Setter
    @Column(nullable = false)
    private String city;

    @Getter
    @Setter
    @Column(nullable = false)
    private String state;

    @Getter
    @Setter
    @Column(nullable = false)
    private Long contactNo;

    @Getter
    @Setter
    @Column
    private String email;

    @Getter
    @Setter
    @Column
    private String idProofName;

    @Getter
    @Setter
    @Column
    private String idProofDetails;

}
