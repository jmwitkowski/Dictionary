package pl.jw.dictionary.service;

import pl.jw.dictionary.model.WordUsageCount;

import java.util.List;

public interface WordUsageCounterService {
    /**
     * Get list of words usage during translations, ranked from most frequently used words
     * @return list of words with their usage count
     */
    List<WordUsageCount> getWordsUsageRanking();

    /**
     * Record usage of word during translation
     * @param word to record usage
     */
    void countWordUsage(String word);
}
