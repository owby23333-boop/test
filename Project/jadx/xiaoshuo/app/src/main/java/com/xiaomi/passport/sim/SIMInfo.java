package com.xiaomi.passport.sim;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.xiaomi.account.privacy_data.master.PrivacyDataMaster;
import com.xiaomi.account.privacy_data.master.PrivacyDataType;
import com.xiaomi.accountsdk.account.data.MiuiActivatorInfo;
import com.xiaomi.phonenum.data.AccountCertification;
import com.xiaomi.phonenum.procedure.AccountPhoneNumberSourceFlag;

/* JADX INFO: loaded from: classes8.dex */
public class SIMInfo implements Parcelable {
    public static final Parcelable.Creator<SIMInfo> CREATOR = new Parcelable.Creator<SIMInfo>() { // from class: com.xiaomi.passport.sim.SIMInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SIMInfo createFromParcel(Parcel parcel) {
            return new SIMInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SIMInfo[] newArray(int i) {
            return new SIMInfo[i];
        }
    };
    public static final int INVALID_SLOT_INDEX = -1;
    public static final int INVALID_SUB_ID = -1;
    public static final String SIM_INFO_TYPE_ACTIVATION_ACCOUNT_CERT = "activationAccountCert";
    public static final String SIM_INFO_TYPE_ACTIVATION_OR_OPERATOR_ACCOUNT_CERT = "activationOrOperatorAccountCert";
    public static final String SIM_INFO_TYPE_ACTIVATOR_INFO = "activatorInfo";
    public static final String SIM_INFO_TYPE_ICCID = "iccid";
    public static final String SIM_INFO_TYPE_IMSI = "imsi";
    public static final String SIM_INFO_TYPE_IN_SERVICE = "inService";
    public static final String SIM_INFO_TYPE_LINE_1_NUMBER = "line1Number";
    public static final String SIM_INFO_TYPE_MCCMNC = "mccmnc";
    public static final String SIM_INFO_TYPE_MOBILE_DATA_ENABLE = "mobileDataEnable";
    public static final String SIM_INFO_TYPE_NETWORK_MCCMNC = "networkMCCMNC";
    public static final String SIM_INFO_TYPE_OPERATOR_ACCOUNT_CERT = "operatorAccountCert";
    public static final String SIM_INFO_TYPE_SIM_ID = "simId";
    public static final String SIM_INFO_TYPE_SLOT_INDEX = "slotIndex";
    public static final String SIM_INFO_TYPE_SUB_ID = "subId";
    public final AccountCertification accountCert;
    public final MiuiActivatorInfo activatorInfo;
    public final String iccid;
    public final String imsi;
    public final Boolean inService;
    public final String line1Number;
    public final String mccmnc;
    public final Boolean mobileDataEnable;
    public final String networkMCCMNC;
    public final String simId;
    public final int slotIndex;
    public final int subId;

    public static class Builder {
        private AccountCertification accountCert;
        private MiuiActivatorInfo activatorInfo;
        private String iccid;
        private String imsi;
        private Boolean inService;
        private String line1Number;
        private String mccmnc;
        private Boolean mobileDataEnable;
        private String networkMCCMNC;
        private String simId;
        private int slotIndex;
        private int subId;

        public Builder(Context context, int i) {
            this.slotIndex = i;
            this.subId = -1;
            try {
                this.subId = Integer.parseInt(PrivacyDataMaster.forceGet(context, PrivacyDataType.SUB_ID, String.valueOf(i)));
            } catch (Exception unused) {
            }
        }

        public Builder accountCert(AccountCertification accountCertification) {
            this.accountCert = accountCertification;
            return this;
        }

        public Builder activatorInfo(MiuiActivatorInfo miuiActivatorInfo) {
            this.activatorInfo = miuiActivatorInfo;
            return this;
        }

        public Builder autoGetICCID(Context context) {
            return iccid(PrivacyDataMaster.forceGet(context, PrivacyDataType.ICCID, String.valueOf(this.subId)));
        }

        public Builder autoGetIMSI(Context context) {
            return imsi(PrivacyDataMaster.forceGet(context, PrivacyDataType.IMSI, String.valueOf(this.subId)));
        }

        public Builder autoGetInService(Context context) {
            String strForceGet = PrivacyDataMaster.forceGet(context, PrivacyDataType.SIM_IN_SERVICE, String.valueOf(this.subId), String.valueOf(3000L));
            return strForceGet == null ? this : inService(Boolean.valueOf(Boolean.parseBoolean(strForceGet)));
        }

        public Builder autoGetLine1Number(Context context) {
            return line1Number(PrivacyDataMaster.forceGet(context, PrivacyDataType.LINE_1_NUMBER, String.valueOf(this.subId)));
        }

        public Builder autoGetMCCMNC(Context context) {
            return mccmnc(PrivacyDataMaster.forceGet(context, PrivacyDataType.MCCMNC, String.valueOf(this.subId)));
        }

        public Builder autoGetMobileDataEnable(Context context) {
            try {
                return mobileDataEnable(Boolean.valueOf(Boolean.parseBoolean(PrivacyDataMaster.forceGet(context, PrivacyDataType.MOBILE_DATA_ENABLE, String.valueOf(this.subId)))));
            } catch (Exception unused) {
                return this;
            }
        }

        public Builder autoGetNetworkMCCMNC(Context context) {
            return networkMCCMNC(PrivacyDataMaster.forceGet(context, PrivacyDataType.NETWORK_MCCMNC, String.valueOf(this.subId)));
        }

        public Builder autoGetSIMId(Context context) {
            return simId(SIMId.get(context, this.subId));
        }

        public SIMInfo build() {
            return new SIMInfo(this.slotIndex, this.subId, this.simId, this.line1Number, this.iccid, this.imsi, this.mccmnc, this.networkMCCMNC, this.inService, this.mobileDataEnable, this.accountCert, this.activatorInfo);
        }

        public Builder iccid(String str) {
            this.iccid = str;
            return this;
        }

        public Builder imsi(String str) {
            this.imsi = str;
            return this;
        }

        public Builder inService(Boolean bool) {
            this.inService = bool;
            return this;
        }

        public Builder line1Number(String str) {
            this.line1Number = str;
            return this;
        }

        public Builder mccmnc(String str) {
            this.mccmnc = str;
            return this;
        }

        public Builder mobileDataEnable(Boolean bool) {
            this.mobileDataEnable = bool;
            return this;
        }

        public Builder networkMCCMNC(String str) {
            this.networkMCCMNC = str;
            return this;
        }

        public Builder simId(String str) {
            this.simId = str;
            return this;
        }
    }

    public SIMInfo(int i, int i2, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable AccountCertification accountCertification, @Nullable MiuiActivatorInfo miuiActivatorInfo) {
        this.slotIndex = i;
        this.subId = i2;
        this.simId = str;
        this.line1Number = str2;
        this.iccid = str3;
        this.imsi = str4;
        this.mccmnc = str5;
        this.networkMCCMNC = str6;
        this.inService = bool;
        this.mobileDataEnable = bool2;
        this.accountCert = accountCertification;
        this.activatorInfo = miuiActivatorInfo;
    }

    /* JADX WARN: Removed duplicated region for block: B:86:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.xiaomi.passport.sim.SIMInfo[] build(android.content.Context r18, java.lang.String[] r19, com.xiaomi.phonenum.data.AccountCertification.Getter r20, com.xiaomi.accountsdk.account.data.MiuiActivatorInfo.Getter r21) {
        /*
            Method dump skipped, instruction units count: 452
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.passport.sim.SIMInfo.build(android.content.Context, java.lang.String[], com.xiaomi.phonenum.data.AccountCertification$Getter, com.xiaomi.accountsdk.account.data.MiuiActivatorInfo$Getter):com.xiaomi.passport.sim.SIMInfo[]");
    }

    private static AccountPhoneNumberSourceFlag getAccountCertSourceFlag(String[] strArr) {
        AccountPhoneNumberSourceFlag flag = AccountPhoneNumberSourceFlag.getFlag(new int[0]);
        for (String str : strArr) {
            str.hashCode();
            switch (str) {
                case "activationOrOperatorAccountCert":
                    flag = flag.addFlag(1).addFlag(2);
                    break;
                case "operatorAccountCert":
                    flag = flag.addFlag(2);
                    break;
                case "activationAccountCert":
                    flag = flag.addFlag(1);
                    break;
            }
        }
        return flag;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.slotIndex);
        parcel.writeInt(this.subId);
        parcel.writeString(this.simId);
        parcel.writeString(this.line1Number);
        parcel.writeString(this.iccid);
        parcel.writeString(this.imsi);
        parcel.writeString(this.mccmnc);
        parcel.writeString(this.networkMCCMNC);
        parcel.writeValue(this.inService);
        parcel.writeValue(this.mobileDataEnable);
        parcel.writeParcelable(this.accountCert, i);
        parcel.writeParcelable(this.activatorInfo, i);
    }

    public SIMInfo(Parcel parcel) {
        this.slotIndex = parcel.readInt();
        this.subId = parcel.readInt();
        this.simId = parcel.readString();
        this.line1Number = parcel.readString();
        this.iccid = parcel.readString();
        this.imsi = parcel.readString();
        this.mccmnc = parcel.readString();
        this.networkMCCMNC = parcel.readString();
        this.inService = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.mobileDataEnable = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.accountCert = (AccountCertification) parcel.readParcelable(AccountCertification.class.getClassLoader());
        this.activatorInfo = (MiuiActivatorInfo) parcel.readParcelable(MiuiActivatorInfo.class.getClassLoader());
    }
}
