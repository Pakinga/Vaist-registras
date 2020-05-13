package com.spring.vaistai.model;

import com.spring.vaistai.config.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class VaistaiDAOImpl implements VaistaiDAO{
        public void insertEntity(Vaistai vaistai){
            EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            entityManager.persist(vaistai);

            entityManager.getTransaction().commit();
            entityManager.close();
        }

        public Vaistai findEntityByID(int id){
            EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
            entityManager.getTransaction().begin();

            List<Vaistai> vaistai = entityManager
                    .createQuery("SELECT n FROM Vaistai n WHERE n.id = :id")
                    .setParameter("id", id)
                    .getResultList();

            entityManager.getTransaction().commit();
            entityManager.close();

            return vaistai.get(0);
        }

        public List<Vaistai> findEntities(){
            EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
            entityManager.getTransaction().begin();

            List<Vaistai> vaistai = entityManager
                    .createQuery("SELECT n FROM Vaistai n")
                    .getResultList();

            entityManager.getTransaction().commit();
            entityManager.close();
            return vaistai;
        }

        public void updateEntity(Vaistai vaistai) {
            EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
            entityManager.getTransaction().begin();

            Vaistai vaistai2 = entityManager.find(Vaistai.class, vaistai.getId());
            vaistai2.setVaistoPav(vaistai.getVaistoPav());
            vaistai2.setVaistuGrupe(vaistai.getVaistuGrupe());
            vaistai2.setVaistoForma(vaistai.getVaistoForma());
            vaistai2.setVeiklMedziaga(vaistai.getVeiklMedziaga());
            vaistai2.setMedziagosKiekis(vaistai.getMedziagosKiekis());

            entityManager.getTransaction().commit();
            entityManager.close();
        }

        public void removeEntityByID(int id) {
            EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
            entityManager.getTransaction().begin();

            Vaistai vaistai = entityManager.find(Vaistai.class, id);
            entityManager.remove(vaistai);

            entityManager.getTransaction().commit();
            entityManager.close();
        }
}
