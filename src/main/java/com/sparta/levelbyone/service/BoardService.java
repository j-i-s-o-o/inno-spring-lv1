package com.sparta.levelbyone.service;


import com.sparta.levelbyone.dto.BoardModifiedDto;
import com.sparta.levelbyone.dto.BoardRequestDeleteDto;
import com.sparta.levelbyone.dto.BoardResponseDeleteDto;
import com.sparta.levelbyone.dto.BoardResponseDto;
import com.sparta.levelbyone.entity.Board;
import com.sparta.levelbyone.repository.BoardRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j(topic = "Board Service")
public class BoardService {

    List<Board> BoardList = new ArrayList<>();
    BoardRepository boardRepository = new BoardRepository();

    Long BoardID = 1L;

    public List<BoardResponseDto> GetListBoard(){
        return boardRepository.GetListBoard()
                .stream().map(BoardResponseDto::new).toList();
    }

    public BoardResponseDto CreateBoard(BoardModifiedDto requestDto){
        log.error("Controller CreateBoard join " + requestDto.toString());

        Board newBoard = new Board(BoardID++, requestDto);
        log.error("Create Board " + newBoard.toString());

        log.error("Save Board");
        newBoard = boardRepository.save(newBoard);

        // 게시글 반환
        log.error("Return Board");
        return new BoardResponseDto(newBoard);
    }

    public BoardResponseDto SelectBoard(long id){
        // 선택한 게시글 조회
        log.error("Controller SelectBoard join");

        // DB에서 검색
        log.error("Repository Search Method");
        Board returnBoard = boardRepository.findById(id);
        log.error("result Data = " + returnBoard.toString());

        // 게시글 반환
        log.error("Return Board");
        return new BoardResponseDto(returnBoard);
    }

    public BoardResponseDto SelectModifiedBoard(long id, BoardModifiedDto requestDto){
        // 선택한 게시글 수정
        log.error("Controller SelectModifiedBoard join");

        // DB에서 검색
        log.error("Search DB for id");
        Board returnBoard = boardRepository.findById(id);
        log.error("result Data = " + returnBoard.toString());

        if (returnBoard.getPassword().equals(requestDto.getPassword()))
        {
            // 수정하는 내용
            if(!requestDto.getTitle().isEmpty())
                returnBoard.updateTitle(requestDto.getTitle());
            if(!requestDto.getContents().isEmpty())
                returnBoard.updateContents(requestDto.getContents());
            returnBoard = boardRepository.update(returnBoard);
        }
        else
            return null;
        // 게시글 반환
        log.error("Return Board");
        return new BoardResponseDto(returnBoard);
    }

    public BoardResponseDeleteDto SelectDeleteBoard(long id, BoardRequestDeleteDto requestDto){
        log.error("Controller SelectDeleteBoard join");

        Board returnBoard = boardRepository.findById(id);
        log.error("result Data = " + returnBoard.toString());

        BoardResponseDeleteDto response;
        if (returnBoard.getPassword().equals(requestDto.getPassword()))
        {
            boardRepository.remove(returnBoard);
            response = new BoardResponseDeleteDto("삭제 됐어!!");
        }
        else
            response = new BoardResponseDeleteDto("삭제 안 됐어");


        // 게시글 반환
        log.error("Return Result");
        return response;
    }
}