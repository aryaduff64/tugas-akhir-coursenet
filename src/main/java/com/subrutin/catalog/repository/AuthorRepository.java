package com.subrutin.catalog.repository;

import com.subrutin.catalog.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    public Optional<Author> findById(Long id);

    public List<Author> findBySecureIdIn(List<String> authorIdList);

    public Optional<Author> findBySecureId(String id);

    public Optional<Author> findByIdAndDeletedFalse(Long id);

    public List<Author> findByNameLike(String authorName);
}
