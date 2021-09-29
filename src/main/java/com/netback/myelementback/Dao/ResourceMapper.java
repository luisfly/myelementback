package com.netback.myelementback.Dao;

import com.netback.myelementback.Entity.Resource;
import com.netback.myelementback.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ResourceMapper {

    /**
     * 新建资源
     * @param resource 资源信息
     */
    public boolean insert(Resource resource);

    /**
     * 根据 ID 获取资源
     * @param id
     * @return
     */
    public Resource getById(int id);

    /**
     * 更新 Resource
     * @param resource 资源的相关信息
     */
    public boolean update(Resource resource);

    /**
     * 根据 id 删除 Resource
     * @param id 资源 ID
     */
    public boolean deleteById(int id);

}
