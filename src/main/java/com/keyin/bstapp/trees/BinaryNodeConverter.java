package com.keyin.bstapp.trees;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.io.IOException;

@Converter(autoApply = true)
public class BinaryNodeConverter implements AttributeConverter<BinaryNode, String> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(BinaryNode binaryNode) {
        try {
            return binaryNode != null ? objectMapper.writeValueAsString(binaryNode) : null;
        } catch (IOException e) {
            throw new RuntimeException("Failed to convert BinaryNode to String", e);
        }
    }

    @Override
    public BinaryNode convertToEntityAttribute(String dbData) {
        try {
            return dbData != null ? objectMapper.readValue(dbData, BinaryNode.class) : null;
        } catch (IOException e) {
            throw new RuntimeException("Failed to convert String to BinaryNode", e);
        }
    }
}
