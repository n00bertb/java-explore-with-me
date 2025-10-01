package ru.practicum.mainservice.event.service;

import jakarta.servlet.http.HttpServletRequest;
import ru.practicum.mainservice.event.model.Event;
import ru.practicum.stats_common.model.ViewStats;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface StatsService {
    void addHit(HttpServletRequest request);

    List<ViewStats> getStats(LocalDateTime start, LocalDateTime end, List<String> uris, Boolean unique);

    Map<Long, Long> getViews(Set<Event> events);

    Map<Long, Long> getConfirmedRequests(Set<Event> events);
}
