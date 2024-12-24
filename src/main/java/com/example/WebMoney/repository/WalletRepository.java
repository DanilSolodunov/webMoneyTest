package com.example.WebMoney.repository;

import com.example.WebMoney.entity.EntityWallet;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<EntityWallet, UUID> {
}