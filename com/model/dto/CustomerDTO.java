package com.model.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Date;
import java.util.Objects;


public class CustomerDTO {
    private int customerId;

    @NotNull(message = "customerCode is required.")
    private String customerCode;

    @NotNull(message = "customerName is required.")
    @Pattern(regexp = "([a-zA-Z0-9]+)", message = "customerName has only alphabets")
    private String customerName;

    @NotNull(message = "customerAddress1 is required.")
    private String customerAddress1;

    private String customerAddress2;

    @NotNull(message = "customerPinCode is required.")
    @Min(6)
    private int customerPinCode;

    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "not a well-formed email address")
    @NotNull(message = "email Id is required.")
    private String emailAddress;

    @Min(10)
    private long contactNumber;

    @NotNull(message = "primaryContactPerson is required.")
    private String primaryContactPerson;

    private String recordStatus;

    @NotNull(message = "activeInactiveFlag is required")
    private String activeInactiveFlag ;

    private Date createDate;

    private String createdBy ;

    private Date modifiedDate;

    private String modifiedBy;

    private Date authorizedDate;

    private String authorizedBy;

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

    public CustomerDTO() {
    }

    public CustomerDTO(String customerCode, String customerName, String customerAddress1, String customerAddress2, int customerPinCode, String emailAddress, long contactNumber, String primaryContactPerson, String recordStatus, String activeInactiveFlag, Date createDate, String createdBy, Date modifiedDate, String modifiedBy, Date authorizedDate, String authorizedBy) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDTO makerDTO = (CustomerDTO) o;
        return customerId == makerDTO.customerId && customerPinCode == makerDTO.customerPinCode && contactNumber == makerDTO.contactNumber && Objects.equals(customerCode, makerDTO.customerCode) && Objects.equals(customerName, makerDTO.customerName) && Objects.equals(customerAddress1, makerDTO.customerAddress1) && Objects.equals(customerAddress2, makerDTO.customerAddress2) && Objects.equals(emailAddress, makerDTO.emailAddress) && Objects.equals(primaryContactPerson, makerDTO.primaryContactPerson) && Objects.equals(recordStatus, makerDTO.recordStatus) && Objects.equals(activeInactiveFlag, makerDTO.activeInactiveFlag) && Objects.equals(createDate, makerDTO.createDate) && Objects.equals(createdBy, makerDTO.createdBy) && Objects.equals(modifiedDate, makerDTO.modifiedDate) && Objects.equals(modifiedBy, makerDTO.modifiedBy) && Objects.equals(authorizedDate, makerDTO.authorizedDate) && Objects.equals(authorizedBy, makerDTO.authorizedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, customerCode, customerName, customerAddress1, customerAddress2, customerPinCode, emailAddress, contactNumber, primaryContactPerson, recordStatus, activeInactiveFlag, createDate, createdBy, modifiedDate, modifiedBy, authorizedDate, authorizedBy);
    }

    @Override
    public String toString() {
        return "MakerDTO{" +
                "customerId=" + customerId +
                ", customerCode='" + customerCode + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerAddress1='" + customerAddress1 + '\'' +
                ", customerAddress2='" + customerAddress2 + '\'' +
                ", customerPinCode=" + customerPinCode +
                ", emailAddress='" + emailAddress + '\'' +
                ", contactNumber=" + contactNumber +
                ", primaryContactPerson='" + primaryContactPerson + '\'' +
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
