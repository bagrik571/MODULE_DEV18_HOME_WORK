package com.example.module_dev18_home_work.controllers;

import com.example.module_dev18_home_work.entity.Note;
import com.example.module_dev18_home_work.exceptions.NoteNotFoundException;
import com.example.module_dev18_home_work.service.NoteService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@Controller
@RequestMapping("/note")
public class NoteController {

@Autowired
    private NoteService noteService;
@GetMapping("/list")
    public ResponseEntity<List<Note>> getList() {
    List<Note> notes = noteService.listAll();
    return ResponseEntity.ok(notes);
}


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteNoteById(@PathVariable Long id) {
        try {
            noteService.deleteById(id);
            return ResponseEntity.ok("Note deleted successfully");
        } catch (NoteNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/edit/{id}")
    public ResponseEntity<Note> getNoteForEdit(@PathVariable Long id) {
        Note note = noteService.getById(id);
        return ResponseEntity.ok(note);
    }


    @PutMapping("/edit/{id}")
    public ResponseEntity<String> editNote(
            @PathVariable Long  id,
            @RequestBody @NotNull Note note) {
        Note newNote = new Note();
        newNote.setId(id);
        newNote.setTitle(note.getTitle());
        newNote.setContent(note.getContent());
        try {
            noteService.update(newNote);
            return ResponseEntity.ok("Note updated successfully");
        }catch (NoteNotFoundException ex){
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/create")
    public ResponseEntity<String> createNote(@RequestBody Note newNote) {
        noteService.ad(newNote);
        return ResponseEntity.ok("Note created successfully");
    }
}
