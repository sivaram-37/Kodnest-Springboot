package com.musichub.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.musichub.entity.Song;
import com.musichub.entity.User;
import com.musichub.model.LoginData;
import com.musichub.service.SongService;
import com.musichub.service.UserService;

import jakarta.servlet.http.HttpSession;

@CrossOrigin("*")
@RestController
public class UserController {

	@Autowired
	UserService userservice;
	@Autowired
	SongService songService;

	@PostMapping("/registered")
	public String adduser(@ModelAttribute User u) {
		
		String email = u.getEmail(); 
		boolean exist = userservice.isExist(email);
		
		if(!exist) {
			userservice.storeuser(u);	
		}
		else {
			System.out.println("User already exist");
		}
		return "login";
	}
	
	@PostMapping("/validate")
	public String validate(@RequestBody LoginData logindata,HttpSession session,Model model) {
		
		boolean b=userservice.validate(logindata.getEmail(),logindata.getPassword());
		if(b) {
			session.setAttribute("email", logindata.getEmail());
			String role = userservice.fetchRole(logindata.getEmail());
			if(role.equals("admin")) {
				return "adminhome";
			}
			else{
				User user = userservice.getUser(logindata.getEmail());
				boolean premiumStatus = user.getPremium();
				List<Song> fetchAllSongs=songService.viewAllSongs();
				model.addAttribute("songs", fetchAllSongs);
				model.addAttribute("ispremium", premiumStatus);
				return "customerhome";
			}
		}
		return "login";
	}
	
	@GetMapping("/logout")
	public String logoutUser(HttpSession session) {
		session.invalidate();
		return "login";
	}
	

}
