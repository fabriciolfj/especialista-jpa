package com.github.fabriciolfj.ecommerce.util;

import com.github.fabriciolfj.ecommerce.model.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class IniciarUnidadeDePersistencia {

    public static void main(String[] args) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ecommerce-PU");
        final EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        final Produto produto = em.find(Produto.class, 1);
        System.out.println("Product: " + produto.getNome());

        em.close();
        emf.close();
    }
}
