package com.kipper.museumchatbot.services;

import com.kipper.museumchatbot.domain.FaqAnswear;
import com.kipper.museumchatbot.utils.FaqAnswers;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class FaqService {

    final private FaqAnswers faqAnswers = new FaqAnswers();

    public String getAnswear(String message) {
        String[] words = message.toLowerCase().split("\\s+");
        List wordsList = Arrays.asList(words).stream().map(String::toLowerCase).map(this::replaceForbiddenChar).toList();

        for (FaqAnswear entry : faqAnswers.getAnswers()) {
            for (String keyword : entry.getKeywords()) {
                if (wordsList.contains(keyword.toLowerCase())) {
                    return entry.getAnswer();
                }
            }
        }

        return faqAnswers.getDefaultAnswer();
    }

    public String replaceForbiddenChar(String question) {
        return question.replace("?", "").replace("?:", "").replace("/", "");
    }
}
