package com.bytedance.sdk.component.adexpress.dynamic.dl;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.component.utils.wp;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.io.encoding.Base64;
import okio.Utf8;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f555a;
    private boolean b;
    private boolean bb;
    private String bm;
    private String bv;
    private int bw;
    private String by;
    private String cb;
    private String dh;
    private float dl;
    private int dt;
    private float e;
    private int ec;
    private int eo;
    private boolean f;
    private float fo;
    private int fp;
    private String fv;
    private float g;
    private boolean gb;
    private boolean gc;
    private String gk;
    private long gm = -1;
    private int gp;
    private int gy;
    private float gz;
    private double h;
    private int hh;
    private double hn;
    private boolean hy;
    private String i;
    private String io;
    private String iq;
    private double j;
    private int ja;
    private boolean jq;
    private String js;
    private String jz;
    private JSONObject k;
    private double kb;
    private int kp;
    private double l;
    private int lk;
    private String lq;
    private String ls;
    private int lt;
    private int lw;
    private boolean ly;
    private float m;
    private String mc;
    private int me;
    private String mn;
    private int n;
    private int na;
    private List<z> nb;
    private int nh;
    private boolean o;
    private int oq;
    private List<String> oz;
    private String p;
    private String pd;
    private String pf;
    private String q;
    private JSONObject qd;
    private int r;
    private int rv;
    private boolean s;
    private boolean sd;
    private boolean sf;
    private boolean sv;
    private int sy;
    private boolean t;
    private String tb;
    private int tc;
    private String te;
    private int tf;
    private boolean ti;
    private int u;
    private boolean uf;
    private String un;
    private float uy;
    private String v;
    private int vm;
    private int vo;
    private String vt;
    private int wj;
    private int wn;
    private JSONObject wo;
    private double wp;
    private int wx;
    private String x;
    private int xf;
    private int xl;
    private int xo;
    private boolean y;
    private JSONObject yt;
    private boolean yw;
    private String yx;
    private String yz;
    private float z;
    private int zb;
    private boolean zd;
    private String zw;
    private int zx;
    private int zz;

    public static m z(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        m mVar = new m();
        mVar.g(jSONObject.optString("adType", "embeded"));
        mVar.pf(jSONObject.optString("clickArea", "creative"));
        mVar.ls(jSONObject.optString("clickTigger", "click"));
        mVar.dl(jSONObject.optString(TtmlNode.ATTR_TTS_FONT_FAMILY, "PingFangSC"));
        mVar.a(jSONObject.optString(TtmlNode.ATTR_TTS_TEXT_ALIGN, TtmlNode.LEFT));
        mVar.gc(jSONObject.optString("color", "#999999"));
        mVar.m(jSONObject.optString("bgColor", "transparent"));
        mVar.e(jSONObject.optString("bgImgUrl", ""));
        mVar.l(jSONObject.optString("bgImgData", ""));
        mVar.gz(jSONObject.optString("borderColor", "#000000"));
        mVar.fo(jSONObject.optString("borderStyle", "solid"));
        mVar.uy(jSONObject.optString("heightMode", "auto"));
        mVar.kb(jSONObject.optString("widthMode", "fixed"));
        mVar.wp(jSONObject.optString("interactText", ""));
        mVar.dl(jSONObject.optBoolean("isShowBgControl", false));
        mVar.i(jSONObject.optString("interactBgColor", ""));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("interactPosition");
        if (jSONObjectOptJSONObject != null) {
            mVar.e(jSONObjectOptJSONObject.optInt("translateY", 0));
            mVar.gz(jSONObjectOptJSONObject.optInt("translateX", 0));
            mVar.a(jSONObjectOptJSONObject.optDouble("scaleX", 0.0d));
            mVar.gc(jSONObjectOptJSONObject.optDouble("scaleY", 0.0d));
        }
        mVar.v(jSONObject.optString("interactType", ""));
        mVar.gc(jSONObject.optInt("interactSlideDirection", -1));
        mVar.p(jSONObject.optString("justifyHorizontal", "space-around"));
        mVar.fv(jSONObject.optString("justifyVertical", "flex-start"));
        mVar.g(jSONObject.optDouble("timingStart"));
        mVar.dl(jSONObject.optDouble("timingEnd"));
        mVar.a((float) jSONObject.optDouble(MediaFormat.KEY_WIDTH, 0.0d));
        mVar.dl((float) jSONObject.optDouble(MediaFormat.KEY_HEIGHT, 0.0d));
        mVar.z((float) jSONObject.optDouble("borderRadius", 0.0d));
        mVar.g((float) jSONObject.optDouble("borderSize", 0.0d));
        mVar.g(jSONObject.optBoolean("interactValidate", false));
        mVar.fo((float) jSONObject.optDouble(TtmlNode.ATTR_TTS_FONT_SIZE, 0.0d));
        mVar.gc((float) jSONObject.optDouble("paddingBottom", 0.0d));
        mVar.m((float) jSONObject.optDouble("paddingLeft", 0.0d));
        mVar.e((float) jSONObject.optDouble("paddingRight", 0.0d));
        mVar.gz((float) jSONObject.optDouble("paddingTop", 0.0d));
        mVar.a(jSONObject.optBoolean("lineFeed", false));
        mVar.fo(jSONObject.optInt("lineCount", 0));
        mVar.m(jSONObject.optDouble("lineHeight", 1.2d));
        mVar.v(jSONObject.optInt("letterSpacing", 0));
        mVar.gc(jSONObject.optBoolean("isDataFixed", false));
        mVar.pf(jSONObject.optInt(TtmlNode.ATTR_TTS_FONT_WEIGHT));
        mVar.m(jSONObject.optBoolean("lineLimit"));
        mVar.ls(jSONObject.optInt("position"));
        mVar.js(jSONObject.optString("align"));
        mVar.e(jSONObject.optBoolean("useLeft"));
        mVar.gz(jSONObject.optBoolean("useRight"));
        mVar.fo(jSONObject.optBoolean("useTop"));
        mVar.uy(jSONObject.optBoolean("useBottom"));
        mVar.tb(jSONObject.optString("data"));
        mVar.g(jSONObject.optJSONObject("i18n"));
        mVar.wp(jSONObject.optInt("marginLeft"));
        mVar.i(jSONObject.optInt("marginRight"));
        mVar.uy(jSONObject.optInt("marginTop"));
        mVar.kb(jSONObject.optInt("marginBottom"));
        mVar.p(jSONObject.optInt("tagMaxCount"));
        mVar.kb(jSONObject.optBoolean("allowTextFlow"));
        mVar.fv(jSONObject.optInt("textFlowType"));
        mVar.js(jSONObject.optInt("textFlowDuration"));
        mVar.tb(jSONObject.optInt(TtmlNode.LEFT));
        mVar.q(jSONObject.optInt(TtmlNode.RIGHT));
        mVar.iq(jSONObject.optInt("top"));
        mVar.zw(jSONObject.optInt("bottom"));
        mVar.q(jSONObject.optString("alignItems", "flex-start"));
        mVar.iq(jSONObject.optString("direction", ""));
        mVar.z(jSONObject.optBoolean("loop", false));
        mVar.io(jSONObject.optInt("zIndex"));
        mVar.h(jSONObject.optInt("interactVisibleTime"));
        mVar.uf(jSONObject.optInt("interactHiddenTime"));
        mVar.i(jSONObject.optBoolean("interactEnableMask"));
        mVar.v(jSONObject.optBoolean("interactWontHide"));
        mVar.z(jSONObject.optString("bgGradient"));
        mVar.x(jSONObject.optInt("areaType"));
        mVar.lq(jSONObject.optInt("interactSlideThreshold", 0));
        mVar.ti(jSONObject.optInt("interactBottomDistance", com.bytedance.sdk.component.adexpress.a.z() ? 0 : 120));
        mVar.fv(jSONObject.optBoolean("openPlayableLandingPage", false));
        mVar.dl(jSONObject.optJSONObject("video"));
        mVar.a(jSONObject.optJSONObject("image"));
        mVar.mc(jSONObject.optInt("borderShadowExtent"));
        mVar.pf(jSONObject.optBoolean("bgGauseBlur"));
        mVar.un(jSONObject.optInt("bgGauseBlurRadius"));
        mVar.ls(jSONObject.optBoolean("showTimeProgress", false));
        mVar.p(jSONObject.optBoolean("showPlayButton", false));
        mVar.z(jSONObject.optDouble("bgColorCg", 0.0d));
        mVar.m(jSONObject.optInt("bgMaterialCenterCalcColor", 0));
        mVar.g(jSONObject.optInt("borderTopLeftRadius", 0));
        mVar.z(jSONObject.optInt("borderTopRightRadius", 0));
        mVar.a(jSONObject.optInt("borderBottomLeftRadius", 0));
        mVar.dl(jSONObject.optInt("borderBottomRightRadius", 0));
        mVar.gc(jSONObject.optJSONObject("interactI18n"));
        mVar.io(jSONObject.optString("imageObjectFit"));
        mVar.uf(jSONObject.optString("interactTitle"));
        mVar.gk(jSONObject.optInt("interactTextPositionTop"));
        mVar.zw(jSONObject.optString("imageLottieTosPath"));
        mVar.wp(jSONObject.optBoolean("animationsLoop"));
        mVar.sy(jSONObject.optInt("lottieAppNameMaxLength"));
        mVar.l(jSONObject.optInt("lottieAdDescMaxLength"));
        mVar.hh(jSONObject.optInt("lottieAdTitleMaxLength"));
        mVar.hh(jSONObject.optString("imageFlipSlideType"));
        mVar.js(jSONObject.optBoolean("isClickEventIntercept"));
        if (jSONObject.has("filterColor")) {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("filterColor");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    arrayList.add(jSONArrayOptJSONArray.optString(i));
                }
                mVar.g(arrayList);
            }
        }
        try {
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("animations");
            if (jSONArrayOptJSONArray2 != null) {
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                    JSONObject jSONObject2 = jSONArrayOptJSONArray2.getJSONObject(i2);
                    z zVar = new z();
                    zVar.dl(jSONObject2.optString("animationType"));
                    zVar.z(jSONObject2.optDouble("animationDuration"));
                    zVar.g(jSONObject2.optDouble("animationScaleX"));
                    zVar.dl(jSONObject2.optDouble("animationScaleY"));
                    zVar.a(jSONObject2.optString("animationTimeFunction"));
                    zVar.a(jSONObject2.optDouble("animationDelay"));
                    zVar.m(jSONObject2.optInt("animationIterationCount"));
                    zVar.gc(jSONObject2.optString("animationDirection"));
                    zVar.gc(jSONObject2.optDouble("animationInterval"));
                    zVar.z(jSONObject2.optInt("animationBorderWidth"));
                    zVar.z(jSONObject2.optLong("key"));
                    zVar.g(jSONObject2.optInt("animationEffectWidth"));
                    zVar.dl(jSONObject2.optInt("animationSwing", 1));
                    zVar.a(jSONObject2.optInt("animationTranslateX"));
                    zVar.gc(jSONObject2.optInt("animationTranslateY"));
                    zVar.g(jSONObject2.optString("animationRippleBackgroundColor"));
                    zVar.z(jSONObject2.optString("animationScaleDirection"));
                    zVar.e(jSONObject2.optInt("animationFadeStart"));
                    zVar.gz(jSONObject2.optInt("animationFadeEnd"));
                    zVar.m(jSONObject2.optString("animationFillMode"));
                    zVar.fo(jSONObject2.optInt("animationBounceHeight"));
                    if (mVar.js() > 0.0d) {
                        zVar.a(zVar.v() + mVar.js());
                    }
                    arrayList2.add(zVar);
                }
                mVar.z(arrayList2);
            }
            if (jSONObject.has("triggerSlideMinDistance")) {
                mVar.sy(jSONObject.optString("triggerSlideDirection", "0"));
                mVar.z(jSONObject.optLong("triggerSlideMinDistance", 0L));
            }
        } catch (Exception e) {
            wp.z(e);
        }
        return mVar;
    }

    public boolean z() {
        return this.sd;
    }

    public void z(boolean z) {
        this.sd = z;
    }

    public int g() {
        return this.xo;
    }

    public void z(int i) {
        this.xo = i;
    }

    public int dl() {
        return this.xf;
    }

    public void g(int i) {
        this.xf = i;
    }

    public int a() {
        return this.bw;
    }

    public void dl(int i) {
        this.bw = i;
    }

    public int gc() {
        return this.gy;
    }

    public void a(int i) {
        this.gy = i;
    }

    public JSONObject m() {
        return this.yt;
    }

    public int e() {
        return this.wx;
    }

    public void gc(int i) {
        this.wx = i;
    }

    public double gz() {
        return this.hn;
    }

    public void z(double d) {
        this.hn = d;
    }

    public int fo() {
        return this.dt;
    }

    public void m(int i) {
        this.dt = i;
    }

    public String uy() {
        return this.by;
    }

    public void z(String str) {
        this.by = str;
    }

    public float kb() {
        return this.z;
    }

    public void z(float f) {
        this.z = f;
    }

    public float wp() {
        return this.g;
    }

    public void g(float f) {
        this.g = f;
    }

    public void dl(float f) {
        this.dl = f;
    }

    public void a(float f) {
        this.f555a = f;
    }

    public boolean i() {
        return this.gc;
    }

    public void g(boolean z) {
        this.gc = z;
    }

    public float v() {
        return this.m;
    }

    public void gc(float f) {
        this.m = f;
    }

    public float pf() {
        return this.e;
    }

    public void m(float f) {
        this.e = f;
    }

    public float ls() {
        return this.gz;
    }

    public void e(float f) {
        this.gz = f;
    }

    public float p() {
        return this.fo;
    }

    public void gz(float f) {
        this.fo = f;
    }

    public float fv() {
        return this.uy;
    }

    public void fo(float f) {
        this.uy = f;
    }

    public double js() {
        return this.kb;
    }

    public void g(double d) {
        this.kb = d;
    }

    public double tb() {
        return this.wp;
    }

    public void dl(double d) {
        this.wp = d;
    }

    public void g(String str) {
        this.i = str;
    }

    public void dl(String str) {
        this.v = str;
    }

    public String q() {
        return this.pf;
    }

    public void a(String str) {
        this.pf = str;
    }

    public String iq() {
        return this.ls;
    }

    public void gc(String str) {
        this.ls = str;
    }

    public String zw() {
        return this.p;
    }

    public void m(String str) {
        this.p = str;
    }

    public void e(String str) {
        this.fv = str;
    }

    public String io() {
        return this.fv;
    }

    private void l(String str) {
        this.mn = str;
    }

    public String uf() {
        return this.mn;
    }

    public String sy() {
        return this.js;
    }

    public void gz(String str) {
        this.js = str;
    }

    public void fo(String str) {
        this.tb = str;
    }

    public String hh() {
        return this.q;
    }

    public void uy(String str) {
        this.q = str;
    }

    public String l() {
        return this.iq;
    }

    public void kb(String str) {
        this.iq = str;
    }

    public String h() {
        return this.zw;
    }

    public void wp(String str) {
        this.zw = str;
    }

    public String gk() {
        return this.io;
    }

    public void i(String str) {
        this.io = str;
    }

    public boolean x() {
        return this.uf;
    }

    public void dl(boolean z) {
        this.uf = z;
    }

    public int lq() {
        return this.sy;
    }

    public void e(int i) {
        this.sy = i;
    }

    public int mc() {
        return this.hh;
    }

    public void gz(int i) {
        this.hh = i;
    }

    public double un() {
        return this.l;
    }

    public void a(double d) {
        this.l = d;
    }

    public double ti() {
        return this.h;
    }

    public void gc(double d) {
        this.h = d;
    }

    public String eo() {
        return this.gk;
    }

    public void v(String str) {
        this.gk = str;
    }

    public String oq() {
        return this.x;
    }

    public void pf(String str) {
        this.x = str;
    }

    public String wj() {
        return this.lq;
    }

    public void ls(String str) {
        this.lq = str;
    }

    public String na() {
        return this.mc;
    }

    public void p(String str) {
        this.mc = str;
    }

    public String xl() {
        return this.un;
    }

    public void fv(String str) {
        this.un = str;
    }

    public boolean j() {
        return this.ti;
    }

    public void a(boolean z) {
        this.ti = z;
    }

    public void fo(int i) {
        this.eo = i;
    }

    public int gp() {
        return this.eo;
    }

    public int t() {
        return this.oq;
    }

    public void uy(int i) {
        this.oq = i;
    }

    public int vm() {
        return this.wj;
    }

    public void kb(int i) {
        this.wj = i;
    }

    public int y() {
        return this.na;
    }

    public void wp(int i) {
        this.na = i;
    }

    public int ec() {
        return this.xl;
    }

    public void i(int i) {
        this.xl = i;
    }

    public double bv() {
        return this.j;
    }

    public void m(double d) {
        this.j = d;
    }

    public int gb() {
        return this.gp;
    }

    public void v(int i) {
        this.gp = i;
    }

    public boolean jq() {
        return this.t;
    }

    public void gc(boolean z) {
        this.t = z;
    }

    public int sv() {
        return this.vm;
    }

    public void pf(int i) {
        this.vm = i;
    }

    public boolean f() {
        return this.y;
    }

    public void m(boolean z) {
        this.y = z;
    }

    public int yx() {
        return this.ec;
    }

    public void ls(int i) {
        this.ec = i;
    }

    public String qd() {
        return this.bv;
    }

    public void js(String str) {
        this.bv = str;
    }

    public boolean zx() {
        return this.gb;
    }

    public void e(boolean z) {
        this.gb = z;
    }

    public boolean b() {
        return this.jq;
    }

    public void gz(boolean z) {
        this.jq = z;
    }

    public boolean lw() {
        return this.sv;
    }

    public void fo(boolean z) {
        this.sv = z;
    }

    public boolean rv() {
        return this.f;
    }

    public void uy(boolean z) {
        this.f = z;
    }

    public String tc() {
        return this.yx;
    }

    public void tb(String str) {
        this.yx = str;
    }

    public void g(JSONObject jSONObject) {
        this.qd = jSONObject;
    }

    public JSONObject me() {
        return this.qd;
    }

    public int nh() {
        return this.zx;
    }

    public void p(int i) {
        this.zx = i;
    }

    public boolean r() {
        return this.b;
    }

    public void kb(boolean z) {
        this.b = z;
    }

    public int yz() {
        return this.lw;
    }

    public void fv(int i) {
        this.lw = i;
    }

    public int bm() {
        return this.rv;
    }

    public void js(int i) {
        this.rv = i;
    }

    public int sd() {
        return this.tc;
    }

    public void tb(int i) {
        this.tc = i;
    }

    public int tf() {
        return this.me;
    }

    public void q(int i) {
        this.me = i;
    }

    public int ja() {
        return this.nh;
    }

    public void iq(int i) {
        this.nh = i;
    }

    public int wn() {
        return this.r;
    }

    public void zw(int i) {
        this.r = i;
    }

    public String nb() {
        return this.yz;
    }

    public void q(String str) {
        this.yz = str;
    }

    public String zz() {
        return this.bm;
    }

    public void iq(String str) {
        this.bm = str;
    }

    public int vo() {
        return this.tf;
    }

    public void io(int i) {
        this.tf = i;
    }

    public int lk() {
        return this.ja;
    }

    public void uf(int i) {
        this.ja = i;
    }

    public String u() {
        return this.te;
    }

    public void zw(String str) {
        this.te = str;
    }

    public boolean sf() {
        return this.hy;
    }

    public void wp(boolean z) {
        this.hy = z;
    }

    public int yw() {
        return this.lt;
    }

    public void sy(int i) {
        this.lt = i;
    }

    public int s() {
        return this.kp;
    }

    public void hh(int i) {
        this.kp = i;
    }

    public int n() {
        return this.fp;
    }

    public void l(int i) {
        this.fp = i;
    }

    public boolean ly() {
        return this.zd;
    }

    public void i(boolean z) {
        this.zd = z;
    }

    public int hn() {
        return this.wn;
    }

    public void h(int i) {
        this.wn = i;
    }

    public void v(boolean z) {
        this.o = z;
    }

    public boolean wo() {
        return this.o;
    }

    public void io(String str) {
        this.dh = str;
    }

    public String k() {
        return this.dh;
    }

    public void gk(int i) {
        this.zb = i;
    }

    public int wx() {
        return this.zb;
    }

    public List<z> cb() {
        return this.nb;
    }

    public int o() {
        List<z> list = this.nb;
        if (list == null) {
            return 0;
        }
        for (z zVar : list) {
            if ("translate".equals(zVar.fo()) && zVar.e() < 0) {
                return -zVar.e();
            }
        }
        return 0;
    }

    public void z(List<z> list) {
        this.nb = list;
    }

    public int yt() {
        return this.zz;
    }

    public void x(int i) {
        this.zz = i;
    }

    public int dt() {
        return this.vo;
    }

    public void lq(int i) {
        this.vo = i;
    }

    public int xo() {
        return this.lk;
    }

    public void mc(int i) {
        this.lk = i;
    }

    public boolean xf() {
        return this.sf;
    }

    public void pf(boolean z) {
        this.sf = z;
    }

    public int bw() {
        return this.u;
    }

    public void un(int i) {
        this.u = i;
    }

    public boolean gy() {
        return this.yw;
    }

    public void ls(boolean z) {
        this.yw = z;
    }

    public boolean dh() {
        return this.s;
    }

    public void p(boolean z) {
        this.s = z;
    }

    public int zb() {
        return this.n;
    }

    public void ti(int i) {
        this.n = i;
    }

    public String zd() {
        return this.cb;
    }

    public boolean te() {
        return this.ly;
    }

    public void fv(boolean z) {
        this.ly = z;
    }

    public void dl(JSONObject jSONObject) {
        this.wo = jSONObject;
    }

    public JSONObject hy() {
        return this.k;
    }

    public void a(JSONObject jSONObject) {
        this.k = jSONObject;
    }

    public void gc(JSONObject jSONObject) {
        this.yt = jSONObject;
    }

    public String lt() {
        return this.vt;
    }

    public void uf(String str) {
        this.vt = str;
    }

    public void kp() {
        z(this, this.wo);
    }

    public void fp() {
        z(this, this.k);
    }

    public String vt() {
        return this.pd;
    }

    public void sy(String str) {
        this.pd = str;
    }

    public long pd() {
        return this.gm;
    }

    public void z(long j) {
        this.gm = j;
    }

    public String gm() {
        return ("flip".equals(this.jz) || "slide".equals(this.jz)) ? this.jz : "slide";
    }

    public void hh(String str) {
        this.jz = str;
    }

    public List<String> mn() {
        return this.oz;
    }

    public void g(List<String> list) {
        this.oz = list;
    }

    public void js(boolean z) {
        this.bb = z;
    }

    public boolean jz() {
        return this.bb;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void z(m mVar, JSONObject jSONObject) {
        if (mVar == null || jSONObject == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            next.hashCode();
            byte b = -1;
            switch (next.hashCode()) {
                case -2067713583:
                    if (next.equals("isShowBgControl")) {
                        b = 0;
                    }
                    break;
                case -1965619659:
                    if (next.equals("clickArea")) {
                        b = 1;
                    }
                    break;
                case -1912831834:
                    if (next.equals("triggerSlideDirection")) {
                        b = 2;
                    }
                    break;
                case -1885934767:
                    if (next.equals("bgImgUrl")) {
                        b = 3;
                    }
                    break;
                case -1822062213:
                    if (next.equals("lineCount")) {
                        b = 4;
                    }
                    break;
                case -1821293778:
                    if (next.equals("openPlayableLandingPage")) {
                        b = 5;
                    }
                    break;
                case -1813937113:
                    if (next.equals("lineLimit")) {
                        b = 6;
                    }
                    break;
                case -1578250488:
                    if (next.equals("interactBgColor")) {
                        b = 7;
                    }
                    break;
                case -1501175880:
                    if (next.equals("paddingLeft")) {
                        b = 8;
                    }
                    break;
                case -1422965251:
                    if (next.equals("adType")) {
                        b = 9;
                    }
                    break;
                case -1383228885:
                    if (next.equals("bottom")) {
                        b = 10;
                    }
                    break;
                case -1224696685:
                    if (next.equals(TtmlNode.ATTR_TTS_FONT_FAMILY)) {
                        b = 11;
                    }
                    break;
                case -1221029593:
                    if (next.equals(MediaFormat.KEY_HEIGHT)) {
                        b = 12;
                    }
                    break;
                case -1065511464:
                    if (next.equals(TtmlNode.ATTR_TTS_TEXT_ALIGN)) {
                        b = 13;
                    }
                    break;
                case -1063257157:
                    if (next.equals("alignItems")) {
                        b = 14;
                    }
                    break;
                case -1046708884:
                    if (next.equals("interactValidate")) {
                        b = 15;
                    }
                    break;
                case -1044792121:
                    if (next.equals("marginTop")) {
                        b = 16;
                    }
                    break;
                case -1019884910:
                    if (next.equals("useBottom")) {
                        b = 17;
                    }
                    break;
                case -1005195314:
                    if (next.equals("triggerSlideMinDistance")) {
                        b = Ascii.DC2;
                    }
                    break;
                case -962590849:
                    if (next.equals("direction")) {
                        b = 19;
                    }
                    break;
                case -912366651:
                    if (next.equals("tagMaxCount")) {
                        b = Ascii.DC4;
                    }
                    break;
                case -848877971:
                    if (next.equals("interactHiddenTime")) {
                        b = Ascii.NAK;
                    }
                    break;
                case -836058546:
                    if (next.equals("useTop")) {
                        b = Ascii.SYN;
                    }
                    break;
                case -734428249:
                    if (next.equals(TtmlNode.ATTR_TTS_FONT_WEIGHT)) {
                        b = Ascii.ETB;
                    }
                    break;
                case -731417480:
                    if (next.equals("zIndex")) {
                        b = Ascii.CAN;
                    }
                    break;
                case -709393864:
                    if (next.equals("timingStart")) {
                        b = Ascii.EM;
                    }
                    break;
                case -515807685:
                    if (next.equals("lineHeight")) {
                        b = Ascii.SUB;
                    }
                    break;
                case -321658193:
                    if (next.equals("textFlowDuration")) {
                        b = Ascii.ESC;
                    }
                    break;
                case -295409451:
                    if (next.equals("useRight")) {
                        b = Ascii.FS;
                    }
                    break;
                case -289173127:
                    if (next.equals("marginBottom")) {
                        b = Ascii.GS;
                    }
                    break;
                case -204859874:
                    if (next.equals("bgColor")) {
                        b = Ascii.RS;
                    }
                    break;
                case -191748762:
                    if (next.equals("isClickEventIntercept")) {
                        b = Ascii.US;
                    }
                    break;
                case -148259282:
                    if (next.equals("useLeft")) {
                        b = 32;
                    }
                    break;
                case -51738487:
                    if (next.equals("widthMode")) {
                        b = 33;
                    }
                    break;
                case 115029:
                    if (next.equals("top")) {
                        b = 34;
                    }
                    break;
                case 3076010:
                    if (next.equals("data")) {
                        b = 35;
                    }
                    break;
                case 3317767:
                    if (next.equals(TtmlNode.LEFT)) {
                        b = 36;
                    }
                    break;
                case 3327652:
                    if (next.equals("loop")) {
                        b = 37;
                    }
                    break;
                case 90130308:
                    if (next.equals("paddingTop")) {
                        b = 38;
                    }
                    break;
                case 92903173:
                    if (next.equals("align")) {
                        b = 39;
                    }
                    break;
                case 94842723:
                    if (next.equals("color")) {
                        b = 40;
                    }
                    break;
                case 108511772:
                    if (next.equals(TtmlNode.RIGHT)) {
                        b = 41;
                    }
                    break;
                case 113126854:
                    if (next.equals(MediaFormat.KEY_WIDTH)) {
                        b = 42;
                    }
                    break;
                case 164611121:
                    if (next.equals("timingEnd")) {
                        b = 43;
                    }
                    break;
                case 202355100:
                    if (next.equals("paddingBottom")) {
                        b = 44;
                    }
                    break;
                case 247204452:
                    if (next.equals("allowTextFlow")) {
                        b = 45;
                    }
                    break;
                case 302841174:
                    if (next.equals("interactWontHide")) {
                        b = 46;
                    }
                    break;
                case 365601008:
                    if (next.equals(TtmlNode.ATTR_TTS_FONT_SIZE)) {
                        b = 47;
                    }
                    break;
                case 428975654:
                    if (next.equals("justifyVertical")) {
                        b = 48;
                    }
                    break;
                case 439444041:
                    if (next.equals("interactVisibleTime")) {
                        b = 49;
                    }
                    break;
                case 713848971:
                    if (next.equals("paddingRight")) {
                        b = 50;
                    }
                    break;
                case 722830999:
                    if (next.equals("borderColor")) {
                        b = 51;
                    }
                    break;
                case 737768677:
                    if (next.equals("borderStyle")) {
                        b = 52;
                    }
                    break;
                case 747804969:
                    if (next.equals("position")) {
                        b = 53;
                    }
                    break;
                case 791643104:
                    if (next.equals("isDataFixed")) {
                        b = 54;
                    }
                    break;
                case 975087886:
                    if (next.equals("marginRight")) {
                        b = 55;
                    }
                    break;
                case 1110826708:
                    if (next.equals("justifyHorizontal")) {
                        b = 56;
                    }
                    break;
                case 1122368895:
                    if (next.equals("interactPosition")) {
                        b = 57;
                    }
                    break;
                case 1188229042:
                    if (next.equals("lineFeed")) {
                        b = 58;
                    }
                    break;
                case 1332036739:
                    if (next.equals("interactText")) {
                        b = 59;
                    }
                    break;
                case 1332055696:
                    if (next.equals("interactType")) {
                        b = 60;
                    }
                    break;
                case 1349188574:
                    if (next.equals("borderRadius")) {
                        b = Base64.padSymbol;
                    }
                    break;
                case 1360828714:
                    if (next.equals("clickTigger")) {
                        b = 62;
                    }
                    break;
                case 1490178922:
                    if (next.equals("heightMode")) {
                        b = Utf8.REPLACEMENT_BYTE;
                    }
                    break;
                case 1761274325:
                    if (next.equals("textFlowType")) {
                        b = SignedBytes.MAX_POWER_OF_TWO;
                    }
                    break;
                case 1824903757:
                    if (next.equals("borderSize")) {
                        b = 65;
                    }
                    break;
                case 1970934485:
                    if (next.equals("marginLeft")) {
                        b = 66;
                    }
                    break;
                case 2111078717:
                    if (next.equals("letterSpacing")) {
                        b = 67;
                    }
                    break;
            }
            switch (b) {
                case 0:
                    mVar.dl(jSONObject.optBoolean(next, false));
                    break;
                case 1:
                    mVar.pf(jSONObject.optString(next));
                    break;
                case 2:
                    mVar.sy(jSONObject.optString(next));
                    break;
                case 3:
                    mVar.e(jSONObject.optString(next));
                    break;
                case 4:
                    mVar.fo(jSONObject.optInt(next));
                    break;
                case 5:
                    mVar.fv(jSONObject.optBoolean(next));
                    break;
                case 6:
                    mVar.m(jSONObject.optBoolean(next));
                    break;
                case 7:
                    mVar.i(jSONObject.optString(next));
                    break;
                case 8:
                    mVar.m((float) jSONObject.optDouble(next));
                    break;
                case 9:
                    mVar.g(jSONObject.optString(next));
                    break;
                case 10:
                    mVar.zw(jSONObject.optInt(next));
                    break;
                case 11:
                    mVar.dl(jSONObject.optString(next));
                    break;
                case 12:
                    mVar.dl((float) jSONObject.optDouble(next));
                    break;
                case 13:
                    mVar.a(jSONObject.optString(next));
                    break;
                case 14:
                    mVar.q(jSONObject.optString(next));
                    break;
                case 15:
                    mVar.g(jSONObject.optBoolean(next));
                    break;
                case 16:
                    mVar.uy(jSONObject.optInt(next));
                    break;
                case 17:
                    mVar.uy(jSONObject.optBoolean(next));
                    break;
                case 18:
                    mVar.z(jSONObject.optLong(next));
                    break;
                case 19:
                    mVar.iq(jSONObject.optString(next));
                    break;
                case 20:
                    mVar.p(jSONObject.optInt(next));
                    break;
                case 21:
                    mVar.uf(jSONObject.optInt(next));
                    break;
                case 22:
                    mVar.fo(jSONObject.optBoolean(next));
                    break;
                case 23:
                    mVar.pf(jSONObject.optInt(next));
                    break;
                case 24:
                    mVar.io(jSONObject.optInt(next));
                    break;
                case 25:
                    mVar.g(jSONObject.optDouble(next));
                    break;
                case 26:
                    mVar.m(jSONObject.optDouble(next));
                    break;
                case 27:
                    mVar.js(jSONObject.optInt(next));
                    break;
                case 28:
                    mVar.gz(jSONObject.optBoolean(next));
                    break;
                case 29:
                    mVar.kb(jSONObject.optInt(next));
                    break;
                case 30:
                    mVar.m(jSONObject.optString(next));
                    break;
                case 31:
                    mVar.v(jSONObject.optBoolean(next));
                    break;
                case 32:
                    mVar.e(jSONObject.optBoolean(next));
                    break;
                case 33:
                    mVar.kb(jSONObject.optString(next));
                    break;
                case 34:
                    mVar.iq(jSONObject.optInt(next));
                    break;
                case 35:
                    mVar.tb(jSONObject.optString(next));
                    break;
                case 36:
                    mVar.tb(jSONObject.optInt(next));
                    break;
                case 37:
                    mVar.z(jSONObject.optBoolean(next));
                    break;
                case 38:
                    mVar.gz((float) jSONObject.optDouble(next));
                    break;
                case 39:
                    mVar.js(jSONObject.optString(next));
                    break;
                case 40:
                    mVar.gc(jSONObject.optString(next));
                    break;
                case 41:
                    mVar.q(jSONObject.optInt(next));
                    break;
                case 42:
                    mVar.a((float) jSONObject.optDouble(next));
                    break;
                case 43:
                    mVar.dl(jSONObject.optDouble(next));
                    break;
                case 44:
                    mVar.gc((float) jSONObject.optDouble(next));
                    break;
                case 45:
                    mVar.kb(jSONObject.optBoolean(next));
                    break;
                case 46:
                    mVar.v(jSONObject.optBoolean(next));
                    break;
                case 47:
                    mVar.fo((float) jSONObject.optDouble(next));
                    break;
                case 48:
                    mVar.fv(jSONObject.optString(next));
                    break;
                case 49:
                    mVar.h(jSONObject.optInt(next));
                    break;
                case 50:
                    mVar.e((float) jSONObject.optDouble(next));
                    break;
                case 51:
                    mVar.gz(jSONObject.optString(next));
                    break;
                case 52:
                    mVar.fo(jSONObject.optString(next));
                    break;
                case 53:
                    mVar.ls(jSONObject.optInt(next));
                    break;
                case 54:
                    mVar.gc(jSONObject.optBoolean(next));
                    break;
                case 55:
                    mVar.i(jSONObject.optInt(next));
                    break;
                case 56:
                    mVar.p(jSONObject.optString(next));
                    break;
                case ILivePlayer.LIVE_PLAYER_OPTION_PLAY_URL /* 57 */:
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
                    if (jSONObjectOptJSONObject != null) {
                        mVar.e(jSONObjectOptJSONObject.optInt("translateY", 0));
                        mVar.gz(jSONObjectOptJSONObject.optInt("translateX", 0));
                        mVar.a(jSONObjectOptJSONObject.optDouble("scaleX", 0.0d));
                        mVar.gc(jSONObjectOptJSONObject.optDouble("scaleY", 0.0d));
                    }
                    break;
                case 58:
                    mVar.a(jSONObject.optBoolean(next));
                    break;
                case 59:
                    mVar.wp(jSONObject.optString(next));
                    break;
                case 60:
                    mVar.v(jSONObject.optString(next));
                    break;
                case 61:
                    mVar.z((float) jSONObject.optDouble(next));
                    break;
                case 62:
                    mVar.ls(jSONObject.optString(next));
                    break;
                case 63:
                    mVar.uy(jSONObject.optString(next));
                    break;
                case 64:
                    mVar.fv(jSONObject.optInt(next));
                    break;
                case 65:
                    mVar.g((float) jSONObject.optDouble(next));
                    break;
                case 66:
                    mVar.wp(jSONObject.optInt(next));
                    break;
                case 67:
                    mVar.v(jSONObject.optInt(next));
                    break;
            }
        }
    }
}
