package org.example;

import org.example.entity.Regions;
import org.example.entity.SalesReps;
import org.example.repository.sales_reps.SalesRepRepoImplementation;
import org.example.repository.sales_reps.SalesRepRepository;

public class HibernateApplication {

    public static void main(String[] args) {

        SalesRepRepository salesRep = new SalesRepRepoImplementation();

        SalesReps one = new SalesReps("James", new Regions(1L));
        salesRep.save(one);

    }
}
