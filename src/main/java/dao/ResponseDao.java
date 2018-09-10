package dao;

import entity.Response;
import java.util.List;

public interface ResponseDao {
    void addResponse(Response responses);
    List<Response> getResponsesAsAList();
}
