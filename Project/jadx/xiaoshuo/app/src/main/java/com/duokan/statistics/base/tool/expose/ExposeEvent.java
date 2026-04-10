package com.duokan.statistics.base.tool.expose;

import com.duokan.statistics.base.tool.ReportField;
import com.market.sdk.reflect.ReflectUtilsForMiui;
import com.yuewen.jv1;
import com.yuewen.we2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/duokan/statistics/base/tool/expose/ExposeEvent;", "Lcom/yuewen/jv1;", "", "page", "Ljava/lang/String;", "i", "()Ljava/lang/String;", "eventName", ReflectUtilsForMiui.OBJECT_CONSTRUCTOR, "(Ljava/lang/String;Ljava/lang/String;)V", "Statistics_release"}, k = 1, mv = {1, 8, 0})
public class ExposeEvent extends jv1 {

    @ReportField(name = "page")
    @NotNull
    private final String page;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExposeEvent(@NotNull String eventName, @we2 @NotNull String page) {
        super(eventName);
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(page, "page");
        this.page = page;
    }

    @NotNull
    /* JADX INFO: renamed from: i, reason: from getter */
    public final String getPage() {
        return this.page;
    }
}
