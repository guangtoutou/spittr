package spittr.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import spittr.Spittle;
import spittr.data.SpittleRepository;

@Controller
public class SpittleController {
	private SpittleRepository spittleRepository;

	@Autowired
	public SpittleController(SpittleRepository spittleRepository) {
		this.spittleRepository = spittleRepository;

	}
/*
	@RequestMapping(method = RequestMethod.GET)
	public String spittles(Model model) {
		model.addAttribute(spittleRepository.findSpittles(Long.MAX_VALUE, 20));
		return "spittles";
	}
*/
	@RequestMapping(value = "/spittles.json", method = RequestMethod.GET)
	public @ResponseBody List<Spittle> listSpittles(@RequestParam("name") String name) {
		List<Spittle> spittles = spittleRepository.findSpittles(Long.MAX_VALUE, 20);
		return spittles;
	}
}