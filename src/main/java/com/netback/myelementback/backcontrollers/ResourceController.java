package com.netback.myelementback.backcontrollers;

import net.minidev.json.JSONObject;
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

        

        return true;
    }

    /**
     * 删除资源
     * @return
     */
    @PostMapping("/api/DeleteResource")
    public String DeleteResource(@RequestBody JSONObject postData) {
        return "";
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
