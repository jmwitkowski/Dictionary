package pl.jw.dictionary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.jw.dictionary.model.WordUsageCount;

import java.util.List;

public interface WordUsageCountRepository extends JpaRepository<WordUsageCount, Integer> {

    WordUsageCount findByWord(String word);

    @Query(value = "SELECT * FROM WORD_USAGE_COUNT ORDER BY USAGE_COUNT DESC", nativeQuery = true)
    List<WordUsageCount> getAllOrderedByUsageCountDesc();
}
