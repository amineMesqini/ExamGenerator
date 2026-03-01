package com.exam.model;

public class Option {

    private int id;
    private int questionId;
    private String texteOption;
    private boolean isCorrect;

    public Option() {}

    public Option(int questionId, String texteOption, boolean isCorrect) {
        this.questionId = questionId;
        this.texteOption = texteOption;
        this.isCorrect = isCorrect;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getQuestionId() { return questionId; }
    public void setQuestionId(int questionId) { this.questionId = questionId; }

    public String getTexteOption() { return texteOption; }
    public void setTexteOption(String texteOption) { this.texteOption = texteOption; }

    public boolean isCorrect() { return isCorrect; }
    public void setCorrect(boolean correct) { isCorrect = correct; }
}