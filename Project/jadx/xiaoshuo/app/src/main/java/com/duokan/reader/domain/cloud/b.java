package com.duokan.reader.domain.cloud;

import com.yuewen.kv3;
import com.yuewen.xl3;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes3.dex */
public class b implements xl3 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static kv3<b> f4793b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<a> f4794a = new LinkedList<>();

    public interface a {
        void A0();

        void a0(String str, DkCloudAnnotation[] dkCloudAnnotationArr);

        void d9(DkCloudNoteBookInfo dkCloudNoteBookInfo);
    }

    public static b b() {
        kv3<b> kv3Var = f4793b;
        if (kv3Var != null) {
            return kv3Var.get();
        }
        return null;
    }

    public static void d(kv3<b> kv3Var) {
        f4793b = kv3Var;
    }

    public void a(a aVar) {
        if (aVar == null || this.f4794a.contains(aVar)) {
            return;
        }
        this.f4794a.add(aVar);
    }

    public void c(a aVar) {
        if (aVar != null) {
            this.f4794a.remove(aVar);
        }
    }
}
