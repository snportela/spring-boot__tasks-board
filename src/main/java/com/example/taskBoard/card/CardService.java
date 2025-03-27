package com.example.taskBoard.card;

import java.util.List;

public interface CardService {

    List<Card> findAll();

    Card findOne(Integer cardId);

    Card save(Card card);

    Card update(Integer cardId, Card card);

    void delete(Integer cardId);

}
