package com.winsigns.investment.framework.measure;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class MeasureValue {

  @JsonIgnore
  private MeasureHost measureHost;

  @JsonIgnore
  private Measure measure;

  private double value;

  public String key() {
    String tmp = this.getMeasure().getName();
    tmp = tmp.substring(tmp.lastIndexOf('.') + 1, tmp.length());

    return this.getMeasureHost().getType().getName() /* + ":" */
        + this.getMeasureHost().getId().toString() + /* ":" + */tmp;
  }

}