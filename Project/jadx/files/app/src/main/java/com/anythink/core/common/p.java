package com.anythink.core.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.umeng.message.common.inter.ITagManager;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class p {
    public static final String b = "Y29tLnhpYW9taS5tYXJrZXQuRE1fUEFHRV9PUEVORUQ=";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f7839c = "Y29tLnhpYW9taS5tYXJrZXQuRE1fUEFHRV9DTE9TRUQ=";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f7840d = "Y29tLnhpYW9taS5tYXJrZXQuRElSRUNUX01BSUxfU1RBVFVT";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f7841e = "Y29udGVudDovL2NvbS54aWFvbWkubWFya2V0LnByb3ZpZGVyLkRpcmVjdE1haWxQcm92aWRlcg==";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f7842f = "code";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f7843g = "packageName";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static volatile String f7844j;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static volatile p f7845n;
    BroadcastReceiver a;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private CopyOnWriteArrayList<com.anythink.core.common.e.i> f7846h = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AtomicBoolean f7847i = new AtomicBoolean(false);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile Boolean f7848k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private com.anythink.core.common.e.i f7849l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Context f7850m;

    /* JADX INFO: renamed from: com.anythink.core.common.p$2, reason: invalid class name */
    final class AnonymousClass2 extends BroadcastReceiver {
        AnonymousClass2() {
        }

        private com.anythink.core.common.e.i a(String str) {
            if (p.this.f7849l != null && TextUtils.equals(p.this.f7849l.B(), str)) {
                return p.this.f7849l;
            }
            if (p.this.f7846h == null || p.this.f7846h.size() <= 0) {
                return null;
            }
            for (com.anythink.core.common.e.i iVar : p.this.f7846h) {
                if (iVar != null && TextUtils.equals(iVar.B(), str)) {
                    return iVar;
                }
            }
            return null;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            Bundle extras;
            com.anythink.core.common.e.i iVar;
            String action = intent.getAction();
            if (TextUtils.isEmpty(action) || action.equals(com.anythink.core.common.k.c.b(p.b)) || action.equals(com.anythink.core.common.k.c.b(p.f7839c)) || !action.equals(com.anythink.core.common.k.c.b(p.f7840d)) || (extras = intent.getExtras()) == null) {
                return;
            }
            int i2 = extras.getInt("code", -1);
            String string = extras.getString("packageName", "");
            if (i2 == -1 || TextUtils.isEmpty(string)) {
                return;
            }
            if (p.this.f7849l != null && TextUtils.equals(p.this.f7849l.B(), string)) {
                iVar = p.this.f7849l;
            } else if (p.this.f7846h == null || p.this.f7846h.size() <= 0) {
                iVar = null;
            } else {
                for (com.anythink.core.common.e.i iVar2 : p.this.f7846h) {
                    if (iVar2 != null && TextUtils.equals(iVar2.B(), string)) {
                        iVar = iVar2;
                        break;
                    }
                }
                iVar = null;
            }
            if (iVar == null) {
                return;
            }
            if (i2 == 4) {
                p.this.b(iVar);
            }
            com.anythink.core.common.j.c.a(iVar.j(), iVar.p(), "", i2, "", 0L, 0L);
        }
    }

    private p() {
    }

    private com.anythink.core.common.e.i e() {
        return this.f7849l;
    }

    private void f() {
        if (this.f7848k == null || !this.f7848k.booleanValue() || this.f7850m == null) {
            return;
        }
        try {
            this.a = new AnonymousClass2();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(com.anythink.core.common.k.c.b(b));
            intentFilter.addAction(com.anythink.core.common.k.c.b(f7839c));
            intentFilter.addAction(com.anythink.core.common.k.c.b(f7840d));
            this.f7850m.registerReceiver(this.a, intentFilter);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Boolean g() {
        Cursor cursorQuery;
        Context contextG = com.anythink.core.common.b.n.a().g();
        Boolean boolValueOf = null;
        if (contextG != null && contextG.getContentResolver() != null) {
            try {
                cursorQuery = contextG.getContentResolver().query(Uri.parse(com.anythink.core.common.k.c.b(f7841e)), null, null, null, null);
            } catch (Throwable unused) {
                cursorQuery = null;
            }
            if (cursorQuery != null) {
                while (cursorQuery.moveToNext()) {
                    try {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("support"));
                        if (!TextUtils.isEmpty(string) && !string.equalsIgnoreCase("null") && (string.equalsIgnoreCase(ITagManager.STATUS_FALSE) || string.equalsIgnoreCase(ITagManager.STATUS_TRUE))) {
                            boolValueOf = Boolean.valueOf(Boolean.parseBoolean(string));
                        }
                    } catch (Throwable unused2) {
                    }
                    try {
                        f7844j = cursorQuery.getString(cursorQuery.getColumnIndex("detailStyle"));
                    } catch (Exception unused3) {
                    }
                }
                try {
                    cursorQuery.close();
                } catch (Throwable unused4) {
                }
            }
        }
        return boolValueOf;
    }

    public final void b(com.anythink.core.common.e.i iVar) {
        if (this.f7848k == null || iVar == null || !this.f7848k.booleanValue()) {
            return;
        }
        this.f7849l = null;
        try {
            this.f7846h.remove(iVar);
        } catch (Exception unused) {
        }
    }

    public final int c() {
        if (this.f7848k != null) {
            return this.f7848k.booleanValue() ? 1 : 0;
        }
        return -1;
    }

    public static p a() {
        if (f7845n == null) {
            synchronized (p.class) {
                if (f7845n == null) {
                    f7845n = new p();
                }
            }
        }
        return f7845n;
    }

    private void b(Context context) {
        BroadcastReceiver broadcastReceiver = this.a;
        if (broadcastReceiver == null || context == null) {
            return;
        }
        try {
            context.unregisterReceiver(broadcastReceiver);
        } catch (Throwable unused) {
        }
        this.f7849l = null;
        this.f7846h.clear();
        this.f7846h = null;
        this.a = null;
        this.f7850m = null;
    }

    public final void a(com.anythink.core.common.e.i iVar) {
        if (this.f7848k == null || iVar == null || !this.f7848k.booleanValue()) {
            return;
        }
        this.f7849l = iVar;
        this.f7846h.add(iVar);
    }

    public static String b() {
        try {
            return f7844j == null ? "" : String.format("[%s]", f7844j);
        } catch (Throwable unused) {
            return "";
        }
    }

    static /* synthetic */ void b(p pVar) {
        if (pVar.f7848k == null || !pVar.f7848k.booleanValue() || pVar.f7850m == null) {
            return;
        }
        try {
            pVar.a = pVar.new AnonymousClass2();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(com.anythink.core.common.k.c.b(b));
            intentFilter.addAction(com.anythink.core.common.k.c.b(f7839c));
            intentFilter.addAction(com.anythink.core.common.k.c.b(f7840d));
            pVar.f7850m.registerReceiver(pVar.a, intentFilter);
        } catch (Throwable unused) {
        }
    }

    public final void a(Context context) {
        this.f7850m = context;
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.p.1
            @Override // java.lang.Runnable
            public final void run() {
                if (p.this.f7847i.compareAndSet(false, true)) {
                    try {
                        p.this.f7848k = p.g();
                        p.b(p.this);
                    } catch (Throwable unused) {
                    }
                }
            }
        });
    }
}
