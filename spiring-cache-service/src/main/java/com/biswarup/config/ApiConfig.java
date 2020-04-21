package com.biswarup.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.biswarup.service.CacheService;
import net.sf.ehcache.config.CacheConfiguration;

@Configuration
@EnableCaching
public class ApiConfig extends CachingConfigurerSupport{

  @Bean
  public CacheService cacheService() {
    return new CacheService();
  }
  
  @Bean(destroyMethod = "shutdown")
  public net.sf.ehcache.CacheManager ehCacheManager() {    
    long cacheSize = 512;
    long ttl = 60 * 60 * 4;    
    net.sf.ehcache.config.Configuration config = new net.sf.ehcache.config.Configuration();
    CacheConfiguration cacheConfig = new CacheConfiguration();
    cacheConfig.setName("studentCache");
    cacheConfig.setTimeToLiveSeconds(ttl);
    cacheConfig.setMaxEntriesLocalHeap(cacheSize);  
    config.addCache(cacheConfig);
    return net.sf.ehcache.CacheManager.newInstance(config);
  }

  @Bean
  public CacheManager cacheManager() {
    return new EhCacheCacheManager(ehCacheManager());
  }


}
