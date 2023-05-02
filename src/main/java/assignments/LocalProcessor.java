package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private String processorName;
    private Long period = 10_000_000_000_000L;
    private String processorVersion;
    private Integer valueOfCheap;
    private Scanner informationScanner;
    static List<String> stringLinkedList = new LinkedList<>();

    public LocalProcessor(String processorName, Long period, String processorVersion, Integer valueOfCheap,
                          Scanner informationscanner) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationscanner;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listIterator(LinkedList<String> stringList) {
        List<String> stringLinkedList = new LinkedList<>(stringList);
        for (int i = 0; i < period; i++) {
            System.out.println(stringLinkedList.get(i).hashCode());
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator(LinkedList<String> stringLinkedList) {
        StringBuilder stringBuilder = new StringBuilder(processorName);
        for (String str : stringLinkedList) {
            stringBuilder.append(str).append(" ");
        }
        processorName = stringBuilder.toString();
        return processorName;
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) throws FileNotFoundException {
        informationScanner = new Scanner(file);
        StringBuilder stringBuilder = new StringBuilder(processorVersion);
        while (informationScanner.hasNext()) {
            stringBuilder.append(informationScanner.nextLine());
        }
        processorVersion = stringBuilder.toString();
    }
}
