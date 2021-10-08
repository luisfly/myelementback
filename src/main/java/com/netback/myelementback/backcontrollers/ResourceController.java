package com.netback.myelementback.backcontrollers;

import com.netback.myelementback.Dao.ResourceMapper;
import com.netback.myelementback.Entity.Resource;
import com.netback.myelementback.Utils.CodeAndMsg;
import com.netback.myelementback.Utils.CustResponseEntity;
import com.netback.myelementback.Utils.UniformResponseHandler;
import com.netback.myelementback.Utils.UserDefinedException;
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
    public CustResponseEntity UploadResource(@RequestBody JSONObject postData) {
        String resourceName = postData.getAsString("resourceName");
        String describe = postData.getAsString("describe");
        String resTag = postData.getAsString("resTag");
        Number category = postData.getAsNumber("Category");
        Number release = postData.getAsNumber("release");

        Resource entity = new Resource();
        entity.setResourceName(resourceName);
        entity.setCategory(category.intValue());
        entity.setDescribe(describe);
        entity.setResTag(resTag);
        entity.setRelease(release.intValue());

        // 保存路径由后台保存返回
        entity.setPath("测试路径");

        /* System.out.println("resouceName: " + resourceName);
        System.out.println("describe: " + describe);
        System.out.println("resTag: " + resTag);
        System.out.println("category: " + category);
        System.out.println("release: " + release); */

        Boolean sqlResult = mapper.insert(entity);

        if (!sqlResult) {
            return new UniformResponseHandler<>().sendErrorResponse_UserDefined(new UserDefinedException(CodeAndMsg.REPEATERROR));
        }

        return new UniformResponseHandler<>().sendSuccessResponse();
    }

    /**
     * 删除资源
     * @return
     */
    @PostMapping("/api/DeleteResource")
    public CustResponseEntity DeleteResource(@RequestBody JSONObject postData) {
        Number resourceId = postData.getAsNumber("ResourceId");

        // Resource entity = new Resource();
        Boolean sqlResult = mapper.deleteById(resourceId.intValue());

        if(!sqlResult) {
            return new UniformResponseHandler<>().sendErrorResponse_UserDefined(new UserDefinedException(CodeAndMsg.SQLIDNOTEXIST));
        }

        return new UniformResponseHandler<>().sendSuccessResponse();
    }

    @PostMapping("/api/RadioUpload")
    public CustResponseEntity UploadRadio(@RequestBody JSONObject postData) {
        return new UniformResponseHandler<>().sendSuccessResponse();
    }

    @PostMapping("/api/RadioDel")
    public CustResponseEntity RadioDel(@RequestBody JSONObject postData) {
        return new UniformResponseHandler<>().sendSuccessResponse();
    }
}
