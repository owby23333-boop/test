package com.duokan.reader.domain.cloud.push;

import com.duokan.reader.domain.cloud.push.MessageWakeupListener;
import com.xiaomi.mipush.sdk.MiPushMessage;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface d {

    public interface a {
        void a(String str, String str2, boolean z);

        void b(DkCloudPushMessage dkCloudPushMessage);

        void c(long j, String str, String str2);

        void d(MessageWakeupListener.MessageSubType messageSubType, Object obj, boolean z);
    }

    void a(String str);

    void b(String str);

    void c(a aVar);

    void e();

    void f(String str);

    void g(long j, String str, String str2);

    void h();

    void i();

    void j(MiPushMessage miPushMessage, boolean z);

    List<String> k();

    void l();
}
