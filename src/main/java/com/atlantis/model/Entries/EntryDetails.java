package com.atlantis.model.Entries;

import lombok.NonNull;
import org.hibernate.annotations.Type;

import javax.persistence.Column;

public class EntryDetails {
    @Column(name = "entryId", nullable = false)
    @NonNull private String entryId;
    @NonNull private Integer replyCount;
    @NonNull private String[] entryTags;
    @NonNull private String entryCategory;
    @Column(name="entryContent")
    @Type(type="text")
    @NonNull private String entryContent;

}
