package q0;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.RequiresApi;
import com.sn.android.Cif;
import com.sn.android.Cnew;
import com.sn.android.Ctry;
import com.sn.android.entity.InitConfig;
import com.sntech.a4.A4;
import com.sntech.a4.A4AdListener;
import com.sntech.a4.A4AdSlot;
import com.sntech.ads.BuildConfig;
import com.sntech.ads.ISNADS;
import com.sntech.ads.callback.RiskUserCallback;
import com.sntech.cc.Cdo;
import com.sntech.event.SNEvent;
import com.sntech.net.DomainConfig;
import com.sntech.net.DomainManager;
import com.sntech.okhttpconnection.log.Ccase;
import com.sntech.okhttpconnection.log.Celse;
import com.sntech.okhttpconnection.log.Cgoto;
import com.sntech.stat.newstat.oaid.OADIDSDKHelper;
import com.sntech.stat.newstat.oaid.OADIDSDKHelper25;
import com.sntech.x2.topon.strategy.ARPUStrategy;
import com.taobao.accs.utl.UtilityImpl;
import e0.h;
import e0.i;
import e0.j;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import z0.l;
import z0.o;

/* JADX INFO: compiled from: InnerSNADSImpl.java */
/* JADX INFO: loaded from: classes4.dex */
public class e implements ISNADS {
    private static final String TAG = "for";
    public static final String sPreChannel = "AN_A4_";
    private final Context mContext;

    /* JADX INFO: compiled from: InnerSNADSImpl.java */
    public class a implements Cnew.Cif {
        public a() {
        }

        @Override // com.sn.android.Cnew.Cif
        /* JADX INFO: renamed from: do */
        public void mo87do() {
            e.this.onConfigLoaded();
        }

        @Override // com.sn.android.Cnew.Cif
        /* JADX INFO: renamed from: do */
        public void mo88do(Exception exc) {
            i.b(e.TAG, "init failed: " + exc);
        }
    }

    /* JADX INFO: compiled from: InnerSNADSImpl.java */
    public class b implements Cgoto {
        public b(e eVar) {
        }
    }

    /* JADX INFO: compiled from: InnerSNADSImpl.java */
    public class c implements Cnew.Cif {
        public c() {
        }

        @Override // com.sn.android.Cnew.Cif
        /* JADX INFO: renamed from: do */
        public void mo87do() {
            if (n.a.b() || n.a.a()) {
                j.b(e.this.mContext, e.this.did());
            }
        }

        @Override // com.sn.android.Cnew.Cif
        /* JADX INFO: renamed from: do */
        public void mo88do(Exception exc) {
        }
    }

    public e(Context context) {
        this.mContext = context;
    }

    private void checkDomainProvider() {
        if (DomainManager.class.getClassLoader() == e.class.getClassLoader()) {
            DomainConfig.Cdo cdo = new DomainConfig.Cdo();
            cdo.f81do.put(DomainConfig.TEMPLATE_X1, new String[]{"x1.dongfenbao.cn"});
            cdo.f81do.put(DomainConfig.TEMPLATE_X2, new String[]{"x2.dongfenbao.cn"});
            cdo.f81do.put(DomainConfig.TEMPLATE_DEVICE, new String[]{"device-center.dongfenbao.cn"});
            cdo.f81do.put(DomainConfig.TEMPLATE_A4, new String[]{"new-a4.dongfenbao.cn"});
            DomainManager.get().init(this.mContext, new DomainConfig(cdo));
        }
    }

    private void initA4(String str) {
        try {
            Class.forName("com.sntech.a4.A4");
            A4.init(this.mContext, BuildConfig.VERSION_NAME, str, did());
        } catch (ClassNotFoundException unused) {
        }
    }

    private void initCC(final String str) {
        String str2;
        String packageName = this.mContext.getPackageName();
        Context context = this.mContext;
        int iMyPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            str2 = null;
        } else {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == iMyPid) {
                    str2 = runningAppProcessInfo.processName;
                    break;
                }
            }
            str2 = null;
        }
        if (packageName.equals(str2)) {
            new Thread(new Runnable() { // from class: q0.b
                @Override // java.lang.Runnable
                public final void run() {
                    this.f21665s.a(str);
                }
            }).start();
        }
    }

    private void initURLLog(String str, String str2) {
        Context context = this.mContext;
        b bVar = new b(this);
        boolean zB = n.b.b();
        boolean z2 = Celse.Cdo.f118do;
        Celse celse = new Celse();
        celse.f114do = bVar;
        celse.f116if = str;
        celse.f115for = zB;
        celse.f117new = 127;
        Ccase.m109do(context, BuildConfig.VERSION_NAME, str2, celse);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onConfigLoaded() {
        if (n.a.a()) {
            j.a(getClass().getClassLoader(), did());
        }
        if (n.a.b()) {
            j.b(getClass().getClassLoader(), this.mContext, did());
        }
        if (Ctry.f72try == null) {
            synchronized (Ctry.class) {
                if (Ctry.f72try == null) {
                    Ctry.f72try = new Ctry();
                }
            }
        }
        Ctry.f72try.m92do();
        Cif cifM84do = Cif.m84do(this.mContext);
        InitConfig initConfig = n.a.a;
        cifM84do.f68do.getSharedPreferences("prefs_sn_android", 0).edit().putBoolean("crash_handler_enabled", initConfig != null && initConfig.handleCrash == 1).apply();
    }

    public void a(String str) {
        ArrayList arrayList;
        Context context = this.mContext;
        String strDid = did();
        Context context2 = this.mContext;
        try {
            arrayList = new ArrayList(2);
            String strB = h.b(context2);
            if (!TextUtils.isEmpty(strB)) {
                arrayList.add(strB);
            }
            String strD = h.d(context2);
            if (!TextUtils.isEmpty(strD)) {
                arrayList.add(strD);
            }
            File externalCacheDir = context2.getApplicationContext().getExternalCacheDir();
            if (externalCacheDir == null) {
                externalCacheDir = context2.getApplicationContext().getCacheDir();
            }
            File file = new File(externalCacheDir, "com_qq_e_download/apk");
            String path = file.exists() ? file.getPath() : null;
            if (!TextUtils.isEmpty(path)) {
                arrayList.add(path);
            }
            String strC = h.c(context2);
            if (!TextUtils.isEmpty(strC)) {
                arrayList.add(strC);
            }
            String strA = h.a(context2);
            if (!TextUtils.isEmpty(strA)) {
                arrayList.add(strA);
            }
        } catch (Throwable unused) {
        }
        String[] strArr = arrayList.size() > 0 ? (String[]) arrayList.toArray(new String[0]) : null;
        if (context instanceof Application) {
            Cdo.f77do = context;
        } else {
            Cdo.f77do = context.getApplicationContext();
        }
        Cdo.f79if = BuildConfig.VERSION_NAME;
        Cdo.f78for = strDid;
        Cdo.f80new = str;
        o oVarA = o.a();
        Context context3 = Cdo.f77do;
        oVarA.a = context3;
        l.a(context3, strArr);
    }

    @Override // com.sntech.ads.ISNADS
    public void clickAd(SNEvent.AdPlatform adPlatform, String str, String str2) {
        o.a().a(adPlatform, str, SNEvent.AdType.NATIVE, SNEvent.AdEvent.CLICK, str2);
    }

    @Override // com.sntech.ads.ISNADS
    public String did() {
        Context context = this.mContext;
        boolean z2 = com.sntech.stat.Cdo.f125do;
        return q.b.a(context);
    }

    @Override // com.sntech.ads.ISNADS
    public double getAdEcpm(SNEvent.AdPlatform adPlatform, SNEvent.AdType adType, String str, double d2) {
        com.sntech.x2.topon.arpu.Cdo.m161do().getClass();
        ARPUStrategy aRPUStrategy = x.a.b().a;
        return aRPUStrategy != null ? aRPUStrategy.m172do(adPlatform.toString(), adType.toString(), str, d2) : d2;
    }

    @Override // com.sntech.ads.ISNADS
    public String getBannerPlacementId(int i2) {
        return com.sntech.x2.Cdo.m147do(com.sntech.x2.Cif.f137do).m150do("BANNER", i2, "");
    }

    @Override // com.sntech.ads.ISNADS
    public String getInterstitialPlacementId(int i2) {
        return com.sntech.x2.Cdo.m147do(com.sntech.x2.Cif.f137do).m150do("INTERSTITIAL", i2, "");
    }

    @Override // com.sntech.ads.ISNADS
    public String getNativePlacementId(int i2) {
        return com.sntech.x2.Cdo.m147do(com.sntech.x2.Cif.f137do).m150do("NATIVE", i2, "");
    }

    @Override // com.sntech.ads.ISNADS
    public List<ClassLoader> getPluginClassloaders() {
        return null;
    }

    @Override // com.sntech.ads.ISNADS
    public String getRewardVideoPlacementId(int i2) {
        return com.sntech.x2.Cdo.m147do(com.sntech.x2.Cif.f137do).m150do("REWARD_VIDEO", i2, "");
    }

    @Override // com.sntech.ads.ISNADS
    public String getSplashPlacementId(int i2) {
        return com.sntech.x2.Cdo.m147do(com.sntech.x2.Cif.f137do).m150do("SPLASH", i2, "");
    }

    @Override // com.sntech.ads.ISNADS
    public int getVersion() {
        return BuildConfig.VERSION_CODE;
    }

    @Override // com.sntech.ads.ISNADS
    @RequiresApi(api = 19)
    public void initSDK(String str, String str2) {
        t0.d dVar;
        StringBuilder sbA = y.b.a("v = ");
        sbA.append(getVersion());
        sbA.append(" d = ");
        sbA.append(n.b.b());
        sbA.toString();
        i.c(null, "init: v = " + getVersion());
        com.sntech.net.Cif.m101do(this.mContext, BuildConfig.VERSION_NAME, did(), str2);
        Context context = this.mContext;
        String str3 = sPreChannel + str2;
        boolean z2 = com.sntech.stat.Cdo.f125do;
        q.b.a = BuildConfig.VERSION_NAME;
        q.b.b = str3;
        com.sntech.stat.Cdo.m144do(context.getApplicationContext());
        Context applicationContext = context.getApplicationContext();
        synchronized (t0.d.class) {
            if (t0.d.f21704e == null) {
                t0.d.f21704e = new t0.d(applicationContext);
            }
            dVar = t0.d.f21704e;
        }
        synchronized (dVar.b) {
            if (!dVar.b.get()) {
                dVar.b.set(true);
                dVar.f21707c.a(dVar.a);
                t0.e eVar = dVar.f21708d;
                Context context2 = dVar.a;
                eVar.getClass();
                t0.c cVar = new t0.c(eVar, System.currentTimeMillis());
                if (OADIDSDKHelper.isSupport()) {
                    eVar.f21711e = OADIDSDKHelper.getOAId(context2, cVar);
                } else if (OADIDSDKHelper25.isSupport()) {
                    eVar.f21711e = OADIDSDKHelper25.getOAId(context2, cVar);
                }
                if (q.e.a(dVar.a)) {
                    try {
                        ((WifiManager) dVar.a.getApplicationContext().getSystemService(UtilityImpl.NET_TYPE_WIFI)).startScan();
                    } catch (Exception unused) {
                    }
                }
            }
        }
        new Thread(new com.sntech.stat.Cif(applicationContext)).start();
        did();
        initURLLog(str2, str);
        initCC(str2);
        Context context3 = this.mContext;
        did();
        if (context3 == null || str2 == null) {
            throw new IllegalArgumentException("Argument null");
        }
        Context applicationContext2 = context3.getApplicationContext();
        com.sntech.x2.Cif.f137do = applicationContext2;
        com.sntech.x2.Cdo.m147do(applicationContext2).m151do(BuildConfig.VERSION_NAME, "");
        initA4(str2);
        Cnew.m86do(this.mContext, new a());
    }

    @Override // com.sntech.ads.ISNADS
    public boolean isAdTypeAvailable(SNEvent.AdPlatform adPlatform, SNEvent.AdType adType) {
        return com.sntech.x2.topon.arpu.Cdo.m161do().m166do(adPlatform, adType);
    }

    @Override // com.sntech.ads.ISNADS
    public void isRiskUser(final RiskUserCallback riskUserCallback) {
        Cdo.m94do(new Cdo.InterfaceC0505do() { // from class: q0.c
            @Override // com.sntech.cc.Cdo.InterfaceC0505do
            /* JADX INFO: renamed from: do */
            public final void mo76do(Object obj) {
                riskUserCallback.callback(((Boolean) obj).booleanValue());
            }
        });
    }

    @Override // com.sntech.ads.ISNADS
    public void onNewVersion(int i2) {
        Cnew.m86do(this.mContext, new c());
    }

    @Override // com.sntech.ads.ISNADS
    public void onRequestPermissionResult(Activity activity, int i2, String[] strArr, int[] iArr) {
        boolean z2 = com.sntech.stat.Cdo.f125do;
        com.sntech.stat.Cdo.m144do(activity.getApplicationContext());
    }

    @Override // com.sntech.ads.ISNADS
    public void onTopOnAdShow(SNEvent.AdPlatform adPlatform, SNEvent.AdType adType, String str, String str2, double d2) {
        com.sntech.x2.topon.arpu.Cdo.m161do().m168if(adPlatform, adType, str, str2, d2);
    }

    @Override // com.sntech.ads.ISNADS
    public void onUserEvent(SNEvent.UserEvent userEvent) {
        o.a().a(userEvent);
    }

    @Override // com.sntech.ads.ISNADS
    public void onWithdraw(String str, float f2, SNEvent.WithdrawChannel withdrawChannel, String str2) {
        o.a().a(str, f2, withdrawChannel, str2);
    }

    @Override // com.sntech.ads.ISNADS
    public void requestPermissionsIfNeed(Activity activity, String... strArr) {
        String[] strArr2;
        boolean z2 = com.sntech.stat.Cdo.f125do;
        if (Build.VERSION.SDK_INT >= 23) {
            if (strArr != null) {
                HashSet hashSet = new HashSet(Arrays.asList(com.sntech.stat.Cdo.f126for));
                hashSet.addAll(Arrays.asList(strArr));
                strArr2 = (String[]) hashSet.toArray(new String[hashSet.size()]);
            } else {
                strArr2 = com.sntech.stat.Cdo.f126for;
            }
            activity.requestPermissions(strArr2, 74565);
        }
    }

    @Override // com.sntech.ads.ISNADS
    public void setUserId(String str) {
        o.a().a(str);
    }

    @Override // com.sntech.ads.ISNADS
    public void setupPlugins() {
    }

    @Override // com.sntech.ads.ISNADS
    public void showA4InterstitialAd(Activity activity, String str, A4AdListener a4AdListener) {
        A4.showInterstitialAd(activity, new A4AdSlot.Builder().slotId(str).build(), a4AdListener);
    }

    @Override // com.sntech.ads.ISNADS
    public void showAd(View view, SNEvent.AdPlatform adPlatform, String str, double d2, String str2) {
        o.a().a(view, adPlatform, str, SNEvent.AdType.NATIVE, SNEvent.AdEvent.SHOW, d2, str2);
    }

    @Override // com.sntech.ads.ISNADS
    public String getBannerPlacementId(int i2, String str) {
        return com.sntech.x2.Cdo.m147do(com.sntech.x2.Cif.f137do).m150do("BANNER", i2, str);
    }

    @Override // com.sntech.ads.ISNADS
    public String getInterstitialPlacementId(int i2, String str) {
        return com.sntech.x2.Cdo.m147do(com.sntech.x2.Cif.f137do).m150do("INTERSTITIAL", i2, str);
    }

    @Override // com.sntech.ads.ISNADS
    public String getNativePlacementId(int i2, String str) {
        return com.sntech.x2.Cdo.m147do(com.sntech.x2.Cif.f137do).m150do("NATIVE", i2, str);
    }

    @Override // com.sntech.ads.ISNADS
    public String getRewardVideoPlacementId(int i2, String str) {
        return com.sntech.x2.Cdo.m147do(com.sntech.x2.Cif.f137do).m150do("REWARD_VIDEO", i2, str);
    }

    @Override // com.sntech.ads.ISNADS
    public String getSplashPlacementId(int i2, String str) {
        return com.sntech.x2.Cdo.m147do(com.sntech.x2.Cif.f137do).m150do("SPLASH", i2, str);
    }
}
