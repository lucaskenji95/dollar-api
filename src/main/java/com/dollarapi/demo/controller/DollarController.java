package com.dollarapi.demo.controller;

import com.dollarapi.demo.dto.DollarDto;
import com.dollarapi.demo.service.DollarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
public class DollarController {

    @Autowired
    private DollarService dollarService;

    @GetMapping("/dollar/{date}")
    public ResponseEntity<DollarDto> getDollar(@PathVariable String date) throws ParseException {

        final DollarDto dollarDto = dollarService.getDollarByDate(date);

        return new ResponseEntity<>(dollarDto, HttpStatus.OK);
    }
}
