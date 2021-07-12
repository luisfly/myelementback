package com.netback.myelementback.backcontrollers;

import com.netback.myelementback.Dao.VideoMapper;
import com.netback.myelementback.Entity.Resource;
import com.netback.myelementback.Entity.Video;
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

    @PostMapping("/api/VideoUpload")
    public boolean UploadVideo(@RequestBody JSONObject postData) {
        String videoName = postData.getAsString("VideoName");
        String videoPath = postData.getAsString("VideoPath");
        String userNO = postData.getAsString("UserNO");
        String createUser = postData.getAsString("CreateUser");


        Video video = new Video();
        video.setsVideoName(videoName);
        video.setsVideoPath(videoPath);
        video.setsUserNO(userNO);
        video.setsCreateUser(createUser);

        SimpleDateFormat change = new SimpleDateFormat("YYYY-MM-dd");

        try {
            Date createDate = change.parse(postData.getAsString("CreateDate"));
            video.setdCreateDate(createDate);
            mapper.insert(video);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    @PostMapping("/api/VideoDel")
    public String DelVideo(@RequestBody JSONObject postData) {
        Number videoId = postData.getAsNumber("VideoId");

        mapper.deleteById(videoId.intValue());

        return "";
    }

    @PostMapping("/api/GetVideo")
    public Video GetVideo(@RequestBody JSONObject postData) {
        Number videoId = postData.getAsNumber("videoId");

        Video video = mapper.getById(videoId.intValue());

        return video;
    }

    @PostMapping("/api/VideoUpdate")
    public boolean UpdateVideo(@RequestBody JSONObject postData) {
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

}
