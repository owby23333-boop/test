package com.arialyy.aria.core.upload.target;

import com.arialyy.aria.core.common.AbsBuilderTarget;
import com.arialyy.aria.core.common.FtpOption;
import com.arialyy.aria.core.common.SFtpOption;
import com.arialyy.aria.core.upload.UploadEntity;
import com.arialyy.aria.util.CommonUtil;

/* JADX INFO: loaded from: classes2.dex */
public class FtpBuilderTarget extends AbsBuilderTarget<FtpBuilderTarget> {
    private UNormalConfigHandler<FtpBuilderTarget> mConfigHandler = new UNormalConfigHandler<>(this, -1);
    private String url;

    FtpBuilderTarget(String str) {
        this.mConfigHandler.setFilePath(str);
        getTaskWrapper().setRequestType(6);
        ((UploadEntity) getEntity()).setTaskType(6);
        getTaskWrapper().setNewTask(true);
    }

    @Deprecated
    public FtpBuilderTarget forceUpload() {
        getTaskWrapper().setIgnoreFilePathOccupy(true);
        return this;
    }

    public FtpBuilderTarget option(FtpOption ftpOption) {
        if (ftpOption == null) {
            throw new NullPointerException("ftp 任务配置为空");
        }
        ftpOption.setUrlEntity(CommonUtil.getFtpUrlInfo(this.url));
        getTaskWrapper().getOptionParams().setParams(ftpOption);
        return this;
    }

    public FtpBuilderTarget setUploadUrl(String str) {
        this.url = str;
        this.mConfigHandler.setTempUrl(str);
        return this;
    }

    public FtpBuilderTarget sftpOption(SFtpOption sFtpOption) {
        if (sFtpOption == null) {
            throw new NullPointerException("ftp 任务配置为空");
        }
        sFtpOption.setUrlEntity(CommonUtil.getFtpUrlInfo(this.url));
        getTaskWrapper().getOptionParams().setParams(sFtpOption);
        ((UploadEntity) getEntity()).setTaskType(13);
        getTaskWrapper().setRequestType(13);
        return this;
    }
}
