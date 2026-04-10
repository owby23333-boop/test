package com.bytedance.sdk.component.m.g;

import com.bytedance.sdk.component.m.m;
import com.bytedance.sdk.component.m.tb;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private tb f777a;
    private boolean dl;
    private boolean g;
    private String z;

    public dl(String str, boolean z, boolean z2, tb tbVar) {
        this.z = str;
        this.g = z;
        this.dl = z2;
        this.f777a = tbVar;
    }

    @Override // com.bytedance.sdk.component.m.m
    public String z() {
        return this.z;
    }

    @Override // com.bytedance.sdk.component.m.m
    public boolean g() {
        return this.g;
    }

    @Override // com.bytedance.sdk.component.m.m
    public boolean dl() {
        return this.dl;
    }

    @Override // com.bytedance.sdk.component.m.m
    public tb a() {
        return this.f777a;
    }
}
