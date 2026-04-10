package com.bytedance.sdk.component.adexpress.dynamic.d;

import android.graphics.Color;
import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.dynamic.tg.wu;
import com.yuewen.x30;

/* JADX INFO: loaded from: classes.dex */
public class p {
    public String bf;
    private vn d;
    public int e;
    private String ga;
    private ga tg;

    public p(ga gaVar) {
        this.tg = gaVar;
        this.e = gaVar.e();
        this.bf = gaVar.bf();
        this.ga = gaVar.d();
        if (com.bytedance.sdk.component.adexpress.tg.bf() == 1) {
            this.d = gaVar.ga();
        } else {
            this.d = gaVar.tg();
        }
        if (com.bytedance.sdk.component.adexpress.tg.e()) {
            this.d = gaVar.tg();
        }
    }

    private boolean pl() {
        if (com.bytedance.sdk.component.adexpress.tg.e()) {
            return false;
        }
        return (!TextUtils.isEmpty(this.bf) && this.bf.contains("adx:")) || wu.bf();
    }

    private boolean tx() {
        return (com.bytedance.sdk.component.adexpress.tg.e() && (this.tg.getType().contains("logo-union") || this.tg.getType().contains("logounion") || this.tg.getType().contains("logoad"))) || "logo-union".equals(this.tg.getType()) || "logounion".equals(this.tg.getType()) || "logoad".equals(this.tg.getType());
    }

    public int a() {
        String strFy = this.d.fy();
        if ("skip-with-time-skip-btn".equals(this.tg.getType()) || "skip".equals(this.tg.getType()) || TextUtils.equals("skip-with-countdowns-skip-btn", this.tg.getType())) {
            return 6;
        }
        if (!"skip-with-time-countdown".equals(this.tg.getType()) && !"skip-with-time".equals(this.tg.getType())) {
            if (this.e == 10 && TextUtils.equals(this.d.h(), "click")) {
                return 5;
            }
            if (tx() && pl()) {
                return 0;
            }
            if (tx()) {
                return 7;
            }
            if ("feedback-dislike".equals(this.tg.getType())) {
                return 3;
            }
            if (!TextUtils.isEmpty(strFy) && !strFy.equals("none")) {
                if (strFy.equals("video") || (this.tg.e() == 7 && TextUtils.equals(strFy, x30.z))) {
                    return (com.bytedance.sdk.component.adexpress.tg.e() && this.tg.tg() != null && this.tg.tg().ys()) ? 11 : 4;
                }
                if (strFy.equals(x30.z)) {
                    return 1;
                }
                return (strFy.equals("creative") || "slide".equals(this.d.h())) ? 2 : 0;
            }
        }
        return 0;
    }

    public String b() {
        return this.d.zk();
    }

    public int bf() {
        return (int) this.d.w();
    }

    public double bh() {
        if (this.e == 11) {
            try {
                return !com.bytedance.sdk.component.adexpress.tg.e() ? (int) r0 : Double.parseDouble(this.bf);
            } catch (NumberFormatException unused) {
            }
        }
        return -1.0d;
    }

    public int bm() {
        return this.d.v();
    }

    public int bx() {
        return this.d.d();
    }

    public int cv() {
        return this.d.bm();
    }

    public int d() {
        return (int) this.d.t();
    }

    public boolean dt() {
        return this.d.as();
    }

    public int e() {
        return (int) this.d.bh();
    }

    public int em() {
        return this.d.lw();
    }

    public int ev() {
        return this.d.sq();
    }

    public int f() {
        return this.d.in();
    }

    public String fl() {
        return this.d.a();
    }

    public int ft() {
        return this.d.zr();
    }

    public double fy() {
        return this.d.p();
    }

    public boolean g() {
        return this.d.zo();
    }

    public float ga() {
        return this.d.l();
    }

    public int h() {
        return this.d.bf();
    }

    public int hb() {
        return this.d.tg();
    }

    public boolean i() {
        return this.d.vg();
    }

    public String j() {
        return this.d.uk();
    }

    public int k() {
        return this.d.jk();
    }

    public float l() {
        return this.d.wu();
    }

    public long lc() {
        return this.d.vd();
    }

    public String m() {
        int i = this.e;
        return (i == 2 || i == 13) ? this.bf : "";
    }

    public int n() {
        return this.d.tu();
    }

    public int nt() {
        return this.d.pl();
    }

    public int ot() {
        return this.d.br();
    }

    public String ov() {
        return this.d.yq();
    }

    public int p() {
        return e(this.d.pe());
    }

    public String pe() {
        return this.d.cv();
    }

    public int q() {
        return this.d.vu();
    }

    public String r() {
        return this.d.h();
    }

    public int rb() {
        return this.d.c();
    }

    public boolean rm() {
        return this.d.ft();
    }

    public int rt() {
        return this.d.ov();
    }

    public float s() {
        return this.d.m();
    }

    public double t() {
        return this.d.f();
    }

    public int tg() {
        return (int) this.d.s();
    }

    public boolean ue() {
        return this.d.xu();
    }

    public int uk() {
        return e(this.d.y());
    }

    public String uq() {
        return this.d.lg();
    }

    public int v() {
        String strDt = this.d.dt();
        if ("left".equals(strDt)) {
            return 17;
        }
        if ("center".equals(strDt)) {
            return 4;
        }
        return "right".equals(strDt) ? 3 : 2;
    }

    public String vn() {
        return this.e == 0 ? this.bf : "";
    }

    public int vs() {
        return this.d.xy();
    }

    public String vu() {
        return this.d.zb();
    }

    public int w() {
        return e(this.d.wl());
    }

    public String wl() {
        return this.d.fy();
    }

    public String wu() {
        return this.e == 1 ? this.bf : "";
    }

    public int x() {
        return this.d.e();
    }

    public String xu() {
        return this.ga;
    }

    public boolean y() {
        return this.d.bx();
    }

    public boolean ya() {
        return this.d.zo();
    }

    public String yf() {
        return this.d.aq();
    }

    public int yl() {
        return this.d.vn();
    }

    public boolean z() {
        return this.d.xn();
    }

    public String za() {
        return this.d.fa();
    }

    public int zk() {
        int iV = v();
        if (iV == 4) {
            return 17;
        }
        return iV == 3 ? 5 : 3;
    }

    public static float[] bf(String str) {
        String[] strArrSplit = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(",");
        return (strArrSplit == null || strArrSplit.length != 4) ? new float[]{0.0f, 0.0f, 0.0f, 0.0f} : new float[]{Float.parseFloat(strArrSplit[0]), Float.parseFloat(strArrSplit[1]), Float.parseFloat(strArrSplit[2]), Float.parseFloat(strArrSplit[3])};
    }

    public void e(float f) {
        this.d.e(f);
    }

    public static int e(String str) {
        String[] strArrSplit;
        if (TextUtils.isEmpty(str)) {
            return -16777216;
        }
        if (str.equals("transparent")) {
            return 0;
        }
        if (str.charAt(0) == '#' && str.length() == 7) {
            return Color.parseColor(str);
        }
        if (str.charAt(0) == '#' && str.length() == 9) {
            return Color.parseColor(str);
        }
        if (str.startsWith("rgba") && (strArrSplit = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(",")) != null) {
            try {
                if (strArrSplit.length == 4) {
                    return (((int) ((Float.parseFloat(strArrSplit[3]) * 255.0f) + 0.5f)) << 24) | (((int) Float.parseFloat(strArrSplit[0])) << 16) | (((int) Float.parseFloat(strArrSplit[1])) << 8) | ((int) Float.parseFloat(strArrSplit[2])) | 0;
                }
            } catch (NumberFormatException unused) {
                return 0;
            }
        }
        return -16777216;
    }

    public boolean e(int i) {
        ga gaVar = this.tg;
        if (gaVar == null) {
            return false;
        }
        if (i == 1) {
            this.d = gaVar.ga();
        } else {
            this.d = gaVar.tg();
        }
        return this.d != null;
    }
}
