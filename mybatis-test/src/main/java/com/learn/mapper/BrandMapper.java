package com.learn.mapper;

import com.learn.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    public List<Brand> selectSth();
    public List<Brand> selectApa();
    public List<Brand> selectById(int id);
    //散装参数
    public List<Brand> selectByCondition(@Param("status")int status,@Param("brandName")String brandName,@Param("companyName")String companyName);
    public List<Brand> selectWithCondition(Brand brand);
    public List<Brand> selectWithMap(Map map);
    public List<Brand> selectSingle(Brand brand);
    void add(Brand brand);
    void Update(Brand brand);
    void Delete(int id);
    void DeleteAll(@Param("ids")int[] ids); // Mybatis默认将数组封装为Map集合，使用@Param改变map默认key值的名称
}
