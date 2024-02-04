package ru.jucharick.NoteRestApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.jucharick.NoteRestApplication.domain.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}
