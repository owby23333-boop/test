package com.amgcyo.cuttadon.api.entity.config;

import androidx.annotation.NonNull;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class DomainBean implements Serializable {
    private String domainName;
    private boolean isCheckEnd;

    public DomainBean() {
    }

    public String getDomainName() {
        return this.domainName;
    }

    public boolean isCheckEnd() {
        return this.isCheckEnd;
    }

    public void setCheckEnd(boolean z2) {
        this.isCheckEnd = z2;
    }

    public void setDomainName(String str) {
        this.domainName = str;
    }

    @NonNull
    public String toString() {
        return "DomainBean{domainName='" + this.domainName + "'}";
    }

    public DomainBean(String str, boolean z2) {
        this.domainName = str;
        this.isCheckEnd = z2;
    }
}
