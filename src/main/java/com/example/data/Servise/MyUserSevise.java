package com.example.data.Servise;

import com.example.data.Entity.myUser;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserSevise {
    @PersistenceContext
    EntityManager entityManager;
    public List<myUser> findBy(String fildName, String value){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<myUser> cq = cb.createQuery(myUser.class);
        Root<myUser> root = cq.from(myUser.class);
        Predicate predicate = cb.equal(root.get(fildName), value);
        cq.where(predicate);
        TypedQuery<myUser > query = entityManager.createQuery(cq);
        return query.getResultList();


    }
}
