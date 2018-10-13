package com.kindleheart.utils;

import java.sql.*;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import javax.sql.DataSource;

public class JDBCUtil {

    private static ComboPooledDataSource dataSource = null;
    static{
        dataSource = new ComboPooledDataSource();
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    public static Connection getConn() throws SQLException{
        return dataSource.getConnection();
    }

    //关闭操作
    public static void release(Connection conn , Statement st , ResultSet rs) {
        closeResultSet(rs);
        closeStatement(st);
        closeConn(conn);
    }

    private static void closeConn(Connection conn) {
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void closeStatement(Statement st) {
        if(st!=null){
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void closeResultSet(ResultSet rs) {
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}