package com.yuewen;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes12.dex */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.CLASS)
public @interface b73 {
    Class oriClass();

    String oriField() default "";
}
