package com.netback.myelementback.Dao;

import com.netback.myelementback.Entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ArticleMapper {

    @Select("select * from tArticle where nRankID = #{rankID}")
    public Article getArticle(@Param("rankID") int rankID);

    public boolean insert(Article article);
    public Article getById(int rankID);
    public boolean update(Article article);
    public boolean deleteById(int rankID);


}
