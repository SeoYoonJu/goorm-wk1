package org.learning.goormquiz.lecture.repo.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class Price {
    private Integer value;

    public Price() {}

    // 값이 음수일 때 예외를 던지는 생성자
    public Price(Integer value) {
        if (value < 0) {
            throw new IllegalArgumentException("음수가 올 수 없습니다.");
        }
        this.value = value;
    }

}
