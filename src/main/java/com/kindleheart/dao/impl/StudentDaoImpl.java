package com.kindleheart.dao.impl;

import com.kindleheart.dao.StudentDao;
import com.kindleheart.model.Student;
import com.kindleheart.utils.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public int getRowCount() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select count(*) from stuifo";
        Object obj = queryRunner.query(sql, new ScalarHandler<>());
        Long num = (Long)obj;
        return num.intValue();
    }

    @Override
    public List<Student> getStudentsWithPage(int rowStart, int pageSize) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from stuifo limit ?,?";
        return queryRunner.query(sql, new BeanListHandler<>(Student.class), rowStart, pageSize);
    }

}

