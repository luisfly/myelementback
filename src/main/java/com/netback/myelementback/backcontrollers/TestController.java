package com.netback.myelementback.backcontrollers;

import com.netback.myelementback.Dao.ArticleMapper;
import com.netback.myelementback.Entity.Article;
import com.netback.myelementback.Utils.CustResponseEntity;
import com.netback.myelementback.Utils.UniformResponseHandler;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    public CustResponseEntity TestListPanel(@RequestBody JSONObject postData) {
        List<Article> testlist = new ArrayList<Article>();

        Article test = new Article();
        test.setUserId(123);
        test.setArticle("这是个测试文章");
        test.setTitle("测试标题");
        test.setCreateDate(new Date());

        Article entity = mapper.getById(1);

        // testlist.add(test);

        testlist.add(entity);

        // 附加返回信息
        return new UniformResponseHandler<List>().sendSuccessResponse(testlist);
    }
}
