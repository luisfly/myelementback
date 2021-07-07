package com.netback.myelementback.backcontrollers;

import com.netback.myelementback.Dao.VideoMapper;
import com.netback.myelementback.Entity.Resource;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/***
 * 资源上传 api
 */
@CrossOrigin("*")
@RestController
public class VideoController {
    @Autowired
    private VideoMapper mapper;

    @PostMapping("/api/RadioUpload")
    public boolean UploadVideo(@RequestBody JSONObject postData) {
        String videoName = postData.getAsString("videoName");
        String videoPath = postData.getAsString("videoPath");
        String userNO = postData.getAsString("userNO");
        String createUser = postData.getAsString("createUser");

        SimpleDateFormat change = new SimpleDateFormat("YYYY-MM-dd");

        try {
            Date createDate = change.parse(postData.getAsString("createDate"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    @PostMapping("/api/RadioDel")
    public String DelVideo(@RequestBody JSONObject postData) {
        Number videoId = postData.getAsNumber("videoId");

        mapper.deleteById(videoId.intValue());

        return "";
    }
}
