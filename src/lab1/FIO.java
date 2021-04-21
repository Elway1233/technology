/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab1;

import entity.Gruppyi;
import entity.Studentyi;
import java.util.HashMap;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author 18753
 */
public  class FIO {
    
    private Session session;
    
    public FIO(Session session){
        this.session = session;
    }
    
    public List<Studentyi> task1(){
        String sql = "from Studentyi s";
        Query query = session.createQuery(sql);
        
        List<Studentyi> rows = query.list();
        return rows;
    }
    
    public HashMap task2(){
        String sq1 = "from Gruppyi g";
        Query query = session.createQuery(sq1);
        
        List<Gruppyi> rowsg = query.list();
        HashMap m = new HashMap();
        for(Gruppyi row : rowsg){
            sq1 = "from Studentyi s where s.gruppyi.shifr = :param";
            query = session.createQuery(sq1);
            query.setParameter("param", row.getShifr());
            List<Studentyi> rows = query.list();
            String[] words = row.getNazvanie().split( "-");
            if(m.containsKey(words[0])){
                int amount = (int)m.get(words[0]);
                m.remove(words[0]);
                m.put(words[0], rows.size() + amount);
            } else if(words.length != 0) m.put(words[0], rows.size());
        }
        return m;
    }
}
