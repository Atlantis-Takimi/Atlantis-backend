package com.atlantis.service.Entry;

import com.atlantis.model.Entry.Entry;
import com.atlantis.model.Entry.EntryDetails;
import com.atlantis.repository.Entry.EntryDetailsRepository;
import com.atlantis.repository.Entry.EntryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EntryService {
    private final EntryRepository entryRepository;
    private final EntryDetailsRepository entryDetailsRepository;

    public EntryService(EntryRepository entryRepository,
                        EntryDetailsRepository entryDetailsRepository){
        this.entryRepository = entryRepository;
        this.entryDetailsRepository = entryDetailsRepository;
    }
    public List<Entry> getEntries(){
        return entryRepository.findAll();
    }

    public Optional<Entry> getEntry(String entryId){
        return entryRepository.findEntryByEntryId(entryId);
    }

    public void addNewEntry(Entry entry){
        Optional<Entry> entryExist = entryRepository.findEntryByEntryId(entry.getEntryId());
        if(entryExist.isPresent()){
            throw new IllegalStateException(
                    "There is already a Entry with the given id!");
        }
        entryRepository.save(entry);
        System.out.println(entry);
    }

    @Transactional
    public void deleteEntry(String entryId){
        boolean exist = entryRepository.existsEntryByEntryId(entryId);
        if(!exist){
            throw new IllegalStateException("Entry with entryId="+ entryId+" does not exist");
        }
        entryRepository.deleteEntryByEntryId(entryId);
    }

    @Transactional
    public void updateEntry(String entryId, Optional<String> entryTitle,
                            Optional<String> entryParent,
                            Optional<String> entryType,
                            Optional<String[]> entryTags,
                            Optional<String> entryCategory,
                            Optional<String> entryContent) {

        Entry entry = entryRepository.findEntryByEntryId(entryId).orElseThrow(()->
                new IllegalStateException("Entry with entryId="+ entryId+" does not exist"));
        EntryDetails entryDetails = entryDetailsRepository.findEntryDetailsByEntryId(entryId).orElseThrow(()->
                new IllegalStateException("Entry with entryId="+ entryId+" does not exist"));

        /*Entry table update*/
        entryTitle.ifPresent(entry::setEntryTitle);
        entryParent.ifPresent(entry::setEntryParent);
        entryType.ifPresent(entry::setEntryType);

        /*EntryDetails table update*/
        entryTags.ifPresent(entryDetails::setEntryTags);
        entryCategory.ifPresent(entryDetails::setEntryCategory);
        entryContent.ifPresent(entryDetails::setEntryContent);

    }

}
