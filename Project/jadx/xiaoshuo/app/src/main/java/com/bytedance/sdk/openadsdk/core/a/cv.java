package com.bytedance.sdk.openadsdk.core.a;

import android.annotation.SuppressLint;
import com.bytedance.sdk.component.vn.tg;

/* JADX INFO: loaded from: classes10.dex */
public final class cv {
    private static volatile boolean e = false;

    public static class bf {

        @SuppressLint({"StaticFieldLeak"})
        static final tg.e e = cv.tg();
    }

    public static class e {

        @SuppressLint({"StaticFieldLeak"})
        static final tg.e e = cv.tg();
    }

    private static String bf(String str) {
        if (e || com.bytedance.sdk.component.utils.l.e(com.bytedance.sdk.openadsdk.core.lc.getContext())) {
            return str;
        }
        return str + com.bytedance.sdk.component.utils.l.bf(com.bytedance.sdk.openadsdk.core.lc.getContext());
    }

    public static com.bytedance.sdk.component.vn.e e(String str) {
        return e.e.e(bf(str)).bf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static tg.e tg() {
        return new tg.e().e(com.bytedance.sdk.openadsdk.core.lc.getContext()).e(com.bytedance.sdk.openadsdk.core.lc.bf().ey() != 1 ? 2 : 1).bf(e);
    }

    public static com.bytedance.sdk.component.vn.e e(String str, boolean z) {
        return bf.e.e(bf(str)).e(z).bf();
    }

    public static void e() {
        e = true;
    }

    public static int bf() {
        if (com.bytedance.sdk.openadsdk.core.lc.bf().ey() == 1) {
            return 2;
        }
        return e.e.e() ? 1 : 0;
    }
}
