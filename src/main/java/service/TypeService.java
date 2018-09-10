package service;

import entity.Type;
import org.apache.log4j.Logger;

import javax.faces.bean.SessionScoped;
import java.util.Arrays;
import java.util.List;

@javax.faces.bean.ManagedBean
@SessionScoped
public class TypeService {

    private static final Logger LOGGER = Logger.getLogger(FieldService.class);

    private  List<Type> typeList = getListOfTypes();

    public List<Type> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<Type> typeList) {
        this.typeList = typeList;
    }

    public List<Type> getListOfTypes() {
        List<Type> types = Arrays.asList(Type.values());
        return types;
    }
}
