package com.example.audit.Controller;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.audit.Model.FruitModel;
import com.example.audit.Service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;



@RestController
public class FruitController {
    private final FruitService FruitService;

    @Autowired
    public FruitController(com.example.audit.Service.FruitService FruitService) {
        this.FruitService = FruitService;

    }

    @RequestMapping("/fruit")
    public String Index() {
        return "this is about fruit controller";
    }

    @RequestMapping("/fruit/list")
    public List<FruitModel> List() {
        return FruitService.selectAll();
    }

    @ResponseBody
    @RequestMapping(value="/fruit/add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String AddFruit(@RequestBody JSONArray jsonParam) {



        for (int i = 0; i< jsonParam.size(); i++){
            String jsondata= JSON.toJSONString(jsonParam.get(i));
            FruitModel fruitModel = JSON.parseObject(jsondata, FruitModel.class);
//            fm = fm.setJsonToFruitModel(jsondata);
            System.out.println(fruitModel.getFruitName());
            if (FruitService.existFruit(fruitModel.getFruitName())){
                FruitService.updateFruitnumber(fruitModel);
            }else {
                FruitService.insert(fruitModel);

            }
        }

        return "add ok";
    }


    @RequestMapping(value = "/fruit/find", method = RequestMethod.GET)
    public FruitModel findFruit(@RequestParam String FruitName) {

        FruitModel refruitModel =FruitService.selectFruit(FruitName);
        System.out.println(refruitModel);

        return refruitModel;
    }

    @ResponseBody
    @RequestMapping(value="/fruit/del", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String DelFruit(@RequestBody JSONArray jsonParam) {



        for (int i = 0; i< jsonParam.size(); i++){
            String jsondata= JSON.toJSONString(jsonParam.get(i));
            FruitModel fruitModel = JSON.parseObject(jsondata, FruitModel.class);
//            fm = fm.setJsonToFruitModel(jsondata);
            System.out.println(fruitModel.getFruitName());
            if (FruitService.existFruit(fruitModel.getFruitName())){
                FruitService.deltFruit(fruitModel);
            }else {
                return "Erro:Fruit-"+fruitModel.getFruitName()+"not in database";

            }
        }

        List<FruitModel> beShortOfFruitModel = FruitService.selectAllnum();
        if (beShortOfFruitModel.size()>0){
            StringBuffer s = new StringBuffer();
            for (int j= 0; j<beShortOfFruitModel.size(); j++){
                s.append(beShortOfFruitModel.get(j).getFruitName()+":"+beShortOfFruitModel.get(j).getNumber()+"\n");
            }
            System.out.println(s);
            return s.toString();
        }

        return "add ok";
    }

}