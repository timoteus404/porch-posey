package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "region")
public class Regions extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "name")
    private String name;

    @OneToMany(targetEntity = SalesReps.class, mappedBy = "regionsId",
            cascade = CascadeType.ALL)
    private List<SalesReps> representativeList;

    public Regions(String name) {
        this.name = name;
    }

    public Regions(long l) {
        super(l);
    }
}
