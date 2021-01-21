package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "web_events")
public class WebEvents extends BaseEntity implements Serializable {

    @OneToMany(targetEntity = Accounts.class, mappedBy = "accountId",
            cascade = CascadeType.ALL)
    private List<Accounts> accountId;

    @Column(name = "occurred_at")
    private String date;

    @Column
    private String channel;


}
