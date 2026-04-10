package com.anythink.expressad.atsignalcommon.bridge;

import android.content.Context;
import com.anythink.expressad.atsignalcommon.windvane.AbsFeedBackForH5;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.foundation.h.o;

/* JADX INFO: loaded from: classes2.dex */
public class BannerJSPlugin extends AbsFeedBackForH5 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f8272h = "BannerJSBridge";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private IBannerJSBridge f8273i;

    public void cai(Object obj, String str) {
        try {
            o.d("BannerJSBridge", "cai");
            if (this.f8273i != null) {
                this.f8273i.cai(obj, str);
            }
        } catch (Throwable th) {
            o.b("BannerJSBridge", "cai", th);
        }
    }

    public void click(Object obj, String str) {
        try {
            o.d("BannerJSBridge", "click");
            if (this.f8273i != null) {
                this.f8273i.click(obj, str);
            }
        } catch (Throwable th) {
            o.b("BannerJSBridge", "click", th);
        }
    }

    public void getFileInfo(Object obj, String str) {
        try {
            o.d("BannerJSBridge", "getFileInfo");
            if (this.f8273i != null) {
                this.f8273i.getFileInfo(obj, str);
            }
        } catch (Throwable th) {
            o.b("BannerJSBridge", "getFileInfo", th);
        }
    }

    public void getNetstat(Object obj, String str) {
        try {
            o.d("BannerJSBridge", "getNetstat");
            if (this.f8273i != null) {
                this.f8273i.getNetstat(obj, str);
            }
        } catch (Throwable th) {
            o.b("BannerJSBridge", "getNetstat", th);
        }
    }

    public void gial(Object obj, String str) {
        try {
            o.d("BannerJSBridge", "gial");
            if (this.f8273i != null) {
                this.f8273i.gial(obj, str);
            }
        } catch (Throwable th) {
            o.b("BannerJSBridge", "gial", th);
        }
    }

    public void handlerH5Exception(Object obj, String str) {
        try {
            o.d("BannerJSBridge", "handlerH5Exception");
            if (this.f8273i != null) {
                this.f8273i.handlerH5Exception(obj, str);
            }
        } catch (Throwable th) {
            o.b("BannerJSBridge", "handlerH5Exception", th);
        }
    }

    public void increaseOfferFrequence(Object obj, String str) {
        try {
            o.d("BannerJSBridge", "increaseOfferFrequence");
            if (this.f8273i != null) {
                this.f8273i.increaseOfferFrequence(obj, str);
            }
        } catch (Throwable th) {
            o.b("BannerJSBridge", "increaseOfferFrequence", th);
        }
    }

    public void init(Object obj, String str) {
        try {
            o.d("BannerJSBridge", "init");
            if (this.f8273i != null) {
                this.f8273i.init(obj, str);
            }
        } catch (Throwable th) {
            o.b("BannerJSBridge", "init", th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.anythink.expressad.atsignalcommon.windvane.l
    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        super.initialize(context, windVaneWebView);
        try {
            if (context instanceof IBannerJSBridge) {
                this.f8273i = (IBannerJSBridge) context;
            } else {
                if (windVaneWebView.getObject() == null || !(windVaneWebView.getObject() instanceof IBannerJSBridge)) {
                    return;
                }
                this.f8273i = (IBannerJSBridge) windVaneWebView.getObject();
            }
        } catch (Throwable th) {
            o.b("BannerJSBridge", "initialize", th);
        }
    }

    public void install(Object obj, String str) {
        try {
            o.d("BannerJSBridge", "install");
            if (this.f8273i != null) {
                this.f8273i.install(obj, str);
            }
        } catch (Throwable th) {
            o.b("BannerJSBridge", "install", th);
        }
    }

    public void onJSBridgeConnect(Object obj, String str) {
        try {
            o.d("BannerJSBridge", "onJSBridgeConnect");
            if (this.f8273i != null) {
                this.f8273i.onJSBridgeConnect(obj, str);
            }
        } catch (Throwable th) {
            o.b("BannerJSBridge", "onJSBridgeConnect", th);
        }
    }

    public void openURL(Object obj, String str) {
        try {
            o.d("BannerJSBridge", "openURL");
            if (this.f8273i != null) {
                this.f8273i.openURL(obj, str);
            }
        } catch (Throwable th) {
            o.b("BannerJSBridge", "openURL", th);
        }
    }

    public void readyStatus(Object obj, String str) {
        try {
            o.d("BannerJSBridge", "readyStatus");
            if (this.f8273i != null) {
                this.f8273i.readyStatus(obj, str);
            }
        } catch (Throwable th) {
            o.b("BannerJSBridge", "readyStatus", th);
        }
    }

    public void reportUrls(Object obj, String str) {
        try {
            o.d("BannerJSBridge", "reportUrls");
            if (this.f8273i != null) {
                this.f8273i.reportUrls(obj, str);
            }
        } catch (Throwable th) {
            o.b("BannerJSBridge", "reportUrls", th);
        }
    }

    public void resetCountdown(Object obj, String str) {
        try {
            o.d("BannerJSBridge", "resetCountdown");
            if (this.f8273i != null) {
                this.f8273i.resetCountdown(obj, str);
            }
        } catch (Throwable th) {
            o.b("BannerJSBridge", "resetCountdown", th);
        }
    }

    public void sendImpressions(Object obj, String str) {
        try {
            o.d("BannerJSBridge", "sendImpressions");
            if (this.f8273i != null) {
                this.f8273i.sendImpressions(obj, str);
            }
        } catch (Throwable th) {
            o.b("BannerJSBridge", "sendImpressions", th);
        }
    }

    public void toggleCloseBtn(Object obj, String str) {
        try {
            o.d("BannerJSBridge", "toggleCloseBtn");
            if (this.f8273i != null) {
                this.f8273i.toggleCloseBtn(obj, str);
            }
        } catch (Throwable th) {
            o.b("BannerJSBridge", "toggleCloseBtn", th);
        }
    }

    public void triggerCloseBtn(Object obj, String str) {
        try {
            o.d("BannerJSBridge", "triggerCloseBtn");
            if (this.f8273i != null) {
                this.f8273i.triggerCloseBtn(obj, str);
            }
        } catch (Throwable th) {
            o.b("BannerJSBridge", "triggerCloseBtn", th);
        }
    }
}
