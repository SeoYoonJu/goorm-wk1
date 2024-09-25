package org.learning.goormquiz.lecture.repo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;
import org.learning.goormquiz.lecture.repo.converter.StringListConverter;

@Getter
@Setter
public class LectureInfoEntity {

    private String title;
    @Lob
    @Convert(converter = StringListConverter.class)
    @Column(columnDefinition = "TEXT")
    private String goals;
    @Lob
    @Convert(converter = StringListConverter.class)
    @Column(columnDefinition = "TEXT")
    private String target;

    public LectureInfoEntity() {}
}
