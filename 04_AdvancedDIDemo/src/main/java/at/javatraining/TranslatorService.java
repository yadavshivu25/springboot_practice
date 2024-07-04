package at.javatraining;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TranslatorService {
	@Autowired
	private List<Translator> translators;

	public Translator getTranslator(Language from, Language to) {
		for (Translator translator : translators) {
			if (translator.canTranslate(from, to)) {
				System.out.println("use " + translator.getClass().getSimpleName());
				return translator;
			}
		}
		
		throw new NoSuchElementException("can't get " + from + "-to-" + to + " translator: no suitable translator found");
	}
}
