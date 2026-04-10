package miuix.animation.font;

import android.annotation.TargetApi;
import android.content.Context;
import android.provider.Settings;
import android.util.Log;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import miuix.animation.utils.CommonUtils;
import miuix.device.DeviceUtils;

/* JADX INFO: loaded from: classes8.dex */
@TargetApi(26)
public class VarFontUtils {
    private static final int DEFAULT_WGHT = 50;
    private static final String FORMAT_WGHT = "'wght' ";
    private static final boolean IS_USING_VAR_FONT;
    private static final String KEY_FONT_WEIGHT = "key_miui_font_weight_scale";
    public static final int MIN_WGHT;
    private static final int[] MITYPE_WGHT;
    private static final int[] MIUI_WGHT;
    private static final int[][][] RULES;
    private static final String THEME_FONT_DIR = "/data/system/theme/fonts/";

    static {
        boolean z = !isFontAnimDisabled() && !isUsingThemeFont() && DeviceUtils.getTotalRam() > 6 && DeviceUtils.getDeviceLevel() > 0;
        IS_USING_VAR_FONT = z;
        Log.w(CommonUtils.TAG, "IS_USING_VAR_FONT " + z);
        if (z) {
            MIUI_WGHT = new int[]{150, 200, 250, 305, 340, 400, 480, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HW_ERR_REASON, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_OPENED_TIME, 700};
            MITYPE_WGHT = new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
            MIN_WGHT = 10;
            RULES = new int[][][]{new int[][]{new int[]{0, 5}, new int[]{0, 5}, new int[]{1, 6}, new int[]{2, 6}, new int[]{2, 7}, new int[]{3, 8}, new int[]{4, 8}, new int[]{5, 9}, new int[]{6, 9}, new int[]{7, 9}}, new int[][]{new int[]{0, 2}, new int[]{0, 3}, new int[]{1, 4}, new int[]{1, 5}, new int[]{2, 6}, new int[]{2, 7}, new int[]{3, 8}, new int[]{4, 9}, new int[]{5, 9}, new int[]{6, 9}}, new int[][]{new int[]{0, 5}, new int[]{1, 5}, new int[]{2, 5}, new int[]{3, 6}, new int[]{3, 6}, new int[]{4, 7}, new int[]{5, 8}, new int[]{6, 8}, new int[]{7, 8}, new int[]{8, 9}}};
            return;
        }
        MIN_WGHT = 0;
        int[] iArr = new int[0];
        MITYPE_WGHT = iArr;
        MIUI_WGHT = iArr;
        RULES = new int[0][][];
    }

    private VarFontUtils() {
    }

    public static int getScaleWeight(int i, float f, int i2, int i3) {
        float f2;
        if (!IS_USING_VAR_FONT) {
            return i;
        }
        int[] weightRange = getWeightRange(i, f);
        int weightByType = getWeightByType(weightRange[0], i2);
        int weightByType2 = getWeightByType(i, i2);
        int weightByType3 = getWeightByType(weightRange[1], i2);
        if (i3 < 50) {
            float f3 = i3 / 50.0f;
            f2 = ((1.0f - f3) * weightByType) + (f3 * weightByType2);
        } else {
            if (i3 <= 50) {
                return weightByType2;
            }
            float f4 = (i3 - 50) / 50.0f;
            f2 = ((1.0f - f4) * weightByType2) + (f4 * weightByType3);
        }
        return (int) f2;
    }

    public static int getSysFontScale(Context context) {
        return Settings.System.getInt(context.getContentResolver(), KEY_FONT_WEIGHT, 50);
    }

    private static int[] getWeightArray(int i) {
        return (i == 1 || i == 2) ? MITYPE_WGHT : MIUI_WGHT;
    }

    private static int getWeightByType(int i, int i2) {
        return getWeightArray(i2)[i];
    }

    private static int[] getWeightRange(int i, float f) {
        return RULES[f > 20.0f ? (char) 1 : (f <= 0.0f || f >= 12.0f) ? (char) 0 : (char) 2][i];
    }

    private static boolean isFontAnimDisabled() {
        try {
            return CommonUtils.readProp("ro.miui.ui.font.animation").equals("disable");
        } catch (Exception e) {
            Log.w(CommonUtils.TAG, "isFontAnimationEnabled failed", e);
            return false;
        }
    }

    private static boolean isUsingThemeFont() {
        String[] list;
        File file = new File(THEME_FONT_DIR);
        try {
            if (!file.exists() || (list = file.list()) == null) {
                return false;
            }
            return list.length > 0;
        } catch (Exception e) {
            Log.w(CommonUtils.TAG, "isUsingThemeFont, failed to check theme font directory", e);
        }
        return false;
    }

    public static void setVariationFont(TextView textView, int i) {
        if (IS_USING_VAR_FONT) {
            textView.setFontVariationSettings(FORMAT_WGHT + i);
        }
    }
}
