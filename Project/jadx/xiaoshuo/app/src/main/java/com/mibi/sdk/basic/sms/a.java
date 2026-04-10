package com.mibi.sdk.basic.sms;

import android.os.Bundle;
import com.mibi.sdk.mvp.IPresenter;
import com.mibi.sdk.mvp.IView;

/* JADX INFO: loaded from: classes10.dex */
public class a {

    /* JADX INFO: renamed from: com.mibi.sdk.basic.sms.a$a, reason: collision with other inner class name */
    public interface InterfaceC0460a extends IPresenter {
        void a();

        void a(String str);
    }

    public interface b extends IView {
        void a();

        void a(int i);

        void a(Bundle bundle);

        void a(String str, Throwable th);

        void b(int i, String str);

        void d();
    }
}
