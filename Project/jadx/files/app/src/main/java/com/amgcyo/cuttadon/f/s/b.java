package com.amgcyo.cuttadon.f.s;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import com.amgcyo.cuttadon.f.s.a;
import java.util.Random;

/* JADX INFO: compiled from: RouterFragment.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends Fragment {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private SparseArray<a.InterfaceC0088a> f3720s = new SparseArray<>();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Random f3721t = new Random();

    private int a() {
        int iNextInt;
        int i2 = 0;
        do {
            iNextInt = this.f3721t.nextInt(65535);
            i2++;
            if (this.f3720s.indexOfKey(iNextInt) < 0) {
                break;
            }
        } while (i2 < 10);
        return iNextInt;
    }

    public static b b() {
        return new b();
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        a.InterfaceC0088a interfaceC0088a = this.f3720s.get(i2);
        this.f3720s.remove(i2);
        if (interfaceC0088a != null) {
            interfaceC0088a.a(i3, intent);
        }
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    public void startActivityForResult(Intent intent, a.InterfaceC0088a interfaceC0088a) {
        int iA = a();
        this.f3720s.put(iA, interfaceC0088a);
        startActivityForResult(intent, iA);
    }
}
