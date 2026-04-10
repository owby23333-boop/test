package com.kwad.sdk.core.adlog.c;

import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.report.h;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aj;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class a extends com.kwad.sdk.core.response.a.a {
    public long PL;
    public String Pj;
    public a.C0392a Pk;
    public int To;
    public AdTemplate adTemplate;
    public int adnMaterialType;
    public String adnMaterialUrl;
    public String adnName;
    public int adnType;
    public int awx;
    public JSONObject axI;
    public int axJ;
    public int axK;
    public int axL;
    public int axM;
    public String axN;
    public String axR;
    public String axS;
    public String axT;
    public int axU;
    public int axV;
    public int axX;
    public String axY;
    public int axZ;
    public int aya;
    public String ayc;
    public int ayd;
    public int aye;
    public String ayf;
    public String ayg;
    public int ayh;
    public int ayi;
    public long ayj;
    public long ayk;
    public int ayn;
    public int ayo;
    public String ayq;
    public int ays;
    public int ayt;
    public int ayu;
    public int ayv;
    public String ayx;
    public int downloadSource;
    public int mI;
    public aj.a mK;
    public double mL;
    public long yU;
    public long axO = -1;
    public int axP = -1;
    public long axQ = -1;
    public int axW = -1;
    public int Pl = 0;
    public String ayb = "";
    public int ayl = -1;
    public int aym = -1;
    public int downloadStatus = 0;
    public int ayp = -1;
    public int Pi = -1;
    public int ayr = -1;
    public int adxResult = -1;
    public int Pm = -1;
    public int ayw = 0;

    public static a EK() {
        return new a();
    }

    public final void cW(int i) {
        if (i == 0) {
            this.ayt = 1;
        } else if (i == 1) {
            this.ayt = 2;
        } else {
            if (i != 2) {
                return;
            }
            this.ayt = 3;
        }
    }

    public final void a(h hVar) {
        if (hVar != null) {
            this.ayx = hVar.Iu();
        }
    }

    public final void e(AdTemplate adTemplate, String str, String str2) {
        a.C0392a c0392a = this.Pk;
        if (c0392a == null) {
            a.C0392a c0392a2 = new a.C0392a();
            this.Pk = c0392a2;
            c0392a2.a(adTemplate, null, null, null);
        } else if (c0392a.axk == null) {
            this.Pk.a(adTemplate, null, null, null);
        }
    }

    public final a cX(int i) {
        this.mI = i;
        return this;
    }

    public final a dr(String str) {
        this.Pj = str;
        return this;
    }

    public final a e(aj.a aVar) {
        this.mK = aVar;
        return this;
    }

    public final a cY(int i) {
        this.Pl = i;
        return this;
    }

    public final a cZ(int i) {
        this.Pm = i;
        return this;
    }

    public final a da(int i) {
        this.Pi = i;
        return this;
    }

    public final a a(a.C0392a c0392a) {
        this.Pk = c0392a;
        return this;
    }

    public final a au(long j) {
        this.yU = j;
        return this;
    }

    public final a av(long j) {
        this.PL = j;
        return this;
    }

    public final a db(int i) {
        this.To = i;
        return this;
    }

    public final a dc(int i) {
        this.ayd = i;
        return this;
    }

    public final a.C0392a EL() {
        return this.Pk;
    }
}
