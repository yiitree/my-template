package com.zr.template.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 拦截器配置
 */
@Configuration
public class ServletContextConfig extends WebMvcConfigurationSupport {

  /**
   * 发现如果继承了WebMvcConfigurationSupport，则在yml中配置的相关内容会失效。
   *
   * 重写addResourceHandlers() 防止静态资源被 dispatcherServle
   * @param registry
   */
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
      //url请求的路径，服务器真实路径
//    registry.addResourceHandler("swagger-ui.html");
//    registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
//    registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
//    registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    // 关联文件(uri请求路径，服务器真实路径)
    registry.addResourceHandler("/files/**").addResourceLocations("file:///E:/tmp/file/");
    super.addResourceHandlers(registry);
  }

  /**
   * 配置servlet处理
   * 默认静态资源处理器
   */
  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    configurer.enable();
  }

}
