package com.amgcyo.cuttadon.api.entity.config;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class LoadingMsg implements Serializable {
    private String msg;
    private boolean showHide;

    public LoadingMsg(boolean z2, String str) {
        this.showHide = z2;
        this.msg = str;
    }

    public String getMsg() {
        return this.msg;
    }

    public boolean isShowHide() {
        return this.showHide;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setShowHide(boolean z2) {
        this.showHide = z2;
    }
}
