package com.bytedance.sdk.openadsdk.core.zk.bf;

import android.app.Activity;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.core.multipro.bf.e;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public interface bf extends ITTDownloadAdapter {
    void bf();

    void bf(JSONObject jSONObject);

    void bf(boolean z);

    void d();

    void d(boolean z);

    boolean d(JSONObject jSONObject);

    void e();

    void e(int i);

    void e(int i, ITTDownloadAdapter.OnEventLogHandler onEventLogHandler);

    void e(Activity activity);

    void e(View view);

    void e(TTAppDownloadListener tTAppDownloadListener);

    void e(TTAppDownloadListener tTAppDownloadListener, boolean z);

    void e(e.InterfaceC0145e interfaceC0145e);

    void e(JSONObject jSONObject);

    boolean e(boolean z);

    void ga();

    boolean p();

    void tg();

    boolean vn();
}
