package com.taobao.accs.ut.monitor;

import anet.channel.statist.Dimension;
import anet.channel.statist.Measure;
import anet.channel.statist.Monitor;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.taobao.accs.utl.BaseMonitor;
import com.umeng.analytics.pro.d;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
@Monitor(module = "accs", monitorPoint = d.aw)
public class SessionMonitor extends BaseMonitor {
    private long a;

    @Measure(constantValue = PangleAdapterUtils.CPM_DEFLAUT_VALUE, max = 15000.0d, min = PangleAdapterUtils.CPM_DEFLAUT_VALUE)
    public long auth_time;
    private long b;
    public long connection_stop_date;

    @Measure(constantValue = PangleAdapterUtils.CPM_DEFLAUT_VALUE, max = 86400.0d, min = PangleAdapterUtils.CPM_DEFLAUT_VALUE)
    public long live_time;

    @Measure(constantValue = PangleAdapterUtils.CPM_DEFLAUT_VALUE)
    public int ping_rec_times;

    @Measure(constantValue = PangleAdapterUtils.CPM_DEFLAUT_VALUE)
    public int ping_send_times;

    @Dimension
    public int retry_times;

    @Measure(constantValue = PangleAdapterUtils.CPM_DEFLAUT_VALUE, max = 15000.0d, min = PangleAdapterUtils.CPM_DEFLAUT_VALUE)
    public long ssl_time;

    @Measure(constantValue = PangleAdapterUtils.CPM_DEFLAUT_VALUE, max = 15000.0d, min = PangleAdapterUtils.CPM_DEFLAUT_VALUE)
    public long tcp_time;

    @Dimension
    public boolean ret = false;

    @Dimension
    public int fail_reasons = 0;

    @Dimension
    public String close_reasons = "none";

    @Dimension
    public int close_connection_type = 2;

    @Dimension
    public String connect_type = "none";

    @Dimension
    public boolean isProxy = false;

    @Dimension
    public String sdkv = String.valueOf(221);

    public String getCloseReason() {
        return this.close_reasons;
    }

    public long getConCloseDate() {
        return this.b;
    }

    public long getConStopDate() {
        return this.connection_stop_date;
    }

    public boolean getRet() {
        return this.ret;
    }

    public void onCloseConnect() {
        this.b = System.currentTimeMillis();
    }

    public void onConnectStop() {
        this.connection_stop_date = System.currentTimeMillis();
    }

    public void onPingCBReceive() {
        this.ping_rec_times++;
    }

    public void onSendPing() {
        this.ping_send_times++;
    }

    public void onStartConnect() {
        this.a = System.currentTimeMillis();
    }

    public void setCloseReason(String str) {
        this.close_reasons = str;
    }

    public void setCloseType(int i2) {
        this.close_connection_type = i2;
    }

    public void setConnectType(String str) {
        this.connect_type = str;
    }

    public void setFailReason(int i2) {
        this.fail_reasons = i2;
    }

    public void setRet(boolean z2) {
        this.ret = z2;
    }

    public void setRetryTimes(int i2) {
        this.retry_times = i2;
    }
}
