package com.instagram.demo.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.instagram.demo.dao.BookmarkDAO;
import com.instagram.demo.dao.FeedDAO;
import com.instagram.demo.dao.LikeDAO;
import com.instagram.demo.dto.BookmarkDTO;
import com.instagram.demo.dto.FeedDTO;
import com.instagram.demo.dto.LikeDTO;
import com.instagram.demo.dto.LoginDTO;
import com.instagram.demo.vo.BookmarkVO;
import com.instagram.demo.vo.FeedVO;
import com.instagram.demo.vo.LikeVO;
import com.instagram.demo.vo.LoginVO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class FeedController {

	private static final LikeVO likevo = null;

	@Autowired
	private FeedDAO feedDAO;
	
	@Autowired
	private LikeDAO likeDAO;
	
	@Autowired
	private BookmarkDAO bookmarkDAO;

	@RequestMapping("/feed_screen")
	public String mapper(LoginDTO loginDTO, FeedDTO feedDTO, HttpServletRequest response, Model model) {
		jakarta.servlet.http.HttpSession session = response.getSession();
		UUID Feed_token = UUID.randomUUID();
		session.setAttribute("Feed_token", Feed_token);

		if (session.getAttribute("login_token") == null) {
			return "redirect:/instagram";
		} else {
			try {
				LoginVO loginuser = (LoginVO) session.getAttribute("loginvo");
				System.out.println("loginvo: " + loginuser.getAccount());
				feedDTO.setAccount(loginuser.getAccount());
				List<FeedVO> feedVO = feedDAO.FeedImport(loginuser.getAccount());
				
				model.addAttribute("feedVO", feedVO);
				System.out.println("feedVO list: " + feedVO.toString());
				return "insta_screen";
			} catch (Exception e) {
				System.out.println("error message: " + e.getMessage());
				return "redirect:/instagram";
			}

		}
	}

	@RequestMapping(value = "/feed_upload_pop")
	public String feedupload() {
		return "/popup/Feed_upload_pop";
	}

	@PostMapping(value = "/feed_upload")
	public void feed_upload(@RequestParam MultipartFile FeedFile, HttpServletRequest requset, FeedDTO feedDTO) {
		jakarta.servlet.http.HttpSession session = requset.getSession();
		UUID random_name = UUID.randomUUID();
		LoginVO user = (LoginVO) session.getAttribute("loginvo");
		System.out.println("loginvo: " + user.getAccount());

		String loginuser = user.getAccount();
		String uploadFolder = "C:\\Users\\User\\eclipse-workspace\\InstagramTest2\\src\\main\\resources\\static\\images\\Feed";

		File saveFile = new File(uploadFolder, loginuser + "_" + random_name + ".png");
		feedDTO.setPicture_address(loginuser + "_" + random_name + ".png");
		String filename = FeedFile.getOriginalFilename();
		System.out.println("getContentType: " + FeedFile.getContentType());
		feedDTO.setAccount(loginuser);
		System.out.println(feedDTO.toString());

		try {
			System.out.println(filename);
			FeedFile.transferTo(saveFile);
			System.out.println("feed upload test");
			feedDAO.FeedUpload(feedDTO);

		} catch (Exception e) {
			System.out.println("error message: " + e.getMessage());
		}
	}
	
	@PostMapping(value= "/likechk")
	@ResponseBody
	public List<LikeVO> likechk(String account) {
		
		System.out.println("feed_number: ");
		List<LikeVO> likevo = likeDAO.likelist(account);
		
		System.out.println(likevo.toString());
		
		return likevo;
	}
	
//	like and bookmark controller
	
	@PostMapping(value = "/likesubmit")
	@ResponseBody
	public String likesubmit(LikeDTO likedto) {
		try {
			System.out.println("likedto tostring: "+likedto.toString());
			
			likeDAO.Likein(likedto);			
			return "like ok";
		} catch (Exception e) {
			System.out.println("error message: " + e.getMessage());
		}	return "like error";
	}
	
	@PostMapping(value = "/likecancel")
	@ResponseBody
	public String likecancel(LikeDTO likedto) {
		try {
			System.out.println("likedto tostring: "+likedto.toString());
			
			likeDAO.Likeout(likedto);	
			return "like cacel ok";
		} catch (Exception e) {
			System.out.println("error message: " + e.getMessage());
		}	return "like error";
	}
	
	@PostMapping(value = "/bookmarksubmit")
	@ResponseBody
	public String bookmarksubmit(BookmarkDTO bookmarkdto) {
		try {
			System.out.println("bookmarkdto tostring: "+bookmarkdto.toString());
			
			bookmarkDAO.Bookmarkin(bookmarkdto);
			
			return "Bookmark ok";
		} catch (Exception e) {
			System.out.println("error message: " + e.getMessage());
		}	return "Bookmark error";
	}
	
	@PostMapping(value = "/bookmarkcancel")
	@ResponseBody
	public String bookmarkcancel(BookmarkDTO bookmarkdto) {
		try {
			System.out.println("bookmarkout dto tostring: "+bookmarkdto.toString());
			
			bookmarkDAO.Bookmarkout(bookmarkdto);
			return "Bookmark cacel ok";
		} catch (Exception e) {
			System.out.println("error message: " + e.getMessage());
		}	return "bookmarkdto error";
	}
	
	@PostMapping(value= "/bookmarkchk")
	@ResponseBody
	public List<BookmarkVO> bookmarkchk(String account) {
		
		System.out.println("bookmarkchk controller");
		List<BookmarkVO> bookmarkvo = bookmarkDAO.bookmarklist(account);
		
		System.out.println(bookmarkvo.toString());
		
		return bookmarkvo;
	}
}
