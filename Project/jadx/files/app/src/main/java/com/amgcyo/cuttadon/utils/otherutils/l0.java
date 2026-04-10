package com.amgcyo.cuttadon.utils.otherutils;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

/* JADX INFO: compiled from: SetterExclusionStrategy.java */
/* JADX INFO: loaded from: classes.dex */
public class l0 implements ExclusionStrategy {
    private String[] a;

    public l0(String[] strArr) {
        this.a = strArr;
    }

    @Override // com.google.gson.ExclusionStrategy
    public boolean shouldSkipClass(Class<?> cls) {
        return false;
    }

    @Override // com.google.gson.ExclusionStrategy
    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
        String[] strArr = this.a;
        if (strArr != null) {
            for (String str : strArr) {
                if (fieldAttributes.getName().equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }
}
