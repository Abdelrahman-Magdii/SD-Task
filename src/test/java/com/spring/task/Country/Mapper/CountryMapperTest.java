package com.spring.task.Country.Mapper;

import com.spring.task.Country.Dto.CountryDto;
import com.spring.task.Country.Entity.CountryEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CountryMapperTest {

    private final CountryMapper countryMapper = CountryMapper.INSTANCE;


    @Test
    void testToCountryDto() {
        // Arrange
        CountryEntity countryEntity = new CountryEntity();
        countryEntity.setId(1);
        countryEntity.setIsoCode("US");

        // Act
        CountryDto countryDto = countryMapper.toCountryDto(countryEntity);

        // Assert
        assertNotNull(countryDto);
        assertEquals(1, countryDto.id());
        assertEquals("US", countryDto.name());
    }

    @Test
    void testToCountryEntity() {
        // Arrange
        CountryDto countryDto = new CountryDto(1, "US");

        // Act
        CountryEntity countryEntity = countryMapper.toCountryEntity(countryDto);

        // Assert
        assertNotNull(countryEntity);
        assertEquals(1, countryEntity.getId());
        assertEquals("US", countryEntity.getIsoCode());
    }


}
