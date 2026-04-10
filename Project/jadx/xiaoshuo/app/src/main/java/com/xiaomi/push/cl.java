package com.xiaomi.push;

import android.content.Context;
import android.database.Cursor;
import com.xiaomi.push.cq;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class cl extends cq.b<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f7853a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f197a;

    public cl(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i, String str6) {
        super(str, list, str2, strArr, str3, str4, str5, i);
        this.f7853a = 0L;
        this.f197a = str6;
    }

    public static cl a(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("count(*)");
        return new cl(str, arrayList, null, null, null, null, null, 0, "job to get count of all message");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.xiaomi.push.cq.b
    public Long a(Context context, Cursor cursor) {
        return Long.valueOf(cursor.getLong(0));
    }

    @Override // com.xiaomi.push.cq.b
    public void a(Context context, List<Long> list) {
        if (context == null || list == null || list.size() <= 0) {
            return;
        }
        this.f7853a = list.get(0).longValue();
    }

    @Override // com.xiaomi.push.cq.a
    /* JADX INFO: renamed from: a */
    public Object mo270a() {
        return Long.valueOf(this.f7853a);
    }
}
