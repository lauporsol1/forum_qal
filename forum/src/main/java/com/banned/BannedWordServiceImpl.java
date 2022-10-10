package com.banned;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BannedWordServiceImpl implements BannedWordService{
	
	@Autowired
	private BannedWordRepository bwordRepository;

	@Override
	public List<BannedWord> getBannedWords() {
		return (List<BannedWord>) bwordRepository.findAll();
	}

	@Override
	public BannedWord saveBannedWord(BannedWord bw) {
		return bwordRepository.save(bw);
	}

}
