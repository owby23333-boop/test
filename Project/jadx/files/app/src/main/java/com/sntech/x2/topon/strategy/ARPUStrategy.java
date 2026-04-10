package com.sntech.x2.topon.strategy;

import androidx.annotation.Keep;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ARPUStrategy {

    @Keep
    public Map<String, Double> adIdEcpm;

    @Keep
    public String date;

    @Keep
    public List<MultiPlatformArpu> multiPlatformArpu;

    @Keep
    public List<PlatformArpu> platformArpu;

    @Keep
    public List<PlatformEcpm> platformEcpm;

    @Keep
    public Map<String, String> slotTypeHeadPlatform;

    @Keep
    public String[] supportedPlatforms;

    @Keep
    public class MultiPlatformArpu {

        @Keep
        public List<String> platforms;

        @Keep
        public Map<String, Integer> slotTypeShow;

        public MultiPlatformArpu() {
        }
    }

    @Keep
    public class PlatformArpu {

        @Keep
        public String platform;

        @Keep
        public Map<String, Double> slotTypeArpu;

        @Keep
        public Map<String, Integer> slotTypeShow;

        @Keep
        public double totalArpu;

        public PlatformArpu() {
        }
    }

    @Keep
    public class PlatformEcpm {

        @Keep
        public String platform;

        @Keep
        public Map<String, Double> slotTypeEcpm;

        public PlatformEcpm() {
        }
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public double m172do(String str, String str2, String str3, double d2) {
        Map<String, Double> map = this.adIdEcpm;
        if (map != null && map.containsKey(str3)) {
            return this.adIdEcpm.get(str3).doubleValue();
        }
        if (d2 > PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            return d2;
        }
        List<PlatformEcpm> list = this.platformEcpm;
        if (list != null && str != null) {
            for (PlatformEcpm platformEcpm : list) {
                if (str.equals(platformEcpm.platform) && platformEcpm.slotTypeEcpm.containsKey(str2)) {
                    return platformEcpm.slotTypeEcpm.get(str2).doubleValue();
                }
            }
        }
        return PangleAdapterUtils.CPM_DEFLAUT_VALUE;
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public final String m173do(String str, String str2, double d2, int i2, double d3, PlatformArpu platformArpu, String str3) {
        Map<String, Double> map = platformArpu.slotTypeArpu;
        Double d4 = map != null ? map.get(str2) : null;
        Map<String, Integer> map2 = platformArpu.slotTypeShow;
        Integer num = map2 != null ? map2.get(str2) : null;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ArpuReachTarget: platform=");
        stringBuffer.append(str);
        stringBuffer.append(" slotType=");
        stringBuffer.append(str2);
        stringBuffer.append(" slotTypeTotalArpu=");
        stringBuffer.append(d2);
        stringBuffer.append(" slotTypeTotalShow=");
        stringBuffer.append(i2);
        stringBuffer.append(" platformTotalArpu=");
        stringBuffer.append(d3);
        stringBuffer.append(" targetArpu=");
        stringBuffer.append(d4);
        stringBuffer.append(" targetShow=");
        stringBuffer.append(num);
        stringBuffer.append(" platformTargetArpu=");
        stringBuffer.append(platformArpu.totalArpu);
        stringBuffer.append(" reason=" + str3);
        return stringBuffer.toString();
    }
}
