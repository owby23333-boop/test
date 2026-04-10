package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.CpuChannelResponse;
import com.baidu.mobads.sdk.api.IOAdEvent;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
class n implements Runnable {
    final /* synthetic */ IOAdEvent a;
    final /* synthetic */ m b;

    n(m mVar, IOAdEvent iOAdEvent) {
        this.b = mVar;
        this.a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        IOAdEvent iOAdEvent = this.a;
        if (iOAdEvent == null || TextUtils.isEmpty(iOAdEvent.getType())) {
            return;
        }
        String type = this.a.getType();
        if (w.an.equals(type)) {
            List<CpuChannelResponse> listA = k.a((JSONArray) this.a.getData().get("cpuChannelList"));
            if (this.b.a.f13152q != null) {
                this.b.a.f13152q.onChannelListLoaded(listA);
                return;
            }
            return;
        }
        if (w.ao.equals(type)) {
            Map<String, Object> data = this.a.getData();
            int iIntValue = 0;
            if (data != null) {
                str = (String) data.get("error_message");
                Object obj = data.get("error_code");
                if (obj == null) {
                    obj = 0;
                }
                iIntValue = ((Integer) obj).intValue();
            } else {
                str = "";
            }
            if (this.b.a.f13152q != null) {
                this.b.a.f13152q.onChannelListError(str, iIntValue);
            }
        }
    }
}
