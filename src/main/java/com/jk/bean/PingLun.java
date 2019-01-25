package com.jk.bean;

import lombok.Data;

import java.util.Date;

/**
 * t_mall_product_comment(商品评论表)
 */
@Data
public class PingLun {

   private Integer id;//(编号)           PKInteger

    private Integer yh_id;//(用户id)      Integer

    private String yh_mch;//用户名称

    private String plnr;//(评论内容)     String(1000)

    private Date plshj;//(平路时间)    Date

    private Integer hpjb;//(好评级别)     Integer

    private Integer sku_id;//(skuid)      Integer

    private String sku_mch;//(sku名称)   String(100)

    private Integer shp_id;//(商品id)     Integer

    private String shp_mch;//(商品名称)  String(100)

    private Integer dd_id;//(订单id)      Integer

    private Integer status ;//状态
}
