package teambravo.pipergames.Mikael;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.persistence.*;
import java.sql.SQLException;
import java.util.List;

public class PersonMain  {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");
    final ObservableList person = FXCollections.observableArrayList();
    public static void main(String[] args) throws SQLException {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try{
            transaction = entityManager.getTransaction();
            transaction.begin();
            Query query = entityManager.createNativeQuery("SELECT first_name FROM person");
            List<String> persons = query.getResultList();
            for(String item : persons){
                System.out.println(item);
            }
            transaction.commit();
        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally{
            entityManager.close();
        }

    }
}
