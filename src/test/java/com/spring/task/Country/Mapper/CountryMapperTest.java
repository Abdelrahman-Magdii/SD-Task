package com.spring.task.Country.Mapper;

import com.spring.task.Country.Dto.CountryDto;
import com.spring.task.Country.Entity.CountryEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CountryMapperTest {

    @Mock
    private CountryMapper countryMapper;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testToCountryDto() {
        // Arrange
        CountryEntity countryEntity = new CountryEntity();
        countryEntity.setId(1);
        countryEntity.setIsoCode("US");

        CountryDto expectedCountryDto = new CountryDto(1, "US");

        when(countryMapper.toCountryDto(countryEntity)).thenReturn(expectedCountryDto);

        // Act
        CountryDto countryDto = countryMapper.toCountryDto(countryEntity);

        // Assert
        assertNotNull(countryDto);
        assertEquals(1, countryDto.id());
        assertEquals("US", countryDto.name());

        // Verify
        verify(countryMapper, times(1)).toCountryDto(countryEntity);
    }

    @Test
    void testToCountryEntity() {
        // Arrange
        CountryDto countryDto = new CountryDto(1, "US");

        CountryEntity expectedCountryEntity = new CountryEntity();
        expectedCountryEntity.setId(1);
        expectedCountryEntity.setIsoCode("US");

        when(countryMapper.toCountryEntity(countryDto)).thenReturn(expectedCountryEntity);

        // Act
        CountryEntity countryEntity = countryMapper.toCountryEntity(countryDto);

        // Assert
        assertNotNull(countryEntity);
        assertEquals(1, countryEntity.getId());
        assertEquals("US", countryEntity.getIsoCode());

        // Verify
        verify(countryMapper, times(1)).toCountryEntity(countryDto);
    }
}
