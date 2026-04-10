package com.anythink.expressad.mbbanner.a.d;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.p;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.foundation.h.w;
import com.anythink.expressad.foundation.h.x;
import com.anythink.expressad.mbbanner.a.b.e;
import com.anythink.expressad.mbbanner.a.c.d;
import com.anythink.expressad.mbbanner.a.c.f;
import com.anythink.expressad.mbbanner.a.c.g;
import com.anythink.expressad.videocommon.b.i;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    private static final String a = "b";
    private Context b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private e f10817d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.anythink.expressad.mbbanner.a.e.a f10818e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.anythink.expressad.mbbanner.a.c.b f10819f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private d f10820g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f10816c = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile boolean f10821h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Timer f10822i = new Timer();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile List<String> f10823j = new ArrayList();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile boolean f10824k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile boolean f10825l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private volatile boolean f10826m = false;

    /* JADX INFO: renamed from: com.anythink.expressad.mbbanner.a.d.b$1, reason: invalid class name */
    final class AnonymousClass1 extends TimerTask {
        final /* synthetic */ String a;

        AnonymousClass1(String str) {
            this.a = str;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            if (b.this.f10821h) {
                return;
            }
            b.b(b.this);
            b.this.a(this.a, -1, "", false);
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.mbbanner.a.d.b$2, reason: invalid class name */
    final class AnonymousClass2 implements Runnable {
        final /* synthetic */ com.anythink.expressad.foundation.d.d a;

        AnonymousClass2(com.anythink.expressad.foundation.d.d dVar) {
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ArrayList<com.anythink.expressad.foundation.d.c> arrayList;
            o.b(b.a, "在单独子线程保存数据库 开始");
            com.anythink.expressad.foundation.d.d dVar = this.a;
            if (dVar != null && (arrayList = dVar.J) != null && arrayList.size() > 0) {
                Context unused = b.this.b;
                com.anythink.expressad.mbbanner.a.e.b.a();
            }
            o.b(b.a, "在单独子线程保存数据库 完成");
        }
    }

    public b(Context context, e eVar, com.anythink.expressad.mbbanner.a.c.b bVar, com.anythink.expressad.mbbanner.a.e.a aVar) {
        this.b = context.getApplicationContext();
        this.f10817d = eVar;
        this.f10819f = bVar;
        this.f10818e = aVar;
    }

    static /* synthetic */ boolean b(b bVar) {
        bVar.f10821h = true;
        return true;
    }

    private void d(String str) {
        this.f10817d.a(str);
    }

    private void b(String str) {
        o.b(a, "在子线程处理业务逻辑 完成");
        o.b(a, "downloadResource--> Fail");
        this.f10821h = true;
        this.f10818e.b(this.f10819f, str);
        this.f10820g.a(str);
    }

    private void c(String str) {
        this.f10822i.schedule(new AnonymousClass1(str), 60000L);
    }

    private void a(String str) {
        if (this.f10826m) {
            return;
        }
        if ((this.f10824k || this.f10825l) && this.f10823j.size() == 0) {
            o.b(a, "在子线程处理业务逻辑 完成");
            this.f10821h = true;
            this.f10826m = true;
            this.f10822i.cancel();
            this.f10818e.a(this.f10819f, str);
            this.f10820g.a(str);
        }
    }

    private int c() {
        try {
            int iB = this.f10817d.b();
            if (iB > this.f10817d.c()) {
                return 0;
            }
            return iB;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    private void b(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        i.a().a(str2, new f(this, str));
    }

    private void b(com.anythink.expressad.foundation.d.d dVar) {
        new Thread(new AnonymousClass2(dVar)).start();
    }

    public final void a(String str, int i2, String str2, boolean z2) {
        if (!z2) {
            if (i2 == -1) {
                o.d(a, " unitId =" + str + " --> time out!");
            }
            this.f10822i.cancel();
            o.b(a, "在子线程处理业务逻辑 完成");
            o.b(a, "downloadResource--> Fail");
            this.f10821h = true;
            this.f10818e.b(this.f10819f, str);
            this.f10820g.a(str);
            return;
        }
        if (i2 == 1) {
            o.b(a, "downloadResource--> Success Image");
            synchronized (this) {
                this.f10823j.remove(str2);
                if (this.f10823j.size() == 0) {
                    a(str);
                }
            }
            return;
        }
        if (i2 == 2) {
            o.b(a, "downloadResource--> Success banner_html");
            this.f10825l = true;
            a(str);
        } else if (i2 == 3) {
            o.b(a, "downloadResource--> Success banner_url");
            this.f10824k = true;
            a(str);
        }
    }

    private String b() {
        return this.f10817d.a();
    }

    private void b(String str, List<com.anythink.expressad.foundation.d.c> list) {
        int size = this.f10816c;
        if (list != null) {
            try {
                if (list.size() > 0) {
                    size += list.size();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (size > this.f10817d.c()) {
            o.b(a, "saveNextOffset 重置offset为0");
            size = 0;
        }
        o.b(a, "saveNextOffset 算出 下次的offset是:".concat(String.valueOf(size)));
        if (w.b(str)) {
            this.f10817d.a(size);
        }
    }

    protected final void a(String str, com.anythink.expressad.foundation.d.d dVar, d dVar2) throws Throwable {
        this.f10820g = dVar2;
        if (dVar == null) {
            this.f10818e.a(this.f10819f, "campaignUnit is NULL!", str);
            this.f10820g.a(str);
            return;
        }
        List<com.anythink.expressad.foundation.d.c> listA = a(dVar);
        new Thread(new AnonymousClass2(dVar)).start();
        if (listA.size() == 0) {
            o.b(a, "tryDownloadOnLoadSuccess 返回的campaign 没有符合下载规则的");
            this.f10818e.a(this.f10819f, com.anythink.expressad.reward.a.d.a, str);
            this.f10820g.a(str);
            return;
        }
        o.b(a, "在子线程处理业务逻辑 开始");
        this.f10822i.schedule(new AnonymousClass1(str), 60000L);
        this.f10817d.a(dVar.c());
        int size = this.f10816c;
        int i2 = 0;
        try {
            if (listA.size() > 0) {
                size += listA.size();
            }
            if (size > this.f10817d.c()) {
                o.b(a, "saveNextOffset 重置offset为0");
                size = 0;
            }
            o.b(a, "saveNextOffset 算出 下次的offset是:".concat(String.valueOf(size)));
            if (w.b(str)) {
                this.f10817d.a(size);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.anythink.expressad.foundation.d.c cVar = listA.get(0);
        String strTrim = cVar.p().trim();
        if (!TextUtils.isEmpty(strTrim)) {
            if (!TextUtils.isEmpty(strTrim)) {
                i.a().a(strTrim, new f(this, str));
            }
            if (listA.size() > 0) {
                while (i2 < listA.size()) {
                    listA.get(i2).d(cVar.p());
                    listA.get(i2).a(true);
                    i2++;
                }
            }
        } else {
            String strTrim2 = cVar.q().trim();
            if (!TextUtils.isEmpty(strTrim2)) {
                String strA = a(str, strTrim2);
                if (listA.size() > 0) {
                    while (i2 < listA.size()) {
                        listA.get(i2).e(strA);
                        listA.get(i2).a(strTrim2.contains("<MBTPLMARK>"));
                        i2++;
                    }
                }
            } else {
                this.f10825l = true;
                this.f10824k = true;
            }
        }
        a(str, listA);
    }

    private List<com.anythink.expressad.foundation.d.c> a(com.anythink.expressad.foundation.d.d dVar) {
        ArrayList arrayList = new ArrayList();
        if (dVar != null) {
            try {
                if (dVar.J != null && dVar.J.size() > 0) {
                    ArrayList<com.anythink.expressad.foundation.d.c> arrayList2 = dVar.J;
                    o.b(a, "getNeedShowList 总共返回的campaign有：" + arrayList2.size());
                    for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                        com.anythink.expressad.foundation.d.c cVar = arrayList2.get(i2);
                        if (cVar != null && cVar.O() != 99 && (!TextUtils.isEmpty(cVar.p()) || !TextUtils.isEmpty(cVar.q()) || !TextUtils.isEmpty(cVar.be()))) {
                            if (t.a(cVar)) {
                                cVar.i(t.a(this.b, cVar.ba()) ? 1 : 2);
                            }
                            if (cVar.ae() != 1 && t.a(this.b, cVar.ba())) {
                                if (t.a(cVar)) {
                                    arrayList.add(cVar);
                                }
                            } else {
                                arrayList.add(cVar);
                            }
                        }
                    }
                    o.b(a, "getNeedShowList 返回有以下带有视频素材的campaign：" + arrayList.size());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return arrayList;
    }

    private void a(String str, List<com.anythink.expressad.foundation.d.c> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (com.anythink.expressad.foundation.d.c cVar : list) {
            if (!TextUtils.isEmpty(cVar.be())) {
                this.f10823j.add(cVar.be());
                com.anythink.expressad.foundation.g.d.b.a(this.b).a(cVar.be(), new g(this, str));
            }
        }
    }

    private String a(String str, String str2) throws Throwable {
        String str3 = "";
        if (!TextUtils.isEmpty(str2)) {
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    String strB = com.anythink.expressad.foundation.g.c.d.b(com.anythink.expressad.foundation.g.c.a.ANYTHINK_700_HTML);
                    String strA = p.a(x.a(str2));
                    if (TextUtils.isEmpty(strA)) {
                        strA = String.valueOf(System.currentTimeMillis());
                    }
                    File file = new File(strB, strA.concat(".html"));
                    Uri.parse(str2).getPath();
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        fileOutputStream2.write(str2.getBytes());
                        fileOutputStream2.flush();
                        String absolutePath = file.getAbsolutePath();
                        try {
                            fileOutputStream2.close();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        str3 = absolutePath;
                    } catch (Exception e3) {
                        e = e3;
                        fileOutputStream = fileOutputStream2;
                        e.printStackTrace();
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e5) {
                                e5.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e6) {
                e = e6;
            }
            File file2 = new File(str3);
            if (file2.exists() && file2.isFile() && file2.canRead()) {
                a(str, 2, str2, true);
            } else {
                a(str, 2, str2, false);
            }
        }
        return str3;
    }
}
