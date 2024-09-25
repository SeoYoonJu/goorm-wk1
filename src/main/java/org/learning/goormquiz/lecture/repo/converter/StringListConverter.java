package org.learning.goormquiz.lecture.repo.converter;

import jakarta.persistence.AttributeConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringListConverter implements AttributeConverter<List<String>, String> {

    private static final String SEPARATOR = "|";

    // 리스트를 문자열로 변환 (리스트 -> "|")
    @Override
    public String convertToDatabaseColumn(List<String> attribute) {
        if (attribute == null || attribute.isEmpty()) {
            return "";
        }
        return attribute.stream().collect(Collectors.joining(SEPARATOR));
    }

    // 문자열을 리스트로 변환 ("|" -> 리스트)
    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return List.of();
        }
        return Arrays.asList(dbData.split("\\|"));
    }
}