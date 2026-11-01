package com.transacoes.teste;

public class Alias {
    public String name;
    public String phone;

    public Alias(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Alias{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
