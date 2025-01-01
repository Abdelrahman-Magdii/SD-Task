package com.spring.task.Company.Mapper;

import com.spring.task.Company.Dto.CompanyDto;
import com.spring.task.Company.Entity.CompanyEntity;
import com.spring.task.Country.Dto.CountryDto;
import com.spring.task.Country.Entity.CountryEntity;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CompanyMapperTest {

    @Mock
    private CompanyMapper companyMapper;

    public CompanyMapperTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testToCompanyDto() {
        // Arrange
        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setId(1);
        companyEntity.setName("Company");

        CountryEntity countryEntity = new CountryEntity();
        countryEntity.setId(1);
        countryEntity.setIsoCode("US");
        companyEntity.setCountry(countryEntity);

        CompanyDto expectedCompanyDto = new CompanyDto(1, "Company", new CountryDto(1, "US"));

        when(companyMapper.toCompanyDto(companyEntity)).thenReturn(expectedCompanyDto);

        // Act
        CompanyDto companyDto = companyMapper.toCompanyDto(companyEntity);

        // Assert
        assertNotNull(companyDto);
        assertEquals(1, companyDto.id());
        assertEquals("Company", companyDto.name());
        assertNotNull(companyDto.country());
        assertEquals(1, companyDto.country().id());
        assertEquals("US", companyDto.country().name());

        // Verify
        verify(companyMapper, times(1)).toCompanyDto(companyEntity);
    }

    @Test
    void testToCompanyEntity() {
        // Arrange
        CountryDto countryDto = new CountryDto(1, "US");
        CompanyDto companyDto = new CompanyDto(1, "Company", countryDto);

        CompanyEntity expectedCompanyEntity = new CompanyEntity();
        expectedCompanyEntity.setId(1);
        expectedCompanyEntity.setName("Company");

        CountryEntity countryEntity = new CountryEntity();
        countryEntity.setId(1);
        countryEntity.setIsoCode("US");
        expectedCompanyEntity.setCountry(countryEntity);

        when(companyMapper.toCompanyEntity(companyDto)).thenReturn(expectedCompanyEntity);

        // Act
        CompanyEntity companyEntity = companyMapper.toCompanyEntity(companyDto);

        // Assert
        assertNotNull(companyEntity);
        assertEquals(1, companyEntity.getId());
        assertEquals("Company", companyEntity.getName());
        assertNotNull(companyEntity.getCountry());
        assertEquals(1, companyEntity.getCountry().getId());
        assertEquals("US", companyEntity.getCountry().getIsoCode());

        // Verify
        verify(companyMapper, times(1)).toCompanyEntity(companyDto);
    }
}
