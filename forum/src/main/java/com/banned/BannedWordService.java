package com.banned;

import java.util.List;

public interface BannedWordService {

	public List<BannedWord> getBannedWords();
	public BannedWord saveBannedWord(BannedWord bw);
	
}
