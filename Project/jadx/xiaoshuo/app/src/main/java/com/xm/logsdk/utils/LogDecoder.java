package com.xm.logsdk.utils;

import com.xm.logsdk.log.logger.crypt.CryptLog;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes8.dex */
public class LogDecoder {
    private CryptLog mCrypt;

    public LogDecoder(String str) {
        this.mCrypt = null;
        this.mCrypt = new CryptLog(str);
    }

    private boolean checkFileHeader(byte[] bArr) {
        if (bArr == null || bArr.length != 11) {
            return false;
        }
        byte b2 = bArr[0];
        if (b2 != 6 && b2 != 7) {
            return false;
        }
        if (new String(bArr, 2, 5).equals("magic")) {
            return true;
        }
        log("illegal eheader magic");
        return false;
    }

    public void decodeLog(String str) throws Throwable {
        DataOutputStream dataOutputStream;
        DataInputStream dataInputStream;
        byte[] bArr;
        File file = new File(str);
        DataInputStream dataInputStream2 = null;
        try {
            try {
                dataOutputStream = new DataOutputStream(new FileOutputStream(str + "_txt"));
                try {
                    try {
                        dataInputStream = new DataInputStream(new FileInputStream(file));
                        try {
                            bArr = new byte[11];
                        } catch (Exception e) {
                            e = e;
                            dataInputStream2 = dataInputStream;
                            e.printStackTrace();
                            if (dataInputStream2 != null) {
                                dataInputStream2.close();
                            }
                            if (dataOutputStream == null) {
                                return;
                            }
                        } catch (Throwable th) {
                            th = th;
                            dataInputStream2 = dataInputStream;
                            if (dataInputStream2 != null) {
                                try {
                                    dataInputStream2.close();
                                } catch (Exception unused) {
                                    throw th;
                                }
                            }
                            if (dataOutputStream != null) {
                                dataOutputStream.flush();
                                dataOutputStream.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
                dataOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                dataOutputStream = null;
            }
            if (dataInputStream.read(bArr, 0, 11) != 11) {
                log("illegal header len");
                try {
                    dataInputStream.close();
                    dataOutputStream.flush();
                    dataOutputStream.close();
                    return;
                } catch (Exception unused2) {
                    return;
                }
            }
            if (!checkFileHeader(bArr)) {
                log("illegal header");
                try {
                    dataInputStream.close();
                    dataOutputStream.flush();
                    dataOutputStream.close();
                    return;
                } catch (Exception unused3) {
                    return;
                }
            }
            if (bArr[0] == 6) {
                decodeLogBySlice(dataInputStream, dataOutputStream);
            } else {
                decodeLogByBlock(dataInputStream, dataOutputStream);
            }
            dataInputStream.close();
            dataOutputStream.flush();
            dataOutputStream.close();
        } catch (Exception unused4) {
        }
    }

    public void decodeLogByBlock(DataInputStream dataInputStream, DataOutputStream dataOutputStream) throws Exception {
        if (dataInputStream == null || dataOutputStream == null) {
            return;
        }
        byte[] blockHeader = this.mCrypt.getBlockHeader(0);
        while (dataInputStream.read(blockHeader, 0, blockHeader.length) == blockHeader.length && blockHeader[0] == 7) {
            int i = 3;
            int i2 = 0;
            int i3 = 0;
            while (i2 < 4) {
                i3 = (i3 << 8) | (blockHeader[i] & 255);
                i2++;
                i++;
            }
            log("len:" + i3);
            byte[] bArr = new byte[i3];
            int i4 = dataInputStream.read(bArr, 0, i3);
            if (i4 != i3) {
                return;
            } else {
                dataOutputStream.write(this.mCrypt.decrypt(bArr, 0, i4).getBytes(StandardCharsets.UTF_8));
            }
        }
    }

    public void decodeLogBySlice(DataInputStream dataInputStream, DataOutputStream dataOutputStream) throws Exception {
        int i;
        if (dataInputStream == null || dataOutputStream == null) {
            return;
        }
        byte[] bArr = new byte[16];
        do {
            i = dataInputStream.read(bArr, 0, 16);
            dataOutputStream.write(this.mCrypt.decrypt(bArr, 0, i).getBytes(StandardCharsets.UTF_8));
        } while (i == 16);
    }

    public void log(String str) {
        System.out.println("LOG_DEC:" + str);
    }
}
