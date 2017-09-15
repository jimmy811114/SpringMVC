/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.model;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Jimmy
 */
public class DB_Helper {

    //新增物件
    public static void saveData(Object data) {
        /*透過SessionFactory 取得 Session 實例*/
        SessionFactory sessionFactory;
        /*取得資料庫連線*/
        Session sess = null;

        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            sess = sessionFactory.openSession();
            /*開啟一個會話操作*/
            Transaction tx = sess.beginTransaction();
            /*將 user 物件映射到資料庫中對應的表格儲存*/
            sess.save(data);
            tx.commit();
        } catch (HibernateException e) {
            System.out.println(e.toString());
        } finally {
            if (sess != null) {
                sess.close();
            }
        }
    }

    //更新物件
    public static void updateData(Object data) {
        /*透過SessionFactory 取得 Session 實例*/
        SessionFactory sessionFactory;
        /*取得資料庫連線*/
        Session sess = null;
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            sess = sessionFactory.openSession();
            /*開啟一個會話操作*/
            Transaction tx = sess.beginTransaction();
            /*將 user 物件映射到資料庫中對應的表格儲存*/
            sess.update(data);
            tx.commit();
        } catch (HibernateException e) {
            System.out.println(e.toString());
        } finally {
            if (sess != null) {
                sess.close();
            }
        }
    }

    //刪除物件
    public static void delData(Object data) {
        /*透過SessionFactory 取得 Session 實例*/
        SessionFactory sessionFactory;
        /*取得資料庫連線*/
        Session sess = null;
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            sess = sessionFactory.openSession();
            /*開啟一個會話操作*/
            Transaction tx = sess.beginTransaction();
            /*將 user 物件映射到資料庫中對應的表格儲存*/
            sess.delete(data);
            tx.commit();
        } catch (HibernateException e) {
            System.out.println(e.toString());
        } finally {
            if (sess != null) {
                sess.close();
            }
        }
    }

    //取得物件
    public static Object getData(Class type, int id) {
        /*透過SessionFactory 取得 Session 實例*/
        SessionFactory sessionFactory;
        /*取得資料庫連線*/
        Session sess = null;
        Object obj = null;
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            sess = sessionFactory.openSession();
            /*將 user 物件映射到資料庫中對應的表格儲存*/
            obj = sess.get(type, id);
        } catch (HibernateException e) {
            System.out.println(e.toString());
        } finally {
            if (sess != null) {
                sess.close();
            }
        }
        return obj;
    }

    //取得物件_str
    public static Object getDataByStr(Class type, String id) {
        /*透過SessionFactory 取得 Session 實例*/
        SessionFactory sessionFactory;
        /*取得資料庫連線*/
        Session sess = null;
        Object obj = null;
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            sess = sessionFactory.openSession();
            /*將 user 物件映射到資料庫中對應的表格儲存*/
            obj = sess.get(type, id);
        } catch (HibernateException e) {
            System.out.println(e.toString());
        } finally {
            if (sess != null) {
                sess.close();
            }
        }
        return obj;
    }

    //取得物件
    public static List getDataSet(String HQL) {
        /*透過SessionFactory 取得 Session 實例*/
        SessionFactory sessionFactory;
        /*取得資料庫連線*/
        Session sess = null;
        List data = null;
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            sess = sessionFactory.openSession();
            Query query = sess.createQuery(HQL);
            data = query.list();
        } catch (HibernateException e) {
            System.out.println(e.toString());
        } finally {
            if (sess != null) {
                sess.close();
            }
        }
        return data;
    }
}
