package com.funny.audio.core.ext;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Long.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\u0012\u0010\u0002\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003\u001a\n\u0010\u0005\u001a\u00020\u0003*\u00020\u0001¨\u0006\u0006"}, d2 = {"getEndOfDayTimestamp", "", "toDateString", "", "formatString", "toRelativeTimeDescription", "app_normalRelease"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LongKt {
    public static final String toDateString(long j, String formatString) {
        Intrinsics.checkNotNullParameter(formatString, "formatString");
        String str = DateTimeFormatter.ofPattern(formatString).withZone(ZoneId.systemDefault()).format(Instant.ofEpochMilli(j));
        Intrinsics.checkNotNullExpressionValue(str, "formatter.format(instant)");
        return str;
    }

    public static final String toRelativeTimeDescription(long j) {
        LocalDateTime localDateTimeNow = LocalDateTime.now();
        LocalDateTime localDateTimeOfInstant = LocalDateTime.ofInstant(Instant.ofEpochMilli(j), ZoneId.systemDefault());
        LocalDateTime localDateTime = localDateTimeNow;
        long jBetween = ChronoUnit.HOURS.between(localDateTimeOfInstant, localDateTime);
        long jBetween2 = ChronoUnit.DAYS.between(localDateTimeOfInstant, localDateTime);
        if (jBetween2 > 1) {
            return jBetween2 + "天前";
        }
        return jBetween2 == 1 ? "昨天" : jBetween > 0 ? jBetween + "小时前" : "刚刚";
    }

    public static final long getEndOfDayTimestamp() {
        return ZonedDateTime.of(LocalDate.now().atTime(LocalTime.MAX), ZoneId.systemDefault()).toInstant().toEpochMilli();
    }
}
