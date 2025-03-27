package com.example.taskBoard.column;


import com.example.taskBoard.board.Board;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.EnumType.STRING;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "board_columns")
public class BoardColumn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "column_id", nullable = false)
    private Integer columnId;

    @Column(nullable = false)
    private String name;

    @Column(name = "column_order", nullable = false)
    private Integer order;

    @Enumerated(STRING)
    @Column(nullable = false)
    private BoardColumnType type;

    @ManyToOne
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;
}
