package com.bytedance.adsdk.z.z.z;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    static class z extends IOException {
        z() {
            super("APNG Format error");
        }
    }

    public static List<gc> z(com.bytedance.adsdk.z.z.g.z zVar) throws IOException {
        if (!zVar.z("\u0089PNG") || !zVar.z("\r\n\u001a\n")) {
            throw new z();
        }
        ArrayList arrayList = new ArrayList();
        while (zVar.a() > 0) {
            arrayList.add(g(zVar));
        }
        return arrayList;
    }

    private static gc g(com.bytedance.adsdk.z.z.g.z zVar) throws IOException {
        gc gcVar;
        int iDl = zVar.dl();
        int iG = zVar.g();
        int iB_ = zVar.b_();
        if (iB_ == com.bytedance.adsdk.z.z.z.z.z) {
            gcVar = new com.bytedance.adsdk.z.z.z.z();
        } else if (iB_ == m.z) {
            gcVar = new m();
        } else if (iB_ == e.z) {
            gcVar = new e();
        } else if (iB_ == uy.z) {
            gcVar = new uy();
        } else if (iB_ == kb.z) {
            gcVar = new kb();
        } else if (iB_ == wp.z) {
            gcVar = new wp();
        } else {
            gcVar = new gc();
        }
        gcVar.e = iDl;
        gcVar.gc = iB_;
        gcVar.f283a = iG;
        gcVar.g(zVar);
        gcVar.m = zVar.g();
        return gcVar;
    }
}
