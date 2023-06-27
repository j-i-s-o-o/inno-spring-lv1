package com.sparta.levelbyone.entity;

import com.sparta.levelbyone.dto.BoardModifiedDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Board {
    private Long id;
    private String username;
    private String password;
    private String title;

    private String contents;
    private String CreatAt;
    private String ModifiedAt;

    public Board(long id, BoardModifiedDto requestDto) {
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

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", CreatAt='" + CreatAt + '\'' +
                ", ModifiedAt='" + ModifiedAt + '\'' +
                '}';
    }
}
