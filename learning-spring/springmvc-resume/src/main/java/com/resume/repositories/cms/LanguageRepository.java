package com.resume.repositories.cms;

import com.resume.entities.cms.Language;

import java.util.List;

public interface LanguageRepository {

    List<Language> findAll();

    void save(Language language);

    Language findById(long id);

    void update(Language language);

    void delete(Language language);
}
