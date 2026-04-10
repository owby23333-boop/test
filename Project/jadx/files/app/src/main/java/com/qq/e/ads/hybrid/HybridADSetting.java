package com.qq.e.ads.hybrid;

/* JADX INFO: loaded from: classes3.dex */
public class HybridADSetting {
    public static final int TYPE_REWARD_VIDEO = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f17731f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f17732g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f17733h;
    private int a = 1;
    private int b = 44;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f17728c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f17729d = -14013133;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f17730e = 16;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f17734i = -1776153;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f17735j = 16;

    public HybridADSetting backButtonImage(String str) {
        this.f17732g = str;
        return this;
    }

    public HybridADSetting backSeparatorLength(int i2) {
        this.f17735j = i2;
        return this;
    }

    public HybridADSetting closeButtonImage(String str) {
        this.f17733h = str;
        return this;
    }

    public String getBackButtonImage() {
        return this.f17732g;
    }

    public int getBackSeparatorLength() {
        return this.f17735j;
    }

    public String getCloseButtonImage() {
        return this.f17733h;
    }

    public int getSeparatorColor() {
        return this.f17734i;
    }

    public String getTitle() {
        return this.f17731f;
    }

    public int getTitleBarColor() {
        return this.f17728c;
    }

    public int getTitleBarHeight() {
        return this.b;
    }

    public int getTitleColor() {
        return this.f17729d;
    }

    public int getTitleSize() {
        return this.f17730e;
    }

    public int getType() {
        return this.a;
    }

    public HybridADSetting separatorColor(int i2) {
        this.f17734i = i2;
        return this;
    }

    public HybridADSetting title(String str) {
        this.f17731f = str;
        return this;
    }

    public HybridADSetting titleBarColor(int i2) {
        this.f17728c = i2;
        return this;
    }

    public HybridADSetting titleBarHeight(int i2) {
        this.b = i2;
        return this;
    }

    public HybridADSetting titleColor(int i2) {
        this.f17729d = i2;
        return this;
    }

    public HybridADSetting titleSize(int i2) {
        this.f17730e = i2;
        return this;
    }

    public HybridADSetting type(int i2) {
        this.a = i2;
        return this;
    }
}
