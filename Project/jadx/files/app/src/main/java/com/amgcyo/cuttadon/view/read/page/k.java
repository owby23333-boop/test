package com.amgcyo.cuttadon.view.read.page;

import android.content.Context;
import android.text.TextUtils;
import com.amgcyo.cuttadon.app.MkApplication;
import com.amgcyo.cuttadon.utils.otherutils.c0;
import com.amgcyo.cuttadon.utils.otherutils.g0;
import com.ss.android.download.api.constant.BaseConstants;

/* JADX INFO: compiled from: NovelPreferenceManager.java */
/* JADX INFO: loaded from: classes.dex */
public class k {
    private static volatile k a;
    private static final int[] b = {0, 900000, 1800000, BaseConstants.Time.HOUR, 5400000};

    static {
        new String[]{"0", "1", "3", "4"};
    }

    private k(Context context) {
    }

    private void b(String str, boolean z2) {
        com.amgcyo.cuttadon.utils.comic.d.a(str, Boolean.valueOf(z2));
    }

    public static k c(Context context) {
        if (a == null) {
            synchronized (k.class) {
                if (a == null) {
                    a = new k(context.getApplicationContext());
                }
            }
        }
        return a;
    }

    public static int l(int i2) {
        return a(i2, b) ? b[0] : b[i2];
    }

    public boolean a(String str, boolean z2) {
        return com.amgcyo.cuttadon.utils.comic.d.a(str, z2).booleanValue();
    }

    public String d() {
        return a("read_Voice", "tts_qinggannan");
    }

    public String e() {
        return a("reader_voice_speed", "5");
    }

    public int f() {
        return a("reader_brightness_percent", c0.c(MkApplication.getAppContext()));
    }

    public boolean g() {
        return a("reader_brightness_sys", true);
    }

    public com.amgcyo.cuttadon.utils.otherutils.k h() {
        String strI = i();
        if (com.amgcyo.cuttadon.utils.otherutils.g.h0()) {
            strI = "night";
        }
        return com.amgcyo.cuttadon.utils.otherutils.k.a(strI);
    }

    public void i(int i2) {
        b("reader_tts_bgm", i2);
    }

    public String j() {
        return a("reader_font_path_str", "");
    }

    public void k(int i2) {
        if (i2 < 0 || i2 > 4) {
            return;
        }
        b("reader_voice_time", i2);
    }

    public PageMode m() {
        return PageMode.values()[a("pagemode", PageMode.SIMULATION.ordinal())];
    }

    public int n() {
        return a("screen_orientation", 1);
    }

    public boolean o() {
        return a("reader_str_traditional", false);
    }

    public int p() {
        return a("reader_tts_bgm", 0);
    }

    public int q() {
        return a("lockScreenTime", 120000);
    }

    public int r() {
        return a("reader_voice_time", 0);
    }

    private void b(String str, int i2) {
        com.amgcyo.cuttadon.utils.comic.d.a(str, Integer.valueOf(i2));
    }

    public void a(String str) {
        b("read_Voice", str);
    }

    public void d(int i2) {
        b("reader_brightness_percent", i2);
    }

    public void e(int i2) {
        b("reader_font_size_default", i2);
    }

    public void g(int i2) {
        b("reader_font_size_style", i2);
    }

    public String i() {
        return a("reader_color_style_str", "jade");
    }

    public void j(int i2) {
        b("lockScreenTime", i2);
    }

    public int k() {
        return a("reader_layout_style", 3);
    }

    public int l() {
        return g0.a().a("read_lock_screen_time_index", 3);
    }

    private void b(String str, String str2) {
        com.amgcyo.cuttadon.utils.comic.d.a(str, (Object) str2);
    }

    public int a(String str, int i2) {
        return com.amgcyo.cuttadon.utils.comic.d.a(str, i2).intValue();
    }

    public void d(String str) {
        b("reader_font_path_str", str);
    }

    public void f(int i2) {
        if (i2 > 60) {
            i2 = 60;
        } else if (i2 < 10) {
            i2 = 10;
        }
        b("reader_font_new_size", i2);
    }

    public String a(String str, String str2) {
        return com.amgcyo.cuttadon.utils.comic.d.a(str, str2);
    }

    public void b(boolean z2) {
        b("reader_brightness_sys", z2);
    }

    public void h(int i2) {
        g0.a().b("read_lock_screen_time_index", i2);
    }

    public void a(PageMode pageMode) {
        b("pagemode", pageMode.ordinal());
    }

    public void b(String str) {
        b("reader_voice_speed", str);
    }

    public void a(boolean z2) {
        b("reader_str_traditional", z2);
    }

    public int b(Context context) {
        return a("reader_font_new_size", a(context));
    }

    public int a(Context context) {
        int iA = a("reader_font_size_default", -1);
        if (iA != -1) {
            return iA;
        }
        float f2 = context.getResources().getConfiguration().fontScale;
        int i2 = f2 > 1.300001f ? 29 : f2 > 1.151f ? 26 : f2 > 1.01f ? 23 : f2 > 0.851f ? 20 : 17;
        e(i2);
        return i2;
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b("reader_color_style_str", str);
    }

    public int b() {
        return a("auto_read_index", 3);
    }

    public void b(int i2) {
        if (i2 == 3 || i2 == 4) {
            b("auto_read_index", i2);
        }
    }

    public int c() {
        return a("auto_read_speed", 1);
    }

    public int a() {
        return a("reader_anim_style_1", 0);
    }

    public void c(int i2) {
        if (i2 < 1 || i2 > 8) {
            return;
        }
        b("auto_read_speed", i2);
    }

    public void a(int i2) {
        if (i2 < 0 || i2 > 6) {
            return;
        }
        b("reader_anim_style_1", i2);
    }

    private static boolean a(int i2, int[] iArr) {
        return i2 < 0 || i2 >= iArr.length;
    }
}
