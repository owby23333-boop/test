package com.amgcyo.cuttadon.api.entity.config;

import java.io.Serializable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public class JsonColorStyle implements Serializable {
    private int footerColor;
    private String key;
    private int panelBgColor;
    private int textColor;
    private int tint;

    public JsonColorStyle() {
    }

    public int getFooterColor() {
        return this.footerColor;
    }

    public String getKey() {
        return this.key;
    }

    public int getPanelBgColor() {
        return this.panelBgColor;
    }

    public int getTextColor() {
        return this.textColor;
    }

    public int getTint() {
        return this.tint;
    }

    public void setFooterColor(int i2) {
        this.footerColor = i2;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setPanelBgColor(int i2) {
        this.panelBgColor = i2;
    }

    public void setTextColor(int i2) {
        this.textColor = i2;
    }

    public void setTint(int i2) {
        this.tint = i2;
    }

    @NotNull
    public String toString() {
        return "JsonColorStyle{panelBgColor=" + this.panelBgColor + ", textColor=" + this.textColor + ", footerColor=" + this.footerColor + ", key='" + this.key + "', tint=" + this.tint + '}';
    }

    public JsonColorStyle(int i2, int i3, int i4, String str, int i5) {
        this.panelBgColor = i2;
        this.textColor = i3;
        this.footerColor = i4;
        this.key = str;
        this.tint = i5;
    }
}
