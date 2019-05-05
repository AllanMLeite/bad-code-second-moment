package br.com.cc.demo.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;

public final class ResourceUtils {

	private ResourceUtils() {
		// just to prevent instantiation
	}

	public static String loadResourceAsString(String pathAsString) {
		try {
			return IOUtils.toString(loadResourceAsInputStream(pathAsString), StandardCharsets.UTF_8.toString());
		} catch (Exception e) {
			throw new RuntimeException("error loading resource " + pathAsString, e);
		}
	}

	private static InputStream loadResourceAsInputStream(String pathAsString) {
		try {
			return new ClassPathResource(pathAsString).getInputStream();
		} catch (IOException e) {
			throw new RuntimeException("error loading resource " + pathAsString, e);
		}
	}
}
