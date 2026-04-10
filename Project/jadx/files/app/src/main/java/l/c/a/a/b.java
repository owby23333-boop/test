package l.c.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tramini.plugin.a.h;
import com.tramini.plugin.a.k.c;
import com.tramini.plugin.a.k.g;
import com.tramini.plugin.a.k.i;

/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile b f21066c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static l.c.a.a.a f21067d;
    private Context a;
    private boolean b = false;

    final class a implements h.d {
        final /* synthetic */ h.e a;

        a(h.e eVar) {
            this.a = eVar;
        }

        @Override // com.tramini.plugin.a.h.d
        public final void a() {
            b.this.b = true;
        }

        @Override // com.tramini.plugin.a.h.d
        public final void b() {
            b.this.b = false;
        }

        @Override // com.tramini.plugin.a.h.d
        public final void a(int i2, Object obj) {
            b.this.b = false;
            if (obj != null) {
                String string = obj.toString();
                i.a(b.this.a, "tramini", "P_SY", string);
                Context context = b.this.a;
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (context != null) {
                    try {
                        SharedPreferences.Editor editorEdit = context.getSharedPreferences("tramini", 0).edit();
                        editorEdit.putLong("P_UD_TE", jCurrentTimeMillis);
                        editorEdit.apply();
                    } catch (Error | Exception unused) {
                    }
                }
                l.c.a.a.a aVarA = l.c.a.a.a.a(c.a(string));
                if (aVarA != null) {
                    com.tramini.plugin.a.j.b.a().a(g.a(aVarA), aVarA.b());
                    com.tramini.plugin.a.a.c.c().a(aVarA);
                    h.e eVar = this.a;
                    if (eVar != null) {
                        eVar.a(aVarA);
                    }
                }
            }
        }
    }

    private b(Context context) {
        this.a = context;
    }

    public final synchronized l.c.a.a.a b() {
        if (f21067d == null) {
            try {
                if (this.a == null) {
                    this.a = com.tramini.plugin.a.a.c.c().a();
                }
                f21067d = b(this.a);
            } catch (Exception unused) {
            }
            com.tramini.plugin.a.a.c.c().a(f21067d);
        }
        return f21067d;
    }

    public static b a(Context context) {
        if (f21066c == null) {
            synchronized (b.class) {
                if (f21066c == null) {
                    f21066c = new b(context);
                }
            }
        }
        return f21066c;
    }

    public static l.c.a.a.a b(Context context) {
        String strB = i.b(context, "tramini", "P_SY", "");
        if (TextUtils.isEmpty(strB)) {
            return null;
        }
        return l.c.a.a.a.a(c.a(strB));
    }

    public final boolean a() {
        long jLongValue = i.a(this.a, "tramini", "P_UD_TE", (Long) 0L).longValue();
        l.c.a.a.a aVarB = b();
        return aVarB == null || jLongValue + aVarB.c() <= System.currentTimeMillis();
    }

    public final void a(h.e eVar) {
        a aVar = new a(eVar);
        if (this.b || TextUtils.isEmpty(c.f19382e)) {
            return;
        }
        new h.f().a(0, (h.d) aVar);
    }
}
