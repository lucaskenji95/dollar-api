package com.dollarapi.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RateDto {

    @JsonFormat(shape=JsonFormat.Shape.STRING)
    private BigDecimal buy;

    @JsonFormat(pattern = "%.2f")
    private BigDecimal sell;
}
