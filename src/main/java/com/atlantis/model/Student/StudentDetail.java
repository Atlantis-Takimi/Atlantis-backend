package com.atlantis.model.Student;

import lombok.NonNull;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class StudentDetail {
    @OneToOne
    @JoinColumn(name = "idStudent")
    @Column(name = "idStudent", nullable = false)
    @NonNull private Student idStudent;

    @Column(name="studentBio")
    @Type(type="text")
    private String studentBio;

    @Column(name="studentBioImgPath")
    @Type(type="text")
    private String studentBioImgPath;

    @Column(name="studentSocialLink")
    @Type(type="text")
    private String studentSocialLink;
}
