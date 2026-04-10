package com.anythink.basead.f.a;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.basead.c.c;
import com.anythink.core.c.d;
import com.anythink.core.c.e;
import com.anythink.core.common.e.s;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private static b a;
    private Context b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ConcurrentHashMap<String, c> f6028d = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SimpleDateFormat f6027c = new SimpleDateFormat("yyyyMMdd");

    private b(Context context) {
        this.b = context.getApplicationContext();
    }

    public final boolean b(s sVar) {
        c cVarD = d(sVar);
        int i2 = sVar.R;
        return i2 != -1 && cVarD.f5895d >= i2;
    }

    public final boolean c(s sVar) {
        return System.currentTimeMillis() - d(sVar).f5896e <= sVar.S;
    }

    public final c d(s sVar) {
        String str = this.f6027c.format(new Date(System.currentTimeMillis()));
        c cVarA = this.f6028d.get(sVar.p());
        if (cVarA == null) {
            cVarA = com.anythink.basead.b.c.a(this.b).a(sVar.p());
            if (cVarA == null) {
                cVarA = new c();
                cVarA.a = sVar.p();
                cVarA.b = sVar.R;
                cVarA.f5894c = sVar.S;
                cVarA.f5896e = 0L;
                cVarA.f5895d = 0;
                cVarA.f5897f = str;
            }
            this.f6028d.put(sVar.p(), cVarA);
        }
        if (!TextUtils.equals(str, cVarA.f5897f)) {
            cVarA.f5897f = str;
            cVarA.f5895d = 0;
        }
        return cVarA;
    }

    public static b a(Context context) {
        if (a == null) {
            a = new b(context);
        }
        return a;
    }

    public final void a(s sVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str = this.f6027c.format(new Date(jCurrentTimeMillis));
        final c cVarD = d(sVar);
        if (cVarD.f5897f.equals(str)) {
            cVarD.f5895d++;
        } else {
            cVarD.f5895d = 1;
            cVarD.f5897f = str;
        }
        cVarD.f5896e = jCurrentTimeMillis;
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.basead.f.a.b.1
            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.basead.b.c.a(b.this.b).c(cVarD.f5897f);
                com.anythink.basead.b.c.a(b.this.b).a(cVarD);
            }
        });
    }

    public final String a() {
        List<c> listB = com.anythink.basead.b.c.a(this.b).b(this.f6027c.format(new Date(System.currentTimeMillis())));
        JSONArray jSONArray = new JSONArray();
        if (listB != null) {
            Iterator<c> it = listB.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().a);
            }
        }
        return jSONArray.toString();
    }

    public final boolean a(String str) {
        List<s> listE;
        d dVarA = e.a(this.b).a(str);
        if (dVarA == null || (listE = dVarA.E()) == null || listE.size() <= 0) {
            return false;
        }
        Iterator<s> it = listE.iterator();
        while (it.hasNext()) {
            if (!b(it.next())) {
                return false;
            }
        }
        return true;
    }
}
