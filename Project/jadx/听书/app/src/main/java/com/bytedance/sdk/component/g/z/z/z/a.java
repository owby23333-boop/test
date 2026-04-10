package com.bytedance.sdk.component.g.z.z.z;

import com.bytedance.sdk.component.dl.g.h;
import com.bytedance.sdk.component.g.z.ls;
import com.bytedance.sdk.component.g.z.v;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class a implements com.bytedance.sdk.component.g.z.g {
    com.bytedance.sdk.component.dl.g.gc z;

    public a(com.bytedance.sdk.component.dl.g.gc gcVar) {
        this.z = gcVar;
    }

    @Override // com.bytedance.sdk.component.g.z.g
    public v z() {
        return new gz(this.z.z());
    }

    @Override // com.bytedance.sdk.component.g.z.g
    public ls g() throws IOException {
        return new fo(this.z.g());
    }

    @Override // com.bytedance.sdk.component.g.z.g
    public void z(final com.bytedance.sdk.component.g.z.dl dlVar) {
        this.z.z(new com.bytedance.sdk.component.dl.g.m() { // from class: com.bytedance.sdk.component.g.z.z.z.a.1
            @Override // com.bytedance.sdk.component.dl.g.m
            public void z(com.bytedance.sdk.component.dl.g.gc gcVar, IOException iOException) {
                dlVar.onFailure(new a(gcVar), iOException);
            }

            @Override // com.bytedance.sdk.component.dl.g.m
            public void z(com.bytedance.sdk.component.dl.g.gc gcVar, h hVar) throws IOException {
                dlVar.onResponse(new a(gcVar), new fo(hVar));
            }
        });
    }

    @Override // com.bytedance.sdk.component.g.z.g
    public void dl() {
        this.z.dl();
    }

    /* JADX INFO: renamed from: gc, reason: merged with bridge method [inline-methods] */
    public com.bytedance.sdk.component.g.z.g clone() {
        return new a(this.z.gc());
    }

    @Override // com.bytedance.sdk.component.g.z.g
    public boolean a() {
        return this.z.a();
    }
}
