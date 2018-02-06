package com.ffm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffm_backend.dao.PostDAO;
import com.ffm_backend.daoImpl.PostDAOImpl;
import com.ffm_backend.dto.Post;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {

	//@Autowired
	PostDAO postDAO = new PostDAOImpl();
	
	@RequestMapping("/all/post")
	@ResponseBody
	public List<Post> getAllPost(){
		return postDAO.list();
	}
}
