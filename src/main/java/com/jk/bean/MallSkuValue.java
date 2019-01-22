package com.jk.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class MallSkuValue {

    private  Integer id;                  // (编号)    

    private Integer shxm_id;             //(属性名id)  

    private Integer shxzh_id;            //(属性值id) 

    private Integer shp_id;              // (商品id)   

    private String is_sku;               // (是否sku)  

    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date chjshj;                  // (创建时间)  

    private Integer sku_id;              // (skuid)  
}
