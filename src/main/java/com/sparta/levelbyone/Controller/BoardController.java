package com.sparta.levelbyone.Controller;

import com.sparta.levelbyone.dto.BoardModifiedDto;
import com.sparta.levelbyone.dto.BoardResponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/board")
public class BoardController {
    @GetMapping("/{id}")
    public BoardResponseDto SelectBoard(@PathVariable long id){
        // 선택한 게시글 조회
        return null;
    }

    @PutMapping("/{id}")
    public BoardResponseDto SelectModifiedBoard(@PathVariable long id,
                                                @RequestBody BoardModifiedDto requestDto){
        // 선택한 게시글 수정
        return null;
    }

    @DeleteMapping("{/id}")
    public String SelectDeleteBoard(@PathVariable long id) {
        // 선택한 게시글 삭제
        return null;
    }
}
