package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;

/* JADX INFO: loaded from: classes3.dex */
public final class ab {

    public static class a {
        private int ayL;
        private int ayM;
        private int ayN;
        private int ayO;
        private int mHeight;
        private int mWidth;

        public a() {
            this.mWidth = -1;
            this.mHeight = -1;
            this.ayL = -1;
            this.ayM = -1;
            this.ayN = -1;
            this.ayO = -1;
        }

        public a(int i2, int i3) {
            this.mWidth = -1;
            this.mHeight = -1;
            this.ayL = -1;
            this.ayM = -1;
            this.ayN = -1;
            this.ayO = -1;
            this.mWidth = i2;
            this.mHeight = i3;
        }

        public final int DE() {
            return this.ayL;
        }

        public final int DF() {
            return this.ayM;
        }

        public final int DG() {
            return this.ayN;
        }

        public final int DH() {
            return this.ayO;
        }

        public final void f(float f2, float f3) {
            this.ayL = (int) f2;
            this.ayM = (int) f3;
        }

        public final void g(float f2, float f3) {
            this.ayN = (int) f2;
            this.ayO = (int) f3;
        }

        public final int getHeight() {
            return this.mHeight;
        }

        public final int getWidth() {
            return this.mWidth;
        }

        public final void t(int i2, int i3) {
            this.mWidth = i2;
            this.mHeight = i3;
        }

        public final String toString() {
            return "TouchCoords{mWidth=" + this.mWidth + ", mHeight=" + this.mHeight + ", mDownX=" + this.ayL + ", mDownY=" + this.ayM + ", mUpX=" + this.ayN + ", mUpY=" + this.ayO + '}';
        }
    }

    @WorkerThread
    public static String a(String str, a aVar) {
        return (TextUtils.isEmpty(str) || aVar == null) ? str : str.replace("__WIDTH__", cc(aVar.getWidth())).replace("__HEIGHT__", cc(aVar.getHeight())).replace("__DOWN_X__", cc(aVar.DE())).replace("__DOWN_Y__", cc(aVar.DF())).replace("__UP_X__", cc(aVar.DG())).replace("__UP_Y__", cc(aVar.DH()));
    }

    public static String ag(Context context, String str) {
        return TextUtils.isEmpty(str) ? str : str.replace("__SCREEN_WIDTH__", String.valueOf(k.getScreenWidth(context))).replace("__SCREEN_HEIGHT__", String.valueOf(k.getScreenHeight(context))).replace("__DEVICE_WIDTH__", String.valueOf(k.bU(context))).replace("__DEVICE_HEIGHT__", String.valueOf(k.bV(context)));
    }

    public static String c(@Nullable Context context, String str, boolean z2) {
        return str.replace("__TS__", String.valueOf(be.v(context, z2)));
    }

    private static String cc(int i2) {
        return i2 >= 0 ? String.valueOf(i2) : "-999";
    }
}
