package com.example.lessonsback.Domain.dto;

import lombok.*;

import java.util.List;

@Data
public class SubmitTestDTO {
    private List<SubmitQuestion> questions;
}
