package com.netback.myelementback.backcontrollers;

import com.netback.myelementback.Dao.ArticleMapper;
import com.netback.myelementback.Dao.UserMapper;
import com.netback.myelementback.Entity.Article;
import com.netback.myelementback.Entity.User;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

// 前端数据传输 api 处理控制器, 文章相关的 api
@CrossOrigin("*")
@RestController
public class ArticleController {

    // 从 bean 获取对应的 mapper 配置信息
    @Autowired
    private ArticleMapper mapper;

    // 文章新建、保存
    // axios 前端传输的 data 会包装到 JSON 内，要使用JSONObject接受
    @PostMapping("/api/saveArticle")
    public boolean SaveArticle(@RequestBody JSONObject postData) {
        String article = postData.getAsString("article");
        Number userID = postData.getAsNumber("userID");
        Number rankID = postData.getAsNumber("rankID");

        System.out.println(article);
        System.out.println(userID);
        System.out.println(rankID);

        Article entity;
        if (rankID != null) {
            entity = mapper.getArticle(rankID.intValue());
            // 找到记录，修改
            if (entity != null) {
                Date date = new Date();

                entity.setsArticle(article);
                entity.setdChangeDate(date);
                entity.setdLastUpdateTime(date);

                mapper.insert(entity);
            } else {
                // 没找到记录，插入
                entity = new Article();
                entity.setnUserId(userID.intValue());
                entity.setsArticle(article);
                mapper.insert(entity);

            }
        }

        return true;
    }

    // 文章删除
    @PostMapping("/api/delArticle")
    public boolean DelArticle(@RequestBody JSONObject postData) {
        // Number userID = postData.getAsNumber("userID");
        Number rankID = postData.getAsNumber("rankID");

        mapper.deleteById(rankID.intValue());

        return true;
    }
}
