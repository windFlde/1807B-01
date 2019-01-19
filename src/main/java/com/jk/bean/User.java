package com.jk.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class User {

    Integer id;
    String loginacct;
    String userpswd;
    String username;
    String email;

    @JsonFormat(pattern="yyyy-MM-dd",timezone="GAM+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    Date createtime;
}
