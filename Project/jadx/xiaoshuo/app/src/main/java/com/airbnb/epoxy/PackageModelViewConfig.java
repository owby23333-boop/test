package com.airbnb.epoxy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface PackageModelViewConfig {

    public enum Option {
        Default,
        Enabled,
        Disabled
    }

    Class<?> defaultBaseModelClass() default Void.class;

    String defaultLayoutPattern() default "%s";

    Option disableGenerateBuilderOverloads() default Option.Default;

    Option disableGenerateGetters() default Option.Default;

    Option disableGenerateReset() default Option.Default;

    String generatedModelSuffix() default "Model_";

    Class<?> rClass();

    boolean useLayoutOverloads() default false;
}
