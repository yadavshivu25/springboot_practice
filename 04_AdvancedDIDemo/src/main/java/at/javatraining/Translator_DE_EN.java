package at.javatraining;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class Translator_DE_EN implements Translator {
	private Map<String, String> vocabularies = Map.of(
		"hallo", "hello",
		"guten tag", "good day"
		// TODO add more translations here ;-)
	); 
	
	@Override
	public boolean canTranslate(Language from, Language to) {
		return (from == Language.GERMAN && to == Language.ENGLISH);
	}

	@Override
	public String translate(String word) {
		return vocabularies.get(word);
	}
}