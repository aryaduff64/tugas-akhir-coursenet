package com.subrutin.catalog.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "author")
//@DynamicUpdate
@SQLDelete(sql = "UPDATE author SET deleted = true WHERE id = ?")
@Where(clause = "deleted=false")
public class Author extends AbstractBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_generator")
    @SequenceGenerator(name = "author_generator", sequenceName = "author_id_seq",allocationSize = 1)
    private Long id;

    @Column(name = "author_name", nullable = false, columnDefinition = "varchar(300)")
    private String name;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;
}
