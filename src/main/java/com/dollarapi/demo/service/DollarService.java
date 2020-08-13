package com.dollarapi.demo.service;

import com.dollarapi.demo.model.Dollar;
import com.dollarapi.demo.dto.DollarDto;
import com.dollarapi.demo.dto.RateDto;
import com.dollarapi.demo.repository.DollarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
public class DollarService {

    @Autowired
    private DollarRepository dollarRepository;

    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public DollarDto getDollarByDate(String dollarDate) throws ParseException {
        final Dollar dollar = dollarRepository.findByDollarDate(dateFormat.parse(dollarDate))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return buildDollar(dollar);

    }

    private DollarDto buildDollar(Dollar dollar) {
        return DollarDto.builder()
                .date(dollar.getDollarDate())
                .rate(RateDto.builder().buy(dollar.getBuy()).sell(dollar.getSell()).build())
                .build();
    }
}
