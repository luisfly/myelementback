package com.netback.myelementback.Dao;

import com.netback.myelementback.Entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ArticleMapper {

    @Select("select * from tArticle where nRankID = #{nRankID}")
    Article getArticle(@Param("nRankID") int nRankID);

    public void insert(Article article);
    public Article getById(int nRankID);
    public void update(Article article);
    public void deleteById(int nRankID);


}
