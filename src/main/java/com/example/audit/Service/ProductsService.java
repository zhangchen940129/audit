package com.example.audit.Service;



import com.example.audit.Mapper.ProductsMapper;
import com.example.audit.Model.ProductsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {

    private final ProductsMapper dao;

    @Autowired
    public ProductsService(ProductsMapper dao) {
        this.dao = dao;
    }

    public boolean insert(ProductsModel model) {
        return dao.insert(model) > 0;
    }

    public ProductsModel select(int id) {
        return dao.select(id);
    }

    public List<ProductsModel> selectAll() {
        return dao.selectAll();
    }

    public boolean updateValue(ProductsModel model) {
        return dao.updateValue(model) > 0;
    }

    public boolean delete(Integer id) {
        return dao.delete(id) > 0;
    }
}