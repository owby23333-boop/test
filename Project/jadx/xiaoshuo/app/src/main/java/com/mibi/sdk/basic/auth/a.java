package com.mibi.sdk.basic.auth;

import android.app.Activity;
import android.os.Bundle;
import com.mibi.sdk.mvp.IPresenter;
import com.mibi.sdk.mvp.IView;

/* JADX INFO: loaded from: classes10.dex */
public class a {

    /* JADX INFO: renamed from: com.mibi.sdk.basic.auth.a$a, reason: collision with other inner class name */
    public interface InterfaceC0457a extends IPresenter {
        void a(Activity activity, String str, String str2);
    }

    public interface b extends IView {
        void a();

        void a(int i, String str);

        void a(Bundle bundle);

        void a(String str, Throwable th);

        void b();

        void c();

        void e();

        void f();
    }
}
