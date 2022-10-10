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
@Table(name = "bannedword")
public class BannedWord implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "word")
	private String word;

	public BannedWord() {

	}

	public BannedWord(Integer id, String word) {
		super();
		this.id = id;
		this.word = word;
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
	public static Integer getSpamInText(String txt, final List<BannedWord> spamWords) {
		final String str = txt.toLowerCase();
		for (final BannedWord s : spamWords) {
			if (txt.toLowerCase().contains(s.getWord().toLowerCase())) {
				txt = txt.toLowerCase().replaceAll(s.getWord().toLowerCase(), "");
			}
		}
		return str.length() - txt.toLowerCase().length();
	}
}
