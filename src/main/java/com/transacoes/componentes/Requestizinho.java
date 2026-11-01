package com.transacoes.componentes;

import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import java.util.HashMap;
import java.util.Map;

@RequestScoped
public class Requestizinho {

    private final Map<String, String> mapinha = new HashMap<>();

    public String getMapinha(String key) {
        return mapinha.get(key);
    }

    public void putMapinha(String key, String value) {
        mapinha.put(key, value);
    }

    public int getSizeMapinha() {
        return mapinha.size();
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Requestizinho destruido.");
        System.out.println("Mapinha size: " + mapinha.size());
    }
}
