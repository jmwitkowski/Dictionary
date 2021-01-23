package pl.jw.dictionary.service;

public interface TranslationService {
    /**
     * For given sentence return response with translated sentence
     * or with translated sentence with every words in quotes for wordsInQuotesMode true
     *
     * @param sentence sentence to translate
     * @param wordsInQuotesMode true if should response in wordsInQuotesMode
     * @return String with translation
     */
    String translate(String sentence, boolean wordsInQuotesMode);
}
