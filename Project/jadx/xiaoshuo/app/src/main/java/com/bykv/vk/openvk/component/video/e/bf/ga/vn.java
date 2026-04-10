package com.bykv.vk.openvk.component.video.e.bf.ga;

import com.bykv.vk.openvk.component.video.e.bf.zk;
import com.bytedance.sdk.component.bf.e.s;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class vn extends e {
    private s d;

    public vn(s sVar, ga gaVar) {
        com.bytedance.sdk.component.bf.e.vn vnVarP;
        this.d = sVar;
        this.e = new ArrayList();
        if (sVar != null && (vnVarP = sVar.p()) != null) {
            for (int i = 0; i < vnVarP.e(); i++) {
                this.e.add(new zk.bf(vnVarP.e(i), vnVarP.bf(i)));
            }
        }
        this.bf = gaVar;
    }

    @Override // com.bykv.vk.openvk.component.video.e.bf.ga.e
    public boolean bf() {
        return this.d.d() >= 200 && this.d.d() < 300;
    }

    @Override // com.bykv.vk.openvk.component.video.e.bf.ga.e
    public List<zk.bf> d() {
        return this.e;
    }

    @Override // com.bykv.vk.openvk.component.video.e.bf.ga.e
    public int e() {
        return this.d.d();
    }

    @Override // com.bykv.vk.openvk.component.video.e.bf.ga.e
    public String ga() {
        s sVar = this.d;
        return (sVar == null || sVar.v() == null) ? "http/1.1" : this.d.v().toString();
    }

    @Override // com.bykv.vk.openvk.component.video.e.bf.ga.e
    public InputStream tg() {
        return this.d.vn().d();
    }

    @Override // com.bykv.vk.openvk.component.video.e.bf.ga.e
    public String vn() {
        return e(this.d.d());
    }

    @Override // com.bykv.vk.openvk.component.video.e.bf.ga.e
    public String e(String str, String str2) {
        return e(str) != null ? e(str).bf : str2;
    }
}
