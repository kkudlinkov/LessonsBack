package com.example.lessonsback.Domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestPassData {
    private Boolean isSuccess;
    private Integer tries;
}
