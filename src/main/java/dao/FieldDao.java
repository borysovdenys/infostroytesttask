package dao;

import entity.Field;

import java.util.List;

public interface FieldDao {
    List<Field> getFieldsAsAList();
    void addField(Field field);
    void deleteFieldFromDBById(int id);

    void updateField(Field field);
}
