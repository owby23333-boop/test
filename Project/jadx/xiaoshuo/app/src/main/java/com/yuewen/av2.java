package com.yuewen;

import com.dangdang.reader.domain.GroupType;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes3.dex */
public class av2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("total_time")
    public int f8888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("total_distribution")
    public JsonObject f8889b;

    @SerializedName("total_rate")
    public int c;

    @SerializedName("finished_books")
    public int d;

    @SerializedName(GroupType.TypeColumn.CREATE_TIME)
    public int e;

    @SerializedName("read_books")
    public int f;
}
