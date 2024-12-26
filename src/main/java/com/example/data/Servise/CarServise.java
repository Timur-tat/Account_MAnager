package com.example.data.Servise;

import com.example.data.Entity.SingleTable.Car1;
import com.example.data.Entity.SingleTable.Car2;
import com.example.data.Entity.myUser;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServise {
    @PersistenceContext
    EntityManager entityManager;
    public  List<Car1> findBy1(String name, int speed){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Car1> cq = cb.createQuery(Car1.class);
        Root<Car1> root = cq.from(Car1.class);
        Predicate predicate = cb.equal(root.get(name), speed);
        cq.where(predicate);
        TypedQuery<Car1 > query = entityManager.createQuery(cq);
        return query.getResultList();
    }
    @Transactional
    public void addCar(int id, String name, int speed) {
        // Создаём хранимую процедуру
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("addcar2");

        // Устанавливаем параметры
        query.registerStoredProcedureParameter(1, Integer.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter(2, String.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter(3, Integer.class, jakarta.persistence.ParameterMode.IN);

        query.setParameter(1, id);
        query.setParameter(2, name);
        query.setParameter(3, speed);

        // Выполняем процедуру
        query.execute();

        System.out.println("Data inserted successfully!");
    }
    public  List<Car1> findBy2(String name1, int value1, String name2, String value2){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Car1> cq = cb.createQuery(Car1.class);
        Root<Car1> root = cq.from(Car1.class);
        Predicate predicate = cb.equal(root.get(name1), value1);
        Predicate predicate2 = cb.equal(root.get(name2), value2);
        Predicate combain1 = cb.or(predicate, predicate2);
        Predicate combain2 = cb.or(predicate, predicate2);
        cq.where(combain1);
        TypedQuery<Car1 > query = entityManager.createQuery(cq);
        return query.getResultList();
    }
    public void createCar( String name, int speed) {
        entityManager.getTransaction().begin();
        Car2 car = new Car2();
        car.setName(name);
        car.setSpeed(speed);
        entityManager.persist(car);
        entityManager.getTransaction().commit();
    }
    public void deleteCar( String name) {
        entityManager.getTransaction().begin();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaDelete<Car2> criteriaDelete = cb.createCriteriaDelete(Car2.class);
        Root<Car2> root = criteriaDelete.from(Car2.class);

        criteriaDelete.where(cb.equal(root.get("name"), name));
        entityManager.createQuery(criteriaDelete).executeUpdate();
        entityManager.getTransaction().commit();
    }

    public Car2 findCarByName( String name) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Car2> criteriaQuery = cb.createQuery(Car2.class);
        Root<Car2> root = criteriaQuery.from(Car2.class);

        criteriaQuery.select(root).where(cb.equal(root.get("name"), name));
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }
    public void updateCarSpeed(String name, int newSpeed) {
        entityManager.getTransaction().begin();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaUpdate<Car2> criteriaUpdate = cb.createCriteriaUpdate(Car2.class);
        Root<Car2> root = criteriaUpdate.from(Car2.class);

        criteriaUpdate.set(root.get("speed"), newSpeed);
        criteriaUpdate.where(cb.equal(root.get("name"), name));
        entityManager.createQuery(criteriaUpdate).executeUpdate();
        entityManager.getTransaction().commit();
    }

    @Transactional
    public Integer getCarsCount() {
        // Создаём вызов процедуры
        var storedProcedure = entityManager.createStoredProcedureQuery("COUNTCARS");

        // Регистрируем параметр как OUT
        storedProcedure.registerStoredProcedureParameter("cars_count", Integer.class, jakarta.persistence.ParameterMode.OUT);

        // Выполняем процедуру
        storedProcedure.execute();

        // Получаем результат из OUT параметра
        return (Integer) storedProcedure.getOutputParameterValue("cars_count");
    }
    @Transactional
    public void deleteCarById(Integer Id) {
        var storedProcedure = entityManager.createStoredProcedureQuery("DELETECARBYID");
        // Регистрируем параметр как IN
        storedProcedure.registerStoredProcedureParameter("id", Integer.class, jakarta.persistence.ParameterMode.IN);

        storedProcedure.setParameter("id", Id);
        // Выполняем процедуру
        storedProcedure.execute();
    }
    @Transactional
    public List<Car2> getCarsWithSpeedGreaterThan100() {
        var storedProcedure = entityManager.createStoredProcedureQuery("GETCARS_WITH_SPEED_GREATER_THAN_100", Car2.class);
storedProcedure.execute();
        return storedProcedure.getResultList();
    }
// НАПИСАТЬ ПРОЦЕДУРУ  С IF ELSE WHILE,
}

