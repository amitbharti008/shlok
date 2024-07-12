/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amit.sholoklogistics.services;

import com.amit.sholoklogistics.dao.PostDao;
import com.amit.sholoklogistics.model.PostModel;
import java.util.ArrayList;

/**
 *
 * @author Amit
 */
public class PostService {
        PostDao dao = new PostDao();
    
    public String insert(PostModel model){
        return dao.insert(model);
    }

    public ArrayList<PostModel> findAll() {
        return dao.findAll();
    }
   
    
     public String deletePost(String id){
        return dao.deletePost(id);
    }
}
