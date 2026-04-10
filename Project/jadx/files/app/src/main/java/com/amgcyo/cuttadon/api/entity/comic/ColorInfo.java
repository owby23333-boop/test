package com.amgcyo.cuttadon.api.entity.comic;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public class ColorInfo {
    private Drawable drawable;
    private String imgUrl;
    private int vibrantColor = -6710887;
    private int vibrantDarkColor = -6710887;
    private int vibrantLightColor = -6710887;
    private int mutedColor = -6710887;
    private int mutedDarkColor = -6710887;
    private int mutedLightColor = -6710887;

    public Drawable getDrawable() {
        return this.drawable;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public int getMutedColor() {
        return this.mutedColor;
    }

    public int getMutedDarkColor() {
        return this.mutedDarkColor;
    }

    public int getMutedLightColor() {
        return this.mutedLightColor;
    }

    public int getVibrantColor() {
        return this.vibrantColor;
    }

    public int getVibrantDarkColor() {
        return this.vibrantDarkColor;
    }

    public int getVibrantLightColor() {
        return this.vibrantLightColor;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public void setImgUrl(String str) {
        this.imgUrl = str;
    }

    public void setMutedColor(int i2) {
        this.mutedColor = i2;
    }

    public void setMutedDarkColor(int i2) {
        this.mutedDarkColor = i2;
    }

    public void setMutedLightColor(int i2) {
        this.mutedLightColor = i2;
    }

    public void setVibrantColor(int i2) {
        this.vibrantColor = i2;
    }

    public void setVibrantDarkColor(int i2) {
        this.vibrantDarkColor = i2;
    }

    public void setVibrantLightColor(int i2) {
        this.vibrantLightColor = i2;
    }
}
