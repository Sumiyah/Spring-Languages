package com.sumiyah.langagues.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sumiyah.langagues.models.Languages;
import com.sumiyah.langagues.services.LanguageService;

@Controller
public class LanguagesController {

	private final LanguageService LanguageService;

	public LanguagesController(LanguageService LangService) {
		this.LanguageService = LangService;
	}

	@RequestMapping("/")
	public String index(Model model) {
		List<Languages> languages = LanguageService.allLanguages();
		model.addAttribute("languages", languages);
		return "index.jsp";
	}
	
	@RequestMapping("/new")
	public String newLanguage(@ModelAttribute("language") Languages language) {
		return "new.jsp";
		}
	
	@RequestMapping("/{id}")
	public String Show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("language", LanguageService.findLanguage(id));
		return "show.jsp";
	}
	
	@RequestMapping(value = "/language", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("language") Languages language, BindingResult result) {
		if (result.hasErrors()) {
			return "new.jsp";
		} else {
			LanguageService.createLanguage(language);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/{id}/edit")
	public String Edit(@PathVariable("id") Long id, Model model) {
		model.addAttribute("language", LanguageService.findLanguage(id));
		return "edit.jsp";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public String Update(@Valid @ModelAttribute("language") Languages lang, BindingResult result) {
		if(result.hasErrors())
			return "edit.jsp";
		LanguageService.updateLanguage(lang);
		return "redirect:/";
	}
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public String Delete(@PathVariable("id") Long id) {
		LanguageService.deleteLanguage(id);
		return "redirect:/";
	}
}
