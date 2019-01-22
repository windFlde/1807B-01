package com.jk.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.lang.model.element.NestingKind;
import java.util.Date;

@Data
public class MallAttr {

    Integer id;
    String shxm_mch;
    String shfqy;
    String flbh2;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date chjshj;

    String shxzh;



}
