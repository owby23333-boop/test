package com.efs.sdk.base.core.config;

import android.content.Context;
import android.os.Message;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.efs.sdk.base.observer.IEfsReporterObserver;
import com.efs.sdk.base.processor.action.ILogEncryptAction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class GlobalEnvStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1545a;
    private String b;
    private String h;
    private ILogEncryptAction m;
    public Context mAppContext;
    private boolean c = true;
    private boolean d = true;
    private boolean e = false;
    private Boolean f = null;
    private boolean g = false;
    private boolean i = false;
    public long configRefreshDelayMills = 5000;
    private long j = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
    private long k = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
    private Map<String, String> l = new HashMap(5);
    private ConcurrentHashMap<Integer, List<ValueCallback<Pair<Message, Message>>>> n = new ConcurrentHashMap<>();
    private List<IEfsReporterObserver> o = new ArrayList(5);

    public String getAppid() {
        return this.f1545a;
    }

    public void setAppid(String str) {
        this.f1545a = str;
    }

    public String getSecret() {
        return this.b;
    }

    public void setSecret(String str) {
        this.b = str;
    }

    public String getUid() {
        return this.h;
    }

    public void setUid(String str) {
        this.h = str;
    }

    public long getLogSendDelayMills() {
        return this.j;
    }

    public long getLogSendIntervalMills() {
        return this.k;
    }

    public Map<String, String> getPublicParamMap() {
        Map<String, String> map = this.l;
        return map == null ? Collections.emptyMap() : map;
    }

    public void addPublicParams(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        HashMap map2 = new HashMap(this.l);
        map2.putAll(map);
        this.l = map2;
    }

    public ILogEncryptAction getLogEncryptAction() {
        return this.m;
    }

    public void setLogEncryptAction(ILogEncryptAction iLogEncryptAction) {
        this.m = iLogEncryptAction;
    }

    public boolean isIntl() {
        return this.i;
    }

    public void setIsIntl(boolean z) {
        this.i = z;
    }

    public boolean isEnableWaStat() {
        return this.c;
    }

    public void setEnableWaStat(boolean z) {
        this.c = z;
    }

    public boolean isEnableSendLog() {
        return this.d;
    }

    public void setEnableSendLog(boolean z) {
        this.d = z;
    }

    public boolean isDebug() {
        return this.e;
    }

    public void setDebug(boolean z) {
        this.e = z;
    }

    public boolean isPrintLogDetail() {
        return this.g;
    }

    public void setPrintLogDetail(boolean z) {
        this.g = z;
    }

    public void registerCallback(int i, ValueCallback<Pair<Message, Message>> valueCallback) {
        if (valueCallback == null) {
            return;
        }
        List<ValueCallback<Pair<Message, Message>>> linkedList = this.n.get(Integer.valueOf(i));
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            this.n.putIfAbsent(Integer.valueOf(i), linkedList);
        }
        linkedList.add(valueCallback);
    }

    public List<ValueCallback<Pair<Message, Message>>> getCallback(int i) {
        if (!this.n.containsKey(Integer.valueOf(i)) || this.n.get(Integer.valueOf(i)) == null) {
            return Collections.emptyList();
        }
        return this.n.get(Integer.valueOf(i));
    }

    public void addConfigObserver(IEfsReporterObserver iEfsReporterObserver) {
        if (this.o.contains(iEfsReporterObserver)) {
            return;
        }
        this.o.add(iEfsReporterObserver);
    }

    public List<IEfsReporterObserver> getEfsReporterObservers() {
        return this.o;
    }
}
