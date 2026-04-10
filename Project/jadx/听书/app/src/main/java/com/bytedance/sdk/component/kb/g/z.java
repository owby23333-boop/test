package com.bytedance.sdk.component.kb.g;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface z {
    String z() default "";
}
