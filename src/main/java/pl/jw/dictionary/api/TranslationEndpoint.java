package pl.jw.dictionary.api;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.jw.dictionary.model.WordUsageCount;
import pl.jw.dictionary.service.TranslationService;
import pl.jw.dictionary.service.WordUsageCounterService;

import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
public class TranslationEndpoint {

    private TranslationService translationService;
    private WordUsageCounterService wordUsageCounterService;

    @ApiOperation(value = "Translate provided sentnece")
    @GetMapping("/translate")
    public ResponseEntity getSentenceTranslation(@RequestParam(value = "sentence") String sentence,
                                                 @RequestParam(value = "wordsInQuoteMode", defaultValue = "false") boolean wordsInQuoteMode) {
        log.info("Gathered request for translation of sentence: " + sentence);
        String translatedSentence = translationService.translate(sentence, wordsInQuoteMode);
        return ResponseEntity.ok(translatedSentence);
    }

    @ApiOperation(value = "Gather words usage during translation ranking")
    @GetMapping("/ranking")
    public ResponseEntity getWordsUsageRanking() {
        log.info("Gathered request for words usage ranking");
        List<WordUsageCount> usageRanking = wordUsageCounterService.getWordsUsageRanking();
        return ResponseEntity.ok(usageRanking);
    }

}