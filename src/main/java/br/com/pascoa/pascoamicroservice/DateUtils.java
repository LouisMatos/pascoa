package br.com.pascoa.pascoamicroservice;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class  DateUtils {

  public static ZonedDateTime getDateNow() {
    return ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
  }

}
