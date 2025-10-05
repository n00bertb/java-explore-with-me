package ru.practicum.statsserver.service;

import ru.practicum.statscommon.model.EndpointHit;
import ru.practicum.statscommon.model.ViewStats;

import java.time.LocalDateTime;
import java.util.List;

public interface StatsService {
    void addHit(EndpointHit endpointHit);

    List<ViewStats> getStats(LocalDateTime start, LocalDateTime end, List<String> uris, Boolean unique);
}