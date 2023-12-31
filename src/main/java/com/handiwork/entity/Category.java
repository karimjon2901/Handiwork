package com.handiwork.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    private String id;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Translator name;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Translator description;
    @CreationTimestamp
    private LocalDateTime createdAt;
}