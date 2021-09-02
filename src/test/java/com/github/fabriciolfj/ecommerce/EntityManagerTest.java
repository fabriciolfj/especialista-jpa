package com.github.fabriciolfj.ecommerce;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerTest {

    private static EntityManagerFactory emf;
    protected EntityManager em;

    @BeforeAll
    public static void Init() {
        emf = Persistence.createEntityManagerFactory("Ecommerce-PU");
    }

    @BeforeEach
    public void setup() {
        em = emf.createEntityManager();
    }

    @AfterEach
    public void close() {
        em.close();
    }

    @AfterAll
    public static void down() {
        emf.close();
    }

}
