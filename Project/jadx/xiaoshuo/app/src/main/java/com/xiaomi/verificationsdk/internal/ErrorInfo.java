package com.xiaomi.verificationsdk.internal;

import com.xiaomi.account.passportsdk.account_sso.R;

/* JADX INFO: loaded from: classes8.dex */
public enum ErrorInfo {
    NETWORK_ERROR_INFO(R.string.passport_network_error),
    NETWORK_TIMEOUT_INFO(R.string.passport_network_timeout),
    SYSTEM_ERROR_INFO(R.string.passport_system_error),
    ACCESS_DENIED_INFO(R.string.passport_access_denied),
    UNKNOWN_ERROR_INFO(R.string.passport_unknown_error);

    public int errorMessageId;

    public enum ErrorCode {
        ERROR_SERVER(-1),
        ERROR_JSON_EXCEPTION(1),
        ERROR_ACCESSDENIED_EXCEPTION(2),
        ERROR_AUTHENTICATIONFAILURE_EXCEPTION(3),
        ERROR_NETWORK_EXCEPTION(4),
        ERROR_ENCRYPT_EXCEPTION(5),
        ERROR_INTERRUPTED_EXCEPTION(6),
        ERROR_HUMANCOMPUTER_VERIFICATION_FAILED(7),
        ERROR_EVENTID_EXPIRED(8),
        ERROR_CONNECT_UNREACHABLE_EXCEPTION(9),
        ERROR_SOCKET_TIMEOUT_EXCEPTION(10),
        ERROR_CONNECT_TIMEOUT_EXCEPTION(11),
        ERROR_IO_EXCEPTION(12),
        ERROR_REGISTRATION_SESSION_EXCEPTION(13),
        ERROR_VERIFY_SERVER(14);

        private int errorCode;

        ErrorCode(int i) {
            this.errorCode = i;
        }

        public int getCode() {
            return this.errorCode;
        }
    }

    ErrorInfo(int i) {
        this.errorMessageId = i;
    }

    public static int getMsgIdGivenErrorCode(ErrorCode errorCode) {
        if (errorCode == ErrorCode.ERROR_JSON_EXCEPTION) {
            return SYSTEM_ERROR_INFO.errorMessageId;
        }
        if (errorCode == ErrorCode.ERROR_ACCESSDENIED_EXCEPTION) {
            return ACCESS_DENIED_INFO.errorMessageId;
        }
        if (errorCode != ErrorCode.ERROR_AUTHENTICATIONFAILURE_EXCEPTION && errorCode != ErrorCode.ERROR_NETWORK_EXCEPTION && errorCode != ErrorCode.ERROR_ENCRYPT_EXCEPTION && errorCode != ErrorCode.ERROR_HUMANCOMPUTER_VERIFICATION_FAILED) {
            if (errorCode == ErrorCode.ERROR_CONNECT_UNREACHABLE_EXCEPTION) {
                return NETWORK_ERROR_INFO.errorMessageId;
            }
            if (errorCode != ErrorCode.ERROR_SOCKET_TIMEOUT_EXCEPTION && errorCode != ErrorCode.ERROR_CONNECT_TIMEOUT_EXCEPTION) {
                if (errorCode != ErrorCode.ERROR_SERVER && errorCode != ErrorCode.ERROR_INTERRUPTED_EXCEPTION && errorCode != ErrorCode.ERROR_EVENTID_EXPIRED) {
                    return errorCode == ErrorCode.ERROR_IO_EXCEPTION ? NETWORK_ERROR_INFO.errorMessageId : UNKNOWN_ERROR_INFO.errorMessageId;
                }
                return SYSTEM_ERROR_INFO.errorMessageId;
            }
            return NETWORK_TIMEOUT_INFO.errorMessageId;
        }
        return SYSTEM_ERROR_INFO.errorMessageId;
    }
}
