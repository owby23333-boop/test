package com.kwad.sdk;

import android.content.Context;
import com.kwad.framework.filedownloader.f.c;
import com.kwad.framework.filedownloader.r;
import com.kwad.framework.filedownloader.services.c;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.k;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.utils.w;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public final class c {
    private com.kwad.sdk.a arM;
    private d arO;
    private Context mContext;
    private final Map<Integer, DownloadTask> arK = new ConcurrentHashMap();
    private final Map<String, Integer> arL = new ConcurrentHashMap();
    private boolean arN = false;

    public static c AA() {
        return a.arR;
    }

    public final void init(Context context) {
        this.mContext = context;
        r.a(context, new c.b().ca(Integer.MAX_VALUE).a(new c.a() { // from class: com.kwad.sdk.c.1
            @Override // com.kwad.framework.filedownloader.services.c.a
            public final c.b yi() {
                try {
                    k.a aVar = new k.a(false);
                    aVar.bo("");
                    return aVar;
                } catch (Throwable unused) {
                    return null;
                }
            }
        }));
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final File AB() {
        return be.dF(this.mContext);
    }

    public final d AC() {
        if (this.arO == null) {
            this.arO = new com.kwad.sdk.core.download.b.a();
        }
        return this.arO;
    }

    public final void g(DownloadTask downloadTask) {
        final String strMd5 = al.md5(downloadTask.getUrl());
        as.a(downloadTask.getTargetFilePath(), new as.a() { // from class: com.kwad.sdk.c.2
            @Override // com.kwad.sdk.utils.as.a
            public final void pR() {
                com.kwad.sdk.core.download.b.GR().dT(strMd5);
            }

            @Override // com.kwad.sdk.utils.as.a
            public final void d(Throwable th) {
                com.kwad.sdk.core.download.b.GR().g(strMd5, th);
            }
        });
    }

    public static boolean AD() {
        try {
            Class.forName("com.kwad.sdk.api.proxy.app.BaseFragmentActivity.RequestInstallPermissionActivity");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private void AE() {
        k.a aVar;
        try {
            aVar = new k.a(true);
        } catch (Throwable th) {
            th.printStackTrace();
            aVar = null;
        }
        if (aVar != null) {
            com.kwad.framework.filedownloader.download.b.yc().b(new c.b().ca(Integer.MAX_VALUE).a(aVar));
            this.arN = true;
        }
    }

    private static void AF() {
        k.a aVar;
        try {
            aVar = new k.a(false);
        } catch (Throwable th) {
            th.printStackTrace();
            aVar = null;
        }
        if (aVar != null) {
            com.kwad.framework.filedownloader.download.b.yc().b(new c.b().ca(Integer.MAX_VALUE).a(aVar));
        }
    }

    public final int a(DownloadTask.DownloadRequest downloadRequest, com.kwad.sdk.a aVar) {
        DownloadTask downloadTask = new DownloadTask(downloadRequest);
        if (downloadRequest.getDownloadUrl().contains("downali.game.uc.cn")) {
            AE();
        } else if (this.arN) {
            AF();
        }
        if (this.arK.get(Integer.valueOf(downloadTask.getId())) != null) {
            a(downloadTask.getId(), downloadRequest);
            cm(downloadTask.getId());
        } else {
            this.arK.put(Integer.valueOf(downloadTask.getId()), downloadTask);
            this.arL.put(downloadTask.getUrl(), Integer.valueOf(downloadTask.getId()));
            downloadTask.submit();
        }
        a(downloadTask.getId(), null, this.arM);
        return downloadTask.getId();
    }

    public final DownloadTask cl(int i) {
        return this.arK.get(Integer.valueOf(i));
    }

    private void cm(int i) {
        DownloadTask downloadTask = this.arK.get(Integer.valueOf(i));
        if (downloadTask != null) {
            downloadTask.clearListener();
        }
    }

    public final boolean AG() {
        Iterator<Map.Entry<Integer, DownloadTask>> it = this.arK.entrySet().iterator();
        while (true) {
            boolean z = false;
            while (it.hasNext()) {
                DownloadTask value = it.next().getValue();
                if (value != null) {
                    int status = value.getStatus();
                    if (status == -2 || status == 1 || status == 2 || status == 3 || status == 5 || status == 6 || status == 10 || status == 11 || Math.abs(value.getStatusUpdateTime() - System.currentTimeMillis()) <= 120000) {
                        break;
                    }
                    z = true;
                }
            }
            return z;
        }
    }

    private void a(int i, com.kwad.sdk.a... aVarArr) {
        DownloadTask downloadTask = this.arK.get(Integer.valueOf(i));
        if (downloadTask != null) {
            for (int i2 = 0; i2 < 2; i2++) {
                com.kwad.sdk.a aVar = aVarArr[i2];
                if (aVar != null) {
                    aVar.setId(i);
                    downloadTask.addListener(aVar);
                }
            }
        }
    }

    public final void a(com.kwad.sdk.a aVar) {
        this.arM = aVar;
    }

    public final void cancel(int i) {
        DownloadTask downloadTask = this.arK.get(Integer.valueOf(i));
        if (downloadTask != null) {
            downloadTask.cancel();
            h(downloadTask);
        }
    }

    public static void cc(String str) {
        if (str == null) {
            return;
        }
        w.delete(com.kwad.framework.filedownloader.f.f.bD(str));
        w.delete(str);
    }

    private void h(DownloadTask downloadTask) {
        this.arK.remove(Integer.valueOf(downloadTask.getId()));
        this.arL.remove(downloadTask.getUrl());
    }

    public final void pause(int i) {
        DownloadTask downloadTask = this.arK.get(Integer.valueOf(i));
        if (downloadTask != null) {
            downloadTask.userPause();
        }
    }

    public final void resume(int i) {
        a(i, (DownloadTask.DownloadRequest) null);
    }

    public final void cn(int i) {
        DownloadTask downloadTaskCl = cl(i);
        if (downloadTaskCl == null) {
            return;
        }
        if (downloadTaskCl.isUserPause()) {
            downloadTaskCl.downloadType = 2;
            resume(i);
        } else {
            pause(i);
        }
    }

    private void a(int i, DownloadTask.DownloadRequest downloadRequest) {
        DownloadTask downloadTask = this.arK.get(Integer.valueOf(i));
        if (downloadTask != null) {
            downloadTask.resume(downloadRequest);
        }
    }

    static final class a {
        private static final c arR = new c();
    }
}
