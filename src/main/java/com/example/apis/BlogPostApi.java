package com.example.apis;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.BlogDao;
import com.example.repository.BlogRepository;
import com.example.response.MessageResponse;
import com.example.response.SuperResponse;
import com.fasterxml.jackson.annotation.JsonRootName;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/blog")
@Produces(MediaType.APPLICATION_JSON)
public class BlogPostApi {
	
	@Autowired
	private BlogRepository blogPostRepository;

	@RequestMapping(method = RequestMethod.GET, value = "/all")
	@Consumes(MediaType.APPLICATION_JSON)
	public @ResponseBody List<BlogDao> getAllUsers() {
		return blogPostRepository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public  @ResponseBody SuperResponse createOrUpdate(@RequestBody BlogDao request) {
		BlogDao dao =new BlogDao();
		try{
		if(request!=null && request.getAuthor_id()!=null){
			dao.setArticle(request.getArticle());
			dao.getAuthor_id();
			dao.getBlog_user_id();
			dao.getTitle();
			dao.getTitle_clean();
			System.out.println("Root notation"+BlogDao.class.getAnnotation(JsonRootName.class).value());
			return blogPostRepository.save(request);
		}else{
			return new MessageResponse("could not save");
		}
		}catch (Exception e) {
			return new MessageResponse(" Exception"+e.getMessage());
			// TODO: handle exception
		}
		
	}
	
	
	
}