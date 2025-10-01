package ru.practicum.statsserver.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.practicum.statscommon.StatsCommonUtils;
import ru.practicum.statscommon.model.EndpointHit;
import ru.practicum.statscommon.model.ViewStats;
import ru.practicum.statsserver.service.StatsService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class StatsController {
    private final StatsService statsService;

    @PostMapping(StatsCommonUtils.HIT_ENDPOINT)
    @ResponseStatus(HttpStatus.CREATED)
    public void addHit(@Valid @RequestBody EndpointHit endpointHit) {
        statsService.addHit(endpointHit);
    }

    @GetMapping(StatsCommonUtils.STATS_ENDPOINT)
    public List<ViewStats> getStats(@RequestParam @DateTimeFormat(pattern = StatsCommonUtils.DT_FORMAT) LocalDateTime start,
                                    @RequestParam @DateTimeFormat(pattern = StatsCommonUtils.DT_FORMAT) LocalDateTime end,
                                    @RequestParam(required = false) List<String> uris,
                                    @RequestParam(required = false, defaultValue = "false") Boolean unique) {
        if (start.isAfter(end)) {
            throw new IllegalArgumentException("Invalid time interval.");
        }
        return statsService.getStats(start, end, uris, unique);
    }
}
