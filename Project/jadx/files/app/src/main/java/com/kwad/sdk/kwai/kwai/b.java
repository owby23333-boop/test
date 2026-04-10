package com.kwad.sdk.kwai.kwai;

import android.content.Context;
import com.baidu.mobads.sdk.internal.bj;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.au;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.p;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    private static volatile b Yv;
    private Stack<AdTemplate> Yt = new Stack<>();
    private File Yu;
    private boolean mHasInit;

    public interface a {
        void gM();

        void tl();
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aa(AdTemplate adTemplate) {
        boolean z2 = false;
        Iterator<AdTemplate> it = this.Yt.iterator();
        while (it.hasNext()) {
            if (com.kwad.sdk.core.response.a.d.ck(it.next()) == com.kwad.sdk.core.response.a.d.ck(adTemplate)) {
                it.remove();
                z2 = true;
            }
        }
        if (!z2) {
            return;
        }
        ObjectOutputStream objectOutputStream = null;
        try {
            try {
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(this.Yu));
                try {
                    objectOutputStream2.writeObject(this.Yt);
                    com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream2);
                } catch (Exception e2) {
                    e = e2;
                    objectOutputStream = objectOutputStream2;
                    com.kwad.sdk.core.d.b.d("InstallTipsDataManager", " removeApkDownloadedData e" + e);
                    com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                } catch (Throwable th) {
                    th = th;
                    objectOutputStream = objectOutputStream2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ab(AdTemplate adTemplate) {
        this.Yt.add(adTemplate);
        ObjectOutputStream objectOutputStream = null;
        try {
            try {
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(ti()));
                try {
                    objectOutputStream2.writeObject(this.Yt);
                    com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream2);
                } catch (Exception e2) {
                    e = e2;
                    objectOutputStream = objectOutputStream2;
                    com.kwad.sdk.core.d.b.printStackTrace(e);
                    com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                } catch (Throwable th) {
                    th = th;
                    objectOutputStream = objectOutputStream2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static File ae(AdTemplate adTemplate) {
        File file = new File(com.kwad.sdk.core.download.a.A(com.kwad.sdk.core.response.a.d.cb(adTemplate)));
        if (p.G(file)) {
            return file;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized File ti() {
        if (this.Yu != null) {
            return this.Yu;
        }
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return null;
        }
        String strCU = au.cU(context);
        File file = new File(strCU);
        if (!file.exists()) {
            file.mkdir();
        }
        this.Yu = new File(strCU + File.separator + "uninstall_ad");
        if (!this.Yu.exists()) {
            try {
                this.Yu.createNewFile();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return this.Yu;
    }

    public static b tj() {
        if (Yv == null) {
            synchronized (b.class) {
                if (Yv == null) {
                    Yv = new b();
                }
            }
        }
        return Yv;
    }

    public final synchronized void a(final a aVar) {
        if (this.mHasInit) {
            return;
        }
        this.mHasInit = true;
        g.execute(new av() { // from class: com.kwad.sdk.kwai.kwai.b.1
            @Override // com.kwad.sdk.utils.av
            public final void doTask() {
                ObjectInputStream objectInputStream;
                try {
                    if (com.kwad.sdk.core.config.d.uv() != 0 && com.kwad.sdk.kwai.kwai.kwai.b.cO() <= 0) {
                        HashMap map = new HashMap();
                        File fileTi = b.this.ti();
                        ObjectOutputStream objectOutputStream = null;
                        try {
                            try {
                                if (!fileTi.exists()) {
                                    com.kwad.sdk.core.d.b.d("InstallTipsDataManager", "getCanShowDownloadData mDownloadFile is not exists");
                                }
                                b.this.Yt.clear();
                                objectInputStream = new ObjectInputStream(new FileInputStream(fileTi));
                            } catch (Exception e2) {
                                e = e2;
                                objectInputStream = null;
                            } catch (Throwable th) {
                                th = th;
                                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                                throw th;
                            }
                            try {
                                b.this.Yt = (Stack) objectInputStream.readObject();
                                if (!b.this.Yt.isEmpty()) {
                                    Stack stack = new Stack();
                                    while (!b.this.Yt.isEmpty()) {
                                        AdTemplate adTemplate = (AdTemplate) b.this.Yt.pop();
                                        if (adTemplate != null) {
                                            String strValueOf = String.valueOf(com.kwad.sdk.core.response.a.d.ck(adTemplate));
                                            File fileAe = b.ae(adTemplate);
                                            if (fileAe == null || !fileAe.exists() || fileAe.lastModified() + bj.f12906d <= System.currentTimeMillis()) {
                                                map.put(strValueOf, Boolean.TRUE);
                                            } else {
                                                stack.push(adTemplate);
                                            }
                                        }
                                    }
                                    while (!stack.isEmpty()) {
                                        b.this.Yt.push((AdTemplate) stack.pop());
                                    }
                                }
                            } catch (Exception e3) {
                                e = e3;
                                com.kwad.sdk.core.d.b.d("InstallTipsDataManager", " getCanShowDownloadBannerData e" + e);
                                if (aVar != null) {
                                    aVar.tl();
                                    com.kwad.sdk.crash.utils.b.closeQuietly(objectInputStream);
                                    com.kwad.sdk.crash.utils.b.closeQuietly(objectInputStream);
                                    return;
                                }
                            }
                            com.kwad.sdk.crash.utils.b.closeQuietly(objectInputStream);
                            try {
                                try {
                                    ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(fileTi));
                                    try {
                                        objectOutputStream2.writeObject(b.this.Yt);
                                        com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream2);
                                    } catch (Exception e4) {
                                        e = e4;
                                        objectOutputStream = objectOutputStream2;
                                        com.kwad.sdk.core.d.b.printStackTrace(e);
                                        if (aVar != null) {
                                            aVar.tl();
                                            com.kwad.sdk.crash.utils.b.closeQuietly(objectInputStream);
                                            com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                                            return;
                                        }
                                        com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                                        com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                                        throw th;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        objectOutputStream = objectOutputStream2;
                                        com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                                        throw th;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                            } catch (Exception e5) {
                                e = e5;
                            }
                            if (aVar != null) {
                                aVar.gM();
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                            throw th;
                        }
                    }
                } catch (Throwable th5) {
                    com.kwad.components.core.c.a.b(th5);
                }
            }
        });
    }

    public final void ac(final AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        g.execute(new Runnable() { // from class: com.kwad.sdk.kwai.kwai.b.2
            @Override // java.lang.Runnable
            public final void run() {
                b.this.ab(adTemplate);
            }
        });
    }

    public final void ad(final AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        g.execute(new Runnable() { // from class: com.kwad.sdk.kwai.kwai.b.3
            @Override // java.lang.Runnable
            public final void run() {
                b.this.aa(adTemplate);
            }
        });
    }

    public final synchronized AdTemplate tk() {
        AdTemplate adTemplate;
        adTemplate = null;
        Stack stack = (Stack) this.Yt.clone();
        while (true) {
            if (stack.isEmpty()) {
                break;
            }
            AdTemplate adTemplate2 = (AdTemplate) stack.pop();
            if (adTemplate2 != null) {
                String str = com.kwad.sdk.core.response.a.d.cb(adTemplate2).adBaseInfo.appPackageName;
                Context context = KsAdSDKImpl.get().getContext();
                File fileAe = ae(adTemplate2);
                if (fileAe != null && fileAe.exists() && fileAe.lastModified() + bj.f12906d > System.currentTimeMillis() && !aj.ah(context, str)) {
                    adTemplate = adTemplate2;
                    break;
                }
            }
        }
        return adTemplate;
    }
}
