package com.jk.bean;

import lombok.Data;

import java.util.Date;

@Data
public class Attr {

    Integer Id;        //(编号)            PKInteger
    String shxm_mch;    //(属性名称)  String(100)
    String shfqy;       //(是否启用)     String(1)
    Integer flbh2;      //(分类编号2)    Integer
    Date chjshj;        //(创建时间)    Date
}
