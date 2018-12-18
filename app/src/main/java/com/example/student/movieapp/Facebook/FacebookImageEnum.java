package com.example.student.movieapp.Facebook;

public enum FacebookImageEnum {
    Small("picture.type(small)"), Normal("picture.type(normal)"), Album("picture.type(album)"),
    Large("picture.type(large)"), Square("picture.type(square)");

    private String fieldName;

    FacebookImageEnum(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}