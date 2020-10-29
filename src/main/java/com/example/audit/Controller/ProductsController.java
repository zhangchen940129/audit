package com.example.audit.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.audit.Model.ProductsModel;
import com.example.audit.Model.ProductsModel;
import com.example.audit.Service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProductsController {


        private final ProductsService ProductsService;

        @Autowired
        public ProductsController(com.example.audit.Service.ProductsService ProductsService) {
            this.ProductsService = ProductsService;

        }

        @RequestMapping("/products")
        public String Index() {
            return "this is about products controller";
        }

        @RequestMapping("/products/list")
        public List<ProductsModel> List() {
            return ProductsService.selectAll();
        }

        @ResponseBody
        @RequestMapping(value="/products/add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
        public String AddProducts(@RequestBody JSONArray jsonParam) {



            for (int i = 0; i< jsonParam.size(); i++){
                String jsondata= JSON.toJSONString(jsonParam.get(i));
                ProductsModel fruitModel = JSON.parseObject(jsondata, ProductsModel.class);
//            fm = fm.setJsonToProductsModel(jsondata);
                System.out.println(fruitModel.getProductsName());
                ProductsService.insert(fruitModel);


            }

            return "add ok";
        }
    }