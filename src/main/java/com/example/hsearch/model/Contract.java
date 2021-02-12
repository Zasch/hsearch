package com.example.hsearch.model;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.search.engine.backend.types.Searchable;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.IndexedEmbedded;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Indexed
public class Contract implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @FullTextField(searchable = Searchable.YES)
    private String contractNumber;

    @IndexedEmbedded(includeDepth = 1)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_number", referencedColumnName = "customer_number")
    private Customer customer;
}
