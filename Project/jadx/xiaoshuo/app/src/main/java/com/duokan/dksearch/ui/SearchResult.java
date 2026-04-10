package com.duokan.dksearch.ui;

import com.duokan.reader.ui.store.book.data.Result;
import com.duokan.reader.ui.store.data.cms.Data;
import com.google.gson.annotations.SerializedName;
import com.yuewen.iw2;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public class SearchResult<T extends Data> extends Result<T> {

    @SerializedName("cate")
    public SearchResultCate<T> cate;

    @SerializedName("key_words_cut")
    public List<String> searchWords;

    @SerializedName("tag")
    public SearchResultTag<T> tag;

    public static class SearchResultCate<E extends Data> extends Data {

        @SerializedName("fictions")
        public List<E> cateList;
        public int category_id;
        public String label;

        @SerializedName("cate_type")
        public String type;
    }

    public static class SearchResultTag<E extends Data> extends Data {
        public int id;
        public String label;

        @SerializedName("fictions")
        public List<E> tagList;

        @SerializedName(iw2.F)
        public String type;
    }
}
