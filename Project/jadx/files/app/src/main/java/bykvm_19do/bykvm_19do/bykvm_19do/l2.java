package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.util.DisplayMetrics;
import com.taobao.accs.flowcontrol.FlowControl;
import com.tencent.smtt.sdk.TbsListener;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class l2 extends e2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f731e;

    l2(Context context) {
        super(true, false);
        this.f731e = context;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.e2
    protected boolean a(JSONObject jSONObject) throws JSONException {
        String str;
        DisplayMetrics displayMetrics = this.f731e.getResources().getDisplayMetrics();
        int i2 = displayMetrics.densityDpi;
        switch (i2) {
            case 120:
                str = "ldpi";
                break;
            case TbsListener.ErrorCode.TPATCH_VERSION_FAILED /* 240 */:
                str = "hdpi";
                break;
            case 260:
            case 280:
            case 300:
            case TbsListener.ErrorCode.ERROR_SDKENGINE_INIT_THROWABLE /* 320 */:
                str = "xhdpi";
                break;
            case 340:
            case 360:
            case TbsListener.ErrorCode.INFO_CODE_BASE /* 400 */:
            case FlowControl.STATUS_FLOW_CTRL_ALL /* 420 */:
            case 440:
            case 480:
                str = "xxhdpi";
                break;
            case 560:
            case 640:
                str = "xxxhdpi";
                break;
            default:
                str = "mdpi";
                break;
        }
        jSONObject.put("density_dpi", i2);
        jSONObject.put("display_density", str);
        jSONObject.put("resolution", displayMetrics.heightPixels + "x" + displayMetrics.widthPixels);
        return true;
    }
}
