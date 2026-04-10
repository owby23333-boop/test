package com.duokan.reader.ui.store.data;

import androidx.annotation.NonNull;
import com.alipay.sdk.m.y.l;
import com.duokan.reader.ui.store.data.cms.Data;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class LayerFictionItem extends Data {
    public RankData data;
    public String msg;
    public List<String> remark;
    public int result;

    public static class RankData implements Serializable {
        public List<RankFiction> rank;
    }

    public static class RankFiction implements Serializable {
        public String channel;
        public String cover;
        public long date;
        public int duration;
        public long fictionId;
        public long popular;
        public int rank;
        public int readUv;
        public String title;

        @NonNull
        public String toString() {
            return "RankFiction{,channel = '" + this.channel + "',cover = '" + this.cover + "',date = '" + this.date + "',duration = '" + this.duration + "',fictionId = '" + this.fictionId + "',popular = '" + this.popular + "',rank = '" + this.rank + "',readUv = '" + this.readUv + "',title = '" + this.title + '\'' + l.d;
        }
    }

    public boolean hasData() {
        List<RankFiction> list;
        RankData rankData = this.data;
        return (rankData == null || (list = rankData.rank) == null || list.isEmpty()) ? false : true;
    }

    public boolean isSuccess() {
        return this.result == 0;
    }

    public String toString() {
        return "LayerFictionItem{remark = '" + this.remark + "',result = '" + this.result + "',msg = '" + this.msg + "',data = '" + this.data + '\'' + l.d;
    }
}
