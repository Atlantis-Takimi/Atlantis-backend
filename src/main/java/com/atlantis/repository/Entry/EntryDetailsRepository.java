package com.atlantis.repository.Entry;

import com.atlantis.model.Entry.EntryDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EntryDetailsRepository extends JpaRepository<EntryDetails, String> {
    @Query("SELECT e FROM EntryDetails e WHERE e.entryId=:id")
    Optional<EntryDetails> findEntryDetailsByEntryId(String id);
}
