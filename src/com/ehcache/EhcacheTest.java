package com.ehcache;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;

public class EhcacheTest {
	public static void main(String[] args) {
		CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
		          .withCache("preConfigured",
		               CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, String.class)
		               .build())
		          .build(true);

		      Cache<Long, String> preConfigured
		          = cacheManager.getCache("preConfigured", Long.class, String.class);

		      Cache<Long, String> myCache = cacheManager.createCache("myCache",
		          CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, String.class).build());

		      myCache.put(1L, "da one!");
		      String value = myCache.get(1L);
		      System.out.println(value);
		      cacheManager.close();
	}
}
