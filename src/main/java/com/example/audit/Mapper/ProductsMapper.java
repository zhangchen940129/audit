package com.example.audit.Mapper;



import com.example.audit.Model.ProductsModel;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ProductsMapper {

    // 插入 并查询id 赋给传入的对象
    @Insert("INSERT INTO Products(ProductsName, Price, time) VALUES(#{ProductsName}, #{Price}, #{time})")
//    @SelectKey(statement = "SELECT name FROM sqlite_master WHERE (name = 'Products')", before = false, keyProperty = "id", resultType = int.class)
    int insert(ProductsModel model);

    // 根据 ID 查询
    @Select("SELECT * FROM Products WHERE id=#{id}")
    ProductsModel select(int id);



    // 查询全部
    @Select("SELECT * FROM Products")
    List<ProductsModel> selectAll();

    // 更新 value
    @Update("UPDATE Products SET value=#{value} WHERE id=#{id}")
    int updateValue(ProductsModel model);

    // 根据 ID 删除
    @Delete("DELETE FROM Products WHERE id=#{id}")
    int delete(Integer id);

}