package anet.channel.detect;

import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.l;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
final class j implements IConnStrategy {
    final /* synthetic */ l.e a;
    final /* synthetic */ ConnProtocol b;

    j(l.e eVar, ConnProtocol connProtocol) {
        this.a = eVar;
        this.b = connProtocol;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getConnectionTimeout() {
        return this.a.b.f463c;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getHeartbeat() {
        return 0;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public String getIp() {
        return this.a.a;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getIpSource() {
        return 2;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getIpType() {
        return 1;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getPort() {
        return this.a.b.a;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public ConnProtocol getProtocol() {
        return this.b;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getReadTimeout() {
        return this.a.b.f464d;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getRetryTimes() {
        return 0;
    }
}
