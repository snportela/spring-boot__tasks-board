package com.example.taskBoard.column;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/columns")
public class BoardColumnController {

    private final BoardColumnService boardColumnService;

    private final BoardColumnMapper boardColumnMapper;

    public BoardColumnController(BoardColumnService boardColumnService, BoardColumnMapper boardColumnMapper) {
        this.boardColumnService = boardColumnService;
        this.boardColumnMapper = boardColumnMapper;
    }

    @GetMapping
    public ResponseEntity<List<BoardColumnDto>> listBoardColumns() {
        List<BoardColumnDto> boardColumnDtoList = boardColumnService.findAll().stream().map(boardColumnMapper::toDto).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(boardColumnDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardColumnDto> getBoardColumn(@PathVariable("id") Integer columnId) {
        BoardColumn foundColumn = boardColumnService.findOne(columnId);
        return ResponseEntity.status(HttpStatus.FOUND).body(boardColumnMapper.toDto(foundColumn));
    }

    @PostMapping
    public ResponseEntity<BoardColumnDto> createColumn(@RequestBody BoardColumnDto boardColumnDto) {
        BoardColumn savedColumn = boardColumnService.save(boardColumnMapper.fromDto(boardColumnDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(boardColumnMapper.toDto(savedColumn));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BoardColumnDto> updateColumn(
            @PathVariable("id") Integer columnId, @RequestBody BoardColumnDto boardColumnDto
    ) {
        BoardColumn updatedColumn = boardColumnService.update(columnId, boardColumnMapper.fromDto(boardColumnDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(boardColumnMapper.toDto(updatedColumn));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteColumn(@PathVariable("id") Integer columnId) {
        boardColumnService.delete(columnId);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted column with ID: " + columnId);
    }
}
