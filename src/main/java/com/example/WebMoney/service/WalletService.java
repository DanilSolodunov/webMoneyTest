package com.example.WebMoney.service;

import com.example.WebMoney.constants.ConstantsMessage;
import com.example.WebMoney.constants.OperationType;
import com.example.WebMoney.controllers.request.WalletRequest;
import com.example.WebMoney.dto.RequestDto;
import com.example.WebMoney.entity.EntityWallet;
import com.example.WebMoney.repository.WalletRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class WalletService {

    private WalletService walletService;

    private WalletRepository walletRepository;

    private WalletRequest walletRequest;

    private RequestDto requestDto;

    public WalletService() {
    }

    @Transactional
    public EntityWallet walletOperation(WalletRequest walletRequest) {
        EntityWallet wallet = walletRepository.findById(this.requestDto.getId())
                .orElseThrow(() -> new IllegalArgumentException(ConstantsMessage.NOT_FOUND));
        if (this.requestDto.getOperationType() == OperationType.DEPOSIT) {
            wallet.setBalance(wallet.getBalance() + this.requestDto.getAmount());
        } else if (this.requestDto.getOperationType() == OperationType.WIHDRAW) {
            if (wallet.getBalance() < this.requestDto.getAmount()) {
                throw new IllegalArgumentException(ConstantsMessage.INSUFFICIENT_FUNDS);
            }

            wallet.setBalance(wallet.getBalance() - this.requestDto.getAmount());
        }

        return walletRepository.save(wallet);
    }

    public EntityWallet getBalance(UUID walletId) {
        return walletRepository.findById(walletId).orElseThrow(() -> new IllegalArgumentException(ConstantsMessage.NOT_FOUND));
    }
}
