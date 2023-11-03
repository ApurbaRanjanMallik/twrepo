package com.arm.limits.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arm.limits.bean.LimitsConfiguration;

@RestController
public class LimitsConfigurationController {
	@Autowired
	private LimitsConfiguration limits;

	@GetMapping("/limits")
	public LimitsConfiguration returnLimits() {
		System.out.println(limits.getMaximum());
		return new LimitsConfiguration(limits.getMinimum(), limits.getMaximum());
	}
}