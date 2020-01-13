package com.jpeony.transaction.isolation;

import java.sql.*;

/**
 * Connection.TRANSACTION_READ_COMMITTED(已提交读)：
 * 一个事务在没有提交前对另外一个事务是不可见的，会导致事务提交前后读取的数据不一样，
 * 两次查询结果不一样，哪这样的数据去处理业务，一般就是完蛋了，所以也叫做不可重复读，
 * 这是一个警告语。这个也是一般数据库的默认级别，但是不是MySQL的默认级别。
 *
 * @author yihonglei
 */
public class ReadcommittedTest {
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
                DriverManager.getConnection("jdbc:mysql://localhost:3306/jpeony", "root", "123456");

        return connection;
    }

    public static void insert(String accountName, String userName, int money) {
        try {
            Connection conn = openConnection();
            PreparedStatement prepare = conn.
                    prepareStatement("insert INTO account (accountName, userName, money) VALUES (?,?,?)");
            prepare.setString(1, accountName);
            prepare.setString(2, userName);
            prepare.setInt(3, money);
            prepare.executeUpdate();
            System.out.println("执行插入成功");
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void select(String userName, Connection conn) {
        try {
            PreparedStatement prepare = conn.
                    prepareStatement("SELECT * from account where userName =?");
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
        Thread insertT = new Thread(() -> {
            try {
                synchronized (lock) {
                    lock.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            insert("1111", "yihonglei", 10000);
        });
        insertT.start();

        Thread selectT = new Thread(() -> {
            try {
                Connection conn = openConnection();
                conn.setAutoCommit(false);
                // 将参数升级成 Connection.TRANSACTION_REPEATABLE_READ 即可解决不可重复读问题
//                    conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
                // 第一次读取不到
                select("yihonglei", conn);
                // 释放锁
                synchronized (lock) {
                    lock.notify();
                }
                // 第二次读取到(数据不一至)
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
        selectT.start();

        try {
            insertT.join();
            selectT.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
