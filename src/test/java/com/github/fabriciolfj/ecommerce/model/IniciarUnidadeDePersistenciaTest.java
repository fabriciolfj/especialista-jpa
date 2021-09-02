package com.github.fabriciolfj.ecommerce.model;

import com.github.fabriciolfj.ecommerce.EntityManagerTest;
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

public class IniciarUnidadeDePersistenciaTest extends EntityManagerTest {

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

}
