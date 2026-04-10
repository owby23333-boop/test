package com.duokan.dkcategory.data.primary;

import com.duokan.dkcategory_export.data.CategoryTag;

/* JADX INFO: loaded from: classes13.dex */
public class PrimaryCoverTag extends CategoryTag {
    public String d;
    public String e;
    public boolean f;

    public PrimaryCoverTag(String id, String label, String coverUrls, boolean isAudio) {
        super(id, label);
        this.d = "";
        this.e = "";
        if (coverUrls != null) {
            try {
                String[] strArrSplit = coverUrls.split(",");
                if (strArrSplit.length > 0) {
                    this.d = strArrSplit[0];
                }
                if (strArrSplit.length > 1) {
                    this.e = strArrSplit[1];
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.c = 1;
        this.f = isAudio;
    }

    public String f() {
        return this.d;
    }

    public String g() {
        return this.e;
    }

    public boolean h() {
        return this.f;
    }
}
