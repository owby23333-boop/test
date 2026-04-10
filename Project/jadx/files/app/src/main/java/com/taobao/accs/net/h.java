package com.taobao.accs.net;

import anet.channel.strategy.dispatch.DispatchEvent;
import anet.channel.strategy.dispatch.HttpDispatcher;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
class h implements HttpDispatcher.IDispatchEventListener {
    final /* synthetic */ g a;

    h(g gVar) {
        this.a = gVar;
    }

    @Override // anet.channel.strategy.dispatch.HttpDispatcher.IDispatchEventListener
    public void onEvent(DispatchEvent dispatchEvent) {
        ThreadPoolExecutorFactory.schedule(new i(this), com.anythink.expressad.exoplayer.i.a.f9492f, TimeUnit.MILLISECONDS);
    }
}
