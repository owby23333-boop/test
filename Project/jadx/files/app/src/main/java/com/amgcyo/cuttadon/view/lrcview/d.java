package com.amgcyo.cuttadon.view.lrcview;

import android.animation.ValueAnimator;
import java.lang.reflect.Field;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: LrcUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    static {
        Pattern.compile("((\\[\\d\\d:\\d\\d\\.\\d{2,3}\\])+)(.+)");
        Pattern.compile("\\[(\\d\\d):(\\d\\d)\\.(\\d{2,3})\\]");
    }

    static void a() {
        try {
            Field declaredField = ValueAnimator.class.getDeclaredField("sDurationScale");
            declaredField.setAccessible(true);
            declaredField.setFloat(null, 1.0f);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
