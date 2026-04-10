package com.liulishuo.filedownloader.download;

import android.text.TextUtils;
import com.liulishuo.filedownloader.download.b;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ConnectTask.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    final int a;
    final String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final FileDownloadHeader f17120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.liulishuo.filedownloader.download.b f17121d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f17122e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<String, List<String>> f17123f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<String> f17124g;

    /* JADX INFO: compiled from: ConnectTask.java */
    static class b {
        private Integer a;
        private String b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f17125c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private FileDownloadHeader f17126d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private com.liulishuo.filedownloader.download.b f17127e;

        b() {
        }

        public b a(int i2) {
            this.a = Integer.valueOf(i2);
            return this;
        }

        public b b(String str) {
            this.b = str;
            return this;
        }

        public b a(String str) {
            this.f17125c = str;
            return this;
        }

        public b a(FileDownloadHeader fileDownloadHeader) {
            this.f17126d = fileDownloadHeader;
            return this;
        }

        public b a(com.liulishuo.filedownloader.download.b bVar) {
            this.f17127e = bVar;
            return this;
        }

        a a() {
            com.liulishuo.filedownloader.download.b bVar;
            Integer num = this.a;
            if (num != null && (bVar = this.f17127e) != null && this.b != null) {
                return new a(bVar, num.intValue(), this.b, this.f17125c, this.f17126d);
            }
            throw new IllegalArgumentException();
        }
    }

    private void b(com.liulishuo.filedownloader.d0.b bVar) {
        HashMap<String, List<String>> mapA;
        FileDownloadHeader fileDownloadHeader = this.f17120c;
        if (fileDownloadHeader == null || (mapA = fileDownloadHeader.a()) == null) {
            return;
        }
        if (com.liulishuo.filedownloader.h0.d.a) {
            com.liulishuo.filedownloader.h0.d.d(this, "%d add outside header: %s", Integer.valueOf(this.a), mapA);
        }
        for (Map.Entry<String, List<String>> entry : mapA.entrySet()) {
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

    private void c(com.liulishuo.filedownloader.d0.b bVar) {
        FileDownloadHeader fileDownloadHeader = this.f17120c;
        if (fileDownloadHeader == null || fileDownloadHeader.a().get("User-Agent") == null) {
            bVar.addHeader("User-Agent", com.liulishuo.filedownloader.h0.f.a());
        }
    }

    void a(long j2) {
        com.liulishuo.filedownloader.download.b bVar = this.f17121d;
        long j3 = bVar.b;
        if (j2 == j3) {
            com.liulishuo.filedownloader.h0.d.e(this, "no data download, no need to update", new Object[0]);
            return;
        }
        this.f17121d = b.C0483b.a(bVar.a, j2, bVar.f17128c, bVar.f17129d - (j2 - j3));
        if (com.liulishuo.filedownloader.h0.d.a) {
            com.liulishuo.filedownloader.h0.d.c(this, "after update profile:%s", this.f17121d);
        }
    }

    public Map<String, List<String>> d() {
        return this.f17123f;
    }

    boolean e() {
        return this.f17121d.b > 0;
    }

    private a(com.liulishuo.filedownloader.download.b bVar, int i2, String str, String str2, FileDownloadHeader fileDownloadHeader) {
        this.a = i2;
        this.b = str;
        this.f17122e = str2;
        this.f17120c = fileDownloadHeader;
        this.f17121d = bVar;
    }

    public com.liulishuo.filedownloader.download.b c() {
        return this.f17121d;
    }

    com.liulishuo.filedownloader.d0.b a() throws IllegalAccessException, IOException {
        com.liulishuo.filedownloader.d0.b bVarA = c.i().a(this.b);
        b(bVarA);
        a(bVarA);
        c(bVarA);
        this.f17123f = bVarA.b();
        if (com.liulishuo.filedownloader.h0.d.a) {
            com.liulishuo.filedownloader.h0.d.a(this, "<---- %s request header %s", Integer.valueOf(this.a), this.f17123f);
        }
        bVarA.execute();
        this.f17124g = new ArrayList();
        com.liulishuo.filedownloader.d0.b bVarA2 = com.liulishuo.filedownloader.d0.d.a(this.f17123f, bVarA, this.f17124g);
        if (com.liulishuo.filedownloader.h0.d.a) {
            com.liulishuo.filedownloader.h0.d.a(this, "----> %s response header %s", Integer.valueOf(this.a), bVarA2.c());
        }
        return bVarA2;
    }

    String b() {
        List<String> list = this.f17124g;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return this.f17124g.get(r0.size() - 1);
    }

    private void a(com.liulishuo.filedownloader.d0.b bVar) throws ProtocolException {
        if (bVar.a(this.f17122e, this.f17121d.a)) {
            return;
        }
        if (!TextUtils.isEmpty(this.f17122e)) {
            bVar.addHeader("If-Match", this.f17122e);
        }
        this.f17121d.a(bVar);
    }
}
