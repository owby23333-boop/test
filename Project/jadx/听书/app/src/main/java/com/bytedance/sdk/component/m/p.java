package com.bytedance.sdk.component.m;

import android.util.SparseArray;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class p implements ls, Function {
    ls g;
    Function z;

    public p(ls lsVar) {
        this.g = lsVar;
    }

    public p(Function function) {
        this.z = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                return this.g.getCacheKey();
            case 2:
                return this.g.getUrl();
            case 3:
                return this.g.getResult();
            case 4:
                return this.g.getOriginResult();
            case 5:
                this.g.setResult(sparseArray.get(1));
                return null;
            case 6:
                return Integer.valueOf(this.g.getWidth());
            case 7:
                return Integer.valueOf(this.g.getHeight());
            case 8:
                return this.g.getHeaders();
            case 9:
                return Boolean.valueOf(this.g.isGif());
            case 10:
                return Boolean.valueOf(this.g.isLocal());
            case 11:
                gz httpTime = this.g.getHttpTime();
                return httpTime != null ? new fo(httpTime) : httpTime;
            case 12:
                return Integer.valueOf(this.g.getFileSize());
            default:
                return null;
        }
    }

    @Override // com.bytedance.sdk.component.m.ls
    public String getCacheKey() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.m.ls
    public int getFileSize() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        return ((Integer) this.z.apply(sparseArray)).intValue();
    }

    @Override // com.bytedance.sdk.component.m.ls
    public Map getHeaders() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        return (Map) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.m.ls
    public int getHeight() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return ((Integer) this.z.apply(sparseArray)).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    @Override // com.bytedance.sdk.component.m.ls
    public gz getHttpTime() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        ?? Apply = this.z.apply(sparseArray);
        ?? foVar = Apply;
        if (Apply != 0) {
            foVar = new fo((Function) Apply);
        }
        return (gz) foVar;
    }

    @Override // com.bytedance.sdk.component.m.ls
    public Object getOriginResult() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.m.ls
    public Object getResult() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.m.ls
    public String getUrl() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.m.ls
    public int getWidth() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        return ((Integer) this.z.apply(sparseArray)).intValue();
    }

    @Override // com.bytedance.sdk.component.m.ls
    public boolean isGif() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        return ((Boolean) this.z.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.sdk.component.m.ls
    public boolean isLocal() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        return ((Boolean) this.z.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.sdk.component.m.ls
    public void setResult(Object obj) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        sparseArray.put(1, obj);
        this.z.apply(sparseArray);
    }
}
