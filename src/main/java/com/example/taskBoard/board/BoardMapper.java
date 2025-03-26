package com.example.taskBoard.board;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BoardMapper {

    BoardDto toDto(Board board);

    Board fromDto(BoardDto boardDto);
}