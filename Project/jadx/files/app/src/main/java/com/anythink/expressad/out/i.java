package com.anythink.expressad.out;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.tencent.smtt.sdk.TbsListener;

/* JADX INFO: loaded from: classes2.dex */
public class i {
    public static final int a = 1;
    public static final int b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f10892c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f10893d = 4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f10894e = 5;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f10895f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f10896g;

    public i(int i2, int i3) {
        if (i2 == 1) {
            this.f10895f = 90;
            this.f10896g = TbsListener.ErrorCode.ERROR_SDKENGINE_INIT_THROWABLE;
            return;
        }
        if (i2 == 2) {
            this.f10895f = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
            this.f10896g = 300;
            return;
        }
        if (i2 == 3) {
            if (com.anythink.expressad.foundation.h.k.f(com.anythink.core.common.b.n.a().g()) < 720) {
                this.f10895f = 50;
                this.f10896g = TbsListener.ErrorCode.ERROR_SDKENGINE_INIT_THROWABLE;
                return;
            } else {
                this.f10895f = 90;
                this.f10896g = 728;
                return;
            }
        }
        if (i2 == 4) {
            this.f10895f = 50;
            this.f10896g = TbsListener.ErrorCode.ERROR_SDKENGINE_INIT_THROWABLE;
        } else {
            if (i2 != 5) {
                return;
            }
            this.f10895f = i3;
            this.f10896g = 0;
        }
    }

    private void c() {
        if (com.anythink.expressad.foundation.h.k.f(com.anythink.core.common.b.n.a().g()) < 720) {
            this.f10895f = 50;
            this.f10896g = TbsListener.ErrorCode.ERROR_SDKENGINE_INIT_THROWABLE;
        } else {
            this.f10895f = 90;
            this.f10896g = 728;
        }
    }

    public final int a() {
        return this.f10895f;
    }

    public final int b() {
        return this.f10896g;
    }
}
