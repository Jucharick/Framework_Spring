package ru.jucharick.NoteRestApplication;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

import org.mockito.junit.jupiter.MockitoExtension;
import ru.jucharick.NoteRestApplication.domain.Note;
import ru.jucharick.NoteRestApplication.exceptions.NoteNotFoundException;
import ru.jucharick.NoteRestApplication.repository.NoteRepository;
import ru.jucharick.NoteRestApplication.service.impl.NoteServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@ExtendWith(MockitoExtension.class)
public class NoteServiceUnitTests {
    @Mock
    private NoteRepository noteRepository;

    @InjectMocks
    private NoteServiceImpl noteService;

    @Test
    public void getNoteByIdHappyFlow(){
        // pre
        LocalDateTime dateTime = LocalDateTime.now();
        Note note = new Note(1L,"Test", "TestTest", dateTime);
        long expectedId = note.getId();

        when(noteRepository.findById(expectedId)).thenReturn(Optional.of(note));

        // action
        Note expectedNote = noteService.getNoteById(expectedId);

        // check
        assertEquals(expectedNote.getTitle(), note.getTitle());
        assertEquals(expectedNote.getContent(), note.getContent());

        verify(noteRepository).findById(expectedId);
    }

    @Test
    public void getAllNotesHappyFlow(){
        // pre
        LocalDateTime dateTime = LocalDateTime.now();
        List<Note> dataNotes = new ArrayList<>();
        Note note1 = new Note(1L,"Test1", "Test1Test1", dateTime);
        Note note2 = new Note(2L,"Test2", "Test2Test2", dateTime);
        dataNotes.add(note1);
        dataNotes.add(note2);

        when(noteRepository.findAll()).thenReturn(dataNotes);

        // action
        List<Note> expectedNotes = noteService.getAllNotes();

        // check
        assertEquals(expectedNotes, dataNotes);

        verify(noteRepository).findAll();
    }

    @Test
    public void getNoteByIdNotFoundFlow() {
        // pre
        LocalDateTime dateTime = LocalDateTime.now();
        Note note = new Note(1L,"Test", "TestTest", dateTime);
        long expectedId = note.getId();

        given(noteRepository.findById(expectedId))
                .willReturn(Optional.empty());

        // action
        assertThrows(NoteNotFoundException.class,
                     () -> noteService.getNoteById(expectedId)
        );

        // check
        verify(noteRepository).findById(expectedId);
    }

    @Test
    public void createNoteHappyFlow() {
        // pre
        LocalDateTime dateTime = LocalDateTime.now();
        Note note = new Note(1L,"Test", "TestTest", dateTime);
        long expectedId = note.getId();

        when(noteRepository.save(note)).thenReturn(note);

        // action
        Note expectedNote = noteService.createNote(note);

        // check
        assertEquals(expectedNote,note);

        verify(noteRepository).save(note);
    }

    @Test
    public void updateNoteHappyFlow() {
        // pre
        LocalDateTime dateTime = LocalDateTime.now();
        Note noteTest = new Note(1L,"Test", "TestTest", dateTime);
        long expectedId = noteTest.getId();

        Note noteById = new Note(expectedId, "OldTest", "OldTestOldTest", dateTime);

        when(noteRepository.findById(expectedId)).thenReturn(Optional.of(noteById));
        when(noteRepository.save(noteById)).thenReturn(noteById);

        // action
        Note expectedNote = noteService.updateNote(expectedId, noteTest);

        // check
        assertEquals(expectedNote.getTitle(), noteTest.getTitle());
        assertEquals(expectedNote.getContent(), noteTest.getContent());

        verify(noteRepository).findById(expectedId);
        verify(noteRepository).save(noteById);
    }

    @Test
    public void deleteNoteHappyFlow() {
        // pre
        LocalDateTime dateTime = LocalDateTime.now();
        Note noteById = new Note(1L,"Test", "TestTest", dateTime);
        long expectedId = noteById.getId();

        when(noteRepository.findById(expectedId)).thenReturn(Optional.of(noteById));

        // action
        noteService.deleteNote(expectedId);

        // check
        verify(noteRepository).findById(expectedId);
        verify(noteRepository).delete(noteById);
    }

//    @Override
//    public void deleteNote(Long id) {
//        Note noteById = getNoteById(id);
//        noteRepository.delete(noteById);
//    }
}
