package com.netback.myelementback.backcontrollers;

import com.netback.myelementback.Dao.ResourceMapper;
import com.netback.myelementback.Entity.Resource;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/***
 * 资源上传 api
 */
@CrossOrigin("*")
@RestController
public class ResourceController {
    @Autowired
    private ResourceMapper mapper;

    /**
     *
     * @param postData
     * @return
     */
    @PostMapping("/api/UploadResource")
    public boolean UploadResource(@RequestBody JSONObject postData) {
        String resourceName = postData.getAsString("resourceName");
        String describe = postData.getAsString("describe");
        String resTag = postData.getAsString("resTag");
        Number category = postData.getAsNumber("Category");
        Number release = postData.getAsNumber("release");

        Resource entity = new Resource();
        entity.setsResourceName(resourceName);
        entity.setnCategory(category.intValue());
        entity.setsDescribe(describe);
        entity.setsResTag(resTag);
        entity.setnRelease(release.intValue());

        // 保存路径由后台保存返回
        entity.setsPath("测试路径");

        /* System.out.println("resouceName: " + resourceName);
        System.out.println("describe: " + describe);
        System.out.println("resTag: " + resTag);
        System.out.println("category: " + category);
        System.out.println("release: " + release); */

        mapper.insert(entity);

        return true;
    }

    /**
     * 删除资源
     * @return
     */
    @PostMapping("/api/DeleteResource")
    public boolean DeleteResource(@RequestBody JSONObject postData) {
        Number resourceId = postData.getAsNumber("ResourceId");

        // Resource entity = new Resource();
        mapper.deleteById(resourceId.intValue());

        return true;
    }

    @PostMapping("/api/RadioUpload")
    public String UploadRadio(@RequestBody JSONObject postData) {
        return "";
    }

    @PostMapping("/api/RadioDel")
    public String RadioDel(@RequestBody JSONObject postData) {
        return "";
    }
}
