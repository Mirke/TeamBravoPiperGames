package teambravo.pipergames.Controllers;

import teambravo.pipergames.Nicolina.Staff;

import javax.persistence.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StaffController {

    static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");

    public static List<Staff> getAllStaffsPrinted() {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<Staff> allTeamQuery = entityManager.createQuery("from Staff", Staff.class);
            List<Staff> staffs = allTeamQuery.getResultList();
            for (Staff staff : staffs) {
                //System.out.println(staff);
            }
            transaction.commit();
            return staffs;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }

            }

