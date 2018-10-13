package com.kindleheart.dao;

import com.kindleheart.model.Student;
import java.sql.SQLException;
import java.util.List;

public interface StudentDao {
    int getRowCount() throws SQLException;

    List<Student> getStudentsWithPage(int rowStart, int pageSize) throws SQLException;
}
