package com.example.WebMoney.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Setter
@Getter
public class EntityWallet {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private double balance;

}
