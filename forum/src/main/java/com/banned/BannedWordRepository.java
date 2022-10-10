package com.banned;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BannedWordRepository extends CrudRepository<BannedWord, Integer> {

//	@Query("select bw.banned_words from BannedWord bw where bw.id = ?1")
//	List<BannedWord> getBannedWords();

	@Transactional
	void deleteById(Integer id);

	@Query("select a from BannedWord a")
	Collection<BannedWord> findBannedWord();
}
