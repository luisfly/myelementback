package com.netback.myelementback.Dao;

import com.netback.myelementback.Entity.Resource;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VideoMapper {

    /**
     * 新建资源
     * @param resource 资源信息
     */
    public void insert(Resource resource);

    /**
     * 根据 ID 获取资源
     * @param nId
     * @return
     */
    public Resource getById(int nId);

    /**
     * 更新 Resource
     * @param resource 资源的相关信息
     */
    public void update(Resource resource);

    /**
     * 根据 id 删除 Resource
     * @param nId 资源 ID
     */
    public void deleteById(int nId);

}
