package com.amgcyo.cuttadon.view.read.page;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import java.io.File;

/* JADX INFO: compiled from: ReadConstant.java */
/* JADX INFO: loaded from: classes.dex */
public class m {
    public static int a(int i2) {
        if (i2 == 0) {
            return 15;
        }
        if (i2 != 2) {
            return i2 != 3 ? 28 : 48;
        }
        return 38;
    }

    public static boolean a(Context context) {
        return k.c(context).a() != PageMode.SCROLL.ordinal();
    }

    public static Typeface b(String str) {
        Typeface typeface = Typeface.DEFAULT;
        if (str != null) {
            try {
                if (str.length() > 0) {
                    File file = new File(str);
                    return (!file.exists() || file.length() <= 10) ? typeface : Typeface.createFromFile(str);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return typeface;
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return me.jessyan.art.b.c.a().a(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String a() {
        int iLastIndexOf;
        String strA = a("");
        return (TextUtils.isEmpty(strA) || (iLastIndexOf = strA.lastIndexOf("-")) == -1) ? strA : strA.substring(0, iLastIndexOf);
    }
}
