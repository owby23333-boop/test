package com.anythink.expressad.foundation.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.anythink.expressad.foundation.h.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static final String a = "a";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile a f10112c;
    SharedPreferences b;

    private a() {
    }

    public static a a() {
        if (f10112c == null) {
            synchronized (a.class) {
                if (f10112c == null) {
                    f10112c = new a();
                }
            }
        }
        return f10112c;
    }

    private int b(String str, int i2) {
        try {
            Context contextD = com.anythink.expressad.foundation.b.a.b().d();
            if (contextD == null) {
                return i2;
            }
            if (this.b == null) {
                this.b = contextD.getSharedPreferences(com.anythink.expressad.foundation.g.a.f10418o, 0);
            }
            return this.b.getInt(str, i2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return i2;
        }
    }

    private int c(String str) {
        try {
            Context contextD = com.anythink.expressad.foundation.b.a.b().d();
            if (contextD == null) {
                return 0;
            }
            if (this.b == null && contextD != null) {
                this.b = contextD.getSharedPreferences(com.anythink.expressad.foundation.g.a.f10418o, 0);
            }
            return this.b.getInt(str, 0);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    private Long d(String str) {
        try {
            Context contextD = com.anythink.expressad.foundation.b.a.b().d();
            if (contextD == null) {
                o.d(a, "context is null in get");
                return 0L;
            }
            if (this.b == null && contextD != null) {
                this.b = contextD.getSharedPreferences(com.anythink.expressad.foundation.g.a.f10418o, 0);
            }
            return Long.valueOf(this.b.getLong(str, 0L));
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    private List<String> b() {
        ArrayList arrayList = new ArrayList();
        Context contextD = com.anythink.expressad.foundation.b.a.b().d();
        if (contextD == null) {
            return null;
        }
        if (this.b == null && contextD != null) {
            this.b = contextD.getSharedPreferences(com.anythink.expressad.foundation.g.a.f10418o, 0);
        }
        Iterator<Map.Entry<String, ?>> it = this.b.getAll().entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getKey());
        }
        return arrayList;
    }

    public final void a(String str, String str2) {
        try {
            Context contextD = com.anythink.expressad.foundation.b.a.b().d();
            if (contextD == null) {
                return;
            }
            if (this.b == null && contextD != null) {
                this.b = contextD.getSharedPreferences(com.anythink.expressad.foundation.g.a.f10418o, 0);
            }
            SharedPreferences.Editor editorEdit = this.b.edit();
            editorEdit.putString(str, str2);
            editorEdit.apply();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void b(String str) {
        Context contextD = com.anythink.expressad.foundation.b.a.b().d();
        if (contextD == null) {
            return;
        }
        if (this.b == null && contextD != null) {
            this.b = contextD.getSharedPreferences(com.anythink.expressad.foundation.g.a.f10418o, 0);
        }
        this.b.edit().remove(str).apply();
    }

    private void a(String str, int i2) {
        try {
            Context contextD = com.anythink.expressad.foundation.b.a.b().d();
            if (contextD == null) {
                return;
            }
            if (this.b == null && contextD != null) {
                this.b = contextD.getSharedPreferences(com.anythink.expressad.foundation.g.a.f10418o, 0);
            }
            SharedPreferences.Editor editorEdit = this.b.edit();
            editorEdit.putInt(str, i2);
            editorEdit.apply();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(String str, long j2) {
        try {
            Context contextD = com.anythink.expressad.foundation.b.a.b().d();
            if (contextD == null) {
                o.d(a, "context is null in put");
                return;
            }
            if (this.b == null && contextD != null) {
                this.b = contextD.getSharedPreferences(com.anythink.expressad.foundation.g.a.f10418o, 0);
            }
            SharedPreferences.Editor editorEdit = this.b.edit();
            editorEdit.putLong(str, j2);
            editorEdit.apply();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final String a(String str) {
        try {
            Context contextD = com.anythink.expressad.foundation.b.a.b().d();
            if (contextD == null) {
                return null;
            }
            if (this.b == null && contextD != null) {
                this.b = contextD.getSharedPreferences(com.anythink.expressad.foundation.g.a.f10418o, 0);
            }
            return this.b.getString(str, "");
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
