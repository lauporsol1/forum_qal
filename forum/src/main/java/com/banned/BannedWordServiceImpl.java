package com.banned;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class BannedWordServiceImpl implements BannedWordService{
	
	@Autowired
	private BannedWordRepository bwordRepository;

	@Override
	public List<BannedWord> getBannedWords() {
		return bwordRepository.getBannedWords();
	}

	@Override
	public BannedWord saveBannedWord(BannedWord bw) {
		return bwordRepository.save(bw);
	}

}
