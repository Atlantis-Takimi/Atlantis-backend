package com.atlantis.model.University;

import com.atlantis.jsonMapping.LessonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@JsonDeserialize(using = LessonDeserializer.class)
public class Lesson {

    @NonNull
    private String lessonId;
    @NonNull private String lessonName;
    private Date year;
    private String term;
    //private List<Teacher> teachers;

}