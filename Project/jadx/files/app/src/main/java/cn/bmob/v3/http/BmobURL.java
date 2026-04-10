package cn.bmob.v3.http;

import cn.bmob.v3.http.bean.Init;
import cn.bmob.v3.http.bean.Migration;
import cn.bmob.v3.util.BLog;
import com.anythink.expressad.d.a.b;

/* JADX INFO: loaded from: classes.dex */
public class BmobURL {
    public static final String BASE_URL_INNER = "http://p.bmob.cn/8/";
    public static final String BASE_URL_TEST = "https://opentest.bmob.cn/8/";
    private static volatile BmobURL instance = null;
    private static byte[] lock = new byte[0];
    private static String standbyBaseUrl = "https://open3.bmob.cn/8/";
    private Migration mMigration;
    private String defaultBaseUrl = "https://open3.bmob.cn/8/";
    private String baseUrl = this.defaultBaseUrl;
    public final String RESPONSE_ID = "Response-Id";
    private String secretUrl = this.defaultBaseUrl + "secret";
    private String initUrl = this.defaultBaseUrl + "init";
    private String createUrl = this.defaultBaseUrl + "create";
    private String UPDATE_URL = this.defaultBaseUrl + "update";
    private String DELETE_URL = this.defaultBaseUrl + b.az;
    private String FIND_URL = this.defaultBaseUrl + "find";
    private String collectUrl = this.defaultBaseUrl + "collect";
    private String signupUrl = this.defaultBaseUrl + "signup";
    private String loginUrl = this.defaultBaseUrl + "login";
    private String loginOrSignupUrl = this.defaultBaseUrl + "login_or_signup";
    private String resetUrl = this.defaultBaseUrl + "reset";
    private String resetPasswordByCodeUrl = this.defaultBaseUrl + "phone_reset";
    private String updateUserPwd = this.defaultBaseUrl + "update_user_password";
    private String emailVerifyUrl = this.defaultBaseUrl + "email_verify";
    private String timestampUrl = this.defaultBaseUrl + "timestamp";
    private String batchUrl = this.defaultBaseUrl + "batch";
    private String PUSH_URL = this.defaultBaseUrl + "push";
    private String fileUrl = "http://file.bmob.cn";
    private String uploadUrl = this.defaultBaseUrl + "files";
    private String uploadMkfileUrl = this.defaultBaseUrl + "mkfile";
    private String uploadBputUrl = this.defaultBaseUrl + "bput";
    private String delFileUrl = this.defaultBaseUrl + "delfile";
    private String thumbnailUrl = this.defaultBaseUrl + "thumbnail";
    private String functionUrl = this.defaultBaseUrl + "functions";
    private String realTimeDataUrl = "http://io.bmob.cn:3010";
    private String sqlqueryUrl = this.defaultBaseUrl + "cloud_query";
    private String requestSMSUrl = this.defaultBaseUrl + "request_sms";
    private String requestSMSCodeUrl = this.defaultBaseUrl + "request_sms_code";
    private String verifySMSCodeUrl = this.defaultBaseUrl + "verify_sms_code";
    private String querySMSUrl = this.defaultBaseUrl + "query_sms";
    private String deviceUrl = this.defaultBaseUrl + "device";
    private String phoneCiUrl = this.defaultBaseUrl + "phone_ci";
    private String getSchemas = this.defaultBaseUrl + "schemas";
    private String cdn = this.defaultBaseUrl + "cdn";
    private String savecdnupload = this.defaultBaseUrl + "savecdnupload";
    private String delcdnupload = this.defaultBaseUrl + "delcdnupload";
    private String delcdnbatch = this.defaultBaseUrl + "delcdnbatch";

    private BmobURL() {
    }

    public static BmobURL getDefault() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new BmobURL();
                }
            }
        }
        return instance;
    }

    public static String getStandbyBaseUrl() {
        return standbyBaseUrl;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public String getCollectUrl() {
        return getDefaultBaseUrl() + "collect";
    }

    public String getCreateUrl() {
        return getDefaultBaseUrl() + "create";
    }

    public String getDefaultBaseUrl() {
        return this.defaultBaseUrl;
    }

    public String getFileUrl() {
        return this.fileUrl;
    }

    public String getInitUrl() {
        return getDefaultBaseUrl() + "init";
    }

    public String getPhoneCiUrl() {
        return getDefaultBaseUrl() + "phone_ci";
    }

    public String getRealTimeDataUrl() {
        return this.realTimeDataUrl;
    }

    public String getSecretUrl() {
        return getDefaultBaseUrl() + "secret";
    }

    public String getUpdateUserPwd() {
        return getDefaultBaseUrl() + "update_user_password";
    }

    public String getUrl(String str, Migration migration) {
        String str2 = "?id=" + RequestUtils.getId();
        if (migration == null) {
            return getUrl(str);
        }
        this.mMigration = migration;
        return this.mMigration.getUrlByOption(str) + str2;
    }

    public void setDefaultBaseUrl(String str) {
        this.defaultBaseUrl = str;
        this.baseUrl = str;
    }

    public void setUrls(Init init) {
        if (!BmobClient.isIsNewDomain()) {
            this.fileUrl = init.getFile();
            this.realTimeDataUrl = init.getIo();
        } else {
            BLog.e(this.defaultBaseUrl);
            BLog.e(this.fileUrl);
            BLog.e(this.realTimeDataUrl);
        }
    }

    public String getUrl(String str) {
        String str2 = "?id=" + RequestUtils.getId();
        if (!BmobClient.hasInit()) {
            return this.defaultBaseUrl + str + str2;
        }
        if (this.mMigration == null) {
            return this.defaultBaseUrl + str + str2;
        }
        return this.mMigration.getUrlByOption(str) + str2;
    }
}
