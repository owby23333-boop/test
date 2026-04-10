package com.kwai.filedownloader.download;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class ConnectTask {
    final int aFo;
    final com.kwai.filedownloader.c.b aFp;
    private com.kwai.filedownloader.download.a aFq;
    private String aFr;
    private Map<String, List<String>> aFs;
    private List<String> aFt;
    final String url;

    class Reconnect extends Throwable {
        private static final long serialVersionUID = 2940866805654257562L;

        Reconnect() {
        }
    }

    static class a {
        private com.kwai.filedownloader.c.b aFp;
        private String aFr;
        private Integer aFu;
        private com.kwai.filedownloader.download.a aFv;
        private String url;

        a() {
        }

        final ConnectTask Hs() {
            com.kwai.filedownloader.download.a aVar;
            Integer num = this.aFu;
            if (num == null || (aVar = this.aFv) == null || this.url == null) {
                throw new IllegalArgumentException();
            }
            return new ConnectTask(aVar, num.intValue(), this.url, this.aFr, this.aFp, (byte) 0);
        }

        public final a a(com.kwai.filedownloader.c.b bVar) {
            this.aFp = bVar;
            return this;
        }

        public final a a(com.kwai.filedownloader.download.a aVar) {
            this.aFv = aVar;
            return this;
        }

        public final a cL(int i2) {
            this.aFu = Integer.valueOf(i2);
            return this;
        }

        public final a eW(String str) {
            this.url = str;
            return this;
        }

        public final a eX(String str) {
            this.aFr = str;
            return this;
        }
    }

    private ConnectTask(com.kwai.filedownloader.download.a aVar, int i2, String str, String str2, com.kwai.filedownloader.c.b bVar) {
        this.aFo = i2;
        this.url = str;
        this.aFr = str2;
        this.aFp = bVar;
        this.aFq = aVar;
    }

    /* synthetic */ ConnectTask(com.kwai.filedownloader.download.a aVar, int i2, String str, String str2, com.kwai.filedownloader.c.b bVar, byte b) {
        this(aVar, i2, str, str2, bVar);
    }

    private void a(com.kwai.filedownloader.kwai.b bVar) {
        HashMap<String, List<String>> mapIo;
        com.kwai.filedownloader.c.b bVar2 = this.aFp;
        if (bVar2 == null || (mapIo = bVar2.Io()) == null) {
            return;
        }
        if (com.kwai.filedownloader.e.d.aHT) {
            com.kwai.filedownloader.e.d.i(this, "%d add outside header: %s", Integer.valueOf(this.aFo), mapIo);
        }
        for (Map.Entry<String, List<String>> entry : mapIo.entrySet()) {
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

    private void b(com.kwai.filedownloader.kwai.b bVar) {
        if (!TextUtils.isEmpty(this.aFr)) {
            bVar.addHeader("If-Match", this.aFr);
        }
        com.kwai.filedownloader.download.a aVar = this.aFq;
        bVar.addHeader("Range", aVar.aFy == 0 ? com.kwai.filedownloader.e.f.j("bytes=%d-", Long.valueOf(aVar.aFx)) : com.kwai.filedownloader.e.f.j("bytes=%d-%d", Long.valueOf(aVar.aFx), Long.valueOf(this.aFq.aFy)));
    }

    private void c(com.kwai.filedownloader.kwai.b bVar) {
        com.kwai.filedownloader.c.b bVar2 = this.aFp;
        if (bVar2 == null || bVar2.Io().get("User-Agent") == null) {
            bVar.addHeader("User-Agent", com.kwai.filedownloader.e.f.IV());
        }
    }

    final com.kwai.filedownloader.kwai.b Ho() {
        com.kwai.filedownloader.kwai.b bVarEY = b.Ht().eY(this.url);
        a(bVarEY);
        b(bVarEY);
        c(bVarEY);
        this.aFs = bVarEY.V();
        if (com.kwai.filedownloader.e.d.aHT) {
            com.kwai.filedownloader.e.d.g(this, "%s request header %s", Integer.valueOf(this.aFo), this.aFs);
        }
        bVarEY.execute();
        this.aFt = new ArrayList();
        return com.kwai.filedownloader.kwai.d.a(this.aFs, bVarEY, this.aFt);
    }

    final boolean Hp() {
        return this.aFq.aFx > 0;
    }

    final String Hq() {
        List<String> list = this.aFt;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return this.aFt.get(r0.size() - 1);
    }

    public final com.kwai.filedownloader.download.a Hr() {
        return this.aFq;
    }

    public final Map<String, List<String>> getRequestHeader() {
        return this.aFs;
    }
}
