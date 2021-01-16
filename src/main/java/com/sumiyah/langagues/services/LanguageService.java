package com.sumiyah.langagues.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.sumiyah.langagues.models.Languages;
import com.sumiyah.langagues.repositories.LanguageRepository;

@Service
public class LanguageService {

	private LanguageRepository LangRepo;

	public LanguageService(LanguageRepository LanguageRepository) {
		this.LangRepo = LanguageRepository;
	}

	// returns all the books
	public List<Languages> allLanguages() {
		return LangRepo.findAll();
	}

	// creates a book
	public Languages createLanguage(Languages l) {
		return LangRepo.save(l);
	}

	// retrieves a book
	public Languages findLanguage(Long id) {
		Optional<Languages> optionalLanguage = LangRepo.findById(id);
		if (optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		} else {
			return null;
		}
	}

	public void deleteLanguage(Long id) {
		Optional<Languages> optionalBook = LangRepo.findById(id);
		if (optionalBook.isPresent()) {
			LangRepo.deleteById(id);
		}
	}

	public Languages updateLanguages(Long id, String name, String creator, String currentVersion) {
		
		Optional<Languages> optionalBook = LangRepo.findById(id);
		if (optionalBook.isPresent()) {
			optionalBook.map(target -> {
				target.setName(name);
				target.setCreator(creator);
				target.setCurrentVersion(currentVersion);
				LangRepo.save(target);

				return target;
			});
			return optionalBook.get();
		} else {
			return null;
		}
	}
	
	public Languages updateLanguage(Languages l) {
		return LangRepo.save(l);
	}
}
