package com.atlantis.model.Entry;

import lombok.*;
import org.hibernate.annotations.Type;
import javax.persistence.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "entry_details")
public class EntryDetails {
    @ManyToOne
    @JoinColumn(name = "entryId")
    @Column(name = "entryId", nullable = false)
    @Id
    @NonNull private Entry entryId;

    @NonNull private Integer replyCount;
    @NonNull private String[] entryTags;
    @NonNull private String entryCategory;
    @Column(name="entryContent")
    @Type(type="text")
    @NonNull private String entryContent;

}
