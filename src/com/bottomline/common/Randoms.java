package com.bottomline.common;

import com.github.javafaker.Faker;

public class Randoms {

	// this static class can be used anywhere directly, faker origin from
	// https://github.com/DiUS/java-faker
	
	static Faker faker = new Faker();

	public static String Name() {
		return faker.funnyName().name();
	}

	public static String Finance() {
		return faker.finance().iban();
	}

	public static String ID() {
		return faker.idNumber().valid();
	}

}
