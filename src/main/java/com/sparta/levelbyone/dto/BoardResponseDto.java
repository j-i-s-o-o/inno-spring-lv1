package com.sparta.levelbyone.dto;

import com.sparta.levelbyone.entity.Board;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardResponseDto {

    Long id;
    String title;
    String username;
    String date;
    String contents;

    public BoardResponseDto(Board board) {

        this.id = board.getId();
        this.username = board.getUsername();
        this.title = board.getTitle();
        this.contents = board.getContents();
        this.date = board.getCreatAt();
    }
}
