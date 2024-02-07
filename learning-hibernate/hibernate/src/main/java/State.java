import com.hibernate.embed.Certificate;
import com.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class State {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        Student student = new Student();
        student.setName("Name 01");
        student.setCertificate(new Certificate(1, "SSC"));
        /* student in: Transient State */

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(student);
        /* student object in: Persistent State - session, database */
        student.setName("Name 01 - Changed in Persistent State");
        /* Changes reflect to database in this state */
        tx.commit();

        session.close();
        /* student in: Detached State */
        student.setName("Name 01 - Changed in Detached State");
        /* Changes not reflect to database in this state */

        /* if removed any row from database then goes to Removed State */

        factory.close();
    }
}
