package com.kindleheart.service;

import com.kindleheart.model.PageBean;
import java.sql.SQLException;

public interface StudentService {
    PageBean getStudentsWithPage(int currentPage, int pageSize) throws SQLException;
}
