package com.arialyy.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
public @interface Download {

    @Target({ElementType.METHOD})
    @Deprecated
    @Retention(RetentionPolicy.CLASS)
    public @interface onNoSupportBreakPoint {
        String[] value() default {""};
    }

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.CLASS)
    public @interface onPre {
        String[] value() default {""};
    }

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.CLASS)
    public @interface onTaskCancel {
        String[] value() default {""};
    }

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.CLASS)
    public @interface onTaskComplete {
        String[] value() default {""};
    }

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.CLASS)
    public @interface onTaskFail {
        String[] value() default {""};
    }

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.CLASS)
    public @interface onTaskPre {
        String[] value() default {""};
    }

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.CLASS)
    public @interface onTaskResume {
        String[] value() default {""};
    }

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.CLASS)
    public @interface onTaskRunning {
        String[] value() default {""};
    }

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.CLASS)
    public @interface onTaskStart {
        String[] value() default {""};
    }

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.CLASS)
    public @interface onTaskStop {
        String[] value() default {""};
    }

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.CLASS)
    public @interface onWait {
        String[] value() default {""};
    }
}
