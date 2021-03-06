package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import spittr.Spitter;
import spittr.data.SpitterRepository;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/spitter")
public class SpitterController {
	private SpitterRepository spitterRepository;
	
	@RequestMapping(value = "/register", method = GET)
	public String showRegistrationForm() {
		return "registerForm";
	}

	@RequestMapping(value = "/register", method = POST)
	public String processRegistration(Spitter spitter) {
		spitterRepository.addSpitter(spitter);
		return "redirect:/spitter/" + spitter.getUsername();
	}
	
	@RequestMapping(value ="/{username}", method = GET)
	public String showSpitterProfile(@PathVariable String username, Model model){
		Spitter spitter = spitterRepository.findByUsername(username);
		model.addAttribute(spitter);
		return "profile";
	}
	
	@Autowired
	public SpitterController(SpitterRepository spitterRepository){
		this.spitterRepository = spitterRepository;
		
	}

}
