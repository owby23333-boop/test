package com.duokan.reader.ui.store.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/duokan/reader/ui/store/utils/ClickFrom;", "", "from", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getFrom", "()Ljava/lang/String;", "AD_ITEM", "APPOINTMENT", "BUTTON_CLOSE", "EXIT_APP", "DkStore_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum ClickFrom {
    AD_ITEM("广告素材"),
    APPOINTMENT("预约按钮"),
    BUTTON_CLOSE("关闭按钮"),
    EXIT_APP("退出应用");


    @NotNull
    private final String from;

    ClickFrom(String str) {
        this.from = str;
    }

    @NotNull
    public final String getFrom() {
        return this.from;
    }

    /* synthetic */ ClickFrom(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str);
    }
}
