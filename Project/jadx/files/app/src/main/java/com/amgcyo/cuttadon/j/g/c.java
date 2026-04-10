package com.amgcyo.cuttadon.j.g;

import com.amgcyo.cuttadon.utils.rxjava.scheduler.SchedulerType;
import io.reactivex.FlowableTransformer;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: RxSchedulerUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    private static Executor a;

    public static Scheduler a(Executor executor) {
        return executor != null ? Schedulers.from(executor) : Schedulers.io();
    }

    public static Executor b() {
        return a;
    }

    public static <T> FlowableTransformer<T, T> a() {
        return new f(SchedulerType._io_main);
    }
}
