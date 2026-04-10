package com.bytedance.pangle.gz;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
class fv extends X509Certificate {
    private final X509Certificate z;

    fv(X509Certificate x509Certificate) {
        this.z = x509Certificate;
    }

    @Override // java.security.cert.X509Extension
    public Set<String> getCriticalExtensionOIDs() {
        return this.z.getCriticalExtensionOIDs();
    }

    @Override // java.security.cert.X509Extension
    public byte[] getExtensionValue(String str) {
        return this.z.getExtensionValue(str);
    }

    @Override // java.security.cert.X509Extension
    public Set<String> getNonCriticalExtensionOIDs() {
        return this.z.getNonCriticalExtensionOIDs();
    }

    @Override // java.security.cert.X509Extension
    public boolean hasUnsupportedCriticalExtension() {
        return this.z.hasUnsupportedCriticalExtension();
    }

    @Override // java.security.cert.X509Certificate
    public void checkValidity() throws CertificateNotYetValidException, CertificateExpiredException {
        this.z.checkValidity();
    }

    @Override // java.security.cert.X509Certificate
    public void checkValidity(Date date) throws CertificateNotYetValidException, CertificateExpiredException {
        this.z.checkValidity(date);
    }

    @Override // java.security.cert.X509Certificate
    public int getVersion() {
        return this.z.getVersion();
    }

    @Override // java.security.cert.X509Certificate
    public BigInteger getSerialNumber() {
        return this.z.getSerialNumber();
    }

    @Override // java.security.cert.X509Certificate
    public Principal getIssuerDN() {
        return this.z.getIssuerDN();
    }

    @Override // java.security.cert.X509Certificate
    public Principal getSubjectDN() {
        return this.z.getSubjectDN();
    }

    @Override // java.security.cert.X509Certificate
    public Date getNotBefore() {
        return this.z.getNotBefore();
    }

    @Override // java.security.cert.X509Certificate
    public Date getNotAfter() {
        return this.z.getNotAfter();
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getTBSCertificate() throws CertificateEncodingException {
        return this.z.getTBSCertificate();
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getSignature() {
        return this.z.getSignature();
    }

    @Override // java.security.cert.X509Certificate
    public String getSigAlgName() {
        return this.z.getSigAlgName();
    }

    @Override // java.security.cert.X509Certificate
    public String getSigAlgOID() {
        return this.z.getSigAlgOID();
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getSigAlgParams() {
        return this.z.getSigAlgParams();
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getIssuerUniqueID() {
        return this.z.getIssuerUniqueID();
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getSubjectUniqueID() {
        return this.z.getSubjectUniqueID();
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getKeyUsage() {
        return this.z.getKeyUsage();
    }

    @Override // java.security.cert.X509Certificate
    public int getBasicConstraints() {
        return this.z.getBasicConstraints();
    }

    @Override // java.security.cert.Certificate
    public byte[] getEncoded() throws CertificateEncodingException {
        return this.z.getEncoded();
    }

    @Override // java.security.cert.Certificate
    public void verify(PublicKey publicKey) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException, NoSuchProviderException {
        this.z.verify(publicKey);
    }

    @Override // java.security.cert.Certificate
    public void verify(PublicKey publicKey, String str) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException, NoSuchProviderException {
        this.z.verify(publicKey, str);
    }

    @Override // java.security.cert.Certificate
    public String toString() {
        return this.z.toString();
    }

    @Override // java.security.cert.Certificate
    public PublicKey getPublicKey() {
        return this.z.getPublicKey();
    }
}
