package com.instagram.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.instagram.demo.dao.CommentDAO;
import com.instagram.demo.dto.CommentDTO;
import com.instagram.demo.vo.CommentVO;

@Controller
public class CommentController {

	
	@Autowired
	private CommentDAO commentDAO;
	
	@PostMapping("/commentlist")
	public @ResponseBody Object commentlist(String commentnumber) {
		System.out.println("comlist controller");
		List<CommentVO> commentVO = commentDAO.CommentImport(commentnumber);
		
		System.out.println(commentVO.toString());
		return commentVO;
	}
	
	
	@PostMapping("comment_insert")
	public @ResponseBody String commentinsert (CommentDTO commentdto) {
		
		System.out.println(commentdto.toString());
		
		commentDAO.commentinsert(commentdto);
		
		return "comment insert ok";
	}
}
