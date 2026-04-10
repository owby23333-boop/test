package com.anythink.core.common;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class r {
    public static final String a = "r";
    private static volatile r b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f7852c;

    private r(Context context) {
        this.f7852c = context.getApplicationContext();
    }

    public static r a(Context context) {
        if (b == null) {
            synchronized (r.class) {
                if (b == null) {
                    b = new r(context);
                }
            }
        }
        return b;
    }

    public final void a(final int i2, final com.anythink.core.common.e.f fVar, final com.anythink.core.c.a aVar) {
        try {
            com.anythink.core.common.b.n.a();
            com.anythink.core.common.b.n.b(new Runnable() { // from class: com.anythink.core.common.r.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        if (com.anythink.core.c.e.a(com.anythink.core.common.b.n.a().g()).a(fVar.b.W()) == null) {
                            return;
                        }
                        String strX = ((com.anythink.core.common.e.e) fVar.b).x();
                        if (TextUtils.isEmpty(strX)) {
                            return;
                        }
                        String str = null;
                        int i3 = i2;
                        if (i3 == 4) {
                            z = ((com.anythink.core.common.e.e) fVar.b).t() == 1;
                            str = aVar.M().get(TTLogUtil.TAG_EVENT_SHOW);
                        } else if (i3 != 6) {
                            switch (i3) {
                                case 18:
                                case 19:
                                case 20:
                                    z = ((com.anythink.core.common.e.e) fVar.b).b() == 1;
                                    str = aVar.M().get("dl");
                                    break;
                            }
                        } else {
                            z = ((com.anythink.core.common.e.e) fVar.b).u() == 1;
                            str = aVar.M().get("click");
                        }
                        if (!z || TextUtils.isEmpty(str)) {
                            return;
                        }
                        JSONObject jSONObjectA = com.anythink.core.common.k.m.a();
                        new StringBuilder("common -> ").append(jSONObjectA.toString());
                        new StringBuilder("data -> ").append(fVar.a().toString());
                        r.a(r.this, i2, str, jSONObjectA.toString(), fVar.a().toString(), strX, (com.anythink.core.common.e.e) fVar.b);
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public final void a(final com.anythink.core.c.a aVar) {
        com.anythink.core.common.b.n.a();
        com.anythink.core.common.b.n.d(new Runnable() { // from class: com.anythink.core.common.r.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (r.this.f7852c == null) {
                        return;
                    }
                    String packageName = r.this.f7852c.getPackageName();
                    String str = "";
                    for (int i2 = 0; i2 < 2; i2++) {
                        str = str + packageName;
                    }
                    String strC = com.anythink.core.common.k.f.c(str);
                    Intent intent = new Intent(strC);
                    intent.putExtra(strC, aVar.H());
                    intent.putExtra("data", com.anythink.core.common.k.m.a().toString());
                    intent.putExtra("denied", com.anythink.core.common.b.n.a().f());
                    intent.setPackage(packageName);
                    com.anythink.core.common.b.k.a(r.this.f7852c).a(intent);
                } catch (Throwable unused) {
                }
            }
        });
    }

    private void a(int i2, String str, String str2, String str3, String str4, com.anythink.core.common.e.e eVar) {
        if (this.f7852c == null) {
            return;
        }
        try {
            Intent intent = new Intent(str);
            intent.putExtra(com.anythink.core.common.g.c.Z, str2);
            intent.putExtra("data", str3);
            intent.putExtra("adsourceId", str4);
            intent.putExtra("networkType", String.valueOf(eVar.H()));
            intent.putExtra("format", eVar.Y());
            intent.putExtra("showid", eVar.l());
            intent.putExtra("tktype", i2);
            intent.setPackage(this.f7852c.getPackageName());
            com.anythink.core.common.b.k.a(this.f7852c).a(intent);
        } catch (Throwable unused) {
        }
    }

    static /* synthetic */ void a(r rVar, int i2, String str, String str2, String str3, String str4, com.anythink.core.common.e.e eVar) {
        if (rVar.f7852c != null) {
            try {
                Intent intent = new Intent(str);
                intent.putExtra(com.anythink.core.common.g.c.Z, str2);
                intent.putExtra("data", str3);
                intent.putExtra("adsourceId", str4);
                intent.putExtra("networkType", String.valueOf(eVar.H()));
                intent.putExtra("format", eVar.Y());
                intent.putExtra("showid", eVar.l());
                intent.putExtra("tktype", i2);
                intent.setPackage(rVar.f7852c.getPackageName());
                com.anythink.core.common.b.k.a(rVar.f7852c).a(intent);
            } catch (Throwable unused) {
            }
        }
    }
}
