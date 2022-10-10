package com.banned;

import java.util.List;

public interface BannedWordService {

	public BannedWord saveBannedWord(BannedWord bw);

	List<BannedWord> getBannedWords();
	
}
