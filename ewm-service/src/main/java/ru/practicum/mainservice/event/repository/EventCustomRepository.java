package ru.practicum.mainservice.event.repository;

import ru.practicum.mainservice.event.dto.enums.EventState;
import ru.practicum.mainservice.event.model.Event;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public interface EventCustomRepository {
    Set<Event> getEventsByAdmin(List<Long> users, List<EventState> states, List<Long> categories,
                                LocalDateTime rangeStart, LocalDateTime rangeEnd, Integer from, Integer size);

    Set<Event> getEventsByPublic(String text, List<Long> categories, Boolean paid, LocalDateTime rangeStart,
                                 LocalDateTime rangeEnd, Integer from, Integer size);
}
