package com.dangdang.reader.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.dangdang.reader.global.DangdangConfig;
import com.dangdang.zframework.log.LogM;
import com.duokan.utils.mmkv.a;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.UnsupportedEncodingException;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: loaded from: classes10.dex */
public class ConfigManager {
    public static final String CHANNEL_ID_GOOGLE_PLAY = "30041";
    public static final String DANG_BOOK_STORE = "dang_book_store_config";
    public static final String DANG_PERSONAL = "dang_personal_config";
    public static final String DANG_READER_PREF = "dang_reader_config";
    public static final String ENVIRONMENT = "environment";
    public static final String FIRST_UPGRADE_FILE = "first_upgrade_file";
    public static final String IS_CLOSED_HOME_DIALOG_TODAY_BY_CUST_ID = "is_closed_home_dialog_today_by_cust_id";
    public static final String IS_CLOSED_TODAY_BY_CUST_ID = "is_closed_today_by_cust_id";
    public static final String IS_COMPANY_VIP_INVALID_SHOWED = "is_company_vip_invalid_showed_byuser";
    public static final String IS_FIRST_VIST_APP = "is_first_vist_app";
    public static final String IS_FIRST_VIST_PUNCH_MAIN = "is_first_vist_punch_main_app";
    public static final String IS_FIRST_VIST_TODAY = "is_first_vist_today";
    public static final String IS_FIRST_VIST_TODAY_BY_CUST_ID = "is_first_vist_today_by_cust_id";
    public static final String IS_FLIPVIEW_SHOWED_TODAY = "is_flipview_showed_today";
    public static final String KEY_CANCELED_MOVE_DATA_TO_SDCARD = "not_move_data_to_sdcard";
    public static final String KEY_CANCELLTION_SWITCH = "key_cancelltion_switch";
    public static final String KEY_CONTENT_CSS_VEVSION = "reader_epub_css_version_new";
    public static final String KEY_CURRENT_DATA_IN_SDCARD = "current_data_in_sdcard";
    public static final String KEY_DEFAULT_FONT_EXIST = "default_font_exist";
    public static final String KEY_ERROR_LOG_LINE = "error_log_line";
    public static final String KEY_EXITAPP_FLAG = "key_exitapp_flag";
    public static final String KEY_EYE_CARE_TIME = "rest_period_per_mins";
    public static final String KEY_FOCUS_WEIXIN_SWITCH = "key_focus_weixin_switch";
    public static final String KEY_HAS_SENT_CHANNEL_ID = "has_sent_channel";
    public static final String KEY_INIT_CARTID = "init_cartId";
    public static final String KEY_INIT_DATA_IN_SDCARD = "init_data_in_sdcard";
    public static final String KEY_INIT_PERMANENTID = "init_permanentId";
    public static final String KEY_IS_CLOSE_CHANGE_BG = "close_change_bg";
    public static final String KEY_IS_READ_VERTICAL_BG = "read_vertical_bg";
    public static final String KEY_IS_REGISTER = "is_sina_register";
    public static final String KEY_IS_REGISTER_TENCENT = "is_tencent_register";
    public static final String KEY_LISTEN_PLAY_SPEED = "key_listen_play_speed";
    public static final String KEY_PROMPT_NUM = "prompt_num";
    public static final String KEY_SYNC_NEWTIP = "key_sync_newtip";
    public static final int LIGHT_SCALE_FACTOR = 100;
    public static final String MESSAGE_SEND_STATE = "message_send_state";
    public static final String MESSAGE_SEND_STATE_FILE = "message_send_state_file";
    public static final String PACKAGE_BOTTOM_INTRO = "package_bottom_intro";
    public static final String PDF_RESOURCE_FILE = "pdf_resource_file";
    public static final String PDF_RESOURCE_URL = "pdf_resource_url";
    private static final String PRIVATE_KEY_URL = "priave";
    private static final String PUBLIC_KEY_URL = "public";
    public static final String SHARE_MINI_SWITCH = "share_to_mini_switch";
    public static final String STARTPAGE_IMG_FILE = "startpage_img_file";
    public static final String STARTPAGE_IMG_VERSION = "startpage_img_version";
    private Context context;
    private SharedPreferences pref;

    public ConfigManager(Context context) {
        this.pref = null;
        this.context = context;
        this.pref = a.e().f(DANG_READER_PREF, context);
    }

    private static void closeStream(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0066: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:26:0x0066 */
    public static String getCPUSerial() throws Throwable {
        InputStreamReader inputStreamReader;
        IOException e;
        LineNumberReader lineNumberReader;
        Closeable closeable;
        String str = "0000000000000000";
        Closeable closeable2 = null;
        try {
            try {
                inputStreamReader = new InputStreamReader(Runtime.getRuntime().exec("system/proc/cpuinfo").getInputStream());
                try {
                    lineNumberReader = new LineNumberReader(inputStreamReader);
                    for (int i = 1; i < 500; i++) {
                        try {
                            String line = lineNumberReader.readLine();
                            if (line == null) {
                                break;
                            }
                            line.substring(line.indexOf(":") + 1, line.length());
                            str = str + line.trim();
                        } catch (IOException e2) {
                            e = e2;
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e3) {
                    lineNumberReader = null;
                    e = e3;
                } catch (Throwable th) {
                    th = th;
                    closeStream(closeable2);
                    closeStream(inputStreamReader);
                    throw th;
                }
            } catch (IOException e4) {
                inputStreamReader = null;
                e = e4;
                lineNumberReader = null;
            } catch (Throwable th2) {
                th = th2;
                inputStreamReader = null;
            }
            closeStream(lineNumberReader);
            closeStream(inputStreamReader);
            return str;
        } catch (Throwable th3) {
            th = th3;
            closeable2 = closeable;
        }
    }

    private String getVersionFirstStartKey() {
        int i;
        try {
            i = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0).versionCode;
        } catch (Exception e) {
            e.printStackTrace();
            i = -1;
        }
        return "versionCode:" + i;
    }

    public void delExitAppFlag() {
        SharedPreferences.Editor editorEdit = this.pref.edit();
        editorEdit.remove(KEY_EXITAPP_FLAG);
        editorEdit.commit();
    }

    public String getActivityId() {
        try {
            return String.valueOf(this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 128).metaData.getInt("ACTIVITY_ID"));
        } catch (PackageManager.NameNotFoundException e) {
            LogM.d("Failed to load meta-data, NameNotFound: " + e.getMessage());
            return null;
        } catch (NullPointerException e2) {
            LogM.d("Failed to load meta-data, NullPointer: " + e2.getMessage());
            return null;
        }
    }

    public String getAppName() {
        String string = null;
        try {
            string = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0).applicationInfo.toString();
            LogM.d("appName=" + string);
            return string;
        } catch (Exception e) {
            LogM.d("Failed to get versionName: " + e.getMessage());
            return string;
        }
    }

    public int getCancelltionSwitch() {
        return this.pref.getInt(KEY_CANCELLTION_SWITCH, 0);
    }

    public String getChannelId() {
        return new com.dangdang.zframework.utils.ConfigManager(this.context).getChannelId();
    }

    public String getChannelIds() {
        return this.pref.getString("ids", "");
    }

    public SharedPreferences.Editor getEditor() {
        return this.pref.edit();
    }

    public String getEnvironment() {
        return this.pref.getString(ENVIRONMENT, DangdangConfig.mEnvironment);
    }

    public String getFlipViewClosedToday() {
        return this.pref.getString(IS_FLIPVIEW_SHOWED_TODAY, "");
    }

    public int getFocusWXSwitch() {
        return this.pref.getInt(KEY_FOCUS_WEIXIN_SWITCH, 0);
    }

    public int getHomeBarNumber() {
        return this.pref.getInt("home_bar_number", 0);
    }

    public int getHomeBookNumber() {
        return this.pref.getInt("home_book_number", 0);
    }

    public int getHomeBooklistNumber() {
        return this.pref.getInt("home_booklist_number", 0);
    }

    public String getHomePageLastArticleTime() {
        return this.pref.getString("home_page_last_article_time", "");
    }

    public int getHomeSystemNumber() {
        return this.pref.getInt("home_system_number", 0);
    }

    public String getIsCompanyVipInvalidShowed() {
        return this.pref.getString(IS_COMPANY_VIP_INVALID_SHOWED, "");
    }

    public int getIsFirsVistPunchMain() {
        return this.pref.getInt(IS_FIRST_VIST_PUNCH_MAIN, 0);
    }

    public int getIsFirsVisttAPP() {
        return this.pref.getInt(IS_FIRST_VIST_APP, 0);
    }

    public String getIsFirsVisttToday() {
        return this.pref.getString(IS_FIRST_VIST_TODAY, "");
    }

    public int getJoinReadPlanPeopleCount() {
        return this.pref.getInt("join_read_plan_people_count", 0);
    }

    public int getNewCountByColumnCode(String str) {
        return this.pref.getInt("shelf_recon_" + str, 0);
    }

    public String getOSVersion() {
        return Build.VERSION.RELEASE;
    }

    public String getPackageBottomIntro() {
        return this.pref.getString(PACKAGE_BOTTOM_INTRO, DebugKt.DEBUG_PROPERTY_VALUE_OFF);
    }

    public String getPackageName() {
        return this.context.getPackageName();
    }

    public String getPdfResourceUrl() {
        return a.e().f(PDF_RESOURCE_FILE, this.context).getString(PDF_RESOURCE_URL, "");
    }

    public String getPhoneModel() {
        return Build.MODEL;
    }

    public SharedPreferences getPreferences() {
        return this.pref;
    }

    public String getPrivateKeyPath() {
        return this.context.getFilesDir().toString() + "/" + PRIVATE_KEY_URL;
    }

    public byte[] getPrivateKeyPathByte() {
        try {
            return getPrivateKeyPath().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getPublicKeyPath() {
        return this.context.getFilesDir().toString() + "/" + PUBLIC_KEY_URL;
    }

    public byte[] getPublicKeyPathByte() {
        try {
            return getPublicKeyPath().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getServerVesion() {
        try {
            return this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 128).metaData.getString("SERVER_VERSION");
        } catch (PackageManager.NameNotFoundException e) {
            LogM.d("Failed to load meta-data, NameNotFound: " + e.getMessage());
            return null;
        } catch (NullPointerException e2) {
            LogM.d("Failed to load meta-data, NullPointer: " + e2.getMessage());
            return null;
        }
    }

    public String getShareMiniSwitch() {
        return this.pref.getString(SHARE_MINI_SWITCH, DebugKt.DEBUG_PROPERTY_VALUE_OFF);
    }

    public int getStartPageImgVersion() {
        return a.e().f(STARTPAGE_IMG_FILE, this.context).getInt(STARTPAGE_IMG_VERSION, 1);
    }

    public String getTagIds() {
        return this.pref.getString("tagids", "");
    }

    public String getUserIsClosedHomeDialogToday() {
        return this.pref.getString(IS_CLOSED_HOME_DIALOG_TODAY_BY_CUST_ID, "");
    }

    public String getUserIsClosedToday() {
        return this.pref.getString(IS_CLOSED_TODAY_BY_CUST_ID, "");
    }

    public String getUserIsFirsVisttToday() {
        return this.pref.getString(IS_FIRST_VIST_TODAY_BY_CUST_ID, "");
    }

    public String getVersionCode() {
        int i;
        try {
            i = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0).versionCode;
        } catch (Exception e) {
            e.printStackTrace();
            i = -1;
        }
        return "" + i;
    }

    public String getVersionName() {
        String str = null;
        try {
            str = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0).versionName;
            LogM.d("versionName=" + str);
            return str;
        } catch (Exception e) {
            LogM.d("Failed to get versionName: " + e.getMessage());
            return str;
        }
    }

    public boolean hasExitAppFlag() {
        return this.pref.getBoolean(KEY_EXITAPP_FLAG, false);
    }

    public boolean isCancelledMoveDataToSdcard() {
        return this.pref.getBoolean(KEY_CANCELED_MOVE_DATA_TO_SDCARD, false);
    }

    public boolean isCopyPdfRes() {
        return a.e().f(PDF_RESOURCE_FILE, this.context).contains(PDF_RESOURCE_URL);
    }

    public boolean isCurrVersionFirstStart() {
        return this.pref.getBoolean(getVersionFirstStartKey(), true);
    }

    public boolean isCurrentDataInSdcard() {
        return this.pref.getBoolean(KEY_CURRENT_DATA_IN_SDCARD, false);
    }

    public boolean isFirstAccess(String str) {
        return a.e().f(FIRST_UPGRADE_FILE, this.context).getBoolean(str, true);
    }

    public boolean isInitDataInSdcard() {
        return this.pref.getBoolean(KEY_INIT_DATA_IN_SDCARD, false);
    }

    public void saveCurrVersionFirstStartFlag(boolean z) {
        SharedPreferences.Editor editorEdit = this.pref.edit();
        editorEdit.putBoolean(getVersionFirstStartKey(), z);
        editorEdit.commit();
    }

    public void saveExitAppFlag(boolean z) {
        SharedPreferences.Editor editorEdit = this.pref.edit();
        editorEdit.putBoolean(KEY_EXITAPP_FLAG, z);
        editorEdit.commit();
    }

    public void setCancelledMoveDataToSdcard(boolean z) {
        SharedPreferences.Editor editorEdit = this.pref.edit();
        editorEdit.putBoolean(KEY_CANCELED_MOVE_DATA_TO_SDCARD, z);
        editorEdit.commit();
    }

    public void setCancelltionSwitch(int i) {
        SharedPreferences.Editor editorEdit = this.pref.edit();
        editorEdit.putInt(KEY_CANCELLTION_SWITCH, i);
        editorEdit.commit();
    }

    public void setChannelIds(String str) {
        if (str == null) {
            str = "";
        }
        SharedPreferences.Editor editorEdit = this.pref.edit();
        editorEdit.putString("ids", str);
        editorEdit.commit();
    }

    public void setCurrentDataInSdcard(boolean z) {
        SharedPreferences.Editor editorEdit = this.pref.edit();
        editorEdit.putBoolean(KEY_CURRENT_DATA_IN_SDCARD, z);
        editorEdit.commit();
    }

    public void setEnvironment(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.pref.edit();
        editorEdit.putString(ENVIRONMENT, str);
        editorEdit.commit();
    }

    public void setFlipViewClosedToday(String str) {
        SharedPreferences.Editor editorEdit = this.pref.edit();
        editorEdit.putString(IS_FLIPVIEW_SHOWED_TODAY, str);
        editorEdit.commit();
    }

    public void setFocusWXSwitch(int i) {
        SharedPreferences.Editor editorEdit = this.pref.edit();
        editorEdit.putInt(KEY_FOCUS_WEIXIN_SWITCH, i);
        editorEdit.commit();
    }

    public void setHomeBarNumber(int i) {
        SharedPreferences.Editor editorEdit = this.pref.edit();
        editorEdit.putInt("home_bar_number", i);
        editorEdit.commit();
    }

    public void setHomeBookNumber(int i) {
        SharedPreferences.Editor editorEdit = this.pref.edit();
        editorEdit.putInt("home_book_number", i);
        editorEdit.commit();
    }

    public void setHomeBooklistNumber(int i) {
        SharedPreferences.Editor editorEdit = this.pref.edit();
        editorEdit.putInt("home_booklist_number", i);
        editorEdit.commit();
    }

    public void setHomePageLastArticleTime(long j) {
        SharedPreferences.Editor editorEdit = this.pref.edit();
        editorEdit.putString("home_page_last_article_time", j + "");
        editorEdit.commit();
    }

    public void setHomeSystemNumber(int i) {
        SharedPreferences.Editor editorEdit = this.pref.edit();
        editorEdit.putInt("home_system_number", i);
        editorEdit.commit();
    }

    public void setInitInSdcard(boolean z) {
        SharedPreferences.Editor editorEdit = this.pref.edit();
        editorEdit.putBoolean(KEY_INIT_DATA_IN_SDCARD, z);
        editorEdit.commit();
    }

    public void setIsCompanyVipInvalidShowed(String str) {
        SharedPreferences.Editor editorEdit = this.pref.edit();
        editorEdit.putString(IS_COMPANY_VIP_INVALID_SHOWED, str);
        editorEdit.commit();
    }

    public void setIsFirsVistPunchMain(int i) {
        SharedPreferences.Editor editorEdit = this.pref.edit();
        editorEdit.putInt(IS_FIRST_VIST_PUNCH_MAIN, i);
        editorEdit.commit();
    }

    public void setIsFirsVisttAPP(int i) {
        SharedPreferences.Editor editorEdit = this.pref.edit();
        editorEdit.putInt(IS_FIRST_VIST_APP, i);
        editorEdit.commit();
    }

    public void setIsFirsVisttToday(String str) {
        SharedPreferences.Editor editorEdit = this.pref.edit();
        editorEdit.putString(IS_FIRST_VIST_TODAY, str);
        editorEdit.commit();
    }

    public void setJoinReadPlanPeopleCount(int i) {
        SharedPreferences.Editor editorEdit = this.pref.edit();
        editorEdit.putInt("join_read_plan_people_count", i);
        editorEdit.commit();
    }

    public void setNewCountByColumnCode(String str, int i) {
        SharedPreferences.Editor editorEdit = this.pref.edit();
        editorEdit.putInt("shelf_recon_" + str, i);
        editorEdit.apply();
    }

    public void setPackageBottomIntro(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.pref.edit();
        editorEdit.putString(PACKAGE_BOTTOM_INTRO, str);
        editorEdit.commit();
    }

    public void setPdfResourceUrl(String str) {
        SharedPreferences.Editor editorEdit = a.e().f(PDF_RESOURCE_FILE, this.context).edit();
        editorEdit.putString(PDF_RESOURCE_URL, str);
        editorEdit.commit();
    }

    public void setShareMiniSwitch(String str) {
        SharedPreferences.Editor editorEdit = this.pref.edit();
        editorEdit.putString(SHARE_MINI_SWITCH, str);
        editorEdit.commit();
    }

    public void setTagIds(String str) {
        if (str == null) {
            str = "";
        }
        SharedPreferences.Editor editorEdit = this.pref.edit();
        editorEdit.putString("tagids", str);
        editorEdit.commit();
    }

    public void setUpdateFinish(String str) {
        SharedPreferences.Editor editorEdit = a.e().f(FIRST_UPGRADE_FILE, this.context).edit();
        editorEdit.putBoolean(str, false);
        editorEdit.commit();
    }

    public void setUserIsClosedHomeDialogToday(String str) {
        SharedPreferences.Editor editorEdit = this.pref.edit();
        editorEdit.putString(IS_CLOSED_HOME_DIALOG_TODAY_BY_CUST_ID, str);
        editorEdit.commit();
    }

    public void setUserIsClosedToday(String str) {
        SharedPreferences.Editor editorEdit = this.pref.edit();
        editorEdit.putString(IS_CLOSED_TODAY_BY_CUST_ID, str);
        editorEdit.commit();
    }

    public void setUserIsFirsVisttToday(String str) {
        SharedPreferences.Editor editorEdit = this.pref.edit();
        editorEdit.putString(IS_FIRST_VIST_TODAY_BY_CUST_ID, str);
        editorEdit.commit();
    }

    public void updateStartPageImgVersion(int i) {
        SharedPreferences.Editor editorEdit = a.e().f(STARTPAGE_IMG_FILE, this.context).edit();
        editorEdit.putInt(STARTPAGE_IMG_VERSION, i);
        editorEdit.commit();
    }

    public static SharedPreferences getPreferences(Context context) {
        return a.e().f(DANG_READER_PREF, context);
    }

    public ConfigManager(Context context, String str) {
        this.pref = null;
        this.context = context;
        this.pref = a.e().f(DANG_READER_PREF, context);
    }
}
