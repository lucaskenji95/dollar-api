package com.dollarapi.demo.repository;

import com.dollarapi.demo.model.Dollar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
class DollarRepositoryTest {

    @Autowired
    private DollarRepository dollarRepository;

    private Dollar expectedDollar = new Dollar();

    private String dateString = "2020-08-06";

    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @BeforeEach
    void setUp() throws ParseException {
        dollarRepository.deleteAll();
        expectedDollar.setSell(new BigDecimal("4.5"));
        expectedDollar.setBuy(new BigDecimal("4.6"));
        expectedDollar.setDollarDate(dateFormat.parse(dateString));
        dollarRepository.save(expectedDollar);
    }

    @Test
    void shouldFindDollarByDate() throws ParseException {

        Optional<Dollar> dollarValue = dollarRepository.findByDollarDate(dateFormat.parse(dateString));
        assertThat(dollarValue.get()).isEqualTo(expectedDollar);
    }

}