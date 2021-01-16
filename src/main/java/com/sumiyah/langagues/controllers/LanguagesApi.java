package com.sumiyah.langagues.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sumiyah.langagues.models.Languages;
import com.sumiyah.langagues.services.LanguageService;

@RestController
public class LanguagesApi {
	
	private final LanguageService LanguageService;
    public LanguagesApi(LanguageService LanguageService){
        this.LanguageService = LanguageService;
    }
    @RequestMapping("/api/languages")
    public List<Languages> index() {
        return LanguageService.allLanguages();
    }
    
    @RequestMapping(value="/api/languages", method=RequestMethod.POST)
    public Languages create(@RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="currentVersion") String currentVersion) {
    	Languages language = new Languages(name, creator, currentVersion);
        return LanguageService.createLanguage(language);
    }
    
    @RequestMapping("/api/languages/{id}")
    public Languages show(@PathVariable("id") Long id) {
    	Languages language = LanguageService.findLanguage(id);
        return language;
    }
    
//    @RequestMapping(value="/api/languages/{id}", method=RequestMethod.PUT)
    
//    public Languages update(@PathVariable("id") Long id, @RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="currentVersion") String currentVersion) {
//    	Languages language = LanguageService.updateLanguage(id, name, creator, currentVersion);
//        return language;
//    }
    
    @RequestMapping(value="/api/languages/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
    	LanguageService.deleteLanguage(id);
    }
}
