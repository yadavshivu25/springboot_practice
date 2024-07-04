package at.javatraining;

public interface Translator {
	boolean canTranslate(Language from, Language to);
	String translate(String word);
}
