package com.lanhuigu.transaction.isolation;

import java.sql.*;

/**
 * Connection.TRANSACTION_REPEATABLE_READ(可重复读):
 * 可重复读能保证多次读取数据一致，但是解决不了你正在读的时候，卡巴一下中间给来一条数据，
 * 结果读出的数据不对，这个也成为幻读。这个也是MySQL的事务默认隔离级别。
 *
 * @author yihonglei
 * @date 2019/1/14 19:13
 */
public class ReadRepeatableTest {
    static {
        try {
            openConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static Object lock = new Object();

    public static Connection openConnection() throws ClassNotFoundException, SQLException {
        // 加载数据库驱动
        Class.forName("com.mysql.jdbc.Driver");

        // 创建数据库连接
        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/lanhuigu","root", "123456");

        return connection;
    }

    public static void update(String userName) {
        try {
            Connection conn = openConnection();
            PreparedStatement prepare = conn.
                    prepareStatement("UPDATE account SET money= money+1 where userName=?");
            prepare.setString(1, userName);
            prepare.executeUpdate();
            conn.close();
            System.out.println("执行修改成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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

    public static Thread run(Runnable runnable) {
        Thread thread1 = new Thread(runnable);
        thread1.start();
        return thread1;
    }

    public static void main(String[] args) {
        // 执行修改
        Thread updateT = new Thread(() -> {
            try {
                synchronized (lock) {
                    lock.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            update("yihonglei");
        });

        Thread selectT = new Thread(() -> {
            try {
                Connection conn = openConnection();
                conn.setAutoCommit(false);
                conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
                // 第一次读取
                select("yihonglei", conn);
                // 释放锁
                synchronized (lock) {
                    lock.notify();
                }
                // 第二次读取 ,采用了  REPEATABLE 级别，所以两次读取数据一至
                Thread.sleep(500);
                select("yihonglei", conn);
                conn.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        try {
            updateT.join();
            selectT.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
