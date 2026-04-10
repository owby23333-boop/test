package anetwork.channel.statist;

import anet.channel.statist.RequestStatistic;
import anet.channel.util.StringUtils;
import java.io.Serializable;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class StatisticData implements Serializable, Cloneable {
    public int K;
    public String L;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f598s = "";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f599t = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f600u = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f601v = "";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f602w = "";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f603x = false;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f604y = 0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f605z = 0;
    public long A = 0;
    public long B = 0;
    public long C = 0;
    public long D = 0;
    public long E = 0;
    public long F = 0;
    public long G = 0;
    public long H = 0;
    public long I = 0;
    public long J = 0;

    public void a(RequestStatistic requestStatistic) {
        if (requestStatistic != null) {
            this.f600u = requestStatistic.statusCode;
            this.f598s = requestStatistic.protocolType;
            this.f599t = requestStatistic.ret == 1;
            this.f601v = requestStatistic.host;
            if (requestStatistic.ip != null && requestStatistic.port != 0) {
                this.f602w = String.format("%s:%d", requestStatistic.ip, Integer.valueOf(requestStatistic.port));
            }
            this.K = requestStatistic.retryTimes;
            this.f603x = requestStatistic.isSSL;
            this.f604y = requestStatistic.oneWayTime;
            this.f605z = requestStatistic.cacheTime;
            this.B = requestStatistic.processTime;
            this.C = requestStatistic.sendBeforeTime;
            this.D = requestStatistic.firstDataTime;
            this.E = requestStatistic.recDataTime;
            this.H = requestStatistic.sendDataSize;
            this.I = requestStatistic.recDataSize;
            this.F = requestStatistic.serverRT;
            long j2 = this.E;
            long j3 = this.I;
            if (j2 != 0) {
                j3 /= j2;
            }
            this.J = j3;
            String str = requestStatistic.locationUrl;
        }
    }

    public String f() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("isSuccess=");
        sb.append(this.f599t);
        sb.append(",host=");
        sb.append(this.f601v);
        sb.append(",resultCode=");
        sb.append(this.f600u);
        sb.append(",connType=");
        sb.append(this.f598s);
        sb.append(",oneWayTime_ANet=");
        sb.append(this.f604y);
        sb.append(",ip_port=");
        sb.append(this.f602w);
        sb.append(",isSSL=");
        sb.append(this.f603x);
        sb.append(",cacheTime=");
        sb.append(this.f605z);
        sb.append(",processTime=");
        sb.append(this.B);
        sb.append(",sendBeforeTime=");
        sb.append(this.C);
        sb.append(",postBodyTime=");
        sb.append(this.A);
        sb.append(",firstDataTime=");
        sb.append(this.D);
        sb.append(",recDataTime=");
        sb.append(this.E);
        sb.append(",serverRT=");
        sb.append(this.F);
        sb.append(",rtt=");
        sb.append(this.G);
        sb.append(",sendSize=");
        sb.append(this.H);
        sb.append(",totalSize=");
        sb.append(this.I);
        sb.append(",dataSpeed=");
        sb.append(this.J);
        sb.append(",retryTime=");
        sb.append(this.K);
        return sb.toString();
    }

    public String toString() {
        if (StringUtils.isBlank(this.L)) {
            this.L = f();
        }
        return "StatisticData [" + this.L + "]";
    }
}
