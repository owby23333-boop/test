package com.duokan.bean;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.gson.annotations.SerializedName;
import com.yuewen.so2;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0004HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/duokan/bean/HotWordList;", "", "wordList", "", "", "(Ljava/util/List;)V", "getWordList", "()Ljava/util/List;", "component1", so2.od, "equals", "", "other", TTDownloadField.TT_HASHCODE, "", "toString", "network_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class HotWordList {

    @SerializedName("wordList")
    @NotNull
    private final List<String> wordList;

    public HotWordList() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HotWordList copy$default(HotWordList hotWordList, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = hotWordList.wordList;
        }
        return hotWordList.copy(list);
    }

    @NotNull
    public final List<String> component1() {
        return this.wordList;
    }

    @NotNull
    public final HotWordList copy(@NotNull List<String> wordList) {
        Intrinsics.checkNotNullParameter(wordList, "wordList");
        return new HotWordList(wordList);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof HotWordList) && Intrinsics.areEqual(this.wordList, ((HotWordList) other).wordList);
    }

    @NotNull
    public final List<String> getWordList() {
        return this.wordList;
    }

    public int hashCode() {
        return this.wordList.hashCode();
    }

    @NotNull
    public String toString() {
        return "HotWordList(wordList=" + this.wordList + ")";
    }

    public HotWordList(@NotNull List<String> wordList) {
        Intrinsics.checkNotNullParameter(wordList, "wordList");
        this.wordList = wordList;
    }

    public /* synthetic */ HotWordList(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : list);
    }
}
