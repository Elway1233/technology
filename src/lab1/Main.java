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
//1 more time
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        FirstSecondName fsn = new FirstSecondName(session);
        List<Studentyi> students = fsn.quest1();
        for(Studentyi student : students){
            System.out.println(student.toString());
        }
        System.out.println();
        HashMap map = fsn.quest2();
        System.out.println(map);
        session.getTransaction().commit();
        //
    }
    
}
