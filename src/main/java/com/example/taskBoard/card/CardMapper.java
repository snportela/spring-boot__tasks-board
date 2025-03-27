package com.example.taskBoard.card;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CardMapper {

    CardDto toDto(Card card);

    Card fromDto(CardDto cardDto);
}
