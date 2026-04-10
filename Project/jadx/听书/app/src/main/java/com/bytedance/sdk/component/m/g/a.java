package com.bytedance.sdk.component.m.g;

import com.bytedance.sdk.component.m.e;
import com.bytedance.sdk.component.m.gz;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a<T> implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f776a;
    private T dl;
    private int g;
    private gz gc;
    Map<String, String> z;

    public a(int i, T t, String str) {
        this.g = i;
        this.dl = t;
        this.f776a = str;
    }

    public a(int i, T t, String str, Map<String, String> map) {
        this(i, t, str);
        this.z = map;
    }

    @Override // com.bytedance.sdk.component.m.e
    public gz z() {
        return this.gc;
    }

    public void z(gz gzVar) {
        this.gc = gzVar;
    }

    @Override // com.bytedance.sdk.component.m.e
    public int g() {
        return this.g;
    }

    @Override // com.bytedance.sdk.component.m.e
    public T dl() {
        return this.dl;
    }

    @Override // com.bytedance.sdk.component.m.e
    public String a() {
        return this.f776a;
    }

    @Override // com.bytedance.sdk.component.m.e
    public Map<String, String> gc() {
        return this.z;
    }
}
