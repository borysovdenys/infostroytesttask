package service;


import dao.impl.ResponseDaoHibernateImpl;
import entity.Response;
import entity.Type;
import entity.UserInputDTO;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.event.ValueChangeEvent;
import java.util.*;
import java.util.stream.Collectors;

@ManagedBean
public class ResponseService {

    private ResponseDaoHibernateImpl responseDao = new ResponseDaoHibernateImpl();

    private  List<Response> responseList = responseDao.getResponsesAsAList();

    private List<List<Response>> answers;

    private Map<String, UserInputDTO> map = new HashMap<>();

    private List<String> questions;

    public List<String> getQuestions() {
        questions = new ArrayList<>(responseList.stream().map(Response::getQuestion).collect(Collectors.toSet()));
        System.out.println(questions);
        questions.sort(String::compareTo);
        return questions;
    }

    public void setQuestions(List<String> questions) {
        this.questions = questions;
    }

    public List<List<Response>>  getAnswers() {
        Map<Integer, List<Response>> collect;
        collect = responseList.stream().collect(Collectors.groupingBy(Response::getUid));
        collect.values().forEach(responsesList -> responsesList.sort(Comparator.comparing(Response::getQuestion)));

        answers = new ArrayList<>(collect.values());
        return answers;
    }

    public Map<String, UserInputDTO> getMap() {
        return map;
    }

    public void setMap(Map<String, UserInputDTO> map) {
        this.map = map;
    }

    public List<Response> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<Response> responseList) {
        this.responseList = responseList;
    }

    public void valueChangeMethod(ValueChangeEvent e) {
        String uid = String.valueOf(System.currentTimeMillis());
        uid = uid.substring(0,10);

        UIComponent component = e.getComponent();
        UserInputDTO DTO = new UserInputDTO();
        DTO.setLabel((String) component.getAttributes().get("myAttribute"));

        if(((String) e.getNewValue().toString()) == "") {
             DTO.setValue("N\\A");
        } else {
            DTO.setValue((String) e.getNewValue().toString());
        }
        DTO.setType((Type) component.getAttributes().get("type"));
        DTO.setUid(Integer.valueOf(uid));
        DTO.setRequired((Boolean) component.getAttributes().get("isRequired"));
        map.put(DTO.getLabel(), DTO);
    }

    public String onInputCompleted() {
        for (Map.Entry<String, UserInputDTO> entry : map.entrySet()) {
            Response response = new Response(entry.getKey(),entry.getValue().getValue(), entry.getValue().getUid());
            responseDao.addResponse(response);
        }
        return "/successPage?faces-redirect=true";
    }
}
