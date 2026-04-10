package com.airbnb.epoxy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface PackageEpoxyConfig {
    public static final boolean IMPLICITLY_ADD_AUTO_MODELS_DEFAULT = false;
    public static final boolean REQUIRE_ABSTRACT_MODELS_DEFAULT = false;
    public static final boolean REQUIRE_HASHCODE_DEFAULT = false;

    boolean implicitlyAddAutoModels() default false;

    boolean requireAbstractModels() default false;

    boolean requireHashCode() default false;
}
