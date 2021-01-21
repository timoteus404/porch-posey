package org.example;

import org.hibernate.Session;

import javax.persistence.Persistence;

public class SessionManager {

    private static Session session;

    public SessionManager() {
    }

    public static synchronized Session getInstance() {

        if (session == null) {
            session = (Session)
                    Persistence.createEntityManagerFactory("org.example").createEntityManager().getDelegate();
        }
        return session;
    }
}
