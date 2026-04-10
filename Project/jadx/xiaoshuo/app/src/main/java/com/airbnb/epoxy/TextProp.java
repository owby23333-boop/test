package com.airbnb.epoxy;

import androidx.annotation.StringRes;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.CLASS)
public @interface TextProp {
    @StringRes
    int defaultRes() default 0;
}
