package com.duokan.reader.domain.store;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class RankInfo implements Serializable {
    public long id;
    public int pos;
    public String slotName;
    public String tab;
    public String type;

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof RankInfo)) {
            return false;
        }
        if (this != obj) {
            RankInfo rankInfo = (RankInfo) obj;
            if (this.pos != rankInfo.pos || !TextUtils.equals(this.slotName, rankInfo.slotName) || !TextUtils.equals(this.tab, rankInfo.tab) || !TextUtils.equals(this.type, rankInfo.type)) {
                return false;
            }
        }
        return true;
    }
}
