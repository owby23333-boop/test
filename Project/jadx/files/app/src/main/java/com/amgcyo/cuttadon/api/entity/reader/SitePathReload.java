package com.amgcyo.cuttadon.api.entity.reader;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class SitePathReload implements Serializable {
    private long updated_at;

    public SitePathReload(long j2) {
        this.updated_at = j2;
    }

    public long getUpdated_at() {
        return this.updated_at;
    }

    public void setUpdated_at(long j2) {
        this.updated_at = j2;
    }

    public SitePathReload() {
    }
}
