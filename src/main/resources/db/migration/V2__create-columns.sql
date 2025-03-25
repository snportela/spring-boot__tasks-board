CREATE TABLE board_columns(
    column_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    "order" int NOT NULL,
    type VARCHAR(7) NOT NULL,
    board_id BIGINT NOT NULL,
    CONSTRAINT boards__board_columns_fk FOREIGN KEY (board_id) REFERENCES boards(board_id) ON DELETE CASCADE,
    CONSTRAINT id_order_uk UNIQUE (board_id)
)