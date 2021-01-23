package pl.jw.dictionary.utils;


import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import pl.jw.dictionary.exception.DictionaryValueTypeException;
import pl.jw.dictionary.exception.NoDictionaryDetectedException;

import java.io.FileReader;
import java.util.Map;

@Component
public class DictionaryFromJsonFileProvider {

    public static final Map<String, String> DICTIONARY = provideDictionary();

    @SneakyThrows
    private static Map<String, String> provideDictionary() {
        String dictionaryFilePath = ".\\\\src\\\\main\\\\resources\\\\dictionary.json";
        Gson gson = new Gson();
        FileReader fileReader = new FileReader(dictionaryFilePath);
        JsonReader reader = new JsonReader(fileReader);
        Map<String, String> dictionary = gson.fromJson(reader, Map.class);
        if (dictionary == null || dictionary.isEmpty()) {
            throw new NoDictionaryDetectedException("Could not create dictionary from fie from path" + dictionaryFilePath);
        }
        if(dictionary.entrySet().stream().anyMatch(entry-> !(entry.getValue() instanceof String))){
            throw new DictionaryValueTypeException("One or more dictionary value is not string type in file: " + dictionaryFilePath);
        }
        return dictionary;
    }
}
