package com.atlantis.model.Teacher;

import com.atlantis.model.Student.Student;
import lombok.NonNull;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class TeacherDetail {
    @OneToOne
    @JoinColumn(name = "idTeacher")
    @Column(name = "idTeacher", nullable = false)
    @NonNull
    private Teacher idTeacher;

    @Column(name="teacherBio")
    @Type(type="text")
    private String teacherBio;

    @Column(name="teacherBioImgPath")
    @Type(type="text")
    private String teacherBioImgPath;

    @Column(name="teacherSocialLink")
    @Type(type="text")
    private String teacherSocialLink;
}
