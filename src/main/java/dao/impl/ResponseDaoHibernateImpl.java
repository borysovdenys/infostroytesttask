package dao.impl;

import dao.ResponseDao;
import entity.Response;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utility.HibernateUtils;

import java.util.*;
import java.util.stream.Collectors;


public class ResponseDaoHibernateImpl implements ResponseDao {
    @Override
    public void addResponse(Response responses) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(responses);
        session.flush();
        transaction.commit();
    }

    public List<Response> getResponsesAsAList() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Response order by id");
        ArrayList<Response> listOfResponses = (ArrayList<Response>) query.getResultList();
        session.flush();
        transaction.commit();
        return listOfResponses;
    }
}
