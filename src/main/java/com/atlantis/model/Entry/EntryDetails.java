package com.atlantis.model.Entry;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "entry_details")
public class EntryDetails {

    @Id
    @Column(name = "entryDetailId", nullable = false)
    private String entryDetailId;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "entryDetails")
    private Entry entry;

    @NonNull private Integer replyCount;
    private String[] entryTags;
    private String entryCategory;
    @Column(name="entryContent")
    @Type(type="text")
    @NonNull private String entryContent;

}
