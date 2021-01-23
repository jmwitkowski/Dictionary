package pl.jw.dictionary.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.jw.dictionary.model.WordUsageCount;
import pl.jw.dictionary.repository.WordUsageCountRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class WordUsageCounterServiceImpl implements WordUsageCounterService {
    private WordUsageCountRepository wordUsageCountRepository;

    @Override
    public List<WordUsageCount> getWordsUsageRanking() {
        return wordUsageCountRepository.getAllOrderedByUsageCountDesc();
    }

    @Transactional
    @Override
    public void countWordUsage(String translatedWord) {
        WordUsageCount wordUsageCount = wordUsageCountRepository.findByWord(translatedWord.toLowerCase());
        if (wordUsageCount == null) {
            WordUsageCount newWordUsageCount = new WordUsageCount(translatedWord.toLowerCase(), 1);
            wordUsageCountRepository.saveAndFlush(newWordUsageCount);
        } else {
            int currentUsageCount = wordUsageCount.getUsageCount();
            wordUsageCount.setUsageCount(currentUsageCount + 1);
            wordUsageCountRepository.saveAndFlush(wordUsageCount);
        }
    }
}
