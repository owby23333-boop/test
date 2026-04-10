package com.arialyy.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
public @interface M3U8 {

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.CLASS)
    public @interface onPeerComplete {
        String[] value() default {""};
    }

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.CLASS)
    public @interface onPeerFail {
        String[] value() default {""};
    }

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.CLASS)
    public @interface onPeerStart {
        String[] value() default {""};
    }
}
