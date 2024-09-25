package org.learning.goormquiz.lecture.application;

import org.learning.goormquiz.lecture.repo.entity.LectureEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectureRepository extends JpaRepository<LectureEntity, Long> {
    @EntityGraph(attributePaths = {"myLecture"}) // myLecture를 조인하여 N+1 문제 해결
    List<LectureEntity> findByMyLectureMemberId(Long memberId);
}
