package com.duokan.reader.domain.payment;

import android.app.Activity;
import android.content.Context;
import com.yuewen.ng2;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c {

    public interface a {
        void a(c cVar, ng2 ng2Var, boolean z);

        void b(c cVar, ng2 ng2Var, String str);

        void c(c cVar, ng2 ng2Var, String str);

        void d(c cVar, ng2 ng2Var, String str);
    }

    public interface b {
        void a(String str);

        void b(float f, String str);
    }

    public abstract boolean b();

    public abstract String c(Context context);

    public abstract String d();

    public abstract void e(ng2 ng2Var, a aVar);

    public abstract void f(Activity activity, b bVar);
}
