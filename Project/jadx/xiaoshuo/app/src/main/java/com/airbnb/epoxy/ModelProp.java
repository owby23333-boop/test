package com.airbnb.epoxy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.CLASS)
public @interface ModelProp {

    public enum Option {
        DoNotHash,
        IgnoreRequireHashCode,
        GenerateStringOverloads,
        NullOnRecycle
    }

    String defaultValue() default "";

    String group() default "";

    Option[] options() default {};

    Option[] value() default {};
}
