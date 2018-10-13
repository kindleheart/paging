package com.kindleheart.service.impl;


import com.kindleheart.dao.StudentDao;
import com.kindleheart.dao.impl.StudentDaoImpl;
import com.kindleheart.model.PageBean;
import com.kindleheart.model.Student;
import com.kindleheart.service.StudentService;

import java.sql.SQLException;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao = new StudentDaoImpl();
    @Override
    public PageBean getStudentsWithPage(int currentPage, int pageSize) throws SQLException {
        //得到总记录数
        int rowCount = studentDao.getRowCount();
        //创建pageBean对象，并传入值
        PageBean pageBean = new PageBean(currentPage, rowCount, pageSize);
        //把查到的学生信息传入到pageBean中
        List<Student> list = studentDao.getStudentsWithPage(pageBean.getRowStart(), pageSize);
        pageBean.setPageList(list);
        return pageBean;
    }
}
