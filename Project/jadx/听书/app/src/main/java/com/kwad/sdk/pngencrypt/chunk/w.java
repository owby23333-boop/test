package com.kwad.sdk.pngencrypt.chunk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class w {
    private final e aWC;
    private final boolean aWD;

    public w(e eVar) {
        this.aWC = eVar;
        if (eVar instanceof f) {
            this.aWD = false;
        } else {
            this.aWD = true;
        }
    }

    private List<? extends t> gC(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.aWC.am("tEXt", str));
        arrayList.addAll(this.aWC.am("zTXt", str));
        arrayList.addAll(this.aWC.am("iTXt", str));
        return arrayList;
    }

    public final String gD(String str) {
        List<? extends t> listGC = gC(str);
        if (listGC.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<? extends t> it = listGC.iterator();
        while (it.hasNext()) {
            sb.append(it.next().ON()).append("\n");
        }
        return sb.toString().trim();
    }
}
