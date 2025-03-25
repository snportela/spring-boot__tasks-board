CREATE TABLE blocks(
    block_id SERIAL PRIMARY KEY,
    blocked_at TIMESTAMP DEFAULT now(),
    block_reason VARCHAR(255) NOT NULL,
    unblocked_at TIMESTAMP NULL,
    unblock_reason VARCHAR(255) NULL,
    card_id BIGINT NOT NULL,
    CONSTRAINT cards__blocks_fk FOREIGN KEY (card_id) REFERENCES cards(card_id) ON DELETE CASCADE
)