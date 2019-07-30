package cn.ziming.shiro.model;

import javax.persistence.Column;
import javax.persistence.Id;

public class UserWithBLOBs extends User {
    @Column(name = "ssl_cipher")
    private byte[] sslCipher;

    @Column(name = "x509_issuer")
    private byte[] x509Issuer;

    @Column(name = "x509_subject")
    private byte[] x509Subject;

    @Column(name = "authentication_string")
    private String authenticationString;

    @Column(name = "User_attributes")
    private String userAttributes;

    /**
     * @return ssl_cipher
     */
    public byte[] getSslCipher() {
        return sslCipher;
    }

    /**
     * @param sslCipher
     */
    public void setSslCipher(byte[] sslCipher) {
        this.sslCipher = sslCipher;
    }

    /**
     * @return x509_issuer
     */
    public byte[] getX509Issuer() {
        return x509Issuer;
    }

    /**
     * @param x509Issuer
     */
    public void setX509Issuer(byte[] x509Issuer) {
        this.x509Issuer = x509Issuer;
    }

    /**
     * @return x509_subject
     */
    public byte[] getX509Subject() {
        return x509Subject;
    }

    /**
     * @param x509Subject
     */
    public void setX509Subject(byte[] x509Subject) {
        this.x509Subject = x509Subject;
    }

    /**
     * @return authentication_string
     */
    public String getAuthenticationString() {
        return authenticationString;
    }

    /**
     * @param authenticationString
     */
    public void setAuthenticationString(String authenticationString) {
        this.authenticationString = authenticationString == null ? null : authenticationString.trim();
    }

    /**
     * @return User_attributes
     */
    public String getUserAttributes() {
        return userAttributes;
    }

    /**
     * @param userAttributes
     */
    public void setUserAttributes(String userAttributes) {
        this.userAttributes = userAttributes == null ? null : userAttributes.trim();
    }
}