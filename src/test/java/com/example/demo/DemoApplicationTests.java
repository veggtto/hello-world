package com.example.demo;

import org.junit.jupiter.api.Test;
import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
		Config config = new Config();
		config.useSingleServer()
				// use "rediss://" for SSL connection
				.setAddress("redis://127.0.0.1:6379");
		RedissonClient redisson = Redisson.create(config);

		RMap<String, RBucket<String>> data = redisson.getMap("myMap");

		RBucket<String> bs = redisson.getBucket("myObject");
		bs.set("5");
		bs.set("7");
		data.put("bucket", bs);

		RBucket<String> bucket = data.get("bucket");

		System.out.println(bucket.get());
	}

	public static void main(String[] args) {
		StdDraw.circle(10,20,200);
	}

}
