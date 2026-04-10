package com.xuexiang.xupdate.entity;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.xuexiang.xupdate.R;

/* JADX INFO: loaded from: classes4.dex */
public class UpdateError extends Throwable {
    private static final SparseArray<String> sMessages = new SparseArray<>();
    private final int mCode;

    public static final class ERROR {
        public static final int CHECK_APK_CACHE_DIR_EMPTY = 2008;
        public static final int CHECK_IGNORED_VERSION = 2007;
        public static final int CHECK_JSON_EMPTY = 2005;
        public static final int CHECK_NET_REQUEST = 2000;
        public static final int CHECK_NO_NETWORK = 2002;
        public static final int CHECK_NO_NEW_VERSION = 2004;
        public static final int CHECK_NO_WIFI = 2001;
        public static final int CHECK_PARSE = 2006;
        public static final int CHECK_UPDATING = 2003;
        public static final int DOWNLOAD_FAILED = 4000;
        public static final int DOWNLOAD_PERMISSION_DENIED = 4001;
        public static final int INSTALL_FAILED = 5000;
        public static final int PROMPT_ACTIVITY_DESTROY = 3001;
        public static final int PROMPT_UNKNOWN = 3000;
        public static final int UPDATE_UNKNOWN = 5100;
    }

    public UpdateError(int i) {
        this(i, null);
    }

    public UpdateError(int i, String str) {
        super(make(i, str));
        this.mCode = i;
    }

    public UpdateError(Throwable th) {
        super(th);
        this.mCode = ERROR.UPDATE_UNKNOWN;
    }

    public int getCode() {
        return this.mCode;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return getMessage();
    }

    private static String make(int i, String str) {
        String str2 = sMessages.get(i);
        return TextUtils.isEmpty(str2) ? "" : (TextUtils.isEmpty(str) || str.equals("null")) ? str2 : str2 + "(" + str + ")";
    }

    public String getDetailMsg() {
        return "Code:" + this.mCode + ", msg:" + getMessage();
    }

    public static void init(Context context) {
        SparseArray<String> sparseArray = sMessages;
        sparseArray.append(2000, context.getString(R.string.xupdate_error_check_net_request));
        sparseArray.append(2001, context.getString(R.string.xupdate_error_check_no_wifi));
        sparseArray.append(2002, context.getString(R.string.xupdate_error_check_no_network));
        sparseArray.append(2003, context.getString(R.string.xupdate_error_check_updating));
        sparseArray.append(2004, context.getString(R.string.xupdate_error_check_no_new_version));
        sparseArray.append(2005, context.getString(R.string.xupdate_error_check_json_empty));
        sparseArray.append(2006, context.getString(R.string.xupdate_error_check_parse));
        sparseArray.append(2007, context.getString(R.string.xupdate_error_check_ignored_version));
        sparseArray.append(2008, context.getString(R.string.xupdate_error_check_apk_cache_dir_empty));
        sparseArray.append(3000, context.getString(R.string.xupdate_error_prompt_unknown));
        sparseArray.append(3001, context.getString(R.string.xupdate_error_prompt_activity_destroy));
        sparseArray.append(4000, context.getString(R.string.xupdate_error_download_failed));
        sparseArray.append(4001, context.getString(R.string.xupdate_error_download_permission_denied));
        sparseArray.append(5000, context.getString(R.string.xupdate_error_install_failed));
    }
}
