package com.amgcyo.cuttadon.f.s;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import androidx.fragment.app.Fragment;
import com.amgcyo.cuttadon.f.s.a;
import java.util.Random;

/* JADX INFO: compiled from: RouterFragmentV4.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends Fragment {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private SparseArray<a.InterfaceC0088a> f3722s = new SparseArray<>();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Random f3723t = new Random();

    private int f() {
        int iNextInt;
        int i2 = 0;
        do {
            iNextInt = this.f3723t.nextInt(65535);
            i2++;
            if (this.f3722s.indexOfKey(iNextInt) < 0) {
                break;
            }
        } while (i2 < 10);
        return iNextInt;
    }

    public static c g() {
        return new c();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        a.InterfaceC0088a interfaceC0088a = this.f3722s.get(i2);
        this.f3722s.remove(i2);
        if (interfaceC0088a != null) {
            interfaceC0088a.a(i3, intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    public void startActivityForResult(Intent intent, a.InterfaceC0088a interfaceC0088a) {
        int iF = f();
        this.f3722s.put(iF, interfaceC0088a);
        startActivityForResult(intent, iF);
    }
}
