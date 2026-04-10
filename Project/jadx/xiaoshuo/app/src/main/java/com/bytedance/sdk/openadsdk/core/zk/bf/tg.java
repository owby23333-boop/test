package com.bytedance.sdk.openadsdk.core.zk.bf;

import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.core.zk.bf.e;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes10.dex */
public class tg implements TTAppDownloadListener {
    private final ConcurrentHashMap<Integer, TTAppDownloadListener> e = new ConcurrentHashMap<>();

    public void e(TTAppDownloadListener tTAppDownloadListener) {
        if (tTAppDownloadListener != null) {
            this.e.put(Integer.valueOf(tTAppDownloadListener.hashCode()), tTAppDownloadListener);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadActive(long j, long j2, String str, String str2) {
        Iterator<Map.Entry<Integer, TTAppDownloadListener>> it = this.e.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, TTAppDownloadListener> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                new e.C0174e().e(next.getValue()).e("onDownloadActive").e(j).bf(j2).bf(str).d(str2).e();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadFailed(long j, long j2, String str, String str2) {
        Iterator<Map.Entry<Integer, TTAppDownloadListener>> it = this.e.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, TTAppDownloadListener> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                new e.C0174e().e(next.getValue()).e("onDownloadFailed").e(j).bf(j2).bf(str).d(str2).e();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadFinished(long j, String str, String str2) {
        Iterator<Map.Entry<Integer, TTAppDownloadListener>> it = this.e.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, TTAppDownloadListener> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                new e.C0174e().e(next.getValue()).e("onDownloadFinished").e(j).bf(str).d(str2).e();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadPaused(long j, long j2, String str, String str2) {
        Iterator<Map.Entry<Integer, TTAppDownloadListener>> it = this.e.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, TTAppDownloadListener> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                new e.C0174e().e(next.getValue()).e("onDownloadPaused").e(j).bf(j2).bf(str).d(str2).e();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onIdle() {
        Iterator<Map.Entry<Integer, TTAppDownloadListener>> it = this.e.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, TTAppDownloadListener> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                new e.C0174e().e(next.getValue()).e("onIdle").e();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onInstalled(String str, String str2) {
        Iterator<Map.Entry<Integer, TTAppDownloadListener>> it = this.e.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, TTAppDownloadListener> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                next.getValue().onInstalled(str, str2);
                new e.C0174e().e(next.getValue()).e("onInstalled").bf(str).d(str2).e();
            }
        }
    }

    public void e() {
        if (this.e.isEmpty()) {
            return;
        }
        this.e.clear();
    }
}
