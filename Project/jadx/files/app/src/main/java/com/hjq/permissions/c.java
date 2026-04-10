package com.hjq.permissions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseBooleanArray;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.anythink.china.activity.TransparentActivity;
import com.kuaishou.weapon.p0.g;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PermissionFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends Fragment {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static SparseBooleanArray f16399v = new SparseBooleanArray();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f16400s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f16401t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private com.hjq.permissions.a f16402u;

    /* JADX INFO: compiled from: PermissionFragment.java */
    class a implements com.hjq.permissions.a {
        final /* synthetic */ ArrayList a;

        a(ArrayList arrayList) {
            this.a = arrayList;
        }

        @Override // com.hjq.permissions.a
        public void a(List<String> list, boolean z2) {
            Bundle arguments;
            if (c.this.isAdded() && (arguments = c.this.getArguments()) != null) {
                c.this.requestPermissions((String[]) this.a.toArray(new String[r0.size() - 1]), arguments.getInt(TransparentActivity.b));
            }
        }

        @Override // com.hjq.permissions.a
        public void b(List<String> list, boolean z2) {
            Bundle arguments;
            if (z2 && c.this.isAdded() && (arguments = c.this.getArguments()) != null) {
                c.this.requestPermissions((String[]) this.a.toArray(new String[r0.size() - 1]), arguments.getInt(TransparentActivity.b));
            }
        }
    }

    /* JADX INFO: compiled from: PermissionFragment.java */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.isAdded()) {
                c.this.f();
            }
        }
    }

    public static void a(FragmentActivity fragmentActivity, ArrayList<String> arrayList, com.hjq.permissions.a aVar) {
        int iA;
        c cVar = new c();
        Bundle bundle = new Bundle();
        do {
            iA = e.a();
        } while (f16399v.get(iA));
        f16399v.put(iA, true);
        bundle.putInt(TransparentActivity.b, iA);
        bundle.putStringArrayList("permission_group", arrayList);
        cVar.setArguments(bundle);
        cVar.setRetainInstance(true);
        cVar.a(aVar);
        a(fragmentActivity.getSupportFragmentManager(), cVar);
    }

    public static void b(FragmentManager fragmentManager, Fragment fragment) {
        if (fragmentManager == null) {
            return;
        }
        fragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss();
    }

    public void f() {
        ArrayList<String> stringArrayList;
        Bundle arguments = getArguments();
        if (arguments == null || (stringArrayList = arguments.getStringArrayList("permission_group")) == null || stringArrayList.size() == 0) {
            return;
        }
        ArrayList arrayList = null;
        if (e.b() && stringArrayList.contains("android.permission.ACCESS_BACKGROUND_LOCATION")) {
            arrayList = new ArrayList();
            if (stringArrayList.contains(g.f16728h) && !e.b(getActivity(), g.f16728h)) {
                arrayList.add(g.f16728h);
            }
            if (stringArrayList.contains(g.f16727g) && !e.b(getActivity(), g.f16727g)) {
                arrayList.add(g.f16727g);
            }
        }
        if (arrayList == null || arrayList.isEmpty()) {
            requestPermissions((String[]) stringArrayList.toArray(new String[stringArrayList.size() - 1]), getArguments().getInt(TransparentActivity.b));
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        a(activity, arrayList, new a(stringArrayList));
    }

    public void g() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        ArrayList<String> stringArrayList = arguments.getStringArrayList("permission_group");
        boolean z2 = false;
        if (e.a(stringArrayList)) {
            if (stringArrayList.contains("android.permission.MANAGE_EXTERNAL_STORAGE") && !e.g(getActivity()) && e.c()) {
                startActivityForResult(d.e(getActivity()), getArguments().getInt(TransparentActivity.b));
                z2 = true;
            }
            if (stringArrayList.contains("android.permission.REQUEST_INSTALL_PACKAGES") && !e.d(getActivity())) {
                startActivityForResult(d.b(getActivity()), getArguments().getInt(TransparentActivity.b));
                z2 = true;
            }
            if (stringArrayList.contains("android.permission.SYSTEM_ALERT_WINDOW") && !e.h(getActivity())) {
                startActivityForResult(d.f(getActivity()), getArguments().getInt(TransparentActivity.b));
                z2 = true;
            }
            if (stringArrayList.contains("android.permission.ACCESS_NOTIFICATION_POLICY") && !e.e(getActivity())) {
                startActivityForResult(d.c(getActivity()), getArguments().getInt(TransparentActivity.b));
                z2 = true;
            }
            if (stringArrayList.contains("android.permission.WRITE_SETTINGS") && !e.f(getActivity())) {
                startActivityForResult(d.d(getActivity()), getArguments().getInt(TransparentActivity.b));
                z2 = true;
            }
        }
        if (z2) {
            return;
        }
        f();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Bundle arguments = getArguments();
        if (arguments == null || this.f16401t || i2 != arguments.getInt(TransparentActivity.b)) {
            return;
        }
        this.f16401t = true;
        new Handler(Looper.getMainLooper()).postDelayed(new b(), 300L);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f16402u = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Bundle arguments = getArguments();
        if (arguments != null && i2 == arguments.getInt(TransparentActivity.b)) {
            com.hjq.permissions.a aVar = this.f16402u;
            this.f16402u = null;
            if (aVar == null) {
                return;
            }
            for (int i3 = 0; i3 < strArr.length; i3++) {
                String str = strArr[i3];
                if (e.a(str)) {
                    iArr[i3] = e.a((Context) getActivity(), str);
                } else if (e.c() && "android.permission.ACCESS_BACKGROUND_LOCATION".equals(str)) {
                    iArr[i3] = e.a((Context) getActivity(), str);
                } else if (!e.b() && ("android.permission.ACCESS_BACKGROUND_LOCATION".equals(str) || "android.permission.ACTIVITY_RECOGNITION".equals(str) || "android.permission.ACCESS_MEDIA_LOCATION".equals(str))) {
                    iArr[i3] = e.a((Context) getActivity(), str);
                } else if (!e.f() && ("android.permission.ANSWER_PHONE_CALLS".equals(str) || "android.permission.READ_PHONE_NUMBERS".equals(str))) {
                    iArr[i3] = e.a((Context) getActivity(), str);
                }
            }
            f16399v.delete(i2);
            b(getFragmentManager(), this);
            List<String> listB = e.b(strArr, iArr);
            if (listB.size() == strArr.length) {
                aVar.b(listB, true);
                return;
            }
            List<String> listA = e.a(strArr, iArr);
            aVar.a(listA, e.b((Activity) getActivity(), listA));
            if (listB.isEmpty()) {
                return;
            }
            aVar.b(listB, false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f16400s) {
            return;
        }
        this.f16400s = true;
        if (this.f16402u == null) {
            b(getFragmentManager(), this);
        } else {
            g();
        }
    }

    public static void a(FragmentManager fragmentManager, Fragment fragment) {
        if (fragmentManager == null) {
            return;
        }
        fragmentManager.beginTransaction().add(fragment, fragment.toString()).commitAllowingStateLoss();
    }

    public void a(com.hjq.permissions.a aVar) {
        this.f16402u = aVar;
    }
}
