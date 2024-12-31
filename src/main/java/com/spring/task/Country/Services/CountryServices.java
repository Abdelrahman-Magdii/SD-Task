package com.spring.task.Country.Services;

import org.springframework.stereotype.Service;

@Service
public class CountryServices {

    public String getName(String isoCode) {
        return "name of " + isoCode;
    }
}
