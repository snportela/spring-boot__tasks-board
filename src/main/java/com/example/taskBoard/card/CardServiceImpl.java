package com.example.taskBoard.card;

import com.example.taskBoard.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public List<Card> findAll() {
        return cardRepository.findAll();
    }

    @Override
    public Card findOne(Integer cardId) {
        return cardRepository.findById(cardId).orElseThrow(NotFoundException::new);
    }

    @Override
    public Card save(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public Card update(Integer cardId, Card card) {
        Card existingCard = cardRepository.findById(cardId).orElseThrow(NotFoundException::new);

        existingCard.setTitle(card.getTitle());
        existingCard.setDescription(card.getDescription());
        existingCard.setBoardColumn(card.getBoardColumn());

        return cardRepository.save(existingCard);
    }

    @Override
    public void delete(Integer cardId) {
    cardRepository.findById(cardId).orElseThrow(NotFoundException::new);
    cardRepository.deleteById(cardId);
    }
}
