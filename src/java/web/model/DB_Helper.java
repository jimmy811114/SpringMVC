/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.model;

import java.util.Iterator;
import java.util.List;
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
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        /*取得資料庫連線*/
        Session sess = sessionFactory.openSession();
        /*開啟一個會話操作*/
        Transaction tx = sess.beginTransaction();
        /*將 user 物件映射到資料庫中對應的表格儲存*/
        sess.save(data);
        tx.commit();
        sess.close();
    }

    //更新物件
    public static void updateData(Object data) {
        /*透過SessionFactory 取得 Session 實例*/
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        /*取得資料庫連線*/
        Session sess = sessionFactory.openSession();
        /*開啟一個會話操作*/
        Transaction tx = sess.beginTransaction();
        /*將 user 物件映射到資料庫中對應的表格儲存*/
        sess.update(data);
        tx.commit();
        sess.close();
    }

    //刪除物件
    public static void delData(Object data) {
        /*透過SessionFactory 取得 Session 實例*/
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        /*取得資料庫連線*/
        Session sess = sessionFactory.openSession();
        /*開啟一個會話操作*/
        Transaction tx = sess.beginTransaction();
        /*將 user 物件映射到資料庫中對應的表格儲存*/
        sess.delete(data);
        tx.commit();
        sess.close();
    }

    //取得物件
    public static Object getData(Class type, int id) {
        /*透過SessionFactory 取得 Session 實例*/
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        /*取得資料庫連線*/
        Session sess = sessionFactory.openSession();
        /*開啟一個會話操作*/
        Transaction tx = sess.beginTransaction();
        /*將 user 物件映射到資料庫中對應的表格儲存*/
        Object obj = sess.get(type, id);
        sess.close();
        return obj;
    }

    //取得物件_str
    public static Object getDataByStr(Class type, String id) {
        /*透過SessionFactory 取得 Session 實例*/
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        /*取得資料庫連線*/
        Session sess = sessionFactory.openSession();
        /*開啟一個會話操作*/
        Transaction tx = sess.beginTransaction();
        /*將 user 物件映射到資料庫中對應的表格儲存*/
        Object obj = sess.get(type, id);
        sess.close();
        return obj;
    }

    //取得物件
    public static Iterator getDataSet(String HQL) {
        /*透過SessionFactory 取得 Session 實例*/
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        /*取得資料庫連線*/
        Session sess = sessionFactory.openSession();
        Query query = sess.createQuery(HQL);
        /*開啟一個會話操作*/
        Transaction tx = sess.beginTransaction();
        List data = query.list();
        Iterator iterator = data.iterator();
        sess.close();
        return iterator;
    }
}
