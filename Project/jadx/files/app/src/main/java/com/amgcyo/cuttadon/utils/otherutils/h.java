package com.amgcyo.cuttadon.utils.otherutils;

import android.text.TextUtils;
import cn.bmob.v3.BmobConstants;
import cn.bmob.v3.datatype.up.ParallelUploader;
import com.amgcyo.cuttadon.api.entity.adbean.NormalAdParams;
import com.amgcyo.cuttadon.api.entity.comment.CommentReprotType;
import com.amgcyo.cuttadon.api.entity.config.BaseAd;
import com.amgcyo.cuttadon.api.entity.config.Fission;
import com.amgcyo.cuttadon.api.entity.config.GameBean;
import com.amgcyo.cuttadon.api.entity.config.MkAppConfig;
import com.amgcyo.cuttadon.api.entity.config.NotifyBean;
import com.amgcyo.cuttadon.api.entity.config.PushDataBean;
import com.amgcyo.cuttadon.api.entity.config.SecondaryDomain;
import com.amgcyo.cuttadon.api.entity.config.UrlsBean;
import com.amgcyo.cuttadon.api.entity.migrate.MigrateBean;
import com.amgcyo.cuttadon.api.entity.migrate.MigrateData;
import com.amgcyo.cuttadon.api.entity.other.MkAdBean;
import com.amgcyo.cuttadon.api.entity.other.MkAppVersion;
import com.amgcyo.cuttadon.api.entity.other.MkChapterContent;
import com.amgcyo.cuttadon.api.entity.other.NewApiAdList;
import com.amgcyo.cuttadon.api.entity.reader.FontBean;
import com.amgcyo.cuttadon.app.MkApplication;
import com.anythink.expressad.atsignalcommon.mraid.CallMraidJS;
import com.open.hule.library.entity.TipsBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import me.jessyan.art.base.QDTCProtect;

/* JADX INFO: compiled from: ArtConfigUtils.java */
/* JADX INFO: loaded from: classes.dex */
@QDTCProtect
public class h {
    public static Fission A() {
        ArrayList<Fission> arrayListK = K();
        if (g.a(arrayListK)) {
            return null;
        }
        return arrayListK.get(0);
    }

    public static int A0() {
        String strB = g.B();
        return g0.a().a(strB + "TodaySawSplashVideoCount", 0);
    }

    private static MigrateBean B() {
        MigrateData migrateDataF = f();
        if (migrateDataF != null) {
            return migrateDataF.getMigrate();
        }
        return null;
    }

    public static String B0() {
        String str = F0() ? "v7" : "v6";
        String str2 = "当前版本：" + str;
        return str;
    }

    public static String C() {
        MigrateBean migrateBeanB = B();
        return migrateBeanB != null ? migrateBeanB.getMatch_format() : "";
    }

    public static String C0() {
        String strE = e("website_url");
        return TextUtils.isEmpty(strE) ? "https://xxydapps.com/fmyd/" : strE;
    }

    public static NotifyBean D() {
        MigrateData migrateDataF = f();
        if (migrateDataF != null) {
            return migrateDataF.getNotify();
        }
        return null;
    }

    public static String D0() {
        return e() == null ? "" : e().getWechat();
    }

    public static TipsBean E() {
        MigrateData migrateDataF;
        String strC = C();
        if (TextUtils.isEmpty(strC) || (migrateDataF = f()) == null) {
            return null;
        }
        TipsBean tips = migrateDataF.getTips();
        if (tips != null) {
            tips.setMatchFormat(strC);
        }
        return tips;
    }

    public static boolean E0() {
        return com.amgcyo.cuttadon.a.f2252c.intValue() == 1;
    }

    public static int F() {
        if (G() == 0) {
            return 1;
        }
        return G();
    }

    public static boolean F0() {
        return u() == 1;
    }

    private static int G() {
        if (e() == null) {
            return 1;
        }
        return e().getData_conf();
    }

    public static boolean G0() {
        MigrateBean migrateBeanB = B();
        boolean z2 = false;
        if (migrateBeanB != null && !TextUtils.isEmpty(migrateBeanB.getMatch_format())) {
            int read_time = migrateBeanB.getRead_time();
            int use_count = migrateBeanB.getUse_count();
            if (read_time > 0 && use_count > 0) {
                int iG = com.amgcyo.cuttadon.app.o.c.g();
                long jA = g.A();
                String str = "本地启动次数：" + iG + " 下发启动次数 " + use_count + " 本地阅读时长 " + jA + " 下发阅读时长 " + read_time;
                if (iG >= use_count && jA >= read_time) {
                    z2 = true;
                }
                String str2 = "isDaoliuOldUser:" + z2;
            }
        }
        return z2;
    }

    public static String H() {
        String strE = e("domain");
        return TextUtils.isEmpty(strE) ? "chuangke.tv" : strE;
    }

    public static boolean H0() {
        return L() == 5;
    }

    public static int I() {
        return com.amgcyo.cuttadon.sdk.utils.g.a("end_tips_ad_switch", 1);
    }

    public static boolean I0() {
        return L() == 6;
    }

    public static List<BaseAd> J() {
        return com.amgcyo.cuttadon.sdk.utils.h.b("err_ad");
    }

    public static boolean J0() {
        return L() == 7;
    }

    public static ArrayList<Fission> K() {
        if (e() == null || g.a(e().getFission())) {
            return null;
        }
        return e().getFission();
    }

    public static boolean K0() {
        return c0() > 0;
    }

    private static int L() {
        Fission fissionA = A();
        if (fissionA != null) {
            return fissionA.getScheme();
        }
        return 0;
    }

    public static boolean L0() {
        int iA = com.amgcyo.cuttadon.sdk.utils.g.a("comment_switch", 0);
        Integer.valueOf(iA);
        return iA == 0;
    }

    public static ArrayList<FontBean> M() {
        if (e() == null || g.a(e().getFont())) {
            return null;
        }
        return e().getFont();
    }

    public static boolean M0() {
        boolean z2 = t0() == 1;
        String str = "是否开启自己sdk：" + z2;
        return z2;
    }

    public static int N() {
        if (d() == null) {
            return 0;
        }
        return d().getGame_interval_seconds();
    }

    public static boolean N0() {
        return d0() == 1;
    }

    public static int O() {
        if (d() == null) {
            return 0;
        }
        return d().getGame_switch();
    }

    static boolean O0() {
        return !TextUtils.isEmpty(m0());
    }

    public static int P() {
        return com.amgcyo.cuttadon.sdk.utils.g.a("guest_book_number", 20);
    }

    public static boolean P0() {
        if (!H0()) {
            return false;
        }
        int iZ0 = z0();
        String str = "piexl:" + iZ0;
        return iZ0 <= 0;
    }

    public static int Q() {
        return com.amgcyo.cuttadon.sdk.utils.g.a("icon_style");
    }

    public static void Q0() {
        com.amgcyo.cuttadon.app.o.c.a(System.currentTimeMillis());
    }

    public static int R() {
        return com.amgcyo.cuttadon.sdk.utils.g.a("interval_chapter_count");
    }

    public static void R0() {
        String strB = g.B();
        g0.a().b(strB + "TodaySawSplashVideoCount", A0() + 1);
    }

    public static int S() {
        return (int) TimeUnit.MINUTES.toSeconds(com.amgcyo.cuttadon.sdk.utils.g.a("invalid_request_min", 5));
    }

    private static void S0() {
        String strD = t0.d(System.currentTimeMillis());
        String str = "举报列表请求成功，时间是：" + strD;
        g0.a().b("CommentReprotType1856", strD);
    }

    public static int T() {
        return com.amgcyo.cuttadon.sdk.utils.h.a("listening_book", "interval_min");
    }

    public static boolean T0() {
        return g0.a().a("source_open_status", false);
    }

    public static int U() {
        return com.amgcyo.cuttadon.utils.comic.d.a("refresh_fuli", 0).intValue();
    }

    public static String U0() {
        return "👉观看小视频解锁后续章节👈";
    }

    public static int V() {
        return com.amgcyo.cuttadon.sdk.utils.g.a("login_book_number", 100);
    }

    public static String V0() {
        return "👉观看小视频解锁后续章节👈";
    }

    public static int W() {
        return com.amgcyo.cuttadon.sdk.utils.g.a("max_ad_count", 5);
    }

    public static int X() {
        return com.amgcyo.cuttadon.sdk.utils.h.a("exempt_ad", "interval_count");
    }

    public static int Y() {
        return com.amgcyo.cuttadon.sdk.utils.h.a("exempt_ad", "interval_min");
    }

    public static List<BaseAd> Z() {
        return com.amgcyo.cuttadon.sdk.utils.h.b("exempt_ad");
    }

    public static void a() {
        MkAppConfig mkAppConfigJ0 = j0();
        if (mkAppConfigJ0 != null) {
            String strA = t0.a(1);
            String str = "缓存配置时间修改为：" + strA + " 当前时间为：" + t0.d(System.currentTimeMillis());
            mkAppConfigJ0.setSave_time(strA);
            String strA2 = r.a(mkAppConfigJ0);
            MkApplication.getAppContext().setAppConfig(mkAppConfigJ0);
            i(strA2);
        }
    }

    public static int a0() {
        return com.amgcyo.cuttadon.sdk.utils.g.a("novice_count");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int b(java.lang.String r5) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            r1 = 1
            if (r0 == 0) goto L8
            return r1
        L8:
            com.amgcyo.cuttadon.api.entity.config.NotifyBean r0 = g()
            if (r0 != 0) goto Lf
            return r1
        Lf:
            r2 = -1
            int r3 = r5.hashCode()
            r4 = -2091234663(0xffffffff835a4a99, float:-6.4150076E-37)
            if (r3 == r4) goto L29
            r4 = -537591189(0xffffffffdff5026b, float:-3.5309582E19)
            if (r3 == r4) goto L1f
            goto L33
        L1f:
            java.lang.String r3 = "notify_tips_type"
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L33
            r5 = 1
            goto L34
        L29:
            java.lang.String r3 = "notify_open_type"
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L33
            r5 = 0
            goto L34
        L33:
            r5 = -1
        L34:
            if (r5 == 0) goto L3e
            if (r5 == r1) goto L39
            goto L42
        L39:
            int r1 = r0.getNotify_tips_type()
            goto L42
        L3e:
            int r1 = r0.getNotify_open_type()
        L42:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.utils.otherutils.h.b(java.lang.String):int");
    }

    public static int b0() {
        return com.amgcyo.cuttadon.sdk.utils.g.a("novice_read");
    }

    public static String c() {
        int iU = u();
        String str = 1 == iU ? "v7" : (I0() || iU == 0) ? "v6" : "v4";
        String str2 = "当前版本：" + str;
        return str;
    }

    public static int c0() {
        return com.amgcyo.cuttadon.sdk.utils.g.a("novice_switch");
    }

    private static GameBean d() {
        MkAppConfig mkAppConfigE = e();
        if (mkAppConfigE == null || mkAppConfigE.getGame() == null) {
            return null;
        }
        return mkAppConfigE.getGame();
    }

    private static int d0() {
        return com.amgcyo.cuttadon.sdk.utils.g.a("pay_switch", 0);
    }

    public static MkAppConfig e() {
        return MkApplication.getAppContext().getAppConfig();
    }

    public static int e0() {
        return com.amgcyo.cuttadon.sdk.utils.g.a("pay_tips_count", 50);
    }

    public static boolean f(String str) {
        String strA = a(str, "sound_switch");
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        String str2 = "platformAdPositionId: " + strA;
        return strA.equals("1");
    }

    public static String f0() {
        return e() == null ? "" : e().getQq();
    }

    public static void g(String str) {
        com.amgcyo.cuttadon.utils.comic.d.a("key_search_history_keyword", (Object) str);
    }

    public static String g0() {
        List<String> listB = com.amgcyo.cuttadon.sdk.utils.g.b("read_ad_content2");
        if (listB != null && !g.b(listB)) {
            return listB.get(new Random().nextInt(listB.size()));
        }
        return "APP官网：" + C0();
    }

    public static void h(String str) {
        g0.a().b(com.amgcyo.cuttadon.f.n.b, str);
    }

    public static String h0() {
        return t();
    }

    private static UrlsBean i() {
        MkAppConfig mkAppConfigE = e();
        if (mkAppConfigE == null || mkAppConfigE.getUrls() == null) {
            return null;
        }
        return mkAppConfigE.getUrls();
    }

    public static MkAppVersion i0() {
        String strA = g0.a().a(com.amgcyo.cuttadon.f.n.b, "");
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        return (MkAppVersion) r.a(strA, MkAppVersion.class);
    }

    public static void j(String str) {
        S0();
        g0.a().b("CommentReprotType1730", str);
    }

    public static MkAppConfig j0() {
        MkAppConfig mkAppConfig;
        String strA = g0.a().a(com.amgcyo.cuttadon.f.n.a, "");
        if (TextUtils.isEmpty(strA) || (mkAppConfig = (MkAppConfig) r.a(strA, MkAppConfig.class)) == null) {
            return null;
        }
        MkApplication.getAppContext().setAppConfig(mkAppConfig);
        String strH = H();
        g.C(strH);
        SecondaryDomain secondaryDomainH = h();
        if (secondaryDomainH != null) {
            MkApplication.getAppContext().setDomainUrlBySecondDomain(secondaryDomainH);
        } else {
            MkApplication.getAppContext().setDomainUrl(strH);
        }
        return mkAppConfig;
    }

    public static void k(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = me.jessyan.art.b.c.a().a(str.getBytes());
        }
        g0.a().b("um_json2018", str);
    }

    public static List<CommentReprotType> k0() {
        String strA = g0.a().a("CommentReprotType1730", "");
        List<CommentReprotType> listB = !TextUtils.isEmpty(strA) ? r.b(strA, CommentReprotType.class) : null;
        if (!g.a(listB)) {
            return listB;
        }
        ArrayList arrayList = new ArrayList();
        CommentReprotType commentReprotType = new CommentReprotType(1, "辱骂作者及他人");
        CommentReprotType commentReprotType2 = new CommentReprotType(2, "广告及垃圾信息");
        CommentReprotType commentReprotType3 = new CommentReprotType(3, "不良淫秽内容");
        CommentReprotType commentReprotType4 = new CommentReprotType(4, "激进敏感内容");
        CommentReprotType commentReprotType5 = new CommentReprotType(5, "其他");
        arrayList.add(commentReprotType);
        arrayList.add(commentReprotType2);
        arrayList.add(commentReprotType3);
        arrayList.add(commentReprotType4);
        arrayList.add(commentReprotType5);
        return arrayList;
    }

    private static int l(int i2) {
        return com.amgcyo.cuttadon.sdk.utils.f.b(i2, CallMraidJS.f8282e);
    }

    public static MkAdBean l0() {
        String strA = g0.a().a("um_json2018", "");
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        return (MkAdBean) r.a(me.jessyan.art.b.c.a().a(strA), MkAdBean.class);
    }

    public static String m() {
        return e("baidu_tts_url");
    }

    private static String m0() {
        return g0.a().a("zhuge_id", "");
    }

    public static String n(int i2) {
        return "👉看小视频免" + i2 + "分钟广告👈";
    }

    public static String n0() {
        return com.amgcyo.cuttadon.utils.comic.d.a("key_search_history_keyword", "");
    }

    public static int o(int i2) {
        String strB = g.B();
        String str = strB + "specialized";
        if (3 == i2) {
            str = strB + "awesome";
        }
        return g0.a().a(str, 0);
    }

    static int o0() {
        return com.amgcyo.cuttadon.sdk.utils.g.a("search_read", 10);
    }

    public static boolean p(int i2) {
        int iA = com.amgcyo.cuttadon.h.a.i.a(i2);
        if (1 == i2) {
            return iA > 0 && !g.a(k(1));
        }
        return iA > 0 && !g.a(k(3));
    }

    static int p0() {
        return com.amgcyo.cuttadon.sdk.utils.g.a("search_read1", 10);
    }

    public static boolean q(int i2) {
        return l(i2) == 1;
    }

    static int q0() {
        return com.amgcyo.cuttadon.sdk.utils.g.a("search_start_up", 100);
    }

    public static boolean r(int i2) {
        boolean zP = p(i2);
        if (3 == i2) {
            if (com.amgcyo.cuttadon.app.o.c.i() || !v(i2)) {
                return false;
            }
            boolean zC = com.amgcyo.cuttadon.app.o.c.c(i2);
            String str = "漫画是否开启笔趣阁方案：" + zP;
            StringBuilder sb = new StringBuilder();
            sb.append("漫画阅读时间是否过期：");
            sb.append(!zC);
            sb.toString();
            return zP && !zC;
        }
        if (1 != i2 || com.amgcyo.cuttadon.app.o.c.j() || !v(i2)) {
            return false;
        }
        boolean zC2 = com.amgcyo.cuttadon.app.o.c.c(i2);
        String str2 = "小说是否开启笔趣阁方案：" + zP;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("小说阅读时间是否过期：");
        sb2.append(!zC2);
        sb2.toString();
        return zP && !zC2;
    }

    static int r0() {
        return com.amgcyo.cuttadon.sdk.utils.g.a("search_start_up1", 100);
    }

    public static String s() {
        String strC = com.amgcyo.cuttadon.sdk.utils.g.c(BmobConstants.TAG);
        return !TextUtils.isEmpty(strC) ? com.amgcyo.cuttadon.view.read.page.m.a(strC) : strC;
    }

    static int s0() {
        return com.amgcyo.cuttadon.sdk.utils.g.a("search_type");
    }

    public static String t() {
        return "com.fatcatfat.io";
    }

    public static void t(int i2) {
        boolean z2 = p(i2) && q(i2);
        String str = "isUnlockAndPreload:" + z2;
        g.c(z2);
    }

    private static int t0() {
        if (g0.a().a("self", false)) {
            return 1;
        }
        return com.amgcyo.cuttadon.sdk.utils.g.a("self_switch", 0);
    }

    public static void u(int i2) {
        if (H0()) {
            com.amgcyo.cuttadon.utils.comic.d.a("refresh_fuli", Integer.valueOf(i2));
        }
    }

    public static boolean u0() {
        return com.amgcyo.cuttadon.sdk.utils.g.a("shield_switch") == 1;
    }

    private static boolean v(int i2) {
        return o(i2) < W();
    }

    public static int v0() {
        return com.amgcyo.cuttadon.sdk.utils.g.a("show_author");
    }

    public static int w() {
        return com.amgcyo.cuttadon.sdk.utils.h.a("comics_exempt_ad", "interval_min");
    }

    static int w0() {
        return com.amgcyo.cuttadon.sdk.utils.g.a("source_open_switch", 0);
    }

    public static List<BaseAd> x() {
        return com.amgcyo.cuttadon.sdk.utils.h.b("comics_exempt_ad");
    }

    public static List<BaseAd> x0() {
        return com.amgcyo.cuttadon.sdk.utils.h.b("splash_screen");
    }

    static int y() {
        return com.amgcyo.cuttadon.sdk.utils.g.a("comics_switch");
    }

    public static int y0() {
        return com.amgcyo.cuttadon.sdk.utils.h.a("splash_screen", "video_count");
    }

    public static String z() {
        String strD = g0.a().d("CommentReprotType1856");
        String str = "读取本地举报列表请求时间成功，时间是：" + strD;
        return strD;
    }

    public static int z0() {
        return g0.a().a("piexl_" + t0.a(), 0);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static String e(String str) {
        UrlsBean urlsBeanI;
        if (TextUtils.isEmpty(str) || (urlsBeanI = i()) == null) {
            return "";
        }
        byte b = -1;
        switch (str.hashCode()) {
            case -2118185013:
                if (str.equals("website_url")) {
                    b = 4;
                }
                break;
            case -1326197564:
                if (str.equals("domain")) {
                    b = 2;
                }
                break;
            case -879587585:
                if (str.equals("baidu_tts_url")) {
                    b = 0;
                }
                break;
            case 1042678868:
                if (str.equals("iflytek_tts_url")) {
                    b = 1;
                }
                break;
            case 1398103163:
                if (str.equals("qr_code_url")) {
                    b = 5;
                }
                break;
            case 2082685923:
                if (str.equals("diversion_url")) {
                    b = 3;
                }
                break;
        }
        return b != 0 ? b != 1 ? b != 2 ? b != 3 ? b != 4 ? b != 5 ? "" : urlsBeanI.getQr_code_url() : urlsBeanI.getWebsite_url() : urlsBeanI.getDiversion_url() : urlsBeanI.getDomain() : urlsBeanI.getIflytek_tts_url() : urlsBeanI.getBaidu_tts_url();
    }

    private static NotifyBean g() {
        MkAppConfig mkAppConfigE = e();
        if (mkAppConfigE == null || mkAppConfigE.getNotify() == null) {
            return null;
        }
        return mkAppConfigE.getNotify();
    }

    public static SecondaryDomain h() {
        MkAppConfig mkAppConfigE = e();
        if (mkAppConfigE == null || mkAppConfigE.getSecondary_domain() == null) {
            return null;
        }
        return mkAppConfigE.getSecondary_domain();
    }

    public static List<BaseAd> l() {
        return com.amgcyo.cuttadon.sdk.utils.h.b("asking_book");
    }

    public static int m(int i2) {
        return com.amgcyo.cuttadon.sdk.utils.f.b(i2, "interval_min");
    }

    public static String n() {
        return com.amgcyo.cuttadon.view.read.page.m.a(com.amgcyo.cuttadon.sdk.utils.g.c("bdid1"));
    }

    public static String q() {
        return com.amgcyo.cuttadon.view.read.page.m.a(com.amgcyo.cuttadon.sdk.utils.g.c("bds1"));
    }

    public static boolean w(int i2) {
        String strA = com.amgcyo.cuttadon.sdk.utils.g.a("ad_err_code", "40018,40021,107006,107030,330004,44406");
        String str = "union str：" + strA;
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        for (String str2 : strA.split(",")) {
            if (g.q(str2)) {
                long jLongValue = Long.valueOf(str2).longValue();
                String str3 = "code:" + jLongValue + " errorCode: " + i2;
                if (i2 == jLongValue) {
                    return true;
                }
            }
        }
        return false;
    }

    public static PushDataBean j() {
        MkAppConfig mkAppConfigE = e();
        if (mkAppConfigE == null || mkAppConfigE.getPush_data() == null) {
            return null;
        }
        return mkAppConfigE.getPush_data();
    }

    public static int u() {
        return com.amgcyo.cuttadon.sdk.utils.g.a("chapter_switch", 0);
    }

    public static int v() {
        return com.amgcyo.cuttadon.sdk.utils.h.a("comics_exempt_ad", "interval_count");
    }

    public static String c(String str) {
        NotifyBean notifyBeanG;
        if (TextUtils.isEmpty(str) || (notifyBeanG = g()) == null) {
            return "";
        }
        byte b = -1;
        int iHashCode = str.hashCode();
        if (iHashCode != -1164591239) {
            if (iHashCode == 894114179 && str.equals("notify_content")) {
                b = 0;
            }
        } else if (str.equals(ParallelUploader.Params.NOTIFY_URL)) {
            b = 1;
        }
        if (b != 0) {
            return b != 1 ? "" : notifyBeanG.getNotify_url();
        }
        return notifyBeanG.getNotify_content();
    }

    public static int d(int i2) {
        return com.amgcyo.cuttadon.sdk.utils.f.a(i2, "interval_count", "content_page");
    }

    public static void i(String str) {
        g0.a().b(com.amgcyo.cuttadon.f.n.a, str);
    }

    public static List<BaseAd> k(int i2) {
        return com.amgcyo.cuttadon.sdk.utils.f.a(i2, "read_ad_lock");
    }

    public static boolean s(int i2) {
        boolean zN0 = g.n0();
        List<BaseAd> listZ = Z();
        int iB = com.amgcyo.cuttadon.h.a.i.b(1);
        if (3 == i2) {
            zN0 = g.i0();
            listZ = x();
            iB = com.amgcyo.cuttadon.h.a.i.b(3);
        }
        return zN0 && !g.a(listZ) && iB > 0;
    }

    public static int[] d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String strA = a(str, "ecode1");
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        String[] strArrSplit = strA.split(",");
        if (strArrSplit.length <= 0) {
            return null;
        }
        int[] iArr = new int[strArrSplit.length];
        for (int i2 = 0; i2 < strArrSplit.length; i2++) {
            String str2 = strArrSplit[i2];
            if (g.q(str2)) {
                int iIntValue = Integer.valueOf(str2).intValue();
                String str3 = "code:" + iIntValue;
                iArr[i2] = iIntValue;
            }
        }
        return iArr;
    }

    public static List<BaseAd> f(int i2) {
        return com.amgcyo.cuttadon.sdk.utils.f.a(i2, "content_end");
    }

    public static List<BaseAd> g(int i2) {
        return com.amgcyo.cuttadon.sdk.utils.f.a(i2, "interface_top");
    }

    public static List<BaseAd> h(int i2) {
        return com.amgcyo.cuttadon.sdk.utils.f.a(i2, "content_page1");
    }

    public static List<BaseAd> i(int i2) {
        return com.amgcyo.cuttadon.sdk.utils.f.a(i2, "content_page");
    }

    public static int k() {
        return com.amgcyo.cuttadon.sdk.utils.h.a("asking_book", "total_count");
    }

    public static int o() {
        return com.amgcyo.cuttadon.sdk.utils.g.a("bdc", com.amgcyo.cuttadon.f.n.R);
    }

    public static List<BaseAd> b(int i2) {
        return com.amgcyo.cuttadon.sdk.utils.f.a(i2, "content_bottom");
    }

    private static MigrateData f() {
        MkAppConfig mkAppConfigE = e();
        if (mkAppConfigE == null || mkAppConfigE.getForce() == null) {
            return null;
        }
        return mkAppConfigE.getMigrate_data();
    }

    private static int j(int i2) {
        return com.amgcyo.cuttadon.sdk.utils.f.b(i2, "back");
    }

    public static String p() {
        return com.amgcyo.cuttadon.view.read.page.m.a(com.amgcyo.cuttadon.sdk.utils.g.c("bdk1"));
    }

    public static NewApiAdList b() {
        return MkApplication.getAppContext().getNewApiAdList();
    }

    public static int a(int i2) {
        int iJ = j(i2);
        String str = "返回按钮关闭方式：" + iJ;
        return iJ;
    }

    public static int c(int i2) {
        return com.amgcyo.cuttadon.sdk.utils.f.a(i2, "interval_count", "content_page1");
    }

    public static String a(String str) {
        String strA = a(str, com.anythink.expressad.d.a.b.cZ);
        return (TextUtils.isEmpty(strA) || !"0".equals(strA)) ? strA : "";
    }

    public static int e(int i2) {
        return com.amgcyo.cuttadon.sdk.utils.f.a(i2, com.anythink.expressad.foundation.h.i.f10647e, "content_page");
    }

    public static String r() {
        String strA = com.amgcyo.cuttadon.view.read.page.m.a(com.amgcyo.cuttadon.sdk.utils.g.c("bdsn1"));
        int iLastIndexOf = strA.lastIndexOf("-");
        if (iLastIndexOf != -1) {
            return strA.substring(0, iLastIndexOf);
        }
        return com.amgcyo.cuttadon.view.read.page.m.a();
    }

    public static MkChapterContent a(int i2, int i3) {
        NormalAdParams normalAdParamsC;
        NormalAdParams normalAdParamsC2;
        if (!g.n0()) {
            return null;
        }
        String str = "interval_chapter_count:" + i2 + " \ncurrentChpaterId:" + i3;
        if (i2 <= 0) {
            if (!com.amgcyo.cuttadon.h.a.c.b("position_page_ad") || (normalAdParamsC2 = com.amgcyo.cuttadon.sdk.utils.e.c()) == null) {
                return null;
            }
            return new MkChapterContent(1, normalAdParamsC2);
        }
        if (i3 == 0 || i3 % i2 != 0 || (normalAdParamsC = com.amgcyo.cuttadon.sdk.utils.e.c()) == null) {
            return null;
        }
        return new MkChapterContent(1, normalAdParamsC);
    }

    public static boolean a(int i2, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String strA = a(str, "ecode");
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        for (String str2 : strA.split(",")) {
            if (g.q(str2)) {
                long jLongValue = Long.valueOf(str2).longValue();
                String str3 = "code:" + jLongValue + " errorCode: " + i2;
                if (i2 == jLongValue) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String a(String str, String str2) {
        return com.amgcyo.cuttadon.sdk.utils.d.a(str, str2);
    }
}
