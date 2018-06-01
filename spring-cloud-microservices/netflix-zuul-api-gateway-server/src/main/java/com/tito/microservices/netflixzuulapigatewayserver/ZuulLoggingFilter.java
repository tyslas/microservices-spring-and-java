package com.tito.microservices.netflixzuulapigatewayserver;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ZuulLoggingFilter extends ZuulFilter {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Override
  public String filterType() {
    return "pre"; //catches all requests before they are executed
  }

  @Override
  public int filterOrder() {
    return 1;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public Object run() throws ZuulException {
    //returns the current HTTP request being handled
    HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
    logger.info("request => {} request uri => {}", request.getServletPath(), request.getRequestURI());

    return null;
  }
}
