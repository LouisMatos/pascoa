package br.com.pascoa.pascoamicroservice.filter;

import java.io.IOException;
import java.util.UUID;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RequestFilter implements Filter {

  private static final String X_REQID = "X-reqID";

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    /* TODO document why this method is empty */
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {

    try {
      MDC.put(X_REQID, getCorrelationId());
      log.info("Request IP address is {}", servletRequest.getRemoteAddr());
      filterChain.doFilter(servletRequest, servletResponse);
    } finally {
      MDC.remove(X_REQID);
    }

  }

  private String getCorrelationId() {
    return UUID.randomUUID().toString();
  }

  @Override
  public void destroy() {
    /* TODO document why this method is empty */
  }

}
