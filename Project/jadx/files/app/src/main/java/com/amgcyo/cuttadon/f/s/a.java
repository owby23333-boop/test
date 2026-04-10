package com.amgcyo.cuttadon.f.s;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

/* JADX INFO: compiled from: ActivityLauncher.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private Context a;
    private c b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f3719c;

    /* JADX INFO: renamed from: com.amgcyo.cuttadon.f.s.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActivityLauncher.java */
    public interface InterfaceC0088a {
        void a(int i2, Intent intent);
    }

    private a(FragmentActivity fragmentActivity) {
        this.a = fragmentActivity;
        this.b = b(fragmentActivity);
    }

    private c a(FragmentActivity fragmentActivity) {
        return (c) fragmentActivity.getSupportFragmentManager().findFragmentByTag("ActivityLauncher");
    }

    private c b(FragmentActivity fragmentActivity) {
        c cVarA = a(fragmentActivity);
        if (cVarA != null) {
            return cVarA;
        }
        c cVarG = c.g();
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        supportFragmentManager.beginTransaction().add(cVarG, "ActivityLauncher").commitAllowingStateLoss();
        supportFragmentManager.executePendingTransactions();
        return cVarG;
    }

    public static a c(FragmentActivity fragmentActivity) {
        return new a(fragmentActivity);
    }

    public void startActivityForResult(Class<?> cls, InterfaceC0088a interfaceC0088a) {
        startActivityForResult(new Intent(this.a, cls), interfaceC0088a);
    }

    private b a(Activity activity) {
        return (b) activity.getFragmentManager().findFragmentByTag("ActivityLauncher");
    }

    public static a c(Activity activity) {
        return new a(activity);
    }

    public void startActivityForResult(Intent intent, InterfaceC0088a interfaceC0088a) {
        c cVar = this.b;
        if (cVar != null) {
            cVar.startActivityForResult(intent, interfaceC0088a);
            return;
        }
        b bVar = this.f3719c;
        if (bVar != null) {
            bVar.startActivityForResult(intent, interfaceC0088a);
            return;
        }
        throw new RuntimeException("please do init first!");
    }

    private a(Activity activity) {
        this.a = activity;
        this.f3719c = b(activity);
    }

    private b b(Activity activity) {
        b bVarA = a(activity);
        if (bVarA != null) {
            return bVarA;
        }
        b bVarB = b.b();
        android.app.FragmentManager fragmentManager = activity.getFragmentManager();
        fragmentManager.beginTransaction().add(bVarB, "ActivityLauncher").commitAllowingStateLoss();
        fragmentManager.executePendingTransactions();
        return bVarB;
    }
}
