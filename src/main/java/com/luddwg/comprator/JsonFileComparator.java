package com.luddwg.comprator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

class JsonFileComparator implements FileComparator {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public boolean compare(File a, File b) {
        return getJsonNode(a).equals(getJsonNode(b));
    }

    private JsonNode getJsonNode(File file) {
        try {
            return objectMapper.readTree(file);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
