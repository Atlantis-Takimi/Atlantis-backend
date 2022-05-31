package com.atlantis.jsonMapping;

import com.atlantis.model.University.Lesson;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class LessonDeserializer extends JsonDeserializer<Lesson> {
    @Override
    public Lesson deserialize(JsonParser j, DeserializationContext ctxt) throws IOException {
        JsonNode jsonNode = j.getCodec().readTree(j);

        String id = jsonNode.get("lessonId").asText();
        String name = jsonNode.get("lessonName").asText();

        SimpleDateFormat df = new SimpleDateFormat("yyyy");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));

        String dateStr = jsonNode.get("year").asText();
        Date year;
        try {
            year = df.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String term = jsonNode.get("term").asText();

        return new Lesson(id, name, year,term);
    }
}
