package com.taobao.accs.net;

import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.taobao.accs.data.Message;
import com.taobao.accs.utl.BaseMonitor;
import java.util.Iterator;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
class r implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ boolean b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f18237c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ j f18238d;

    r(j jVar, int i2, boolean z2, int i3) {
        this.f18238d = jVar;
        this.a = i2;
        this.b = z2;
        this.f18237c = i3;
    }

    @Override // java.lang.Runnable
    public void run() {
        Message messageB;
        int i2 = this.a;
        if (i2 > 0) {
            Message.Id id = new Message.Id(i2, "");
            Message.Id id2 = null;
            Iterator<Message.Id> it = this.f18238d.f18202e.f().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Message.Id next = it.next();
                if (next.equals(id)) {
                    id2 = next;
                    break;
                }
            }
            if (id2 != null && (messageB = this.f18238d.f18202e.b(id2.getDataId())) != null) {
                if (this.b) {
                    if (!this.f18238d.a(messageB, 2000)) {
                        this.f18238d.f18202e.a(messageB, this.f18237c);
                    }
                    if (messageB.getNetPermanceMonitor() != null) {
                        com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_POINT_RESEND, "total_tnet", PangleAdapterUtils.CPM_DEFLAUT_VALUE);
                    }
                } else {
                    this.f18238d.f18202e.a(messageB, this.f18237c);
                }
            }
        }
        int i3 = this.a;
        if (i3 >= 0 || !this.b) {
            return;
        }
        this.f18238d.b(i3);
    }
}
