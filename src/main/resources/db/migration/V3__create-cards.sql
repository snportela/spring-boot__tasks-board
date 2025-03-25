CREATE TABLE cards(
    card_id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    column_id BIGINT NOT NULL,
    CONSTRAINT boards_columns__cards_fk FOREIGN KEY (column_id) REFERENCES board_columns(column_id) ON DELETE CASCADE
);