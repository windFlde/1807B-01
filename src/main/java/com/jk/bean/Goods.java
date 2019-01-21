package com.jk.bean;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Goods {

    /*
    *
    * t_mall_product(商品表)
--------------------------------
Id(编号)           PKInteger
shp_mch(商品名称)  String(100)
shp_tp(商品图片)   String(100)
flbh1(分类编号1)   Integer
flbh2(分类编号2)   Integer
pp_id(品牌id)      Integer
chjshj(创建时间)   Date
shp_msh(商品描述)  String(1000)
    *
    * */
    Integer id;
    String shp_mch;
    String shp_tp;
    Integer flbh1;
    Integer flbh2;
    Integer pp_id;

    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date chjshj;
    String shp_msh;



}
