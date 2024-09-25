package org.learning.goormquiz.lecture.application.controller;

import org.learning.goormquiz.lecture.application.LectureService;
import org.learning.goormquiz.lecture.repo.entity.LectureEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lectures")
public class LectureController {

    private final LectureService lectureService;

    public LectureController(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    @GetMapping("/member/{memberId}")
    public List<LectureEntity> getLecturesByMemberId(@PathVariable Long memberId) {
        return lectureService.findLecturesByMemberId(memberId);
    }
}