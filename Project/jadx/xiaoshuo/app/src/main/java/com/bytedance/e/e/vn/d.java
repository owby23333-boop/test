package com.bytedance.e.e.vn;

import android.content.Context;
import android.os.Handler;
import com.bytedance.e.e.v.m;
import com.yuewen.mw3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    private List<e> e;

    private d(Handler handler, Context context) {
        ArrayList arrayList = new ArrayList(3);
        this.e = arrayList;
        arrayList.add(new bf(handler, 0L, mw3.f));
    }

    public static d e(Handler handler, Context context) {
        return new d(handler, context);
    }

    public void e() {
        m.e("[ScheduleTaskManager] execute, task size=" + this.e.size());
        Iterator<e> it = this.e.iterator();
        while (it.hasNext()) {
            try {
                it.next().e();
            } catch (Throwable unused) {
            }
        }
    }
}
