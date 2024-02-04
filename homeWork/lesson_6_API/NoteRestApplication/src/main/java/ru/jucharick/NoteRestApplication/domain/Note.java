package ru.jucharick.NoteRestApplication.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "notes")
public class Note {
    /**
     * ID of the note
     * AUTO_INCREMENT
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * the title of the note
     *
     */
    @Column(nullable = false)
    private String title;;

    /**
     * the contents of the note
     *
     */
    @Column(nullable = false)
    private String content;

    /**
     * date the note was created
     */
    private LocalDateTime createDate;
}
