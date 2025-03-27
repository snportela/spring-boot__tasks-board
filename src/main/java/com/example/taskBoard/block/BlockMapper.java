package com.example.taskBoard.block;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BlockMapper {

    BlockDto toDto(Block block);

    Block fromDto (BlockDto blockDto);
}
