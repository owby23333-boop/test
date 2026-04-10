package com.yuewen;

import com.duokan.bean.StoreType;
import com.duokan.reader.ReaderEnv;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes14.dex */
public final class j01 {
    public static final boolean a(@NotNull List<StoreType> list, @Nullable List<StoreType> list2) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list2 == null || list2.size() != list.size()) {
            return false;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!Intrinsics.areEqual(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public static final String b(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return (!Intrinsics.areEqual(str, ReaderEnv.o1) && Intrinsics.areEqual(str, ReaderEnv.p1)) ? "4" : "3";
    }

    @NotNull
    public static final String c(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Intrinsics.areEqual(str, ReaderEnv.o1) ? "3" : Intrinsics.areEqual(str, ReaderEnv.p1) ? "4" : "0";
    }
}
