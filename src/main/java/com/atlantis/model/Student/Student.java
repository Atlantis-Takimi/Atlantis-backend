package com.atlantis.model.Student;

import com.atlantis.model.University.Department;
import com.atlantis.model.University.Faculty;
import com.atlantis.model.University.Lesson;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.*;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonStringType.class),
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
public class Student implements Serializable {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "idStudent", nullable = false)
    private String idStudent;

    @NonNull private String studentNumber;
    @NonNull private String name;
    @NonNull private String surname;
    @NonNull private Integer grade;

    @NonNull private String facultyId;
    @NonNull private String departmentId;
    //    @Type( type = "json" )
//    @Column( columnDefinition = "json" )
//    @NonNull private List<Lesson> lessons;
    @ManyToMany(mappedBy = "enrolledStudents")
    private Set<Lesson> lessons = new HashSet<>();

    @Transient
    private Faculty faculty;
    @Transient
    private Department department;

}