package com.spring.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.rest.component.Country;
import com.spring.rest.repository.CountryDao;

@Service
public class CountryServ implements CountryServiceInterface {

	@Autowired
	private CountryDao cdao;

	public List<Country> getAllCountries() {
		return cdao.getAllCountries();
	}

	@Transactional
	public Country getCountry(int id) {
		return cdao.getCountry(id);
	}

	public Country addcountry(Country c) {
		return cdao.addcountry(c);
	}

	public Country updatecountry(Country c) {
		return cdao.updatecountry(c);
	}

}