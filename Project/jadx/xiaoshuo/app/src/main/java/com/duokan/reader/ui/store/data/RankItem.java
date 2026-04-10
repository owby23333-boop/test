package com.duokan.reader.ui.store.data;

import com.duokan.reader.ui.store.data.cms.Data;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes5.dex */
public class RankItem extends Data {
    private DataItem data;
    private int result;

    public static class DataItem extends Data {
        private int rank;

        @SerializedName("rank_name")
        private String rankName;

        public int getRank() {
            return this.rank;
        }

        public String getRankName() {
            return this.rankName;
        }

        public void setRank(int i) {
            this.rank = i;
        }

        public void setRankName(String str) {
            this.rankName = str;
        }
    }

    public DataItem getData() {
        return this.data;
    }

    public int getResult() {
        return this.result;
    }

    public void setData(DataItem dataItem) {
        this.data = dataItem;
    }

    public void setResult(int i) {
        this.result = i;
    }
}
