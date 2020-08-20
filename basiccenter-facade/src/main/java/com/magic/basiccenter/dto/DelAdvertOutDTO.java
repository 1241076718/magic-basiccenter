package com.magic.basiccenter.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;

@JsonIgnoreProperties({"handler", "hibernateLazyInitializer", "fieldHandler"})
public class DelAdvertOutDTO
  implements Serializable
{
  private static final long serialVersionUID = 1L;
}
