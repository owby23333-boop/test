package com.duokan.reader.ui.store;

import android.content.Context;
import com.yuewen.yt2;

/* JADX INFO: loaded from: classes5.dex */
public enum LoadStatus {
    LOADING_MORE,
    LOADING_REFRESH,
    LOADED,
    NO_MORE,
    ERROR;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6409a;

        static {
            int[] iArr = new int[LoadStatus.values().length];
            f6409a = iArr;
            try {
                iArr[LoadStatus.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6409a[LoadStatus.NO_MORE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6409a[LoadStatus.LOADING_MORE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public String getLoadingText(Context context) {
        int i = a.f6409a[ordinal()];
        int i2 = i != 1 ? i != 2 ? i != 3 ? 0 : yt2.r.I8 : yt2.r.J8 : yt2.r.H8;
        return i2 == 0 ? "" : context.getResources().getString(i2);
    }
}
