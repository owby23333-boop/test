package com.amgcyo.cuttadon.k.a;

import android.view.View;
import com.amgcyo.cuttadon.widget.ui.b;

/* JADX INFO: compiled from: GlobalAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements b.InterfaceC0125b {
    @Override // com.amgcyo.cuttadon.widget.ui.b.InterfaceC0125b
    public View a(b.c cVar, View view, int i2) {
        b bVar = view instanceof b ? (b) view : null;
        if (bVar == null) {
            bVar = new b(cVar.getContext(), cVar.b());
        }
        bVar.setStatus(i2);
        bVar.setMsgViewVisibility(!"hide_loading_status_msg".equals(cVar.a()));
        return bVar;
    }
}
