package com.netback.myelementback.backcontrollers;

import com.netback.myelementback.Dao.ArticleMapper;
import com.netback.myelementback.Entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/***
 * 测试使用控制器
 */
@CrossOrigin("*")
@RestController
public class TestController {

    /**
     * 从 bean 获取对应的 mapper 配置信息
     */
    @Autowired
    private ArticleMapper mapper;

    @GetMapping("/helloworld")
    public String helloworld() {
        return "helloworld";
    }

    @PostMapping("/api/TestListPanel")
    public List<Article> TestListPanel(String[] query) {
        List<Article> testlist = new ArrayList<Article>();

        Article test = new Article();
        test.setnUserId(123);
        test.setsArticle("这是个测试文章");

        testlist.add(test);

        return testlist;
    }
}
