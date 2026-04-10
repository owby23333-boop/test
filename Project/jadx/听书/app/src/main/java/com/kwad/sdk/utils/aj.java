package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class aj {
    public static String c(Context context, String str, boolean z) {
        return str.replace("__TS__", String.valueOf(bt.x(context, z)));
    }

    public static String a(String str, a aVar) {
        return (TextUtils.isEmpty(str) || aVar == null) ? str : str.replace("__WIDTH__", eQ(aVar.getWidth())).replace("__HEIGHT__", eQ(aVar.getHeight())).replace("__DOWN_X__", eQ(aVar.QO())).replace("__DOWN_Y__", eQ(aVar.QP())).replace("__UP_X__", eQ(aVar.QQ())).replace("__UP_Y__", eQ(aVar.QR()));
    }

    public static String ao(Context context, String str) {
        return TextUtils.isEmpty(str) ? str : str.replace("__SCREEN_WIDTH__", String.valueOf(m.getScreenWidth(context))).replace("__SCREEN_HEIGHT__", String.valueOf(m.getScreenHeight(context))).replace("__DEVICE_WIDTH__", String.valueOf(m.cI(context))).replace("__DEVICE_HEIGHT__", String.valueOf(m.cJ(context)));
    }

    private static String eQ(int i) {
        return i >= 0 ? String.valueOf(i) : "-999";
    }

    public static class a {
        private int aZH;
        private int aZI;
        private int aZJ;
        private int aZK;
        private int mHeight;
        private int mWidth;

        public a() {
            this.mWidth = -1;
            this.mHeight = -1;
            this.aZH = -1;
            this.aZI = -1;
            this.aZJ = -1;
            this.aZK = -1;
        }

        public a(int i, int i2) {
            this.aZH = -1;
            this.aZI = -1;
            this.aZJ = -1;
            this.aZK = -1;
            this.mWidth = i;
            this.mHeight = i2;
        }

        public final void e(float f, float f2) {
            this.aZH = (int) f;
            this.aZI = (int) f2;
        }

        public final void f(float f, float f2) {
            this.aZJ = (int) f;
            this.aZK = (int) f2;
        }

        public final void B(int i, int i2) {
            this.mWidth = i;
            this.mHeight = i2;
        }

        public final int getWidth() {
            return this.mWidth;
        }

        public final int getHeight() {
            return this.mHeight;
        }

        public final int QO() {
            return this.aZH;
        }

        public final int QP() {
            return this.aZI;
        }

        public final int QQ() {
            return this.aZJ;
        }

        public final int QR() {
            return this.aZK;
        }

        public final String toString() {
            return "TouchCoords{mWidth=" + this.mWidth + ", mHeight=" + this.mHeight + ", mDownX=" + this.aZH + ", mDownY=" + this.aZI + ", mUpX=" + this.aZJ + ", mUpY=" + this.aZK + '}';
        }
    }
}
