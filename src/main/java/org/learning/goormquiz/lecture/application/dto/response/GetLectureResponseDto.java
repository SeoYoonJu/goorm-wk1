package org.learning.goormquiz.lecture.application.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Builder;
import org.learning.goormquiz.lecture.repo.entity.LectureEntity;

@Builder
public record GetLectureResponseDto(
    Long lectureId,
    String title,
    @JsonProperty(value = "image_url") String imageUrl,
    String instructor,
    int price,
    @JsonProperty(value = "lecture_url") String lectureUrl,
    List<String> goals,
    List<String> target) {

    public static GetLectureResponseDto fromEntity(LectureEntity lecture) {
        return new GetLectureResponseDto(
                lecture.getLectureId(),
                lecture.getTitle(),
                lecture.getImageUrl(),
                lecture.getInstructor(),
                lecture.getPrice(),
                lecture.getLectureUrl(),
                lecture.getGoals(),
                lecture.getTarget()
        );
    }
//        return GetLectureResponseDto.builder()
//            .lectureId(lecture.getLectureId())
//            .title(lecture.getTitle())
//            .imageUrl(lecture.getImageUrl())
//            .instructor(lecture.getInstructor())
//            .price(lecture.getPrice())
//            .lectureUrl(lecture.getLectureUrl())
//            .goals(lecture.getGoals())
//            .target(lecture.getTarget())
//            .build();
//    }
}
