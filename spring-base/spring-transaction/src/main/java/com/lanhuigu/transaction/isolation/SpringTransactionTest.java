package com.lanhuigu.transaction.isolation;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * spring 编程示事物示例
 *
 * @author yihonglei
 * @date 2019/1/14 20:07
 */
public class SpringTransactionTest {

    private static String url = "jdbc:mysql://localhost:3306/lanhuigu";
    private static String user = "root";
    private static String password = "123456";

    public static Connection openConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lanhuigu", "root", "123456");
        return conn;
    }

    /**
     * 1）在一个事务内，一个失败，全部失败回滚。
     * 2）如果设置了保存点，可以选择回滚到保存点。
     *
     * @author yihonglei
     * @date 2019/1/14 20:42
     */
    public static void main(String[] args) {
        final DataSource ds = new DriverManagerDataSource(url, user, password);

        final TransactionTemplate template = new TransactionTemplate();

        template.setTransactionManager(new DataSourceTransactionManager(ds));

        template.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus status) {
                Connection conn = DataSourceUtils.getConnection(ds);
                Object savePoint = null;
                try {
                    {
                        // 插入
                        PreparedStatement prepare = conn.
                                prepareStatement("insert INTO account (accountName,userName,money) VALUES (?,?,?)");
                        prepare.setString(1, "111");
                        prepare.setString(2, "aaa");
                        prepare.setInt(3, 10000);
                        prepare.executeUpdate();
                    }
                    // 设置保存点，如果设置了保存点，我们可以根据保存点进行回滚
//                     savePoint = status.createSavepoint();
                    {
                        // 插入
                        PreparedStatement prepare = conn.
                                prepareStatement("insert INTO account (accountName,userName,money) VALUES (?,?,?)");
                        prepare.setString(1, "222");
                        prepare.setString(2, "bbb");
                        prepare.setInt(3, 10000);
                        prepare.executeUpdate();
                    }
                    {
                        // 更新
                        PreparedStatement prepare = conn.
                                prepareStatement("UPDATE account SET money= money+1 where userName=?");
                        prepare.setString(1, "ccc");

                        // 模拟报错
                        int i = 1 / 0;

                    }
                } catch (Exception e) {
                    System.out.println("更新失败");
                    if (savePoint != null) { // 回滚到保存点
                        status.rollbackToSavepoint(savePoint);
                    } else {
                        // 事务回滚
                        status.setRollbackOnly();
                    }
                }
                return null;
            }
        });
    }

}
