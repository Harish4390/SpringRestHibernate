package com.spring.rest.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.rest.component.Country;

@Repository
public class CountryDao implements CountryDaoInterface {

	@Autowired
	private HibernateTemplate template;

	@Autowired
	private SessionFactory sessionFactory;

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	// Get all countries from the database
	public List<Country> getAllCountries() {
		List<Country> countries = getTemplate().loadAll(Country.class);

		for (Country c : countries)
			System.out.println(c.toString());

		return countries;
	}

	// Get country by id from the database
	// public Country getCountry(int id) {
	// Country country = (Country) getTemplate().get(Country.class, new
	// Integer(id));
	// System.out.println(country.toString());
	// return country;
	// }

	public Country addcountry(Country c) {

		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.save(c);
		s.getTransaction().commit();
		s.close();

		return c;
	}

	public Country getCountry(@PathVariable int id) {
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.get(Country.class, id);
		return s.get(Country.class, id);

	}

	public Country updatecountry(@RequestBody Country c) {
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.update(c);
		s.getTransaction().commit();
		s.close();
		return null;
	}

}