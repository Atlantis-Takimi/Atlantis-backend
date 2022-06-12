package com.atlantis.repository.Entry;

import com.atlantis.model.Entry.Entry;
import com.atlantis.model.Entry.EntryDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Map;
import java.util.Optional;

public interface EntryDetailsRepository extends JpaRepository<EntryDetails, String> {
    @Query("SELECT e FROM EntryDetails e WHERE e.entryDetailId=:id")
    Optional<EntryDetails> findEntryDetailsByEntryDetailId(String id);

    @Query("SELECT e.entryTitle from Entry e INNER JOIN EntryDetails ed where ed.entry.entryId =: id")
    String getEntryTitle(String id);

    @Query("SELECT e from Entry e INNER JOIN EntryDetails ed where ed.entry.entryId =: id")
    Optional<Entry> findEntryByEntryId(String id);

    @Query("SELECT e,ed from Entry e INNER JOIN EntryDetails ed where ed.entry.entryId =: id")
    Optional<Map> getJoinedDetailsByEntryId(String id);


}
