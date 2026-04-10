package com.bytedance.sdk.openadsdk.ats;

import android.util.Pair;
import android.util.SparseArray;
import com.bytedance.sdk.component.a.kb;
import java.util.HashMap;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class gz implements kb, Function {
    private static HashMap<String, z> z = new HashMap<>();
    private kb g = new com.bytedance.sdk.openadsdk.ats.z.dl();

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == 1) {
            return get((String) sparseArray.get(1));
        }
        if (iIntValue == 2) {
            return Integer.valueOf(getInt((String) sparseArray.get(1)));
        }
        if (iIntValue == 3) {
            return Long.valueOf(getLong((String) sparseArray.get(1)));
        }
        if (iIntValue == 4) {
            return Boolean.valueOf(getBoolean((String) sparseArray.get(1)));
        }
        if (iIntValue != 5) {
            return null;
        }
        set((String) sparseArray.get(1), (String) sparseArray.get(2));
        return null;
    }

    private Pair<z, Boolean> z(String str) {
        z zVar = z.get(str);
        if (zVar == null) {
            z zVar2 = new z();
            z.put(str, zVar2);
            return new Pair<>(zVar2, Boolean.TRUE);
        }
        return new Pair<>(zVar, Boolean.FALSE);
    }

    @Override // com.bytedance.sdk.component.a.kb
    public String get(String str) {
        Pair<z, Boolean> pairZ = z(str);
        if (((Boolean) pairZ.second).booleanValue()) {
            ((z) pairZ.first).z = this.g.get(str);
        }
        return ((z) pairZ.first).z;
    }

    @Override // com.bytedance.sdk.component.a.kb
    public int getInt(String str) {
        Pair<z, Boolean> pairZ = z(str);
        if (((Boolean) pairZ.second).booleanValue()) {
            ((z) pairZ.first).g = this.g.getInt(str);
        }
        return ((z) pairZ.first).g;
    }

    @Override // com.bytedance.sdk.component.a.kb
    public long getLong(String str) {
        Pair<z, Boolean> pairZ = z(str);
        if (((Boolean) pairZ.second).booleanValue()) {
            ((z) pairZ.first).dl = this.g.getLong(str);
        }
        return ((z) pairZ.first).dl;
    }

    @Override // com.bytedance.sdk.component.a.kb
    public boolean getBoolean(String str) {
        Pair<z, Boolean> pairZ = z(str);
        if (((Boolean) pairZ.second).booleanValue()) {
            ((z) pairZ.first).f907a = this.g.getBoolean(str);
        }
        return ((z) pairZ.first).f907a;
    }

    @Override // com.bytedance.sdk.component.a.kb
    public void set(String str, String str2) {
        this.g.set(str, str2);
    }

    private static final class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f907a;
        long dl;
        int g;
        String z;

        private z() {
        }
    }
}
