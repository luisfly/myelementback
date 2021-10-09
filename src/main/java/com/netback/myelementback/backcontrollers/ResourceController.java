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

import java.util.ArrayList;
import java.util.List;

/***
 * 资源上传 api
 */
@CrossOrigin("*")
@RestController
public class ResourceController {
    @Autowired
    private ResourceMapper mapper;

    /**
     * 上传资源
     * @param postData 上传信息的 json
     * @return 上传结果返回
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

        Boolean sqlResult = mapper.insert(entity);

        if (!sqlResult) {
            return new UniformResponseHandler<>().sendErrorResponse_UserDefined(new UserDefinedException(CodeAndMsg.REPEATERROR));
        }

        return new UniformResponseHandler<>().sendSuccessResponse();
    }

    /**
     * 删除资源
     * @param postData
     * @return 上传结果返回
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

    /**
     * 根据id获取资源
     * @param postData 包含资源id的json
     * @return 资源的list
     */
    @PostMapping("/api/GetResource")
    public CustResponseEntity GetResource(@RequestBody JSONObject postData) {
        Number resourceId = postData.getAsNumber("ResourceId");

        Resource data = mapper.getById(resourceId.intValue());
        List<Resource> datalist = new ArrayList<Resource>();

        datalist.add(data);
        if (data == null) {
            return new UniformResponseHandler<>().sendErrorResponse_UserDefined(new UserDefinedException(CodeAndMsg.SQLIDNOTEXIST));
        }

        return new UniformResponseHandler<List>().sendSuccessResponse(datalist);
    }
}
