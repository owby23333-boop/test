package com.kingsoft.iciba.sdk2;

import android.content.Context;
import com.xiaomi.ad.y;
import com.xiaomi.verificationsdk.internal.Constants;
import com.yuewen.gm;
import com.yuewen.ld0;
import com.yuewen.ul1;
import java.io.File;

/* JADX INFO: loaded from: classes7.dex */
public final class Ca {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f7021a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f7022b = f7021a + File.separator + ld0.f13887b;
    public static final String[] c = {"n.", "v.", "vt.", "vi.", "adj.", "adv.", "abbr.", "art.", "pron.", "prep.", "num.", "conj.", "interj.", "int.", "aux.", "na.", "link-v."};
    public static final String[] d = {"n", "v", Constants.TIMESTAMP, "i", "j", "d", y.j, "a", "o", "p", y.k, gm.a.f11596b, "e", "g", "x", "h", gm.a.f11595a};
    public static final String[] e = {"word_ing", "word_pl", "word_past", "word_done", "word_third", "word_er", "word_est", "word_noun", "word_adv", "word_conn", "word_adj", "word_prep", "word_verb"};
    public static final long[] f = {82334488, 69425876, 65895566, 65893569, ul1.c, 65896879, 65897643, 65892187, 65898657, 65689621, 65891439};

    public static void init(Context context) {
        f7021a = context.getExternalFilesDir(null).getAbsolutePath();
        f7022b = f7021a + File.separator + ld0.f13887b;
    }
}
