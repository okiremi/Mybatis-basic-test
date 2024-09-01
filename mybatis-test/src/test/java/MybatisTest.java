import com.learn.mapper.BrandMapper;
import com.learn.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest {
    @Test
    public void SelectTestAll() throws IOException {
        //获取sqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //Mapper接口代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //执行
        List<Brand> brands = brandMapper.selectSth();
        System.out.println(brands);
        //释放
        sqlSession.close();
    }
    @Test
    public void SelectById() throws IOException {
        int id = 1;
        //获取sqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //Mapper接口代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //执行
        List<Brand> brands = brandMapper.selectById(id);
        System.out.println(brands);
        //释放
        sqlSession.close();
    }
    @Test
    public void SelectByCondition() throws IOException {
        int status = 1;
        String companyName = "小米";
        String brandName = "华为";
        //Brand brand = new Brand(status,brandName,companyName);
        //参数处理，模糊查询
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";
        Map map = new HashMap<>();
        //map.put("status",status);
        //map.put("brandName",brandName);
        map.put("companyName",companyName);
        //获取sqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //Mapper接口代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //执行
        List<Brand> brands = brandMapper.selectWithMap(map);
        System.out.println(brands);
        //释放
        sqlSession.close();
    }
    @Test
    public void SelectSingle() throws IOException {
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";
        Brand brand = new Brand();
        //brand.setBrandName(brandName);
        //Brand brand = new Brand(status,brandName,companyName);
        //参数处理，模糊查询
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";
        //Map map = new HashMap<>();
        //map.put("status",status);
        //map.put("brandName",brandName);
        //map.put("companyName",companyName);
        //获取sqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //Mapper接口代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //执行
        List<Brand> brands = brandMapper.selectSingle(brand);
        System.out.println(brands);
        //释放
        sqlSession.close();
    }
    @Test
    public void add() throws IOException {
        int status = 1;
        String companyName = "字节跳动有限公司";
        String brandName = "抖音";
        String description = "抖音，给你不一样的体验";
        int ordered = 200;
        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setOrdered(ordered);
        brand.setDescription(description);
        //参数处理，模糊查询
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";
        //Map map = new HashMap<>();
        //map.put("status",status);
        //map.put("brandName",brandName);
        //map.put("companyName",companyName);
        //获取sqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //Mapper接口代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //执行
        brandMapper.add(brand);
        //提交事务
        sqlSession.commit();
        //释放
        sqlSession.close();
    }
    @Test
    public void Update() throws IOException {
        int status = 1;
        String companyName = "字节跳动有限公司";
        String brandName = "抖音";
        String description = "抖音，百万人的选择";
        int ordered = 200;
        Brand brand = new Brand();
        //brand.setBrandName(brandName);
        //brand.setStatus(status);
        //brand.setCompanyName(companyName);
        //brand.setOrdered(ordered);
        brand.setDescription(description);
        //参数处理，模糊查询
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";
        //获取sqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //Mapper接口代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //执行
        brandMapper.Update(brand);
        //提交事务
        sqlSession.commit();
        //释放
        sqlSession.close();
    }
    @Test
    public void Delete() throws IOException {
        int id = 5;
        //获取sqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //Mapper接口代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //执行
        brandMapper.Delete(id);
        //提交事务
        sqlSession.commit();
        //释放
        sqlSession.close();
    }
    @Test
    public void DeleteAll() throws IOException {
        int[] ids = {4,5,6};
        //获取sqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //Mapper接口代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //执行
        brandMapper.DeleteAll(ids);
        //提交事务
        sqlSession.commit();
        //释放
        sqlSession.close();
    }
}
