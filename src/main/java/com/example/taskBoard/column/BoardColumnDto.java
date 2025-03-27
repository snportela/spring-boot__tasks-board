package com.example.taskBoard.column;

import com.example.taskBoard.board.BoardDto;

public record BoardColumnDto(

        Integer columnId,

        String name,

        Integer order,

        BoardColumnType type,

        BoardDto board

) {
}
