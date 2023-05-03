package com.dconsonni.exercise.bankapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * MoneyTransfertResponse
 */
@Validated
public class MoneyTransfertResponse   {
  @JsonProperty("moneyTransferId")
  private String moneyTransferId = null;

  @JsonProperty("status")
  private String status = null;

  public MoneyTransfertResponse moneyTransferId(String moneyTransferId) {
    this.moneyTransferId = moneyTransferId;
    return this;
  }

  /**
   * Get moneyTransferId
   * @return moneyTransferId
   **/

    public String getMoneyTransferId() {
    return moneyTransferId;
  }

  public void setMoneyTransferId(String moneyTransferId) {
    this.moneyTransferId = moneyTransferId;
  }

  public MoneyTransfertResponse status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
   **/

    public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MoneyTransfertResponse moneyTransfertResponse = (MoneyTransfertResponse) o;
    return Objects.equals(this.moneyTransferId, moneyTransfertResponse.moneyTransferId) &&
        Objects.equals(this.status, moneyTransfertResponse.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(moneyTransferId, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MoneyTransfertResponse {\n");
    
    sb.append("    moneyTransferId: ").append(toIndentedString(moneyTransferId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
