package com.anythink.expressad.foundation.f;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.anythink.core.common.b.n;
import com.anythink.expressad.foundation.f.a.a;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.widget.FeedBackButton;
import com.anythink.expressad.widget.a.c;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static int a = -2;
    public static int b = -2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f10401c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConcurrentHashMap<String, com.anythink.expressad.foundation.f.a.a> f10402d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RelativeLayout.LayoutParams f10403e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.anythink.expressad.d.a f10404f;

    static class a {
        private static final b a = new b(0);

        a() {
        }
    }

    /* synthetic */ b(byte b2) {
        this();
    }

    public static b a() {
        return a.a;
    }

    private static boolean b(Context context, c cVar) {
        Activity activityA = a(context);
        if (activityA == null || cVar == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 17 && activityA.isDestroyed()) {
            return false;
        }
        try {
            if (cVar.isShowing() || activityA.isFinishing()) {
                return false;
            }
            cVar.show();
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private void c(String str, int i2) {
        com.anythink.expressad.foundation.f.a.a aVarA = a(str);
        if (i2 == 1) {
            aVarA.b();
        } else {
            aVarA.a();
        }
    }

    private com.anythink.expressad.foundation.f.a.a d(String str) {
        if (TextUtils.isEmpty(str)) {
            str = com.anythink.expressad.foundation.b.a.b().e();
        }
        if (this.f10402d.containsKey(str)) {
            return this.f10402d.get(str);
        }
        return null;
    }

    private void e(String str) {
        a(str).e();
    }

    private b() {
        this.f10402d = new ConcurrentHashMap<>();
        this.f10403e = new RelativeLayout.LayoutParams(a, b);
    }

    public static Activity a(Context context) {
        Activity activity;
        Context contextG = com.anythink.expressad.foundation.b.a.b().g();
        try {
            activity = contextG instanceof Activity ? (Activity) contextG : null;
            try {
                Activity activity2 = (!(context instanceof Activity) || (Build.VERSION.SDK_INT >= 17 && ((Activity) context).isDestroyed())) ? activity : (Activity) context;
                if (activity2 != null) {
                    try {
                        if (!activity2.isFinishing()) {
                            if (Build.VERSION.SDK_INT < 17) {
                                return activity2;
                            }
                            if (!activity2.isDestroyed()) {
                                return activity2;
                            }
                        }
                    } catch (Exception e2) {
                        activity = activity2;
                        e = e2;
                        e.printStackTrace();
                        return activity;
                    }
                }
                return null;
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Exception e4) {
            e = e4;
            activity = null;
        }
    }

    public final void c(String str) {
        try {
            String strE = TextUtils.isEmpty(str) ? com.anythink.expressad.foundation.b.a.b().e() : str;
            com.anythink.expressad.foundation.f.a.a aVar = this.f10402d.containsKey(strE) ? this.f10402d.get(strE) : null;
            if (aVar != null) {
                aVar.d();
            }
            this.f10402d.remove(str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final boolean b() {
        com.anythink.expressad.d.b.a();
        this.f10404f = com.anythink.expressad.d.b.c();
        return this.f10404f.K() != 0;
    }

    public final void b(String str, int i2) {
        a(str).c(i2);
    }

    public static boolean a(Context context, c cVar) {
        if (cVar == null) {
            o.b("", "mbAlertDialog  is null");
            return false;
        }
        return b(context, cVar);
    }

    public final FeedBackButton b(String str) {
        return a(str).c();
    }

    private void a(String str, int i2, ViewGroup viewGroup) {
        com.anythink.expressad.foundation.f.a.a aVarA = a(str);
        if (aVarA.c() != null) {
            aVarA.a(i2);
            if (i2 == 0) {
                a(str, n.a().g(), viewGroup, null, null);
            }
        }
    }

    private void a(String str, int i2, int i3, int i4, float f2, float f3, float f4, String str2, String str3) {
        com.anythink.expressad.foundation.f.a.a aVarA = a(str);
        Context contextG = n.a().g();
        aVarA.a(t.b(contextG, f2), t.b(contextG, f3), t.b(contextG, i2), t.b(contextG, i3), t.b(contextG, i4), f4, str2, str3);
    }

    private void a(String str, Context context, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        a(str, context, viewGroup, layoutParams, null);
    }

    public final void a(String str, com.anythink.expressad.foundation.f.a aVar) {
        a(str).a(new a.C0206a(str, aVar));
    }

    public final void a(String str, Context context, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, com.anythink.expressad.foundation.f.a aVar) {
        if (b()) {
            com.anythink.expressad.foundation.f.a.a aVarA = a(str);
            if (aVar != null) {
                aVarA.a(new a.C0206a(str, aVar));
            }
            FeedBackButton feedBackButtonC = aVarA.c();
            if (feedBackButtonC != null) {
                if (layoutParams == null) {
                    int iB = t.b(n.a().g(), 10.0f);
                    this.f10403e.setMargins(iB, iB, iB, iB);
                    layoutParams = this.f10403e;
                }
                ViewGroup viewGroup2 = (ViewGroup) feedBackButtonC.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.removeView(feedBackButtonC);
                }
                Activity activityA = a(context);
                if (activityA != null && viewGroup == null) {
                    viewGroup = (ViewGroup) activityA.findViewById(R.id.content);
                }
                if (viewGroup != null) {
                    viewGroup.removeView(feedBackButtonC);
                    viewGroup.addView(feedBackButtonC, layoutParams);
                }
            }
        }
    }

    public final void a(String str, com.anythink.expressad.foundation.d.c cVar) {
        a(str).a(cVar);
    }

    public final void a(String str, int i2) {
        a(str).b(i2);
    }

    public final com.anythink.expressad.foundation.f.a.a a(String str) {
        com.anythink.expressad.foundation.f.a.a aVar;
        if (TextUtils.isEmpty(str)) {
            str = com.anythink.expressad.foundation.b.a.b().e();
        }
        if (!this.f10402d.containsKey(str)) {
            aVar = new com.anythink.expressad.foundation.f.a.a(str);
            this.f10402d.put(str, aVar);
        } else {
            aVar = this.f10402d.get(str);
        }
        if (aVar != null) {
            return aVar;
        }
        com.anythink.expressad.foundation.f.a.a aVar2 = new com.anythink.expressad.foundation.f.a.a(str);
        this.f10402d.put(str, aVar2);
        return aVar2;
    }

    public final void a(String str, FeedBackButton feedBackButton) {
        a(str).a(feedBackButton);
    }
}
