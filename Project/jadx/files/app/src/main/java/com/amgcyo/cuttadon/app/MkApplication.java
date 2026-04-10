package com.amgcyo.cuttadon.app;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.multidex.MultiDex;
import bin.mt.signature.KillerApplication;
import com.amgcyo.cuttadon.api.entity.config.MkAppConfig;
import com.amgcyo.cuttadon.api.entity.config.SecondaryDomain;
import com.amgcyo.cuttadon.api.entity.other.MkAppVersion;
import com.amgcyo.cuttadon.api.entity.other.NewApiAdList;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.utils.otherutils.g0;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.fatcatfat.io.R;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.SdkConfig;
import com.qq.e.comm.managers.GDTAdSdk;
import com.sntech.ads.SNAdConfig;
import com.sntech.ads.SNAdSdk;
import com.taobao.accs.common.Constants;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.mmkv.MMKV;
import com.tencent.mmkv.MMKVLogLevel;
import com.tencent.smtt.sdk.QbSdk;
import io.reactivex.functions.Consumer;
import io.reactivex.plugins.RxJavaPlugins;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import me.jessyan.art.base.QDTCProtect;

/* JADX INFO: loaded from: classes.dex */
@QDTCProtect
public class MkApplication extends KillerApplication implements me.jessyan.art.base.b {
    private static MkApplication D = null;
    public static int killFlag = -1;
    private MkAppVersion A;
    private String B;
    private me.jessyan.art.base.f.e C;
    public SparseIntArray downloadArray = new SparseIntArray();
    public Map<String, Activity> lists = new HashMap();
    public com.amgcyo.cuttadon.utils.comic.a mPreferenceManager;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f3581s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f3582t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f3583u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f3584v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private MkAppConfig f3585w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private NewApiAdList f3586x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private ArrayList<Integer> f3587y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f3588z;

    class a implements QbSdk.PreInitCallback {
        a(MkApplication mkApplication) {
        }

        @Override // com.tencent.smtt.sdk.QbSdk.PreInitCallback
        public void onCoreInitFinished() {
        }

        @Override // com.tencent.smtt.sdk.QbSdk.PreInitCallback
        public void onViewInitFinished(boolean z2) {
            String str = " onViewInitFinished is " + z2;
        }
    }

    class b implements SNAdConfig {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;

        b(MkApplication mkApplication, Context context, String str) {
            this.a = context;
            this.b = str;
        }

        @Override // com.sntech.ads.SNAdConfig
        public String getAppId() {
            return this.b;
        }

        @Override // com.sntech.ads.SNAdConfig
        public String getChannel() {
            return com.amgcyo.cuttadon.utils.otherutils.g.e(this.a);
        }

        @Override // com.sntech.ads.SNAdConfig
        public String getUserId() {
            return com.amgcyo.cuttadon.utils.otherutils.g.h(this.a);
        }

        @Override // com.sntech.ads.SNAdConfig
        public boolean isDebug() {
            return false;
        }
    }

    private String b() {
        int iMyPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) getApplicationContext().getSystemService("activity")).getRunningAppProcesses();
        String str = "";
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(runningAppProcesses)) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (iMyPid == runningAppProcessInfo.pid) {
                    str = runningAppProcessInfo.processName;
                }
            }
        }
        return str;
    }

    private void c() {
        if (g0.a().a("user_agree_pri", false)) {
            String strM = com.amgcyo.cuttadon.utils.otherutils.g.m();
            if (!TextUtils.isEmpty(strM)) {
                a(strM);
            }
            initDeviceIdentifier();
            e();
            new Thread(new Runnable() { // from class: com.amgcyo.cuttadon.app.h
                @Override // java.lang.Runnable
                public final void run() {
                    this.f3591s.a();
                }
            }).start();
        }
    }

    private void d() {
        l.b.a.j.a((Application) this, (l.b.a.d) new l.b.a.l.b(this));
        l.b.a.j.a(17, 0, com.amgcyo.cuttadon.utils.otherutils.n.a(200.0f));
    }

    private void e() {
        QbSdk.initX5Environment(getApplicationContext(), new a(this));
    }

    private void f() {
        String strG = com.amgcyo.cuttadon.utils.otherutils.g.g(this);
        String str = "x1AppId:" + strG;
        if (TextUtils.isEmpty(strG)) {
            return;
        }
        SNAdSdk.onApplicationCreate(this);
    }

    private void g() {
        RxJavaPlugins.setErrorHandler(new Consumer() { // from class: com.amgcyo.cuttadon.app.g
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                MkApplication.a((Throwable) obj);
            }
        });
    }

    public static MkApplication getAppContext() {
        return D;
    }

    public static TTAdManager getTTAdManager() {
        TTAdManager tTAdManagerA = com.amgcyo.cuttadon.h.b.d.a();
        if (tTAdManagerA != null) {
            return tTAdManagerA;
        }
        TextUtils.isEmpty(com.amgcyo.cuttadon.utils.otherutils.h.a("csj_new"));
        return null;
    }

    public /* synthetic */ void a() {
        com.amgcyo.cuttadon.i.m.a(getApplicationContext());
    }

    public void addActivity(String str, Activity activity) {
        this.lists.put(str, activity);
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
        if (this.C == null) {
            this.C = new me.jessyan.art.base.f.c(context);
        }
        this.C.attachBaseContext(context);
        a(context);
    }

    public void clearActivityByUrl(String str) {
        Activity activity;
        if (this.lists == null || TextUtils.isEmpty(str)) {
            return;
        }
        Iterator<Map.Entry<String, Activity>> it = this.lists.entrySet().iterator();
        while (it.hasNext()) {
            String key = it.next().getKey();
            if (str.equals(key) && (activity = this.lists.get(key)) != null) {
                activity.finish();
                return;
            }
        }
    }

    public void clearAllActivity() {
        Map<String, Activity> map = this.lists;
        if (map != null) {
            for (Map.Entry<String, Activity> entry : map.entrySet()) {
                String key = entry.getKey();
                Activity value = entry.getValue();
                value.finish();
                String str = key + ":" + value;
            }
            this.lists.clear();
        }
    }

    @Override // me.jessyan.art.base.b
    @NonNull
    public me.jessyan.art.a.a.a getAppComponent() {
        me.jessyan.art.f.g.a(this.C, "%s cannot be null", me.jessyan.art.base.f.c.class.getName());
        me.jessyan.art.base.f.e eVar = this.C;
        me.jessyan.art.f.g.a(eVar instanceof me.jessyan.art.base.b, "%s must be implements %s", eVar.getClass().getName(), me.jessyan.art.base.b.class.getName());
        return ((me.jessyan.art.base.b) this.C).getAppComponent();
    }

    public MkAppConfig getAppConfig() {
        return this.f3585w;
    }

    public String getFissionUrl() {
        return this.B;
    }

    public NewApiAdList getNewApiAdList() {
        return this.f3586x;
    }

    public int getOrientation() {
        return this.f3588z;
    }

    public MkAppVersion getVersion() {
        return this.A;
    }

    public ArrayList<Integer> getVersion_data() {
        return this.f3587y;
    }

    public com.amgcyo.cuttadon.utils.comic.a getmPreferenceManager() {
        return this.mPreferenceManager;
    }

    public void initCsjSdk(com.amgcyo.cuttadon.h.f.a aVar) {
        boolean zIsCurrentProcess = isCurrentProcess();
        if (zIsCurrentProcess) {
            String strA = com.amgcyo.cuttadon.utils.otherutils.h.a("csj_new");
            String str = "csjAppId:" + strA;
            if (!TextUtils.isEmpty(strA)) {
                String strD = g0.a().d("hcehiuwhrg");
                String str2 = "old_appid:" + strD;
                if (!TextUtils.isEmpty(strD) && !strA.equals(strD)) {
                    setCsjInit(false);
                }
                isCsjInit();
                if (!isCsjInit()) {
                    com.amgcyo.cuttadon.h.b.d.b(this, strA, aVar);
                } else if (aVar != null) {
                    aVar.success();
                }
            } else if (aVar != null) {
                aVar.success();
            }
        }
        com.amgcyo.cuttadon.utils.otherutils.g.i(zIsCurrentProcess);
    }

    public void initDeviceIdentifier() {
        try {
            com.github.gzuliyujiang.oaid.b.a((Application) this);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void initGdtSdk() {
        boolean zIsCurrentProcess = isCurrentProcess();
        if (zIsCurrentProcess) {
            isGdtInit();
            String strA = com.amgcyo.cuttadon.utils.otherutils.h.a("gdt_new");
            String str = "gdtSdkAppId:" + strA;
            String strD = g0.a().d("koiweoivna");
            String str2 = "old_gdtid:" + strD;
            if (!TextUtils.isEmpty(strD) && !strA.equals(strD)) {
                setGdtInit(false);
            }
            if (!isGdtInit() && !TextUtils.isEmpty(strA)) {
                GDTAdSdk.init(this, strA);
                g0.a().b("koiweoivna", strA);
                setGdtInit(true);
                System.out.println("ylh init result true");
            }
        }
        com.amgcyo.cuttadon.utils.otherutils.g.i(zIsCurrentProcess);
    }

    public void initGromoreSdk(String str) {
        boolean zIsCurrentProcess = isCurrentProcess();
        if (zIsCurrentProcess) {
            com.amgcyo.cuttadon.h.d.d.a.c(this, str);
        }
        com.amgcyo.cuttadon.utils.otherutils.g.i(zIsCurrentProcess);
    }

    public void initKsSdk() {
        boolean zIsCurrentProcess = isCurrentProcess();
        if (zIsCurrentProcess) {
            isKsInit();
            String strD = g0.a().d("fqie9");
            String strA = com.amgcyo.cuttadon.utils.otherutils.h.a("ks");
            if (!TextUtils.isEmpty(strD) && !strA.equals(strD)) {
                setKsInit(false);
            }
            if (!isKsInit() && !TextUtils.isEmpty(strA)) {
                boolean zInit = KsAdSDK.init(this, new SdkConfig.Builder().appId(strA).appName(o.d(R.string.app_name)).showNotification(true).debug(false).build());
                if (zInit) {
                    setKsInit(true);
                    g0.a().b("fqie9", strA);
                }
                System.out.println("ks init result " + zInit);
            }
        }
        com.amgcyo.cuttadon.utils.otherutils.g.i(zIsCurrentProcess);
    }

    public void initToponSdk(String str, String str2) {
    }

    public boolean isCsjInit() {
        return this.f3583u;
    }

    public boolean isCurrentProcess() {
        return b().equals(getPackageName());
    }

    public boolean isGdtInit() {
        return this.f3581s;
    }

    public boolean isKsInit() {
        return this.f3582t;
    }

    public boolean isToponInit() {
        return this.f3584v;
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        me.jessyan.art.base.f.e eVar = this.C;
        if (eVar != null) {
            eVar.b(this);
        }
        D = this;
        com.yyxk.xlog.a.a("xx", false);
        com.amgcyo.cuttadon.widget.ui.b.a(false);
        com.amgcyo.cuttadon.widget.ui.b.a(new com.amgcyo.cuttadon.k.a.a());
        MMKV.initialize(this);
        MMKV.setLogLevel(MMKVLogLevel.LevelNone);
        com.amgcyo.cuttadon.utils.comic.d.a();
        this.mPreferenceManager = new com.amgcyo.cuttadon.utils.comic.a();
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        builder.detectFileUriExposure();
        g();
        d();
        if (!isCurrentProcess() && Build.VERSION.SDK_INT >= 28) {
            try {
                String strB = b();
                String str = "其他进程:" + strB;
                WebView.setDataDirectorySuffix(strB);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        com.amgcyo.cuttadon.i.m.c(this);
        c();
        f();
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        String strG = com.amgcyo.cuttadon.utils.otherutils.g.g(this);
        String str = "x1AppId:" + strG;
        if (TextUtils.isEmpty(strG)) {
            return;
        }
        SNAdSdk.onApplicationLowMemory(this);
    }

    @Override // android.app.Application
    public void onTerminate() {
        super.onTerminate();
        me.jessyan.art.base.f.e eVar = this.C;
        if (eVar != null) {
            eVar.a(this);
        }
    }

    public void setAppConfig(MkAppConfig mkAppConfig) {
        this.f3585w = mkAppConfig;
    }

    public void setCsjInit(boolean z2) {
        this.f3583u = z2;
    }

    public void setDomainUrl(String str) {
        me.jessyan.retrofiturlmanager.a aVarF = me.jessyan.retrofiturlmanager.a.f();
        if (TextUtils.isEmpty(str)) {
            str = "chuangke.tv";
        }
        aVarF.a("my", String.format("%smy.%s", "https://", str));
        aVarF.a("conf", String.format("%sconf.%s", "https://", str));
        aVarF.a("book", String.format("%sbook.%s", "https://", str));
        aVarF.a("ad", String.format("%sad.%s", "https://", str));
        aVarF.a("catalog", String.format("%scatalog.%s", "https://", str));
        aVarF.a("chapter", String.format("%schapter.%s", "https://", str));
        aVarF.a("s", String.format("%ss.%s", "https://", str));
        aVarF.a("avatar", String.format("%savatar.%s", "https://", str));
        aVarF.a(Constants.SEND_TYPE_RES, String.format("%sres.%s", "https://", str));
        aVarF.a("d", String.format("%sd.%s", "https://", str));
        aVarF.a("comic_cover_res", String.format("%sc-res.%s", "https://", str));
        aVarF.a("comic_catalog", String.format("%sc-catalog.%s", "https://", str));
        aVarF.a("comic_chapter", String.format("%sc-chapter.%s", "https://", str));
        aVarF.a("comic_pic", String.format("%sc-pic.%s", "https://", str));
        aVarF.a("ads-api", String.format("%sads-api.%s", "https://", str));
        aVarF.a("l", String.format("%sl.%s", "https://", str));
    }

    public void setDomainUrlBySecondDomain(SecondaryDomain secondaryDomain) {
        me.jessyan.retrofiturlmanager.a aVarF = me.jessyan.retrofiturlmanager.a.f();
        String strF = com.amgcyo.cuttadon.utils.otherutils.g.F();
        if (TextUtils.isEmpty(strF)) {
            strF = "chuangke.tv";
        }
        String my = secondaryDomain.getMy();
        if (TextUtils.isEmpty(my)) {
            aVarF.a("my", String.format("%smy.%s", "https://", strF));
        } else {
            aVarF.a("my", my);
        }
        String book = secondaryDomain.getBook();
        if (TextUtils.isEmpty(book)) {
            aVarF.a("book", String.format("%sbook.%s", "https://", strF));
        } else {
            aVarF.a("book", book);
        }
        String conf = secondaryDomain.getConf();
        if (TextUtils.isEmpty(conf)) {
            aVarF.a("ad", String.format("%sad.%s", "https://", strF));
            aVarF.a("conf", String.format("%sconf.%s", "https://", strF));
        } else {
            aVarF.a("ad", conf);
            aVarF.a("conf", conf);
        }
        String catalog = secondaryDomain.getCatalog();
        if (TextUtils.isEmpty(catalog)) {
            aVarF.a("catalog", String.format("%scatalog.%s", "https://", strF));
        } else {
            aVarF.a("catalog", catalog);
        }
        String chapter = secondaryDomain.getChapter();
        if (TextUtils.isEmpty(chapter)) {
            aVarF.a("chapter", String.format("%schapter.%s", "https://", strF));
        } else {
            aVarF.a("chapter", chapter);
        }
        String s2 = secondaryDomain.getS();
        if (TextUtils.isEmpty(s2)) {
            aVarF.a("s", String.format("%ss.%s", "https://", strF));
        } else {
            aVarF.a("s", s2);
        }
        String avatar = secondaryDomain.getAvatar();
        if (TextUtils.isEmpty(avatar)) {
            aVarF.a("avatar", String.format("%savatar.%s", "https://", strF));
        } else {
            aVarF.a("avatar", avatar);
        }
        String res = secondaryDomain.getRes();
        if (TextUtils.isEmpty(res)) {
            aVarF.a(Constants.SEND_TYPE_RES, String.format("%sres.%s", "https://", strF));
        } else {
            aVarF.a(Constants.SEND_TYPE_RES, res);
        }
        String d2 = secondaryDomain.getD();
        if (TextUtils.isEmpty(d2)) {
            aVarF.a("d", String.format("%sd.%s", "https://", strF));
        } else {
            aVarF.a("d", d2);
        }
        String c_res = secondaryDomain.getC_res();
        if (TextUtils.isEmpty(c_res)) {
            aVarF.a("comic_cover_res", String.format("%sc-res.%s", "https://", strF));
        } else {
            aVarF.a("comic_cover_res", c_res);
        }
        String c_catalog = secondaryDomain.getC_catalog();
        if (TextUtils.isEmpty(c_catalog)) {
            aVarF.a("comic_catalog", String.format("%sc-catalog.%s", "https://", strF));
        } else {
            aVarF.a("comic_catalog", c_catalog);
        }
        String c_chapter = secondaryDomain.getC_chapter();
        if (TextUtils.isEmpty(c_chapter)) {
            aVarF.a("comic_chapter", String.format("%sc-chapter.%s", "https://", strF));
        } else {
            aVarF.a("comic_chapter", c_chapter);
        }
        String c_pic = secondaryDomain.getC_pic();
        if (TextUtils.isEmpty(c_pic)) {
            aVarF.a("comic_pic", String.format("%sc-pic.%s", "https://", strF));
        } else {
            aVarF.a("comic_pic", c_pic);
        }
        String ad = secondaryDomain.getAd();
        if (TextUtils.isEmpty(ad)) {
            ad = strF;
        }
        aVarF.a("ads-api", String.format("%sads-api.%s", "https://", ad));
        aVarF.a("l", String.format("%sl.%s", "https://", ad));
    }

    public void setFissionUrl(String str) {
        this.B = str;
    }

    public void setGdtInit(boolean z2) {
        this.f3581s = z2;
    }

    public void setKsInit(boolean z2) {
        this.f3582t = z2;
    }

    public void setNewApiAdList(NewApiAdList newApiAdList) {
        this.f3586x = newApiAdList;
    }

    public void setOrientation(int i2) {
        this.f3588z = i2;
    }

    public void setToponInit(boolean z2) {
        this.f3584v = z2;
    }

    public void setVersion(MkAppVersion mkAppVersion) {
        this.A = mkAppVersion;
    }

    public void setVersion_data(ArrayList<Integer> arrayList) {
        this.f3587y = arrayList;
    }

    private void a(String str) {
        com.amgcyo.cuttadon.utils.otherutils.g.f(false);
        new CrashReport.UserStrategy(getApplicationContext()).setAppChannel(com.amgcyo.cuttadon.utils.otherutils.g.T());
        CrashReport.initCrashReport(getApplicationContext(), str, false);
        com.amgcyo.cuttadon.utils.otherutils.g.f(true);
    }

    static /* synthetic */ void a(Throwable th) throws Exception {
        th.printStackTrace();
        th.printStackTrace(new PrintWriter((Writer) new StringWriter(), true));
    }

    private void a(Context context) {
        String strG = com.amgcyo.cuttadon.utils.otherutils.g.g(context);
        String str = "x1AppId:" + strG;
        if (TextUtils.isEmpty(strG)) {
            return;
        }
        SNAdSdk.onApplicationAttachBaseContext(this, new b(this, context, strG));
    }
}
