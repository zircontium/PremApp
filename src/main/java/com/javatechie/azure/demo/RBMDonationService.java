package com.javatechie.azure.demo;

import java.util.List;
public interface RBMDonationService {
    void save(UserEntity user);
    List<UserEntity> getuserList();
}