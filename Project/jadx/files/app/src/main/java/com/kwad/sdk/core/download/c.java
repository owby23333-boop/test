package com.kwad.sdk.core.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.ksad.download.DownloadTask;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.LruHashMap;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.g;
import com.taobao.accs.common.Constants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    private final WeakHashMap<d, AdTemplate> aeC;
    private final Map<d, AdTemplate> aeD;
    private final HashMap<String, AdTemplate> aeF;
    private final Map<String, AdTemplate> aeG;
    private volatile boolean mHasInit;
    private static final Map<String, Integer> aeE = Collections.synchronizedMap(new LruHashMap(10));
    private static final Map<String, String> aeH = new LruHashMap(10);
    private static final BroadcastReceiver PT = new BroadcastReceiver() { // from class: com.kwad.sdk.core.download.c.4
        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            c.vG().f(intent);
        }
    };

    static final class a {
        static final c aeP = new c(0);
    }

    private c() {
        this.aeC = new WeakHashMap<>();
        this.aeD = Collections.synchronizedMap(this.aeC);
        this.mHasInit = false;
        this.aeF = new HashMap<>();
        this.aeG = Collections.synchronizedMap(this.aeF);
    }

    /* synthetic */ c(byte b) {
        this();
    }

    private void a(String str, com.kwad.sdk.d.a<d> aVar) {
        Set<d> setKeySet = this.aeD.keySet();
        synchronized (this.aeD) {
            for (d dVar : setKeySet) {
                if (dVar != null && TextUtils.equals(dVar.nx(), str)) {
                    try {
                        aVar.accept(dVar);
                    } catch (Exception e2) {
                        com.kwad.sdk.core.d.b.printStackTrace(e2);
                    }
                }
            }
        }
    }

    private void aW(final Context context) {
        g.execute(new av() { // from class: com.kwad.sdk.core.download.c.5
            @Override // com.kwad.sdk.utils.av
            public final void doTask() {
                try {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                    intentFilter.addDataScheme(Constants.KEY_PACKAGE);
                    context.registerReceiver(c.PT, intentFilter);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                }
            }
        });
    }

    public static int by(String str) {
        Integer num;
        if (TextUtils.isEmpty(str) || (num = aeE.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Intent intent) {
        String schemeSpecificPart = (!TextUtils.equals("android.intent.action.PACKAGE_ADDED", intent.getAction()) || intent.getData() == null) ? null : intent.getData().getSchemeSpecificPart();
        if (com.kwad.b.kwai.a.bI.booleanValue()) {
            com.kwad.sdk.core.d.b.d("DownloadStatusManager", "handleInstallApp(), pkgNameAdded=" + schemeSpecificPart);
        }
        if (TextUtils.isEmpty(schemeSpecificPart)) {
            return;
        }
        f fVar = new f();
        synchronized (this.aeD) {
            for (d dVar : this.aeD.keySet()) {
                if (dVar != null && !TextUtils.isEmpty(schemeSpecificPart) && TextUtils.equals(schemeSpecificPart, dVar.ny())) {
                    dVar.a((String) null, 0, fVar);
                }
            }
        }
        com.ksad.download.d dVarO = com.ksad.download.c.M().O();
        if (dVarO != null) {
            dVarO.n(schemeSpecificPart);
        }
        synchronized (this.aeG) {
            Iterator<Map.Entry<String, AdTemplate>> it = this.aeG.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, AdTemplate> next = it.next();
                if (next != null) {
                    String key = next.getKey();
                    if (!TextUtils.isEmpty(schemeSpecificPart) && TextUtils.equals(schemeSpecificPart, key)) {
                        it.remove();
                    }
                }
            }
        }
    }

    private void f(String str, f fVar) {
        AdTemplate value;
        for (Map.Entry<String, AdTemplate> entry : this.aeG.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null) {
                AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(value);
                com.kwad.sdk.core.a.ud().c(str, value);
                if (!TextUtils.isEmpty(str) && adInfoCb.downloadId.equals(str) && !value.mDownloadFinishReported) {
                    if (fVar.vK()) {
                        com.kwad.sdk.core.download.a.c(1, value);
                        fVar.vJ();
                    }
                    value.mDownloadFinishReported = true;
                }
            }
        }
    }

    public static c vG() {
        return a.aeP;
    }

    public final void a(d dVar) {
        this.aeD.remove(dVar);
    }

    public final void a(d dVar, AdTemplate adTemplate) {
        this.aeD.put(dVar, adTemplate);
    }

    public final void a(final String str, final int i2, final int i3, final int i4) {
        aeE.put(str, 2);
        a(str, new com.kwad.sdk.d.a<d>() { // from class: com.kwad.sdk.core.download.c.7
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.d.a
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(d dVar) {
                dVar.a(str, i2, i3, i4);
            }
        });
    }

    public final synchronized void aX(Context context) {
        if (!this.mHasInit || context == null) {
            return;
        }
        try {
            context.unregisterReceiver(PT);
            this.aeD.clear();
            this.aeG.clear();
            this.mHasInit = false;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
        }
    }

    public final void an(AdTemplate adTemplate) {
        try {
            String strAr = com.kwad.sdk.core.response.a.a.ar(com.kwad.sdk.core.response.a.d.cb(adTemplate));
            if (TextUtils.isEmpty(strAr)) {
                return;
            }
            this.aeG.put(strAr, adTemplate);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTrace(th);
        }
    }

    public final void b(final String str, int i2, final String str2) {
        aeE.put(str, 7);
        final f fVar = new f();
        final int i3 = 0;
        a(str, new com.kwad.sdk.d.a<d>() { // from class: com.kwad.sdk.core.download.c.9
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.d.a
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(d dVar) {
                dVar.a(str, i3, str2, fVar);
            }
        });
    }

    public final void bA(final String str) {
        final f fVar = new f();
        aeE.put(str, 4);
        a(str, new com.kwad.sdk.d.a<d>() { // from class: com.kwad.sdk.core.download.c.10
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.d.a
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(d dVar) {
                dVar.b(str, fVar);
            }
        });
    }

    public final void bB(final String str) {
        final f fVar = new f();
        aeE.put(str, 1);
        a(str, new com.kwad.sdk.d.a<d>() { // from class: com.kwad.sdk.core.download.c.11
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.d.a
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(d dVar) {
                dVar.c(str, fVar);
            }
        });
    }

    public final void bC(final String str) {
        final f fVar = new f();
        aeE.put(str, 5);
        a(str, new com.kwad.sdk.d.a<d>() { // from class: com.kwad.sdk.core.download.c.12
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.d.a
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(d dVar) {
                dVar.d(str, fVar);
            }
        });
    }

    public final void bD(final String str) {
        final f fVar = new f();
        aeE.put(str, 9);
        a(str, new com.kwad.sdk.d.a<d>() { // from class: com.kwad.sdk.core.download.c.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.d.a
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(d dVar) {
                dVar.e(str, fVar);
            }
        });
    }

    public final void bE(final String str) {
        final f fVar = new f();
        a(str, new com.kwad.sdk.d.a<d>() { // from class: com.kwad.sdk.core.download.c.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.d.a
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(d dVar) {
                dVar.an(str);
            }
        });
    }

    public final void bz(final String str) {
        aeE.put(str, 1);
        final f fVar = new f();
        a(str, new com.kwad.sdk.d.a<d>() { // from class: com.kwad.sdk.core.download.c.6
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.d.a
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(d dVar) {
                dVar.a(str, fVar);
            }
        });
    }

    public final synchronized void init(Context context) {
        if (!this.mHasInit && context != null) {
            com.ksad.download.c.M().a(new com.ksad.download.b() { // from class: com.kwad.sdk.core.download.c.1
                private static String m(DownloadTask downloadTask) {
                    String url = downloadTask.getUrl();
                    String str = (String) c.aeH.get(url);
                    if (!TextUtils.isEmpty(str)) {
                        return str;
                    }
                    String strEl = ac.el(downloadTask.getUrl());
                    c.aeH.put(url, strEl);
                    return strEl;
                }

                @Override // com.ksad.download.b, com.ksad.download.a
                public final void a(DownloadTask downloadTask) {
                    c.this.r(m(downloadTask), downloadTask.getTargetFilePath());
                }

                @Override // com.ksad.download.b, com.ksad.download.a
                public final void a(DownloadTask downloadTask, int i2, int i3) {
                    c.this.a(m(downloadTask), i3 > 0 ? (int) ((i2 * 100.0f) / i3) : 0, i2, i3);
                }

                @Override // com.ksad.download.b, com.ksad.download.a
                public final void a(DownloadTask downloadTask, Throwable th) {
                    String str;
                    if (th == null || th.getStackTrace().length <= 0) {
                        str = "";
                    } else {
                        str = th.getMessage() + " @ " + th.getStackTrace()[0].getFileName() + th.getStackTrace()[0].getClassName() + th.getStackTrace()[0].getLineNumber();
                    }
                    c.this.b(m(downloadTask), 0, str);
                }

                @Override // com.ksad.download.b, com.ksad.download.a
                public final void b(DownloadTask downloadTask) {
                    if (downloadTask.getSmallFileSoFarBytes() == 0) {
                        if (com.kwad.b.kwai.a.bI.booleanValue()) {
                            com.kwad.sdk.core.d.b.d("DownloadStatusManager", "onDownloadStart(), id=" + m(downloadTask));
                        }
                        c.this.bz(m(downloadTask));
                    }
                }

                @Override // com.ksad.download.b, com.ksad.download.a
                public final void c(DownloadTask downloadTask) {
                    c.this.bA(m(downloadTask));
                }

                @Override // com.ksad.download.b, com.ksad.download.a
                public final void d(DownloadTask downloadTask) {
                    c.this.bC(m(downloadTask));
                }

                @Override // com.ksad.download.b, com.ksad.download.a
                public final void e(DownloadTask downloadTask) {
                    c.this.bB(m(downloadTask));
                }

                @Override // com.ksad.download.b, com.ksad.download.a
                public final void f(DownloadTask downloadTask) {
                    c.this.bE(m(downloadTask));
                }
            });
            aW(context);
            this.mHasInit = true;
        }
    }

    public final void r(final String str, final String str2) {
        final f fVar = new f();
        aeE.put(str, 8);
        a(str, new com.kwad.sdk.d.a<d>() { // from class: com.kwad.sdk.core.download.c.8
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.d.a
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(d dVar) {
                dVar.a(str, str2, fVar);
            }
        });
        f(str, fVar);
    }
}
