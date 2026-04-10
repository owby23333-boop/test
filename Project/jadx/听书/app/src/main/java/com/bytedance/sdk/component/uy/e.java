package com.bytedance.sdk.component.uy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes2.dex */
public class e extends m {
    public static z g;
    public static final int z = Runtime.getRuntime().availableProcessors();
    public static boolean dl = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f805a = 120;

    public static void z(fo foVar) {
        foVar.setPriority(10);
        kb.g.uy().execute(foVar);
    }

    public static ExecutorService z() {
        return kb.g.i();
    }

    public static void g(fo foVar) {
        z().execute(foVar);
    }

    public static void z(fo foVar, int i) {
        foVar.setPriority(i);
        kb.g.i().execute(foVar);
    }

    public static ThreadPoolExecutor g() {
        return kb.g.fo();
    }

    public static void dl(fo foVar) {
        g().execute(foVar);
    }

    public static void a(fo foVar) {
        kb.g.i().execute(foVar);
    }

    public static void g(fo foVar, int i) {
        foVar.setPriority(i);
        kb.g.i().execute(foVar);
    }

    public static ExecutorService dl() {
        return z();
    }

    public static ScheduledExecutorService a() {
        return kb.g.wp();
    }

    public static boolean gc() {
        return dl;
    }

    public static void z(boolean z2) {
        dl = z2;
    }

    public static void z(z zVar) {
        g = zVar;
    }

    public static void gc(fo foVar) {
        kb.g.uy().execute(foVar);
    }

    public static void z(int i) {
        f805a = i;
    }
}
