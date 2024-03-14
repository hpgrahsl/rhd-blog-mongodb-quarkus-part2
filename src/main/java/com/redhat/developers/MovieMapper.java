package com.redhat.developers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface MovieMapper {

    @Mapping(target = "id", expression = "java(m.id.toHexString())")
    @Mapping(target = "genres", source = "genre")
    @Mapping(target = "runningTime", source = "duration")
    @Mapping(target = "yearReleased", expression = "java(Year.of(m.year))")
    MovieDTO toDTO(Movie m);

    @Mapping(target = "id", expression = "java(m.id() != null ? new org.bson.types.ObjectId(m.id()) : null)")
    @Mapping(target = "genre", source = "genres")
    @Mapping(target = "duration", source = "runningTime")
    @Mapping(target = "year", expression = "java(m.yearReleased().getValue())")
    Movie toEntity(MovieDTO m);

}

