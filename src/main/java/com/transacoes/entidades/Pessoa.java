package com.transacoes.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigInteger;
import java.util.*;

/**
 * The type Pessoa.
 */
@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String name;
    public Integer age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        Set<String> setinho = new HashSet<>(get());
        List<String> listinha = get();

        for (int i = 0; i < 5000; i++) {
            long start = System.nanoTime();
            boolean contains = setinho.contains(i * 22);
            System.out.println("Setinho: "+(System.nanoTime()-start));

            long start2 = System.nanoTime();
            boolean contains2 = listinha.contains(i * 22);
            System.out.println("Listinha: "+(System.nanoTime()-start2));

        }

    }

    private static List<String> get() {
        List<String> lista = new ArrayList<>();
        for (int i = 0; i < 5000; i++) {
            lista.add(""+i);
        }
        return lista;
    }

}
