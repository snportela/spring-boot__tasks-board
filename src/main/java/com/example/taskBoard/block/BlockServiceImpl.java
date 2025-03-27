package com.example.taskBoard.block;

import com.example.taskBoard.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockServiceImpl implements BlockService{

    private final BlockRepository blockRepository;

    public BlockServiceImpl(BlockRepository blockRepository) {
        this.blockRepository = blockRepository;
    }

    @Override
    public List<Block> findAll() {
        return blockRepository.findAll();
    }

    @Override
    public Block findOne(Integer blockId) {
        return blockRepository.findById(blockId).orElseThrow(NotFoundException::new);
    }

    @Override
    public Block save(Block block) {
        return blockRepository.save(block);
    }

    @Override
    public Block update(Integer blockId, Block block) {
        Block existingBlock = blockRepository.findById(blockId).orElseThrow(NotFoundException::new);

        existingBlock.setBlockReason(block.getBlockReason());
        existingBlock.setUnblockedAt(block.getUnblockedAt());
        existingBlock.setUnblockReason(block.getUnblockReason());
        existingBlock.setCard(block.getCard());

        return blockRepository.save(existingBlock);
    }

    @Override
    public void delete(Integer blockId) {
        blockRepository.findById(blockId).orElseThrow(NotFoundException::new);
        blockRepository.deleteById(blockId);
    }
}
