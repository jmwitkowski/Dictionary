package pl.jw.dictionary.service;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class TranslationServiceTest {

    private TranslationService translationService;

    @Test
    void shouldTranslateSentence()  {
        String translate = translationService.translate("Testowanie jest ważne");
        assertEquals(translate, "Testing is important");
    }
}