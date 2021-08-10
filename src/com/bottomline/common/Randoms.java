package com.bottomline.common;

import com.github.javafaker.Faker;

public class Randoms {

	// this static class can be used anywhere directly, faker origin from
	// https://github.com/DiUS/java-faker

	static Faker faker = new Faker();

	public static String IBAN() {
		return faker.finance().iban();
	}

	public static String ID() {
		return faker.idNumber().valid();
	}

	public static String Lebowski() {
		return faker.lebowski().actor();
	}

	public static String Name() {
		return faker.name().firstName();
	}

	public static String YodaQuote() {
		return faker.yoda().quote();
	}

	public static String Department() {
		return faker.commerce().department();
	}

	public static String CompanyName() {
		return faker.company().name();
	}

	public static String CompanyIndustry() {
		return faker.company().industry();
	}
}