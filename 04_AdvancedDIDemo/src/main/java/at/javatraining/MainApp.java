package at.javatraining;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApp implements CommandLineRunner {
	@Autowired
	private TranslatorService translatorService;

	public static void main(String[] args) {
		SpringApplication.run(MainApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Translator translator = translatorService.getTranslator(Language.AUSTRIAN, Language.GERMAN);
		System.out.println(
				translator.translate("servus")
		);
		try {
			translatorService.getTranslator(Language.AUSTRIAN, Language.FRENCH);
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
