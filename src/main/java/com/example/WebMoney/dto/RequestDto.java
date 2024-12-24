package com.example.WebMoney.dto;

import com.example.WebMoney.constants.OperationType;
import java.util.UUID;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class RequestDto {

    @NonNull
    private  UUID id;

    @NonNull
    private OperationType operationType;

    @NonNull
    private Double amount;

    public RequestDto() {
    }
}