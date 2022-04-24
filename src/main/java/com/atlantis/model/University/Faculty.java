package com.atlantis.model.University;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="faculties")
public class Faculty {
    @Id
    @NonNull private String facultyId;
    @NonNull private String facultyName;

}