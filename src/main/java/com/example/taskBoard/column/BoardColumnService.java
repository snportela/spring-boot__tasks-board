package com.example.taskBoard.column;

import java.util.List;

public interface BoardColumnService {

    List<BoardColumn> findAll();

    BoardColumn findOne(Integer columnId);

    BoardColumn save(BoardColumn boardColumn);

    BoardColumn update(Integer columnId, BoardColumn boardColumn);

    void delete(Integer columnId);
}
