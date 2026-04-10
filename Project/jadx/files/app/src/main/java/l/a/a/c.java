package l.a.a;

import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;

/* JADX INFO: compiled from: OrigamiValueConverter.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static double a(double d2) {
        return d2 == PangleAdapterUtils.CPM_DEFLAUT_VALUE ? PangleAdapterUtils.CPM_DEFLAUT_VALUE : 25.0d + ((d2 - 8.0d) * 3.0d);
    }

    public static double b(double d2) {
        return d2 == PangleAdapterUtils.CPM_DEFLAUT_VALUE ? PangleAdapterUtils.CPM_DEFLAUT_VALUE : 8.0d + ((d2 - 25.0d) / 3.0d);
    }

    public static double c(double d2) {
        return d2 == PangleAdapterUtils.CPM_DEFLAUT_VALUE ? PangleAdapterUtils.CPM_DEFLAUT_VALUE : 30.0d + ((d2 - 194.0d) / 3.62d);
    }

    public static double d(double d2) {
        return d2 == PangleAdapterUtils.CPM_DEFLAUT_VALUE ? PangleAdapterUtils.CPM_DEFLAUT_VALUE : 194.0d + ((d2 - 30.0d) * 3.62d);
    }
}
