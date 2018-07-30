//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.07.27 at 11:26:22 AM ICT 
//


package org.opencps.api.v21.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NotificationTemplate" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="notificationType">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="255"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="sendEmail" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                   &lt;element name="emailSubject">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="255"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="emailBody">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="1000"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="textMessage">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="255"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="sendSMS" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                   &lt;element name="expireDuration" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "notificationTemplate"
})
@XmlRootElement(name = "NotificationTemplateList")
public class NotificationTemplateList {

    @XmlElement(name = "NotificationTemplate", required = true)
    protected List<NotificationTemplateList.NotificationTemplate> notificationTemplate;

    /**
     * Gets the value of the notificationTemplate property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the notificationTemplate property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNotificationTemplate().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NotificationTemplateList.NotificationTemplate }
     * 
     * 
     */
    public List<NotificationTemplateList.NotificationTemplate> getNotificationTemplate() {
        if (notificationTemplate == null) {
            notificationTemplate = new ArrayList<NotificationTemplateList.NotificationTemplate>();
        }
        return this.notificationTemplate;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="notificationType">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="255"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="sendEmail" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *         &lt;element name="emailSubject">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="255"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="emailBody">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="1000"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="textMessage">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="255"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="sendSMS" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *         &lt;element name="expireDuration" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "notificationType",
        "sendEmail",
        "emailSubject",
        "emailBody",
        "textMessage",
        "sendSMS",
        "expireDuration"
    })
    public static class NotificationTemplate {

        @XmlElement(required = true)
        protected String notificationType;
        protected boolean sendEmail;
        @XmlElement(required = true)
        protected String emailSubject;
        @XmlElement(required = true)
        protected String emailBody;
        @XmlElement(required = true)
        protected String textMessage;
        protected boolean sendSMS;
        protected int expireDuration;

        /**
         * Gets the value of the notificationType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNotificationType() {
            return notificationType;
        }

        /**
         * Sets the value of the notificationType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNotificationType(String value) {
            this.notificationType = value;
        }

        /**
         * Gets the value of the sendEmail property.
         * 
         */
        public boolean isSendEmail() {
            return sendEmail;
        }

        /**
         * Sets the value of the sendEmail property.
         * 
         */
        public void setSendEmail(boolean value) {
            this.sendEmail = value;
        }

        /**
         * Gets the value of the emailSubject property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEmailSubject() {
            return emailSubject;
        }

        /**
         * Sets the value of the emailSubject property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEmailSubject(String value) {
            this.emailSubject = value;
        }

        /**
         * Gets the value of the emailBody property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEmailBody() {
            return emailBody;
        }

        /**
         * Sets the value of the emailBody property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEmailBody(String value) {
            this.emailBody = value;
        }

        /**
         * Gets the value of the textMessage property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTextMessage() {
            return textMessage;
        }

        /**
         * Sets the value of the textMessage property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTextMessage(String value) {
            this.textMessage = value;
        }

        /**
         * Gets the value of the sendSMS property.
         * 
         */
        public boolean isSendSMS() {
            return sendSMS;
        }

        /**
         * Sets the value of the sendSMS property.
         * 
         */
        public void setSendSMS(boolean value) {
            this.sendSMS = value;
        }

        /**
         * Gets the value of the expireDuration property.
         * 
         */
        public int getExpireDuration() {
            return expireDuration;
        }

        /**
         * Sets the value of the expireDuration property.
         * 
         */
        public void setExpireDuration(int value) {
            this.expireDuration = value;
        }

    }

}