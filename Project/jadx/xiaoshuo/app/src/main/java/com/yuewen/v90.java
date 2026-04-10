package com.yuewen;

import android.content.Context;
import com.yuewen.st2;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes5.dex */
public class v90 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f18931a = 1000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f18932b = 60000;
    public static final long c = 3600000;
    public static final long d = 86400000;
    public static final long e = 604800000;
    public static final long f = 2592000000L;
    public static final long g = 31104000000L;

    public static String a(Context context, long j) {
        Date date = new Date();
        Date date2 = new Date(j);
        long time = date.getTime() - date2.getTime();
        return time < 300000 ? context.getString(st2.s.kj0) : time < 3600000 ? String.format(context.getString(st2.s.oj0), Integer.valueOf((int) Math.floor(time / 60000))) : time < 86400000 ? String.format(context.getString(st2.s.jj0), Integer.valueOf((int) Math.floor(time / 3600000))) : time < 604800000 ? String.format(context.getString(st2.s.hj0), Integer.valueOf((int) Math.floor(time / 86400000))) : time < 2592000000L ? String.format(context.getString(st2.s.Ej0), Integer.valueOf((int) Math.floor(time / 604800000))) : time < g ? String.format(context.getString(st2.s.pj0), Integer.valueOf((int) Math.floor(time / 2592000000L))) : new SimpleDateFormat(context.getString(st2.s.Fj0)).format(date2);
    }

    public static boolean b(long j) {
        return new Date().getTime() - new Date(j).getTime() >= 2592000000L;
    }
}
