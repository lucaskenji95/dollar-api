package com.dollarapi.demo.service;

import com.dollarapi.demo.model.Dollar;
import com.dollarapi.demo.dto.DollarDto;
import com.dollarapi.demo.dto.RateDto;
import com.dollarapi.demo.repository.DollarRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DollarServiceTest {

    @Mock
    private DollarRepository dollarRepository;

    @InjectMocks
    private DollarService dollarService;

    @Test
    void shouldBuildDollarCorrectly() throws ParseException {
        DollarDto expectedDollarDto = DollarDto.builder()
                                        .rate(RateDto.builder().sell(new BigDecimal("4.3")).buy(new BigDecimal("4.4")).build())
                                        .build();
        Dollar dollar = new Dollar();
        dollar.setBuy(new BigDecimal("4.4"));
        dollar.setSell(new BigDecimal("4.3"));

        when(dollarRepository.findByDollarDate(any())).thenReturn(Optional.of(dollar));

        DollarDto dollarDto = dollarService.getDollarByDate("2020-07-01");

        assertThat(dollarDto).isEqualTo(expectedDollarDto);

    }

    @Test
    void shouldReturnThrowResponseStatusExceptionWhenThereIsNoValue() {
        when(dollarRepository.findByDollarDate(any())).thenReturn(Optional.empty());

        assertThrows(ResponseStatusException.class, () -> dollarService.getDollarByDate("2020-07-01"));
    }
}