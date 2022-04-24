package com.atlantis.model.University;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lesson {

    private String lessonId;
    private String lessonName;
    private Date year;
    private String term;
    //private List<Teacher> teachers;

}