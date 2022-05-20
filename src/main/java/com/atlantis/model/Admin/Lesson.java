package com.atlantis.model.Admin;

import com.atlantis.jsonMapping.LessonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;


@AllArgsConstructor
@Data
@JsonDeserialize(using = LessonDeserializer.class)
public class Lesson {
    private String lessonId;
    private String lessonName;
    private Date year;
    private String term;

}