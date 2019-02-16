package com.jk.controller;

import com.jk.bean.Groud;
import com.jk.bean.PingLun;
import com.jk.bean.ReceivePage;
import com.jk.bean.SendPage;
import com.jk.service.PingLunService;
import com.jk.utils.ExportExcel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("pingLun")
public class GoodPingLunController {

    @Resource
    private PingLunService pingLunService;

    @RequestMapping("queryPingLun")
    @ResponseBody
    public SendPage queryPingLun(PingLun p, ReceivePage r) {
        SendPage sp = pingLunService.queryPingLun(p, r);
        return sp;

    }


    @RequestMapping("updatePinglun")
    @ResponseBody
    public String addPingLun(PingLun pingLun) {

        pingLunService.updatePingLun(pingLun);
        return "1";
    }

    @RequestMapping("updateTongguo")
    @ResponseBody
    public String updateTongguo(Integer id) {

        pingLunService.updateTongguo(id);
        return "1";
    }


    @RequestMapping("deletePingLun")
    @ResponseBody
    public String deletePingLun(Integer id) {

        pingLunService.deletePingLun(id);
        return "1";
    }

    @RequestMapping("queryTop")
    @ResponseBody
    public SendPage queryTop(Groud g, ReceivePage r) {

        SendPage sp = pingLunService.queryTop(g, r);
        return sp;

    }

    @RequestMapping("addGroud")
    @ResponseBody
    public Boolean addGroud(Groud groud) {

        try {
            if (groud.getGroudId() == null) {

                pingLunService.addGroud(groud);
            } else {
                pingLunService.updateGroud(groud);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @RequestMapping("deleteGroudByIds")
    @ResponseBody
    public Boolean deleteGroudByIds(String[] ids) {

        try {
            pingLunService.deleteGroudByIds(ids);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping("queryTopId")
    @ResponseBody
    public Groud queryTopId(Integer groudId) {

        return pingLunService.queryTopId(groudId);
    }


    //poi导出
    @ResponseBody
    @RequestMapping("save")
    public String save(@RequestParam("id") String id) throws Exception {
        String sheetName = "评论列表";
        String titleName = "内容";
        String[] headers = {"评论ID", "用户名称", "评论内容", "评论时间", "好评级别", "sku名称", "商品名称", "状态"};

        /////获取桌面路径
        FileSystemView fsv = FileSystemView.getFileSystemView();
        File com = fsv.getHomeDirectory();
        //格式化时间戳
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HHmmss");
        String format = simpleDateFormat.format(new Date());

        /////去数据库查询要导出的数据
        List<PingLun> dataSet = pingLunService.getAllPingLun(id);
        String resultUrl = com.getPath() + "//" + format + ".xls";
        String pattern = "yyyy-MM-dd";
        ExportExcel.exportExcel(sheetName, titleName, headers, dataSet, resultUrl, pattern);
        return "success";
    }
}