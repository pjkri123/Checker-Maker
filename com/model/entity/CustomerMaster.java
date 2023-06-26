package com.model.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "CUSTOMERMASTER16905")
public class CustomerMaster {
    @Column(name = "customerId", length = 10, nullable = false)
    private int customerId;
    @Id
    @Column(name = "customerCode", length = 10, nullable = false)
    private String customerCode;
    @Column(name = "customerName", length = 30, nullable = false)
    private String customerName;
    @Column(name = "customerAddress1", length = 100, nullable = false)
    private String customerAddress1;
    @Column(name = "customerAddress2", length = 100)
    private String customerAddress2;
    @Column(name = "customerPinCode", length = 6, nullable = false)
    private int customerPinCode;
    @Column(name = "emailAddress", length = 100, nullable = false)
    private String emailAddress;
    @Column(name = "contactNumber", length = 20)
    private long contactNumber;
    @Column(name = "primaryContactPerson", length = 100, nullable = false)
    private String primaryContactPerson;
    @Column(name = "recordStatus", length = 1)
    private String recordStatus;
    @Column(name = "activeInactiveFlag", length = 1, nullable = false)
    private String activeInactiveFlag ;
    @Column(name = "createDate")
    private Date createDate;
    @Column(name = "createdBy")
    private String createdBy ;
    @Column(name = "modifiedDate")
    private Date modifiedDate;
    @Column(name = "modifiedBy", length = 30)
    private String modifiedBy;
    @Column(name = "authorizedDate")
    private Date authorizedDate;
    @Column(name = "authorizedBy", length = 30)
    private String authorizedBy;

    public CustomerMaster() {
    }

    public CustomerMaster(String customerCode, String customerName, String customerAddress1, String customerAddress2, int customerPinCode, String emailAddress, long contactNumber, String primaryContactPerson, String recordStatus, String activeInactiveFlag, Date createDate, String createdBy, Date modifiedDate, String modifiedBy, Date authorizedDate, String authorizedBy) {
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.customerAddress1 = customerAddress1;
        this.customerAddress2 = customerAddress2;
        this.customerPinCode = customerPinCode;
        this.emailAddress = emailAddress;
        this.contactNumber = contactNumber;
        this.primaryContactPerson = primaryContactPerson;
        this.recordStatus = recordStatus;
        this.activeInactiveFlag = activeInactiveFlag;
        this.createDate = createDate;
        this.createdBy = createdBy;
        this.modifiedDate = modifiedDate;
        this.modifiedBy = modifiedBy;
        this.authorizedDate = authorizedDate;
        this.authorizedBy = authorizedBy;
    }
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress1() {
        return customerAddress1;
    }

    public void setCustomerAddress1(String customerAddress1) {
        this.customerAddress1 = customerAddress1;
    }

    public String getCustomerAddress2() {
        return customerAddress2;
    }

    public void setCustomerAddress2(String customerAddress2) {
        this.customerAddress2 = customerAddress2;
    }

    public int getCustomerPinCode() {
        return customerPinCode;
    }

    public void setCustomerPinCode(int customerPinCode) {
        this.customerPinCode = customerPinCode;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getPrimaryContactPerson() {
        return primaryContactPerson;
    }

    public void setPrimaryContactPerson(String primaryContactPerson) {
        this.primaryContactPerson = primaryContactPerson;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getActiveInactiveFlag() {
        return activeInactiveFlag;
    }

    public void setActiveInactiveFlag(String activeInactiveFlag) {
        this.activeInactiveFlag = activeInactiveFlag;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getAuthorizedDate() {
        return authorizedDate;
    }

    public void setAuthorizedDate(Date authorizedDate) {
        this.authorizedDate = authorizedDate;
    }

    public String getAuthorizedBy() {
        return authorizedBy;
    }

    public void setAuthorizedBy(String authorizedBy) {
        this.authorizedBy = authorizedBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerMaster that = (CustomerMaster) o;
        return customerId == that.customerId && customerPinCode == that.customerPinCode && contactNumber == that.contactNumber && Objects.equals(customerCode, that.customerCode) && Objects.equals(customerName, that.customerName) && Objects.equals(customerAddress1, that.customerAddress1) && Objects.equals(customerAddress2, that.customerAddress2) && Objects.equals(emailAddress, that.emailAddress) && Objects.equals(primaryContactPerson, that.primaryContactPerson) && Objects.equals(recordStatus, that.recordStatus) && Objects.equals(activeInactiveFlag, that.activeInactiveFlag) && Objects.equals(createDate, that.createDate) && Objects.equals(createdBy, that.createdBy) && Objects.equals(modifiedDate, that.modifiedDate) && Objects.equals(modifiedBy, that.modifiedBy) && Objects.equals(authorizedDate, that.authorizedDate) && Objects.equals(authorizedBy, that.authorizedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, customerCode, customerName, customerAddress1, customerAddress2, customerPinCode, emailAddress, contactNumber, primaryContactPerson, recordStatus, activeInactiveFlag, createDate, createdBy, modifiedDate, modifiedBy, authorizedDate, authorizedBy);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerCode='" + customerCode + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerAddress1='" + customerAddress1 + '\'' +
                ", customerAddress2='" + customerAddress2 + '\'' +
                ", customerPinCode=" + customerPinCode +
                ", emailAddress='" + emailAddress + '\'' +
                ", contactNumber=" + contactNumber +
                ", primaryContactPerson=" + primaryContactPerson +
                ", recordStatus='" + recordStatus + '\'' +
                ", activeInactiveFlag='" + activeInactiveFlag + '\'' +
                ", createDate=" + createDate +
                ", createdBy='" + createdBy + '\'' +
                ", modifiedDate=" + modifiedDate +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", authorizedDate=" + authorizedDate +
                ", authorizedBy='" + authorizedBy + '\'' +
                '}';
    }
}
