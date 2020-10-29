package com.example.audit.Mapper;



import com.example.audit.Model.FruitModel;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface FruitMapper {

    // 插入 并查询id 赋给传入的对象
    @Insert("INSERT INTO Fruit(FruitName, Price, number) VALUES(#{FruitName}, #{Price}, #{number})")
//    @SelectKey(statement = "SELECT name FROM sqlite_master WHERE (name = 'Fruit')", before = false, keyProperty = "id", resultType = int.class)
    int insert(FruitModel model);

    // 根据 ID 查询
    @Select("SELECT * FROM Fruit WHERE id=#{id}")
    FruitModel select(int id);

    // 根据 FruitName 查询
    @Select("SELECT * FROM Fruit WHERE FruitName=#{FruitName}")
    FruitModel selectFruit(String FruitName);

    // 查询全部
    @Select("SELECT * FROM Fruit")
    List<FruitModel> selectAll();

    // 更新 value
    @Update("UPDATE Fruit SET value=#{value} WHERE id=#{id}")
    int updateValue(FruitModel model);

    // 更新 value
    @Update("UPDATE Fruit SET number=number + #{number} WHERE FruitName=#{FruitName}")
    int updatFruit(FruitModel model);

    // 根据 ID 删除
    @Delete("DELETE FROM Fruit WHERE FruitName=#{FruitName}")
    int delete(String FruitName);


    // 根据 FruitName 查询
    @Select("SELECT count(*) FROM Fruit WHERE FruitName=#{FruitName}")
    int countFruit(String FruitName);


    // 更新 value
    @Update("UPDATE Fruit SET number=number - #{number} WHERE FruitName=#{FruitName}")
    int deltFruit(FruitModel model);


    // 查询全部num<4
    @Select("SELECT * FROM Fruit where number<5")
    List<FruitModel> selectAllnum();
}