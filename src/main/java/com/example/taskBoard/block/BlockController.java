package com.example.taskBoard.block;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/blocks")
public class BlockController {

    private final BlockService blockService;

    private final BlockMapper blockMapper;

    public BlockController(BlockService blockService, BlockMapper blockMapper) {
        this.blockService = blockService;
        this.blockMapper = blockMapper;
    }

    @GetMapping
    public ResponseEntity<List<BlockDto>> listBlocks() {
        List<BlockDto> blockDtoList = blockService.findAll().stream().map(blockMapper::toDto).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(blockDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlockDto> getBlock(@PathVariable("id") Integer blockId) {
        Block foundBlock = blockService.findOne(blockId);
        return ResponseEntity.status(HttpStatus.FOUND).body(blockMapper.toDto(foundBlock));
    }

    @PostMapping
    public ResponseEntity<BlockDto> createBlock(@RequestBody BlockDto blockDto) {
        Block savedBlock = blockService.save(blockMapper.fromDto(blockDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(blockMapper.toDto(savedBlock));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BlockDto> updateBlock(
            @PathVariable("id") Integer blockId, @RequestBody BlockDto blockDto
    ) {
        Block updatedBlock = blockService.update(blockId, blockMapper.fromDto(blockDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(blockMapper.toDto(updatedBlock));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBlock(@PathVariable("id") Integer blockId) {
        blockService.delete(blockId);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted block with ID:" + blockId);
    }
}
