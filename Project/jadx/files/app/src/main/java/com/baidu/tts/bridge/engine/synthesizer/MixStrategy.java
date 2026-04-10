package com.baidu.tts.bridge.engine.synthesizer;

import com.baidu.tts.enumtype.MixMode;
import com.baidu.tts.param.AllSynthesizerParams;

/* JADX INFO: loaded from: classes2.dex */
public class MixStrategy {
    private static final int NETWORK_CLASS_2_G = 1;
    private static final int NETWORK_CLASS_3_G = 2;
    private static final int NETWORK_CLASS_4_G = 3;
    private static final int NETWORK_CLASS_UNKNOWN = 0;
    public static final int NETWORK_TYPE_CELL_5G = 5;
    public static final int NETWORK_TYPE_NR = 20;
    private static final String TAG = "MixStrategy";
    private AllSynthesizerParams mAllSynthesizerParams;
    private MixMode mOldMode;

    /* JADX INFO: renamed from: com.baidu.tts.bridge.engine.synthesizer.MixStrategy$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$tts$enumtype$MixMode = new int[MixMode.values().length];

        static {
            try {
                $SwitchMap$com$baidu$tts$enumtype$MixMode[MixMode.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$tts$enumtype$MixMode[MixMode.HIGH_SPEED_SYNTHESIZE_WIFI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$tts$enumtype$MixMode[MixMode.HIGH_SPEED_NETWORK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$tts$enumtype$MixMode[MixMode.HIGH_SPEED_SYNTHESIZE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private int getNetworkClass(int i2) {
        if (i2 == 20) {
            return 5;
        }
        switch (i2) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 1;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 2;
            case 13:
                return 3;
            default:
                return 0;
        }
    }

    private boolean isHighSpeedNetwork(int i2) {
        int networkClass = getNetworkClass(i2);
        return networkClass >= 2 || networkClass == 0;
    }

    private boolean isMixModeChanged() {
        MixMode mixMode;
        try {
            mixMode = this.mAllSynthesizerParams.getMixMode();
        } catch (Exception unused) {
            mixMode = null;
        }
        MixMode mixMode2 = this.mOldMode;
        if (mixMode2 == null) {
            if (mixMode == null) {
                this.mOldMode = MixMode.DEFAULT;
                return true;
            }
            this.mOldMode = mixMode;
            return true;
        }
        if (mixMode == null || mixMode2.equals(mixMode)) {
            return false;
        }
        this.mOldMode = mixMode;
        return true;
    }

    private boolean isNetworkTypeWifi(int i2) {
        return i2 == 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0090 A[PHI: r0
  0x0090: PHI (r0v4 ??) = (r0v6 ??), (r0v7 ??), (r0v8 ??), (r0v9 ??), (r0v10 ??) binds: [B:25:0x008c, B:26:0x008e, B:19:0x007d, B:20:0x007f, B:23:0x0087] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean isOnlineValid() {
        /*
            r8 = this;
            java.lang.String r0 = "MixStrategy"
            r1 = 0
            com.baidu.tts.flyweight.persistent.PersistentPool r2 = com.baidu.tts.flyweight.persistent.PersistentPool.getInstance()     // Catch: java.lang.Exception -> L92
            android.content.Context r2 = r2.getContext()     // Catch: java.lang.Exception -> L92
            r3 = 1
            if (r2 == 0) goto L9a
            boolean r4 = r8.isMixModeChanged()     // Catch: java.lang.Exception -> L92
            com.baidu.tts.param.AllSynthesizerParams r5 = r8.mAllSynthesizerParams     // Catch: java.lang.Exception -> L92
            com.baidu.tts.bridge.engine.synthesizer.OnlineSynthesizer$OnlineSynthesizerParams r5 = r5.getOnlineSynthesizerParams()     // Catch: java.lang.Exception -> L92
            com.baidu.tts.param.AllSynthesizerParams r6 = r8.mAllSynthesizerParams     // Catch: java.lang.Exception -> L92
            com.baidu.tts.enumtype.TimeOutEnum r6 = r6.getMixOnlineRequestTimeout()     // Catch: java.lang.Exception -> L92
            int r6 = r6.getMillSecondsInt()     // Catch: java.lang.Exception -> L92
            r5.setTimeout(r6)     // Catch: java.lang.Exception -> L92
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L92
            r6.<init>()     // Catch: java.lang.Exception -> L92
            java.lang.String r7 = "MixOnlineRequestTimeout: "
            r6.append(r7)     // Catch: java.lang.Exception -> L92
            int r5 = r5.getTimeout()     // Catch: java.lang.Exception -> L92
            r6.append(r5)     // Catch: java.lang.Exception -> L92
            java.lang.String r5 = " isModeChanged: "
            r6.append(r5)     // Catch: java.lang.Exception -> L92
            r6.append(r4)     // Catch: java.lang.Exception -> L92
            java.lang.String r4 = r6.toString()     // Catch: java.lang.Exception -> L92
            com.baidu.tts.chainofresponsibility.logger.LoggerProxy.d(r0, r4)     // Catch: java.lang.Exception -> L92
            java.lang.String r4 = "connectivity"
            java.lang.Object r2 = r2.getSystemService(r4)     // Catch: java.lang.Exception -> L92
            android.net.ConnectivityManager r2 = (android.net.ConnectivityManager) r2     // Catch: java.lang.Exception -> L92
            android.net.NetworkInfo r2 = r2.getActiveNetworkInfo()     // Catch: java.lang.Exception -> L92
            if (r2 == 0) goto L9a
            boolean r4 = r2.isConnected()     // Catch: java.lang.Exception -> L92
            if (r4 == 0) goto L9a
            int r4 = r2.getType()     // Catch: java.lang.Exception -> L92
            int r2 = r2.getSubtype()     // Catch: java.lang.Exception -> L92
            int[] r5 = com.baidu.tts.bridge.engine.synthesizer.MixStrategy.AnonymousClass1.$SwitchMap$com$baidu$tts$enumtype$MixMode     // Catch: java.lang.Exception -> L92
            com.baidu.tts.enumtype.MixMode r6 = r8.mOldMode     // Catch: java.lang.Exception -> L92
            int r6 = r6.ordinal()     // Catch: java.lang.Exception -> L92
            r5 = r5[r6]     // Catch: java.lang.Exception -> L92
            r6 = 9
            if (r5 == r3) goto L88
            r7 = 2
            if (r5 == r7) goto L88
            r7 = 3
            if (r5 == r7) goto L79
            r7 = 4
            if (r5 == r7) goto L79
            goto L9a
        L79:
            boolean r5 = r8.isNetworkTypeWifi(r4)     // Catch: java.lang.Exception -> L92
            if (r5 != 0) goto L90
            if (r4 == r6) goto L90
            boolean r0 = r8.isHighSpeedNetwork(r2)     // Catch: java.lang.Exception -> L92
            if (r0 == 0) goto L9a
            goto L90
        L88:
            boolean r0 = r8.isNetworkTypeWifi(r4)     // Catch: java.lang.Exception -> L92
            if (r0 != 0) goto L90
            if (r4 != r6) goto L9a
        L90:
            r1 = 1
            goto L9a
        L92:
            r2 = move-exception
            java.lang.String r2 = r2.toString()
            com.baidu.tts.chainofresponsibility.logger.LoggerProxy.d(r0, r2)
        L9a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tts.bridge.engine.synthesizer.MixStrategy.isOnlineValid():boolean");
    }

    public void setAllSynthesizerParams(AllSynthesizerParams allSynthesizerParams) {
        this.mAllSynthesizerParams = allSynthesizerParams;
    }
}
