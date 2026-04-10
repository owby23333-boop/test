package com.bykv.vk.openvk.component.video.z.g.gc;

import com.bykv.vk.openvk.component.video.z.g.fo;
import com.bytedance.sdk.component.g.z.ls;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class m extends z {
    private ls dl;

    public m(ls lsVar, gc gcVar) {
        com.bytedance.sdk.component.g.z.m mVarE;
        this.dl = lsVar;
        this.z = new ArrayList();
        if (lsVar != null && (mVarE = lsVar.e()) != null) {
            for (int i = 0; i < mVarE.z(); i++) {
                this.z.add(new fo.g(mVarE.z(i), mVarE.g(i)));
            }
        }
        this.g = gcVar;
    }

    @Override // com.bykv.vk.openvk.component.video.z.g.gc.z
    public int z() {
        return this.dl.dl();
    }

    @Override // com.bykv.vk.openvk.component.video.z.g.gc.z
    public boolean g() {
        return this.dl.dl() >= 200 && this.dl.dl() < 300;
    }

    @Override // com.bykv.vk.openvk.component.video.z.g.gc.z
    public String z(String str, String str2) {
        return z(str) != null ? z(str).g : str2;
    }

    @Override // com.bykv.vk.openvk.component.video.z.g.gc.z
    public List<fo.g> dl() {
        return this.z;
    }

    @Override // com.bykv.vk.openvk.component.video.z.g.gc.z
    public InputStream a() {
        return this.dl.m().dl();
    }

    @Override // com.bykv.vk.openvk.component.video.z.g.gc.z
    public String gc() {
        ls lsVar = this.dl;
        return (lsVar == null || lsVar.gz() == null) ? "http/1.1" : this.dl.gz().toString();
    }

    @Override // com.bykv.vk.openvk.component.video.z.g.gc.z
    public String m() {
        return z(this.dl.dl());
    }
}
