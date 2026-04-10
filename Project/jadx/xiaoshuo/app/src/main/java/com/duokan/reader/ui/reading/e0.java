package com.duokan.reader.ui.reading;

import android.os.CountDownTimer;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class e0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f6037b;

    @Nullable
    public static CountDownTimer d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e0 f6036a = new e0();

    @NotNull
    public static final CopyOnWriteArrayList<a> c = new CopyOnWriteArrayList<>();

    public interface a {
        void a(long j, long j2, long j3, long j4);

        void onFinish(boolean z);
    }

    public static final class b extends CountDownTimer {
        public b(long j) {
            super(j, 1000L);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            e0 e0Var = e0.f6036a;
            e0Var.i(0L);
            Iterator<a> it = e0Var.d().iterator();
            while (it.hasNext()) {
                it.next().onFinish(false);
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            e0 e0Var = e0.f6036a;
            e0Var.i(j);
            long j2 = 3600000;
            long j3 = j / j2;
            long j4 = j % j2;
            long j5 = 60000;
            long j6 = j4 / j5;
            long j7 = (j4 % j5) / ((long) 1000);
            Iterator<a> it = e0Var.d().iterator();
            while (it.hasNext()) {
                it.next().a(j, j3, j6, j7);
            }
        }
    }

    public final void a(@NotNull a listener2) {
        Intrinsics.checkNotNullParameter(listener2, "listener");
        c.add(listener2);
    }

    public final void b() {
        CountDownTimer countDownTimer = d;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        d = null;
        f6037b = 0L;
        c.clear();
    }

    @Nullable
    public final CountDownTimer c() {
        return d;
    }

    @NotNull
    public final CopyOnWriteArrayList<a> d() {
        return c;
    }

    public final long e() {
        return f6037b;
    }

    public final void f(@NotNull a listener2) {
        Intrinsics.checkNotNullParameter(listener2, "listener");
        c.remove(listener2);
    }

    public final void g(@Nullable CountDownTimer countDownTimer) {
        d = countDownTimer;
    }

    public final void h(long j) {
        CountDownTimer countDownTimer = d;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        f6037b = 0L;
        if (j > 0) {
            d = new b(j).start();
            return;
        }
        Iterator<a> it = c.iterator();
        while (it.hasNext()) {
            it.next().onFinish(true);
        }
    }

    public final void i(long j) {
        f6037b = j;
    }
}
