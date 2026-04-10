package com.anythink.core.a;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.c.d;
import com.anythink.core.common.c.l;
import com.anythink.core.common.e.ae;
import com.anythink.core.common.e.ai;
import com.anythink.core.common.v;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static a f6464e;
    l a;
    SimpleDateFormat b = new SimpleDateFormat("yyyyMMdd");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    SimpleDateFormat f6465c = new SimpleDateFormat("yyyyMMddHH");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Context f6466d;

    private a(Context context) {
        this.a = l.a(com.anythink.core.common.c.c.a(context));
        this.f6466d = context;
    }

    public static a a(Context context) {
        if (f6464e == null) {
            f6464e = new a(context);
        }
        return f6464e;
    }

    public final void a() {
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.a.a.1
            @Override // java.lang.Runnable
            public final void run() {
                a aVar = a.this;
                aVar.a.a(aVar.b.format(new Date(System.currentTimeMillis())));
            }
        });
    }

    public final boolean a(d dVar, String str) {
        if (dVar.ab() == -1 && dVar.ac() == -1) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        ae aeVarA = this.a.a(str, this.b.format(new Date(jCurrentTimeMillis)), this.f6465c.format(new Date(jCurrentTimeMillis)));
        int i2 = aeVarA != null ? aeVarA.f7139c : 0;
        int i3 = aeVarA != null ? aeVarA.f7140d : 0;
        if (dVar.ab() == -1 || i2 < dVar.ab()) {
            return dVar.ac() != -1 && ((long) i3) >= dVar.ac();
        }
        return true;
    }

    public final boolean a(String str, ai aiVar) {
        if (aiVar.f() == -1 && aiVar.e() == -1) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        ae.a aVarA = this.a.a(str, aiVar.t(), this.b.format(new Date(jCurrentTimeMillis)), this.f6465c.format(new Date(jCurrentTimeMillis)));
        if (aVarA == null) {
            aVarA = new ae.a();
        }
        if (aiVar.f() == -1 || aVarA.f7145e < aiVar.f()) {
            return aiVar.e() != -1 && aVarA.f7144d >= aiVar.e();
        }
        return true;
    }

    public final ae a(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        return this.a.a(str, this.b.format(new Date(jCurrentTimeMillis)), this.f6465c.format(new Date(jCurrentTimeMillis)));
    }

    public final ae.a a(String str, String str2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        return this.a.a(str, str2, this.b.format(new Date(jCurrentTimeMillis)), this.f6465c.format(new Date(jCurrentTimeMillis)));
    }

    public final Map<String, ae> a(int i2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        return this.a.a(i2, this.b.format(new Date(jCurrentTimeMillis)), this.f6465c.format(new Date(jCurrentTimeMillis)));
    }

    public final void a(String str, String str2, String str3) {
        synchronized (v.a().a(str2)) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String str4 = this.b.format(new Date(jCurrentTimeMillis));
            String str5 = this.f6465c.format(new Date(jCurrentTimeMillis));
            int i2 = Integer.parseInt(str);
            ae.a aVarA = a(str2, str3);
            if (aVarA == null) {
                aVarA = new ae.a();
                aVarA.a = str3;
            }
            if (!TextUtils.equals(str4, aVarA.f7143c)) {
                aVarA.f7144d = 1;
                aVarA.f7143c = str4;
            } else {
                aVarA.f7144d++;
            }
            if (!TextUtils.equals(str5, aVarA.b)) {
                aVarA.f7145e = 1;
                aVarA.b = str5;
            } else {
                aVarA.f7145e++;
            }
            aVarA.f7146f = jCurrentTimeMillis;
            this.a.a(i2, str2, aVarA);
        }
    }
}
