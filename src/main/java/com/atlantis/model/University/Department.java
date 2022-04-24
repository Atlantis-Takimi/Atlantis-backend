package com.atlantis.model.University;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="departments")
public class Department {
    @Id
    @NonNull private String departmentId;
    @NonNull private String departmentName;

}