package com.example.taskBoard.card;

import com.example.taskBoard.column.BoardColumnDto;

public record CardDto(
        Integer cardId,

        String title,

        String description,

        BoardColumnDto boardColumn
) {
}
