package com.kwad.components.ad.splashscreen.widget;

import android.content.Context;
import com.kwad.sdk.utils.ak;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private float IE;
    private int JR;
    private int JS;
    private int JT;
    private int JU;
    private int JV;
    private int JW;
    private Context mContext;

    public static a ai(Context context) {
        return new a(context);
    }

    public static a aj(Context context) {
        return new a(context, 17, 10, 12, 8, 4, 3);
    }

    private a(Context context) {
        this.JR = 24;
        this.JS = 12;
        this.JT = 16;
        this.JU = 12;
        this.JV = 6;
        this.JW = 4;
        this.IE = 1.0f;
        this.mContext = context;
    }

    private a(Context context, int i, int i2, int i3, int i4, int i5, int i6) {
        this.IE = 1.0f;
        this.mContext = context;
        this.JR = 17;
        this.JS = 10;
        this.JT = 12;
        this.JU = 8;
        this.JV = 4;
        this.JW = 3;
    }

    public final void d(float f) {
        this.IE = f;
    }

    public final int no() {
        return (int) (((this.JR - this.JT) / 2) * this.IE);
    }

    public final int np() {
        return (int) (this.JU * this.IE);
    }

    public final ak mR() {
        return new ak(0, (int) (com.kwad.sdk.c.a.a.a(this.mContext, this.JR) * this.IE));
    }

    public final ak nq() {
        int iA = (int) (com.kwad.sdk.c.a.a.a(this.mContext, this.JV) * this.IE);
        int iA2 = (int) (com.kwad.sdk.c.a.a.a(this.mContext, this.JW) * this.IE);
        ak akVar = new ak(0, 0);
        akVar.eT(iA);
        akVar.eU(iA2);
        return akVar;
    }

    public final int nr() {
        return (int) (com.kwad.sdk.c.a.a.b(this.mContext, this.JS) * this.IE);
    }

    public final float ns() {
        return (com.kwad.sdk.c.a.a.a(this.mContext, this.JR) * this.IE) / 2.0f;
    }

    public final ak nt() {
        int iA = (int) (com.kwad.sdk.c.a.a.a(this.mContext, this.JT) * this.IE);
        return new ak(iA, iA);
    }
}
