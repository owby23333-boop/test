package com.bytedance.pangle.e.z;

/* JADX INFO: loaded from: classes2.dex */
public class gc {
    public com.bytedance.pangle.dl.z dl;
    public int g;
    public String z;

    public gc(String str, int i) {
        this.z = str;
        this.g = i;
    }

    public gc(com.bytedance.pangle.dl.z zVar) {
        if (zVar != null) {
            this.z = zVar.g();
            this.g = zVar.dl();
            this.dl = zVar;
        }
    }
}
