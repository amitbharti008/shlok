package com.amit.sholoklogistics.services;

import com.amit.sholoklogistics.dao.RequestDao;
import com.amit.sholoklogistics.model.RequestModel;
import java.util.ArrayList;

public class RequestService {
    RequestDao dao = new RequestDao();
    
    public String insert(RequestModel model){
        return dao.insert(model);
    }

    public ArrayList<RequestModel> findAll() {
        return dao.findAll();
    }
   
    
     public String deletePost(String id){
        return dao.deletePost(id);
    }
}
