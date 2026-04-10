package com.yuewen;

import com.duokan.core.async.work.IAsyncWorkProgressListener;
import com.duokan.reader.ui.FlowChargingTransferChoice;
import java.io.File;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class t12 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f17834a = "/Books";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f17835b = "duokan";
    public static kv3<t12> c;

    public interface a {
        void a();

        void b();
    }

    public static t12 d() {
        kv3<t12> kv3Var = c;
        if (kv3Var != null) {
            return kv3Var.get();
        }
        return null;
    }

    public static void l(kv3<t12> kv3Var) {
        c = kv3Var;
    }

    public abstract void a(List<File> list, FlowChargingTransferChoice flowChargingTransferChoice);

    public abstract void b(IAsyncWorkProgressListener<com.duokan.core.async.work.b> iAsyncWorkProgressListener);

    public abstract void c(File file);

    public abstract Object e(String str);

    public abstract Object f(Object obj);

    public abstract Object g(Object obj, Collection collection);

    public abstract Collection h();

    public abstract void i(a aVar);

    public abstract void j();

    public abstract void k(IAsyncWorkProgressListener iAsyncWorkProgressListener);

    public abstract void m(boolean z);
}
