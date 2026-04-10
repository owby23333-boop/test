package com.github.gzuliyujiang.oaid;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class DeviceIdentifier {
    private static volatile String androidId;
    private static volatile String clientId;
    private static volatile String guid;
    private static volatile String imei;
    private static volatile String oaid;
    private static volatile String pseudoId;
    private static volatile boolean registered;
    private static volatile String widevineId;

    private DeviceIdentifier() {
    }

    public static void register(Application application) {
        if (registered) {
            return;
        }
        synchronized (DeviceIdentifier.class) {
            if (!registered) {
                DeviceID.register(application);
                registered = true;
            }
        }
    }

    public static String getClientId() {
        if (TextUtils.isEmpty(clientId)) {
            synchronized (DeviceIdentifier.class) {
                if (TextUtils.isEmpty(clientId)) {
                    clientId = DeviceID.getClientIdMD5();
                }
            }
        }
        if (clientId == null) {
            clientId = "";
        }
        return clientId;
    }

    public static String getIMEI(Context context) {
        if (imei == null) {
            synchronized (DeviceIdentifier.class) {
                if (imei == null) {
                    imei = DeviceID.getUniqueID(context);
                }
            }
        }
        if (imei == null) {
            imei = "";
        }
        return imei;
    }

    public static String getOAID(Context context) {
        if (TextUtils.isEmpty(oaid)) {
            synchronized (DeviceIdentifier.class) {
                if (TextUtils.isEmpty(oaid)) {
                    oaid = DeviceID.getOAID();
                    if (oaid == null || oaid.length() == 0) {
                        DeviceID.getOAID(context, new IGetter() { // from class: com.github.gzuliyujiang.oaid.DeviceIdentifier.1
                            @Override // com.github.gzuliyujiang.oaid.IGetter
                            public void onOAIDGetComplete(String result) {
                                String unused = DeviceIdentifier.oaid = result;
                            }

                            @Override // com.github.gzuliyujiang.oaid.IGetter
                            public void onOAIDGetError(Exception error) {
                                String unused = DeviceIdentifier.oaid = "";
                            }
                        });
                    }
                }
            }
        }
        if (oaid == null) {
            oaid = "";
        }
        return oaid;
    }

    public static String getAndroidID(Context context) {
        if (androidId == null) {
            synchronized (DeviceIdentifier.class) {
                if (androidId == null) {
                    androidId = DeviceID.getAndroidID(context);
                }
            }
        }
        if (androidId == null) {
            androidId = "";
        }
        return androidId;
    }

    public static String getWidevineID() {
        if (widevineId == null) {
            synchronized (DeviceIdentifier.class) {
                if (widevineId == null) {
                    widevineId = DeviceID.getWidevineID();
                }
            }
        }
        if (widevineId == null) {
            widevineId = "";
        }
        return widevineId;
    }

    public static String getPseudoID() {
        if (pseudoId == null) {
            synchronized (DeviceIdentifier.class) {
                if (pseudoId == null) {
                    pseudoId = DeviceID.getPseudoID();
                }
            }
        }
        if (pseudoId == null) {
            pseudoId = "";
        }
        return pseudoId;
    }

    public static String getGUID(Context context) {
        if (guid == null) {
            synchronized (DeviceIdentifier.class) {
                if (guid == null) {
                    guid = DeviceID.getGUID(context);
                }
            }
        }
        if (guid == null) {
            guid = "";
        }
        return guid;
    }
}
