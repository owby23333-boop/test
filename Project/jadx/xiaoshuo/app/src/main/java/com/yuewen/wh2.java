package com.yuewen;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import com.duokan.core.app.AppWrapper;
import com.duokan.core.app.ManagedActivity;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes12.dex */
public abstract class wh2 implements vh2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f19460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String[] f19461b;
    public final CopyOnWriteArrayList<vh2> c = new CopyOnWriteArrayList<>();

    public wh2() {
        String[] strArrC = fi2.d() ? c() : e();
        this.f19461b = strArrC;
        this.f19460a = b(strArrC);
    }

    public boolean a() {
        if (!this.f19460a) {
            this.f19460a = b(this.f19461b);
        }
        return this.f19460a;
    }

    public boolean b(String[] strArr) {
        try {
            for (String str : strArr) {
                if (ContextCompat.checkSelfPermission(AppWrapper.v(), str) != 0) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public abstract String[] c();

    @Override // com.yuewen.vh2
    public synchronized void d() {
        this.f19460a = false;
        Iterator<vh2> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
        this.c.clear();
    }

    public String[] e() {
        return new String[0];
    }

    public boolean f() {
        return this.f19460a;
    }

    public void g(@NonNull ManagedActivity managedActivity, @NonNull vh2 vh2Var) {
        if (h(vh2Var)) {
            if (l32.f()) {
                String[] strArrJ = j(managedActivity);
                if (strArrJ.length > 0) {
                    new gi2(managedActivity, this.f19461b, strArrJ, this).d();
                    return;
                }
            }
            new gw3(managedActivity, this.f19461b, this).d();
        }
    }

    public boolean h(@NonNull vh2 vh2Var) {
        if (this.f19460a) {
            vh2Var.onSuccess();
            return false;
        }
        this.c.addIfAbsent(vh2Var);
        return true;
    }

    @StringRes
    public int[] i() {
        return new int[0];
    }

    public final String[] j(Context context) {
        int[] iArrI = i();
        if (iArrI == null || iArrI.length == 0) {
            return new String[0];
        }
        String[] strArr = new String[iArrI.length];
        for (int i = 0; i < iArrI.length; i++) {
            strArr[i] = context.getString(iArrI[i]);
        }
        return strArr;
    }

    @Override // com.yuewen.vh2
    public synchronized void onSuccess() {
        this.f19460a = true;
        Iterator<vh2> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().onSuccess();
        }
        this.c.clear();
    }
}
