package com.kwad.sdk.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes4.dex */
public final class ak extends bm {
    private int aZL;
    private int aZM;
    private int aZN;
    private int aZO;

    public static ak a(int i, int i2, int i3, int i4, int i5, int i6) {
        ak akVar = new ak(i, i2);
        akVar.eT(0);
        akVar.eU(0);
        akVar.eR(i4);
        akVar.eS(0);
        return akVar;
    }

    public final ak c(Context context, float f) {
        ak akVar = new ak(com.kwad.sdk.c.a.a.a(context, this.mWidth * f), com.kwad.sdk.c.a.a.a(context, this.mHeight * f));
        akVar.aZN = com.kwad.sdk.c.a.a.a(context, this.aZN * f);
        akVar.aZM = com.kwad.sdk.c.a.a.a(context, this.aZM * f);
        akVar.aZO = com.kwad.sdk.c.a.a.a(context, this.aZO * f);
        akVar.aZL = com.kwad.sdk.c.a.a.a(context, this.aZL * f);
        return akVar;
    }

    public ak(int i, int i2) {
        super(i, i2);
    }

    private int QS() {
        return this.aZL;
    }

    public final void eR(int i) {
        this.aZL = i;
    }

    private int QT() {
        return this.aZM;
    }

    private void eS(int i) {
        this.aZM = i;
    }

    private int QU() {
        return this.aZN;
    }

    public final void eT(int i) {
        this.aZN = i;
    }

    private int QV() {
        return this.aZO;
    }

    public final void eU(int i) {
        this.aZO = i;
    }

    public static void a(View view, ak akVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (akVar.getHeight() > 0) {
            layoutParams.height = akVar.getHeight();
        }
        if (akVar.getWidth() > 0) {
            layoutParams.width = akVar.getWidth();
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (akVar.QU() > 0) {
                marginLayoutParams.leftMargin = akVar.QU();
            }
            if (akVar.QT() > 0) {
                marginLayoutParams.bottomMargin = akVar.QT();
            }
            if (akVar.QV() > 0) {
                marginLayoutParams.rightMargin = akVar.QV();
            }
            if (akVar.QS() > 0) {
                marginLayoutParams.topMargin = akVar.QS();
            }
        }
        view.setLayoutParams(layoutParams);
    }
}
