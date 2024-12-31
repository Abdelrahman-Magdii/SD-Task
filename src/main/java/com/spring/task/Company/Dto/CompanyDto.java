package com.spring.task.Company.Dto;

import com.spring.task.Country.Dto.CountryDto;

public record CompanyDto(int id, String name, CountryDto country) {
}
