package com.airbnb.epoxy;

import androidx.annotation.LayoutRes;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface ModelView {

    public enum Size {
        NONE,
        WRAP_WIDTH_WRAP_HEIGHT,
        WRAP_WIDTH_MATCH_HEIGHT,
        MATCH_WIDTH_WRAP_HEIGHT,
        MATCH_WIDTH_MATCH_HEIGHT
    }

    Size autoLayout() default Size.NONE;

    Class<?> baseModelClass() default Void.class;

    @LayoutRes
    int defaultLayout() default 0;

    boolean fullSpan() default true;

    boolean saveViewState() default false;
}
