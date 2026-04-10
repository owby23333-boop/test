package com.bytedance.adsdk.ugeno.tg;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.tg.e$e, reason: collision with other inner class name */
    public static class C0070e {
        public int[] bf;
        public GradientDrawable.Orientation e;
    }

    public static C0070e bf(String str) {
        String[] strArrSplit;
        int[] iArr;
        String strSubstring = str.substring(str.indexOf("(") + 1, str.length() - 1);
        if (strSubstring.contains("rgba") && strSubstring.contains("%")) {
            strArrSplit = new String[]{strSubstring.substring(0, strSubstring.indexOf(",")).trim(), strSubstring.substring(strSubstring.indexOf(",") + 1, strSubstring.indexOf("%") + 1).trim(), strSubstring.substring(strSubstring.indexOf("%") + 2).trim()};
            iArr = new int[]{e(strArrSplit[1]), e(strArrSplit[2])};
        } else {
            strArrSplit = strSubstring.split(", ");
            iArr = new int[]{e(strArrSplit[1].substring(0, 7)), e(strArrSplit[2].substring(0, 7))};
        }
        try {
            double d = Double.parseDouble(strSubstring.substring(strSubstring.indexOf("linear-gradient(") + 1, strSubstring.indexOf("deg")));
            if (d > 225.0d && d < 315.0d) {
                int i = iArr[iArr.length - 1];
                iArr[iArr.length - 1] = iArr[0];
                iArr[0] = i;
            }
        } catch (Exception unused) {
        }
        C0070e c0070e = new C0070e();
        c0070e.e = tg(strArrSplit[0]);
        c0070e.bf = iArr;
        return c0070e;
    }

    public static boolean d(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("linear-gradient");
    }

    public static int e(String str) {
        String[] strArrSplit;
        if (TextUtils.isEmpty(str)) {
            return -16777216;
        }
        if (str.equals("transparent")) {
            return 0;
        }
        if (str.charAt(0) == '#' && str.length() == 4) {
            StringBuilder sb = new StringBuilder("#");
            char[] charArray = str.toCharArray();
            for (int i = 1; i < charArray.length; i++) {
                sb.append(charArray[i]);
                sb.append(charArray[i]);
            }
            return Color.parseColor(sb.toString());
        }
        if (str.charAt(0) == '#' && str.length() == 7) {
            return Color.parseColor(str);
        }
        if (str.charAt(0) == '#' && str.length() == 9) {
            return Color.parseColor(str);
        }
        if (str.startsWith("rgba") && (strArrSplit = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(",")) != null && strArrSplit.length == 4) {
            return (((int) ((Float.parseFloat(strArrSplit[3]) * 255.0f) + 0.5f)) << 24) | (((int) Float.parseFloat(strArrSplit[0])) << 16) | (((int) Float.parseFloat(strArrSplit[1])) << 8) | ((int) Float.parseFloat(strArrSplit[2])) | 0;
        }
        return -16777216;
    }

    public static GradientDrawable.Orientation tg(String str) {
        try {
            int i = Integer.parseInt(str.substring(0, str.length() - 3));
            return i == 90 ? GradientDrawable.Orientation.LEFT_RIGHT : i == 180 ? GradientDrawable.Orientation.TOP_BOTTOM : i == 270 ? GradientDrawable.Orientation.RIGHT_LEFT : i == 135 ? GradientDrawable.Orientation.TL_BR : i == 45 ? GradientDrawable.Orientation.BL_TR : GradientDrawable.Orientation.BOTTOM_TOP;
        } catch (Exception unused) {
            return GradientDrawable.Orientation.LEFT_RIGHT;
        }
    }
}
