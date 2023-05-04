package com.dconsonni.exercise.bankapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Objects;

/**
 * BankTransfertInfo
 */
public class BankTransfertInfo   {
  @JsonProperty("accountId")
  @NotNull(message = "The accountId is required.")
  private Long accountId = null;

  @JsonProperty("receiverName")
  @NotBlank(message = "The receiverName is required.")
  private String receiverName = null;

  @JsonProperty("description")
  @NotBlank(message = "The description is required.")
  private String description = null;

  @JsonProperty("currency")
  @NotBlank(message = "The currency is required.")
  private String currency = null;

  @JsonProperty("amount")
  @NotBlank(message = "The amount is required.")
  private String amount = null;

  @JsonProperty("executionDate")
  @NotBlank(message = "The executionDate is required.")
  @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])[-.](0[1-9]|1[012])[-.](19|20)\\d\\d$", flags = { Pattern.Flag.CASE_INSENSITIVE, Pattern.Flag.MULTILINE }, message = "The executionDate is invalid.")
  private String executionDate = null;

  public BankTransfertInfo accountId(Long accountId) {
    this.accountId = accountId;
    return this;
  }

  /**
   * Get accountId
   * @return accountId
   **/
    public Long getAccountId() {
    return accountId;
  }

  public void setAccountId(Long accountId) {
    this.accountId = accountId;
  }

  public BankTransfertInfo receiverName(String receiverName) {
    this.receiverName = receiverName;
    return this;
  }

  /**
   * Get receiverName
   * @return receiverName
   **/
    public String getReceiverName() {
    return receiverName;
  }

  public void setReceiverName(String receiverName) {
    this.receiverName = receiverName;
  }

  public BankTransfertInfo description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
   **/
    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BankTransfertInfo currency(String currency) {
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

  public BankTransfertInfo amount(String amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
   **/
    public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public BankTransfertInfo executionDate(String executionDate) {
    this.executionDate = executionDate;
    return this;
  }

  /**
   * Get executionDate
   * @return executionDate
   **/
    public String getExecutionDate() {
    return executionDate;
  }

  public void setExecutionDate(String executionDate) {
    this.executionDate = executionDate;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankTransfertInfo bankTransfertInfo = (BankTransfertInfo) o;
    return Objects.equals(this.accountId, bankTransfertInfo.accountId) &&
        Objects.equals(this.receiverName, bankTransfertInfo.receiverName) &&
        Objects.equals(this.description, bankTransfertInfo.description) &&
        Objects.equals(this.currency, bankTransfertInfo.currency) &&
        Objects.equals(this.amount, bankTransfertInfo.amount) &&
        Objects.equals(this.executionDate, bankTransfertInfo.executionDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, receiverName, description, currency, amount, executionDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankTransfertInfo {\n");
    
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    receiverName: ").append(toIndentedString(receiverName)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    executionDate: ").append(toIndentedString(executionDate)).append("\n");
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
