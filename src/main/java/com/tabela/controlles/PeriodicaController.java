package com.tabela.controlles;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tabela.model.Pages;
import com.tabela.repository.PeriodicaPagesRepository;

@Controller
public class PeriodicaController {

	@Autowired
	PeriodicaPagesRepository periodicaRepository;
	
	@RequestMapping(value = {"/","/elementos"}, method = RequestMethod.GET)
	public ModelAndView getPage() {
		ModelAndView mv = new ModelAndView("pages");
		List<Pages> pages = periodicaRepository.findAll();
		mv.addObject("pages",pages);
		return mv;
	}
	
	@RequestMapping(value = "/elementos/{id}", method = RequestMethod.GET)
	public ModelAndView getPageDetalis(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("pageDetalis");
		Pages page = periodicaRepository.getReferenceById(id);
		mv.addObject("page",page);
		return mv;
	}
	
	
	//Função de ADM
	
	@RequestMapping(value = "/newpage", method = RequestMethod.GET)
	public String getPageFormato() {
		
		return "pageFormato";
	}
	
	@RequestMapping(value = "/newpage", method = RequestMethod.POST)
	public String savePage(@Valid Pages page, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem","verifique se os campos obrigatorios foram preenchidos");
			return "redirect:/newpage";
		}
		periodicaRepository.save(page);
		return "redirect:/newpage";
	}
	
}
