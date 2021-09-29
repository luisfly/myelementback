package com.netback.myelementback.Dao;

import com.netback.myelementback.Entity.Video;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VideoMapper {

    /**
     * 新建资源
     * @param video 资源信息
     */
    public void insert(Video video);

    /**
     * 根据 ID 获取资源
     * @param id
     * @return
     */
    public Video getById(int id);

    /**
     * 更新 Resource
     * @param video 资源的相关信息
     */
    public void update(Video video);

    /**
     * 根据 id 删除 Resource
     * @param id 资源 ID
     */
    public void deleteById(int id);

}
