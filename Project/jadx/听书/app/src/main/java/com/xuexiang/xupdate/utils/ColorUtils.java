package com.xuexiang.xupdate.utils;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import java.util.Random;

/* JADX INFO: loaded from: classes4.dex */
public final class ColorUtils {
    private ColorUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static ColorStateList getColorStateList(int i, int i2) {
        return new ColorStateList(new int[][]{new int[]{R.attr.state_enabled, R.attr.state_pressed}, new int[]{R.attr.state_enabled}, new int[0]}, new int[]{i, i2, -1});
    }

    public static int colorDeep(int i) {
        return Color.argb(Color.alpha(i), (int) (Color.red(i) * 0.8f), (int) (Color.green(i) * 0.8f), (int) (Color.blue(i) * 0.8f));
    }

    public static boolean isColorDark(int i) {
        return 1.0d - ((((((double) Color.red(i)) * 0.299d) + (((double) Color.green(i)) * 0.587d)) + (((double) Color.blue(i)) * 0.114d)) / 255.0d) >= 0.5d;
    }

    public static int getRandomColor(int i, int i2, int i3) {
        return new RandomColor(i, i2, i3).getColor();
    }

    public static int getRandomColor() {
        return new RandomColor(255, 80, 200).getColor();
    }

    public static int getColor(Context context, int i) {
        return context.getResources().getColor(i);
    }

    public static class RandomColor {
        int alpha;
        int lower;
        int upper;

        RandomColor(int i, int i2, int i3) {
            if (i3 <= i2) {
                throw new IllegalArgumentException("must be lower < upper");
            }
            setAlpha(i);
            setLower(i2);
            setUpper(i3);
        }

        public int getColor() {
            return Color.argb(getAlpha(), getLower() + new Random().nextInt((getUpper() - getLower()) + 1), getLower() + new Random().nextInt((getUpper() - getLower()) + 1), getLower() + new Random().nextInt((getUpper() - getLower()) + 1));
        }

        public int getAlpha() {
            return this.alpha;
        }

        public void setAlpha(int i) {
            if (i > 255) {
                i = 255;
            }
            if (i < 0) {
                i = 0;
            }
            this.alpha = i;
        }

        int getLower() {
            return this.lower;
        }

        void setLower(int i) {
            if (i < 0) {
                i = 0;
            }
            this.lower = i;
        }

        int getUpper() {
            return this.upper;
        }

        void setUpper(int i) {
            if (i > 255) {
                i = 255;
            }
            this.upper = i;
        }
    }
}
