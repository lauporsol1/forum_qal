package com.banned;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BannedWordController {

	@Autowired
	private BannedWordServiceImpl bwordService;

	@GetMapping("/banned_words")
	public String getBannedWords(Model model) {
		List<BannedWord> listBannedWords = bwordService.getBannedWords();
		model.addAttribute("listBannedWords", listBannedWords);
		return "bannedWords";
	}

	@GetMapping("/banned_words/create")
	public String createBannedWord(Model model) {
		BannedWord bw = new BannedWord();
		model.addAttribute("banned_word", bw);
		return "create_banned_word";
	}

	@PostMapping("/process_create_banned_word")
	public String createBannedWOrdProcess(BannedWord bw) {
		bwordService.saveBannedWord(bw);
		return "redirect:/banned_words";
	}
}
