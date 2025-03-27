package com.example.taskBoard.block;

import com.example.taskBoard.card.Card;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "blocks")
public class Block {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "block_id", nullable = false)
    private Integer blockId;

    @CreationTimestamp
    @Column(name = "blocked_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime blockedAt;

    @Column(name = "block_reason", nullable = false)
    private String blockReason;

    @Column(name = "unblocked_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime unblockedAt;

    @Column(name = "unblock_reason")
    private String unblockReason;

    @ManyToOne
    @JoinColumn(name = "card_id", nullable = false)
    private Card card;
}
