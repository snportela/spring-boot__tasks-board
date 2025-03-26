package com.example.taskBoard.column;

import com.example.taskBoard.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardColumnServiceImpl implements BoardColumnService {

    private final BoardColumnRepository boardColumnRepository;

    public BoardColumnServiceImpl(BoardColumnRepository boardColumnRepository) {
        this.boardColumnRepository = boardColumnRepository;
    }

    @Override
    public List<BoardColumn> findAll() {
        return boardColumnRepository.findAll();
    }

    @Override
    public BoardColumn findOne(Integer columnId) {
        return boardColumnRepository.findById(columnId).orElseThrow(NotFoundException::new);
    }


    @Override
    public BoardColumn save(BoardColumn boardColumn) {
        return boardColumnRepository.save(boardColumn);
    }

    @Override
    public BoardColumn update(Integer columnId, BoardColumn boardColumn) {
        BoardColumn existingBoardColumn = boardColumnRepository.findById(columnId).orElseThrow(NotFoundException::new);

        existingBoardColumn.setName(boardColumn.getName());
        existingBoardColumn.setType(boardColumn.getType());
        existingBoardColumn.setBoard(boardColumn.getBoard());

        return boardColumnRepository.save(existingBoardColumn);
    }

    @Override
    public void delete(Integer columnId) {
        boardColumnRepository.findById(columnId).orElseThrow(NotFoundException::new);
        boardColumnRepository.deleteById(columnId);
    }
}
