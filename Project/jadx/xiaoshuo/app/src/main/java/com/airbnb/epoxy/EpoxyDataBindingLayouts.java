package com.airbnb.epoxy;

import androidx.annotation.LayoutRes;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface EpoxyDataBindingLayouts {
    boolean enableDoNotHash() default true;

    @LayoutRes
    int[] value();
}
