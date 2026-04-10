package com.kwad.framework.filedownloader.download;

import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class ConnectTask {
    final int amZ;
    final com.kwad.framework.filedownloader.d.b ana;
    private com.kwad.framework.filedownloader.download.a anb;
    private String anc;
    private Map<String, List<String>> and;
    private List<String> ane;
    final String url;

    /* synthetic */ ConnectTask(com.kwad.framework.filedownloader.download.a aVar, int i, String str, String str2, com.kwad.framework.filedownloader.d.b bVar, byte b) {
        this(aVar, i, str, str2, bVar);
    }

    private ConnectTask(com.kwad.framework.filedownloader.download.a aVar, int i, String str, String str2, com.kwad.framework.filedownloader.d.b bVar) {
        this.amZ = i;
        this.url = str;
        this.anc = str2;
        this.ana = bVar;
        this.anb = aVar;
    }

    final com.kwad.framework.filedownloader.a.b xX() {
        com.kwad.framework.filedownloader.a.b bVarBr = b.yc().br(this.url);
        a(bVarBr);
        b(bVarBr);
        c(bVarBr);
        this.and = bVarBr.xQ();
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(this, "%s request header %s", Integer.valueOf(this.amZ), this.and);
        }
        bVarBr.execute();
        ArrayList arrayList = new ArrayList();
        this.ane = arrayList;
        return com.kwad.framework.filedownloader.a.d.a(this.and, bVarBr, arrayList);
    }

    private void a(com.kwad.framework.filedownloader.a.b bVar) {
        HashMap<String, List<String>> mapYY;
        com.kwad.framework.filedownloader.d.b bVar2 = this.ana;
        if (bVar2 == null || (mapYY = bVar2.yY()) == null) {
            return;
        }
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.e(this, "%d add outside header: %s", Integer.valueOf(this.amZ), mapYY);
        }
        for (Map.Entry<String, List<String>> entry : mapYY.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (value != null) {
                Iterator<String> it = value.iterator();
                while (it.hasNext()) {
                    bVar.addHeader(key, it.next());
                }
            }
        }
    }

    private void b(com.kwad.framework.filedownloader.a.b bVar) {
        String strC;
        if (!TextUtils.isEmpty(this.anc)) {
            bVar.addHeader(HttpHeaders.IF_MATCH, this.anc);
        }
        if (this.anb.anj == 0) {
            strC = com.kwad.framework.filedownloader.f.f.c("bytes=%d-", Long.valueOf(this.anb.ani));
        } else {
            strC = com.kwad.framework.filedownloader.f.f.c("bytes=%d-%d", Long.valueOf(this.anb.ani), Long.valueOf(this.anb.anj));
        }
        bVar.addHeader(HttpHeaders.RANGE, strC);
    }

    private void c(com.kwad.framework.filedownloader.a.b bVar) {
        com.kwad.framework.filedownloader.d.b bVar2 = this.ana;
        if (bVar2 == null || bVar2.yY().get("User-Agent") == null) {
            bVar.addHeader("User-Agent", com.kwad.framework.filedownloader.f.f.zH());
        }
    }

    final boolean xY() {
        return this.anb.ani > 0;
    }

    final String xZ() {
        List<String> list = this.ane;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return this.ane.get(r0.size() - 1);
    }

    public final Map<String, List<String>> getRequestHeader() {
        return this.and;
    }

    public final com.kwad.framework.filedownloader.download.a ya() {
        return this.anb;
    }

    class Reconnect extends Throwable {
        private static final long serialVersionUID = 2940866805654257562L;

        Reconnect() {
        }
    }

    static class a {
        private com.kwad.framework.filedownloader.d.b ana;
        private String anc;
        private Integer anf;
        private com.kwad.framework.filedownloader.download.a ang;
        private String url;

        a() {
        }

        public final a bL(int i) {
            this.anf = Integer.valueOf(i);
            return this;
        }

        public final a bp(String str) {
            this.url = str;
            return this;
        }

        public final a bq(String str) {
            this.anc = str;
            return this;
        }

        public final a a(com.kwad.framework.filedownloader.d.b bVar) {
            this.ana = bVar;
            return this;
        }

        public final a a(com.kwad.framework.filedownloader.download.a aVar) {
            this.ang = aVar;
            return this;
        }

        final ConnectTask yb() {
            if (this.anf == null || this.ang == null || this.url == null) {
                throw new IllegalArgumentException();
            }
            return new ConnectTask(this.ang, this.anf.intValue(), this.url, this.anc, this.ana, (byte) 0);
        }
    }
}
