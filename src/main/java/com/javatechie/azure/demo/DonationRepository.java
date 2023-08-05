package com.javatechie.azure.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DonationRepository extends JpaRepository<DonationEntity, Long> {

    Optional<DonationEntity> findById(Long id);

    @Query( nativeQuery = true,
            value = "SELECT p FROM DONATION p WHERE p.userId = :id) ")
    List<DonationEntity> findLastTransaction(@Param("id") long id);
}