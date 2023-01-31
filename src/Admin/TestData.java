package Admin;

import ControllerPck.Controller;
import Pojo.Administrators;
import Pojo.Department;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestData {

    public static void main(String[] args) {
        Session session = Controller.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Department department = new Department();
        
        String sql = "From Department";
        Query query = session.createQuery(sql);
        
        List<Department> deptList = query.list();
        
        for (Iterator<Department> iterator = deptList.iterator(); iterator.hasNext();) {
            Department next = iterator.next();
            
            if (next.getId().equalsIgnoreCase("BTEC")) {
                System.out.println(next.getName());
            }
        }
        
 
        session.close();
        

            
            Administrators adm = new Administrators();
            adm.setId("adm002");
            adm.setName("A.R.P.Y.D. Amarasinghe");
            
            session.save(adm);
            transaction.commit();
       
    }
    
}
