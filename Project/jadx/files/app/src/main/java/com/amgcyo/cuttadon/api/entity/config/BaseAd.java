package com.amgcyo.cuttadon.api.entity.config;

import java.io.Serializable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public class BaseAd implements Serializable {
    protected boolean isNoExempt;
    private int load_type = 0;
    protected String platform;
    private transient String stochasticKey;
    protected int style;

    public BaseAd() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj instanceof BaseAd ? this.platform.equals(((BaseAd) obj).platform) : super.equals(obj);
    }

    public int getLoad_type() {
        return this.load_type;
    }

    public String getPlatform() {
        return this.platform;
    }

    public String getStochasticKey() {
        return this.stochasticKey;
    }

    public int getStyle() {
        return this.style;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean isNoExempt() {
        return this.isNoExempt;
    }

    public void setLoad_type(int i2) {
        this.load_type = i2;
    }

    public void setNoExempt(boolean z2) {
        this.isNoExempt = z2;
    }

    public void setPlatform(String str) {
        this.platform = str;
    }

    public void setStochasticKey(String str) {
        this.stochasticKey = str;
    }

    public void setStyle(int i2) {
        this.style = i2;
    }

    @NotNull
    public String toString() {
        return "BaseAd{style=" + this.style + ", platform='" + this.platform + "', stochasticKey='" + this.stochasticKey + "'}";
    }

    public BaseAd(String str, int i2) {
        this.platform = str;
        this.style = i2;
    }
}
