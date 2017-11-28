package com.example.demo;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data

@ConfigurationProperties("foo")
public class FooProperties {
	private boolean enabled;
	private InetAddress remoteAddress;
	private final Security security = new Security();

	@Data
	public static class Security {
		private String username;
		private String password;
		private List<String> roles = new ArrayList<>(Collections.singleton("USER"));

	}

}