package com.cos.photogramstart.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {// web 설정 파일

	@Value("${file.path}")
	private String uploadFolder;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);

		/// upload/** 이 발동하면 앞을
		/// C:/workspace/springboot4/EaszUp-Springboot-Photogram-Start/upload/로 바꿔준다.
		registry.addResourceHandler("/upload/**") // jsp파일에서 이 경로가 나오면
				.addResourceLocations("file:///" + uploadFolder) // file.path 경로를 적용시킨다.
				.setCachePeriod(3600) // cashe가 유지되는 시간은 1시간이고
				.resourceChain(true) // 위의 설정을 발동시킨다.
				.addResolver(new PathResourceResolver());

	}
}
