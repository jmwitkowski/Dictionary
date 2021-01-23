package pl.jw.dictionary.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.jw.dictionary.service.TranslationService;

@RestController
public class TranslationEndpoint {
    private TranslationService translationService;

    @GetMapping("/translate")
    public ResponseEntity getSentenceTranslation(@RequestParam(value = "sentence") String sentence){
        String translatedSentence = translationService.translate(sentence);
        return ResponseEntity.ok(translatedSentence);
    }

}
