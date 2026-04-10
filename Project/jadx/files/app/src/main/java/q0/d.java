package q0;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.sntech.a4.A4AdListener;
import com.sntech.ads.ISNADS;
import com.sntech.ads.InnerAPISNADS;
import com.sntech.ads.callback.RiskUserCallback;
import com.sntech.event.SNEvent;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/* JADX INFO: compiled from: ClassLoaderSNADS.java */
/* JADX INFO: loaded from: classes4.dex */
public class d implements ISNADS {
    public static final String E = InnerAPISNADS.class.getName();
    public static final String F = SNEvent.AdPlatform.class.getName();
    public static final String G = SNEvent.AdType.class.getName();
    public static final String H = SNEvent.WithdrawChannel.class.getName();
    public static final String I = SNEvent.UserEvent.class.getName();
    public static final String J = RiskUserCallback.class.getName();
    public final Method A;
    public final Method B;
    public Method C;
    public final ClassLoader D;
    public final Object a;
    public final Method b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Method f21667c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Method f21668d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Method f21669e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Method f21670f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Method f21671g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Method f21672h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Method f21673i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Method f21674j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Method f21675k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Method f21676l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Method f21677m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Method f21678n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Method f21679o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Method f21680p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Method f21681q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Method f21682r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Method f21683s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Method f21684t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Method f21685u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Method f21686v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Method f21687w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Method f21688x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Method f21689y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Method f21690z;

    /* JADX INFO: compiled from: ClassLoaderSNADS.java */
    public class a implements InvocationHandler {
        public final /* synthetic */ RiskUserCallback a;

        public a(d dVar, RiskUserCallback riskUserCallback) {
            this.a = riskUserCallback;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            this.a.callback(((Boolean) objArr[0]).booleanValue());
            return null;
        }
    }

    public d(Context context, ClassLoader classLoader) throws Exception {
        this.D = classLoader;
        Class<?> clsLoadClass = classLoader.loadClass(E);
        Constructor<?> declaredConstructor = clsLoadClass.getDeclaredConstructor(Context.class);
        declaredConstructor.setAccessible(true);
        this.a = declaredConstructor.newInstance(context);
        this.b = clsLoadClass.getDeclaredMethod("initSDK", String.class, String.class);
        this.f21667c = clsLoadClass.getDeclaredMethod("setupPlugins", new Class[0]);
        this.f21668d = clsLoadClass.getDeclaredMethod("getPluginClassloaders", new Class[0]);
        Class<?> cls = Integer.TYPE;
        this.f21669e = clsLoadClass.getDeclaredMethod("onNewVersion", cls);
        this.f21670f = clsLoadClass.getDeclaredMethod("requestPermissionsIfNeed", Activity.class, String[].class);
        this.f21671g = clsLoadClass.getDeclaredMethod("onRequestPermissionResult", Activity.class, cls, String[].class, int[].class);
        this.f21672h = clsLoadClass.getDeclaredMethod("setUserId", String.class);
        this.f21673i = clsLoadClass.getDeclaredMethod("did", new Class[0]);
        String str = F;
        this.f21674j = clsLoadClass.getDeclaredMethod("clickAd", classLoader.loadClass(str), String.class, String.class);
        this.f21675k = clsLoadClass.getDeclaredMethod("showAd", View.class, classLoader.loadClass(str), String.class, Double.TYPE, String.class);
        String str2 = G;
        this.f21676l = clsLoadClass.getDeclaredMethod("onTopOnAdShow", classLoader.loadClass(str), classLoader.loadClass(str2), String.class, String.class, Double.TYPE);
        this.f21677m = clsLoadClass.getDeclaredMethod("isAdTypeAvailable", classLoader.loadClass(str), classLoader.loadClass(str2));
        this.f21678n = clsLoadClass.getDeclaredMethod("getAdEcpm", classLoader.loadClass(str), classLoader.loadClass(str2), String.class, Double.TYPE);
        this.f21679o = clsLoadClass.getDeclaredMethod("onWithdraw", String.class, Float.TYPE, classLoader.loadClass(H), String.class);
        this.f21680p = clsLoadClass.getDeclaredMethod("onUserEvent", classLoader.loadClass(I));
        this.f21681q = clsLoadClass.getDeclaredMethod("isRiskUser", classLoader.loadClass(J));
        this.f21682r = clsLoadClass.getDeclaredMethod("getVersion", new Class[0]);
        this.f21683s = clsLoadClass.getDeclaredMethod("getRewardVideoPlacementId", cls);
        this.f21684t = clsLoadClass.getDeclaredMethod("getRewardVideoPlacementId", cls, String.class);
        this.f21685u = clsLoadClass.getDeclaredMethod("getInterstitialPlacementId", cls);
        this.f21686v = clsLoadClass.getDeclaredMethod("getInterstitialPlacementId", cls, String.class);
        this.f21687w = clsLoadClass.getDeclaredMethod("getBannerPlacementId", cls);
        this.f21688x = clsLoadClass.getDeclaredMethod("getBannerPlacementId", cls, String.class);
        this.f21689y = clsLoadClass.getDeclaredMethod("getNativePlacementId", cls);
        this.f21690z = clsLoadClass.getDeclaredMethod("getNativePlacementId", cls, String.class);
        this.A = clsLoadClass.getDeclaredMethod("getSplashPlacementId", cls);
        this.B = clsLoadClass.getDeclaredMethod("getSplashPlacementId", cls, String.class);
        try {
            this.C = clsLoadClass.getDeclaredMethod("showA4InterstitialAd", Activity.class, String.class, classLoader.loadClass("com.sntech.a4.A4AdListener"));
        } catch (Throwable unused) {
        }
        a(this.D);
    }

    public static void a(ClassLoader classLoader) {
        try {
            Field declaredField = classLoader.loadClass("com.sntech.ads.BuildConfig").getDeclaredField("DEBUG");
            declaredField.setAccessible(true);
            declaredField.set(null, Boolean.valueOf(n.b.b()));
        } catch (Exception e2) {
            if (n.b.b()) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.sntech.ads.ISNADS
    public void clickAd(SNEvent.AdPlatform adPlatform, String str, String str2) {
        try {
            this.f21674j.invoke(this.a, a(adPlatform), str, str2);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.sntech.ads.ISNADS
    public String did() {
        try {
            return (String) this.f21673i.invoke(this.a, new Object[0]);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.sntech.ads.ISNADS
    public double getAdEcpm(SNEvent.AdPlatform adPlatform, SNEvent.AdType adType, String str, double d2) {
        try {
            return ((Double) this.f21678n.invoke(this.a, a(adPlatform), a(adType), str, Double.valueOf(d2))).doubleValue();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.sntech.ads.ISNADS
    public String getBannerPlacementId(int i2) {
        try {
            return (String) this.f21687w.invoke(this.a, Integer.valueOf(i2));
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.sntech.ads.ISNADS
    public String getInterstitialPlacementId(int i2) {
        try {
            return (String) this.f21685u.invoke(this.a, Integer.valueOf(i2));
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.sntech.ads.ISNADS
    public String getNativePlacementId(int i2) {
        try {
            return (String) this.f21689y.invoke(this.a, Integer.valueOf(i2));
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.sntech.ads.ISNADS
    public List<ClassLoader> getPluginClassloaders() {
        try {
            return (List) this.f21668d.invoke(this.a, new Object[0]);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.sntech.ads.ISNADS
    public String getRewardVideoPlacementId(int i2) {
        try {
            return (String) this.f21683s.invoke(this.a, Integer.valueOf(i2));
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.sntech.ads.ISNADS
    public String getSplashPlacementId(int i2) {
        try {
            return (String) this.A.invoke(this.a, Integer.valueOf(i2));
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.sntech.ads.ISNADS
    public int getVersion() {
        try {
            return ((Integer) this.f21682r.invoke(this.a, new Object[0])).intValue();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.sntech.ads.ISNADS
    public void initSDK(String str, String str2) {
        try {
            this.b.invoke(this.a, str, str2);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.sntech.ads.ISNADS
    public boolean isAdTypeAvailable(SNEvent.AdPlatform adPlatform, SNEvent.AdType adType) {
        try {
            return ((Boolean) this.f21677m.invoke(this.a, a(adPlatform), a(adType))).booleanValue();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.sntech.ads.ISNADS
    public void isRiskUser(RiskUserCallback riskUserCallback) {
        try {
            this.f21681q.invoke(this.a, Proxy.newProxyInstance(this.D, new Class[]{this.D.loadClass(RiskUserCallback.class.getName())}, new a(this, riskUserCallback)));
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.sntech.ads.ISNADS
    public void onNewVersion(int i2) {
        try {
            this.f21669e.invoke(this.a, Integer.valueOf(i2));
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.sntech.ads.ISNADS
    public void onRequestPermissionResult(Activity activity, int i2, String[] strArr, int[] iArr) {
        try {
            this.f21671g.invoke(this.a, activity, Integer.valueOf(i2), strArr, iArr);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.sntech.ads.ISNADS
    public void onTopOnAdShow(SNEvent.AdPlatform adPlatform, SNEvent.AdType adType, String str, String str2, double d2) {
        try {
            this.f21676l.invoke(this.a, a(adPlatform), a(adType), str, str2, Double.valueOf(d2));
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.sntech.ads.ISNADS
    public void onUserEvent(SNEvent.UserEvent userEvent) {
        try {
            this.f21680p.invoke(this.a, a(userEvent));
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.sntech.ads.ISNADS
    public void onWithdraw(String str, float f2, SNEvent.WithdrawChannel withdrawChannel, String str2) {
        try {
            this.f21679o.invoke(this.a, str, Float.valueOf(f2), a(withdrawChannel), str2);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.sntech.ads.ISNADS
    public void requestPermissionsIfNeed(Activity activity, String... strArr) {
        try {
            this.f21670f.invoke(this.a, activity, strArr);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.sntech.ads.ISNADS
    public void setUserId(String str) {
        try {
            this.f21672h.invoke(this.a, str);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.sntech.ads.ISNADS
    public void setupPlugins() {
        try {
            this.f21667c.invoke(this.a, new Object[0]);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.sntech.ads.ISNADS
    public void showA4InterstitialAd(Activity activity, String str, final A4AdListener a4AdListener) {
        try {
            this.C.invoke(this.a, activity, str, Proxy.newProxyInstance(this.D, new Class[]{this.D.loadClass(A4AdListener.class.getName())}, new InvocationHandler() { // from class: q0.a
                @Override // java.lang.reflect.InvocationHandler
                public final Object invoke(Object obj, Method method, Object[] objArr) {
                    return d.a(a4AdListener, obj, method, objArr);
                }
            }));
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.sntech.ads.ISNADS
    public void showAd(View view, SNEvent.AdPlatform adPlatform, String str, double d2, String str2) {
        try {
            this.f21675k.invoke(this.a, view, a(adPlatform), str, Double.valueOf(d2), str2);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.sntech.ads.ISNADS
    public String getBannerPlacementId(int i2, String str) {
        try {
            return (String) this.f21688x.invoke(this.a, Integer.valueOf(i2), str);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.sntech.ads.ISNADS
    public String getInterstitialPlacementId(int i2, String str) {
        try {
            return (String) this.f21686v.invoke(this.a, Integer.valueOf(i2), str);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.sntech.ads.ISNADS
    public String getNativePlacementId(int i2, String str) {
        try {
            return (String) this.f21690z.invoke(this.a, Integer.valueOf(i2), str);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.sntech.ads.ISNADS
    public String getRewardVideoPlacementId(int i2, String str) {
        try {
            return (String) this.f21684t.invoke(this.a, Integer.valueOf(i2), str);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.sntech.ads.ISNADS
    public String getSplashPlacementId(int i2, String str) {
        try {
            return (String) this.B.invoke(this.a, Integer.valueOf(i2), str);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static /* synthetic */ Object a(A4AdListener a4AdListener, Object obj, Method method, Object[] objArr) throws Throwable {
        a4AdListener.onError(((Integer) objArr[0]).intValue(), (String) objArr[1]);
        return null;
    }

    public final Object a(Object obj) throws ClassNotFoundException {
        for (Object obj2 : this.D.loadClass(obj.getClass().getName()).getEnumConstants()) {
            if (obj.toString().equals(obj2.toString())) {
                return obj2;
            }
        }
        return null;
    }
}
