package com.zhangqiang.learn.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhangqiang.learn.bean.Zq;
import com.zhangqiang.learn.mapper.MyBatisPlusMapper;
import com.zhangqiang.learn.service.MyBatisPlusService;
import com.zhangqiang.learn.service.ZqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MybatisController {
    @Autowired
    ZqService zqService;

    @Autowired
    MyBatisPlusService myBatisPlusService;

    @GetMapping("/getzq")
    public Zq getZq(@RequestParam("id") int id){
        return zqService.getZqById(id);
    }

    @GetMapping("/getallzq")
    public List<Zq> getAllZq(@RequestParam("pagenum") int pagenum,
                             @RequestParam("pagecount") int pagecount){
        //return zqService.getAllZq();
        //return myBatisPlusService.list();
        Page<Zq> page = new Page<Zq>(pagenum,pagecount);
        Page<Zq> page1 = myBatisPlusService.page(page, null);
        return page1.getRecords();
    }

    @PostMapping(value="/addZq",produces= MediaType.APPLICATION_JSON_VALUE)
    public Zq addZq(Zq zq){
//        zqService.addZq(zq);
        myBatisPlusService.save(zq);
        return zq;
    }

    @GetMapping("/updateZq")
    public int updateZq(@RequestParam("name") String name,@RequestParam("id") int id){
        return zqService.updateZq(id, name);
    }

    @GetMapping("/deleteZq")
    public int deleteZq(@RequestParam("id") int id){
        return zqService.deleteZq(id);
    }
}
