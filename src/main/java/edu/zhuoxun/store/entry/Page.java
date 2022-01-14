package edu.zhuoxun.store.entry;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by Jash
 */
@Data
@NoArgsConstructor
public class Page<T> {
    private String cid;
    private String keyword;
    private int currentPage;
    private int totalPage;
    private int total;
    private List<T> list;
}
