package com.example.audit.Service;



import com.example.audit.Mapper.FruitMapper;
import com.example.audit.Mapper.HelloMapper;
import com.example.audit.Model.FruitModel;
import com.example.audit.Model.HelloModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitService {

    private final FruitMapper dao;


    @Autowired
    public FruitService(FruitMapper dao) {
        this.dao = dao;
    }

    public boolean insert(FruitModel model) {
        return dao.insert(model) > 0;
    }

    public FruitModel select(int id) {
        return dao.select(id);
    }

    public FruitModel selectFruit(String FruitName) {
        return dao.selectFruit(FruitName);
    }

    public Boolean existFruit(String FruitName) {

       return dao.countFruit(FruitName)> 0;
    }



    public List<FruitModel> selectAll() {
        return dao.selectAll();
    }

    public List<FruitModel> selectAllnum() {
//        System.out.println(dao.selectAllnum());
        return dao.selectAllnum();
    }

    public boolean updateValue(FruitModel model) {
        return dao.updateValue(model) > 0;
    }

    public boolean updateFruitnumber(FruitModel model) {
        return dao.updatFruit(model) > 0;
    }

    public boolean delete(String FruitName) {
        return dao.delete(FruitName) > 0;
    }
    public boolean deltFruit(FruitModel model) {
        return dao.deltFruit(model) > 0;
    }
}