package com.example.formexample.entities;

public enum Degree {
    BA("B.A."),
    BSC("B.Sc."),
    MA("M.A."),
    MSC("M.Sc."),
    PHD("Ph.D.");
    private final String label;

    Degree(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
