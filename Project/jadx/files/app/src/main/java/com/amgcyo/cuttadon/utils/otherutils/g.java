package com.amgcyo.cuttadon.utils.otherutils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.annotation.ColorRes;
import androidx.annotation.StringRes;
import androidx.core.content.FileProvider;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.amgcyo.cuttadon.api.entity.adbean.NormalAdParams;
import com.amgcyo.cuttadon.api.entity.comic.Base64Bean;
import com.amgcyo.cuttadon.api.entity.config.BaseAd;
import com.amgcyo.cuttadon.api.entity.config.MkAppConfig;
import com.amgcyo.cuttadon.api.entity.config.PushDataBean;
import com.amgcyo.cuttadon.api.entity.migrate.DaoliuData;
import com.amgcyo.cuttadon.api.entity.other.LocalReadHistoryBean;
import com.amgcyo.cuttadon.api.entity.other.MkAdBean;
import com.amgcyo.cuttadon.api.entity.other.MkAreaCodeBean;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.entity.other.MkCatalog;
import com.amgcyo.cuttadon.api.entity.other.MkUser;
import com.amgcyo.cuttadon.api.entity.other.Slippage;
import com.amgcyo.cuttadon.app.MkApplication;
import com.amgcyo.cuttadon.database.AppDatabase;
import com.amgcyo.cuttadon.database.ReadHistoryDatabase;
import com.amgcyo.cuttadon.utils.event.MkCommentEvent;
import com.amgcyo.cuttadon.utils.otherutils.ScannerUtils;
import com.arialyy.aria.core.ProtocolType;
import com.baidu.mobads.sdk.api.ArticleInfo;
import com.bytedance.msdk.api.AdError;
import com.fatcatfat.io.R;
import com.google.gson.GsonBuilder;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.taobao.accs.common.Constants;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ArtAppUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class g {
    public static final String[] a = {" 男生热搜榜 ", " 女生热搜榜 "};
    public static final String[] b = {" 评论通知 ", " 系统通知 "};

    /* JADX INFO: compiled from: ArtAppUtils.java */
    class a implements X509TrustManager {
        a() {
        }

        @Override // javax.net.ssl.X509TrustManager
        @SuppressLint({"TrustAllX509TrustManager"})
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        @SuppressLint({"TrustAllX509TrustManager"})
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    /* JADX INFO: compiled from: ArtAppUtils.java */
    class b implements com.hjq.permissions.a {
        final /* synthetic */ boolean[] a;
        final /* synthetic */ Context b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f4394c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Bitmap f4395d;

        b(boolean[] zArr, Context context, String str, Bitmap bitmap) {
            this.a = zArr;
            this.b = context;
            this.f4394c = str;
            this.f4395d = bitmap;
        }

        @Override // com.hjq.permissions.a
        public void a(List<String> list, boolean z2) {
            this.a[0] = false;
            com.amgcyo.cuttadon.f.o.b("二维码保存到相册失败，请授予存储权限后重试！");
        }

        @Override // com.hjq.permissions.a
        public void b(List<String> list, boolean z2) {
            this.a[0] = ScannerUtils.a(this.b, this.f4394c, this.f4395d, ScannerUtils.ScannerType.RECEIVER);
            if (this.a[0]) {
                com.amgcyo.cuttadon.f.o.b("已成功保存图片到相册");
            }
        }
    }

    public static long A() {
        return J().longValue() / 60;
    }

    public static String B() {
        return t0.e(System.currentTimeMillis()) + "_";
    }

    public static String C() {
        String strE0 = e0();
        String strA = g0.a().a("privacy_url", strE0);
        String str = "default_privatcyUrl：" + strE0;
        String str2 = "real_privatcy：" + strA;
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str3 = "?t=" + jCurrentTimeMillis;
        if (!TextUtils.isEmpty(strA) && strA.contains(DispatchConstants.APP_NAME)) {
            str3 = "&t=" + jCurrentTimeMillis;
        }
        return strA + str3;
    }

    public static String D(String str) throws NoSuchAlgorithmException {
        byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(str.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArrDigest) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString().substring(6, 26);
    }

    public static String E() {
        return d(Constants.SEND_TYPE_RES);
    }

    public static String F() {
        String strA = g0.a().a("reset_domain", "chuangke.tv");
        return !TextUtils.isEmpty(strA) ? strA : "chuangke.tv";
    }

    public static String G() {
        return g0.a().a("communicate", "正常用户或设备,结果仅供参考。");
    }

    public static SSLSocketFactory H() {
        try {
            SSLContext sSLContext = SSLContext.getInstance(ProtocolType.SSL);
            sSLContext.init(null, S(), new SecureRandom());
            return sSLContext.getSocketFactory();
        } catch (KeyManagementException | NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String I() {
        return "v" + g0.a().a("roundtables", 4);
    }

    public static Long J() {
        return com.amgcyo.cuttadon.utils.comic.d.a("Participate", 0L);
    }

    public static int K() {
        return g0.a().a("ShelfModel", 1);
    }

    public static String L() {
        return g0.a().a("shelf_sort_key", "sort_by_last_read_time");
    }

    public static int M() {
        try {
            return Settings.System.getInt(MkApplication.getAppContext().getContentResolver(), "screen_off_timeout");
        } catch (Settings.SettingNotFoundException e2) {
            e2.printStackTrace();
            return 120000;
        }
    }

    private static g0 N() {
        return g0.a();
    }

    public static int O() {
        return g0.a().a("fatten_chapter_num", 50);
    }

    public static int P() {
        return g0.a().a("TTS_RATE", 10);
    }

    public static float Q() {
        double dA = g0.a().a("TTS_RATE", 10);
        Double.isNaN(dA);
        return (float) (dA / 10.0d);
    }

    public static int R() {
        return g0.a().a(B() + "contr_delivery_active", 0);
    }

    public static TrustManager[] S() {
        return new TrustManager[]{new a()};
    }

    public static String T() {
        return e(MkApplication.getAppContext());
    }

    public static String U() {
        return g0.a().a("um_key", "5ef59e530cafb20267000026");
    }

    public static String V() {
        return g0.a().a("um_master_secret", "ec523cccdfcb4f6a64f9c85b148a6e84");
    }

    public static int W() {
        return com.amgcyo.cuttadon.a.b.intValue();
    }

    public static boolean X() {
        return g0.a().a("value_unlock_preload", false);
    }

    public static OkHttpClient Y() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        SSLSocketFactory sSLSocketFactoryH = H();
        if (sSLSocketFactoryH != null) {
            builder.sslSocketFactory(sSLSocketFactoryH, (X509TrustManager) S()[0]);
        }
        builder.hostnameVerifier(new HostnameVerifier() { // from class: com.amgcyo.cuttadon.utils.otherutils.a
            @Override // javax.net.ssl.HostnameVerifier
            public final boolean verify(String str, SSLSession sSLSession) {
                return g.a(str, sSLSession);
            }
        });
        builder.hostnameVerifier(new HostnameVerifier() { // from class: com.amgcyo.cuttadon.utils.otherutils.b
            @Override // javax.net.ssl.HostnameVerifier
            public final boolean verify(String str, SSLSession sSLSession) {
                return g.b(str, sSLSession);
            }
        });
        return builder.build();
    }

    public static String[] Z() {
        String strD = g0.a().d("Z8716HRlaBgT");
        if (!TextUtils.isEmpty(strD)) {
            String[] strArrSplit = strD.split(",");
            if (strArrSplit.length > 0) {
                for (String str : strArrSplit) {
                }
                return strArrSplit;
            }
        }
        return com.amgcyo.cuttadon.a.f2255f;
    }

    public static void a(Throwable th) {
    }

    public static void a(Throwable th, String str) {
    }

    public static boolean a() {
        String strN = h.n();
        String strP = h.p();
        String strQ = h.q();
        String strR = h.r();
        String str = "bdId：" + strN;
        String str2 = "bdk：" + strP;
        String str3 = "bds：" + strQ;
        String str4 = "bdsn：" + strR;
        return (TextUtils.isEmpty(strN) || TextUtils.isEmpty(strP) || TextUtils.isEmpty(strQ) || TextUtils.isEmpty(strR)) ? false : true;
    }

    static /* synthetic */ boolean a(String str, SSLSession sSLSession) {
        return true;
    }

    public static String a0() {
        return g0.a().a("techno_introduce", "");
    }

    static /* synthetic */ boolean b(String str, SSLSession sSLSession) {
        return true;
    }

    public static boolean b(List<?> list) {
        return !a(list);
    }

    public static String b0() {
        String str = h.C0() + "service/member.html?appName=";
        if (!str.contains(DispatchConstants.APP_NAME)) {
            return str;
        }
        try {
            return str + URLEncoder.encode(g(R.string.app_name), "UTF-8");
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static void c(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(BaseConstants.MARKET_PREFIX + str));
            intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            context.startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
            com.amgcyo.cuttadon.f.o.b("打开应用市场失败，请手动打开！");
        }
    }

    public static String c0() {
        return g0.a().a("learning_logy", "");
    }

    @NotNull
    private static String d(String str) {
        HttpUrl httpUrlA = me.jessyan.retrofiturlmanager.a.f().a(str);
        return httpUrlA != null ? httpUrlA.getUrl() : "";
    }

    public static boolean d0() {
        return !TextUtils.isEmpty(g(MkApplication.getAppContext()));
    }

    public static String e(int i2) {
        Integer.valueOf(i2);
        return o();
    }

    public static String e0() {
        String str = h.C0() + "service/privacy.html?appName=";
        if (!str.contains(DispatchConstants.APP_NAME)) {
            return str;
        }
        try {
            return str + URLEncoder.encode(g(R.string.app_name), "UTF-8");
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static float f(int i2) {
        return g0.a().a(String.valueOf(i2), 0.0f);
    }

    public static boolean f0() {
        return Build.VERSION.SDK_INT >= 28;
    }

    public static String g(String str) {
        String str2 = d(Constants.SEND_TYPE_RES) + "tt/" + str + ".jpg";
        String str3 = "soUrl:" + str2;
        return str2;
    }

    public static boolean g0() {
        return g0.a().a("eye_protected_model", false);
    }

    public static int h() {
        return g0.a().a(ArticleInfo.USER_SEX, -1);
    }

    public static boolean h(int i2) {
        return 3 == i2;
    }

    public static boolean h0() {
        return g0.a().a("daynight_model", false);
    }

    public static void i(Context context) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(BaseConstants.MARKET_PREFIX + context.getPackageName()));
            intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            context.startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean i(int i2) {
        return i2 > 0 && i2 < 400;
    }

    public static boolean i0() {
        return N().a("is_old_ad_model_comics", false);
    }

    public static MkUser j() {
        try {
            return AppDatabase.i().d().a();
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean j0() {
        return g0.a().a("comics_status", false);
    }

    public static String k() {
        return "https://conf.chuangke.tv/";
    }

    public static void k(int i2) {
        g0.a().b("attributes", i2);
    }

    private static boolean k0() {
        return g0.a().a("is_current_process");
    }

    public static boolean l(String str) {
        return "index".equals(str);
    }

    public static boolean l0() {
        return com.amgcyo.cuttadon.sdk.utils.g.a("comics_barrage_switch", 0) == 1;
    }

    public static boolean m(String str) {
        return "index".equals(str) || "comics".equals(str);
    }

    public static boolean m0() {
        try {
            g0 g0VarA = g0.a();
            long jA = g0VarA.a("electrostatic", 0L);
            boolean zA = g0VarA.a("eyeglass", false);
            long jCurrentTimeMillis = System.currentTimeMillis();
            String str = "邀请好友免广告\n当前时间：" + t0.d(jCurrentTimeMillis) + "\n过期时间：" + t0.d(jA);
            long j2 = jA - jCurrentTimeMillis;
            StringBuilder sb = new StringBuilder();
            sb.append("免除广告：fission6_ad_end_time: ");
            sb.append(jA);
            sb.append(" verifyValues: ");
            sb.append(zA);
            sb.append(" result_time: ");
            sb.append(j2);
            sb.append(" result: ");
            sb.append(j2 > 1 && zA);
            sb.toString();
            return j2 > 1 && zA;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String n() {
        return d("comic_chapter");
    }

    public static boolean n0() {
        return N().a("is_old_ad_model_novel", false);
    }

    private static String o() {
        return d("comic_cover_res");
    }

    public static boolean o0() {
        String strT = T();
        return !TextUtils.isEmpty(strT) && strT.startsWith(AgooConstants.MESSAGE_SYSTEM_SOURCE_XIAOMI);
    }

    public static void p(int i2) {
        g0.a().b("TypeFinish" + i2, true);
    }

    public static boolean p0() {
        int iG = com.amgcyo.cuttadon.app.o.c.g();
        int iE0 = h.e0();
        boolean z2 = iG >= iE0;
        String str = "startCount:" + iG + " pay_tips_count: " + iE0 + " 是否需要强制申请权限：" + z2;
        if (z2) {
            h.i("");
        }
        return z2;
    }

    public static boolean q(String str) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (!Character.isDigit(str.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    public static boolean q0() {
        return me.jessyan.art.f.f.a(MkApplication.getAppContext()) && me.jessyan.art.f.f.b(MkApplication.getAppContext());
    }

    public static String r(int i2) {
        return String.valueOf(i2 + AdError.AD_NO_FILL);
    }

    public static void r0() {
        com.amgcyo.cuttadon.h.a.c.a("minefragment_time", 0L);
        com.amgcyo.cuttadon.h.a.c.a("bookshelf_time1", 0L);
        com.amgcyo.cuttadon.h.a.c.a("bookshelf_time3", 0L);
    }

    public static boolean s(String str) {
        return str.contains("/default/avatar.png");
    }

    public static void s0() {
        g0.a().b(B() + "contr_delivery_active", R() + 1);
    }

    public static boolean t(String str) {
        try {
            Runtime runtime = Runtime.getRuntime();
            StringBuilder sb = new StringBuilder();
            sb.append("ping -c 1 -w 100 ");
            sb.append(str);
            return runtime.exec(sb.toString()).waitFor() == 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void t0() {
        f.b(MkApplication.getAppContext(), "eliiminate", w());
    }

    public static MkAreaCodeBean u() {
        return new MkAreaCodeBean("^[1]([3-9][0-9])[0-9]{8}$", "cn", "中国", "86", 11);
    }

    public static boolean u0() {
        return !L().equals("sort_by_last_read_time");
    }

    public static String v(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return str.replaceAll("\\s", "");
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String w() {
        String strA = com.github.gzuliyujiang.oaid.b.a();
        if (!TextUtils.isEmpty(strA)) {
            return strA;
        }
        return String.valueOf(W()) + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) + (Build.DISPLAY.length() % 10) + (Build.HOST.length() % 10) + (Build.ID.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10) + (Build.TAGS.length() % 10) + (Build.TYPE.length() % 10) + (Build.USER.length() % 10);
    }

    public static int x() {
        return g0.a().a("from_unlock_comic", 0);
    }

    public static void y(String str) {
        g0.a().b("xf-appid", str);
    }

    public static int z() {
        MkUser mkUserJ = j();
        if (mkUserJ != null) {
            return mkUserJ.getUser_id();
        }
        return -1;
    }

    private static void A(String str) {
        g0.a().b("learning_logy", str);
    }

    private static void B(String str) {
        f.b(MkApplication.getAppContext(), "accelerate", str);
    }

    public static String b(String str) {
        HttpUrl httpUrlA = me.jessyan.retrofiturlmanager.a.f().a("avatar");
        if (httpUrlA == null) {
            return "";
        }
        return httpUrlA.getUrl() + str;
    }

    public static String f(Context context) {
        return DeviceConfig.getDeviceIdForGeneral(context);
    }

    public static void h(boolean z2) {
        g0.a().b("csj_request_permission", z2);
    }

    private static String j(Context context) {
        if (context == null) {
            return "null";
        }
        String strD = g0.a().d("lanren_info");
        if (TextUtils.isEmpty(strD)) {
            return "null";
        }
        List<String> listB = r.b(strD, String.class);
        if (a((List<?>) listB)) {
            return "null";
        }
        for (String str : listB) {
            if (b(context, str)) {
                String str2 = "已经安装：" + str;
                return str;
            }
        }
        return "null";
    }

    private static boolean k(String str) {
        return Pattern.compile("[一-龥]").matcher(str).find();
    }

    public static int l() {
        return com.amgcyo.cuttadon.a.f2253d.intValue();
    }

    public static void m(int i2) {
        g0.a().b(ArticleInfo.USER_SEX, i2);
    }

    public static boolean n(String str) {
        return h(str) || i(str);
    }

    public static void o(int i2) {
        g0.a().b("eye_protected_model_values", i2);
    }

    public static boolean r() {
        return g0.a().a("csj_request_permission", false);
    }

    public static Animation s(int i2) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 10.0f, 0.0f, 0.0f);
        translateAnimation.setInterpolator(new CycleInterpolator(i2));
        translateAnimation.setDuration(1000L);
        return translateAnimation;
    }

    public static String u(String str) {
        return !TextUtils.isEmpty(str) ? str.replaceAll("0", "") : str;
    }

    public static void x(String str) {
        g0.a().b("communicate", str);
    }

    public static String y() {
        String strS = s();
        String strT = t();
        DaoliuData daoliuData = new DaoliuData();
        if (!TextUtils.isEmpty(strS)) {
            daoliuData.setJson_book(strS);
        }
        if (TextUtils.isEmpty(strT)) {
            List<LocalReadHistoryBean> listB = ReadHistoryDatabase.b().a().b();
            String strA = !a(listB) ? r.a(listB) : "";
            if (!TextUtils.isEmpty(strA)) {
                daoliuData.setJson_history(strA);
            }
        } else {
            daoliuData.setJson_user(strT);
        }
        daoliuData.setPackage_name("com.fatcatfat.io");
        daoliuData.setChannel(T());
        String strA2 = r.a(daoliuData);
        return !TextUtils.isEmpty(strA2) ? me.jessyan.art.b.c.a().a(strA2.getBytes()) : "";
    }

    public static int d(int i2) {
        return (int) Math.floor(i2 / 1000);
    }

    public static void e(boolean z2) {
        g0.a().b("daynight_model", z2);
    }

    public static int f() {
        return g0.a().a("attributes", 1);
    }

    public static String g(@StringRes int i2) {
        return MkApplication.getAppContext().getResources().getString(i2);
    }

    private static boolean h(String str) {
        return str.matches(".*[0-9].*");
    }

    public static boolean l(Context context) {
        if (com.amgcyo.cuttadon.j.f.b.e() && com.amgcyo.cuttadon.j.f.e.c(context)) {
            return true;
        }
        if ((com.amgcyo.cuttadon.j.f.b.d() && com.amgcyo.cuttadon.j.f.a.b(context)) || com.amgcyo.cuttadon.j.f.c.a(context)) {
            return true;
        }
        return com.amgcyo.cuttadon.j.f.d.c(context);
    }

    public static String m() {
        return g0.a().a("bug_key", "047605967d");
    }

    public static void n(int i2) {
        g0.a().b(B() + "ad_track_error1Count", i2);
    }

    public static boolean o(String str) {
        return k(str) || h(str) || i(str);
    }

    public static boolean p() {
        return f.a((Context) MkApplication.getAppContext(), "db_on_corruption", false);
    }

    public static void q(int i2) {
        g0.a().b("TTS_RATE", i2);
    }

    public static boolean r(String str) {
        if (str == null || str.length() <= 0 || TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.matches("(https?://(w{3}\\.)?)?\\w+\\.\\w+(\\.[a-zA-Z]+)*(:\\d{1,5})?(/\\w*)*(\\??(.+=.*)?(&.+=.*)?)?", str);
    }

    public static int t(int i2) {
        int iB = AppDatabase.i().d().b();
        if (iB > 0) {
            h.k("");
            a("", "");
            k(1);
            com.amgcyo.cuttadon.i.n.a(i2);
            me.jessyan.art.d.f.a().a(new MkCommentEvent(), "login_out");
            h.u(1);
            d.a(MkApplication.getAppContext()).a("encrey_gold_number", "");
            g0 g0VarA = g0.a();
            g0VarA.b("tel", "");
            g0VarA.b("need_load_history_novel_data", false);
            g0VarA.b("need_load_history_comics_data", false);
            b();
        }
        return iB;
    }

    private static void z(String str) {
        g0.a().b("techno_introduce", str);
    }

    public static List<MkBook> b(int i2) {
        com.amgcyo.cuttadon.database.f fVarA = AppDatabase.i().a();
        return u0() ? fVarA.h(i2) : fVarA.l(i2);
    }

    public static void d(Activity activity) {
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                activity.getWindow().setAttributes(attributes);
                activity.getWindow().getDecorView().setSystemUiVisibility(activity.getWindow().getDecorView().getSystemUiVisibility() | DownloadErrorCode.ERROR_SAVE_PATH_CREATE_FAILED);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void e(Activity activity) {
        Intent intent = new Intent();
        intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        try {
            intent.setAction("com.android.settings.TTS_SETTINGS");
            activity.startActivity(intent);
        } catch (Exception unused) {
            try {
                try {
                    intent.setAction("android.settings.ACCESSIBILITY_SETTINGS");
                    activity.startActivity(intent);
                    com.amgcyo.cuttadon.f.o.f(R.string.select_tts);
                } catch (Exception unused2) {
                    intent.setAction("android.settings.INPUT_METHOD_SETTINGS");
                    activity.startActivity(intent);
                    com.amgcyo.cuttadon.f.o.f(R.string.select_tts);
                }
            } catch (Exception unused3) {
                com.amgcyo.cuttadon.f.o.f(R.string.not_support_tts);
            }
        }
    }

    public static void f(boolean z2) {
        g0.a().b("bugly_init", z2);
    }

    public static void g(boolean z2) {
        String str = "setComicsOldAdModelByUser:" + z2;
        N().b("is_old_ad_model_comics", z2);
    }

    public static String h(Context context) {
        return f.a(context, "eliiminate", "");
    }

    public static boolean p(String str) {
        return (TextUtils.isEmpty(str) || "0".equals(str)) ? false : true;
    }

    public static String q() {
        try {
            MkApplication appContext = MkApplication.getAppContext();
            byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 64).signatures[0].toByteArray());
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArrDigest) {
                String upperCase = Integer.toHexString(b2 & 255).toUpperCase(Locale.US);
                if (upperCase.length() == 1) {
                    sb.append("0");
                }
                sb.append(upperCase);
                sb.append(":");
            }
            String string = sb.toString();
            return string.substring(0, string.length() - 1);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static int v() {
        return g0.a().a("eye_protected_model_values", 40);
    }

    public static List<String> f(String str) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = Pattern.compile("((2[0-4]\\d|25[0-5]|[01]?\\d\\d?)\\.){3}(2[0-4]\\d|25[0-5]|[01]?\\d\\d?)").matcher(str);
        while (matcher.find()) {
            arrayList.add(matcher.group());
        }
        return arrayList;
    }

    private static String k(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return "TM==null";
        }
        switch (telephonyManager.getNetworkType()) {
            case 0:
                return "UNKNOWN";
            case 1:
            case 2:
                return "2G";
            case 3:
                return "3G";
            case 4:
                return "2G";
            case 5:
            case 6:
                return "3G";
            case 7:
                return "2G";
            case 8:
            case 9:
            case 10:
                return "3G";
            case 11:
                return "2G";
            case 12:
                return "3G";
            case 13:
                return "4G";
            case 14:
            case 15:
                return "3G";
            default:
                return "UNKNOWN:" + telephonyManager.getNetworkType();
        }
    }

    private static String s() {
        List<MkBook> listC = AppDatabase.i().a().c();
        if (a(listC)) {
            return "";
        }
        return new GsonBuilder().setExclusionStrategies(new l0(new String[]{"art_id", "book_count", "book_int_filed_3", "book_int_filed_4", "book_int_filed_5", "book_int_filed_6", "cacheProgress", "cacheTotalSize", "isChangeSiteId", "isInshelf", "not_update_day", "position", "search_count", ArticleInfo.USER_SEX, "skipToDetailPage", "source_count", "total_count", "book_text_filed_3", "book_text_filed_4", "book_text_filed_5", "book_text_filed_6"})).create().toJson(listC);
    }

    public static int g() {
        return g0.a().a(B() + "ad_error_time", 0);
    }

    public static void i(boolean z2) {
        g0.a().b("is_current_process", z2);
    }

    public static String g(Context context) {
        return f.a(context, "accelerate", "");
    }

    private static boolean i(String str) {
        return str.matches(".*[a-zA-z].*");
    }

    public static void l(int i2) {
        g0.a().b(B() + "ad_error_time", i2);
    }

    public static String b(long j2) {
        String str;
        if (j2 <= 0) {
            return "";
        }
        if (j2 < 100000) {
            str = " " + j2;
        } else {
            str = " " + (j2 / 10000) + "万";
        }
        return str + "";
    }

    public static void c(Activity activity) {
        View currentFocus;
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager == null || (currentFocus = activity.getCurrentFocus()) == null || !inputMethodManager.isActive()) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
    }

    public static int i() {
        return g0.a().a(B() + "ad_track_error1Count", 0);
    }

    public static boolean j(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("data:image/png;base64,") || str.startsWith("data:image/*;base64,") || str.startsWith("data:image/jpg;base64,"));
    }

    public static void C(String str) {
        g0.a().b("reset_domain", str);
    }

    public static int D() {
        int[] iArr = {2, 4};
        double dRandom = Math.random();
        double length = iArr.length;
        Double.isNaN(length);
        return iArr[(int) (dRandom * length)];
    }

    public static boolean a(List<?> list) {
        return list == null || list.size() == 0;
    }

    public static boolean a(ArrayList<Integer> arrayList) {
        if (a((List<?>) arrayList)) {
            return false;
        }
        Iterator<Integer> it = arrayList.iterator();
        while (it.hasNext()) {
            if (502 == it.next().intValue()) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(Context context, String str) {
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        if (installedPackages != null) {
            for (int i2 = 0; i2 < installedPackages.size(); i2++) {
                if (str.equals(installedPackages.get(i2).packageName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void j(int i2) {
        g0.a().b("from_unlock_comic", i2);
    }

    public static void w(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str2 = "ad_end_datetime: " + str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        long jF = y.f(str);
        b();
        String str3 = "当前时区 ad_end_datetime:" + t0.a(str) + " ad_end_datetime_long:" + jF;
        if (jF <= 0 || jF <= jCurrentTimeMillis) {
            if (jF <= -3600000) {
                b();
            }
        } else {
            g0 g0VarA = g0.a();
            g0VarA.b("electrostatic", jF);
            g0VarA.b("eyeglass", true);
        }
    }

    public static List<MkBook> c(int i2) {
        com.amgcyo.cuttadon.database.f fVarA = AppDatabase.i().a();
        return u0() ? fVarA.j(i2) : fVarA.b(i2);
    }

    public static void d(boolean z2) {
        g0.a().b("eye_protected_model", z2);
    }

    public static void j(boolean z2) {
        N().b("is_old_ad_model_novel", z2);
    }

    public static int d(Context context) {
        try {
            int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", DispatchConstants.ANDROID);
            if (identifier > 0) {
                return context.getResources().getDimensionPixelSize(identifier);
            }
            return 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static boolean a(Context context, String str) {
        if (str != null && !str.isEmpty()) {
            List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
            if (installedPackages.isEmpty()) {
                return false;
            }
            for (int i2 = 0; i2 < installedPackages.size(); i2++) {
                if (str.equals(installedPackages.get(i2).packageName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String e(Context context) {
        Object obj = null;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo.metaData != null) {
                obj = applicationInfo.metaData.get("BMOB_CHANNEL");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (obj == null || "".equals(obj)) {
            obj = "website";
        }
        return obj.toString();
    }

    public static int b(Activity activity) {
        if (com.amgcyo.cuttadon.j.f.b.e()) {
            return f0() ? g0.a().a("SafeInsetLeft", 0) : com.amgcyo.cuttadon.j.f.e.c(activity) ? com.amgcyo.cuttadon.j.f.e.b(activity) : 0;
        }
        if (com.amgcyo.cuttadon.j.f.b.d() && com.amgcyo.cuttadon.j.f.a.b(activity)) {
            return com.amgcyo.cuttadon.j.f.a.a(activity)[0];
        }
        if (com.amgcyo.cuttadon.j.f.c.a(activity)) {
            int iB = com.amgcyo.cuttadon.j.f.c.b();
            String str = "oppo width: " + iB;
            return iB;
        }
        if (com.amgcyo.cuttadon.j.f.d.c(activity)) {
            return com.amgcyo.cuttadon.j.f.d.b(activity);
        }
        return 0;
    }

    public static boolean c() {
        if (h.F0()) {
            return false;
        }
        return h.I0() && m0() && j() != null;
    }

    public static String d() {
        return g0.a().a("xf-appid", "11000001");
    }

    private static String t() {
        MkUser mkUserJ = j();
        if (mkUserJ == null) {
            return "";
        }
        String str = "user:" + mkUserJ.getUser_id();
        String str2 = "token:" + mkUserJ.getToken();
        return new GsonBuilder().setExclusionStrategies(new l0(new String[]{"invitation_code"})).create().toJson(mkUserJ);
    }

    public static void a(Context context, String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                com.amgcyo.cuttadon.view.webview.b.startActivity(context, str2);
                return;
            }
            l.b.a.j.a((CharSequence) "请在应用商店下载！");
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(BaseConstants.MARKET_PREFIX + str));
            intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            context.startActivity(intent);
        } catch (Exception unused) {
            com.amgcyo.cuttadon.view.webview.b.startActivity(context, str2);
        }
    }

    public static String c(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return "ConnectivityManager not found";
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return "UNKNOWN";
        }
        String typeName = activeNetworkInfo.getTypeName();
        if (typeName.equalsIgnoreCase("WIFI")) {
            return "WIFI";
        }
        if (typeName.equalsIgnoreCase("MOBILE")) {
            return TextUtils.isEmpty(Proxy.getDefaultHost()) ? k(context) : "WAP";
        }
        return null;
    }

    public static String e(String str) {
        String fissionUrl = MkApplication.getAppContext().getFissionUrl();
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(fissionUrl)) {
            return null;
        }
        return E() + fissionUrl + "?type=" + str + "&pname=" + com.amgcyo.cuttadon.f.o.d(R.string.app_name);
    }

    public static boolean e() {
        return g0.a().a("app_version_test", false);
    }

    public static boolean a(File file) {
        return file == null || !file.exists() || file.length() < 5;
    }

    public static List<Integer> a(List<Integer> list, List<Integer> list2) {
        if (a(list) || a(list2)) {
            return null;
        }
        HashMap map = new HashMap(list.size() + list2.size());
        ArrayList arrayList = new ArrayList();
        if (list2.size() > list.size()) {
            list2 = list;
            list = list2;
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            map.put(it.next(), 1);
        }
        for (Integer num : list2) {
            Integer num2 = (Integer) map.get(num);
            if (num2 != null) {
                map.put(num, Integer.valueOf(num2.intValue() + 1));
            } else {
                map.put(num, 1);
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            if (((Integer) entry.getValue()).intValue() == 1) {
                arrayList.add((Integer) entry.getKey());
            }
        }
        return arrayList;
    }

    public static boolean b(String str, CharSequence charSequence) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        return a(str, charSequence);
    }

    public static String c(String str) {
        return "https://conf." + str + "/state.jpg";
    }

    public static void c(long j2) {
        com.amgcyo.cuttadon.utils.comic.d.a("Participate", Long.valueOf(j2));
    }

    private static void b() {
        g0 g0VarA = g0.a();
        g0VarA.b("electrostatic", 0L);
        g0VarA.b("eyeglass", false);
    }

    static void c(boolean z2) {
        g0.a().b("value_unlock_preload", z2);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static String b(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return "unkonow sim";
        }
        String simOperator = telephonyManager.getSimOperator();
        if (simOperator != null) {
            byte b2 = -1;
            int iHashCode = simOperator.hashCode();
            if (iHashCode != 49679477) {
                switch (iHashCode) {
                    case 49679470:
                        if (simOperator.equals("46000")) {
                            b2 = 0;
                        }
                        break;
                    case 49679471:
                        if (simOperator.equals("46001")) {
                            b2 = 3;
                        }
                        break;
                    case 49679472:
                        if (simOperator.equals("46002")) {
                            b2 = 1;
                        }
                        break;
                    case 49679473:
                        if (simOperator.equals("46003")) {
                            b2 = 4;
                        }
                        break;
                }
            } else if (simOperator.equals("46007")) {
                b2 = 2;
            }
            if (b2 == 0 || b2 == 1 || b2 == 2) {
                return "中国移动";
            }
            if (b2 == 3) {
                return "中国联通";
            }
            if (b2 == 4) {
                return "中国电信";
            }
        }
        return "unkonow sim " + simOperator;
    }

    public static void b(boolean z2) {
        f.b(MkApplication.getAppContext(), "db_on_corruption", z2);
    }

    public static void a(int i2, float f2) {
        g0.a().b(String.valueOf(i2), f2);
    }

    public static File a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 100;
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        while (byteArrayOutputStream.toByteArray().length / 1024 > 500) {
            byteArrayOutputStream.reset();
            i2 -= 10;
            bitmap.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
        }
        File file = new File(z.k(), "avatar.jpg");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(byteArrayOutputStream.toByteArray());
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } catch (FileNotFoundException e3) {
            e3.printStackTrace();
        }
        a(bitmap);
        return file;
    }

    private static void a(Bitmap... bitmapArr) {
        if (bitmapArr == null) {
            return;
        }
        for (Bitmap bitmap : bitmapArr) {
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
    }

    public static List a(List list, int i2) {
        if (list.size() < i2) {
            return list;
        }
        Random random = new Random();
        if (i2 <= 0) {
            i2 = random.nextInt(6) + 5;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i3 = 0;
        while (i3 < i2) {
            int iNextInt = random.nextInt(list.size());
            if (arrayList.contains(Integer.valueOf(iNextInt))) {
                i3--;
            } else {
                arrayList.add(Integer.valueOf(iNextInt));
                arrayList2.add(list.get(iNextInt));
            }
            i3++;
        }
        return arrayList2;
    }

    public static void a(EditText editText) {
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        ((InputMethodManager) editText.getContext().getSystemService("input_method")).showSoftInput(editText, 0);
    }

    public static int a(@ColorRes int i2) {
        return MkApplication.getAppContext().getResources().getColor(i2);
    }

    public static String a(String str, long j2) {
        return j2 + "_" + str.replaceAll("/", "_").replace(".html", ".data");
    }

    public static String a(long j2) {
        String str;
        if (j2 <= 0) {
            return "暂无人点赞^_^";
        }
        if (j2 < 100000) {
            str = " " + j2;
        } else {
            str = " " + (j2 / 10000) + "万";
        }
        return str + "人已点赞";
    }

    public static int a(Activity activity) {
        int iA = n.a(32.0f);
        if (com.amgcyo.cuttadon.j.f.b.e()) {
            if (com.amgcyo.cuttadon.j.f.e.c(activity)) {
                iA = com.amgcyo.cuttadon.j.f.e.a(activity);
            }
            if (f0()) {
                iA = g0.a().a("SafeInsetBottom", 0);
            }
            return iA <= 0 ? d((Context) activity) : iA;
        }
        if (com.amgcyo.cuttadon.j.f.b.d() && com.amgcyo.cuttadon.j.f.a.b(activity)) {
            return com.amgcyo.cuttadon.j.f.a.a(activity)[1];
        }
        if (com.amgcyo.cuttadon.j.f.c.a(activity)) {
            return com.amgcyo.cuttadon.j.f.c.a();
        }
        return com.amgcyo.cuttadon.j.f.d.c(activity) ? com.amgcyo.cuttadon.j.f.d.a(activity) : iA;
    }

    private static boolean a(String str, CharSequence charSequence) {
        return charSequence != null && charSequence.length() > 0 && Pattern.matches(str, charSequence);
    }

    public static void a(int i2, Context context, String str) {
        String str2;
        a(true);
        MkApplication appContext = MkApplication.getAppContext();
        if ("gdt_new".equals(str)) {
            str2 = " ga: " + (true ^ TextUtils.isEmpty(h.a("gdt_new"))) + " " + appContext.isGdtInit();
            appContext.setGdtInit(false);
        } else if ("csj_new".equals(str)) {
            str2 = " cja: " + (true ^ TextUtils.isEmpty(h.a("csj_new"))) + " " + appContext.isCsjInit();
            appContext.setCsjInit(false);
        } else {
            str2 = "unknow platform appid";
        }
        MkAppConfig appConfig = appContext.getAppConfig();
        if (appConfig != null) {
            str2 = str2 + " time: " + appConfig.getSave_time() + " " + appConfig.isIs_success();
        }
        com.amgcyo.cuttadon.h.h.c.a(context, str, " reward ad errorCode：" + i2 + " root: " + com.amgcyo.cuttadon.h.a.g.d() + " process: " + k0() + " release: " + Build.VERSION.RELEASE + " model: " + Build.MODEL + " info: " + str2 + " package: " + j(context));
        StringBuilder sb = new StringBuilder();
        sb.append("初始化失败，请重启(1次到3次)APP后重试或到APP官网下载最新版本！\n如果无法解决再将错误码：");
        sb.append(i2);
        sb.append("反馈给客服！ ");
        com.amgcyo.cuttadon.f.o.b(sb.toString());
    }

    public static boolean a(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Settings.System.canWrite(context);
        }
        return true;
    }

    public static void a(Context context, int i2) {
        String str = "锁屏时间:" + i2;
        try {
            Settings.System.putInt(context.getContentResolver(), "screen_off_timeout", i2);
        } catch (Exception unused) {
        }
    }

    public static String a(String str) {
        String string = new StringBuilder(str).reverse().toString();
        if (string.equals("0")) {
            return string;
        }
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (true) {
            if (i2 >= string.length()) {
                break;
            }
            int i3 = i2 * 3;
            int i4 = i3 + 3;
            if (i4 > string.length()) {
                sb.append(string.substring(i3));
                break;
            }
            sb.append(string.substring(i3, i4));
            sb.append(",");
            i2++;
        }
        String string2 = new StringBuilder((sb.toString().endsWith(",") ? new StringBuilder(sb.substring(0, sb.length() - 1)) : sb).toString()).reverse().toString();
        return string2.substring(0, string2.lastIndexOf(",")) + string2.substring(string2.lastIndexOf(",") + 1);
    }

    public static String a(int i2, int i3) {
        return a("%d/%d", Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public static String a(String str, Object... objArr) {
        return String.format(Locale.getDefault(), str, objArr);
    }

    public static int a(float f2) {
        return (int) ((f2 * MkApplication.getAppContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void a(MkAppConfig mkAppConfig) {
        int i2 = 4;
        if (mkAppConfig != null && mkAppConfig.getForce() != null) {
            int iS0 = h.s0();
            int iR0 = h.r0();
            int iP0 = h.p0();
            int iQ0 = h.q0();
            int iO0 = h.o0();
            int iG = com.amgcyo.cuttadon.app.o.c.g();
            long jLongValue = J().longValue();
            String str = "下发的搜索类型：" + iS0 + "\n下发的v7启动次数：" + iR0 + "\n下发的v7阅读时长：" + iP0 + "\n下发的启动次数：" + iQ0 + "\n下发的阅读时长：" + iO0 + "\n本地保存的启动次数：" + iG + "\n本地保存的阅读时长：" + jLongValue;
            if (2 == iS0) {
                i2 = 6;
            } else if (iG > iR0 && jLongValue > iP0 * 60 && iP0 != 0) {
                i2 = 7;
            } else if (iG > iQ0 && jLongValue > iO0 * 60 && iO0 != 0) {
                i2 = 5;
            } else if (4 == iS0) {
                i2 = 8;
            }
        }
        g0 g0VarA = g0.a();
        g0VarA.b("roundtables", i2);
        g0VarA.b("comics_status", h.y() == 1);
        g0VarA.b("source_open_status", h.w0() == 0);
        g0VarA.b("ad_polling_second_value", com.amgcyo.cuttadon.sdk.utils.g.a("ad_polling_second", 60));
        PushDataBean pushDataBeanJ = h.j();
        if (pushDataBeanJ != null) {
            String bug_key = pushDataBeanJ.getBug_key();
            if (!TextUtils.isEmpty(bug_key)) {
                Base64Bean base64Bean = new Base64Bean();
                base64Bean.setVer(1);
                base64Bean.setContent(bug_key);
                bug_key = (String) com.amgcyo.cuttadon.utils.comic.b.a(base64Bean, String.class);
            }
            if (TextUtils.isEmpty(bug_key)) {
                bug_key = "047605967d";
            }
            g0VarA.b("bug_key", bug_key);
            String um_key = pushDataBeanJ.getUm_key();
            if (!TextUtils.isEmpty(um_key)) {
                Base64Bean base64Bean2 = new Base64Bean();
                base64Bean2.setVer(1);
                base64Bean2.setContent(um_key);
                um_key = (String) com.amgcyo.cuttadon.utils.comic.b.a(base64Bean2, String.class);
            }
            if (TextUtils.isEmpty(um_key)) {
                um_key = "5ef59e530cafb20267000026";
            }
            g0VarA.b("um_key", um_key);
            String um_message_secret = pushDataBeanJ.getUm_message_secret();
            if (!TextUtils.isEmpty(um_message_secret)) {
                Base64Bean base64Bean3 = new Base64Bean();
                base64Bean3.setVer(1);
                base64Bean3.setContent(um_message_secret);
                um_message_secret = (String) com.amgcyo.cuttadon.utils.comic.b.a(base64Bean3, String.class);
            }
            if (TextUtils.isEmpty(um_message_secret)) {
                um_message_secret = "ec523cccdfcb4f6a64f9c85b148a6e84";
            }
            g0VarA.b("um_master_secret", um_message_secret);
        }
        String strP = com.amgcyo.cuttadon.sdk.utils.d.p(com.anythink.expressad.d.a.b.cZ);
        if (TextUtils.isEmpty(strP)) {
            strP = "";
        }
        B(strP);
    }

    public static void a(String str, String str2) {
        z(str);
        A(str2);
    }

    public static Slippage a(MkCatalog mkCatalog, int i2, int i3) {
        if (!n0()) {
            return null;
        }
        boolean zH = com.amgcyo.cuttadon.app.o.c.h();
        boolean zJ = com.amgcyo.cuttadon.app.o.c.j();
        StringBuilder sb = new StringBuilder();
        sb.append("androidS:");
        sb.append(zH);
        sb.append(" !expam:");
        sb.append(!zJ);
        sb.toString();
        if (mkCatalog != null && zH && !zJ) {
            int iC = h.c(1);
            String str = "interval_count:" + iC;
            NormalAdParams normalAdParamsD = com.amgcyo.cuttadon.sdk.utils.e.d("adkey_novel_unlock_next");
            if (iC > 0 && normalAdParamsD != null) {
                BaseAd baseAd = normalAdParamsD.getBaseAd();
                int catalogId = mkCatalog.getCatalogId();
                boolean zA = g0.a().a("unlock_" + i2 + "_" + catalogId, false);
                boolean z2 = (catalogId == 0 || catalogId % iC != 0 || zA) ? false : true;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("结果：");
                sb2.append(z2);
                sb2.append(" catalogId != 0:");
                sb2.append(catalogId != 0);
                sb2.append(" 除法:");
                sb2.append(catalogId % iC == 0);
                sb2.append(" !status:");
                sb2.append(true ^ zA);
                sb2.toString();
                if (z2) {
                    Slippage slippage = new Slippage(i2, catalogId, i3, mkCatalog.getName(), baseAd.getPlatform(), baseAd.getStyle());
                    slippage.toString();
                    return slippage;
                }
            }
        }
        return null;
    }

    public static void a(View view) {
        if (view != null) {
            view.startAnimation(s(5));
            view.setFocusable(true);
            view.requestFocus();
        }
    }

    public static void a(boolean z2) {
        g0.a().b("app_version_test", z2);
    }

    public static void a(Context context, String str, Bitmap bitmap) {
        boolean[] zArr = new boolean[1];
        if (i0.a()) {
            zArr[0] = z.a(context, bitmap, str, "image/jpeg");
            if (zArr[0]) {
                com.amgcyo.cuttadon.f.o.b("已成功保存图片到相册");
                return;
            }
            return;
        }
        if (!com.hjq.permissions.f.a(context, com.amgcyo.cuttadon.f.n.f3693g)) {
            com.hjq.permissions.f fVarA = com.hjq.permissions.f.a(context);
            fVarA.a(com.amgcyo.cuttadon.f.n.f3693g);
            fVarA.a(new b(zArr, context, str, bitmap));
        } else {
            zArr[0] = ScannerUtils.a(context, str, bitmap, ScannerUtils.ScannerType.RECEIVER);
            if (zArr[0]) {
                com.amgcyo.cuttadon.f.o.b("已成功保存图片到相册");
            }
        }
    }

    public static void a(MkAdBean mkAdBean) {
        b();
        if (mkAdBean != null) {
            int ad_state = mkAdBean.getAd_state();
            String str = "ad_state:" + ad_state;
            if (ad_state == 1) {
                String ad_end_datetime = mkAdBean.getAd_end_datetime();
                if (TextUtils.isEmpty(ad_end_datetime)) {
                    return;
                }
                if (t0.a(ad_end_datetime) > 0) {
                    p(1);
                }
                w(ad_end_datetime);
                return;
            }
            String message = mkAdBean.getMessage();
            if (ad_state == 3) {
                message = mkAdBean.getAd_tips();
            }
            String str2 = "index_tips" + t0.e(System.currentTimeMillis());
            if (g0.a().a(str2, false) || TextUtils.isEmpty(message)) {
                return;
            }
            g0.a().b(str2, true);
            com.amgcyo.cuttadon.f.o.b(message);
        }
    }

    public static void a(Context context, File file) {
        if (file.exists()) {
            Intent intent = new Intent("android.intent.action.VIEW");
            if (Build.VERSION.SDK_INT >= 24) {
                intent.setDataAndType(FileProvider.getUriForFile(context, h.t() + ".MkTsFileProvider", file), AdBaseConstants.MIME_APK);
                intent.addFlags(1);
            } else {
                intent.setDataAndType(Uri.parse("file://" + file.toString()), AdBaseConstants.MIME_APK);
            }
            intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            context.startActivity(intent);
        }
    }
}
