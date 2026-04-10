package com.bumptech.glide.util;

import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;

/* JADX INFO: compiled from: CachedHashCodeArrayMap.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b<K, V> extends ArrayMap<K, V> {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f13892s;

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public void clear() {
        this.f13892s = 0;
        super.clear();
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public int hashCode() {
        if (this.f13892s == 0) {
            this.f13892s = super.hashCode();
        }
        return this.f13892s;
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public V put(K k2, V v2) {
        this.f13892s = 0;
        return (V) super.put(k2, v2);
    }

    @Override // androidx.collection.SimpleArrayMap
    public void putAll(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        this.f13892s = 0;
        super.putAll(simpleArrayMap);
    }

    @Override // androidx.collection.SimpleArrayMap
    public V removeAt(int i2) {
        this.f13892s = 0;
        return (V) super.removeAt(i2);
    }

    @Override // androidx.collection.SimpleArrayMap
    public V setValueAt(int i2, V v2) {
        this.f13892s = 0;
        return (V) super.setValueAt(i2, v2);
    }
}
