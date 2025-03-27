package com.example.taskBoard.block;

import java.util.List;

public interface BlockService {

    List<Block> findAll();

    Block findOne(Integer blockId);

    Block save(Block block);

    Block update(Integer blockId, Block block);

    void delete(Integer blockId);
}
