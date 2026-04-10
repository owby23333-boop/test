package com.bytedance.sdk.component.ga.bf;

/* JADX INFO: loaded from: classes.dex */
public class d implements com.bytedance.sdk.component.ga.ga {
    private boolean bf;
    private boolean d;
    private String e;

    public d(String str, boolean z, boolean z2) {
        this.e = str;
        this.bf = z;
        this.d = z2;
    }

    @Override // com.bytedance.sdk.component.ga.ga
    public boolean bf() {
        return this.bf;
    }

    @Override // com.bytedance.sdk.component.ga.ga
    public boolean d() {
        return this.d;
    }

    @Override // com.bytedance.sdk.component.ga.ga
    public String e() {
        return this.e;
    }
}
