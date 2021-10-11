package com.netback.myelementback.backcontrollers;

import com.netback.myelementback.Dao.UserMapper;
import com.netback.myelementback.Entity.User;
import com.netback.myelementback.Utils.*;
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

    /**
     * 用户登录
     * @param postData 用户登录信息
     * @return 登录结果
     */
    @ResponseBody
    @PostMapping("/api/login")
    public CustResponseEntity Login(@RequestBody JSONObject postData) {
        String userNO = postData.getAsString("userNO");
        String password = postData.getAsString("password");
        String token = postData.getAsString("token");
        // 工具创建
        User entity = userMapper.getByUserNO(userNO);
        JSONObject result = new JSONObject();

        if (token != null && !token.equals("")) {
            if (TokenCreator.verify(token)) {
                result.put("code", 20000);
                // 带上 token
                result.put("token", token);
                result.put("message", "token 验证成功");

                System.out.println("token1");
                return new UniformResponseHandler<>().sendSuccessResponse();
            } else {
                // token 过期返回错误码，提示
                result.put("code", 50001);
                result.put("message", "登录已过期，请重新登录");

                System.out.println("token2");
                return new UniformResponseHandler<>().sendErrorResponse_UserDefined(new UserDefinedException(CodeAndMsg.ILLEAGETOKEN));
            }
        }

        // 正常登录
        if (entity.getPassword().equals(password)) {
            entity.setToken(TokenCreator.CreateToken(userNO, password));
            return new UniformResponseHandler<User>().sendSuccessResponse(entity);
        }

        //result.put("code", 20001);
        //result.put("message", "账号密码有误");
        return new UniformResponseHandler<>().sendErrorResponse_UserDefined(new UserDefinedException(CodeAndMsg.PASSWORDERROR));
    }

    /**
     * 创建用户
     * @param postData 用户信息
     * @return 创建结果
     */
    @PostMapping("/api/createUser")
    public CustResponseEntity CreateUser(@RequestBody JSONObject postData) {
        User user = new User();
        String userNO = postData.getAsString("userNO");
        String password = postData.getAsString("password");
        String userName = postData.getAsString("userName");

        User entity = userMapper.getUser(userNO);
        // 有相同的记录
        if (entity.getUserNO() != null) {
            return new UniformResponseHandler<>().sendErrorResponse_UserDefined(new UserDefinedException(CodeAndMsg.REPEATERROR));
        } else {
            // 没有记录，创建
            entity.setUserName(userName);
            entity.setUserNO(userNO);
            entity.setPassword(password);
            userMapper.insert(entity);
        }
        return new UniformResponseHandler<>().sendSuccessResponse();
    }

    /**
     * 修改用户名
     * @param postData
     * @return
     */
    @PostMapping("/api/modifyName")
    public CustResponseEntity ModifyUserName(@RequestBody JSONObject postData) {
        // 从 JsonObject 获取信息
        int userId = postData.getAsNumber("userId").intValue();
        String userName = postData.getAsString("userName");

        User entity = userMapper.getById(userId);

        if (entity.getUserNO() != null) {
            entity.setUserName(userName);
            userMapper.update(entity);
        } else {
            return new UniformResponseHandler<>().sendErrorResponse_UserDefined(new UserDefinedException(CodeAndMsg.SQLIDNOTEXIST));
        }

        return new UniformResponseHandler<>().sendSuccessResponse();
    }

    /**
     * 修改密码
     * @param postData
     * @return
     */
    @PostMapping("/api/modifyPassword")
    public CustResponseEntity ModifyPassword(@RequestBody JSONObject postData) {
        // 从 JsonObject 获取信息
        int userId = postData.getAsNumber("userId").intValue();
        String password = postData.getAsString("password");

        User entity = userMapper.getById(userId);

        if (entity.getUserNO() != null) {
            entity.setPassword(password);
            userMapper.update(entity);
        } else {
            return new UniformResponseHandler<>().sendErrorResponse_UserDefined(new UserDefinedException(CodeAndMsg.SQLIDNOTEXIST));
        }

        return new UniformResponseHandler<>().sendSuccessResponse();

    }

    /**
     * 获取当前用户完整信息
     * @param postData
     * @return
     */
    @PostMapping("/api/getUser")
    public User getUser(@RequestBody JSONObject postData) {
        // 从 JsonObject 获取信息
        int userId = postData.getAsNumber("userId").intValue();
        String userName = postData.getAsString("userNO");
        String password = postData.getAsString("password");

        return userMapper.getById(userId);
    }

    /**
     * 删除用户
     * @param postData
     * @return
     */
    @PostMapping("/api/deleteUser")
    public CustResponseEntity deleteUser(@RequestBody JSONObject postData) {
        // 从 JSONObject 获取信息
        int userId = postData.getAsNumber("userId").intValue();

        Boolean sqlResult = userMapper.deleteById(userId);

        if (!sqlResult) {
            return new UniformResponseHandler<>().sendErrorResponse_UserDefined(new UserDefinedException(CodeAndMsg.SQLIDNOTEXIST));
        }

        return new UniformResponseHandler<>().sendSuccessResponse();

    }

}
