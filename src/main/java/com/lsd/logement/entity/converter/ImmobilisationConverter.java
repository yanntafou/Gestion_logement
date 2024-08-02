package com.lsd.logement.entity.converter;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lsd.logement.entity.infrastructure.Immobilisation;

import jakarta.persistence.AttributeConverter;

public class ImmobilisationConverter implements AttributeConverter<List<Immobilisation>, String> {

    private static final ObjectMapper mapper;
    Logger logger = LogManager.getLogger(ImmobilisationConverter.class);

    static {
        mapper = new ObjectMapper();
    }

    @Override
    public String convertToDatabaseColumn(List<Immobilisation> responses) {
        try {
            return mapper.writeValueAsString(responses);
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    @Override
    public List<Immobilisation> convertToEntityAttribute(String s) {
        try {
            return mapper.readValue(s, new TypeReference<List<Immobilisation>>() {
            });
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }
}
