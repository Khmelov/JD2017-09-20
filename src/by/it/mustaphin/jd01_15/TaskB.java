package by.it.mustaphin.jd01_15;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Имя класса
public class TaskB {

    StringBuilder sb = new StringBuilder();

    //Метод чтения сдержимого файла класса
    void readSrc() {
        String src = System.getProperty("user.dir") + "/src/by/it/mustaphin/jd01_15/TaskB.java";

        /**try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(src))))) {
         String line;
         while ((line = br.readLine()) != null) {
         sb.append(line);
         }
         } catch (FileNotFoundException e) {
         e.printStackTrace();
         } catch (IOException e) {
         e.printStackTrace();
         }*/

        //Новый более продвинутый способ читать файлы
        try {
            for (String line : Files.readAllLines(Paths.get(src))) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        removeComments();
    }

    void removeComments() {
        Pattern lineComent = Pattern.compile(Patterns.patLineComent);
        String newLine[] = sb.toString().split(Patterns.patMultiComent);
        sb.setLength(0);
        for (String line : newLine) {
            sb.append(line);
        }
        List<Integer[]> couple = new ArrayList<>();
        Matcher mat = lineComent.matcher(sb);
        while (mat.find()) {
            couple.add(new Integer[]{mat.start(), mat.end()});
        }
        Collections.reverse(couple);
        for (Integer[] twin : couple) {
            sb.delete(twin[0], twin[1]);
        }
        addLineNumbers();
        System.out.println(sb);
    }

    void addLineNumbers() {
        Pattern newLine = Pattern.compile("\\R");
        List<Integer> lines = new ArrayList<>();
        Matcher mat = newLine.matcher(sb);
        while (mat.find()) {
            lines.add(mat.start());
        }
        Collections.reverse(lines);
        int lineNumber = lines.size() + 2;
        for (Integer numb : lines) {
            sb.insert(numb + 1, getLineNumber(--lineNumber));
        }
        sb.insert(0, getLineNumber(1));
    }

    void writeToFile() {
        String out = System.getProperty("user.dir") + "/src/by/it/mustaphin/jd01_15/TaskB.txt";
        try (FileWriter fw = new FileWriter(new File(out))) {
            fw.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String getLineNumber(int lineNumber) {
        if (10 > lineNumber) {
            return "0" + String.valueOf(lineNumber);
        }
        return "" + lineNumber;
    }
}
