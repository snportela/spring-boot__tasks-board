package com.example.taskBoard.column;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BoardColumnMapper {

    BoardColumnDto toDto(BoardColumn boardColumn);

    BoardColumn fromDto(BoardColumnDto boardColumnDto);
}
