package com.example.taskBoard.board;

import com.example.taskBoard.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;

    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public Board save(Board board) {
        return boardRepository.save(board);
    }

    @Override
    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    @Override
    public Board findOne(Integer boardId) {
        return boardRepository.findById(boardId).orElseThrow(NotFoundException::new);
    }

    @Override
    public Board update(Integer boardId, Board board) {
        Board existingBoard = boardRepository.findById(boardId).orElseThrow(NotFoundException::new);

        existingBoard.setName(board.getName());

        return boardRepository.save(existingBoard);
    }

    @Override
    public void delete(Integer boardId) {
        boardRepository.findById(boardId).orElseThrow(NotFoundException::new);
        boardRepository.deleteById(boardId);

    }
}
