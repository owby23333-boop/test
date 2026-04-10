package com.yuewen;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class wh3 implements sh3, yf2<JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final JSONObject f19462a;

    public wh3(@NotNull JSONObject uploadParams) {
        Intrinsics.checkNotNullParameter(uploadParams, "uploadParams");
        this.f19462a = uploadParams;
    }

    @Override // com.yuewen.yf2
    @NotNull
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public JSONObject b() {
        return this.f19462a;
    }
}
