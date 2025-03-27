package com.example.taskBoard.block;

import com.example.taskBoard.card.CardDto;

import java.time.LocalDateTime;

public record BlockDto(

        Integer blockId,

        LocalDateTime blockedAt,

        String blockReason,

        LocalDateTime unblockedAt,

        String unblockReason,

        CardDto card


) {
}
