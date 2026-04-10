package com.anythink.expressad.foundation.d;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.anythink.expressad.foundation.h.t;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class r {
    public static final int A = 22;
    public static final int B = 21;
    public static final int C = 10;
    public static final int D = 11;
    public static final int E = 12;
    public static final String F = "1";
    public static final String G = "2";
    public static final int H = 1;
    public static final int I = 2;
    public static final int J = 3;
    public static final int K = 0;
    public static final int L = 1;
    public static final int M = 2;
    public static final int N = 3;
    public static final int O = 4;
    public static final int P = 5;
    public static final int Q = 6;
    public static final int R = 1;
    public static final int S = 2;
    public static final int T = 3;
    public static final int U = 4;
    public static final String V = "key";
    public static final String W = "network_type";
    public static final String X = "network_str";
    public static final String Y = "is_complete_view";
    public static final String Z = "watched_millis";
    public static final String a = "2000020";
    public static final String aA = "ad_type";
    public static final String aB = "resource_type";
    public static final String aC = "devid";
    public static final String aD = "creative";
    public static final String aE = "mraid_type";
    public static final String aF = "adspace_t";
    public static final String aG = "1";
    public static final String aH = "2";
    public static final String aI = "1";
    public static final String aJ = "2";
    public static final String aK = "3";
    public static final String aL = "4";
    public static final String aM = "5";
    public static final String aN = "6";
    public static final String aO = "7";
    public static final String aP = "8";
    public static int aQ = 1;
    public static int aR = 0;
    private static final String aS = "VideoReportData";
    public static final String aa = "video_length";
    public static final String ab = "offer_url";
    public static final String ac = "reason";
    public static final String ad = "case";
    public static final String ae = "time";
    public static final String af = "platform";
    public static final String ag = "duration";
    public static final String ah = "result";
    public static final String ai = "video_size";
    public static final String aj = "ctype";
    public static final String ak = "unit_id";
    public static final String al = "cid";
    public static final String am = "endscreen_type";
    public static final String an = "error";
    public static final String ao = "template_url";
    public static final String ap = "template";
    public static final String aq = "aback";
    public static final String ar = "event";
    public static final String as = "layout";
    public static final String at = "type";
    public static final String au = "endcard_url";
    public static final String av = "video_url";
    public static final String aw = "template_url";
    public static final String ax = "rid";
    public static final String ay = "rid_n";
    public static final String az = "image_url";
    public static final String b = "2000021";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f10356c = "2000054";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f10357d = "2000022";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f10358e = "2000023";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f10359f = "2000024";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f10360g = "2000025";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f10361h = "2000030";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f10362i = "2000037";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f10363j = "2000039";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f10364k = "2000043";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f10365l = "2000044";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f10366m = "2000045";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f10367n = "2000060";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f10368o = "2000059";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f10369p = "2000063";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f10370q = "2000061";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f10371r = "2000062";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f10372s = "2000073";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f10373t = "2000074";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f10374u = "2000075";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f10375v = "2000076";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f10376w = 14;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f10377x = 2;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f10378y = 3;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f10379z = 20;
    private String aT;
    private String aU;
    private String aV;
    private String aW;
    private int aX;
    private String aY;
    private int aZ;
    private String bA;
    private int bB;
    private int bC;
    private int ba;
    private int bb;
    private String bc;
    private String bd;
    private int be;
    private int bf;
    private String bg;
    private long bh;
    private int bi;
    private int bj;
    private String bk;
    private String bl;
    private String bm;
    private String bn;
    private int bo;
    private String bp;
    private String bq;
    private String br;
    private String bs;
    private String bt;
    private String bu;
    private String bv;
    private String bw;
    private String bx;
    private String by;
    private String bz;

    private r(String str, int i2, int i3, int i4, int i5, String str2, String str3, int i6, String str4, int i7, String str5) {
        this.bj = 0;
        this.bB = 0;
        this.aW = str;
        this.aX = i2;
        this.aY = str5;
        this.aZ = i3;
        this.ba = i4;
        this.bb = i5;
        try {
            if (!TextUtils.isEmpty(str2)) {
                this.bc = URLEncoder.encode(str2, com.anythink.expressad.foundation.g.a.bN);
            }
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        this.bd = str3;
        this.bf = i6;
        this.bg = str4;
        this.bh = i7;
    }

    private int A() {
        return this.ba;
    }

    private int B() {
        return this.bb;
    }

    private String C() {
        return this.bc;
    }

    private String D() {
        return TextUtils.isEmpty(this.bd) ? "" : this.bd;
    }

    private String E() {
        return this.bg;
    }

    private long F() {
        return this.bh;
    }

    private int G() {
        return this.aX;
    }

    private String H() {
        return this.aY;
    }

    private int I() {
        return this.aZ;
    }

    private int J() {
        return this.bf;
    }

    private int a() {
        return this.be;
    }

    private String b() {
        return this.aT;
    }

    private String c() {
        return this.aU;
    }

    private String d() {
        return this.aV;
    }

    private void e(int i2) {
        this.be = i2;
    }

    private String f() {
        return this.by;
    }

    private String g() {
        return this.bx;
    }

    private String h() {
        return this.bw;
    }

    private String i() {
        return this.bA;
    }

    private int j() {
        return this.bj;
    }

    private void k(String str) {
        this.aT = str;
    }

    private void l(String str) {
        this.aU = str;
    }

    private void m(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.aV = URLEncoder.encode(str);
    }

    private void n(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.bz = URLEncoder.encode(str, com.anythink.expressad.foundation.g.a.bN);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void o(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.by = URLEncoder.encode(str, com.anythink.expressad.foundation.g.a.bN);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void p(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.bx = URLEncoder.encode(str, com.anythink.expressad.foundation.g.a.bN);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void q(String str) {
        this.bw = str;
    }

    private void r(String str) {
        this.bs = str;
    }

    private void s(String str) {
        this.bq = str;
    }

    private void t(String str) {
        this.bt = str;
    }

    private void u(String str) {
        this.bu = str;
    }

    private void v(String str) {
        this.bv = str;
    }

    private String w() {
        return this.bm;
    }

    private String x() {
        return this.bn;
    }

    private int y() {
        return this.bo;
    }

    private String z() {
        return this.aW;
    }

    public final String toString() {
        return "RewardReportData [key=" + this.aW + ", networkType=" + this.aX + ", isCompleteView=" + this.aZ + ", watchedMillis=" + this.ba + ", videoLength=" + this.bb + ", offerUrl=" + this.bc + ", reason=" + this.bd + ", result=" + this.bf + ", duration=" + this.bg + ", videoSize=" + this.bh + "]";
    }

    private String e() {
        return this.bz;
    }

    private void f(int i2) {
        this.bj = i2;
    }

    private void g(int i2) {
        this.bi = i2;
    }

    private void h(int i2) {
        this.bo = i2;
    }

    private void i(int i2) {
        this.ba = i2;
    }

    private void j(int i2) {
        this.bb = i2;
    }

    private int k() {
        return this.bi;
    }

    private String l() {
        return this.bp;
    }

    private String q() {
        return this.bu;
    }

    private String r() {
        return this.bv;
    }

    private int s() {
        return this.bB;
    }

    private int t() {
        return this.bC;
    }

    private String u() {
        return this.bk;
    }

    private String v() {
        return this.bl;
    }

    private void w(String str) {
        this.bc = str;
    }

    private void x(String str) {
        this.bg = str;
    }

    public final void a(String str) {
        this.bA = str;
    }

    public final void b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.bp = URLEncoder.encode(str, com.anythink.expressad.foundation.g.a.bN);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
    }

    public final void c(String str) {
        this.br = str;
    }

    public final void d(String str) {
        this.bk = str;
    }

    private void k(int i2) {
        this.bh = i2;
    }

    private void l(int i2) {
        this.aZ = i2;
    }

    private String m() {
        return this.br;
    }

    public final void a(int i2) {
        this.bB = i2;
    }

    public final void c(int i2) {
        this.aX = i2;
    }

    public final void d(int i2) {
        this.bf = i2;
    }

    public final void e(String str) {
        this.bl = str;
    }

    public final void f(String str) {
        this.bm = str;
    }

    public final void g(String str) {
        this.bn = str;
    }

    public final void h(String str) {
        this.aW = str;
    }

    public final void i(String str) {
        this.bd = str;
    }

    public final void j(String str) {
        this.aY = str;
    }

    private static String a(List<r> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (r rVar : list) {
            stringBuffer.append("key=" + rVar.aW + DispatchConstants.SIGN_SPLIT_SYMBOL);
            stringBuffer.append("result=" + rVar.bf + DispatchConstants.SIGN_SPLIT_SYMBOL);
            stringBuffer.append("duration=" + rVar.bg + DispatchConstants.SIGN_SPLIT_SYMBOL);
            stringBuffer.append("endcard_url=" + rVar.bx + DispatchConstants.SIGN_SPLIT_SYMBOL);
            stringBuffer.append("cid=" + rVar.bn + DispatchConstants.SIGN_SPLIT_SYMBOL);
            stringBuffer.append("unit_id=" + rVar.bm + DispatchConstants.SIGN_SPLIT_SYMBOL);
            stringBuffer.append("reason=" + rVar.D() + DispatchConstants.SIGN_SPLIT_SYMBOL);
            stringBuffer.append("ad_type=" + rVar.bA + DispatchConstants.SIGN_SPLIT_SYMBOL);
            stringBuffer.append("rid=" + rVar.bk + DispatchConstants.SIGN_SPLIT_SYMBOL);
            stringBuffer.append("rid_n=" + rVar.bl + DispatchConstants.SIGN_SPLIT_SYMBOL);
            stringBuffer.append("type=" + rVar.bw + DispatchConstants.SIGN_SPLIT_SYMBOL);
            StringBuilder sb = new StringBuilder("adspace_t=");
            sb.append(rVar.bC);
            stringBuffer.append(sb.toString());
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }

    private static String c(r rVar) {
        if (rVar == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=" + rVar.aW + DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("cid=" + rVar.bn + DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("unit_id=" + rVar.bm + DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("network_type=" + rVar.aX + DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("mraid_type=" + rVar.bB + DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("rid_n=" + rVar.bl + DispatchConstants.SIGN_SPLIT_SYMBOL);
        StringBuilder sb = new StringBuilder("rid=");
        sb.append(rVar.bk);
        stringBuffer.append(sb.toString());
        stringBuffer.append("\n");
        return stringBuffer.toString();
    }

    private static String d(r rVar) {
        if (rVar == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=" + rVar.aW + DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("result=" + rVar.bf + DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("duration=" + rVar.bg + DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("cid=" + rVar.bn + DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("reason=" + rVar.D() + DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("ad_type=" + rVar.bA + DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("unit_id=" + rVar.bm + DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("devid=" + rVar.aU + DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("mraid_type=" + rVar.bB + DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("network_type=" + rVar.aX + DispatchConstants.SIGN_SPLIT_SYMBOL);
        if (!TextUtils.isEmpty(rVar.bx)) {
            stringBuffer.append("endcard_url=" + rVar.bx + DispatchConstants.SIGN_SPLIT_SYMBOL);
        }
        if (!TextUtils.isEmpty(rVar.bw)) {
            stringBuffer.append("type=" + rVar.bw + DispatchConstants.SIGN_SPLIT_SYMBOL);
        }
        if (rVar.aT != null) {
            stringBuffer.append("resource_type=" + rVar.aT + DispatchConstants.SIGN_SPLIT_SYMBOL);
        }
        stringBuffer.append("rid_n=" + rVar.bl + DispatchConstants.SIGN_SPLIT_SYMBOL);
        StringBuilder sb = new StringBuilder("rid=");
        sb.append(rVar.bk);
        stringBuffer.append(sb.toString());
        stringBuffer.append("\n");
        return stringBuffer.toString();
    }

    private static String e(r rVar) {
        if (rVar == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=" + rVar.aW + DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("result=" + rVar.bf + DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("duration=" + rVar.bg + DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("cid=" + rVar.bn + DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("unit_id=" + rVar.bm + DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("reason=" + rVar.D() + DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("ad_type=" + rVar.bA + DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("rid=" + rVar.bk + DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("rid_n=" + rVar.bl + DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("network_type=" + rVar.aX + DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("mraid_type=" + rVar.bB + DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("devid=" + rVar.aU + DispatchConstants.SIGN_SPLIT_SYMBOL);
        if (rVar.aT != null) {
            stringBuffer.append("resource_type=" + rVar.aT + DispatchConstants.SIGN_SPLIT_SYMBOL);
        }
        if (!TextUtils.isEmpty(rVar.bx)) {
            stringBuffer.append("endcard_url=" + rVar.bx + DispatchConstants.SIGN_SPLIT_SYMBOL);
        }
        stringBuffer.append("type=" + rVar.bw);
        return stringBuffer.toString();
    }

    private static String f(r rVar) {
        if (rVar == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=" + rVar.aW + DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("cid=" + rVar.bn + DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("rid=" + rVar.bk + DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("rid_n=" + rVar.bl + DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("unit_id=" + rVar.bm + DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("network_type=" + rVar.aX + DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("mraid_type=" + rVar.bB + DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("platform=1");
        return stringBuffer.toString();
    }

    private static String g(r rVar) {
        if (rVar == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=" + rVar.aW + DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("cid=" + rVar.bn + DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("rid=" + rVar.bk + DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("rid_n=" + rVar.bl + DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("unit_id=" + rVar.bm + DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("reason=" + rVar.D() + DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("case=" + rVar.be + DispatchConstants.SIGN_SPLIT_SYMBOL);
        StringBuilder sb = new StringBuilder("network_type=");
        sb.append(rVar.aX);
        stringBuffer.append(sb.toString());
        return stringBuffer.toString();
    }

    private String n() {
        return this.bs;
    }

    private String o() {
        return this.bq;
    }

    private String p() {
        return this.bt;
    }

    public final void b(int i2) {
        this.bC = i2;
    }

    private static String b(r rVar) {
        if (rVar == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=" + rVar.aW + DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("cid=" + rVar.bn + DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("unit_id=" + rVar.bm + DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("network_type=" + rVar.aX + DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("rid=" + rVar.bk + DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("rid_n=" + rVar.bl + DispatchConstants.SIGN_SPLIT_SYMBOL);
        StringBuilder sb = new StringBuilder("reason=");
        sb.append(rVar.D());
        stringBuffer.append(sb.toString());
        stringBuffer.append("\n");
        return stringBuffer.toString();
    }

    public r() {
        this.bj = 0;
        this.bB = 0;
    }

    private r(String str, int i2, int i3, String str2, int i4, int i5, String str3) {
        this.bj = 0;
        this.bB = 0;
        this.aW = str;
        this.aX = i2;
        this.aY = str3;
        this.bb = i3;
        if (!TextUtils.isEmpty(str2)) {
            try {
                this.bc = URLEncoder.encode(str2, com.anythink.expressad.foundation.g.a.bN);
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        this.bi = i4;
        this.bj = i5;
    }

    private static String b(List<r> list) {
        if (list == null) {
            return null;
        }
        try {
            if (list.size() <= 0) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer();
            Iterator<r> it = list.iterator();
            while (it.hasNext()) {
                stringBuffer.append(it.next().bv);
                stringBuffer.append("\n");
            }
            return stringBuffer.toString();
        } catch (Throwable th) {
            com.anythink.expressad.foundation.h.o.b(aS, th.getMessage(), th);
            return null;
        }
    }

    private r(String str, int i2, int i3, int i4, int i5, String str2, int i6, String str3) {
        this.bj = 0;
        this.bB = 0;
        this.aW = str;
        this.aY = str3;
        this.aX = i2;
        this.aZ = i3;
        this.ba = i4;
        this.bb = i5;
        if (!TextUtils.isEmpty(str2)) {
            try {
                this.bc = URLEncoder.encode(str2, com.anythink.expressad.foundation.g.a.bN);
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        this.bj = i6;
    }

    public static String a(r rVar) {
        String str;
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=" + rVar.aW + DispatchConstants.SIGN_SPLIT_SYMBOL);
            stringBuffer.append("error=" + t.c(rVar.br) + DispatchConstants.SIGN_SPLIT_SYMBOL);
            stringBuffer.append("template_url=" + t.c(rVar.bp) + DispatchConstants.SIGN_SPLIT_SYMBOL);
            stringBuffer.append("unit_id=" + t.c(rVar.bm) + DispatchConstants.SIGN_SPLIT_SYMBOL);
            stringBuffer.append("cid=" + t.c(rVar.bn) + DispatchConstants.SIGN_SPLIT_SYMBOL);
            String str2 = "";
            if (TextUtils.isEmpty(rVar.aY)) {
                str = "";
            } else {
                str = "network_str=" + rVar.aY + DispatchConstants.SIGN_SPLIT_SYMBOL;
            }
            stringBuffer.append(str);
            if (!TextUtils.isEmpty(rVar.aY)) {
                str2 = "network_type=" + rVar.aX;
            }
            stringBuffer.append(str2);
            return stringBuffer.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private r(String str, int i2, String str2, String str3, String str4) {
        this.bj = 0;
        this.bB = 0;
        this.aW = str;
        this.aY = str4;
        this.aX = i2;
        if (!TextUtils.isEmpty(str2)) {
            try {
                this.bc = URLEncoder.encode(str2, com.anythink.expressad.foundation.g.a.bN);
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        this.bd = str3;
    }

    private r(String str, int i2, int i3, String str2, int i4, String str3, int i5, String str4) {
        this.bj = 0;
        this.bB = 0;
        this.aW = str;
        this.aX = i2;
        this.aY = str4;
        this.bb = i3;
        if (!TextUtils.isEmpty(str2)) {
            try {
                this.bc = URLEncoder.encode(str2, com.anythink.expressad.foundation.g.a.bN);
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        this.bf = i4;
        this.bg = str3;
        this.bh = i5;
    }

    private r(Context context, c cVar, int i2, String str, long j2, int i3) {
        this.bj = 0;
        this.bB = 0;
        if (i3 == 1 || i3 == 287 || i3 == 94) {
            this.aW = f10357d;
        } else if (i3 == 95) {
            this.aW = f10360g;
        }
        this.aX = com.anythink.expressad.foundation.h.k.a();
        this.aY = com.anythink.expressad.foundation.h.k.a(context, this.aX);
        this.bb = cVar.bi();
        this.bk = cVar.Z();
        this.bl = cVar.aa();
        if (!TextUtils.isEmpty(this.bc)) {
            try {
                this.bc = URLEncoder.encode(cVar.ah() == null ? cVar.ad() : cVar.ah(), com.anythink.expressad.foundation.g.a.bN);
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        this.bf = i2;
        this.bg = str;
        this.bh = j2 == 0 ? cVar.T() : j2;
    }

    private r(String str, String str2, String str3, String str4, int i2, String str5, int i3, String str6) {
        this.bj = 0;
        this.bB = 0;
        this.aW = str;
        this.bk = str2;
        this.bl = str3;
        this.bm = str4;
        this.aX = i2;
        this.aY = str6;
        this.bn = str5;
        this.bo = i3;
    }

    public r(String str, String str2, String str3, String str4, String str5, String str6, int i2, String str7) {
        this.bj = 0;
        this.bB = 0;
        this.aW = str;
        this.bt = str2;
        this.bq = str3;
        this.bu = str4;
        this.bm = str5;
        this.bn = str6;
        this.aX = i2;
        this.aY = str7;
    }

    private r(String str) {
        this.bj = 0;
        this.bB = 0;
        this.bv = str;
    }

    public r(String str, int i2, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.bj = 0;
        this.bB = 0;
        this.aW = str;
        this.bf = i2;
        this.bg = str2;
        try {
            if (!TextUtils.isEmpty(str3)) {
                this.bx = URLEncoder.encode(str3, com.anythink.expressad.foundation.g.a.bN);
            }
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        this.bn = str4;
        this.bm = str5;
        this.bd = str6;
        this.bw = str7;
        if (Integer.valueOf(str2).intValue() > com.anythink.expressad.foundation.g.a.cq) {
            this.bf = 2;
        }
    }

    public r(String str, String str2, String str3, String str4, String str5, int i2) {
        this.bj = 0;
        this.bB = 0;
        this.aW = str;
        this.bn = str2;
        this.bk = str3;
        this.bl = str4;
        this.bm = str5;
        this.aX = i2;
    }

    public r(String str, String str2, String str3, String str4, String str5, int i2, int i3, String str6) {
        this.bj = 0;
        this.bB = 0;
        this.aW = str;
        this.bn = str2;
        this.bk = str3;
        this.bl = str4;
        this.bm = str5;
        this.aX = i2;
        this.bd = str6;
        this.be = i3;
    }
}
