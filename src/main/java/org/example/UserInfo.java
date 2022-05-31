package org.example;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class UserInfo {
    private Long id;
//    @JSONField(alternateNames = "test")
    private String userName;
    @JSONField(name = "user_age")
    private String userAge;
    private String userSex;
    private String userPassword;
}
