package pl.jw.dictionary.service;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import pl.jw.dictionary.model.WordUsageCount;
import pl.jw.dictionary.repository.WordUsageCountRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class WordUsageCounterServiceTest {

    private WordUsageCountRepository wordUsageCountRepository = mock(WordUsageCountRepository.class);

    private WordUsageCounterService wordUsageCounterService = new WordUsageCounterServiceImpl(wordUsageCountRepository);


    ArgumentCaptor<WordUsageCount> wordUsageCountCaptor=ArgumentCaptor.forClass(WordUsageCount.class);

    @Test
    void shouldTryToCreateNewWordUsageCountIndDb() {
        String notExistedInDbWord = "test";
        when(wordUsageCountRepository.findByWord(notExistedInDbWord)).thenReturn(null);

        wordUsageCounterService.countWordUsage(notExistedInDbWord);
        verify(wordUsageCountRepository).saveAndFlush(wordUsageCountCaptor.capture());
        WordUsageCount captorValue = wordUsageCountCaptor.getValue();

        assertEquals(captorValue.getUsageCount(),1);
        assertEquals(captorValue.getWord(),notExistedInDbWord);
        assertEquals(captorValue.getId(),0);
    }

    @Test
    void shouldTryToSaveExistedInDbWordUsageCountWithIncreasedCountNumber() {
        String existedInDbWord = "test2";
        WordUsageCount wordUsageCountFromDb = new WordUsageCount(100,existedInDbWord,98);
        when(wordUsageCountRepository.findByWord(existedInDbWord)).thenReturn(wordUsageCountFromDb);

        wordUsageCounterService.countWordUsage(existedInDbWord);
        verify(wordUsageCountRepository).saveAndFlush(wordUsageCountCaptor.capture());
        WordUsageCount captorValue = wordUsageCountCaptor.getValue();

        assertEquals(captorValue.getUsageCount(),99);
        assertEquals(captorValue.getWord(),existedInDbWord);
        assertEquals(captorValue.getId(),100);
    }

}