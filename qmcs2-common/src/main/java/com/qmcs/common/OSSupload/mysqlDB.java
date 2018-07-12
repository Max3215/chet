package com.qmcs.common.OSSupload;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC 陈超 2016-05-06
 */
public class mysqlDB {

    private static String driver="com.mysql.jdbc.Driver";// 数据库驱动字符串
    private static String url="jdbc:mysql://localhost:3306/qmcs?tinyInt1isBit=false&amp;serverTimezone=UTC&amp;useSSL=false";  //连接URL字符串
    private static String uesr="root";
    private static String passpwd="123456";

    protected Connection conn=null;
    protected Statement stm=null;
    protected ResultSet rs=null;
    protected PreparedStatement prs=null;

    // 获取连接并捕获异常返回连接对象
    public Connection getConnection(){
        try {
            if(conn==null || conn.isClosed()){
                try {
                    Class.forName(driver);
                    conn=DriverManager.getConnection(url,uesr,passpwd);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    /**
     * 关闭数据库连接。
     * @param conn 数据库接
     * @param stmt Statement对象
     * @param rs 结果集
     */
    public void closeAll(Connection conn,Statement stmt,ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(stmt!=null){
            try {
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    //现实增删改的方法
    public int exceuteUpdate(String sql,Object[] prams){
        int resuit=0;
        conn=this.getConnection();
        try {
            prs=conn.prepareStatement(sql);
            if(prams!=null){
                for(int i=0;i<prams.length;i++){
                    prs.setObject(i+1, prams[i]);
                }
            }
            resuit=prs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            this.closeAll(this.conn, prs, rs);
        }
        return resuit;
    }

}
