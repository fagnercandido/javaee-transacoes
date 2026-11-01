package com.transacoes.teste;

import java.util.HashMap;
import java.util.Map;

public class Cach1 {
    public static Map<String, Alias> caching = new HashMap<>();
    static {
        caching.put("cach1-1", new Alias("kiko", "123"));
        caching.put("cach1-2", new Alias("goku", "777"));
        caching.put("cach1-3", new Alias("mr satan", "666"));
    }

    public static Alias getValueInCache(String key) {
        return caching.get(key);
    }

}
