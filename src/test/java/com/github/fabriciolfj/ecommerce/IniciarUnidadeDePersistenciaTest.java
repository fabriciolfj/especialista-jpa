package com.github.fabriciolfj.ecommerce;

import com.github.fabriciolfj.ecommerce.model.Produto;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IniciarUnidadeDePersistenciaTest {

    private static EntityManagerFactory emf;
    private EntityManager em;

    @BeforeAll
    public static void Init() {
        emf = Persistence.createEntityManagerFactory("Ecommerce-PU");
    }

    @BeforeEach
    public void setup() {
        em = emf.createEntityManager();
    }

    @Test
    public void findProductSucess() {
        var product = em.find(Produto.class, 1);
        assertTrue(Objects.nonNull(product));
        assertEquals(product.getNome(), "Kindle");
    }

    @Test
    public void updateProduto() {
        var product = em.find(Produto.class, 1);
        product.setNome("Microfone");

        em.refresh(product);

        assertEquals("Kindle", product.getNome());
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
