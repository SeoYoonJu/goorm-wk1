package org.learning.goormquiz.lecture.repo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@Entity
public class LectureEntity {

    @Id
    @GeneratedValue
    private Long lectureId;
    private String imageUrl;
    private String instructor;
    private Integer price;
    private String lectureUrl;

    @Embedded
    private LectureInfoEntity lectureInfo;

    @OneToMany(mappedBy = "lecture")
    private List<MyLectureEntity> myLecture = new ArrayList<>();

//    public String getTitle() {
//        return this.lectureInfo.getTitle();  // LectureInfoEntity에서 가져오기
//    }
//    public List<String> getGoals() {
//        return Arrays.asList(this.lectureInfo.getGoals().split("\\|"));  // "goals"를 리스트로 변환
//    }
//    public List<String> getTarget() {
//        return Arrays.asList(this.lectureInfo.getTarget().split("\\|")); // "target"을 리스트로 변환
//    }
//
//    public void setTitle(String title) {
//        this.lectureInfo.setTitle(title);  // LectureInfoEntity의 제목 설정
//    }
//
//    public void setGoals(List<String> goals) {
//        String goalsString = String.join("|", goals);  // 리스트를 "goals" 문자열로 변환
//        this.lectureInfo.setGoals(goalsString);  // LectureInfoEntity의 goals 설정
//    }
//
//    public void setTarget(List<String> target) {
//        String targetString = String.join("|", target);  // 리스트를 "target" 문자열로 변환
//        this.lectureInfo.setTarget(targetString);  // LectureInfoEntity의 target 설정
//    }
}
