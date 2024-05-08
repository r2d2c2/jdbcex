package org.zerock.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;

public enum MapperUtil {
    MYINSTANCE;
    private ModelMapper modelMapper;
    MapperUtil() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)//필드 매칭
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)//privat까지 연결
                .setMatchingStrategy(MatchingStrategies.STANDARD)//model,models 구별
                ;
    }

    public ModelMapper getModelMapper() {
        return modelMapper;
    }
}
