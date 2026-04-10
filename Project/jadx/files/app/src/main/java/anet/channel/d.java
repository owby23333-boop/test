package anet.channel;

import anet.channel.security.ISecurity;
import anet.channel.strategy.dispatch.IAmdcSign;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class d implements IAmdcSign {
    final /* synthetic */ String a;
    final /* synthetic */ ISecurity b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ SessionCenter f299c;

    d(SessionCenter sessionCenter, String str, ISecurity iSecurity) {
        this.f299c = sessionCenter;
        this.a = str;
        this.b = iSecurity;
    }

    @Override // anet.channel.strategy.dispatch.IAmdcSign
    public String getAppkey() {
        return this.a;
    }

    @Override // anet.channel.strategy.dispatch.IAmdcSign
    public String sign(String str) {
        return this.b.sign(this.f299c.b, ISecurity.SIGN_ALGORITHM_HMAC_SHA1, getAppkey(), str);
    }

    @Override // anet.channel.strategy.dispatch.IAmdcSign
    public boolean useSecurityGuard() {
        return !this.b.isSecOff();
    }
}
