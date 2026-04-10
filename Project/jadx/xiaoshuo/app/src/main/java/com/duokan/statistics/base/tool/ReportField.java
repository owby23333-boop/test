package com.duokan.statistics.base.tool;

import androidx.annotation.Keep;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes6.dex */
@Target({ElementType.FIELD})
@Keep
@Retention(RetentionPolicy.RUNTIME)
public @interface ReportField {
    @Keep
    String name();
}
