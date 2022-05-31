package com.atlantis.model.University;

import com.atlantis.jsonMapping.LessonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor

@Table(name = "lessons")
@Entity

@JsonDeserialize(using = LessonDeserializer.class)
public class Lesson {
    @Id
    @NonNull
    private String lessonId;
    @NonNull private String lessonName;
    private Date year;
    private String term;
    //private List<Teacher> teachers;

}