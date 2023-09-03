package com.batuhan.stationer.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    private String name;

    @JsonBackReference
    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name="parent_category")
    private Category category;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Category> subCategories;

    @OneToMany(mappedBy="category")
    private List<Product> products;
}
