package pl.jw.dictionary.service;

public interface TranslationService {
    /**
     *For given sentence return response with translated sentence
     *
     * @param sentence sentence to translate
     * @return String with translation
     */
    String translate(String sentence);
}
