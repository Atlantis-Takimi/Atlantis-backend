package com.atlantis.repository.Entry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import com.atlantis.model.Entry.Entry;

@Repository
public interface EntryRepository extends JpaRepository<Entry, String> {
    @Query("SELECT e FROM Entry e WHERE e.entryId=:id")
    Optional<Entry> findEntryByEntryId(String id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Entry e WHERE e.entryId=:id")
    void deleteEntryByEntryId(@Param("id") String id);

    boolean existsEntryByEntryId(String id);
}
