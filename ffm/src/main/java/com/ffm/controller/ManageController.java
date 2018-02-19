package com.ffm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ffm.util.FileUtil;
import com.ffm_backend.dao.CategoryDAO;
import com.ffm_backend.dao.PostDAO;
import com.ffm_backend.dto.Category;
import com.ffm_backend.dto.Post;
import com.ffm_backend.util.ffmUtil;

@Controller
@RequestMapping("/manage")
public class ManageController {

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private PostDAO postDAO;
	
	@RequestMapping(value = "/post", method = RequestMethod.GET )
	public ModelAndView showManagePost() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","ManagePost");
		mv.addObject("userClickManagePost",true);
		//mv.addObject("categories",categoryDAO.list());
		Post nPost = new Post();
		nPost.setRowId(ffmUtil.genRowID());
		nPost.setCreated(ffmUtil.genCurrDateTime());
		nPost.setUserId(1);
		mv.addObject("post",nPost);
		
		return mv;
	}
	@RequestMapping(value="/post", method = RequestMethod.POST)
	public String updatePost(@ModelAttribute("post") Post mPost, Model model , HttpServletRequest request) {
		if(mPost.getId()==0) {
			postDAO.add(mPost);
		}else {
			postDAO.update(mPost);
		}
		//upload file
		
		if(!mPost.getFile().getOriginalFilename().equals("")) {
			FileUtil.uploadFile(request, mPost.getFile(), mPost.getCode());
		}
		return "redirect:/manage/post?success=post";
	}
	@RequestMapping(value = "/category", method=RequestMethod.POST)
	public String managePostCategory(@ModelAttribute("category") Category mCategory, HttpServletRequest request) {					
		categoryDAO.add(mCategory);		
		return "redirect:" + request.getHeader("Referer") + "?success=category";
	}
	
	
	@ModelAttribute("categories")
	public List<Category> getCategories(){
		return categoryDAO.list();
	}
}
