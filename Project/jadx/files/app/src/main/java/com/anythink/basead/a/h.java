package com.anythink.basead.a;

import android.content.Context;
import android.content.IntentFilter;
import com.anythink.core.common.m;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class h {
    private static volatile h b;
    g a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f5833c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ConcurrentHashMap<String, com.anythink.core.common.e.i> f5834d = new ConcurrentHashMap<>();

    private h(Context context) {
        this.f5833c = context;
    }

    public static h a(Context context) {
        if (b == null) {
            synchronized (h.class) {
                if (b == null) {
                    b = new h(context);
                }
            }
        }
        return b;
    }

    private void b() {
        if (this.a != null) {
            m.a(this.f5833c).a(this.a);
            this.a = null;
        }
    }

    public final void c(String str, String str2) {
        com.anythink.core.common.e.i iVar = this.f5834d.get(str);
        if (iVar != null) {
            com.anythink.basead.c.i iVar2 = new com.anythink.basead.c.i("", "");
            iVar2.f5937i = new com.anythink.basead.c.b();
            iVar2.f5937i.a = str2;
            b.a(20, iVar, iVar2);
        }
    }

    public final void d(String str, String str2) {
        com.anythink.core.common.e.i iVarRemove = this.f5834d.remove(str);
        if (iVarRemove != null) {
            com.anythink.basead.c.i iVar = new com.anythink.basead.c.i("", "");
            iVar.f5937i = new com.anythink.basead.c.b();
            iVar.f5937i.a = str2;
            b.a(21, iVarRemove, iVar);
        }
        if (this.f5834d.size() != 0 || this.a == null) {
            return;
        }
        m.a(this.f5833c).a(this.a);
        this.a = null;
    }

    public final void b(String str, String str2) {
        com.anythink.core.common.e.i iVar = this.f5834d.get(str);
        if (iVar != null) {
            com.anythink.basead.c.i iVar2 = new com.anythink.basead.c.i("", "");
            iVar2.f5937i = new com.anythink.basead.c.b();
            iVar2.f5937i.a = str2;
            b.a(19, iVar, iVar2);
        }
    }

    public final void a() {
        if (this.f5833c != null && this.a == null) {
            this.a = new g();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(com.anythink.china.common.a.b);
            intentFilter.addAction(com.anythink.china.common.a.f6363c);
            intentFilter.addAction(com.anythink.china.common.a.f6364d);
            intentFilter.addAction(com.anythink.china.common.a.f6365e);
            m.a(this.f5833c).a(this.a, intentFilter);
        }
    }

    public final void a(String str, com.anythink.core.common.e.i iVar) {
        this.f5834d.put(str, iVar);
    }

    public final void a(String str, String str2) {
        com.anythink.core.common.e.i iVar = this.f5834d.get(str);
        if (iVar != null) {
            com.anythink.basead.c.i iVar2 = new com.anythink.basead.c.i("", "");
            iVar2.f5937i = new com.anythink.basead.c.b();
            iVar2.f5937i.a = str2;
            b.a(18, iVar, iVar2);
        }
    }
}
