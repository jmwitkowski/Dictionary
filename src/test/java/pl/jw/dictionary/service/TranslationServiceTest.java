package pl.jw.dictionary.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.powermock.reflect.Whitebox;
import pl.jw.dictionary.utils.DictionaryFromJsonFileProvider;


import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class TranslationServiceTest {
    private DictionaryFromJsonFileProvider dictionaryFromJsonFileProvider = mock(DictionaryFromJsonFileProvider.class);

    private WordUsageCounterService wordUsageCounterService = mock(WordUsageCounterService.class);

    private TranslationService translationService = new TranslationServiceImpl(wordUsageCounterService);

    private Map<String, String> testDictionary = Map.of(
            "Testowanie", "Testing",
            "jest", "is",
            "ważne", "important",
            "śćźż", "Polish letters");

    @BeforeEach
    void setUp() {
        Whitebox.setInternalState(DictionaryFromJsonFileProvider.class, "DICTIONARY", testDictionary);
    }

    @Test
    void shouldTranslateWord()  {
        String translate = translationService.translate("Testowanie",false);
        assertEquals(translate, "Testing");
    }

    @Test
    void shouldTranslateSentence()  {
        String translate = translationService.translate("Testowanie jest ważne",false);
        assertEquals(translate, "Testing is important");
    }

    @Test
    void shouldTranslateSentenceAndKeepPunctuation() {
        String translate = translationService.translate("Testowanie, jest ważne!",false);
        assertEquals(translate, "Testing, is important!");
    }

    @Test
    void shouldTranslateWordStartedWithPolishLetter()  {
        String translate = translationService.translate("śćźż",false);
        assertEquals(translate, "Polish letters");
    }

    @Test
    void shouldTranslateWordInWordsInQuoteMode() {
        String translate = translationService.translate("Testowanie", true);
        assertEquals(translate, "'Testing'");
    }


    @Test
    void shouldTranslateSentenceInQuoteMode() {
        String translate = translationService.translate("Testowanie jest ważne", true);
        assertEquals(translate, "'Testing' 'is' 'important'");
    }


    @Test
    void shouldTranslateDespiteLetterCase() {
        String translate = translationService.translate("testowanie jESt WAżne", false);
        assertEquals(translate, "Testing is important");
    }

    @Test
    void shouldTranslateToWordNotFound() {
        String translate = translationService.translate("Słowa spoza słownika", false);
        assertEquals(translate, "|Słowa - not found in dictionary| |spoza - not found in dictionary| |słownika - not found in dictionary|");
    }
}