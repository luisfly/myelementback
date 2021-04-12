package com.netback.myelementback.backcontrollers;

import net.minidev.json.JSONObject;
import org.springframework.web.bind.annotation.*;

// 前端数据传输 api 处理控制器
@CrossOrigin("*")
@RestController
public class ArticleController {

    // 文章保存
    // axios 前端传输的 data 会包装到 JSON 内，要使用JSONObject接受
    @PostMapping("/api/saveArticle")
    public void SaveArticle(@RequestBody JSONObject postdata) {
        String article = postdata.getAsString("article");
        System.out.println(article);
        return ;
    }
}
