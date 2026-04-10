package com.yuewen;

import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ui.reading.ReadingTheme;
import com.yuewen.gb1;
import com.yuewen.gm;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public class q implements yh1, xl3 {
    public static final int c = 0;
    public static final int d = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f16342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f16343b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final q f16344a = new q();
    }

    public static q c() {
        return a.f16344a;
    }

    @Override // com.yuewen.yh1
    public boolean a() {
        return this.f16343b;
    }

    public void b() {
        h(1);
    }

    public ReadingTheme d() {
        gb1.c cVar = pc0.f15995a;
        if (!com.duokan.reader.e.S().w() || cVar == null) {
            return ReadingTheme.THEME14;
        }
        if (ReaderEnv.get().j5()) {
            List<Integer> listAsList = Arrays.asList(0, 3, 6, Integer.valueOf(Integer.parseInt("d", 16)));
            List<Integer> listAsList2 = Arrays.asList(2, 5, 9, Integer.valueOf(Integer.parseInt("a", 16)));
            List<Integer> listAsList3 = Arrays.asList(1, 8, Integer.valueOf(Integer.parseInt(com.xiaomi.ad.y.j, 16)), Integer.valueOf(Integer.parseInt(gm.a.f11596b, 16)));
            if (cVar.f(listAsList)) {
                return ReadingTheme.THEME22;
            }
            if (cVar.f(listAsList2)) {
                return ReadingTheme.THEME20;
            }
            if (cVar.f(listAsList3)) {
                return ReadingTheme.THEME23;
            }
        }
        return ReadingTheme.THEME14;
    }

    public int e() {
        return ReaderEnv.get().k5();
    }

    public boolean f() {
        return this.f16343b;
    }

    public void g() {
        ReaderEnv.get().H8(true);
        this.f16343b = true;
    }

    public void h(int i) {
        int i2 = this.f16342a;
        if (i2 == i || i2 == 1) {
            return;
        }
        this.f16342a = i;
        ReaderEnv.get().E9(i);
    }

    public boolean i() {
        return this.f16342a < 0;
    }

    public q() {
        this.f16342a = e();
    }
}
