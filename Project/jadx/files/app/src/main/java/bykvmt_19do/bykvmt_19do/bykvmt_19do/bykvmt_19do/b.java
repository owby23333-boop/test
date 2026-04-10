package bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do;

import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.GMAdEcpmInfo;
import com.bytedance.msdk.api.reward.RewardItem;
import java.util.Map;

/* JADX INFO: compiled from: TTAdPrintUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public static final String a = "b";

    public static void a(String str, String str2, GMAdEcpmInfo gMAdEcpmInfo, RewardItem rewardItem) {
        Logger.e(a, String.format("-------------------------- %1$s --------------------------", "tools show info start"));
        Logger.e(a, String.format("回调方法名称 methodName =  %1$s", str));
        if (gMAdEcpmInfo != null) {
            Logger.e(a, String.format("展示广告信息 ：广告位id = %1$s 代码位id = %2$s adnName = %3$s ecpm = %4$s ", str2, gMAdEcpmInfo.getAdNetworkRitId(), gMAdEcpmInfo.getAdnName(), gMAdEcpmInfo.getPreEcpm()));
        }
        if (rewardItem != null) {
            StringBuilder sb = new StringBuilder();
            if (rewardItem.getCustomData() != null) {
                for (Map.Entry<String, Object> entry : rewardItem.getCustomData().entrySet()) {
                    sb.append("key = ");
                    sb.append(entry.getKey());
                    sb.append(" value = ");
                    sb.append(entry.getValue());
                    sb.append("\n");
                }
            }
            Logger.e(a, String.format("激励回调信息 ：rewardVerify() = %1$s getAmount() = %2$s getRewardName() = %3$s \ngetCustomData(): \n%4$s ", Boolean.valueOf(rewardItem.rewardVerify()), Float.valueOf(rewardItem.getAmount()), rewardItem.getRewardName(), sb.toString()));
        }
        Logger.e(a, String.format("-------------------------- %1$s --------------------------", "tools show info end"));
    }

    public static void a(String str, AdError adError) {
        Logger.e(a, String.format("-------------------------- %1$s --------------------------", "tools error info start"));
        Logger.e(a, String.format("回调方法名称 methodName =  %1$s", str));
        if (adError != null) {
            Logger.e(a, String.format("error_code = %1$s error_message = %2$s", Integer.valueOf(adError.thirdSdkErrorCode), adError.thirdSdkErrorMessage));
        }
        Logger.e(a, String.format("-------------------------- %1$s --------------------------", "tools error info end"));
    }
}
