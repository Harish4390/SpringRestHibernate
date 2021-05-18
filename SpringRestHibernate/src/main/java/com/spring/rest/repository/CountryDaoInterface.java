package com.spring.rest.repository;

import com.spring.rest.component.Country;

public interface CountryDaoInterface {
	
	public Country addcountry(Country c);
	public Country getCountry(int id);
	public Country updatecountry(Country c);


}
