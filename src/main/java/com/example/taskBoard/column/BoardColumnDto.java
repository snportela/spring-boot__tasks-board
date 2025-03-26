package com.example.taskBoard.column;

import com.example.taskBoard.board.BoardDto;

public record BoardColumnDto(

        Integer columnId,

        String name,

        BoardColumnType type,

        BoardDto board

) {
}
