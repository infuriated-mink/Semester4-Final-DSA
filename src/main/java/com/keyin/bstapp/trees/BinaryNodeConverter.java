package com.keyin.bstapp.trees;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class BinaryNodeConverter implements AttributeConverter<BinaryNode, String> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(BinaryNode attribute) {
        if (attribute == null) {
            return null;
        }
        try {
            return serializeBinaryNodeToString(attribute);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public BinaryNode convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        try {
            return deserializeStringToBinaryNode(dbData);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private String serializeBinaryNodeToString(BinaryNode binaryNode) throws JsonProcessingException {
        return objectMapper.writeValueAsString(binaryNode);
    }

    private BinaryNode deserializeStringToBinaryNode(String json) throws JsonProcessingException {
        return objectMapper.readValue(json, BinaryNode.class);
    }
}
