package com.learn;

import com.learn.mapper.UserMapper;
import com.learn.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisDemo2 {
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
        //List<User> users = sqlSession.selectList("test.selectAll");
        //获取Mapper接口代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectAll();
        System.out.println(users);
        //释放资源
        sqlSession.close();
    }
}
