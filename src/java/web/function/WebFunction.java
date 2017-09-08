/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.function;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jimmy
 */
public class WebFunction {

    //顯示alert訊息
    public static void showAlert(HttpServletResponse response, String msg, String back_url) {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<script type=\"text/javascript\">\n"
                    + "alert('" + msg + "')\n"
                    + "location='" + back_url + "'\n"
                    + "</script>");
        } catch (Exception ex) {
            System.out.println("show_result exception =" + ex.toString());
        }
    }

    //顯示訊息
    public static void showHTML(HttpServletResponse response, String msg) {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println(msg);
        } catch (Exception ex) {
            System.out.println("show_result exception =" + ex.toString());
        }
    }

}
