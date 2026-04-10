package com.zackratos.ultimatebarx.ultimatebarx.bean;

import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public class BarBackground {
    private int color;
    private int colorRes;
    private int drawableRes;

    public static BarBackground newInstance() {
        BarBackground barBackground = new BarBackground();
        barBackground.defaultBg();
        return barBackground;
    }

    public int getColor() {
        return this.color;
    }

    public int getColorRes() {
        return this.colorRes;
    }

    public int getDrawableRes() {
        return this.drawableRes;
    }

    public void setColor(int i) {
        this.colorRes = -1;
        this.drawableRes = -1;
        this.color = i;
    }

    public void setColorRes(int i) {
        this.color = -16777217;
        this.drawableRes = -1;
        this.colorRes = i;
    }

    public void setDrawableRes(int i) {
        this.color = -16777217;
        this.colorRes = -1;
        this.drawableRes = i;
    }

    public void transparent() {
        this.color = 0;
        this.colorRes = -1;
        this.drawableRes = -1;
    }

    public void defaultBg() {
        this.color = -16777217;
        this.colorRes = -1;
        this.drawableRes = -1;
    }

    public void update(BarBackground barBackground) {
        if (equals(barBackground)) {
            return;
        }
        this.color = barBackground.color;
        this.colorRes = barBackground.colorRes;
        this.drawableRes = barBackground.drawableRes;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BarBackground)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        BarBackground barBackground = (BarBackground) obj;
        return this.color == barBackground.color && this.colorRes == barBackground.colorRes && this.drawableRes == barBackground.drawableRes;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.color), Integer.valueOf(this.colorRes), Integer.valueOf(this.drawableRes));
    }
}
