package com.mibi.sdk.pay.ui.ma;

import android.os.Bundle;
import com.mibi.sdk.mvp.IPresenter;
import com.mibi.sdk.mvp.IView;

/* JADX INFO: loaded from: classes15.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f7169a = 48;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f7170b = 49;
    public static final int c = 50;
    public static final int d = 51;
    public static final int e = 52;

    public interface a extends IPresenter {
        void a();

        void a(boolean z, boolean z2, int i, boolean z3);

        String b();
    }

    /* JADX INFO: renamed from: com.mibi.sdk.pay.ui.ma.b$b, reason: collision with other inner class name */
    public interface InterfaceC0473b extends IView {
        void a();

        void a(int i, String str, Throwable th);

        void a(Bundle bundle);

        void a(Bundle bundle, boolean z);

        void a(String str);

        void a(boolean z, boolean z2, boolean z3, int i);

        void b();

        void onAccountFrozen();

        void onBindPhoneCheck(Bundle bundle);

        void onPasswordCheck();

        void onProcessExpired();
    }
}
