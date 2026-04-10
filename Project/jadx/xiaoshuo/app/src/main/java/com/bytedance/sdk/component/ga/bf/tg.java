package com.bytedance.sdk.component.ga.bf;

import com.bytedance.sdk.component.ga.p;
import com.bytedance.sdk.component.ga.vn;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class tg<T> implements vn {
    private int bf;
    private T d;
    Map<String, String> e;
    private p ga;
    private String tg;

    public tg(int i, T t, String str) {
        this.bf = i;
        this.d = t;
        this.tg = str;
    }

    @Override // com.bytedance.sdk.component.ga.vn
    public int bf() {
        return this.bf;
    }

    @Override // com.bytedance.sdk.component.ga.vn
    public T d() {
        return this.d;
    }

    @Override // com.bytedance.sdk.component.ga.vn
    public p e() {
        return this.ga;
    }

    @Override // com.bytedance.sdk.component.ga.vn
    public Map<String, String> ga() {
        return this.e;
    }

    @Override // com.bytedance.sdk.component.ga.vn
    public String tg() {
        return this.tg;
    }

    public void e(p pVar) {
        this.ga = pVar;
    }

    public tg(int i, T t, String str, Map<String, String> map) {
        this(i, t, str);
        this.e = map;
    }
}
