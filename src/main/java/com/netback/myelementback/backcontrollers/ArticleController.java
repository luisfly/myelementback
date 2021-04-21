package com.netback.myelementback.backcontrollers;

import com.netback.myelementback.Dao.ArticleMapper;
import com.netback.myelementback.Dao.UserMapper;
import com.netback.myelementback.Entity.Article;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.util.Date;

// 前端数据传输 api 处理控制器
@CrossOrigin("*")
@RestController
public class ArticleController {

    // 从 bean 获取对应的 mapper 配置信息
    @Autowired
    private ArticleMapper mapper;
    @Autowired
    private UserMapper userMapper;

    // 文章保存
    // axios 前端传输的 data 会包装到 JSON 内，要使用JSONObject接受
    @PostMapping("/api/saveArticle")
    public void SaveArticle(@RequestBody JSONObject postdata) {
        String article = postdata.getAsString("article");
        Article entity = new Article();
        entity.setnUserId(1);
        entity.setsArticle(article);
        mapper.insert(entity);
        return ;
    }
}
