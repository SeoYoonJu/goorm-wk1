package org.learning.goormquiz.lecture.application;

import lombok.RequiredArgsConstructor;
import org.learning.goormquiz.common.domain.dto.CommonSuccessDto;
import org.learning.goormquiz.lecture.application.dto.request.CreateLectureRequestDto;
import org.learning.goormquiz.lecture.application.dto.request.UpdateLectureTitleRequestDto;
import org.learning.goormquiz.lecture.application.dto.response.GetLectureResponseDto;
import org.learning.goormquiz.lecture.repo.entity.LectureEntity;
import org.learning.goormquiz.lecture.repo.entity.LectureInfoEntity;
import org.learning.goormquiz.lecture.repo.entity.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LectureService {

    private final LectureRepository lectureRepository;

    public GetLectureResponseDto findLecture(Long lectureId) {

        Optional<LectureEntity> lecture = lectureRepository.findById(lectureId);
        LectureEntity lectureEntity = lecture.orElseThrow(() -> new RuntimeException("강의를 찾을 수 없습니다."));

        // LectureEntity를 GetLectureResponseDto로 변환
        return GetLectureResponseDto.fromEntity(lectureEntity);
    }

    @Transactional
    public CommonSuccessDto createLecture(CreateLectureRequestDto dto) {

        LectureInfoEntity lectureInfo = new LectureInfoEntity();
        lectureInfo.setTitle(dto.title());
        lectureInfo.setGoals(String.join("|", dto.goals())); // List<String>를 "|"로 구분된 String으로 변환
        lectureInfo.setTarget(String.join("|", dto.target())); // List<String>를 "|"로 구분된 String으로 변환

        // LectureEntity 생성
        LectureEntity lecture = new LectureEntity();
        lecture.setImageUrl(dto.imageUrl());
        lecture.setInstructor(dto.instructor());
        lecture.setPrice(dto.price());
        lecture.setLectureUrl(dto.lectureUrl());
        lecture.setLectureInfo(lectureInfo);

        // LectureEntity 저장
        lectureRepository.save(lecture);

        // 성공 응답 반환
        return new CommonSuccessDto(true);

    }

    @Transactional
    public CommonSuccessDto updateLecture(Long lectureId, UpdateLectureTitleRequestDto dto) {
        LectureEntity lecture = lectureRepository.findById(lectureId)
                .orElseThrow(() -> new RuntimeException(""));

        lecture.getLectureInfo().setTitle(dto.title());
        return new CommonSuccessDto(true);
    }

    @Transactional
    public CommonSuccessDto deleteLecture(Long lectureId) {
        LectureEntity lecture = lectureRepository.findById(lectureId)
                .orElseThrow(() -> new RuntimeException(""));

        lectureRepository.delete(lecture);
        return new CommonSuccessDto(true);
    }

    public List<LectureEntity> findLecturesByMemberId(Long memberId) {
        return lectureRepository.findByMyLectureMemberId(memberId);
    }
}
