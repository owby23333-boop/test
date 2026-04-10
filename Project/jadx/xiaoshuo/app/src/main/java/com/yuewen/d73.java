package com.yuewen;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes12.dex */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
public @interface d73 {
    int oriAccess() default 184;

    Class oriClass();

    String oriMethod() default "";

    String oriMethodDesc() default "";
}
