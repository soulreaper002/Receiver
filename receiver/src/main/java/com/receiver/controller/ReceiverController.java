package com.receiver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.receiver.entity.Receiver;
import com.receiver.repository.ReceiverRepository;

@Controller
public class ReceiverController {

	@Autowired
	private ReceiverRepository receiverRepo;
	
	@GetMapping
	public String receiverHomepage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
	    model.addAttribute("receiver", new Receiver());
	     
	    return "signup_form";
	}
	
	@PostMapping("/process_register")
	public String processRegister(Receiver receiver) {
		/*BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);*/
		
		receiverRepo.save(receiver);
		
		return "register_success";
	}
	
	@GetMapping("/receiver")
	public String listUsers(Model model) {
		List<Receiver> listReceivers = receiverRepo.findAll();
		model.addAttribute("listReceivers", listReceivers);
		
		return "receivers";
	}
	
}
