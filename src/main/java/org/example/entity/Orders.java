package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders extends BaseEntity implements Serializable {

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Accounts accountId;

    private Integer standardQuantity;
    private Integer posterQuantity;
    private Integer glossyQuantity;
    private Integer total;
    @Column(name = "occurred_at")
    private String date;
    private Double standardAmount;
    private Double glossAmount;
    private Double posterAmount;
    private Double totalAmount;

}
