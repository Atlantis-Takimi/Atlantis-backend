package com.atlantis.model.Teacher;

import com.atlantis.model.University.Department;
import com.atlantis.model.University.Faculty;
import com.atlantis.model.University.Lesson;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "teachers")
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonStringType.class),
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
public class Teacher implements Serializable {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "idTeacher", nullable = false)
    @NonNull private String idTeacher;
    @NonNull private String teacherNumber;
    @NonNull private String name;
    @NonNull private String surname;

    @Type( type = "json" )
    @Column( columnDefinition = "json" )
    @NonNull
    private List<Lesson> lessons;
    @NonNull private String role;

    @Transient private Faculty faculty;
    @Transient private Department department;
}
