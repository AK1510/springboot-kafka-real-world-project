package com.misterkourouma.trainings.springboot.model;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Builder
@Entity
@Table(name = "wikimedia_recentchange")
@NoArgsConstructor
@AllArgsConstructor
public class Wikimedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String wikiEventData;

}
