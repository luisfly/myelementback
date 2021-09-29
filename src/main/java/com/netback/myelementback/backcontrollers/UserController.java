package com.netback.myelementback.backcontrollers;

import com.netback.myelementback.Dao.UserMapper;
import com.netback.myelementback.Entity.User;
import com.netback.myelementback.Utils.TokenCreator;
import net.minidev.json.JSONObject;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户操作相关的 controller
 */
@CrossOrigin("*")
@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    // 用户登录
    @ResponseBody
    @PostMapping("/api/login")
    public String Login(@RequestBody JSONObject postData) {
        String userNO = postData.getAsString("userNO");
        String password = postData.getAsString("password");
        String token = postData.getAsString("token");
        // 工具创建
        User entity = userMapper.getUser(userNO);
        JSONObject result = new JSONObject();

        if (token != null && !token.equals("")) {
            if (TokenCreator.verify(token)) {
                result.put("code", 20000);
                // 带上 token
                result.put("token", token);
                result.put("message", "token 验证成功");
                return result.toJSONString();
            } else {
                // token 过期返回错误码，提示
                result.put("code", 50001);
                result.put("message", "登录已过期，请重新登录");
                return result.toJSONString();
            }
        }
        // String token = TokenCreator.CreateToken(userNO, password);

        if (entity.getPassword().equals(password)) {
            result.put("code", 20000);
            // 带上 token
            result.put("token", TokenCreator.CreateToken(userNO, password));
            return result.toJSONString();
        }

        result.put("code", 20001);
        result.put("message", "账号密码有误");
        return result.toJSONString();
    }

    // 用户创建
    @PostMapping("/api/createUser")
    public boolean CreateUser(@RequestBody JSONObject postData) {
        User user = new User();
        String userNO = postData.getAsString("userNO");
        String password = postData.getAsString("password");
        String userName = postData.getAsString("userName");

        User entity = userMapper.getUser(userNO);
        // 有相同的记录
        if (entity.getUserNO() != null) {
            return false;
        } else {
            // 没有记录，创建
            entity.setUserName(userName);
            entity.setUserNO(userNO);
            entity.setPassword(password);
            userMapper.insert(entity);
        }

        return true;
    }

    // 修改用户名
    @PostMapping("/api/modifyName")
    public boolean ModifyUserName(@RequestBody JSONObject postData) {
        // 从 JsonObject 获取信息
        int userId = postData.getAsNumber("userId").intValue();
        String userName = postData.getAsString("userName");

        User entity = userMapper.getById(userId);

        if (entity.getUserNO() != null) {
            entity.setUserName(userName);
            userMapper.update(entity);
        } else {
            return false;
        }

        return true;
    }

    // 修改密码
    @PostMapping("/api/modifyPassword")
    public boolean ModifyPassword(@RequestBody JSONObject postData) {
        // 从 JsonObject 获取信息
        int userId = postData.getAsNumber("userId").intValue();
        String password = postData.getAsString("password");

        User entity = userMapper.getById(userId);

        if (entity.getUserNO() != null) {
            entity.setPassword(password);
            userMapper.update(entity);
        } else {
            return false;
        }

        return true;

    }

    // 获取当前用户完整信息
    @PostMapping("/api/getUser")
    public User getUser(@RequestBody JSONObject postData) {
        // 从 JsonObject 获取信息
        int userId = postData.getAsNumber("userId").intValue();
        String userName = postData.getAsString("userNO");
        String password = postData.getAsString("password");

        return userMapper.getById(userId);
    }

    // 删除用户
    @PostMapping("/api/deleteUser")
    public boolean deleteUser(@RequestBody JSONObject postData) {
        // 从 JSONObject 获取信息
        int userId = postData.getAsNumber("userId").intValue();

        userMapper.deleteById(userId);

        return true;

    }

}
