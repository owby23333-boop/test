package com.anythink.expressad.videocommon.b;

import android.webkit.URLUtil;
import com.anythink.expressad.foundation.h.w;
import com.anythink.expressad.videocommon.b.h;
import com.anythink.expressad.videocommon.b.i;

/* JADX INFO: loaded from: classes2.dex */
public final class g {
    public static final String a = "<anythinkloadend></anythinkloadend>";
    private static final String b = "DownLoadUtils";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f12168c = 20000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f12169d = 30000;

    public static void a(final String str, final i.c cVar) {
        try {
            if (!w.a(str) && URLUtil.isNetworkUrl(str)) {
                h.a.a.a(new com.anythink.expressad.foundation.g.g.a() { // from class: com.anythink.expressad.videocommon.b.g.1

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    final /* synthetic */ boolean f12171f = true;

                    /* JADX WARN: Can't wrap try/catch for region: R(12:108|3|(8:5|6|115|7|(8:104|8|(1:10)(1:117)|45|(1:47)|(1:51)|(3:103|55|(2:60|61))|(2:75|(2:77|78)(1:119))(2:71|(2:73|74)(1:118)))|11|(4:13|107|14|(2:16|17))(1:20)|21)(2:31|32)|112|33|(1:35)|(1:37)|38|(0)|(1:65)|75|(0)(0)) */
                    /* JADX WARN: Code restructure failed: missing block: B:39:0x0099, code lost:
                    
                        r3 = e;
                     */
                    /* JADX WARN: Removed duplicated region for block: B:103:0x00d3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                    /* JADX WARN: Removed duplicated region for block: B:119:? A[RETURN, SYNTHETIC] */
                    /* JADX WARN: Removed duplicated region for block: B:47:0x00be A[Catch: Exception -> 0x00c2, TRY_ENTER, TryCatch #12 {Exception -> 0x00c2, blocks: (B:35:0x008f, B:37:0x0094, B:47:0x00be, B:51:0x00c6), top: B:114:0x0004 }] */
                    /* JADX WARN: Removed duplicated region for block: B:51:0x00c6 A[Catch: Exception -> 0x00c2, TRY_LEAVE, TryCatch #12 {Exception -> 0x00c2, blocks: (B:35:0x008f, B:37:0x0094, B:47:0x00be, B:51:0x00c6), top: B:114:0x0004 }] */
                    /* JADX WARN: Removed duplicated region for block: B:77:0x010c A[Catch: all -> 0x00e4, TRY_LEAVE, TryCatch #1 {all -> 0x00e4, blocks: (B:55:0x00d3, B:58:0x00d9, B:60:0x00dc, B:65:0x00e8, B:67:0x00ee, B:69:0x00f4, B:71:0x00fc, B:73:0x0100, B:75:0x0108, B:77:0x010c), top: B:103:0x00d3 }] */
                    @Override // com.anythink.expressad.foundation.g.g.a
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final void a() throws java.lang.Throwable {
                        /*
                            Method dump skipped, instruction units count: 332
                            To view this dump change 'Code comments level' option to 'DEBUG'
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.videocommon.b.g.AnonymousClass1.a():void");
                    }

                    @Override // com.anythink.expressad.foundation.g.g.a
                    public final void b() {
                    }

                    @Override // com.anythink.expressad.foundation.g.g.a
                    public final void c() {
                    }
                });
                return;
            }
            cVar.a("url is error");
        } catch (Throwable th) {
            if (com.anythink.expressad.a.a) {
                th.printStackTrace();
            }
        }
    }
}
