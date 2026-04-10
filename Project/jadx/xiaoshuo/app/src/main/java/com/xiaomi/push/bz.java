package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;

/* JADX INFO: loaded from: classes8.dex */
public class bz implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f7842a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private com.xiaomi.clientreport.processor.c f183a;

    public void a(com.xiaomi.clientreport.processor.c cVar) {
        this.f183a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.xiaomi.clientreport.processor.c cVar = this.f183a;
            if (cVar != null) {
                cVar.a();
            }
            com.xiaomi.channel.commonutils.logger.b.c("begin read and send perf / event");
            com.xiaomi.clientreport.processor.c cVar2 = this.f183a;
            if (cVar2 instanceof IEventProcessor) {
                cd.a(this.f7842a).m264a("sp_client_report_status", "event_last_upload_time", System.currentTimeMillis());
            } else if (cVar2 instanceof IPerfProcessor) {
                cd.a(this.f7842a).m264a("sp_client_report_status", "perf_last_upload_time", System.currentTimeMillis());
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    public void a(Context context) {
        this.f7842a = context;
    }
}
