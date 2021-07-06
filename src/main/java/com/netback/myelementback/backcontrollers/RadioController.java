package com.netback.myelementback.backcontrollers;

import com.netback.myelementback.Dao.RadioMapper;
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
public class RadioController {
    @Autowired
    private RadioMapper mapper;

    @PostMapping("/api/RadioUpload")
    public boolean UploadRadio(@RequestBody JSONObject postData) {
        String radioName = postData.getAsString("radioName");

        return true;
    }

    @PostMapping("/api/RadioDel")
    public String RadioDel(@RequestBody JSONObject postData) {
        String radioName = postData.getAsString("");

        return "";
    }
}
