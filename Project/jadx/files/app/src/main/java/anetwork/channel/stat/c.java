package anetwork.channel.stat;

import anet.channel.util.StringUtils;
import anetwork.channel.statist.StatisticData;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class c implements anetwork.channel.stat.a {
    private Map<String, String> a;

    /* JADX INFO: compiled from: Taobao */
    private static class a {
        public static c a = new c();
    }

    public static c a() {
        return a.a;
    }

    private c() {
        this.a = Collections.synchronizedMap(new LinkedHashMap<String, String>(this) { // from class: anetwork.channel.stat.NetworkStatCache$1
            @Override // java.util.LinkedHashMap
            protected boolean removeEldestEntry(Map.Entry<String, String> entry) {
                return size() > 100;
            }
        });
    }

    @Override // anetwork.channel.stat.a
    public void a(String str, StatisticData statisticData) {
        if (StringUtils.isBlank(str)) {
            return;
        }
        StringBuilder sb = new StringBuilder(48);
        sb.append("{\"oneWayTime\" : ");
        sb.append(statisticData.f604y);
        sb.append(", \"totalSize\" : ");
        sb.append(statisticData.I);
        sb.append("}");
        this.a.put(str, sb.toString());
    }
}
