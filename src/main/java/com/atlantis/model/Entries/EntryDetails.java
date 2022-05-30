package com.atlantis.model.Entries;

import lombok.NonNull;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class EntryDetails {
    @ManyToOne
    @JoinColumn(name = "entryId")
    @Column(name = "entryId", nullable = false)
    @NonNull private Entry entryId;
    @NonNull private Integer replyCount;
    @NonNull private String[] entryTags;
    @NonNull private String entryCategory;
    @Column(name="entryContent")
    @Type(type="text")
    @NonNull private String entryContent;

}
