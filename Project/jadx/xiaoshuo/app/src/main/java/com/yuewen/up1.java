package com.yuewen;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes12.dex */
@Target({ElementType.TYPE})
@Documented
@Retention(RetentionPolicy.CLASS)
public @interface up1 {
    String value() default "";
}
