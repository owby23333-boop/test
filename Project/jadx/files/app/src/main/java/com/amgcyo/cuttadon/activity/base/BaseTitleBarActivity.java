package com.amgcyo.cuttadon.activity.base;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.FragmentActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.BmobDialogButtonListener;
import cn.bmob.v3.listener.BmobUpdateListener;
import cn.bmob.v3.update.BmobUpdateAgent;
import cn.bmob.v3.update.UpdateResponse;
import com.amgcyo.cuttadon.activity.feedback.MkFeedBackActivity;
import com.amgcyo.cuttadon.activity.main.AndroidAppActivity;
import com.amgcyo.cuttadon.activity.main.ArtGuiderDaoliuActivity;
import com.amgcyo.cuttadon.api.entity.comment.CommentReprotType;
import com.amgcyo.cuttadon.api.entity.config.BaseAd;
import com.amgcyo.cuttadon.api.entity.config.MkAppConfig;
import com.amgcyo.cuttadon.api.entity.config.NotifyBean;
import com.amgcyo.cuttadon.api.entity.migrate.DaoliuBook;
import com.amgcyo.cuttadon.api.entity.migrate.DaoliuData;
import com.amgcyo.cuttadon.api.entity.migrate.DaoliuUser;
import com.amgcyo.cuttadon.api.entity.other.MkAppVersion;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.entity.other.MkUser;
import com.amgcyo.cuttadon.api.entity.other.RewardAdParam;
import com.amgcyo.cuttadon.api.entity.other.SdkErrorBean;
import com.amgcyo.cuttadon.api.entity.other.VideoAddBook;
import com.amgcyo.cuttadon.api.presenter.BookPresenter;
import com.amgcyo.cuttadon.api.presenter.ConfigPresenter;
import com.amgcyo.cuttadon.api.presenter.UserPresenter;
import com.amgcyo.cuttadon.app.MkApplication;
import com.amgcyo.cuttadon.database.AppDatabase;
import com.amgcyo.cuttadon.f.s.a;
import com.amgcyo.cuttadon.sdk.ui.OwnerRewardFullVideoActivity;
import com.amgcyo.cuttadon.sdk.ui.OwnerSplashActivity;
import com.amgcyo.cuttadon.sdk.ui.SdkFullVideoActivity;
import com.amgcyo.cuttadon.sdk.ui.SdkSplashActivity;
import com.amgcyo.cuttadon.utils.event.MkCommentEvent;
import com.amgcyo.cuttadon.utils.otherutils.DrainThrowable;
import com.amgcyo.cuttadon.utils.otherutils.c0;
import com.amgcyo.cuttadon.utils.otherutils.g0;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.amgcyo.cuttadon.utils.otherutils.x0;
import com.amgcyo.cuttadon.utils.otherutils.z;
import com.amgcyo.cuttadon.view.dialog.b1;
import com.amgcyo.cuttadon.view.dialog.d1;
import com.amgcyo.cuttadon.view.otherview.TintableImageView;
import com.amgcyo.cuttadon.view.xtablayout.XTabLayout;
import com.amgcyo.cuttadon.widget.ui.MoreTextView;
import com.amgcyo.cuttadon.widget.ui.b;
import com.baidu.mobads.sdk.internal.am;
import com.bytedance.msdk.api.AdError;
import com.fatcatfat.io.R;
import com.open.hule.library.entity.AppUpdate;
import com.open.hule.library.entity.SafBean;
import com.open.hule.library.entity.TipsBean;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.tencent.bugly.crashreport.CrashReport;
import com.umeng.analytics.MobclickAgent;
import io.reactivex.disposables.Disposable;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.jessyan.art.base.convert.ApiException;
import me.jessyan.art.entity.BaseModel;
import me.jessyan.art.mvp.Message;
import me.jessyan.art.mvp.c;
import org.jetbrains.annotations.NotNull;
import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;
import org.simple.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseTitleBarActivity<P extends me.jessyan.art.mvp.c> extends AppCompatActivity implements me.jessyan.art.base.f.h<P>, me.jessyan.art.mvp.e, com.open.hule.library.b.a {
    public static int READ_REQUEST_CODE = 10001;
    public static int WRITE_REQUEST_CODE = 10002;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private static long f2260m0;
    protected RelativeLayout A;
    protected TextView B;
    protected TintableImageView C;
    protected MoreTextView D;
    protected XTabLayout E;
    FrameLayout F;
    protected me.jessyan.art.c.e.c G;
    private d1 J;
    private MkBook K;
    protected b.c L;
    ViewGroup N;
    protected boolean O;
    protected boolean P;
    private int Q;
    private long R;
    private long S;
    protected int T;
    protected int U;
    protected int V;
    protected int W;
    protected int X;
    protected String Y;
    private List<BaseAd> Z;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private File f2265e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private boolean f2266f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private ConfigPresenter f2267g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private com.open.hule.library.c.c f2268h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private SafBean f2269i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private String f2270j0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private String f2272l0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private me.jessyan.art.d.j.a<String, Object> f2274t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Unbinder f2275u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    protected P f2276v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    protected Context f2277w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    protected View f2278x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    protected Toolbar f2279y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    protected LinearLayout f2280z;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected final String f2273s = getClass().getSimpleName();
    public boolean isNeedNightModel = true;
    public boolean setDiffentStatusBar = true;
    private Runnable H = new Runnable() { // from class: com.amgcyo.cuttadon.activity.base.l
        @Override // java.lang.Runnable
        public final void run() {
            this.f2295s.n();
        }
    };
    private Handler I = new Handler(Looper.getMainLooper());
    private View M = null;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private boolean f2261a0 = false;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private com.amgcyo.cuttadon.h.f.c f2262b0 = new a();

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private boolean f2263c0 = true;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private Handler f2264d0 = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    protected boolean f2271k0 = false;

    class a implements com.amgcyo.cuttadon.h.f.c {
        a() {
        }

        @Override // com.amgcyo.cuttadon.h.f.c
        public void onRewardAdClose(String str) {
            String str2 = "adPosition:" + str;
            if (BaseTitleBarActivity.this.f2261a0 && BaseTitleBarActivity.this.e(str)) {
                if (BaseTitleBarActivity.this.K == null || BaseTitleBarActivity.this.K.getBook_id() <= 0) {
                    BaseTitleBarActivity.this.d("获取数据成功，请手动加入书架！");
                } else {
                    BaseTitleBarActivity.this.d("获取数据成功，正在自动加入书架！");
                    new BookPresenter(me.jessyan.art.f.e.a(BaseTitleBarActivity.this.f2277w)).a(Message.a(BaseTitleBarActivity.this.a(), new Object[]{BaseTitleBarActivity.this.K}), true);
                }
            } else if (BaseTitleBarActivity.this.f2261a0) {
                com.amgcyo.cuttadon.utils.otherutils.h.R0();
            }
            BaseTitleBarActivity.this.f2261a0 = false;
        }

        @Override // com.amgcyo.cuttadon.h.f.c
        public void onRewardAdFail(int i2, String str, String str2, String str3) {
            System.out.println(str2 + "wake up load reward data fail code:" + i2 + " msg: " + str);
            if (com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) BaseTitleBarActivity.this.Z)) {
                BaseTitleBarActivity.this.f2261a0 = false;
                if (BaseTitleBarActivity.this.e(str3)) {
                    BaseTitleBarActivity.this.showErrorMsgGravityBottom("获取数据失败，暂时无法添加，请1小时后重试，错误码：" + i2);
                    return;
                }
                return;
            }
            BaseAd baseAd = (BaseAd) BaseTitleBarActivity.this.Z.get(0);
            baseAd.setLoad_type(0);
            String platform = baseAd.getPlatform();
            int style = baseAd.getStyle();
            Iterator it = BaseTitleBarActivity.this.Z.iterator();
            if (it.hasNext()) {
                try {
                    it.next();
                    it.remove();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BaseTitleBarActivity.this.Z.clear();
                }
            }
            if (!"csj_new".equals(platform)) {
                BaseTitleBarActivity.this.a(str3, baseAd);
                return;
            }
            if (6 == style) {
                BaseTitleBarActivity.this.a(str3, baseAd);
                return;
            }
            if (8 == style) {
                String strA = com.amgcyo.cuttadon.utils.otherutils.h.a("csj_new", "v");
                String str4 = BaseTitleBarActivity.this.f2273s;
                String str5 = "新插屏id：" + strA;
                com.amgcyo.cuttadon.h.b.c.d().a(BaseTitleBarActivity.this.f2277w, strA, str3, this);
            }
        }

        @Override // com.amgcyo.cuttadon.h.f.c
        public void onRewardAdSuccess(com.amgcyo.cuttadon.h.g.h hVar) {
            BaseTitleBarActivity.this.f2261a0 = false;
            if (hVar != null) {
                BaseTitleBarActivity.this.f2261a0 = true;
                if (BaseTitleBarActivity.this.e(hVar.b) && hVar.f3980d) {
                    BaseTitleBarActivity.this.d("获取数据成功，请返回继续操作！");
                }
                System.out.println("wake up load reward data success, thanks");
            }
        }

        @Override // com.amgcyo.cuttadon.h.f.c
        public void onRewardAdVideoCached(Object obj) {
        }
    }

    class b extends com.amgcyo.cuttadon.j.g.h.b<Object> {
        b(Object obj) {
            super(obj);
        }

        @Override // com.amgcyo.cuttadon.j.g.g.a
        public Void a(Object obj) throws Throwable {
            BaseTitleBarActivity.this.r();
            return null;
        }
    }

    class c extends com.amgcyo.cuttadon.j.g.h.a<String, Boolean> {
        c(String str) {
            super(str);
        }

        @Override // com.amgcyo.cuttadon.j.g.g.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Boolean bool) {
            if (bool.booleanValue()) {
                BaseTitleBarActivity.this.p();
            } else {
                BaseTitleBarActivity.this.q();
            }
        }

        @Override // com.amgcyo.cuttadon.j.g.g.a
        public Boolean a(String str) {
            return Boolean.valueOf(com.amgcyo.cuttadon.utils.otherutils.g.a(AppDatabase.i().a().c()) && com.amgcyo.cuttadon.utils.otherutils.g.j() == null);
        }
    }

    class d extends com.amgcyo.cuttadon.j.g.h.a<String, String> {
        d(String str) {
            super(str);
        }

        @Override // com.amgcyo.cuttadon.j.g.g.a
        public String a(String str) {
            return com.amgcyo.cuttadon.utils.otherutils.g.y();
        }

        @Override // com.amgcyo.cuttadon.j.g.g.b
        public void b(String str) {
            if (TextUtils.isEmpty(str)) {
                BaseTitleBarActivity.this.showMessage("无需备份！请点击下载！");
                BaseTitleBarActivity.this.p();
                return;
            }
            try {
                Toast.makeText(BaseTitleBarActivity.this.f2277w, "请选择一个方便好记的文件夹后进行保存备份!", 0).show();
                Intent intent = new Intent("android.intent.action.CREATE_DOCUMENT");
                intent.addCategory("android.intent.category.OPENABLE");
                intent.setType(am.f12848e);
                intent.putExtra("android.content.extra.SHOW_ADVANCED", true);
                intent.putExtra("android.content.extra.FANCY", true);
                intent.putExtra("android.content.extra.SHOW_FILESIZE", true);
                intent.putExtra("android.intent.extra.TITLE", z.f());
                BaseTitleBarActivity.this.startActivityForResult(intent, BaseTitleBarActivity.WRITE_REQUEST_CODE);
            } catch (Exception e2) {
                e2.printStackTrace();
                BaseTitleBarActivity.this.showErrorMsgGravityBottom("无法启动备份组件，备份失败！");
                BaseTitleBarActivity.this.a("open saf fail", e2);
                BaseTitleBarActivity baseTitleBarActivity = BaseTitleBarActivity.this;
                baseTitleBarActivity.f2271k0 = false;
                baseTitleBarActivity.a((Uri) null);
            }
        }
    }

    private void A() {
        String strS = com.amgcyo.cuttadon.utils.otherutils.h.s();
        try {
            if (!TextUtils.isEmpty(strS)) {
                showLoading();
                Bmob.initialize(this, strS);
                BmobUpdateAgent.setUpdateListener(new BmobUpdateListener() { // from class: com.amgcyo.cuttadon.activity.base.g
                    @Override // cn.bmob.v3.listener.BmobUpdateListener
                    public final void onUpdateReturned(int i2, UpdateResponse updateResponse) {
                        this.a.a(i2, updateResponse);
                    }
                });
                BmobUpdateAgent.setDialogListener(new BmobDialogButtonListener() { // from class: com.amgcyo.cuttadon.activity.base.h
                    @Override // cn.bmob.v3.listener.BmobDialogButtonListener
                    public final void onClick(int i2) {
                        this.a.b(i2);
                    }
                });
                BmobUpdateAgent.forceUpdate(this);
            } else if (this.f2266f0) {
                com.amgcyo.cuttadon.f.o.a((Context) this);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            hideLoading();
            if (this.f2266f0) {
                com.amgcyo.cuttadon.f.o.a((Context) this);
            }
        }
    }

    static /* synthetic */ void a(int i2, Intent intent) {
    }

    static /* synthetic */ void d(View view) {
    }

    public static boolean isForeground(Activity activity) {
        return isForeground(activity, activity.getClass().getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        try {
            if (this.J != null && this.J.isShowing()) {
                this.J.dismiss();
                this.J = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean o() {
        int i2 = this.U;
        return i2 == 0 || this.S - this.R >= ((long) (i2 * BaseConstants.Time.MINUTE));
    }

    @Subscriber
    private void onReceiveStickyEvent(File file) {
        if (file == null || a() == null || !isForeground(a())) {
            return;
        }
        b(file);
        EventBus.getDefault().removeStickyEvent(file.getClass());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        SafBean safBean;
        if (this.f2268h0 == null || (safBean = this.f2269i0) == null) {
            return;
        }
        int type = safBean.getType();
        if (type != 1) {
            if (type != 2) {
                this.f2268h0.a(false);
                return;
            }
            String migration_package = this.f2269i0.getMigration_package();
            if (TextUtils.isEmpty(migration_package)) {
                return;
            }
            com.open.hule.library.c.b.c(a(), migration_package);
            return;
        }
        File file = this.f2269i0.getFile();
        if (file != null && file.exists()) {
            this.f2268h0.a(file);
        } else {
            c("安装文件不存在，正在重新下载！");
            this.f2268h0.a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        com.amgcyo.cuttadon.j.g.b.a(new d(""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:102:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0170 A[PHI: r8
  0x0170: PHI (r8v8 java.io.InputStream) = 
  (r8v1 java.io.InputStream)
  (r8v10 java.io.InputStream)
  (r8v10 java.io.InputStream)
  (r8v10 java.io.InputStream)
  (r8v10 java.io.InputStream)
 binds: [B:5:0x0032, B:11:0x005a, B:13:0x0074, B:15:0x0087, B:17:0x0096] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01b0 A[Catch: Exception -> 0x01ac, TRY_LEAVE, TryCatch #1 {Exception -> 0x01ac, blocks: (B:77:0x01a8, B:81:0x01b0), top: B:89:0x01a8 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void r() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 442
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity.r():void");
    }

    @Subscriber(mode = ThreadMode.POST, tag = "install_permission")
    private void refreshUserIndex(File file) {
        if (file == null || a() == null || !isForeground(a())) {
            return;
        }
        b(file);
    }

    private int s() {
        return com.amgcyo.cuttadon.utils.otherutils.n.a(this.f2277w) / 4;
    }

    @Subscriber(mode = ThreadMode.MAIN, tag = "submitFeebV2")
    private void subscriberSubmitV2(SdkErrorBean sdkErrorBean) {
        String str;
        if (sdkErrorBean == null) {
            return;
        }
        UserPresenter userPresenter = new UserPresenter(me.jessyan.art.f.e.a(this.f2277w));
        showLoading();
        String str2 = "请求配置时间：";
        MkApplication appContext = MkApplication.getAppContext();
        MkAppConfig appConfig = appContext.getAppConfig();
        if (appConfig != null) {
            str2 = "请求配置时间：" + appConfig.getSave_time() + " | " + appConfig.isIs_success() + " | ";
        }
        if (com.amgcyo.cuttadon.h.j.a.a()) {
            str = "x1 sdk 判断该用户或设备为：" + com.amgcyo.cuttadon.utils.otherutils.g.G() + " | ";
        } else {
            str = "";
        }
        userPresenter.M(Message.a(this, new Object[]{"获取数据失败，错误码：" + sdkErrorBean.getErrorCode(), "无联系方式", (str + " csj:" + appContext.isCsjInit() + " gdt:" + appContext.isGdtInit() + " topon:" + appContext.isToponInit() + " ks:" + appContext.isKsInit()) + " appId：" + sdkErrorBean.getAppId() + " | codeId：" + sdkErrorBean.getCodeId() + " | adPosition：" + sdkErrorBean.getAdPosition() + " | url：" + com.amgcyo.cuttadon.utils.otherutils.g.F() + " | msg：" + sdkErrorBean.getErrorMsg() + " | sha1：" + com.amgcyo.cuttadon.utils.otherutils.g.q() + " | " + str2 + sdkErrorBean.getSaveTime()}));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        this.I.post(this.H);
    }

    private void u() {
        com.open.hule.library.c.c cVar = this.f2268h0;
        if (cVar != null) {
            cVar.a(new File[0]);
        }
    }

    protected static boolean v() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z2 = jCurrentTimeMillis - f2260m0 < 500;
        f2260m0 = jCurrentTimeMillis;
        return z2;
    }

    private boolean w() {
        int i2 = this.T;
        if (i2 != 1) {
            return i2 != 0 && this.Q % i2 == 0;
        }
        return true;
    }

    private void x() {
        BaseAd baseAd;
        List<BaseAd> listB = com.amgcyo.cuttadon.sdk.utils.h.b("awaken");
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(listB)) {
            return;
        }
        if (1 == listB.size()) {
            baseAd = listB.get(0);
        } else {
            g0 g0VarA = g0.a();
            int iA = g0VarA.a("candidate", 0);
            try {
                BaseAd baseAd2 = listB.get(iA);
                if (baseAd2 != null) {
                    g0VarA.b("candidate", iA + 1);
                }
                baseAd = baseAd2;
            } catch (Exception unused) {
                baseAd = listB.get(0);
                if (baseAd != null) {
                    g0VarA.b("candidate", 1);
                }
            }
        }
        if (baseAd == null) {
            return;
        }
        String platform = baseAd.getPlatform();
        int style = baseAd.getStyle();
        if (TextUtils.isEmpty(platform) || style <= 0) {
            String str = "唤醒不满足：platform: " + platform;
            return;
        }
        this.T = com.amgcyo.cuttadon.sdk.utils.h.a("awaken", "interval_count");
        this.U = com.amgcyo.cuttadon.sdk.utils.h.a("awaken", "interval_min");
        this.V = com.amgcyo.cuttadon.sdk.utils.h.a("awaken", "second");
        this.W = com.amgcyo.cuttadon.utils.otherutils.h.y0();
        this.X = com.amgcyo.cuttadon.utils.otherutils.h.A0();
        boolean zO = o();
        if (!w() || !zO) {
            String str2 = "唤醒不满足：isTrueAd() && checkTime()：isTrueAd()：" + w() + " checkTime(): " + zO;
            return;
        }
        if (!"self".equals(platform)) {
            switch (style) {
                case 1:
                    this.Y = com.amgcyo.cuttadon.utils.otherutils.h.a(platform, "c");
                    SdkSplashActivity.launch(this, platform, this.Y, false);
                    break;
                case 2:
                case 4:
                    b(platform, style);
                    break;
                case 3:
                    String str3 = "唤醒 当天需要观看激励视频次数:" + this.W + " 当天已观看激励视频次数: " + this.X;
                    if (this.X >= this.W) {
                        b(platform, com.amgcyo.cuttadon.utils.otherutils.g.D());
                    } else {
                        a("position_wake_up_reward_ad_video", new BaseAd(platform, style));
                    }
                    break;
                case 5:
                case 6:
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new BaseAd(platform, style));
                    com.amgcyo.cuttadon.h.a.h.a(this.f2277w, "repositorylastoma", arrayList);
                    break;
            }
        } else if (style == 1) {
            OwnerSplashActivity.launch(a(), this.V, false);
        } else if (style == 9) {
            Intent intent = new Intent(this.f2277w, (Class<?>) OwnerRewardFullVideoActivity.class);
            intent.putExtra("key_txmoney", style);
            intent.putExtra("ltype", false);
            com.amgcyo.cuttadon.f.s.a.c((Activity) this.f2277w).startActivityForResult(intent, new a.InterfaceC0088a() { // from class: com.amgcyo.cuttadon.activity.base.e
                @Override // com.amgcyo.cuttadon.f.s.a.InterfaceC0088a
                public final void a(int i2, Intent intent2) {
                    BaseTitleBarActivity.a(i2, intent2);
                }
            });
        }
        com.amgcyo.cuttadon.utils.otherutils.h.Q0();
    }

    private void y() {
        try {
            com.amgcyo.cuttadon.j.g.b.a(new c(""));
        } catch (Exception e2) {
            e2.printStackTrace();
            showErrorMsgGravityBottom("备份失败，请反馈给客服！");
        }
    }

    @RequiresApi(api = 26)
    private void z() {
        startActivityForResult(new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + getPackageName())), AdError.AD_NO_FILL);
    }

    protected abstract BaseTitleBarActivity a();

    @Override // me.jessyan.art.mvp.e
    public void addBookToShelfV6(Message message) {
        if (message == null) {
            showMessage("添加失败，请重试！");
            return;
        }
        VideoAddBook videoAddBook = (VideoAddBook) message.f21202x;
        if (videoAddBook == null) {
            showMessage("添加失败，请重试！");
            return;
        }
        MkBook book = videoAddBook.getBook();
        BaseAd baseAdB = com.amgcyo.cuttadon.sdk.utils.e.b("position_add_book_reward_ad_video", "video_add_book");
        if (baseAdB == null || book == null) {
            return;
        }
        this.K = book;
        a("position_add_book_reward_ad_video", baseAdB);
        message.f21197s = 2022505;
        message.b();
    }

    @Override // com.open.hule.library.b.a
    @RequiresApi(api = 23)
    public void applyAndroidOInstall(File file) {
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.REQUEST_INSTALL_PACKAGES"}, 1112);
    }

    @Override // com.open.hule.library.b.a
    public void bauckUpData(SafBean safBean) {
        this.f2269i0 = safBean;
        y();
    }

    public void checkUpdate(MkAppVersion mkAppVersion) {
        if (this.f2268h0 == null) {
            this.f2268h0 = new com.open.hule.library.c.c(this);
        }
        String apk_size = mkAppVersion.getApk_size();
        int i2 = (TextUtils.isEmpty(apk_size) || "0".equals(apk_size)) ? 1 : 0;
        String str = "downloadScheme:" + i2;
        this.f2268h0.a(new AppUpdate.Builder().newVersionUrl(mkAppVersion.getDownload_url()).downBrowserUrl(com.amgcyo.cuttadon.utils.otherutils.h.C0()).updateBtnBgResourceId(R.drawable.update_round_bg_new).updateTopImgResourceId(R.drawable.top_3).forceUpdate(mkAppVersion.getUpdate_state()).newVersionCode(mkAppVersion.getVersion_name()).downloadScheme(i2).tipsBean(new TipsBean(mkAppVersion.getContent(), s())).build(), this);
    }

    protected abstract String d();

    public void finishActivity() {
    }

    @Override // me.jessyan.art.mvp.e
    public void finishReadActivity() {
    }

    @Override // com.open.hule.library.b.a
    public void forceExit() {
        MobclickAgent.onKillProcess(this);
        finish();
        System.exit(0);
    }

    public void getArtAppVersionMethod() {
        if (this.f2267g0 == null) {
            this.f2267g0 = new ConfigPresenter(me.jessyan.art.f.e.a(this));
        }
        this.f2267g0.d(Message.a(this, new Object[0]));
    }

    @Override // me.jessyan.art.mvp.e
    public Context getHostContext() {
        return this.f2277w;
    }

    @Override // com.open.hule.library.b.a
    public void gotoFeedback() {
        r0.startActivity(this.f2277w, MkFeedBackActivity.class);
    }

    protected void h() {
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags(DownloadExpSwitchCode.BACK_BUGFIX_SIGBUS);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.clearFlags(DownloadExpSwitchCode.BACK_BUGFIX_SIGBUS);
            window.getDecorView().setSystemUiVisibility(1280);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        }
    }

    @Override // me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        int i2 = message.f21197s;
        if (i2 == 102) {
            Throwable th = (Throwable) message.f21202x;
            if (th instanceof ApiException) {
                StringBuilder sb = new StringBuilder();
                ApiException apiException = (ApiException) th;
                sb.append(apiException.f());
                sb.append(" ");
                sb.append(apiException.g());
                sb.toString();
                b1 b1Var = new b1(this);
                b1Var.show();
                b1Var.a(apiException.g());
            }
            try {
                Boolean.valueOf(com.amgcyo.cuttadon.utils.otherutils.p.a((DaoliuData) message.f21203y[4], this));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            me.jessyan.art.d.f.a().a(new MkCommentEvent(), "tag_daoliu_view");
            return;
        }
        if (i2 == 103) {
            hideLoading();
            MkUser mkUser = (MkUser) message.f21202x;
            if (mkUser != null) {
                me.jessyan.art.d.f.a().a(mkUser, "refreshingBookShelf");
                return;
            } else {
                if (com.amgcyo.cuttadon.utils.otherutils.p.a((DaoliuData) message.f21203y[4], this)) {
                    me.jessyan.art.d.f.a().a(new MkCommentEvent(), "tag_daoliu_view");
                    return;
                }
                return;
            }
        }
        if (i2 != 851) {
            return;
        }
        hideLoading();
        MkAppVersion mkAppVersion = (MkAppVersion) message.f21202x;
        Boolean.valueOf(mkAppVersion == null);
        if (mkAppVersion == null) {
            A();
        } else {
            b(mkAppVersion);
        }
    }

    @Override // me.jessyan.art.mvp.e
    public void hideLoading() {
        runOnUiThread(new com.amgcyo.cuttadon.activity.base.d(this));
    }

    public /* synthetic */ void i() {
        com.amgcyo.cuttadon.j.g.b.a(new v(this, ""));
    }

    public boolean isRunningInForeground() {
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(runningAppProcessInfo);
        int i2 = runningAppProcessInfo.importance;
        return i2 == 100 || i2 == 200;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j() {
    }

    protected void k() {
        Intent intent = new Intent(this, (Class<?>) AndroidAppActivity.class);
        intent.addFlags(DownloadExpSwitchCode.BACK_BUGFIX_SIGBUS);
        startActivity(intent);
        finish();
    }

    protected abstract boolean l();

    protected abstract boolean m();

    public void netWorkConnect(boolean z2) {
    }

    public boolean networkisAvailable() {
        return me.jessyan.art.f.f.a(this.f2277w) && me.jessyan.art.f.f.b(this.f2277w);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        File file;
        super.onActivityResult(i2, i3, intent);
        if (i2 == 10086 && i3 == -1 && (file = this.f2265e0) != null) {
            a(file);
            return;
        }
        if (i2 == 1113) {
            if (Build.VERSION.SDK_INT >= 26) {
                if (getPackageManager().canRequestPackageInstalls()) {
                    u();
                    return;
                }
                Toast.makeText(a(), "您拒绝了安装未知来源应用，应用暂时无法更新或安装！", 0).show();
                com.open.hule.library.c.c cVar = this.f2268h0;
                if (cVar == null || cVar.d().getForceUpdate() == 0) {
                    return;
                }
                forceExit();
                return;
            }
            return;
        }
        if (i2 == WRITE_REQUEST_CODE) {
            if (i3 != -1) {
                c("你似乎没有执行任何操作~");
                return;
            }
            Uri data = intent != null ? intent.getData() : null;
            if (data == null) {
                this.f2271k0 = false;
                b(" write_request_code uri is null.");
                a((Uri) null);
                return;
            } else {
                String str = "uri: " + data.toString();
                c(data);
                return;
            }
        }
        if (i2 == READ_REQUEST_CODE) {
            if (i3 != -1) {
                c("你似乎没有执行任何操作~");
                return;
            }
            Uri data2 = intent != null ? intent.getData() : null;
            if (data2 == null) {
                c("读取备份文件失败，请反馈给客服！");
                b(" read_request_code uri is null.");
                return;
            }
            String str2 = "uri: " + data2.toString();
            b(data2);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) throws Exception {
        super.onCreate(bundle);
        if (MkApplication.killFlag == -1) {
            k();
            return;
        }
        try {
            this.f2277w = this;
            if (m()) {
                this.f2278x = View.inflate(this, R.layout.mk_ac_base, null);
                this.f2280z = (LinearLayout) this.f2278x.findViewById(R.id.ll_include_root);
                this.f2279y = (Toolbar) this.f2278x.findViewById(R.id.toolbar);
                this.B = (TextView) this.f2278x.findViewById(R.id.toolbar_title);
                this.C = (TintableImageView) this.f2278x.findViewById(R.id.img_back);
                this.D = (MoreTextView) this.f2278x.findViewById(R.id.toolbar_right);
                this.A = (RelativeLayout) this.f2278x.findViewById(R.id.toolbar_back);
                this.E = (XTabLayout) this.f2278x.findViewById(R.id.xtablayout);
                if (this.f2280z != null) {
                    this.f2280z.setVisibility(0);
                }
                if (this.f2279y != null) {
                    this.f2279y.setVisibility(0);
                }
                if (l()) {
                    this.B.setVisibility(8);
                    this.E.setVisibility(0);
                } else {
                    this.B.setVisibility(0);
                    this.E.setVisibility(8);
                }
                a(bundle);
                setContentView(this.f2278x);
                this.f2275u = ButterKnife.bind(this, this.f2278x);
            } else {
                int iInitView = initView(bundle);
                if (iInitView != 0) {
                    setContentView(iInitView);
                    this.f2275u = ButterKnife.bind(this);
                }
            }
            this.G = me.jessyan.art.f.e.a(this.f2277w).imageLoader();
            if (m() && this.B != null) {
                this.B.setText(d() == null ? getResources().getString(R.string.app_name) : d());
            }
            me.jessyan.art.f.h.a((Activity) this);
            initData(bundle);
            EventBus.getDefault().registerSticky(this);
        } catch (Exception e2) {
            if (e2 instanceof InflateException) {
                throw e2;
            }
            e2.printStackTrace();
            StringWriter stringWriter = new StringWriter();
            e2.printStackTrace(new PrintWriter((Writer) stringWriter, true));
            z.b(stringWriter.toString(), z.c(), "error.data");
            showMessage("错误码:3000");
            com.amgcyo.cuttadon.utils.otherutils.g.a(new Throwable(e2), "base");
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(@NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        View viewA = me.jessyan.art.f.i.a(str, context, attributeSet);
        return viewA == null ? super.onCreateView(str, context, attributeSet) : viewA;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Unbinder unbinder = this.f2275u;
        if (unbinder != null && unbinder != Unbinder.EMPTY) {
            unbinder.unbind();
        }
        this.f2276v = null;
        this.f2275u = null;
        com.amgcyo.cuttadon.f.o.a((ViewGroup) ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0));
    }

    public void onErrorCode(BaseModel baseModel) {
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
        hideLoading();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 1112) {
            if (iArr != null && iArr.length > 0 && iArr[0] == 0) {
                u();
            } else if (Build.VERSION.SDK_INT >= 26) {
                startActivityForResult(new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + getPackageName())), 1113);
            }
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(@NotNull Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        if (this.f2276v == null) {
            this.f2276v = obtainPresenter();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
        g0.a().b("currentt_run_foreground", true);
    }

    public void onResumeCheckAppUpdate() {
        MkAppVersion version = MkApplication.getAppContext().getVersion();
        if (version != null) {
            b(version);
        } else {
            this.f2266f0 = false;
            getArtAppVersionMethod();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        if (!com.amgcyo.cuttadon.app.o.c.h() || com.amgcyo.cuttadon.utils.otherutils.g.c()) {
            return;
        }
        this.Q = com.amgcyo.cuttadon.app.o.c.a();
        this.R = com.amgcyo.cuttadon.app.o.c.b();
        this.S = System.currentTimeMillis();
        if (this.f2263c0) {
            return;
        }
        this.f2263c0 = true;
        x();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        this.f2264d0.postDelayed(new Runnable() { // from class: com.amgcyo.cuttadon.activity.base.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f2289s.i();
            }
        }, 1000L);
    }

    @Override // com.open.hule.library.b.a
    public void openBroswer() {
        Toast.makeText(this.f2277w, "安装失败，请访问app官网重新下载安装！", 0).show();
        com.amgcyo.cuttadon.view.webview.b.startActivity(this, com.amgcyo.cuttadon.utils.otherutils.h.C0());
    }

    @Override // me.jessyan.art.base.f.h
    @NonNull
    public synchronized me.jessyan.art.d.j.a<String, Object> provideCache() {
        if (this.f2274t == null) {
            this.f2274t = me.jessyan.art.f.e.a(this).a().a(me.jessyan.art.d.j.b.f21178d);
        }
        return this.f2274t;
    }

    public void removeViewImmediate() {
        try {
            if (this.M != null) {
                this.N.removeView(this.M);
                this.M = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setChipioAppNightModel() {
        try {
            this.O = com.amgcyo.cuttadon.utils.otherutils.g.h0();
            this.P = com.amgcyo.cuttadon.utils.otherutils.g.g0();
            int iA = this.P ? c0.a(com.amgcyo.cuttadon.utils.otherutils.g.v()) : Integer.MIN_VALUE;
            if (!this.P && !this.O) {
                removeViewImmediate();
                return;
            }
            if (this.M == null) {
                this.M = new View(this);
                this.M.setBackgroundColor(iA);
                this.N = (ViewGroup) getWindow().getDecorView();
                this.N.addView(this.M, new WindowManager.LayoutParams(-1, -1));
            } else {
                this.M.setBackgroundColor(iA);
                this.M.setBackgroundColor(0);
                this.M.setBackgroundColor(iA);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                getWindow().setNavigationBarColor(iA);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // me.jessyan.art.base.f.h
    public void setPresenter(@Nullable P p2) {
        this.f2276v = p2;
    }

    public void showAppUpdateChioceDialog() {
        showLoading();
        this.f2266f0 = true;
        getArtAppVersionMethod();
    }

    public void showDaoliuDialog(String str) {
        TipsBean tipsBeanE;
        String notify_url;
        if (!com.amgcyo.cuttadon.utils.otherutils.h.G0() || (tipsBeanE = com.amgcyo.cuttadon.utils.otherutils.h.E()) == null || TextUtils.isEmpty(str)) {
            return;
        }
        String tips_content = tipsBeanE.getTips_content();
        String jump_url = tipsBeanE.getJump_url();
        String matchFormat = tipsBeanE.getMatchFormat();
        this.f2270j0 = tipsBeanE.getTips_app();
        if (TextUtils.isEmpty(tips_content) || TextUtils.isEmpty(jump_url) || TextUtils.isEmpty(matchFormat)) {
            return;
        }
        tipsBeanE.setMaxHeight(s());
        String str2 = "tips_app: " + this.f2270j0 + " matchFormat:" + matchFormat;
        int read_tips_switch = 0;
        if ("other_page".equals(str)) {
            read_tips_switch = tipsBeanE.getTips_switch();
        } else if ("read_page".equals(str)) {
            read_tips_switch = tipsBeanE.getRead_tips_switch();
        }
        String str3 = "updateAppUtils:" + read_tips_switch;
        if (this.f2268h0 == null) {
            this.f2268h0 = new com.open.hule.library.c.c(this);
        }
        int i2 = !TextUtils.isEmpty(tipsBeanE.getTips_classname()) ? 1 : 0;
        NotifyBean notifyBeanD = com.amgcyo.cuttadon.utils.otherutils.h.D();
        if (notifyBeanD != null) {
            String str4 = "导流跑马灯对象不为空：" + notifyBeanD.toString();
            notify_url = notifyBeanD.getNotify_url();
        } else {
            notify_url = "";
        }
        this.f2268h0.a(new AppUpdate.Builder().newVersionUrl(jump_url).downBrowserUrl(notify_url).downloadScheme(i2).updateBtnBgResourceId(R.drawable.update_round_bg_new).updateTopImgResourceId(R.drawable.top_3).updateTitle(R.string.qianyitongzhi).tipsBean(tipsBeanE).updateText(R.string.ljxz).forceUpdate(read_tips_switch).build(), this);
    }

    @Override // me.jessyan.art.mvp.e
    public void showEmpty() {
        g();
        this.L.d();
    }

    public void showError(String str) {
        me.jessyan.art.f.g.a(str);
        showMessage(str);
    }

    public void showErrorMsgGravityBottom(String str) {
        com.sdsmdg.tastytoast.a.a(MkApplication.getAppContext(), 80, str, 1, 3);
    }

    public void showLoadFailed() {
        g();
        this.L.e();
    }

    @Override // me.jessyan.art.mvp.e
    public void showLoadSuccess() {
        g();
        hideLoading();
        this.L.f();
    }

    @Override // me.jessyan.art.mvp.e
    public void showLoading(String str) {
        c(true);
    }

    @Override // me.jessyan.art.mvp.e
    public void showLoginDialog(@NonNull String str) {
        com.amgcyo.cuttadon.f.o.a(a(), "提示", str, new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.base.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2293s.b(view);
            }
        }, new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.base.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2292s.c(view);
            }
        });
    }

    @Override // me.jessyan.art.mvp.e
    public void showMessage(@NonNull String str) {
        l.b.a.j.a((CharSequence) str);
    }

    public void showMessageDialog(@NonNull String str) {
        final b1 b1Var = new b1(this);
        b1Var.show();
        b1Var.a(str);
        b1Var.a(new com.amgcyo.cuttadon.g.f() { // from class: com.amgcyo.cuttadon.activity.base.t
            @Override // com.amgcyo.cuttadon.g.f
            public final void a() {
                b1Var.dismiss();
            }
        });
    }

    public void showMsgGravityBottomByType(String str, int i2) {
        com.sdsmdg.tastytoast.a.a(MkApplication.getAppContext(), 80, str, 1, i2);
    }

    @Override // me.jessyan.art.mvp.e
    public void showToasyErrorMessage(@NonNull String str) {
        runOnUiThread(new com.amgcyo.cuttadon.activity.base.d(this));
        c(str);
    }

    public void submitCommentReprot(CommentReprotType commentReprotType) {
        if (commentReprotType == null) {
            c("参数异常，请退出app重试！");
            return;
        }
        String str = commentReprotType.getReport_content() + me.jessyan.art.f.e.a();
        new UserPresenter(me.jessyan.art.f.e.a(this)).K(Message.a(this, new Object[]{Integer.valueOf(commentReprotType.getComment_id()), Integer.valueOf(commentReprotType.getComment_reply_id()), Integer.valueOf(commentReprotType.getReport_id())}));
    }

    @Override // me.jessyan.art.base.f.h
    public boolean useEventBus() {
        return true;
    }

    @Override // me.jessyan.art.base.f.h
    public boolean useFragment() {
        return true;
    }

    public void zhugeIodEvent(String str) {
        x0.c().a(str);
    }

    private void c(final boolean z2) {
        runOnUiThread(new Runnable() { // from class: com.amgcyo.cuttadon.activity.base.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f2287s.a(z2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(String str) {
        return "position_add_book_reward_ad_video".equals(str);
    }

    public static boolean isForeground(Activity activity, String str) {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        if (activity == null || TextUtils.isEmpty(str) || (runningTasks = ((ActivityManager) activity.getSystemService("activity")).getRunningTasks(1)) == null || runningTasks.size() <= 0) {
            return false;
        }
        return str.equals(runningTasks.get(0).topActivity.getClassName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(String str) {
        com.sdsmdg.tastytoast.a.a(MkApplication.getAppContext(), 17, str, 1, 1);
    }

    protected void f() {
        if (g0.a().a("user_agree_pri", false)) {
            com.amgcyo.cuttadon.j.g.b.a(new b(""));
        }
    }

    protected void g() {
        if (this.L == null) {
            if (this.F != null) {
                this.L = com.amgcyo.cuttadon.widget.ui.b.b().a(this.F).a(new Runnable() { // from class: com.amgcyo.cuttadon.activity.base.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f2305s.j();
                    }
                });
            } else {
                this.L = com.amgcyo.cuttadon.widget.ui.b.b().a((ViewGroup) findViewById(android.R.id.content)).a(new Runnable() { // from class: com.amgcyo.cuttadon.activity.base.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f2305s.j();
                    }
                });
            }
        }
    }

    public void showLoading() {
        c(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View... viewArr) {
        for (View view : viewArr) {
            view.setVisibility(0);
        }
    }

    public /* synthetic */ void c(View view) {
        finishReadActivity();
    }

    protected ViewGroup e() {
        return (ViewGroup) ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(String str) {
        com.sdsmdg.tastytoast.a.a(MkApplication.getAppContext(), 17, str, 1, 3);
    }

    public /* synthetic */ void b(View view) {
        r0.b(this);
    }

    protected void c() {
        try {
            getWindow().clearFlags(128);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(Bundle bundle) {
        this.F = (FrameLayout) this.f2278x.findViewById(R.id.fl_content);
        View viewInflate = View.inflate(this, initView(bundle), null);
        if (viewInflate != null) {
            this.F.addView(viewInflate, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public /* synthetic */ void b(int i2) {
        if (i2 != 6) {
            showMessage("请尽快更新最新版本!");
        } else {
            showMessage("正在处理中，请稍后!");
        }
    }

    private void c(MkAppVersion mkAppVersion) {
        if (mkAppVersion.getVersion() > 502) {
            if (!com.amgcyo.cuttadon.utils.otherutils.h.G0()) {
                checkUpdate(mkAppVersion);
            }
        } else if (this.f2266f0) {
            A();
        }
        this.f2266f0 = false;
    }

    private void b(String str, int i2) {
        if (i2 == 2) {
            this.Y = com.amgcyo.cuttadon.utils.otherutils.h.a(str, "f");
            if ("csj_new".equals(str)) {
                this.Y = com.amgcyo.cuttadon.utils.otherutils.h.a(str, "m");
            }
        } else if (i2 == 4) {
            this.Y = com.amgcyo.cuttadon.utils.otherutils.h.a(str, "t");
        }
        SdkFullVideoActivity.launch(this, str, this.Y, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View... viewArr) {
        for (View view : viewArr) {
            view.setVisibility(8);
        }
    }

    public /* synthetic */ void a(boolean z2) {
        try {
            if (this.J == null) {
                d1.b bVar = new d1.b(this);
                bVar.b(z2);
                bVar.a(false);
                this.J = bVar.a();
                this.J.show();
            } else {
                this.I.removeCallbacks(this.H);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void c(Uri uri) {
        OutputStream outputStreamOpenOutputStream;
        this.f2272l0 = "";
        try {
            try {
                outputStreamOpenOutputStream = getContentResolver().openOutputStream(uri);
            } catch (Exception e2) {
                this.f2271k0 = false;
                String str = "写入数据失败：" + e2.toString();
                a(" writeFileText catch ", e2);
            }
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStreamOpenOutputStream));
                try {
                    String strY = com.amgcyo.cuttadon.utils.otherutils.g.y();
                    if (TextUtils.isEmpty(strY)) {
                        this.f2271k0 = false;
                        b(" writeFileText jsonData is null.");
                    } else {
                        this.f2271k0 = true;
                        try {
                            this.f2272l0 = z.b(this, uri);
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        bufferedWriter.write(strY);
                        bufferedWriter.flush();
                        bufferedWriter.close();
                        g0 g0VarA = g0.a();
                        g0VarA.b("back_up_count", g0VarA.a("back_up_count", 1) + 1);
                    }
                    bufferedWriter.close();
                    if (outputStreamOpenOutputStream != null) {
                        outputStreamOpenOutputStream.close();
                    }
                } finally {
                }
            } catch (Throwable th) {
                if (outputStreamOpenOutputStream != null) {
                    try {
                        outputStreamOpenOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } finally {
            a(uri);
        }
    }

    protected void b() {
        try {
            getWindow().addFlags(128);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void b(File file) {
        this.f2265e0 = file;
        com.amgcyo.cuttadon.f.o.a(a(), "去开启", "取消", "提示", "已下载，\n安装应用需要打开“允许安装未知来源权限”，请去设置中开启权限", new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.base.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2294s.a(view);
            }
        }, new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.base.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseTitleBarActivity.d(view);
            }
        });
    }

    protected void b(boolean z2) {
        if (z2) {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.flags |= 1024;
            getWindow().setAttributes(attributes);
        } else {
            WindowManager.LayoutParams attributes2 = getWindow().getAttributes();
            attributes2.flags &= -1025;
            getWindow().setAttributes(attributes2);
        }
    }

    public /* synthetic */ void a(int i2, UpdateResponse updateResponse) {
        BmobException exception = updateResponse.getException();
        hideLoading();
        if (exception == null) {
            String str = "检测更新返回：" + updateResponse.version + "-" + updateResponse.path;
            return;
        }
        if (this.f2266f0) {
            com.amgcyo.cuttadon.f.o.a((Context) this);
        }
    }

    private void b(final MkAppVersion mkAppVersion) {
        ArrayList<Integer> version_data = mkAppVersion.getVersion_data();
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) version_data) && com.amgcyo.cuttadon.utils.otherutils.g.a(version_data)) {
            b1 b1Var = new b1(a());
            b1Var.a(new com.amgcyo.cuttadon.g.f() { // from class: com.amgcyo.cuttadon.activity.base.c
                @Override // com.amgcyo.cuttadon.g.f
                public final void a() {
                    this.a.a(mkAppVersion);
                }
            });
            b1Var.show();
            b1Var.a(String.format(com.amgcyo.cuttadon.f.o.d(R.string.string_enable), "5.0.2", com.amgcyo.cuttadon.utils.otherutils.h.C0()));
            return;
        }
        c(mkAppVersion);
    }

    protected View a(String str, int i2) {
        View viewInflate;
        Context context = this.f2277w;
        if (context == null || (viewInflate = ((Activity) context).getLayoutInflater().inflate(R.layout.layout_empty_list, (ViewGroup) null)) == null) {
            return null;
        }
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.empty_iv);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_empty_msg);
        if (TextUtils.isEmpty(str)) {
            str = "暂无数据";
        }
        if (i2 == 0) {
            i2 = R.mipmap.icon_withdraw_empty;
        }
        textView.setText(str);
        imageView.setImageResource(i2);
        return viewInflate;
    }

    private void b(Uri uri) {
        try {
            InputStream inputStreamOpenInputStream = getContentResolver().openInputStream(uri);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpenInputStream));
            StringBuilder sb = new StringBuilder();
            while (true) {
                int i2 = bufferedReader.read();
                if (i2 == -1) {
                    break;
                } else {
                    sb.append((char) i2);
                }
            }
            bufferedReader.close();
            if (inputStreamOpenInputStream != null) {
                inputStreamOpenInputStream.close();
            }
            String string = sb.toString();
            if (TextUtils.isEmpty(string)) {
                return;
            }
            String strA = me.jessyan.art.b.c.a().a(string);
            if (TextUtils.isEmpty(strA)) {
                showMsgGravityBottomByType("备份文件读取失败，请反馈给客服！", 3);
                b(" readFileText decrypt is null.");
                return;
            }
            DaoliuData daoliuData = (DaoliuData) com.amgcyo.cuttadon.utils.otherutils.r.a(strA, DaoliuData.class);
            if (daoliuData == null) {
                showMsgGravityBottomByType("备份文件解析失败，请反馈给客服！", 3);
                b(" readFileText json convert object is null.");
            } else {
                a(daoliuData, false);
            }
        } catch (Exception e2) {
            String str = "读取数据失败：" + e2.toString();
            showMsgGravityBottomByType("备份文件读取失败，请检查所选文件是否是你刚才备份的文件！", 3);
            e2.printStackTrace();
            a(" readFileText catch ", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i2) {
        Window window = getWindow();
        if (window == null) {
            return;
        }
        boolean zIsInMultiWindowMode = Build.VERSION.SDK_INT >= 24 ? isInMultiWindowMode() : false;
        View decorView = window.getDecorView();
        decorView.setSystemUiVisibility(0);
        if (zIsInMultiWindowMode) {
            decorView.setSystemUiVisibility(256);
            return;
        }
        if (i2 == 0) {
            decorView.setSystemUiVisibility(5894);
        } else if (i2 == 1) {
            decorView.setSystemUiVisibility(5888);
        } else {
            decorView.setSystemUiVisibility(5892);
        }
        me.jessyan.art.f.h.a((Activity) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, BaseAd baseAd) {
        String strA;
        String platform = baseAd.getPlatform();
        if ("position_wake_up_reward_ad_video".equals(str)) {
            strA = com.amgcyo.cuttadon.utils.otherutils.h.a(platform, "r");
        } else {
            strA = com.amgcyo.cuttadon.utils.otherutils.h.a(platform, "u");
        }
        String str2 = strA;
        this.Z = new ArrayList();
        List<BaseAd> listJ = com.amgcyo.cuttadon.utils.otherutils.h.J();
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(listJ)) {
            String str3 = "45分钟解锁广告位———错误后广告轮询列表大小：" + listJ.size();
            this.Z.addAll(listJ);
        }
        com.amgcyo.cuttadon.h.g.i.a().a(this.f2277w, new RewardAdParam(platform, str, str2, baseAd.getStyle(), baseAd.isNoExempt()), this.f2262b0);
    }

    protected void b(String str) {
        CrashReport.postCatchedException(new DrainThrowable(str));
    }

    public /* synthetic */ void a(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            z();
        }
    }

    private void a(File file) {
        Intent intent = new Intent("android.intent.action.VIEW");
        if (Build.VERSION.SDK_INT >= 24) {
            intent.setDataAndType(FileProvider.getUriForFile(this, com.amgcyo.cuttadon.utils.otherutils.h.t() + ".MkTsFileProvider", file), AdBaseConstants.MIME_APK);
            intent.addFlags(1);
        } else {
            intent.setDataAndType(Uri.parse("file://" + file.toString()), AdBaseConstants.MIME_APK);
        }
        intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        startActivity(intent);
    }

    protected void a(Disposable... disposableArr) {
        for (int i2 = 0; disposableArr != null && i2 < disposableArr.length; i2++) {
            if (disposableArr[i2] != null && !disposableArr[i2].isDisposed()) {
                disposableArr[i2].dispose();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        MkAppConfig appConfig = MkApplication.getAppContext().getAppConfig();
        if (appConfig != null) {
            appConfig.isIs_cache();
        }
        if (appConfig != null && !appConfig.isIs_cache()) {
            String str2 = "配置文件来自网络请求，请求时间是：" + appConfig.getSave_time();
        } else {
            new ConfigPresenter(me.jessyan.art.f.e.a(this)).b(Message.a(this, new Object[]{true}));
        }
        onResumeCheckAppUpdate();
        showDaoliuDialog(str);
    }

    public /* synthetic */ void a(MkAppVersion mkAppVersion) {
        String download_url = mkAppVersion.getDownload_url();
        if (TextUtils.isEmpty(download_url)) {
            download_url = com.amgcyo.cuttadon.utils.otherutils.h.C0();
        }
        com.amgcyo.cuttadon.view.webview.b.startActivity(this.f2277w, download_url);
    }

    protected void a(DaoliuData daoliuData, boolean z2) {
        DaoliuUser daoliuUserA = com.amgcyo.cuttadon.utils.otherutils.p.a(daoliuData);
        if (daoliuUserA == null) {
            if (com.amgcyo.cuttadon.utils.otherutils.p.a(daoliuData, this)) {
                me.jessyan.art.d.f.a().a(new MkCommentEvent(), "tag_daoliu_view");
                return;
            }
            return;
        }
        String channel = daoliuData.getChannel();
        String package_name = daoliuData.getPackage_name();
        String str = "old_channel：" + channel + " " + com.amgcyo.cuttadon.utils.otherutils.g.T();
        String str2 = "old_package_name：" + package_name + " com.fatcatfat.io";
        long user_id = daoliuUserA.getUser_id();
        String strValueOf = String.valueOf(user_id);
        System.out.println("fromSAF userId:" + strValueOf);
        if (z2) {
            strValueOf = String.valueOf(9827991128661L - user_id);
            System.out.println("fromClipboard userId:" + strValueOf);
        }
        new UserPresenter(me.jessyan.art.f.e.a(this)).p(Message.a(this, new Object[]{strValueOf, daoliuUserA.getToken(), package_name, channel, daoliuData}));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Uri uri) {
        Intent intent = new Intent(this.f2277w, (Class<?>) ArtGuiderDaoliuActivity.class);
        intent.putExtra("theme_path", this.f2272l0);
        intent.putExtra("title", this.f2270j0);
        intent.putExtra("SafBean", this.f2271k0);
        com.amgcyo.cuttadon.f.s.a.c((FragmentActivity) this).startActivityForResult(intent, new a.InterfaceC0088a() { // from class: com.amgcyo.cuttadon.activity.base.m
            @Override // com.amgcyo.cuttadon.f.s.a.InterfaceC0088a
            public final void a(int i2, Intent intent2) {
                this.a.a(uri, i2, intent2);
            }
        });
    }

    public /* synthetic */ void a(Uri uri, int i2, Intent intent) {
        if (i2 == 836) {
            com.amgcyo.cuttadon.utils.otherutils.j.a(this);
            if (!this.f2271k0) {
                DaoliuData daoliuData = new DaoliuData();
                MkUser mkUserJ = com.amgcyo.cuttadon.utils.otherutils.g.j();
                if (mkUserJ != null) {
                    DaoliuUser daoliuUser = new DaoliuUser();
                    daoliuUser.setUser_id(9827991128661L - ((long) mkUserJ.getUser_id()));
                    daoliuUser.setToken(mkUserJ.getToken());
                    String strA = com.amgcyo.cuttadon.utils.otherutils.r.a(daoliuUser);
                    if (!TextUtils.isEmpty(strA)) {
                        daoliuData.setPackage_name("com.fatcatfat.io");
                        daoliuData.setChannel(com.amgcyo.cuttadon.utils.otherutils.g.T());
                        daoliuData.setJson_user(strA);
                    }
                } else {
                    List<MkBook> listC = AppDatabase.i().a().c();
                    if (!com.amgcyo.cuttadon.utils.otherutils.g.a(listC)) {
                        ArrayList arrayList = new ArrayList();
                        for (MkBook mkBook : listC) {
                            arrayList.add(new DaoliuBook(mkBook.getBook_id(), mkBook.getForm(), mkBook.getReading_site_id(), mkBook.getReading_chapter_key(), mkBook.getRead_begin(), mkBook.getLast_read_chapterName(), mkBook.getReading_datetime()));
                        }
                        if (!com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) arrayList)) {
                            String strA2 = com.amgcyo.cuttadon.utils.otherutils.r.a(arrayList);
                            if (!TextUtils.isEmpty(strA2)) {
                                daoliuData.setJson_book(strA2);
                            }
                        }
                    }
                }
                String strA3 = com.amgcyo.cuttadon.utils.otherutils.r.a(daoliuData);
                if (!TextUtils.isEmpty(strA3)) {
                    String str = "开始复制数据" + strA3;
                    com.amgcyo.cuttadon.utils.otherutils.j.a(this, strA3);
                }
            } else if (uri != null) {
                com.amgcyo.cuttadon.utils.otherutils.j.a(a(), uri.toString());
            }
            p();
        }
    }

    protected void a(String str, Exception exc) {
        CrashReport.postCatchedException(new Exception(str, exc));
    }
}
