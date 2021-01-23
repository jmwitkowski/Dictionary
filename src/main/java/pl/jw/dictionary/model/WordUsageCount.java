package pl.jw.dictionary.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WordUsageCount {
    @Id
    @GeneratedValue(generator = "wordUsageCountSeq")
    @SequenceGenerator(name = "wordUsageCountSeq", sequenceName = "wordUsageCount_Seq", allocationSize = 1)
    private int id;

    private String word;

    private int usageCount;

    public WordUsageCount(String word, int usageCount) {
        this.word = word;
        this.usageCount = usageCount;
    }
}
