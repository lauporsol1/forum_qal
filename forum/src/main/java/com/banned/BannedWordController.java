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

	@GetMapping("/bannedword")
	public String getBannedWords(Model model) {
		List<BannedWord> listBannedWords = bwordService.getBannedWords();
		model.addAttribute("listBannedWords", listBannedWords);
		return "bannedword";
	}

	@GetMapping("/bannedword/create")
	public String createBannedWord(Model model) {
		BannedWord bw = new BannedWord();
		model.addAttribute("bannedword", bw);
		return "create_bannedword";
	}

	@PostMapping("/process_create_bannedword")
	public String createBannedWordProcess(BannedWord bw) {
		bwordService.saveBannedWord(bw);
		return "redirect:/bannedword";
	}
}
