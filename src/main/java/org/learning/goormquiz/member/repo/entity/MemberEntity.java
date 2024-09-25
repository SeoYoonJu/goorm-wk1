package org.learning.goormquiz.member.repo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.learning.goormquiz.lecture.repo.entity.MyLectureEntity;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "member")
public class MemberEntity {

    @Id
    @GeneratedValue
    private Long memberId;
    private String name;
    private String email;
    private String password;
    private String role;
    @OneToMany(mappedBy = "member")
    private List<MyLectureEntity> myLecture = new ArrayList<>();
}

