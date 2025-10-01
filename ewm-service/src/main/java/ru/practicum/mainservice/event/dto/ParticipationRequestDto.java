package ru.practicum.mainservice.event.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.practicum.mainservice.MainCommonUtils;
import ru.practicum.mainservice.event.dto.enums.RequestStatus;

import java.time.LocalDateTime;
import java.util.Objects;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParticipationRequestDto {

    Long id;

    Long event;

    Long requester;

    @JsonFormat(pattern = MainCommonUtils.DT_FORMAT, shape = JsonFormat.Shape.STRING)
    LocalDateTime created;

    RequestStatus status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParticipationRequestDto that = (ParticipationRequestDto) o;
        return Objects.equals(id, that.id) && Objects.equals(event, that.event) &&
                Objects.equals(requester, that.requester) && Objects.equals(created, that.created) &&
                status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, event, requester, created, status);
    }
}
