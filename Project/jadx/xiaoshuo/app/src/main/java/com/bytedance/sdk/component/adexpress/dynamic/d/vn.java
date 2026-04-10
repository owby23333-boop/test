package com.bytedance.sdk.component.adexpress.dynamic.d;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.common.base.Ascii;
import com.yuewen.w51;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.io.encoding.Base64;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class vn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f2086a;
    private String aq;
    private int as;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double f2087b;
    private int bc;
    private float bf;
    private String bh;
    private int bm;
    private int br;
    private int bx;
    private boolean c;
    private String cv;
    private float d;
    private String dt;
    private float e;
    private int em;
    private boolean en;
    private int ev;
    private int ey;
    private String f;
    private int fa;
    private boolean fl;
    private int ft;
    private boolean fy;
    private List<e> g;
    private boolean ga;
    private int h;
    private int hb;
    private String i;
    private JSONObject in;
    private int j;
    private int jk;
    private String k;
    private String kt;
    private String l;
    private String lc;
    private JSONObject lg;
    private boolean lw;
    private float m;
    private boolean n;
    private String nt;
    private boolean ot;
    private long ou;
    private int ov;
    private float p;
    private String pe;
    private int pl;
    private int q;
    private int r;
    private boolean rb;
    private String rk;
    private boolean rm;
    private boolean rt;
    private int rw;
    private String s;
    private boolean sq;
    private String t;
    private float tg;
    private String tk;
    private boolean tu;
    private int tv;
    private int tx;
    private int ue;
    private String uk;
    private String uo;
    private int uq;
    private float v;
    private int vd;
    private int vg;
    private boolean vm;
    private float vn;
    private int vs;
    private int vu;
    private String w;
    private String wl;
    private double wu;
    private int x;
    private int xn;
    private double xu;
    private boolean xy;
    private String y;
    private int ya;
    private int yf;
    private boolean yl;
    private String yq;
    private int ys;
    private String z;
    private String za;
    private int zb;
    private float zk;
    private double zo;
    private JSONObject zr;

    public static vn e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        vn vnVar = new vn();
        vnVar.bf(jSONObject.optString("adType", "embeded"));
        vnVar.t(jSONObject.optString("clickArea", "creative"));
        vnVar.s(jSONObject.optString("clickTigger", "click"));
        vnVar.d(jSONObject.optString(TtmlNode.ATTR_TTS_FONT_FAMILY, "PingFangSC"));
        vnVar.tg(jSONObject.optString(TtmlNode.ATTR_TTS_TEXT_ALIGN, "left"));
        vnVar.ga(jSONObject.optString("color", "#999999"));
        vnVar.vn(jSONObject.optString("bgColor", "transparent"));
        vnVar.p(jSONObject.optString("bgImgUrl", ""));
        vnVar.v(jSONObject.optString("borderColor", "#000000"));
        vnVar.zk(jSONObject.optString("borderStyle", "solid"));
        vnVar.m(jSONObject.optString("heightMode", "auto"));
        vnVar.wu(jSONObject.optString("widthMode", "fixed"));
        vnVar.xu(jSONObject.optString("interactText", ""));
        vnVar.bh(jSONObject.optString("interactType", ""));
        vnVar.ga(jSONObject.optInt("interactSlideDirection", -1));
        vnVar.w(jSONObject.optString("justifyHorizontal", "space-around"));
        vnVar.l(jSONObject.optString("justifyVertical", "flex-start"));
        vnVar.bf(jSONObject.optDouble("timingStart"));
        vnVar.d(jSONObject.optDouble("timingEnd"));
        vnVar.tg((float) jSONObject.optDouble("width", w51.l));
        vnVar.d((float) jSONObject.optDouble("height", w51.l));
        vnVar.e((float) jSONObject.optDouble("borderRadius", w51.l));
        vnVar.bf((float) jSONObject.optDouble("borderSize", w51.l));
        vnVar.e(jSONObject.optBoolean("interactValidate", false));
        vnVar.zk((float) jSONObject.optDouble(TtmlNode.ATTR_TTS_FONT_SIZE, w51.l));
        vnVar.ga((float) jSONObject.optDouble("paddingBottom", w51.l));
        vnVar.vn((float) jSONObject.optDouble("paddingLeft", w51.l));
        vnVar.p((float) jSONObject.optDouble("paddingRight", w51.l));
        vnVar.v((float) jSONObject.optDouble("paddingTop", w51.l));
        vnVar.bf(jSONObject.optBoolean("lineFeed", false));
        vnVar.p(jSONObject.optInt("lineCount", 0));
        vnVar.tg(jSONObject.optDouble("lineHeight", 1.2d));
        vnVar.xu(jSONObject.optInt("letterSpacing", 0));
        vnVar.d(jSONObject.optBoolean("isDataFixed", false));
        vnVar.bh(jSONObject.optInt(TtmlNode.ATTR_TTS_FONT_WEIGHT));
        vnVar.tg(jSONObject.optBoolean("lineLimit"));
        vnVar.t(jSONObject.optInt("position"));
        vnVar.f(jSONObject.optString("align"));
        vnVar.ga(jSONObject.optBoolean("useLeft"));
        vnVar.vn(jSONObject.optBoolean("useRight"));
        vnVar.p(jSONObject.optBoolean("useTop"));
        vnVar.v(jSONObject.optBoolean("useBottom"));
        vnVar.k(jSONObject.optString("data"));
        vnVar.m(jSONObject.optInt("marginLeft"));
        vnVar.wu(jSONObject.optInt("marginRight"));
        vnVar.v(jSONObject.optInt("marginTop"));
        vnVar.zk(jSONObject.optInt("marginBottom"));
        vnVar.s(jSONObject.optInt("tagMaxCount"));
        vnVar.zk(jSONObject.optBoolean("allowTextFlow"));
        vnVar.w(jSONObject.optInt("textFlowType"));
        vnVar.l(jSONObject.optInt("textFlowDuration"));
        vnVar.f(jSONObject.optInt("left"));
        vnVar.k(jSONObject.optInt("right"));
        vnVar.dt(jSONObject.optInt("top"));
        vnVar.pe(jSONObject.optInt("bottom"));
        vnVar.dt(jSONObject.optString("alignItems", "flex-start"));
        vnVar.y(jSONObject.optInt("zIndex"));
        vnVar.a(jSONObject.optInt("interactVisibleTime"));
        vnVar.cv(jSONObject.optInt("interactHiddenTime"));
        vnVar.wu(jSONObject.optBoolean("interactEnableMask"));
        vnVar.xu(jSONObject.optBoolean("interactWontHide"));
        vnVar.e(jSONObject.optString("bgGradient"));
        vnVar.fy(jSONObject.optInt("areaType"));
        vnVar.h(jSONObject.optInt("interactSlideThreshold", 0));
        vnVar.bx(jSONObject.optInt("interactBottomDistance", 120));
        vnVar.w(jSONObject.optBoolean("openPlayableLandingPage", false));
        vnVar.bf(jSONObject.optJSONObject("video"));
        vnVar.d(jSONObject.optJSONObject("image"));
        vnVar.x(jSONObject.optInt("borderShadowExtent"));
        vnVar.bh(jSONObject.optBoolean("bgGauseBlur"));
        vnVar.hb(jSONObject.optInt("bgGauseBlurRadius"));
        vnVar.t(jSONObject.optBoolean("showTimeProgress", false));
        vnVar.s(jSONObject.optBoolean("showPlayButton", false));
        vnVar.e(jSONObject.optDouble("bgColorCg", w51.l));
        vnVar.vn(jSONObject.optInt("bgMaterialCenterCalcColor", 0));
        vnVar.bf(jSONObject.optInt("borderTopLeftRadius", 0));
        vnVar.e(jSONObject.optInt("borderTopRightRadius", 0));
        vnVar.tg(jSONObject.optInt("borderBottomLeftRadius", 0));
        vnVar.d(jSONObject.optInt("borderBottomRightRadius", 0));
        vnVar.tg(jSONObject.optJSONObject("interactI18n"));
        vnVar.y(jSONObject.optString("imageObjectFit"));
        vnVar.cv(jSONObject.optString("interactTitle"));
        vnVar.uk(jSONObject.optInt("interactTextPositionTop"));
        vnVar.pe(jSONObject.optString("imageLottieTosPath"));
        vnVar.m(jSONObject.optBoolean("animationsLoop"));
        vnVar.wl(jSONObject.optInt("lottieAppNameMaxLength"));
        vnVar.lc(jSONObject.optInt("lottieAdDescMaxLength"));
        vnVar.za(jSONObject.optInt("lottieAdTitleMaxLength"));
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("animations");
            if (jSONArrayOptJSONArray != null) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
                    e eVar = new e();
                    eVar.d(jSONObject2.optString("animationType"));
                    eVar.e(jSONObject2.optDouble("animationDuration"));
                    eVar.bf(jSONObject2.optDouble("animationScaleX"));
                    eVar.d(jSONObject2.optDouble("animationScaleY"));
                    eVar.tg(jSONObject2.optString("animationTimeFunction"));
                    eVar.tg(jSONObject2.optDouble("animationDelay"));
                    eVar.vn(jSONObject2.optInt("animationIterationCount"));
                    eVar.ga(jSONObject2.optString("animationDirection"));
                    eVar.ga(jSONObject2.optDouble("animationInterval"));
                    eVar.e(jSONObject2.optInt("animationBorderWidth"));
                    eVar.e(jSONObject2.optLong("key"));
                    eVar.bf(jSONObject2.optInt("animationEffectWidth"));
                    eVar.d(jSONObject2.optInt("animationSwing", 1));
                    eVar.tg(jSONObject2.optInt("animationTranslateX"));
                    eVar.ga(jSONObject2.optInt("animationTranslateY"));
                    eVar.bf(jSONObject2.optString("animationRippleBackgroundColor"));
                    eVar.e(jSONObject2.optString("animationScaleDirection"));
                    eVar.p(jSONObject2.optInt("animationFadeStart"));
                    eVar.v(jSONObject2.optInt("animationFadeEnd"));
                    eVar.vn(jSONObject2.optString("animationFillMode"));
                    eVar.zk(jSONObject2.optInt("animationBounceHeight"));
                    if (vnVar.f() > w51.l) {
                        eVar.tg(eVar.t() + vnVar.f());
                    }
                    arrayList.add(eVar);
                }
                vnVar.e(arrayList);
            }
            if (jSONObject.has("triggerSlideDirection")) {
                vnVar.wl(jSONObject.optString("triggerSlideDirection", "0"));
                vnVar.e(jSONObject.optLong("triggerSlideMinDistance", 0L));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vnVar;
    }

    public String a() {
        return this.cv;
    }

    public String aq() {
        return this.rk;
    }

    public boolean as() {
        return this.lw;
    }

    public int b() {
        return this.x;
    }

    public void bc() {
        e(this, this.zr);
    }

    public int bf() {
        return this.rw;
    }

    public float bh() {
        return this.vn;
    }

    public int bm() {
        return this.h;
    }

    public int br() {
        return this.vg;
    }

    public boolean bx() {
        return this.fy;
    }

    public int c() {
        return this.pl;
    }

    public String cv() {
        return this.f;
    }

    public int d() {
        return this.ys;
    }

    public String dt() {
        return this.s;
    }

    public int em() {
        return this.vu;
    }

    public void en() {
        e(this, this.lg);
    }

    public int ev() {
        return this.ft;
    }

    public boolean ey() {
        return this.tu;
    }

    public double f() {
        return this.wu;
    }

    public String fa() {
        return this.uo;
    }

    public boolean fl() {
        return this.ot;
    }

    public boolean ft() {
        return this.fl;
    }

    public String fy() {
        return this.za;
    }

    public String g() {
        return this.z;
    }

    public JSONObject ga() {
        return this.in;
    }

    public String h() {
        return this.lc;
    }

    public String hb() {
        return this.uk;
    }

    public boolean i() {
        return this.rm;
    }

    public int in() {
        return this.zb;
    }

    public int j() {
        return this.r;
    }

    public int jk() {
        return this.xn;
    }

    public double k() {
        return this.xu;
    }

    public float l() {
        return this.m;
    }

    public String lc() {
        return this.y;
    }

    public String lg() {
        return this.aq;
    }

    public int lw() {
        return this.bc;
    }

    public float m() {
        return this.e;
    }

    public String n() {
        return this.i;
    }

    public boolean nt() {
        return this.yl;
    }

    public int ot() {
        return this.j;
    }

    public int ov() {
        return this.uq;
    }

    public double p() {
        return this.zo;
    }

    public String pe() {
        return this.w;
    }

    public int pl() {
        return this.vs;
    }

    public int q() {
        return this.bm;
    }

    public int r() {
        return this.hb;
    }

    public boolean rb() {
        return this.rt;
    }

    public int rk() {
        return this.tx;
    }

    public int rm() {
        return this.bx;
    }

    public double rt() {
        return this.f2087b;
    }

    public boolean rw() {
        return this.xy;
    }

    public float s() {
        return this.v;
    }

    public int sq() {
        return this.vd;
    }

    public float t() {
        return this.p;
    }

    public int tg() {
        return this.br;
    }

    public int tu() {
        return this.em;
    }

    public List<e> tv() {
        return this.g;
    }

    public int tx() {
        return this.ev;
    }

    public int ue() {
        return this.ya;
    }

    public String uk() {
        return this.wl;
    }

    public boolean uq() {
        return this.n;
    }

    public int v() {
        return this.as;
    }

    public long vd() {
        return this.ou;
    }

    public boolean vg() {
        return this.vm;
    }

    public JSONObject vm() {
        return this.zr;
    }

    public int vn() {
        return this.tv;
    }

    public int vs() {
        return this.ov;
    }

    public int vu() {
        return this.yf;
    }

    public float w() {
        return this.zk;
    }

    public String wl() {
        return this.k;
    }

    public float wu() {
        return this.bf;
    }

    public String x() {
        return this.f2086a;
    }

    public boolean xn() {
        return this.en;
    }

    public boolean xu() {
        return this.ga;
    }

    public int xy() {
        return this.fa;
    }

    public String y() {
        return this.l;
    }

    public boolean ya() {
        return this.rb;
    }

    public String yf() {
        return this.nt;
    }

    public int yl() {
        return this.q;
    }

    public String yq() {
        return this.kt;
    }

    public boolean ys() {
        return this.sq;
    }

    public int z() {
        return this.ue;
    }

    public String za() {
        return this.pe;
    }

    public String zb() {
        return this.yq;
    }

    public String zk() {
        return this.tk;
    }

    public boolean zo() {
        return this.c;
    }

    public int zr() {
        return this.ey;
    }

    public void a(int i) {
        this.em = i;
    }

    public void bf(int i) {
        this.rw = i;
    }

    public void bh(String str) {
        this.wl = str;
    }

    public void bx(int i) {
        this.vg = i;
    }

    public void cv(int i) {
        this.vs = i;
    }

    public void d(int i) {
        this.ys = i;
    }

    public void dt(int i) {
        this.ov = i;
    }

    public void f(String str) {
        this.i = str;
    }

    public void fy(int i) {
        this.tx = i;
    }

    public void ga(int i) {
        this.tv = i;
    }

    public void h(int i) {
        this.pl = i;
    }

    public void hb(int i) {
        this.xn = i;
    }

    public void k(String str) {
        this.nt = str;
    }

    public void l(String str) {
        this.uk = str;
    }

    public void lc(int i) {
        this.vd = i;
    }

    public void m(String str) {
        this.pe = str;
    }

    public void p(float f) {
        this.v = f;
    }

    public void pe(int i) {
        this.vu = i;
    }

    public void s(String str) {
        this.lc = str;
    }

    public void t(String str) {
        this.za = str;
    }

    public void tg(int i) {
        this.br = i;
    }

    public void uk(int i) {
        this.ey = i;
    }

    public void v(float f) {
        this.zk = f;
    }

    public void vn(int i) {
        this.as = i;
    }

    public void w(String str) {
        this.f2086a = str;
    }

    public void wl(int i) {
        this.bc = i;
    }

    public void wu(String str) {
        this.y = str;
    }

    public void x(int i) {
        this.zb = i;
    }

    public void xu(String str) {
        this.cv = str;
    }

    public void y(int i) {
        this.ev = i;
    }

    public void za(int i) {
        this.fa = i;
    }

    public void zk(float f) {
        this.m = f;
    }

    public void bf(float f) {
        this.bf = f;
    }

    public void bh(int i) {
        this.q = i;
    }

    public void cv(String str) {
        this.kt = str;
    }

    public void d(float f) {
        this.d = f;
    }

    public void dt(String str) {
        this.z = str;
    }

    public void f(int i) {
        this.ue = i;
    }

    public void ga(float f) {
        this.vn = f;
    }

    public void k(int i) {
        this.ft = i;
    }

    public void l(int i) {
        this.yf = i;
    }

    public void m(int i) {
        this.bx = i;
    }

    public void p(String str) {
        this.f = str;
    }

    public void pe(String str) {
        this.yq = str;
    }

    public void s(int i) {
        this.ya = i;
    }

    public void t(int i) {
        this.j = i;
    }

    public void tg(float f) {
        this.tg = f;
    }

    public void v(String str) {
        this.k = str;
    }

    public void vn(float f) {
        this.p = f;
    }

    public void w(int i) {
        this.uq = i;
    }

    public void wl(String str) {
        this.uo = str;
    }

    public void wu(int i) {
        this.bm = i;
    }

    public void xu(int i) {
        this.r = i;
    }

    public void y(String str) {
        this.aq = str;
    }

    public void zk(String str) {
        this.dt = str;
    }

    public void bf(double d) {
        this.wu = d;
    }

    public void bh(boolean z) {
        this.lw = z;
    }

    public void d(double d) {
        this.xu = d;
    }

    public void ga(String str) {
        this.w = str;
    }

    public void m(boolean z) {
        this.en = z;
    }

    public void p(int i) {
        this.h = i;
    }

    public void s(boolean z) {
        this.sq = z;
    }

    public void t(boolean z) {
        this.xy = z;
    }

    public void tg(String str) {
        this.s = str;
    }

    public void v(int i) {
        this.x = i;
    }

    public void vn(String str) {
        this.l = str;
    }

    public void w(boolean z) {
        this.tu = z;
    }

    public void wu(boolean z) {
        this.vm = z;
    }

    public void xu(boolean z) {
        this.c = z;
    }

    public void zk(int i) {
        this.hb = i;
    }

    public void bf(String str) {
        this.bh = str;
    }

    public void d(String str) {
        this.t = str;
    }

    public void ga(boolean z) {
        this.yl = z;
    }

    public void p(boolean z) {
        this.ot = z;
    }

    public void tg(double d) {
        this.f2087b = d;
    }

    public void v(boolean z) {
        this.n = z;
    }

    public void vn(boolean z) {
        this.rb = z;
    }

    public void zk(boolean z) {
        this.fl = z;
    }

    public void bf(boolean z) {
        this.fy = z;
    }

    public void d(boolean z) {
        this.rm = z;
    }

    public void tg(boolean z) {
        this.rt = z;
    }

    public void bf(JSONObject jSONObject) {
        this.lg = jSONObject;
    }

    public void d(JSONObject jSONObject) {
        this.zr = jSONObject;
    }

    public void tg(JSONObject jSONObject) {
        this.in = jSONObject;
    }

    public int e() {
        return this.jk;
    }

    public void e(int i) {
        this.jk = i;
    }

    public void e(double d) {
        this.zo = d;
    }

    public void e(String str) {
        this.tk = str;
    }

    public void e(float f) {
        this.e = f;
    }

    public void e(boolean z) {
        this.ga = z;
    }

    public void e(List<e> list) {
        this.g = list;
    }

    public void e(long j) {
        this.ou = j;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void e(vn vnVar, JSONObject jSONObject) {
        if (vnVar == null || jSONObject == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            next.hashCode();
            byte b2 = -1;
            switch (next.hashCode()) {
                case -1965619659:
                    if (next.equals("clickArea")) {
                        b2 = 0;
                    }
                    break;
                case -1912831834:
                    if (next.equals("triggerSlideDirection")) {
                        b2 = 1;
                    }
                    break;
                case -1885934767:
                    if (next.equals("bgImgUrl")) {
                        b2 = 2;
                    }
                    break;
                case -1822062213:
                    if (next.equals("lineCount")) {
                        b2 = 3;
                    }
                    break;
                case -1821293778:
                    if (next.equals("openPlayableLandingPage")) {
                        b2 = 4;
                    }
                    break;
                case -1813937113:
                    if (next.equals("lineLimit")) {
                        b2 = 5;
                    }
                    break;
                case -1501175880:
                    if (next.equals("paddingLeft")) {
                        b2 = 6;
                    }
                    break;
                case -1422965251:
                    if (next.equals("adType")) {
                        b2 = 7;
                    }
                    break;
                case -1383228885:
                    if (next.equals("bottom")) {
                        b2 = 8;
                    }
                    break;
                case -1224696685:
                    if (next.equals(TtmlNode.ATTR_TTS_FONT_FAMILY)) {
                        b2 = 9;
                    }
                    break;
                case -1221029593:
                    if (next.equals("height")) {
                        b2 = 10;
                    }
                    break;
                case -1065511464:
                    if (next.equals(TtmlNode.ATTR_TTS_TEXT_ALIGN)) {
                        b2 = Ascii.VT;
                    }
                    break;
                case -1063257157:
                    if (next.equals("alignItems")) {
                        b2 = Ascii.FF;
                    }
                    break;
                case -1046708884:
                    if (next.equals("interactValidate")) {
                        b2 = Ascii.CR;
                    }
                    break;
                case -1044792121:
                    if (next.equals("marginTop")) {
                        b2 = Ascii.SO;
                    }
                    break;
                case -1019884910:
                    if (next.equals("useBottom")) {
                        b2 = Ascii.SI;
                    }
                    break;
                case -1005195314:
                    if (next.equals("triggerSlideMinDistance")) {
                        b2 = 16;
                    }
                    break;
                case -912366651:
                    if (next.equals("tagMaxCount")) {
                        b2 = 17;
                    }
                    break;
                case -848877971:
                    if (next.equals("interactHiddenTime")) {
                        b2 = 18;
                    }
                    break;
                case -836058546:
                    if (next.equals("useTop")) {
                        b2 = 19;
                    }
                    break;
                case -734428249:
                    if (next.equals(TtmlNode.ATTR_TTS_FONT_WEIGHT)) {
                        b2 = Ascii.DC4;
                    }
                    break;
                case -731417480:
                    if (next.equals("zIndex")) {
                        b2 = Ascii.NAK;
                    }
                    break;
                case -709393864:
                    if (next.equals("timingStart")) {
                        b2 = Ascii.SYN;
                    }
                    break;
                case -515807685:
                    if (next.equals("lineHeight")) {
                        b2 = Ascii.ETB;
                    }
                    break;
                case -321658193:
                    if (next.equals("textFlowDuration")) {
                        b2 = Ascii.CAN;
                    }
                    break;
                case -295409451:
                    if (next.equals("useRight")) {
                        b2 = Ascii.EM;
                    }
                    break;
                case -289173127:
                    if (next.equals("marginBottom")) {
                        b2 = Ascii.SUB;
                    }
                    break;
                case -204859874:
                    if (next.equals("bgColor")) {
                        b2 = Ascii.ESC;
                    }
                    break;
                case -148259282:
                    if (next.equals("useLeft")) {
                        b2 = Ascii.FS;
                    }
                    break;
                case -51738487:
                    if (next.equals("widthMode")) {
                        b2 = Ascii.GS;
                    }
                    break;
                case 115029:
                    if (next.equals("top")) {
                        b2 = Ascii.RS;
                    }
                    break;
                case 3076010:
                    if (next.equals("data")) {
                        b2 = Ascii.US;
                    }
                    break;
                case 3317767:
                    if (next.equals("left")) {
                        b2 = 32;
                    }
                    break;
                case 90130308:
                    if (next.equals("paddingTop")) {
                        b2 = 33;
                    }
                    break;
                case 92903173:
                    if (next.equals("align")) {
                        b2 = 34;
                    }
                    break;
                case 94842723:
                    if (next.equals("color")) {
                        b2 = 35;
                    }
                    break;
                case 108511772:
                    if (next.equals("right")) {
                        b2 = 36;
                    }
                    break;
                case 113126854:
                    if (next.equals("width")) {
                        b2 = 37;
                    }
                    break;
                case 164611121:
                    if (next.equals("timingEnd")) {
                        b2 = 38;
                    }
                    break;
                case 202355100:
                    if (next.equals("paddingBottom")) {
                        b2 = 39;
                    }
                    break;
                case 247204452:
                    if (next.equals("allowTextFlow")) {
                        b2 = 40;
                    }
                    break;
                case 302841174:
                    if (next.equals("interactWontHide")) {
                        b2 = 41;
                    }
                    break;
                case 365601008:
                    if (next.equals(TtmlNode.ATTR_TTS_FONT_SIZE)) {
                        b2 = 42;
                    }
                    break;
                case 428975654:
                    if (next.equals("justifyVertical")) {
                        b2 = 43;
                    }
                    break;
                case 439444041:
                    if (next.equals("interactVisibleTime")) {
                        b2 = 44;
                    }
                    break;
                case 713848971:
                    if (next.equals("paddingRight")) {
                        b2 = 45;
                    }
                    break;
                case 722830999:
                    if (next.equals("borderColor")) {
                        b2 = 46;
                    }
                    break;
                case 737768677:
                    if (next.equals("borderStyle")) {
                        b2 = 47;
                    }
                    break;
                case 747804969:
                    if (next.equals("position")) {
                        b2 = 48;
                    }
                    break;
                case 791643104:
                    if (next.equals("isDataFixed")) {
                        b2 = 49;
                    }
                    break;
                case 975087886:
                    if (next.equals("marginRight")) {
                        b2 = 50;
                    }
                    break;
                case 1110826708:
                    if (next.equals("justifyHorizontal")) {
                        b2 = 51;
                    }
                    break;
                case 1188229042:
                    if (next.equals("lineFeed")) {
                        b2 = 52;
                    }
                    break;
                case 1332036739:
                    if (next.equals("interactText")) {
                        b2 = 53;
                    }
                    break;
                case 1332055696:
                    if (next.equals("interactType")) {
                        b2 = 54;
                    }
                    break;
                case 1349188574:
                    if (next.equals("borderRadius")) {
                        b2 = 55;
                    }
                    break;
                case 1360828714:
                    if (next.equals("clickTigger")) {
                        b2 = 56;
                    }
                    break;
                case 1490178922:
                    if (next.equals("heightMode")) {
                        b2 = 57;
                    }
                    break;
                case 1761274325:
                    if (next.equals("textFlowType")) {
                        b2 = 58;
                    }
                    break;
                case 1824903757:
                    if (next.equals("borderSize")) {
                        b2 = 59;
                    }
                    break;
                case 1970934485:
                    if (next.equals("marginLeft")) {
                        b2 = 60;
                    }
                    break;
                case 2111078717:
                    if (next.equals("letterSpacing")) {
                        b2 = Base64.padSymbol;
                    }
                    break;
            }
            switch (b2) {
                case 0:
                    vnVar.t(jSONObject.optString(next));
                    break;
                case 1:
                    vnVar.wl(jSONObject.optString(next));
                    break;
                case 2:
                    vnVar.p(jSONObject.optString(next));
                    break;
                case 3:
                    vnVar.p(jSONObject.optInt(next));
                    break;
                case 4:
                    vnVar.w(jSONObject.optBoolean(next));
                    break;
                case 5:
                    vnVar.tg(jSONObject.optBoolean(next));
                    break;
                case 6:
                    vnVar.vn((float) jSONObject.optDouble(next));
                    break;
                case 7:
                    vnVar.bf(jSONObject.optString(next));
                    break;
                case 8:
                    vnVar.pe(jSONObject.optInt(next));
                    break;
                case 9:
                    vnVar.d(jSONObject.optString(next));
                    break;
                case 10:
                    vnVar.d((float) jSONObject.optDouble(next));
                    break;
                case 11:
                    vnVar.tg(jSONObject.optString(next));
                    break;
                case 12:
                    vnVar.dt(jSONObject.optString(next));
                    break;
                case 13:
                    vnVar.e(jSONObject.optBoolean(next));
                    break;
                case 14:
                    vnVar.v(jSONObject.optInt(next));
                    break;
                case 15:
                    vnVar.v(jSONObject.optBoolean(next));
                    break;
                case 16:
                    vnVar.e(jSONObject.optLong(next));
                    break;
                case 17:
                    vnVar.s(jSONObject.optInt(next));
                    break;
                case 18:
                    vnVar.cv(jSONObject.optInt(next));
                    break;
                case 19:
                    vnVar.p(jSONObject.optBoolean(next));
                    break;
                case 20:
                    vnVar.bh(jSONObject.optInt(next));
                    break;
                case 21:
                    vnVar.y(jSONObject.optInt(next));
                    break;
                case 22:
                    vnVar.bf(jSONObject.optDouble(next));
                    break;
                case 23:
                    vnVar.tg(jSONObject.optDouble(next));
                    break;
                case 24:
                    vnVar.l(jSONObject.optInt(next));
                    break;
                case 25:
                    vnVar.vn(jSONObject.optBoolean(next));
                    break;
                case 26:
                    vnVar.zk(jSONObject.optInt(next));
                    break;
                case 27:
                    vnVar.vn(jSONObject.optString(next));
                    break;
                case 28:
                    vnVar.ga(jSONObject.optBoolean(next));
                    break;
                case 29:
                    vnVar.wu(jSONObject.optString(next));
                    break;
                case 30:
                    vnVar.dt(jSONObject.optInt(next));
                    break;
                case 31:
                    vnVar.k(jSONObject.optString(next));
                    break;
                case 32:
                    vnVar.f(jSONObject.optInt(next));
                    break;
                case 33:
                    vnVar.v((float) jSONObject.optDouble(next));
                    break;
                case 34:
                    vnVar.f(jSONObject.optString(next));
                    break;
                case 35:
                    vnVar.ga(jSONObject.optString(next));
                    break;
                case 36:
                    vnVar.k(jSONObject.optInt(next));
                    break;
                case 37:
                    vnVar.tg((float) jSONObject.optDouble(next));
                    break;
                case 38:
                    vnVar.d(jSONObject.optDouble(next));
                    break;
                case 39:
                    vnVar.ga((float) jSONObject.optDouble(next));
                    break;
                case 40:
                    vnVar.zk(jSONObject.optBoolean(next));
                    break;
                case 41:
                    vnVar.xu(jSONObject.optBoolean(next));
                    break;
                case 42:
                    vnVar.zk((float) jSONObject.optDouble(next));
                    break;
                case 43:
                    vnVar.l(jSONObject.optString(next));
                    break;
                case 44:
                    vnVar.a(jSONObject.optInt(next));
                    break;
                case 45:
                    vnVar.p((float) jSONObject.optDouble(next));
                    break;
                case 46:
                    vnVar.v(jSONObject.optString(next));
                    break;
                case 47:
                    vnVar.zk(jSONObject.optString(next));
                    break;
                case 48:
                    vnVar.t(jSONObject.optInt(next));
                    break;
                case 49:
                    vnVar.d(jSONObject.optBoolean(next));
                    break;
                case 50:
                    vnVar.wu(jSONObject.optInt(next));
                    break;
                case 51:
                    vnVar.w(jSONObject.optString(next));
                    break;
                case 52:
                    vnVar.bf(jSONObject.optBoolean(next));
                    break;
                case 53:
                    vnVar.xu(jSONObject.optString(next));
                    break;
                case 54:
                    vnVar.bh(jSONObject.optString(next));
                    break;
                case 55:
                    vnVar.e((float) jSONObject.optDouble(next));
                    break;
                case 56:
                    vnVar.s(jSONObject.optString(next));
                    break;
                case 57:
                    vnVar.m(jSONObject.optString(next));
                    break;
                case 58:
                    vnVar.w(jSONObject.optInt(next));
                    break;
                case 59:
                    vnVar.bf((float) jSONObject.optDouble(next));
                    break;
                case 60:
                    vnVar.m(jSONObject.optInt(next));
                    break;
                case 61:
                    vnVar.xu(jSONObject.optInt(next));
                    break;
            }
        }
    }
}
