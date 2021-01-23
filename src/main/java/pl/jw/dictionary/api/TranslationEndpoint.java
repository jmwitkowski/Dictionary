package pl.jw.dictionary.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.jw.dictionary.service.TranslationService;

@RestController
public class TranslationEndpoint {
    private TranslationService translationService;

    public TranslationEndpoint(TranslationService translationService) {
        this.translationService = translationService;
    }

    @GetMapping("/translate")
    public ResponseEntity getSentenceTranslation(@RequestParam(value = "sentence") String sentence,
                                                 @RequestParam(value = "wordsInQuoteMode", defaultValue = "false") boolean wordsInQuoteMode) {

        String translatedSentence = translationService.translate(sentence, wordsInQuoteMode);
        return ResponseEntity.ok(translatedSentence);
    }

}
