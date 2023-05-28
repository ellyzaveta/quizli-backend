package com.quizli.quizli.models;

import java.util.Objects;

public class Option {

    private String text;
    private boolean isCorrect;

    public Option(String text, boolean isCorrect) {
        this.text = text;
        this.isCorrect = isCorrect;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Option otherOption = (Option) obj;
        return Objects.equals(text, otherOption.text) && Objects.equals(isCorrect, otherOption.isCorrect);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, isCorrect);
    }
}

