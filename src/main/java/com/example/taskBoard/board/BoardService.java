package com.example.taskBoard.board;

import java.util.List;

public interface BoardService {

    Board save(Board board);

    List<Board> findAll();

    Board findOne(Integer boardId);

    Board update(Integer boardId, Board board);

    void delete(Integer boardId);
}
