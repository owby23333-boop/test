package com.bytedance.z.g.m;

import android.content.Context;
import android.os.Handler;
import androidx.media3.common.C;
import com.bytedance.z.g.gz.uy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class dl {
    private List<z> z;

    private dl(Handler handler, Context context) {
        ArrayList arrayList = new ArrayList(3);
        this.z = arrayList;
        arrayList.add(new g(handler, 0L, C.DEFAULT_SEEK_FORWARD_INCREMENT_MS));
    }

    public static dl z(Handler handler, Context context) {
        return new dl(handler, context);
    }

    public void z() {
        uy.z("[ScheduleTaskManager] execute, task size=" + this.z.size());
        Iterator<z> it = this.z.iterator();
        while (it.hasNext()) {
            try {
                it.next().z();
            } catch (Throwable unused) {
            }
        }
    }
}
