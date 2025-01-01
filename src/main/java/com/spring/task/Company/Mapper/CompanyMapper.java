package com.spring.task.Company.Mapper;

import com.spring.task.Company.Dto.CompanyDto;
import com.spring.task.Company.Entity.CompanyEntity;
import com.spring.task.Country.Mapper.CountryMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",uses =  CountryMapper.class)
public interface CompanyMapper {

    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);


    @Mapping(source = "country", target = "country")
    @Mapping(source = "country.isoCode", target = "country.name")
    CompanyDto toCompanyDto(CompanyEntity companyEntity);

    @Mapping(source = "country", target = "country")
    @Mapping(source = "country.name", target = "country.isoCode")
    CompanyEntity toCompanyEntity(CompanyDto companyDto);


}
