package service;

import dao.impl.FieldDaoHibernateImpl;
import entity.Field;
import org.apache.log4j.Logger;
import java.util.List;


@javax.faces.bean.ManagedBean
public class FieldService {
    private static final Logger LOGGER = Logger.getLogger(FieldService.class);

    private FieldDaoHibernateImpl fieldDao = new FieldDaoHibernateImpl();

    private Field editableField;

    private  List<Field> fieldList = fieldDao.getFieldsAsAList();

    public List<Field> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<Field> fieldList) {
        this.fieldList = fieldList;
    }

    public Field getEditableField() {
        return editableField;
    }

    public void setEditableField(Field editableField) {
        this.editableField = editableField;
    }

    public String saveField(Field field) {
        System.out.println(field);
       fieldDao.addField(field);
       return "/fields?faces-redirect=true";
    }

    public String deleteFieldById(int id) {
        fieldDao.deleteFieldFromDBById(id);
        return "/fields?faces-redirect=true";
    }

    public String updateField(Field field) {
        fieldDao.updateField(field);
        return "/fields?faces-redirect=true";
    }


    public void editFieldById(int id) {
        editableField = fieldList.get(3);
    }
}
