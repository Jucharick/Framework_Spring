package ru.jucharick.NoteRestApplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.jucharick.NoteRestApplication.domain.Note;
import ru.jucharick.NoteRestApplication.service.NoteService;

import java.util.List;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;

    @GetMapping
    public ResponseEntity<List<Note>> getAll() {
        return new ResponseEntity<>(noteService.getAllNotes(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Note> createNote(@RequestBody Note Note) {
        return new ResponseEntity<>(noteService.createNote(Note), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Note> getNote(@PathVariable("id") Long id) {
        Note NoteById;
        try {
            NoteById = noteService.getNoteById(id);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Note());
        }
        return new ResponseEntity<>(NoteById, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @RequestBody Note Note) {
        return new ResponseEntity<>(noteService.updateNote(id, Note), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable("id") Long id){
        noteService.deleteNote(id);
        return ResponseEntity.ok().build();
    }
}
