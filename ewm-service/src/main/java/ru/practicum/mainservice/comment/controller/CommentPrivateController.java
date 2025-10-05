package ru.practicum.mainservice.comment.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.practicum.mainservice.MainCommonUtils;
import ru.practicum.mainservice.comment.dto.CommentDto;
import ru.practicum.mainservice.comment.dto.NewCommentDto;
import ru.practicum.mainservice.comment.service.CommentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users/{userId}/comments")
@Validated
public class CommentPrivateController {
    private final CommentService commentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentDto createByPrivate(@PathVariable Long userId,
                                      @RequestParam Long eventId,
                                      @Valid @RequestBody NewCommentDto newCommentDto) {
        return commentService.createByPrivate(userId, eventId, newCommentDto);
    }

    @PatchMapping("/{commentId}")
    @ResponseStatus(HttpStatus.OK)
    public CommentDto patchByPrivate(@PathVariable Long userId,
                                     @PathVariable Long commentId,
                                     @Valid @RequestBody NewCommentDto newCommentDto) {
        return commentService.patchByPrivate(userId, commentId, newCommentDto);
    }

    @DeleteMapping("/{commentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByPrivate(@PathVariable Long userId,
                                @PathVariable Long commentId) {
        commentService.deleteByPrivate(userId, commentId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CommentDto> getCommentsByPrivate(
            @PathVariable Long userId,
            @RequestParam(required = false) Long eventId,
            @RequestParam(defaultValue = MainCommonUtils.PAGE_DEFAULT_FROM) @PositiveOrZero Integer from,
            @RequestParam(defaultValue = MainCommonUtils.PAGE_DEFAULT_SIZE) @Positive Integer size) {
        return commentService.getCommentsByPrivate(userId, eventId, PageRequest.of(from / size, size));
    }
}
