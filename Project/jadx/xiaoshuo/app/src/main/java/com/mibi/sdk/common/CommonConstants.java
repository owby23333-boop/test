package com.mibi.sdk.common;

import android.text.TextUtils;
import com.mibi.sdk.common.utils.MibiEnvironment;
import java.io.File;

/* JADX INFO: loaded from: classes13.dex */
public class CommonConstants {
    public static final boolean ACCOUNT_PREVIEW;
    public static final String ALIPAY_PACKAGE_NAME = "com.eg.android.AlipayGphone";
    public static final boolean DEBUG;
    public static final String KEY_AGREE = "agree";
    public static final String KEY_AGREE_PRIVACY = "agreePrivacy";
    public static final String KEY_BIND_PHONE_URL = "bindPhoneUrl";
    public static final String KEY_BRAND = "brand";
    public static final String KEY_COUNTRY = "co";
    public static final String KEY_DEVICE_ID = "deviceId";
    public static final String KEY_DOMAIN = "domain";
    public static final String KEY_DOMAIN_PARAM = "domainParam";
    public static final String KEY_ENCRYPT_AES_KEY = "aesKeyEncrypt";
    public static final String KEY_ENCRYPT_OAID = "oaidEncrypt";
    public static final String KEY_ENTRY = "entry";
    public static final String KEY_ERROR = "payment_error";
    public static final String KEY_ERR_CODE = "errcode";
    public static final String KEY_ERR_DESC = "errDesc";
    public static final String KEY_ERR_ID = "errId";
    public static final String KEY_ERR_THROWABLE = "errThrowable";
    public static final String KEY_EXTRA = "extra";
    public static final String KEY_FULL_AUTH = "fullAuth";
    public static final String KEY_ID = "id";
    public static final String KEY_INTENT_URI = "intentUri";
    public static final String KEY_IS_PARTNER_ACCOUNT = "isPartnerAccount";
    public static final String KEY_IS_RESTORED = "isRestored";
    public static final String KEY_LANGUAGE = "la";
    public static final String KEY_MARKET = "market";
    public static final String KEY_META = "meta";
    public static final String KEY_MODEL = "model";
    public static final String KEY_NEED_PRIVACY_AUTHORIZE = "needPrivacyAuthorize";
    public static final String KEY_OAID = "oaid";
    public static final String KEY_OAID_MD5 = "oaidmd5";
    public static final String KEY_ORDER = "order";
    public static final String KEY_ORDER_QR_URL = "orderQrUrl";
    public static final String KEY_OS = "os";
    public static final String KEY_PACKAGE = "package";
    public static final String KEY_PACKAGE_NAME = "packageName";
    public static final String KEY_PARTNER_ACCOUNT_TYPE = "accountType";
    public static final String KEY_PARTNER_MARKET_TYPE = "marketType";
    public static final String KEY_PARTNER_USER_ID = "partnerAccountId";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_PHONE_NUM = "payment_phone_num";
    public static final String KEY_PROCESS_ID = "processId";
    public static final String KEY_PROGRESS_START = "progressStart";
    public static final String KEY_PUB_KEY = "pubKey";
    public static final String KEY_PUB_KEY_ID = "pubKeyId";
    public static final String KEY_SDK_VERSION_CODE = "mibiSdkVersionCode";
    public static final String KEY_SERVICE_ID = "serviceId";
    public static final String KEY_SESSION = "session";
    public static final String KEY_SMS_CODE = "smsCode";
    public static final String KEY_SYSTEM_VERSION = "systemVersion";
    public static final String KEY_TASK_ID = "taskId";
    public static final String KEY_TOKEN_TYPE = "tokenType";
    public static final String KEY_TYPE = "type";
    public static final String KEY_URL = "url";
    public static final String KEY_USER_ID = "userId";
    public static final String KEY_USER_NAME = "userName";
    public static final String KEY_USER_REVOKE = "userRevoke";
    public static final String KEY_VERSION_CODE = "versionCode";
    public static final String KEY_VERSION_NAME = "versionName";
    public static final String KEY_WX_APP_ID = "appid";
    public static final String KEY_XIAOMI_DEVICE_TOKEN = "xiaomiDeviceToken";
    public static final String MARKET_PACKAGE_NAME = "com.xiaomi.market";
    public static final String PATH_DEVICE = "device";
    public static final String PATH_DOMAIN = "domain";
    public static final String PATH_GDPR_AGREE = "privacy/authorize";
    public static final String PATH_NO_ACCOUNT_DEVICE = "/na/device";
    public static final String PATH_NO_ACCOUNT_DOMAIN = "/na/domain";
    public static final String PATH_PARTNER_DEVICE = "/partner/device";
    public static final String PATH_PARTNER_DOMAIN = "/partner/domain";
    public static String SERVICE_ID = null;
    public static String SERVICE_ID_DEFAULT = null;
    public static final boolean STAGING;
    public static String TOKEN_TYPE = null;
    public static final String TOKEN_TYPE_AUTH_TOKEN = "AUTH_TOKEN";
    public static final String TOKEN_TYPE_SERVICE_TOKEN = "SERVICE_TOKEN";
    public static String URL_ACCOUNT_BASE = null;
    public static String URL_BASE = null;
    public static String URL_BASE_DEFAULT = null;
    public static final String URL_ONLINE_ACCOUNT_BASE = "https://account.xiaomi.com/pass";
    public static final String URL_ONLINE_PAYMENT_BASE = "https://billapi.xiaomi.com";
    public static final String URL_ONLINE_WEB_BASE = "https://m.mibi.mi.com";
    public static final String URL_PREVIEW_ACCOUNT_BASE = "http://account.preview.n.xiaomi.net/pass";
    public static final String URL_STAGING_PAYMENT_BASE = "http://staging.billapi.n.xiaomi.com";
    public static final String URL_STAGING_WEB_BASE = "http://m.staging.mibi.n.xiaomi.com";
    public static String URL_WEB_BASE = null;
    public static final String WX_PACKAGE_NAME = "com.tencent.mm";
    public static final String XIAOMI_ACCOUNT_TYPE = "com.xiaomi";
    public static final String XIAOMI_PAYMENT_AUTH_TOKEN_TYPE = "billcenter";
    public static final String XIAOMI_STAGING_PAYMENT_AUTH_TOKEN_TYPE = "sbillcenter_tmp";

    public interface Mgc {
        public static final int ACCOUNTSTATUS_ERROR = 1518;
        public static final int ACCOUNT_FROZEN_ERROR = 1993;
        public static final int AUTH_FAILED_ERROR = 1989;
        public static final int BALANCE_NOT_ENOUGH = 2001;
        public static final int CALLER_VERIFY_ERROR = 1992;
        public static final int CATCHABLE_EXCEPTION = 3002;
        public static final int DUPLICATE_RECHARGE_ERROR = 2004;
        public static final int DUPLICATE_TRADE_ERROR = 2002;
        public static final int EXCEPTION = 3000;
        public static final int GIFTCARD_INVOKE_ERROR = 1996;
        public static final int HAS_BOUGHT_ERROR = 1986;
        public static final int HAS_DEDUCTED_ERROR = 3416;
        public static final int ILLEGAL_REQUEST_ERROR = 1991;
        public static final int MSG_ID_ERROR = 1503;
        public static final int NEED_AUTH_ERROR = 1985;
        public static final int NEED_BIND_PHONE = 7002;
        public static final int NEED_UPGRADE_VERSION = 7000;
        public static final int NEED_VERIFY_SMS_CODE = 7001;
        public static final int NETWORK_ERROR = 1504;
        public static final int NETWORK_NOT_EXIST = 2009;
        public static final int NO_REQUEST_PARAMS = 1501;
        public static final int ORDER_DESC_ERROR = 1534;
        public static final int ORDER_EXPIRED_ERROR = 1569;
        public static final int ORDER_FEE_ERROR = 1507;
        public static final int ORDER_ID_ERROR = 1509;
        public static final int PAGE_MAX_ERROR = 1539;
        public static final int PAGE_SIZE = 25;
        public static final int PAGE_SIZE_ERROR = 1540;
        public static final int PAY_FEE_ERROR = 1512;
        public static final int PAY_ORDER_NOT_EXIST = 2014;
        public static final int PAY_TYPE_ERROR = 1536;
        public static final int PRICE_CHANGED = 1987;
        public static final int PRIVATE_KEY_NOT_EXIST = 2008;
        public static final int PUB_KEY_NOT_EXIST = 2007;
        public static final int RECHARGE_ERROR = 1511;
        public static final int RECHARGE_FEE_ERROR = 1535;
        public static final int RECHARGE_ID_ERROR = 1537;
        public static final int RECHARGE_NOT_EXIST = 2005;
        public static final int RECHARGE_PREPAID_CARD_ERROR = 1988;
        public static final int RECHARGE_STATUS_NOT_EXIST = 2006;
        public static final int RECHARGE_VOUCHER_ERROR = 1994;
        public static final int RSA_SIGN_ERROR = 1007;
        public static final int SENDER_SIGN_ERROR = 2003;
        public static final int SEND_SMS_CODE_FAILED = 7004;
        public static final int SERVICE_TOKEN_EXPIRED = 1984;
        public static final int SING_EMPTY_ERROR = 1538;
        public static final int SMS_CODE_VERIFY_ERROR = 7003;
        public static final String STATUS_FAIL = "FAIL";
        public static final String STATUS_SUCCESS = "SUCCESS";
        public static final int SUCCESS = 200;
        public static final int TEXCEPTION = 3001;
        public static final int THIRD_PART_ORDER_ID_ERROR = 1510;
        public static final int TOO_FREQUENT_VISITS_ERROR = 1008;
        public static final String TRADE_CLOSED = "TRADE_CLOSED";
        public static final String TRADE_FAIL = "TRADE_FAIL";
        public static final String TRADE_SUCCESS = "TRADE_SUCCESS";
        public static final int URL_PARSE_ERROR = 7006;
        public static final int USER_DEDUCT_DECRYPT_ERROR = 3401;
        public static final int USER_DEDUCT_RET_ERROR = 3402;
        public static final int USER_PROCESS_EXPIRED = 8000;
        public static final int USR_ID_MISMATCH_ERROR = 1990;
        public static final String WAIT_BUYER_PAY = "WAIT_BUYER_PAY";
        public static final int WEB_CHNEL = -1;
        public static final int XIAOMI_ID_ERROR = 1505;
    }

    static {
        boolean z = new File("/data/system/xiaomi_account_preview").exists() || MibiEnvironment.isStaging();
        ACCOUNT_PREVIEW = z;
        DEBUG = new File("/data/system/payment_debug").exists();
        boolean z2 = new File("/data/system/server_staging").exists() || MibiEnvironment.isStaging();
        STAGING = z2;
        if (z2) {
            URL_BASE_DEFAULT = URL_STAGING_PAYMENT_BASE;
            SERVICE_ID_DEFAULT = XIAOMI_STAGING_PAYMENT_AUTH_TOKEN_TYPE;
            URL_WEB_BASE = URL_STAGING_WEB_BASE;
        } else {
            URL_BASE_DEFAULT = URL_ONLINE_PAYMENT_BASE;
            SERVICE_ID_DEFAULT = XIAOMI_PAYMENT_AUTH_TOKEN_TYPE;
            URL_WEB_BASE = URL_ONLINE_WEB_BASE;
        }
        URL_BASE = URL_BASE_DEFAULT;
        SERVICE_ID = SERVICE_ID_DEFAULT;
        if (z) {
            URL_ACCOUNT_BASE = URL_PREVIEW_ACCOUNT_BASE;
        } else {
            URL_ACCOUNT_BASE = URL_ONLINE_ACCOUNT_BASE;
        }
        TOKEN_TYPE = TOKEN_TYPE_AUTH_TOKEN;
    }

    public static String getAccountBaseUrl(String str) {
        return Utils.joinUrl(URL_ACCOUNT_BASE, str);
    }

    public static String getUrl(String str) {
        return Utils.joinUrl(URL_BASE, str);
    }

    public static String getWebUrl(String str) {
        return Utils.joinUrl(URL_WEB_BASE, str);
    }

    public static boolean isGlobalHost() {
        return (TextUtils.equals(URL_BASE, URL_ONLINE_PAYMENT_BASE) || TextUtils.equals(URL_BASE, URL_STAGING_PAYMENT_BASE)) ? false : true;
    }

    public static void setServer(String str, String str2) {
        SERVICE_ID = str2;
        URL_BASE = str;
    }
}
