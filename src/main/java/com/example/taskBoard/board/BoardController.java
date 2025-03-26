package com.example.taskBoard.board;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/boards")
public class BoardController {

    private final BoardService boardService;

    private final BoardMapper boardMapper;

    public BoardController(BoardService boardService, BoardMapper boardMapper) {
        this.boardService = boardService;
        this.boardMapper = boardMapper;
    }

    @GetMapping
    public ResponseEntity<List<BoardDto>> listBoards() {
        List<BoardDto> boardDtoList = boardService.findAll().stream().map(boardMapper::toDto).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(boardDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardDto> getBoard(@PathVariable("id") Integer boardId) {
        Board foundBoard = boardService.findOne(boardId);
        return ResponseEntity.status(HttpStatus.FOUND).body(boardMapper.toDto(foundBoard));
    }

    @PostMapping
    public ResponseEntity<BoardDto> createBoard(@RequestBody BoardDto boardDto) {
        Board savedBoard = boardService.save(boardMapper.fromDto(boardDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(boardMapper.toDto(savedBoard));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BoardDto> updateBoard(
            @PathVariable("id") Integer boardId, @RequestBody BoardDto boardDto) {
        Board updatedBoard = boardService.update(boardId, boardMapper.fromDto(boardDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(boardMapper.toDto(updatedBoard));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBoard(@PathVariable("id") Integer boardId) {
        boardService.delete(boardId);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted board with ID: " + boardId);
    }

}
