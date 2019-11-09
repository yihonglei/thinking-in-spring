package com.lanhuigu.transaction.isolation;

import java.sql.*;

/**
 * Connection.TRANSACTION_READ_UNCOMMITTED(未提交读)：
 * 一个事务在没有提交的时候对另外一个事务可见，从而导致事务读取到未提交的数据，
 * 所以也叫脏读，这个隔离级别都是问题，一般实际不用。
 *
 * @author yihonglei
 * @date 2019/1/14 12:21
 */
public class ReadUncommittedTest {

    static {
        try {
            openConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection openConnection() throws ClassNotFoundException, SQLException {
        // 加载数据库驱动
        Class.forName("com.mysql.jdbc.Driver");

        // 创建数据库连接
        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/lanhuigu","root", "123456");

        return connection;
    }

    /**
     * 执行SQL，不提交，并停顿3秒
     *
     * @author yihonglei
     * @date 2019/1/14 17:52
     */
    public static void insert(String accountName, String userName, int money) {
        try {
            // 创建连接，并设置为非自动提交
            Connection connection = openConnection();
            connection.setAutoCommit(false);

            // 预编译SQL
            PreparedStatement ps =
                    connection.prepareStatement("insert INTO account (accountName, userName, money) VALUES (?,?,?)");

            // 设置SQL参数
            ps.setString(1, accountName);
            ps.setString(2, userName);
            ps.setInt(3, money);

            // 执行SQL
            ps.executeUpdate();
            System.out.println("执行插入!");

            // 关闭SQL连接
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 执行查询
     *
     * @author yihonglei
     * @date 2019/1/14 17:57
     */
    public static void select(String userName, Connection conn) {
        try {
            PreparedStatement prepare = conn.
                    prepareStatement("SELECT * from account where userName=?");
            prepare.setString(1, userName);
            ResultSet resultSet = prepare.executeQuery();
            System.out.println("执行查询");
            while (resultSet.next()) {
                for (int i = 1; i <= 4; i++) {
                    System.out.print(resultSet.getString(i) + ",");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // 启动插入线程
        Thread insertT = new Thread(() -> {
            insert("1111", "yihonglei", 10000);
        });
        insertT.start();

        // 启动查询线程
        Thread selectT = new Thread(() -> {
            try {
                Thread.sleep(500);
                Connection connection = openConnection();
                // 将参数升级成 Connection.TRANSACTION_READ_COMMITTED 即可解决脏读的问题
                connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
                select("yihonglei", connection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        selectT.start();

        // 插入线程需要等到查询线程结束后再结束
        try {
            insertT.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
