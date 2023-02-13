package com.edu.db.model.board;

import java.util.List;
import com.edu.db.domain.Board;

public interface BoardService {
    //C
    public void insert(Board board);

    //R
    public List selectAll();
    public Board select(int board_idx);

    //U
    public void update(Board board);

    //D
    public void delete(int board_idx);
}