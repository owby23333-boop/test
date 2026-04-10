package com.anythink.expressad.videocommon.b;

import android.text.TextUtils;
import com.anythink.expressad.videocommon.b.i;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements i.c {
    private static String a = "DownLoadH5SourceListener";
    private ConcurrentMap<String, d> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private m f12159c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private CopyOnWriteArrayList<i.d> f12160d = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f12161e;

    public d(ConcurrentMap<String, d> concurrentMap, m mVar, i.d dVar, String str) {
        this.b = concurrentMap;
        this.f12159c = mVar;
        this.f12160d.add(dVar);
        this.f12161e = str;
    }

    @Override // com.anythink.expressad.videocommon.b.i.c
    public final void a() {
    }

    public final void a(i.d dVar) {
        this.f12160d.add(dVar);
    }

    @Override // com.anythink.expressad.videocommon.b.i.c
    public final void a(byte[] bArr, String str) {
        String message;
        try {
        } catch (Exception e2) {
            if (com.anythink.expressad.a.a) {
                e2.printStackTrace();
            }
            try {
                message = e2.getMessage();
            } catch (Throwable th) {
                com.anythink.expressad.foundation.h.o.b(a, th.getMessage(), th);
                message = "";
            }
        }
        if (this.b == null) {
            for (i.d dVar : this.f12160d) {
                if (dVar != null) {
                    dVar.a(str, "mResDownloadingMap  is null");
                    this.f12160d.remove(dVar);
                }
            }
            return;
        }
        if (this.b.containsKey(str)) {
            this.b.remove(str);
        }
        if (bArr == null || bArr.length <= 0) {
            message = "response data is error";
        } else {
            String strA = this.f12159c.a(str, bArr);
            if (TextUtils.isEmpty(strA)) {
                for (i.d dVar2 : this.f12160d) {
                    if (dVar2 != null) {
                        dVar2.a(str);
                        this.f12160d.remove(dVar2);
                    }
                }
                return;
            }
            message = "data save failed:".concat(String.valueOf(strA));
        }
        for (i.d dVar3 : this.f12160d) {
            if (dVar3 != null) {
                dVar3.a(str, message);
            }
        }
    }

    @Override // com.anythink.expressad.videocommon.b.i.c
    public final void a(String str) {
        try {
        } catch (Exception e2) {
            if (com.anythink.expressad.a.a) {
                e2.printStackTrace();
            }
            try {
                str = e2.getMessage();
            } catch (Throwable th) {
                com.anythink.expressad.foundation.h.o.b(a, th.getMessage(), th);
            }
        }
        if (this.b == null) {
            for (i.d dVar : this.f12160d) {
                if (dVar != null) {
                    dVar.a(this.f12161e, "mResDownloadingMap  is null");
                    this.f12160d.remove(dVar);
                }
            }
            return;
        }
        if (this.b.containsKey(this.f12161e)) {
            this.b.remove(this.f12161e);
        }
        for (i.d dVar2 : this.f12160d) {
            if (dVar2 != null) {
                dVar2.a(this.f12161e, str);
                this.f12160d.remove(dVar2);
            }
        }
    }
}
