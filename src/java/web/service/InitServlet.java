/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.service;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author Jimmy
 */
public class InitServlet extends HttpServlet {

    /**
     */
    private static final long serialVersionUID = 1L;

    @Override
    public void init(ServletConfig config) {
        try {
            super.init();
        } catch (ServletException e) {
            e.printStackTrace();
        }
        System.out.println("================>[Servlet]自動載入開始.");
        //放入想執行的東西
        System.out.println("================>[Servlet]自動載入結束.");
    }
}
