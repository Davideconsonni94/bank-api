package com.dconsonni.exercise.bankapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * Balance
 */
@Validated
public class Balance   {
  @JsonProperty("accountId")
  private String accountId = null;

  @JsonProperty("iban")
  private String iban = null;

  @JsonProperty("abiCode")
  private String abiCode = null;

  @JsonProperty("cabCode")
  private String cabCode = null;

  @JsonProperty("countryCode")
  private String countryCode = null;

  @JsonProperty("internationalCin")
  private String internationalCin = null;

  @JsonProperty("nationalCin")
  private String nationalCin = null;

  @JsonProperty("account")
  private String account = null;

  @JsonProperty("alias")
  private String alias = null;

  @JsonProperty("productName")
  private String productName = null;

  @JsonProperty("holderName")
  private String holderName = null;

  @JsonProperty("activatedDate")
  private String activatedDate = null;

  @JsonProperty("currency")
  private String currency = null;

  public Balance accountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

  /**
   * Get accountId
   * @return accountId
   **/

    public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public Balance iban(String iban) {
    this.iban = iban;
    return this;
  }

  /**
   * Get iban
   * @return iban
   **/

    public String getIban() {
    return iban;
  }

  public void setIban(String iban) {
    this.iban = iban;
  }

  public Balance abiCode(String abiCode) {
    this.abiCode = abiCode;
    return this;
  }

  /**
   * Get abiCode
   * @return abiCode
   **/

    public String getAbiCode() {
    return abiCode;
  }

  public void setAbiCode(String abiCode) {
    this.abiCode = abiCode;
  }

  public Balance cabCode(String cabCode) {
    this.cabCode = cabCode;
    return this;
  }

  /**
   * Get cabCode
   * @return cabCode
   **/

    public String getCabCode() {
    return cabCode;
  }

  public void setCabCode(String cabCode) {
    this.cabCode = cabCode;
  }

  public Balance countryCode(String countryCode) {
    this.countryCode = countryCode;
    return this;
  }

  /**
   * Get countryCode
   * @return countryCode
   **/

    public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public Balance internationalCin(String internationalCin) {
    this.internationalCin = internationalCin;
    return this;
  }

  /**
   * Get internationalCin
   * @return internationalCin
   **/

    public String getInternationalCin() {
    return internationalCin;
  }

  public void setInternationalCin(String internationalCin) {
    this.internationalCin = internationalCin;
  }

  public Balance nationalCin(String nationalCin) {
    this.nationalCin = nationalCin;
    return this;
  }

  /**
   * Get nationalCin
   * @return nationalCin
   **/

    public String getNationalCin() {
    return nationalCin;
  }

  public void setNationalCin(String nationalCin) {
    this.nationalCin = nationalCin;
  }

  public Balance account(String account) {
    this.account = account;
    return this;
  }

  /**
   * Get account
   * @return account
   **/

    public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public Balance alias(String alias) {
    this.alias = alias;
    return this;
  }

  /**
   * Get alias
   * @return alias
   **/

    public String getAlias() {
    return alias;
  }

  public void setAlias(String alias) {
    this.alias = alias;
  }

  public Balance productName(String productName) {
    this.productName = productName;
    return this;
  }

  /**
   * Get productName
   * @return productName
   **/

    public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public Balance holderName(String holderName) {
    this.holderName = holderName;
    return this;
  }

  /**
   * Get holderName
   * @return holderName
   **/

    public String getHolderName() {
    return holderName;
  }

  public void setHolderName(String holderName) {
    this.holderName = holderName;
  }

  public Balance activatedDate(String activatedDate) {
    this.activatedDate = activatedDate;
    return this;
  }

  /**
   * Get activatedDate
   * @return activatedDate
   **/

    public String getActivatedDate() {
    return activatedDate;
  }

  public void setActivatedDate(String activatedDate) {
    this.activatedDate = activatedDate;
  }

  public Balance currency(String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * Get currency
   * @return currency
   **/

    public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Balance balance = (Balance) o;
    return Objects.equals(this.accountId, balance.accountId) &&
        Objects.equals(this.iban, balance.iban) &&
        Objects.equals(this.abiCode, balance.abiCode) &&
        Objects.equals(this.cabCode, balance.cabCode) &&
        Objects.equals(this.countryCode, balance.countryCode) &&
        Objects.equals(this.internationalCin, balance.internationalCin) &&
        Objects.equals(this.nationalCin, balance.nationalCin) &&
        Objects.equals(this.account, balance.account) &&
        Objects.equals(this.alias, balance.alias) &&
        Objects.equals(this.productName, balance.productName) &&
        Objects.equals(this.holderName, balance.holderName) &&
        Objects.equals(this.activatedDate, balance.activatedDate) &&
        Objects.equals(this.currency, balance.currency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, iban, abiCode, cabCode, countryCode, internationalCin, nationalCin, account, alias, productName, holderName, activatedDate, currency);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Balance {\n");
    
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    iban: ").append(toIndentedString(iban)).append("\n");
    sb.append("    abiCode: ").append(toIndentedString(abiCode)).append("\n");
    sb.append("    cabCode: ").append(toIndentedString(cabCode)).append("\n");
    sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
    sb.append("    internationalCin: ").append(toIndentedString(internationalCin)).append("\n");
    sb.append("    nationalCin: ").append(toIndentedString(nationalCin)).append("\n");
    sb.append("    account: ").append(toIndentedString(account)).append("\n");
    sb.append("    alias: ").append(toIndentedString(alias)).append("\n");
    sb.append("    productName: ").append(toIndentedString(productName)).append("\n");
    sb.append("    holderName: ").append(toIndentedString(holderName)).append("\n");
    sb.append("    activatedDate: ").append(toIndentedString(activatedDate)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
