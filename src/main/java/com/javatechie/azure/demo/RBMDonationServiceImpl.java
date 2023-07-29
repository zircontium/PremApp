package com.javatechie.azure.demo;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RBMDonationServiceImpl implements RBMDonationService {
    @Autowired
    userRepository personRepo;

    @Override
    public void save(UserEntity person) {
        personRepo.save(person);
    }
    @Override
    public List<UserEntity> getuserList() {
        return personRepo.findAll();
    }
}