package com.sumiyah.langagues.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sumiyah.langagues.models.Languages;

@Repository
public interface LanguageRepository extends CrudRepository <Languages, Long>{
	 // this method retrieves all the languages from the database
    List<Languages> findAll();

}
