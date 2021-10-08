package com.netback.myelementback.backcontrollers;

import com.netback.myelementback.Dao.ArticleMapper;
import com.netback.myelementback.Dao.UserMapper;
import com.netback.myelementback.Entity.Article;
import com.netback.myelementback.Entity.User;
import com.netback.myelementback.Utils.CodeAndMsg;
import com.netback.myelementback.Utils.CustResponseEntity;
import com.netback.myelementback.Utils.UniformResponseHandler;
import com.netback.myelementback.Utils.UserDefinedException;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 前端数据传输 api 处理控制器, 文章相关的 api
 */
@CrossOrigin("*")
@RestController
public class ArticleController {

    /**
     * 从 bean 获取对应的 mapper 配置信息
     */
    @Autowired
    private ArticleMapper mapper;

    /**
     * 文章新建、保存
     * axios 前端传输的 data 会包装到 JSON 内，要使用JSONObject接受
     */
    @PostMapping("/api/saveArticle")
    public CustResponseEntity SaveArticle(@RequestBody JSONObject postData) {
        String article = postData.getAsString("article");
        Number userID = postData.getAsNumber("userID");
        Number rankID = postData.getAsNumber("rankID");

        Article entity;
        if (rankID != null) {
            entity = mapper.getArticle(rankID.intValue());
            // 找到记录，修改
            if (entity != null) {
                Date date = new Date();

                entity.setArticle(article);
                entity.setChangeDate(date);
                entity.setLastUpdateTime(date);

                mapper.insert(entity);
            } else {
                // 没找到记录，插入
                entity = new Article();
                entity.setUserId(userID.intValue());
                entity.setArticle(article);
                mapper.insert(entity);

            }
        }

        return new UniformResponseHandler<>().sendSuccessResponse();
    }

    /**
     * 文章删除
     */
    @PostMapping("/api/delArticle")
    public CustResponseEntity DelArticle(@RequestBody JSONObject postData) {
        // Number userID = postData.getAsNumber("userID");
        Number rankID = postData.getAsNumber("rankID");

        Boolean sqlResult = mapper.deleteById(rankID.intValue());

        if (!sqlResult) {
            return new UniformResponseHandler<>().sendErrorResponse_UserDefined(new UserDefinedException(CodeAndMsg.SQLIDNOTEXIST));
        }

        return new UniformResponseHandler<>().sendSuccessResponse();
    }

    /**
     * 查找文章
     */
    @PostMapping("/api/getArticle")
    public CustResponseEntity GetArticle(@RequestBody JSONObject postData) {
        Number rankID = postData.getAsNumber("rankID");

        Article article = mapper.getById(rankID.intValue());

        List datalist = new ArrayList<Article>();

        datalist.add(article);

        System.out.println(article.getArticle());

        if (article == null) {
            return new UniformResponseHandler<>().sendErrorResponse_UserDefined(new UserDefinedException(CodeAndMsg.SQLIDNOTEXIST));
        }

        return new UniformResponseHandler<Article>().sendSuccessResponse(article);
    }
}
