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
@Table(name = "sales_reps")
public class SalesReps extends BaseEntity implements Serializable {

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "region_id", referencedColumnName = "id")
    private Regions regionsId;


    @OneToMany(targetEntity = Accounts.class, mappedBy = "salesReps",
            cascade = CascadeType.ALL)
    private List<Accounts> accounts;


    public SalesReps(String name, Regions regions) {
        this.name = name;
        this.regionsId = regions;
    }
}
