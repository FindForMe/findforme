package com.ffm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ffm.model.UserModel;
import com.ffm.util.FileUtil;
import com.ffm.util.ffmUtilMain;
import com.ffm_backend.dao.CategoryDAO;
import com.ffm_backend.dao.PostDAO;
import com.ffm_backend.dto.Category;
import com.ffm_backend.dto.Post;
import com.ffm_backend.util.ffmUtil;

@Controller
@RequestMapping("/manage")
public class ManageController {

	Logger logger = LoggerFactory.getLogger(ManageController.class);
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private PostDAO postDAO;
	
	@RequestMapping(value = "/post", method = RequestMethod.GET )
	public ModelAndView showManagePost(@RequestParam(name = "success" ,required = false)String success) {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","ManagePost");
		mv.addObject("userClickManagePost",true);
		//mv.addObject("categories",categoryDAO.list());
		Post nPost = new Post();
		nPost.setRowId(ffmUtil.genRowID());
		nPost.setCreated(ffmUtil.genCurrDateTime());
		nPost.setUserId(1);
		mv.addObject("post",nPost);
		
		if(success != null) {
			if(success.equals("post")) {
				mv.addObject("message","Post Update Successfully !");
			}
			else if(success.equals("category")) {
				mv.addObject("message","Category Added Successfully !");
			}
		}
		
		return mv;
	}
	@RequestMapping(value="/post", method = RequestMethod.POST)
	public String updatePost(@Valid @ModelAttribute("post") Post mPost,BindingResult result, Model model, HttpServletRequest request) {
		
		if(result.hasErrors()) {
			model.addAttribute("message","Validation failed for posting a post");
			model.addAttribute("userClickManagePost",true);
			return "page";
		}
		
		int userId = ffmUtilMain.getUserId(request);
		if(userId == 0) {
			model.addAttribute("message","Invalid User");
			model.addAttribute("userClickManagePost",true);
			return "page";
		}
		mPost.setUserId(userId);
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
	@ModelAttribute("category")
	public Category modelCategory() {
		return new Category();
	}
	
	
}
