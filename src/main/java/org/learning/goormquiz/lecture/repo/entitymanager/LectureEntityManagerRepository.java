package org.learning.goormquiz.lecture.repo.entitymanager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.learning.goormquiz.lecture.repo.entity.LectureEntity;
import org.learning.goormquiz.lecture.repo.entity.Price;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LectureEntityManagerRepository {

    @PersistenceContext
    private EntityManager em;

    public LectureEntity save(LectureEntity lectureEntity) {
        em.persist(lectureEntity);
        return lectureEntity;
    }

    /**
     * Lecture 엔티티 조회 (ID 기준)
     */
    public LectureEntity findById(Long id) {
        return em.find(LectureEntity.class, id);
    }

    /**
     * 모든 Lecture 엔티티 조회
     */
    public List<LectureEntity> findAll() {
        return em.createQuery("SELECT l FROM LectureEntity l", LectureEntity.class)
                .getResultList();
    }

    /**
     * Lecture 엔티티 수정 (dirty checking 사용)
     * 가격 음수 검증 로직 포함
     */
    public LectureEntity update(Long id, LectureEntity updatedLecture) {
        // EntityManager는 트랜잭션 안에서 엔티티를 관리하고 있기 때문에
        // 별도로 merge 없이 dirty checking을 사용
        LectureEntity lectureEntity = em.find(LectureEntity.class, id);

        if (lectureEntity != null) {
            // Dirty checking에 의해 트랜잭션이 끝나면 자동으로 업데이트
            lectureEntity.setImageUrl(updatedLecture.getImageUrl());
            lectureEntity.setInstructor(updatedLecture.getInstructor());
            lectureEntity.setLectureUrl(updatedLecture.getLectureUrl());

            // 가격이 음수일 경우 예외 발생 (Price 값 타입 사용)
            Price price = new Price(updatedLecture.getPrice());
            lectureEntity.setPrice(price.getValue());

            lectureEntity.setLectureInfo(updatedLecture.getLectureInfo());
        }

        return lectureEntity;
    }

    /**
     * Lecture 엔티티 삭제
     */
    public void delete(Long id) {
        LectureEntity lectureEntity = em.find(LectureEntity.class, id);
        if (lectureEntity != null) {
            em.remove(lectureEntity);
        }
    }

}
