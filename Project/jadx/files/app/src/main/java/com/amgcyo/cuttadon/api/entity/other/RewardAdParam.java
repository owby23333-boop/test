package com.amgcyo.cuttadon.api.entity.other;

import com.amgcyo.cuttadon.api.entity.config.BaseAd;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class RewardAdParam extends BaseAd implements Serializable {
    private String adPosition;
    private String codeId;
    private int errorCode;
    private String errorMsg;
    private int form;
    private int loadType;
    private int orientation;

    public RewardAdParam(String str, String str2, String str3, int i2, int i3, int i4) {
        this.loadType = 0;
        this.form = 1;
        this.orientation = 1;
        this.platform = str;
        this.adPosition = str2;
        this.codeId = str3;
        this.loadType = i2;
        this.form = i3;
        this.style = i4;
    }

    public String getAdPosition() {
        return this.adPosition;
    }

    public String getCodeId() {
        return this.codeId;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public int getForm() {
        return this.form;
    }

    public int getLoadType() {
        return this.loadType;
    }

    public int getOrientation() {
        return this.orientation;
    }

    @Override // com.amgcyo.cuttadon.api.entity.config.BaseAd
    public String getPlatform() {
        return this.platform;
    }

    @Override // com.amgcyo.cuttadon.api.entity.config.BaseAd
    public int getStyle() {
        return this.style;
    }

    public void setAdPosition(String str) {
        this.adPosition = str;
    }

    public void setCodeId(String str) {
        this.codeId = str;
    }

    public void setErrorCode(int i2) {
        this.errorCode = i2;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public void setForm(int i2) {
        this.form = i2;
    }

    public void setLoadType(int i2) {
        this.loadType = i2;
    }

    public void setOrientation(int i2) {
        this.orientation = i2;
    }

    @Override // com.amgcyo.cuttadon.api.entity.config.BaseAd
    public void setPlatform(String str) {
        this.platform = str;
    }

    @Override // com.amgcyo.cuttadon.api.entity.config.BaseAd
    public void setStyle(int i2) {
        this.style = i2;
    }

    public RewardAdParam(String str, String str2) {
        this.loadType = 0;
        this.form = 1;
        this.orientation = 1;
        this.adPosition = str;
        this.codeId = str2;
    }

    public RewardAdParam(String str, String str2, String str3) {
        this.loadType = 0;
        this.form = 1;
        this.orientation = 1;
        this.adPosition = str2;
        this.codeId = str3;
        this.platform = str;
    }

    public RewardAdParam(String str, String str2, String str3, int i2, boolean z2) {
        this.loadType = 0;
        this.form = 1;
        this.orientation = 1;
        this.adPosition = str2;
        this.codeId = str3;
        this.platform = str;
        this.style = i2;
        this.isNoExempt = z2;
    }

    public RewardAdParam(String str) {
        this.loadType = 0;
        this.form = 1;
        this.orientation = 1;
        this.adPosition = str;
    }

    public RewardAdParam() {
        this.loadType = 0;
        this.form = 1;
        this.orientation = 1;
    }
}
