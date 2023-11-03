package com.tw.junit;

import java.util.List;

/**
 * Hello world!
 *
 */
public class Demo {
	List<String> namesList;

	public Demo(List<String> namesList) {
		super();
		this.namesList = namesList;
	}

	public String concatinateNames() {
		String value = "";
		for (String name : namesList) {
			value = value.concat(name).concat(" ");
		}
		value = value.trim();
		return value;
	}
}
