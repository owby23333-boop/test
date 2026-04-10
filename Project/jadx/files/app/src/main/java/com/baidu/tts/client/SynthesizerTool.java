package com.baidu.tts.client;

import com.baidu.tts.enumtype.UrlEnum;
import com.baidu.tts.jni.EmbeddedSynthesizerEngine;
import com.baidu.tts.tools.ResourceTools;
import com.baidu.tts.tools.StringTool;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class SynthesizerTool {
    public static int CheckDomainFile(String str) {
        if (StringTool.isEmpty(str)) {
            return -12;
        }
        File file = new File(str);
        if (file.exists() && file.canRead()) {
            return EmbeddedSynthesizerEngine.bdTTSCheckDomainFile(ResourceTools.stringToByteArrayAddNull(str));
        }
        return -12;
    }

    public static long getDomainSampleRate(String str) {
        if (StringTool.isEmpty(str)) {
            return -12L;
        }
        File file = new File(str);
        if (file.exists() && file.canRead()) {
            return EmbeddedSynthesizerEngine.bdTTSGetDomainSampleRate(ResourceTools.stringToByteArrayAddNull(str));
        }
        return -12L;
    }

    public static String getEngineInfo() {
        return EmbeddedSynthesizerEngine.bdTTSGetEngineParam();
    }

    public static int getEngineVersion() {
        return EmbeddedSynthesizerEngine.getEngineMinVersion();
    }

    public static String getModelInfo(String str) {
        if (StringTool.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (file.exists() && file.canRead()) {
            return EmbeddedSynthesizerEngine.bdTTSGetDatParam(str);
        }
        return null;
    }

    public static long getSpeechSampleRate(String str) {
        if (StringTool.isEmpty(str)) {
            return -12L;
        }
        File file = new File(str);
        if (file.exists() && file.canRead()) {
            return EmbeddedSynthesizerEngine.bdTTSGetSpeechSampleRate(ResourceTools.stringToByteArrayAddNull(str));
        }
        return -12L;
    }

    public static void setGetLicenseServer(String str) {
        UrlEnum.STATISTICS_MODELLOAD_SERVER.setmUrl(str);
    }

    public static void setModelServer(String str) {
        UrlEnum.MODEL_SERVER.setmUrl(str);
    }

    public static boolean verifyModelFile(String str) {
        if (StringTool.isEmpty(str)) {
            return false;
        }
        try {
            return EmbeddedSynthesizerEngine.bdTTSVerifyDataFile(ResourceTools.stringToByteArrayAddNull(str)) >= 0;
        } catch (Exception unused) {
            return false;
        }
    }
}
