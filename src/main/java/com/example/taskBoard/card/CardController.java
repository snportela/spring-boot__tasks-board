package com.example.taskBoard.card;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    private final CardService cardService;

    private final CardMapper cardMapper;

    public CardController(CardService cardService, CardMapper cardMapper) {
        this.cardService = cardService;
        this.cardMapper = cardMapper;
    }

    @GetMapping
    public ResponseEntity<List<CardDto>> listCards() {
        List<CardDto> cardDtoList = cardService.findAll().stream().map(cardMapper::toDto).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(cardDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardDto> getCard(@PathVariable("id") Integer cardId) {
        Card foundCard = cardService.findOne(cardId);
        return ResponseEntity.status(HttpStatus.FOUND).body(cardMapper.toDto(foundCard));
    }

    @PostMapping
    public ResponseEntity<CardDto> createCard(@RequestBody CardDto cardDto) {
        Card savedCard = cardService.save(cardMapper.fromDto(cardDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(cardMapper.toDto(savedCard));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CardDto> updateCard(@PathVariable("id") Integer cardId, @RequestBody CardDto cardDto) {
        Card updatedCard = cardService.update(cardId, cardMapper.fromDto(cardDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(cardMapper.toDto(updatedCard));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCard(@PathVariable("id") Integer cardId) {
        cardService.delete(cardId);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted card with ID: " + cardId);
    }

}
