package com.sda.taskmanagement.persistance.dao;

import com.sda.taskmanagement.persistance.model.Status;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class StatusDao {
    private Session session;
    private Transaction transaction;

    public void createStatus( Status status) {
        start();
        session.save(status);
        transaction.commit();
    }

    public void deleteStatus(Status status){
        start();
        session.delete(status);
        transaction.commit();
    }

    public List<Status> getAll(){
        start();
        Query query =  session.createQuery("from Status",Status.class);
        List<Status> list = query.getResultList();
        transaction.commit();
        return list;
    }

    public Status findById(int id){
        start();
        Status status = session.find(Status.class,id);
        transaction.commit();
        return status;
    }

    public void update(Status status){
        start();
        session.update(status);
        transaction.commit();
    }
    private void start() {
        SessionFactory sessionFactory = Config.getSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
    }




}
