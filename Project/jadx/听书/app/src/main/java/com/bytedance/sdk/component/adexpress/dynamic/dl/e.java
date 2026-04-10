package com.bytedance.sdk.component.adexpress.dynamic.dl;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.core.view.GravityCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bytedance.sdk.component.adexpress.dynamic.a.kb;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f551a;
    public String dl;
    private String e;
    public String g;
    private m gc;
    private gc m;
    public int z;

    public e(gc gcVar) {
        this.m = gcVar;
        this.z = gcVar.z();
        this.g = gcVar.g();
        this.dl = gcVar.dl();
        this.f551a = gcVar.gc().me();
        this.e = gcVar.a();
        if (com.bytedance.sdk.component.adexpress.a.g() == 1) {
            this.gc = gcVar.e();
        } else {
            this.gc = gcVar.gc();
        }
        if (com.bytedance.sdk.component.adexpress.a.z()) {
            this.gc = gcVar.gc();
        }
    }

    public int z() {
        return (int) this.gc.v();
    }

    public int g() {
        return (int) this.gc.p();
    }

    public int dl() {
        return (int) this.gc.pf();
    }

    public int a() {
        return (int) this.gc.ls();
    }

    public float gc() {
        return this.gc.fv();
    }

    public String m() {
        if (this.z != 0) {
            return "";
        }
        if (!TextUtils.isEmpty(this.g)) {
            return this.g;
        }
        return this.f551a.optString(com.bytedance.sdk.component.adexpress.a.gz.a(com.bytedance.sdk.component.adexpress.a.getContext()));
    }

    public int e() {
        return z(this.gc.iq());
    }

    public int gz() {
        String strQ = this.gc.q();
        if (TtmlNode.LEFT.equals(strQ)) {
            return 17;
        }
        if (TtmlNode.CENTER.equals(strQ)) {
            return 4;
        }
        return TtmlNode.RIGHT.equals(strQ) ? 3 : 2;
    }

    public int fo() {
        int iGz = gz();
        if (iGz == 4) {
            return 17;
        }
        return iGz == 3 ? GravityCompat.END : GravityCompat.START;
    }

    public String uy() {
        int i = this.z;
        return (i == 2 || i == 13) ? this.g : "";
    }

    public String kb() {
        int i = this.z;
        return (i == 1 || i == 29) ? this.g : "";
    }

    public String wp() {
        return this.e;
    }

    public double i() {
        if (this.z == 11) {
            try {
                return !com.bytedance.sdk.component.adexpress.a.z() ? (int) r0 : Double.parseDouble(this.g);
            } catch (NumberFormatException unused) {
            }
        }
        return -1.0d;
    }

    public double v() {
        return this.gc.js();
    }

    public float pf() {
        return this.gc.kb();
    }

    public int ls() {
        return z(this.gc.sy());
    }

    public float p() {
        return this.gc.wp();
    }

    public int fv() {
        return this.gc.xo();
    }

    public int js() {
        return this.gc.bw();
    }

    public boolean tb() {
        return this.gc.xf();
    }

    public String q() {
        return this.gc.io();
    }

    public void z(float f) {
        this.gc.z(f);
    }

    public boolean iq() {
        return this.gc.j();
    }

    public int zw() {
        return this.gc.gp();
    }

    public String io() {
        return this.gc.oq();
    }

    public String uf() {
        return this.gc.vt();
    }

    public long sy() {
        return this.gc.pd();
    }

    public int hh() {
        String strOq = this.gc.oq();
        if ("skip-with-time-skip-btn".equals(this.m.getType()) || "skip".equals(this.m.getType()) || TextUtils.equals("skip-with-countdowns-skip-btn", this.m.getType())) {
            return 6;
        }
        if (!"skip-with-time-countdown".equals(this.m.getType()) && !"skip-with-time".equals(this.m.getType())) {
            if (this.z == 10 && TextUtils.equals(this.gc.wj(), "click")) {
                return 5;
            }
            if (vo() && lk()) {
                return 0;
            }
            if (vo()) {
                return 7;
            }
            if ("feedback-dislike".equals(this.m.getType())) {
                return 3;
            }
            if (!TextUtils.isEmpty(strOq) && !strOq.equals("none")) {
                if (strOq.equals("video") || (this.m.z() == 7 && TextUtils.equals(strOq, "normal"))) {
                    return (com.bytedance.sdk.component.adexpress.a.z() && this.m.gc() != null && this.m.gc().dh()) ? 11 : 4;
                }
                if (strOq.equals("normal")) {
                    return 1;
                }
                return (strOq.equals("creative") || "slide".equals(this.gc.wj())) ? 2 : 0;
            }
        }
        return 0;
    }

    private boolean vo() {
        return (com.bytedance.sdk.component.adexpress.a.z() && (this.m.getType().contains("logo-union") || this.m.getType().contains("logounion") || this.m.getType().contains("logoad"))) || "logo-union".equals(this.m.getType()) || "logounion".equals(this.m.getType()) || "logoad".equals(this.m.getType());
    }

    public int l() {
        return z(this.gc.zw());
    }

    public double h() {
        return this.gc.gz();
    }

    public int gk() {
        return this.gc.dl();
    }

    public int x() {
        return this.gc.g();
    }

    public int lq() {
        return this.gc.gc();
    }

    public int mc() {
        return this.gc.a();
    }

    public int un() {
        return this.gc.fo();
    }

    public String ti() {
        return this.gc.uy();
    }

    public String eo() {
        return this.gc.wj();
    }

    private boolean lk() {
        if (com.bytedance.sdk.component.adexpress.a.z()) {
            return false;
        }
        return (!TextUtils.isEmpty(this.g) && this.g.contains("adx:")) || kb.g();
    }

    public static int z(String str) {
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

    public static float[] g(String str) {
        String[] strArrSplit = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(",");
        return (strArrSplit == null || strArrSplit.length != 4) ? new float[]{0.0f, 0.0f, 0.0f, 0.0f} : new float[]{Float.parseFloat(strArrSplit[0]), Float.parseFloat(strArrSplit[1]), Float.parseFloat(strArrSplit[2]), Float.parseFloat(strArrSplit[3])};
    }

    public boolean z(int i) {
        gc gcVar = this.m;
        if (gcVar == null) {
            return false;
        }
        if (i == 1) {
            this.gc = gcVar.e();
        } else {
            this.gc = gcVar.gc();
        }
        return this.gc != null;
    }

    public boolean oq() {
        return this.gc.r();
    }

    public int wj() {
        return this.gc.bm();
    }

    public int na() {
        return this.gc.yz();
    }

    public String xl() {
        return this.gc.eo();
    }

    public boolean j() {
        return this.gc.ly();
    }

    public int gp() {
        return this.gc.e();
    }

    public int t() {
        return this.gc.dt();
    }

    public int vm() {
        return this.gc.zb();
    }

    public int y() {
        return this.gc.hn();
    }

    public int ec() {
        return this.gc.lk();
    }

    public boolean bv() {
        return this.gc.wo();
    }

    public String gb() {
        return this.gc.h();
    }

    public String jq() {
        return this.gc.k();
    }

    public String sv() {
        return this.gc.zd();
    }

    public boolean f() {
        return this.gc.i();
    }

    public boolean yx() {
        return this.gc.x();
    }

    public String qd() {
        return this.gc.gk();
    }

    public int zx() {
        return this.gc.lq();
    }

    public int b() {
        return this.gc.mc();
    }

    public double lw() {
        return this.gc.un();
    }

    public double rv() {
        return this.gc.ti();
    }

    public int tc() {
        return this.gc.wx();
    }

    public String me() {
        return this.gc.lt();
    }

    public String nh() {
        return this.gc.u();
    }

    public boolean r() {
        return this.gc.sf();
    }

    public int yz() {
        return this.gc.n();
    }

    public int bm() {
        return this.gc.s();
    }

    public int sd() {
        return this.gc.yw();
    }

    public boolean tf() {
        return this.gc.wo();
    }

    public String ja() {
        return this.gc.uf();
    }

    public String wn() {
        return this.z == 29 ? this.dl : "";
    }

    public List<String> nb() {
        return this.gc.mn();
    }

    public boolean zz() {
        return this.gc.jz();
    }
}
