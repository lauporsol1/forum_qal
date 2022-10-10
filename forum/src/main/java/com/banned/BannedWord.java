package com.banned;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "banned_word")
public class BannedWord implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "word")
	private String word;

	@Column(name="banned_words")
	private List<BannedWord> bannedWords;

	public BannedWord() {

	}

	public BannedWord(Integer id, String word, List<BannedWord> bannedWords) {
		super();
		this.id = id;
		this.word = word;
		this.bannedWords = bannedWords;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}
	
	public List<BannedWord> getBannedWords() {
		return bannedWords;
	}

	public void setBannedWords(List<BannedWord> bannedWords) {
		this.bannedWords = bannedWords;
	}

}
