package com.kwad.sdk.a.a;

import android.content.Context;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.w;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

/* JADX INFO: loaded from: classes4.dex */
public class b {
    private static volatile b asX;
    private Stack<AdTemplate> asV = new Stack<>();
    private File asW;
    private boolean mHasInit;

    public interface a {
        void CT();

        void hy();
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized File CQ() {
        File file = this.asW;
        if (file != null) {
            return file;
        }
        String strDI = be.dI(ServiceProvider.getContext());
        File file2 = new File(strDI);
        if (!file2.exists()) {
            file2.mkdir();
        }
        File file3 = new File(strDI + File.separator + "uninstall_ad");
        this.asW = file3;
        if (!file3.exists()) {
            try {
                this.asW.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return this.asW;
        }
        return this.asW;
    }

    public final synchronized void a(final a aVar) {
        if (this.mHasInit) {
            return;
        }
        this.mHasInit = true;
        h.execute(new bg() { // from class: com.kwad.sdk.a.a.b.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                ObjectInputStream objectInputStream;
                try {
                    if (com.kwad.sdk.core.config.e.Fk() != 0 && com.kwad.sdk.a.a.a.b.dO() <= 0) {
                        HashMap map = new HashMap();
                        File fileCQ = b.this.CQ();
                        Closeable closeable = null;
                        try {
                            if (!fileCQ.exists()) {
                                com.kwad.sdk.core.d.c.d("InstallTipsDataManager", "getCanShowDownloadData mDownloadFile is not exists");
                            }
                            b.this.asV.clear();
                            objectInputStream = new ObjectInputStream(new FileInputStream(fileCQ));
                        } catch (Exception e) {
                            e = e;
                            objectInputStream = null;
                        } catch (Throwable th) {
                            th = th;
                            com.kwad.sdk.crash.utils.b.closeQuietly(closeable);
                            throw th;
                        }
                        try {
                            try {
                                b.this.asV = (Stack) objectInputStream.readObject();
                                if (!b.this.asV.isEmpty()) {
                                    Stack stack = new Stack();
                                    while (!b.this.asV.isEmpty()) {
                                        AdTemplate adTemplate = (AdTemplate) b.this.asV.pop();
                                        if (adTemplate != null) {
                                            String strValueOf = String.valueOf(com.kwad.sdk.core.response.b.e.ev(adTemplate));
                                            File fileAW = b.aW(adTemplate);
                                            if (fileAW != null && fileAW.exists() && fileAW.lastModified() + 604800000 > System.currentTimeMillis()) {
                                                stack.push(adTemplate);
                                            } else {
                                                map.put(strValueOf, Boolean.TRUE);
                                            }
                                        }
                                    }
                                    while (!stack.isEmpty()) {
                                        b.this.asV.push((AdTemplate) stack.pop());
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                closeable = objectInputStream;
                                com.kwad.sdk.crash.utils.b.closeQuietly(closeable);
                                throw th;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            com.kwad.sdk.core.d.c.d("InstallTipsDataManager", " getCanShowDownloadBannerData e" + e);
                            a aVar2 = aVar;
                            if (aVar2 != null) {
                                aVar2.CT();
                                com.kwad.sdk.crash.utils.b.closeQuietly(objectInputStream);
                                com.kwad.sdk.crash.utils.b.closeQuietly(objectInputStream);
                                return;
                            }
                        }
                        com.kwad.sdk.crash.utils.b.closeQuietly(objectInputStream);
                        try {
                            try {
                                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileCQ));
                                try {
                                    objectOutputStream.writeObject(b.this.asV);
                                    com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                                } catch (Exception e3) {
                                    e = e3;
                                    closeable = objectOutputStream;
                                    com.kwad.sdk.core.d.c.printStackTrace(e);
                                    a aVar3 = aVar;
                                    if (aVar3 != null) {
                                        aVar3.CT();
                                        com.kwad.sdk.crash.utils.b.closeQuietly(objectInputStream);
                                        com.kwad.sdk.crash.utils.b.closeQuietly(closeable);
                                        return;
                                    }
                                    com.kwad.sdk.crash.utils.b.closeQuietly(closeable);
                                    com.kwad.sdk.crash.utils.b.closeQuietly(closeable);
                                    throw th;
                                } catch (Throwable th3) {
                                    th = th3;
                                    closeable = objectOutputStream;
                                    com.kwad.sdk.crash.utils.b.closeQuietly(closeable);
                                    throw th;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        } catch (Exception e4) {
                            e = e4;
                        }
                        a aVar4 = aVar;
                        if (aVar4 != null) {
                            aVar4.hy();
                        }
                    }
                } catch (Throwable th5) {
                    com.kwad.components.core.d.a.reportSdkCaughtException(th5);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aS(AdTemplate adTemplate) {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        Exception e;
        Iterator<AdTemplate> it = this.asV.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (com.kwad.sdk.core.response.b.e.ev(it.next()) == com.kwad.sdk.core.response.b.e.ev(adTemplate)) {
                it.remove();
                z = true;
            }
        }
        if (z) {
            try {
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.asW));
            } catch (Exception e2) {
                objectOutputStream = null;
                e = e2;
            } catch (Throwable th2) {
                objectOutputStream = null;
                th = th2;
                com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                throw th;
            }
            try {
                try {
                    objectOutputStream.writeObject(this.asV);
                    com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                } catch (Throwable th3) {
                    th = th3;
                    com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                com.kwad.sdk.core.d.c.d("InstallTipsDataManager", " removeApkDownloadedData e" + e);
                com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aT(AdTemplate adTemplate) {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        Exception e;
        this.asV.add(adTemplate);
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(CQ()));
        } catch (Exception e2) {
            objectOutputStream = null;
            e = e2;
        } catch (Throwable th2) {
            objectOutputStream = null;
            th = th2;
            com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
            throw th;
        }
        try {
            try {
                objectOutputStream.writeObject(this.asV);
                com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
            } catch (Throwable th3) {
                th = th3;
                com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            com.kwad.sdk.core.d.c.printStackTrace(e);
            com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
        }
    }

    public static b CR() {
        if (asX == null) {
            synchronized (b.class) {
                if (asX == null) {
                    asX = new b();
                }
            }
        }
        return asX;
    }

    public final void aU(final AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        h.execute(new bg() { // from class: com.kwad.sdk.a.a.b.2
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                b.this.aT(adTemplate);
            }
        });
    }

    public final void aV(final AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        h.execute(new bg() { // from class: com.kwad.sdk.a.a.b.3
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                b.this.aS(adTemplate);
            }
        });
    }

    public final synchronized AdTemplate CS() {
        AdTemplate adTemplate;
        Stack stack = (Stack) this.asV.clone();
        while (true) {
            if (stack.isEmpty()) {
                adTemplate = null;
                break;
            }
            adTemplate = (AdTemplate) stack.pop();
            if (adTemplate != null) {
                String str = com.kwad.sdk.core.response.b.e.el(adTemplate).adBaseInfo.appPackageName;
                Context context = ServiceProvider.getContext();
                File fileAW = aW(adTemplate);
                if (fileAW != null && fileAW.exists() && fileAW.lastModified() + 604800000 > System.currentTimeMillis() && !as.ap(context, str)) {
                    break;
                }
            }
        }
        return adTemplate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static File aW(AdTemplate adTemplate) {
        File file = new File(com.kwad.sdk.core.download.a.H(com.kwad.sdk.core.response.b.e.el(adTemplate)));
        if (w.O(file)) {
            return file;
        }
        return null;
    }
}
