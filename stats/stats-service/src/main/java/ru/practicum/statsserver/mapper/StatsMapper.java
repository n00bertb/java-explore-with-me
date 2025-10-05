package ru.practicum.statsserver.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.practicum.statscommon.model.EndpointHit;
import ru.practicum.statsserver.model.Stats;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public interface StatsMapper {
    @Mapping(target = "timestamp", expression = "java(timestamp)")
    Stats toStats(EndpointHit endpointHit, LocalDateTime timestamp);
}
