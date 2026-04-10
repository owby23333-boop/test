package com.github.gzuliyujiang.oaid.g;

import com.github.gzuliyujiang.oaid.OAIDException;

/* JADX INFO: compiled from: DefaultImpl.java */
/* JADX INFO: loaded from: classes2.dex */
class d implements com.github.gzuliyujiang.oaid.d {
    d() {
    }

    @Override // com.github.gzuliyujiang.oaid.d
    public void a(com.github.gzuliyujiang.oaid.c cVar) {
        if (cVar == null) {
            return;
        }
        cVar.a(new OAIDException("Unsupported"));
    }

    @Override // com.github.gzuliyujiang.oaid.d
    public boolean a() {
        return false;
    }
}
