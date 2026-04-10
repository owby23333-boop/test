package com.kwad.sdk.pngencrypt.chunk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class w {
    private final e awQ;
    private final boolean awR;

    public w(e eVar) {
        this.awQ = eVar;
        this.awR = !(eVar instanceof f);
    }

    private List<? extends t> dX(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.awQ.V("tEXt", str));
        arrayList.addAll(this.awQ.V("zTXt", str));
        arrayList.addAll(this.awQ.V("iTXt", str));
        return arrayList;
    }

    public final String dY(String str) {
        List<? extends t> listDX = dX(str);
        if (listDX.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<? extends t> it = listDX.iterator();
        while (it.hasNext()) {
            sb.append(it.next().Cs());
            sb.append("\n");
        }
        return sb.toString().trim();
    }
}
