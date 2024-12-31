package com.spring.task.Country.Mapper;

import com.spring.task.Country.Dto.CountryDto;
import com.spring.task.Country.Entity.CountryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CountryMapper {

    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

    @Mapping(source = "isoCode",target = "name")
    CountryDto toCountryDto(CountryEntity countryEntity);

    @Mapping(source = "name",target = "isoCode")
    CountryEntity toCountryEntity(CountryDto countryDto);

}
