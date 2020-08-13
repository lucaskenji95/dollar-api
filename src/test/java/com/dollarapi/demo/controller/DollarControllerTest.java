package com.dollarapi.demo.controller;

import com.dollarapi.demo.dto.DollarDto;
import com.dollarapi.demo.service.DollarService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DollarControllerTest {

    @Mock
    private DollarService dollarService;

    @InjectMocks
    private DollarController dollarController;

    @Test
    void shouldReturnOkGivenDollarWithDateExists() throws ParseException {
        when(dollarService.getDollarByDate("2020-07-01")).thenReturn(DollarDto.builder().build());

        ResponseEntity<DollarDto> responseDollarDto =  dollarController.getDollar("2020-07-01");

        assertThat(responseDollarDto.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}