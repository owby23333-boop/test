package com.bytedance.sdk.component.m.dl;

import com.bytedance.sdk.component.m.ls;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a<T> implements ls {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private T f761a;
    private T dl;
    private Map<String, String> e;
    private boolean fo;
    private String g;
    private int gc;
    private boolean gz;
    private int kb;
    private int m;
    private com.bytedance.sdk.component.m.gz uy;
    private String z;

    public a z(dl dlVar, T t) {
        this.dl = t;
        this.z = dlVar.getMemoryCacheKey();
        this.g = dlVar.getUrl();
        this.gc = dlVar.getWidth();
        this.m = dlVar.getHeight();
        this.fo = dlVar.gz();
        this.uy = dlVar.fo();
        this.kb = dlVar.uy();
        return this;
    }

    public a z(dl dlVar, T t, Map<String, String> map, boolean z) {
        this.e = map;
        this.gz = z;
        return z(dlVar, t);
    }

    @Override // com.bytedance.sdk.component.m.ls
    public String getCacheKey() {
        return this.z;
    }

    @Override // com.bytedance.sdk.component.m.ls
    public String getUrl() {
        return this.g;
    }

    @Override // com.bytedance.sdk.component.m.ls
    public T getResult() {
        return this.dl;
    }

    @Override // com.bytedance.sdk.component.m.ls
    public T getOriginResult() {
        return this.f761a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.component.m.ls
    public void setResult(Object obj) {
        this.f761a = this.dl;
        this.dl = obj;
    }

    @Override // com.bytedance.sdk.component.m.ls
    public int getWidth() {
        return this.gc;
    }

    @Override // com.bytedance.sdk.component.m.ls
    public int getHeight() {
        return this.m;
    }

    @Override // com.bytedance.sdk.component.m.ls
    public Map<String, String> getHeaders() {
        return this.e;
    }

    @Override // com.bytedance.sdk.component.m.ls
    public boolean isGif() {
        return this.gz;
    }

    @Override // com.bytedance.sdk.component.m.ls
    public boolean isLocal() {
        return this.fo;
    }

    @Override // com.bytedance.sdk.component.m.ls
    public com.bytedance.sdk.component.m.gz getHttpTime() {
        return this.uy;
    }

    @Override // com.bytedance.sdk.component.m.ls
    public int getFileSize() {
        return this.kb;
    }
}
