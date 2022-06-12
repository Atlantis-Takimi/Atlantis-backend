package com.atlantis.controller.Entry;


import com.atlantis.model.Entry.Entry;
import com.atlantis.service.Entry.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/entry")
public class EntryController {
    private final EntryService entryService;
    @Autowired
    public EntryController(EntryService entryService){
        this.entryService = entryService;
    }
    @GetMapping
    public List<Entry> getAllEntries(){
        return entryService.getAllEntries();
    }

    @GetMapping(path = "{entryId}")
    public Entry getEntryById(@PathVariable("entryId") String entryId){
        return entryService.getEntry(entryId);

    }

    //TO - DO
//    @GetMapping(path = "{entryId}")
//    public List getJoinedEntryDetailsById(@PathVariable("entryId") String entryId,
//                                      @RequestParam(required = true) Boolean all){
//        if (all){
//            return entryService.getJoinedDetails(entryId);
//        }
//        return null;
//    }


}
