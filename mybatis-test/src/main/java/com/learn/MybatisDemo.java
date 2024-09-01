package com.learn;

import com.learn.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisDemo {
    public static void main(String[] args) throws IOException {
        //加载mybatis核心配置文件
        String resource = "mybatis-config.xml";
        //返回字节输入流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取执行对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行sql
        List<User> users = sqlSession.selectList("test.selectAll");
        System.out.println(users);
    }
}
