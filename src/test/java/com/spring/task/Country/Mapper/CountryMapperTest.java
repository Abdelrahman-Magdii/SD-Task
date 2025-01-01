package com.spring.task.Country.Mapper;

import com.spring.task.Country.Dto.CountryDto;
import com.spring.task.Country.Entity.CountryEntity;
import com.spring.task.Country.Services.CountryServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountryMapperTest {

    private CountryMapper countryMapper;
    private CountryServices countryServices;

    @BeforeEach
    void setUp() {
        // Initialize the actual services and mapper
        countryServices = new CountryServices();
        countryMapper = new CountryMapperImpl();
    }

    @Test
    void testToDto() {
        // Arrange: create a CountryEntity and provide an isoCode
        CountryEntity countryEntity = new CountryEntity();
        countryEntity.setIsoCode("US");

        // Act: call the mapping method with the actual CountryServices
        CountryDto countryDto = countryMapper.toDto(countryEntity, countryServices);

        // Assert: verify the mapped values
        assertNotNull(countryDto);
        assertEquals("name of US", countryDto.name());
    }
}
