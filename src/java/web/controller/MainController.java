/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.entity.Member;
import web.entity.Table;
import web.model.DB_Helper;

/**
 *
 * @author Jimmy
 */
@Controller
public class MainController {

    //新增資料
    @RequestMapping(value = "/add")
    public String addData(Model model, @RequestParam String data) {
        System.out.println("data:" + data);
        Table table = new Table(); //建立 User 實例
        table.setTest(data);
        DB_Helper.saveData(table);
        model.addAttribute("status", "寫入資料：" + data);
        System.out.println("write--->OK");
        return "showData";
    }

    //更新資料
    @RequestMapping(value = "/update")
    public String updateData(Model model, @RequestParam String data, @RequestParam int count) {
        Table table = (Table) DB_Helper.getData(Table.class, count);
        table.setTest(data);
        DB_Helper.updateData(table);
        model.addAttribute("status", "更新資料：" + data + ",id=" + count);
        System.out.println("write--->OK");
        return "showData";
    }

    //讀取資料
    @RequestMapping(value = "/read")
    public String readData(Model model, @RequestParam int count) {
        Table table = (Table) DB_Helper.getData(Table.class, count);
        model.addAttribute("status", "讀取資料：" + table.getId() + "," + table.getTest());
        System.out.println("read--->OK");
        return "showData";
    }

    //產生陣列
    @RequestMapping(value = "/showArray")
    public String showArray(Model model) {
        List list = DB_Helper.getDataSet("from Table order by id desc");
        Iterator iterator = list.iterator();
        List<Table> tables = new ArrayList();
        while (iterator.hasNext()) {
            Table table = (Table) iterator.next();
            tables.add(table);
        }
        model.addAttribute("datas", tables);
        return "showArray";
    }

    //儲存Session
    @RequestMapping(value = "/setSession")
    public String setSession(HttpServletRequest request, Model model) {
        Table table = new Table();
        table.setTest("my_test");
        request.getSession().setAttribute("table", table);
        model.addAttribute("status", "OK");
        return "showData";
    }

    //儲存Session
    @RequestMapping(value = "/getSession")
    public String getSession(HttpServletRequest request, Model model) {
        if (request.getSession().getAttribute("table") != null) {
            Table table = (Table) request.getSession().getAttribute("table");
            model.addAttribute("status", table.getTest());
        } else {
            model.addAttribute("status", "未登入");
        }
        return "showData";
    }

    //測試HQL語句
    @RequestMapping(value = "/test01")
    public String test01(Model model, @RequestParam String test) {
        List list = DB_Helper.getDataSet("from Table table where table.test = '" + test + "'");
        if (list.size() > 0) {
            model.addAttribute("status", "true");
        } else {
            model.addAttribute("status", "false");
        }
        return "showData";
    }

    //測試PK table
    @RequestMapping(value = "/test02")
    public String test02(Model model, @RequestParam String member_s, @RequestParam String member_pwd) {
        List list = DB_Helper.getDataSet("from Member m where m.member='" + member_s + "'");
        Iterator iterator = list.iterator();
        boolean isV = false;
        if (!iterator.hasNext()) {
            isV = true;
            Member member = new Member();
            member.setMember(member_s);
            member.setPwd(member_pwd);
            DB_Helper.saveData(member);
        }
        model.addAttribute("status", isV);
        return "showData";
    }

    //取得PK table
    @RequestMapping(value = "/test03")
    public String test03(Model model, @RequestParam String member) {
        Member member_s = (Member) DB_Helper.getDataByStr(Member.class, member);
        model.addAttribute("status", member_s.getPwd());
        return "showData";
    }

    //取得資料
    @RequestMapping(value = "/result")
    public String getData(Model model, @RequestParam String member) {
        Member member_s = (Member) DB_Helper.getDataByStr(Member.class, member);
        model.addAttribute("data", member_s.getPwd());
        return "result";
    }
}
