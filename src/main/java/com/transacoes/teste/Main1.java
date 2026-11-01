package com.transacoes.teste;

import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.Map;

public class Main1 {

    final static ProcessContext context = new ProcessContext();

    public static void main(String[] args){
      context.attributes.put(ContextVars.VAR1, "Cachorro Quente");
      context.attributes.put(ContextVars.VAR2, "Pizza");
      context.attributes.put(ContextVars.VAR3, "Feijoada");
      context.attributes.put(ContextVars.CACH1, Cach1.caching.get("cach1-1"));
      cleanContext();
      printContext();
      printCache();
    }

    private static void cleanContext() {
        //((Alias) context.getAttributes(ContextVars.CACH1)).phone = null;
        //((Alias) context.getAttributes(ContextVars.CACH1)).name = null;
        SoftReference<Object> attributes = context.getAttributes(ContextVars.CACH1);
        ((Alias)attributes.get()).name = null;
        ((Alias)attributes.get()).phone = null;
        System.out.println(context.attributes.get(ContextVars.CACH1).hashCode());
        System.out.println(Cach1.caching.get("cach1-1").hashCode());
        System.out.println(context.attributes.get(ContextVars.CACH1));
        System.out.println(attributes.get().hashCode());
    }

    private static void printContext() {
        System.out.println("BEGIN PRINT CONTEXT");
        for (Map.Entry<ContextVars, Object> entry : context.attributes.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        System.out.println("END PRINT CONTEXT");
    }

    private static void printCache() {
        System.out.println("BEGIN PRINT CACHE");
        for (Map.Entry<String, Alias> entry : Cach1.caching.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        System.out.println("END PRINT CACHE");
    }


}
