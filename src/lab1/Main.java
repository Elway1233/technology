/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab1;

import entity.Gruppyi;
import entity.Studentyi;
import java.util.List;
import java.util.HashMap;
import org.hibernate.Query;
import org.hibernate.Session;
import utils.NewHibernateUtil;

/**
 *
 * @author 18753
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        FIO fio = new FIO(session);
        List<Studentyi> students = fio.fio1();
        for(Studentyi student : students){
            System.out.println(student.toString());
        }
        System.out.println();
        HashMap map = fio.fio2();
        System.out.println(map);
        session.getTransaction().commit();
        //
    }
    
}
