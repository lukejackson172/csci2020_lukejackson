package sample;

import java.io.*;
import java.util.*;


public class WordCounter{

    private Map<String, Integer> wordCounts;

    public WordCounter(){
        wordCounts = new TreeMap<>();
    }

    public void parseFile(File file) throws IOException{
        System.out.println("Starting parsing the file:" + file.getAbsolutePath());
        String please="";

        if(file.isDirectory()){
            //parse each file inside the directory
            File[] content = file.listFiles();
            for(File current: content){
                parseFile(current);
            }
        }else{
            Scanner scanner = new Scanner(file);
            // scanning token by token
            while (scanner.hasNext()){
                please += scanner.next();
            }
            List<String> words = Arrays.asList(please.split(","));
            String[] work = words.toArray(new String[words.size()]);

            String[] weather = {"FLASHFLOOD", "SEVERETHUNDERSTORM", "SPECIALMARINE", "TORNADO"};
            List<String> weathers = Arrays.asList();


            for (int i=0; i<work.length; i++) {
                if (isValidWord(work[i])){
                    countWord(work[i]);
                }
            }
        }
    }


    private boolean isValidWord(String word){
        String[] weather = {"FLASHFLOOD", "SEVERETHUNDERSTORM", "SPECIALMARINE", "TORNADO"};
        List<String> weathers = Arrays.asList();
        // returns true if the word is composed by only letters otherwise returns false;
        return Arrays.stream(weather).anyMatch(word::equals);

    }

    private void countWord(String word){
        if(wordCounts.containsKey(word)){
            int previous = wordCounts.get(word);
            wordCounts.put(word, previous+1);
        }else{
            wordCounts.put(word, 1);
        }
    }


    public Map<String, Integer> getWordCounts() {
        return wordCounts;
    }


}
