package com.api.v1.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync(proxyTargetClass = true)
public class SpringAsyncConfig {
}