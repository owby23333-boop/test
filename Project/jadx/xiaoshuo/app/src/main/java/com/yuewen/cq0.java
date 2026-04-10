package com.yuewen;

import com.duokan.reader.domain.cloud.push.DkCloudPushMessage;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class cq0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public bm0 f9742a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DkCloudPushMessage f9743b = null;

    public static List<cq0> b(DkCloudPushMessage[] dkCloudPushMessageArr) {
        LinkedList linkedList = new LinkedList();
        for (DkCloudPushMessage dkCloudPushMessage : dkCloudPushMessageArr) {
            cq0 cq0Var = new cq0();
            cq0Var.f9743b = dkCloudPushMessage;
            linkedList.add(cq0Var);
        }
        return linkedList;
    }

    public static List<cq0> c(bm0[] bm0VarArr) {
        LinkedList linkedList = new LinkedList();
        for (bm0 bm0Var : bm0VarArr) {
            cq0 cq0Var = new cq0();
            cq0Var.f9742a = bm0Var;
            linkedList.add(cq0Var);
        }
        return linkedList;
    }

    public long a() {
        DkCloudPushMessage dkCloudPushMessage = this.f9743b;
        if (dkCloudPushMessage != null) {
            return dkCloudPushMessage.getReceivedDate().getTime();
        }
        bm0 bm0Var = this.f9742a;
        if (bm0Var != null) {
            return bm0Var.f * 1000;
        }
        return 0L;
    }
}
