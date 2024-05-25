package com.example.module_dev18_home_work.service;

import com.example.module_dev18_home_work.entity.Note;
import com.example.module_dev18_home_work.exceptions.NoteNotFoundException;
import com.example.module_dev18_home_work.repository.NoteRepository;
import com.example.module_dev18_home_work.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@Slf4j
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;


    public List<Note> listAll() {
        return noteRepository.findAll();
    }

    public Note ad(Note note) {
        return noteRepository.save(note);
    }

    public void deleteById(Long id) throws NoteNotFoundException {
        try {
            noteRepository.deleteById(id);
        } catch (Exception e) {
            throw new NoteNotFoundException(id);
        }
    }

    public void update(Note note)throws NoteNotFoundException {
        try {

            noteRepository.save(note);
        } catch (Exception e) {
            throw new NoteNotFoundException(note.getId());
        }
    }



    public Note getById(Long id) {
        return noteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(id + " for note - not found!"));
    }

    public List<Note> getUserNotes(String username) {

        return noteRepository.getUserNotes(username);
    }

}
