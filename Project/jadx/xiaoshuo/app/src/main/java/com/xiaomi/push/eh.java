package com.xiaomi.push;

import com.xiaomi.push.eg;
import com.xiaomi.push.eg.c;
import java.io.File;
import java.util.Date;

/* JADX INFO: loaded from: classes8.dex */
class eh extends eg.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f7914a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    final /* synthetic */ eg f278a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    File f279a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    final /* synthetic */ String f280a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    final /* synthetic */ Date f281a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    final /* synthetic */ boolean f282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f7915b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    final /* synthetic */ Date f283b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eh(eg egVar, int i, Date date, Date date2, String str, String str2, boolean z) {
        super();
        this.f278a = egVar;
        this.f7914a = i;
        this.f281a = date;
        this.f283b = date2;
        this.f280a = str;
        this.f7915b = str2;
        this.f282a = z;
    }

    @Override // com.xiaomi.push.eg.b, com.xiaomi.push.aj.b
    public void b() {
        try {
            File file = new File(this.f278a.f271a.getFilesDir() + "/.logcache");
            if (w.m818a(file)) {
                file.mkdirs();
                if (file.isDirectory()) {
                    ef efVar = new ef();
                    efVar.a(this.f7914a);
                    this.f279a = efVar.a(this.f278a.f271a, this.f281a, this.f283b, file);
                }
            }
        } catch (NullPointerException unused) {
        }
    }

    @Override // com.xiaomi.push.aj.b
    /* JADX INFO: renamed from: c */
    public void mo323c() {
        File file = this.f279a;
        if (file != null && file.exists()) {
            this.f278a.f272a.add(this.f278a.new c(this.f280a, this.f7915b, this.f279a, this.f282a));
        }
        this.f278a.a(0L);
    }
}
