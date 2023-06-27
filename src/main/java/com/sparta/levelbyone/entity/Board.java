package com.sparta.levelbyone.entity;

import com.sparta.levelbyone.dto.BoardModifiedDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // index 자동 증가
    private Long id;
    private String username;
    private String password;
    private String title;
    private String contents;

    @CreatedDate
    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime ModifiedAt;

    public Board(BoardModifiedDto requestDto) {
        this.id = id;
        this.username = requestDto.getUsername();
        this.password = requestDto.getPassword();
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }

    public void updateTitle(String title) {
        this.title = title;
    }

    public void updateContents(String contents) {
        this.contents = contents;
    }

}
