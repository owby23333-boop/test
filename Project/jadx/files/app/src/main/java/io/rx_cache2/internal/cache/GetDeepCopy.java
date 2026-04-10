package io.rx_cache2.internal.cache;

import io.rx_cache2.internal.Memory;
import io.rx_cache2.internal.Persistence;
import io.victoralbertos.jolyglot.JolyglotGenerics;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes3.dex */
public final class GetDeepCopy extends Action {
    private final JolyglotGenerics jolyglot;

    @Inject
    public GetDeepCopy(Memory memory, Persistence persistence, JolyglotGenerics jolyglotGenerics) {
        super(memory, persistence);
        this.jolyglot = jolyglotGenerics;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> T getDeepCopyArray(T t2) {
        Object[] objArr = (Object[]) t2;
        if (objArr.length == 0) {
            return t2;
        }
        GenericArrayType genericArrayTypeArrayOf = this.jolyglot.arrayOf(objArr[0].getClass());
        return (T) this.jolyglot.fromJson(this.jolyglot.toJson(t2), genericArrayTypeArrayOf);
    }

    private <T> T getDeepCopyCollection(T t2) {
        Collection collection = (Collection) t2;
        if (collection.isEmpty()) {
            return t2;
        }
        Class<?> cls = t2.getClass();
        if (List.class.isAssignableFrom(cls)) {
            cls = List.class;
        }
        return (T) this.jolyglot.fromJson(this.jolyglot.toJson(t2), this.jolyglot.newParameterizedType(cls, collection.toArray()[0].getClass()));
    }

    private <T, K, V> T getDeepCopyMap(T t2) {
        Map map = (Map) t2;
        if (map.isEmpty()) {
            return t2;
        }
        Class<?> cls = map.values().toArray()[0].getClass();
        return (T) this.jolyglot.fromJson(this.jolyglot.toJson(t2), this.jolyglot.newParameterizedType(Map.class, map.keySet().toArray()[0].getClass(), cls));
    }

    private <T> T getDeepCopyObject(T t2) {
        if (t2 == null) {
            return t2;
        }
        ParameterizedType parameterizedTypeNewParameterizedType = this.jolyglot.newParameterizedType(t2.getClass(), new Type[0]);
        return (T) this.jolyglot.fromJson(this.jolyglot.toJson(t2), parameterizedTypeNewParameterizedType);
    }

    public <T> T deepCopy(T t2) {
        try {
            Class<?> cls = t2.getClass();
            return Collection.class.isAssignableFrom(cls) ? (T) getDeepCopyCollection(t2) : cls.isArray() ? (T) getDeepCopyArray(t2) : Map.class.isAssignableFrom(cls) ? (T) getDeepCopyMap(t2) : (T) getDeepCopyObject(t2);
        } catch (Exception unused) {
            return t2;
        }
    }
}
