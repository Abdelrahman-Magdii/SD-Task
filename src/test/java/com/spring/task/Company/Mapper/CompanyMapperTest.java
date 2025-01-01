package com.spring.task.Company.Mapper;

import com.spring.task.Company.Dto.CompanyDto;
import com.spring.task.Company.Entity.CompanyEntity;
import com.spring.task.Country.Dto.CountryDto;
import com.spring.task.Country.Entity.CountryEntity;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

public class CompanyMapperTest {

    private static final Logger log = LoggerFactory.getLogger(CompanyMapperTest.class);
    private final CompanyMapper companyMapper = Mappers.getMapper(CompanyMapper.class);

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

        // Expected CompanyDto
        CompanyDto expectedCompanyDto = new CompanyDto(1, "Company", new CountryDto(1, "US"));

        // Act
        CompanyDto companyDto = companyMapper.toCompanyDto(companyEntity);

        // Assert
        assertNotNull(companyDto);
        assertEquals(1, companyDto.id());
        assertEquals("Company", companyDto.name());
        assertNotNull(companyDto.country());
        assertEquals(1, companyDto.country().id());
        assertEquals("US", companyDto.country().name());
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

        // Act
        CompanyEntity companyEntity = companyMapper.toCompanyEntity(companyDto);

        // Assert
        assertNotNull(companyEntity);
        assertEquals(1, companyEntity.getId());
        assertEquals("Company", companyEntity.getName());
        assertNotNull(companyEntity.getCountry());
        assertEquals(1, companyEntity.getCountry().getId());
        assertEquals("US", companyEntity.getCountry().getIsoCode());
    }
}
