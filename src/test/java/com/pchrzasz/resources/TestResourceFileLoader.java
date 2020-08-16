package com.pchrzasz.resources;

import io.micrometer.core.instrument.util.IOUtils;
import io.micronaut.core.io.ResourceResolver;

import java.nio.charset.StandardCharsets;

public class TestResourceFileLoader {

    private static final ResourceResolver loader = new ResourceResolver();
    private static final String CLASSPATH_URL_PREFIX = "classpath:";

    public static String loadFileContentFromResources(String fileName) {
        return loader.getResourceAsStream(CLASSPATH_URL_PREFIX + fileName)
                     .map(inputStream -> IOUtils.toString(inputStream, StandardCharsets.UTF_8))
                     .orElseThrow(() -> new IllegalArgumentException("Error during loading resource file"));
    }

}
