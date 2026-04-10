package com.zwb.danmaku;

import com.zwb.danmaku.model.BaseDanmaku;
import com.zwb.danmaku.model.d;
import com.zwb.danmaku.model.e;
import com.zwb.danmaku.model.f;
import com.zwb.danmaku.model.g;

/* JADX INFO: compiled from: DanmakuFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: com.zwb.danmaku.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DanmakuFactory.java */
    static /* synthetic */ class C0561a {
        static final /* synthetic */ int[] a = new int[BaseDanmaku.DanmakuType.values().length];

        static {
            try {
                a[BaseDanmaku.DanmakuType.TYPE_SCROLL_LR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[BaseDanmaku.DanmakuType.TYPE_SCROLL_TB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[BaseDanmaku.DanmakuType.TYPE_SCROLL_BT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[BaseDanmaku.DanmakuType.TYPE_SPECIAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[BaseDanmaku.DanmakuType.TYPE_SCROLL_RL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static BaseDanmaku a(BaseDanmaku.DanmakuType danmakuType) {
        int i2 = C0561a.a[danmakuType.ordinal()];
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? new e() : new f() : new com.zwb.danmaku.model.b() : new g() : new d();
    }
}
