package dao.impl;

import dao.FieldDao;
import entity.*;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utility.HibernateUtils;

import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class FieldDaoHibernateImpl implements FieldDao {
    private static final Logger LOGGER = Logger.getLogger(FieldDaoHibernateImpl.class);

    public List<Field> getFieldsAsAList() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Field order by id");
        ArrayList<Field> listOfFields = (ArrayList<Field>) query.getResultList();
        session.flush();
        transaction.commit();
        return listOfFields;
    }

    @Override
    public void addField(Field field) {
            Session session = HibernateUtils.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(field);
            session.flush();
            transaction.commit();
        }

    public void deleteFieldFromDBById(int id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("delete from Field where id=:fieldId");
        query.setParameter("fieldId", id);
        query.executeUpdate();
        session.flush();
        transaction.commit();
    }

    @Override
    public void updateField(Field field) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("update Field set label=:fieldLabel,type=:fieldType,required=:fieldRequired,isActive=:fieldIsActive, options=:fieldOptions where id=:fieldId");
        query.setParameter("fieldId", field.getId());
        query.setParameter("fieldLabel", field.getLabel());
        query.setParameter("fieldType", field.getType());
        query.setParameter("fieldRequired", field.isRequired());
        query.setParameter("fieldIsActive", field.isActive());
        query.setParameter("fieldOptions", field.getOptions());
        query.executeUpdate();
        session.flush();
        transaction.commit();
    }


}
