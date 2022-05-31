package org.example;

import static org.junit.Assert.assertTrue;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.val;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private String json1 = "{\"id\":1,\"useRName\":\"ZhangSan\",\"userAge\":\"18\",\"user_Sex\":\"1\",\"userPass_word\":\"123456\"}";
    private String json2 = "{\"id\":1,\"test\":\"ZhangSan\",\"userAge\":\"18\",\"userSex\":\"1\",\"userPassword\":\"123456\"}";
    private String json3 = "{\"id\":1,\"userName\":\"ZhangSan\",\"userAge\":\"18\",\"userSex\":\"1\",\"userPassword\":\"123456\"}";
    private ObjectMapper objectMapper;

    @Before
    public void init() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1L);
        userInfo.setUserName("ZhangSan");
        userInfo.setUserAge("18");
        userInfo.setUserSex("1");
        userInfo.setUserPassword("123456");
        objectMapper = new ObjectMapper();
    }

    /**
     * 测试1
     */
    @Test
    public void fastjson70VsJackson1() throws JsonProcessingException {
        val userInfo1 = JSON.parseObject(json1, UserInfo.class);
        System.out.println(JSON.toJSONString(userInfo1));
        val userInfo2 = objectMapper.readValue(json1, UserInfo.class);
        System.out.println(JSON.toJSONString(userInfo2));
        Assert.assertNotNull(userInfo1.getId());
        Assert.assertNotNull(userInfo1.getUserName());
        Assert.assertNotNull(userInfo1.getUserAge());
        Assert.assertNotNull(userInfo1.getUserSex());
        Assert.assertNotNull(userInfo1.getUserPassword());
        Assert.assertNotNull(userInfo2.getId());
        Assert.assertNotNull(userInfo2.getUserName());
        Assert.assertNotNull(userInfo2.getUserAge());
        Assert.assertNotNull(userInfo2.getUserSex());
        Assert.assertNotNull(userInfo2.getUserPassword());

    }

    /**
     * 打开注释代码  @JSONField(alternateNames = "test")
     */
    @Test
    public void fastjson70VsJackson2() throws JsonProcessingException {
        val userInfo1 = JSON.parseObject(json2, UserInfo.class);
        System.out.println(JSON.toJSONString(userInfo1));
        val userInfo2 = objectMapper.readValue(json2, UserInfo.class);
        System.out.println(JSON.toJSONString(userInfo2));
        Assert.assertNotNull(userInfo1.getId());
        Assert.assertNotNull(userInfo1.getUserName());
        Assert.assertNotNull(userInfo1.getUserAge());
        Assert.assertNotNull(userInfo1.getUserSex());
        Assert.assertNotNull(userInfo1.getUserPassword());
        Assert.assertNotNull(userInfo2.getId());
        Assert.assertNotNull(userInfo2.getUserName());
        Assert.assertNotNull(userInfo2.getUserAge());
        Assert.assertNotNull(userInfo2.getUserSex());
        Assert.assertNotNull(userInfo2.getUserPassword());
    }

    /**
     * 打开注释代码 @JSONField(name = "user_age")
     */
    @Test
    public void fastjson70VsFastJson75() throws JsonProcessingException {
        val userInfo1 = JSON.parseObject(json3, UserInfo.class);
        System.out.println(JSON.toJSONString(userInfo1));
        val userInfo2 = objectMapper.readValue(json3, UserInfo.class);
        System.out.println(JSON.toJSONString(userInfo2));
        Assert.assertNotNull(userInfo1.getId());
        Assert.assertNotNull(userInfo1.getUserName());
        Assert.assertNotNull(userInfo1.getUserAge());
        Assert.assertNotNull(userInfo1.getUserSex());
        Assert.assertNotNull(userInfo1.getUserPassword());
        Assert.assertNotNull(userInfo2.getId());
        Assert.assertNotNull(userInfo2.getUserName());
        Assert.assertNotNull(userInfo2.getUserAge());
        Assert.assertNotNull(userInfo2.getUserSex());
        Assert.assertNotNull(userInfo2.getUserPassword());
    }
}
