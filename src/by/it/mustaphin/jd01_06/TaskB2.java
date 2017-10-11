package by.it.mustaphin.jd01_06;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TaskB2 {

    void seekLengthParts(String text) {
	List<Sense> allText = new ArrayList<>();
	String oneLine = text.replace("\n", " ");
	Pattern patPunct = Pattern.compile("[а-яА-ЯёЁ:,; -]+[\\.!]{1,}");
	Matcher mat = patPunct.matcher(oneLine);
	while (mat.find()) {
	    allText.add(new Sense(mat.group()));
	}
	Sense[] senses = new Sense[allText.size()];
	senses = allText.toArray(senses);
	for (int i = senses.length - 1; i >= 0; i--) {
	    for (int j = 0; j < i; j++) {
		if (senses[j].wordsCount() > senses[j + 1].wordsCount()) {
		    Sense swap = senses[j + 1];
		    senses[j + 1] = senses[j];
		    senses[j] = swap;
		}
	    }
	}
	for (Sense sense : senses) {
	    System.out.println(sense.data);
	}
    }
}
