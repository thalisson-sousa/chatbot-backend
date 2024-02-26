package com.kipper.museumchatbot.domain;

import java.util.List;

public class FaqAnswear {
    private List<String> keywords;
    private String answer;

    public List<String> getKeywords() {
        return keywords;
    }

    public String getAnswer() {
        return answer;
    }

    public FaqAnswear(List<String> keywords, String answer) {
        this.keywords = keywords;
        this.answer = answer;
    }
}
