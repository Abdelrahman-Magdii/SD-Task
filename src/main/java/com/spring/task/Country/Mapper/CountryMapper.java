package com.spring.task.Country.Mapper;

import com.spring.task.Country.Dto.CountryDto;
import com.spring.task.Country.Entity.CountryEntity;
import com.spring.task.Country.Services.CountryServices;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface CountryMapper {

    @Mapping(source = "isoCode", target = "name", qualifiedByName = "isoToName")
    CountryDto toDto(CountryEntity country, @Context CountryServices countryService);

    @Named("isoToName")
    default String isoToName(String isoCode, @Context CountryServices countryService) {
        return countryService.getName(isoCode);
    }

}
