package pl.jw.dictionary.service;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class TranslationServiceTest {

    private TranslationService translationService;

    @Test
    void shouldTranslateWord()  {
        String translate = translationService.translate("Testowanie");
        assertEquals(translate, "Testing");
    }

    @Test
    void shouldTranslateSentence()  {
        String translate = translationService.translate("Testowanie jest ważne");
        assertEquals(translate, "Testing is important");
    }

    @Test
    void shouldTranslateSentenceAndKeepPunctuation() {
        String translate = translationService.translate("Testowanie, jest ważne!");
        assertEquals(translate, "Testing, is important!");
    }
}