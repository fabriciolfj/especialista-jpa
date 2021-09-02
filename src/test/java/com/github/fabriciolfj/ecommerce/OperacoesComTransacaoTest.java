package com.github.fabriciolfj.ecommerce;

import com.github.fabriciolfj.ecommerce.model.Produto;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class OperacoesComTransacaoTest extends EntityManagerTest {

    @Test
    public void abrirEFecharTransacao() {
        final Produto produto = new Produto();

        em.getTransaction().begin();

        em.getTransaction().commit();
    }

    @Test
    public void removeRegistro() {
        final Produto produto = em.find(Produto.class, 3);

        em.getTransaction().begin();

        em.remove(produto);

        em.getTransaction().commit();

        final Produto prod = em.find(Produto.class, 3);

        assertNull(prod);
    }

    @Test
    public void inserirOPrimeiroObjeto() {
        final Produto produto = new Produto();
        produto.setNome("Camera canon");
        produto.setDescricao("A melhor definicao para suas fotos");
        produto.setPreco(new BigDecimal(1000));

        em.getTransaction().begin();
        em.persist(produto);
        em.getTransaction().commit();

        em.clear();

        Produto prd = em.find(Produto.class, produto.getId());

        assertNotNull(prd);
    }
}
