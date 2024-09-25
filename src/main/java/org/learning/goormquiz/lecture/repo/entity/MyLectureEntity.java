package org.learning.goormquiz.lecture.repo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.learning.goormquiz.member.repo.entity.MemberEntity;


@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "my_lecture")
public class MyLectureEntity {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_TEAM_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private MemberEntity member;

    @ManyToOne
    @JoinColumn(name = "LECTURE_ID")
    private LectureEntity lecture;
}
