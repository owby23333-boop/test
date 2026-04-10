package com.yuewen;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class uz3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final uz3 f18853a = new uz3();

    public final boolean a(long j, long j2, int i) {
        long j3 = 60;
        return Math.abs(j - j2) > ((((long) i) * j3) * j3) * ((long) 1000);
    }

    public final boolean b(@NotNull String currentTime, @NotNull String lastTime) {
        Intrinsics.checkNotNullParameter(currentTime, "currentTime");
        Intrinsics.checkNotNullParameter(lastTime, "lastTime");
        try {
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
            long j = Long.parseLong(currentTime);
            long j2 = Long.parseLong(lastTime);
            String str = simpleDateFormat.format(Long.valueOf(j));
            String str2 = simpleDateFormat2.format(Long.valueOf(j2));
            Date date = simpleDateFormat.parse(str);
            Date date2 = simpleDateFormat2.parse(str2);
            calendar.setTime(date);
            calendar2.setTime(date2);
            return c(calendar, calendar2);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public final boolean c(@Nullable Calendar calendar, @Nullable Calendar calendar2) {
        return calendar != null && calendar2 != null && calendar.get(0) == calendar2.get(0) && calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
    }
}
