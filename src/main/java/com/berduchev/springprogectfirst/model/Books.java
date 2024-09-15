package com.berduchev.springprogectfirst.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public  long id;
    public String Name;
    public String Author;
    public String Description;
    public int Articulation;

    @ManyToOne
    @JoinColumn(name = "book", nullable = false)
    BooksShelf bookshelf;
}
