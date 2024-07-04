package at.javatraining;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class Translator_AT_DE implements Translator {
	private Map<String, String> vocabularies = Map.of(
		"servus", "hallo",   // key, value
		"grüß gott", "guten tag"
		// TODO add more translations here ;-)
	);
	
	@Override
	public boolean canTranslate(Language from, Language to) {
		return (from == Language.AUSTRIAN && to == Language.GERMAN);
	}

	@Override
	public String translate(String word) {
		return vocabularies.get(word);
	}
}