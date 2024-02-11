package ru.jucharick.NoteRestApplication.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.jucharick.NoteRestApplication.aspect.TrackUserAction;
import ru.jucharick.NoteRestApplication.domain.Note;
import ru.jucharick.NoteRestApplication.repository.NoteRepository;
import ru.jucharick.NoteRestApplication.service.NoteService;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {
    private final NoteRepository noteRepository;

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Note getNoteById(Long id) {
        return noteRepository.findById(id).orElseThrow(null);
    }

    @TrackUserAction
    @Override
    public Note updateNote(Long id, Note note) {
        Note noteById = getNoteById(id);
        noteById.setTitle(note.getTitle());
        noteById.setContent(note.getContent());
        return noteRepository.save(noteById);
    }

    @TrackUserAction
    @Override
    public Note createNote(Note note) {
        note.setCreateDate(LocalDateTime.now());
        return noteRepository.save(note);
    }

    @TrackUserAction
    @Override
    public void deleteNote(Long id) {
        Note noteById = getNoteById(id);
        noteRepository.delete(noteById);
    }
}
