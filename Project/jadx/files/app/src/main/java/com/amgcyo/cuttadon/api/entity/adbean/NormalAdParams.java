package com.amgcyo.cuttadon.api.entity.adbean;

import com.amgcyo.cuttadon.api.entity.config.BaseAd;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class NormalAdParams implements Serializable {
    private int adCount;
    private int adHeight;
    private String adPosition;
    private String adUnitId;
    private int adWidth;
    private BaseAd baseAd;
    private boolean bigAd;
    private boolean failRestart;
    private int form;
    private boolean isChapingAd;
    private int refreshTime;
    private boolean requireExpam;
    private String[] selfAdPosition;
    private boolean specialAdPosition;
    private String stochasticKey;
    private int styleType;

    public NormalAdParams() {
        this.adPosition = "csj_new_position_book_city";
        this.form = 1;
        this.adCount = 1;
        this.styleType = 1;
        this.specialAdPosition = false;
        this.bigAd = false;
        this.failRestart = false;
    }

    public int getAdCount() {
        return this.adCount;
    }

    public int getAdHeight() {
        return this.adHeight;
    }

    public String getAdPosition() {
        return this.adPosition;
    }

    public String getAdUnitId() {
        return this.adUnitId;
    }

    public int getAdWidth() {
        return this.adWidth;
    }

    public BaseAd getBaseAd() {
        return this.baseAd;
    }

    public int getForm() {
        return this.form;
    }

    public int getRefreshTime() {
        return this.refreshTime;
    }

    public String[] getSelfAdPosition() {
        return this.selfAdPosition;
    }

    public String getStochasticKey() {
        return this.stochasticKey;
    }

    public int getStyleType() {
        return this.styleType;
    }

    public boolean isBigAd() {
        return this.bigAd;
    }

    public boolean isChapingAd() {
        return this.isChapingAd;
    }

    public boolean isFailRestart() {
        return this.failRestart;
    }

    public boolean isRequireExpam() {
        return this.requireExpam;
    }

    public boolean isSpecialAdPosition() {
        return this.specialAdPosition;
    }

    public void setAdCount(int i2) {
        this.adCount = i2;
    }

    public void setAdHeight(int i2) {
        this.adHeight = i2;
    }

    public void setAdPosition(String str) {
        this.adPosition = str;
    }

    public void setAdUnitId(String str) {
        this.adUnitId = str;
    }

    public void setAdWidth(int i2) {
        this.adWidth = i2;
    }

    public void setBaseAd(BaseAd baseAd) {
        this.baseAd = baseAd;
    }

    public void setBigAd(boolean z2) {
        this.bigAd = z2;
    }

    public void setChapingAd(boolean z2) {
        this.isChapingAd = z2;
    }

    public void setFailRestart(boolean z2) {
        this.failRestart = z2;
    }

    public void setForm(int i2) {
        this.form = i2;
    }

    public void setRefreshTime(int i2) {
        this.refreshTime = i2;
    }

    public void setRequireExpam(boolean z2) {
        this.requireExpam = z2;
    }

    public void setSelfAdPosition(String[] strArr) {
        this.selfAdPosition = strArr;
    }

    public void setSpecialAdPosition(boolean z2) {
        this.specialAdPosition = z2;
    }

    public void setStochasticKey(String str) {
        this.stochasticKey = str;
    }

    public void setStyleType(int i2) {
        this.styleType = i2;
    }

    public NormalAdParams(String str) {
        this.adPosition = "csj_new_position_book_city";
        this.form = 1;
        this.adCount = 1;
        this.styleType = 1;
        this.specialAdPosition = false;
        this.bigAd = false;
        this.failRestart = false;
        this.adPosition = str;
    }

    public NormalAdParams(String str, String str2, int i2, boolean z2) {
        this.adPosition = "csj_new_position_book_city";
        this.form = 1;
        this.adCount = 1;
        this.styleType = 1;
        this.specialAdPosition = false;
        this.bigAd = false;
        this.failRestart = false;
        this.stochasticKey = str;
        this.adPosition = str2;
        this.form = i2;
        this.requireExpam = z2;
    }

    public NormalAdParams(String str, String str2, boolean z2) {
        this.adPosition = "csj_new_position_book_city";
        this.form = 1;
        this.adCount = 1;
        this.styleType = 1;
        this.specialAdPosition = false;
        this.bigAd = false;
        this.failRestart = false;
        this.stochasticKey = str;
        this.adPosition = str2;
        this.requireExpam = z2;
    }

    public NormalAdParams(boolean z2, String str, String str2, boolean z3) {
        this.adPosition = "csj_new_position_book_city";
        this.form = 1;
        this.adCount = 1;
        this.styleType = 1;
        this.specialAdPosition = false;
        this.bigAd = false;
        this.failRestart = false;
        this.specialAdPosition = z2;
        this.stochasticKey = str;
        this.adPosition = str2;
        this.requireExpam = z3;
    }

    public NormalAdParams(String str, String str2, int i2) {
        this.adPosition = "csj_new_position_book_city";
        this.form = 1;
        this.adCount = 1;
        this.styleType = 1;
        this.specialAdPosition = false;
        this.bigAd = false;
        this.failRestart = false;
        this.stochasticKey = str;
        this.adPosition = str2;
        this.form = i2;
    }

    public NormalAdParams(String str, int i2) {
        this.adPosition = "csj_new_position_book_city";
        this.form = 1;
        this.adCount = 1;
        this.styleType = 1;
        this.specialAdPosition = false;
        this.bigAd = false;
        this.failRestart = false;
        this.adPosition = str;
        this.form = i2;
    }

    public NormalAdParams(boolean z2, String str, String str2, int i2) {
        this.adPosition = "csj_new_position_book_city";
        this.form = 1;
        this.adCount = 1;
        this.styleType = 1;
        this.specialAdPosition = false;
        this.bigAd = false;
        this.failRestart = false;
        this.specialAdPosition = z2;
        this.stochasticKey = str;
        this.adPosition = str2;
        this.form = i2;
    }

    public NormalAdParams(String str, int i2, int i3) {
        this.adPosition = "csj_new_position_book_city";
        this.form = 1;
        this.adCount = 1;
        this.styleType = 1;
        this.specialAdPosition = false;
        this.bigAd = false;
        this.failRestart = false;
        this.stochasticKey = str;
        this.form = i3;
        this.adWidth = i2;
    }

    public NormalAdParams(String str, String str2) {
        this.adPosition = "csj_new_position_book_city";
        this.form = 1;
        this.adCount = 1;
        this.styleType = 1;
        this.specialAdPosition = false;
        this.bigAd = false;
        this.failRestart = false;
        this.stochasticKey = str;
        this.adPosition = str2;
    }
}
