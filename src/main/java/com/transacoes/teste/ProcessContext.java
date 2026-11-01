package com.transacoes.teste;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public class ProcessContext {

    public Map<ContextVars, Object> attributes = new HashMap<>();

    public SoftReference<Object> getAttributes(ContextVars var) {
        return new SoftReference(attributes.get(var));
    }

    public void setAttributes(ContextVars var, Object object) {
        this.attributes.put(var, object);
    }
}
