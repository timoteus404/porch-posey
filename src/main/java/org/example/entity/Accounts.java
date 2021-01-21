package org.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor

@Table(name = "accounts")
public class Accounts extends BaseEntity implements Serializable {

    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @Column(name = "website", unique = true, nullable = false)
    private String website;
    @Column(name = "latitude", unique = true, nullable = false)
    private Double lat;
    @Column(name = "longitude", unique = true, nullable = false)
    private Double lon;
    @Column(name = "primary_poc", unique = true, nullable = false)
    private String primaryPerson;

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private WebEvents accountId;

    @ManyToOne
    @JoinColumn(name = "sales_rep_id", referencedColumnName = "id")
    private SalesReps salesReps;

    @OneToMany(targetEntity = Orders.class, mappedBy = "accountId",
            cascade = CascadeType.ALL)
    private List<Orders> orders;

    public Accounts(String name, String website, Double lat, Double lon, String primaryPerson, SalesReps salesReps, WebEvents accountId, List<Orders> orders) {
        this.name = name;
        this.website = website;
        this.lat = lat;
        this.lon = lon;
        this.primaryPerson = primaryPerson;
        this.salesReps = salesReps;
        this.accountId = accountId;
        this.orders = orders;
    }

    public Accounts(String name, String website, Double lat, Double lon, String primaryPerson, SalesReps salesReps) {
        this.name = name;
        this.website = website;
        this.lat = lat;
        this.lon = lon;
        this.primaryPerson = primaryPerson;
        this.salesReps = salesReps;
    }
}
