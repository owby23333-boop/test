package com.anythink.china.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.anythink.china.a.a.d;
import com.anythink.china.a.a.e;
import com.anythink.china.a.a.f;
import com.anythink.china.a.a.g;
import com.anythink.china.a.a.j;
import com.anythink.china.a.a.k;
import com.anythink.china.a.a.m;
import com.anythink.china.api.ATChinaSDKHandler;
import com.anythink.china.api.OaidSDKCallbackListener;
import com.bun.miitmdid.interfaces.IdSupplier;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.Method;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: com.anythink.china.a.b$1, reason: invalid class name */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ com.anythink.china.a.a a;
        final /* synthetic */ Context b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f6339c;

        AnonymousClass1(com.anythink.china.a.a aVar, Context context, String str) {
            this.a = aVar;
            this.b = context;
            this.f6339c = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.china.a.a aVar = new com.anythink.china.a.a() { // from class: com.anythink.china.a.b.1.1
                @Override // com.anythink.china.a.a
                public final void a(String str, boolean z2) {
                    com.anythink.china.a.a aVar2 = AnonymousClass1.this.a;
                    if (aVar2 != null) {
                        aVar2.a(str, z2);
                    }
                }

                @Override // com.anythink.china.a.a
                public final void a() {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    b.c(anonymousClass1.b, anonymousClass1.a);
                }
            };
            try {
                switch (this.f6339c) {
                    case "ASUS":
                        new com.anythink.china.a.a.b(this.b).a(aVar);
                        break;
                    case "OPPO":
                    case "ONEPLUS":
                        new g(this.b).a(aVar);
                        break;
                    case "ZTE":
                    case "FERRMEOS":
                    case "SSUI":
                        b.c(this.b, this.a);
                        break;
                    case "HUAWEI":
                        new d(this.b).a(aVar);
                        break;
                    case "SAMSUNG":
                        new j(this.b).a(aVar);
                        break;
                    case "LENOVO":
                    case "MOTOLORA":
                        new m(this.b).a(aVar);
                        break;
                    case "MEIZU":
                        new e(this.b).a(aVar);
                        break;
                    default:
                        b.c(this.b, this.a);
                        break;
                }
            } catch (Throwable th) {
                com.anythink.china.a.a aVar2 = this.a;
                if (aVar2 != null) {
                    th.getMessage();
                    aVar2.a();
                }
            }
        }
    }

    @SuppressLint({"PrivateApi"})
    static final class a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static Object f6340e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static Class<?> f6341f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static Method f6342g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static Method f6343h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static Method f6344i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static Method f6345j;
        final String a;
        final String b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final String f6346c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final String f6347d;

        static {
            try {
                Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
                f6341f = cls;
                f6340e = cls.newInstance();
                f6342g = f6341f.getMethod("getUDID", Context.class);
                f6343h = f6341f.getMethod("getOAID", Context.class);
                f6344i = f6341f.getMethod("getVAID", Context.class);
                f6345j = f6341f.getMethod("getAAID", Context.class);
            } catch (Throwable unused) {
            }
        }

        a(Context context) {
            this.a = a(context, f6342g);
            this.b = a(context, f6343h);
            this.f6346c = a(context, f6344i);
            this.f6347d = a(context, f6345j);
        }

        private static boolean a() {
            return (f6341f == null || f6340e == null) ? false : true;
        }

        private static String a(Context context, Method method) {
            Object obj = f6340e;
            if (obj == null || method == null) {
                return null;
            }
            try {
                Object objInvoke = method.invoke(obj, context);
                if (objInvoke != null) {
                    return (String) objInvoke;
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    public static void a(Context context, com.anythink.china.a.a aVar) {
        String strA;
        try {
            strA = a(context);
        } catch (Throwable unused) {
            strA = "";
        }
        if (!TextUtils.isEmpty(strA)) {
            aVar.a(strA, false);
            return;
        }
        String str = Build.MANUFACTURER;
        String strA2 = a("ro.build.freeme.label");
        boolean z2 = true;
        if (!TextUtils.isEmpty(strA2) && strA2.equalsIgnoreCase("FREEMEOS")) {
            str = "FERRMEOS";
        } else {
            String strA3 = a("ro.ssui.product");
            if (TextUtils.isEmpty(strA3) || strA3.equalsIgnoreCase("unknown")) {
                z2 = false;
            }
            if (z2) {
                str = "SSUI";
            }
        }
        if (!TextUtils.isEmpty(str)) {
            String upperCase = str.toUpperCase();
            if (Arrays.asList("ASUS", "HUAWEI", "OPPO", "ONEPLUS", "ZTE", "FERRMEOS", "SSUI", "SAMSUNG", "MEIZU", "MOTOLORA", "LENOVO").contains(upperCase)) {
                com.anythink.core.common.k.b.a.a().a(new AnonymousClass1(aVar, context, upperCase));
            } else if ("VIVO".equals(upperCase)) {
                strA = new k(context).a();
            } else if ("NUBIA".equals(upperCase)) {
                strA = new f(context).a();
            } else {
                c(context, aVar);
            }
        }
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        aVar.a(strA, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(final Context context, final com.anythink.china.a.a aVar) {
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.china.a.b.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    ATChinaSDKHandler.handleInitOaidSDK(context.getApplicationContext(), new OaidSDKCallbackListener() { // from class: com.anythink.china.a.b.2.1
                        @Override // com.anythink.china.api.OaidSDKCallbackListener
                        public final void OnSupport(boolean z2, IdSupplier idSupplier) {
                            b.a(idSupplier, aVar);
                        }

                        @Override // com.anythink.china.api.OaidSDKCallbackListener
                        public final void onSupport(IdSupplier idSupplier) {
                            b.a(idSupplier, aVar);
                        }
                    });
                } catch (Throwable unused) {
                }
            }
        });
    }

    private static boolean b() {
        String strA = a("ro.ssui.product");
        return (TextUtils.isEmpty(strA) || strA.equalsIgnoreCase("unknown")) ? false : true;
    }

    private static void b(IdSupplier idSupplier, com.anythink.china.a.a aVar) {
        String oaid = idSupplier != null ? idSupplier.getOAID() : "";
        if (TextUtils.isEmpty(oaid)) {
            if (aVar != null) {
                aVar.a();
            }
        } else if (aVar != null) {
            aVar.a(oaid, false);
        }
    }

    private static boolean a() {
        String strA = a("ro.build.freeme.label");
        return !TextUtils.isEmpty(strA) && strA.equalsIgnoreCase("FREEMEOS");
    }

    private static String a(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, str, "unknown");
        } catch (Exception unused) {
            return null;
        }
    }

    private static void a(Context context, String str, com.anythink.china.a.a aVar) {
        com.anythink.core.common.k.b.a.a().a(new AnonymousClass1(aVar, context, str));
    }

    private static String a(Context context) {
        try {
            return new a(context).b;
        } catch (Throwable unused) {
            return "";
        }
    }

    static /* synthetic */ void a(IdSupplier idSupplier, com.anythink.china.a.a aVar) {
        String oaid = idSupplier != null ? idSupplier.getOAID() : "";
        if (TextUtils.isEmpty(oaid)) {
            if (aVar != null) {
                aVar.a();
            }
        } else if (aVar != null) {
            aVar.a(oaid, false);
        }
    }
}
