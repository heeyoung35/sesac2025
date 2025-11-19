package com.ohgiraffers.restapi.section05.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    /* API 명세서는 개발팀 내외부의 소통을 원활하게 하고, 시스템의 품질과 효율성을 보장하는 역할
    * API $Swagger$는 API 명세서 작성 및 관리를 위한 핵심 도구로, 문서화의 자동화, 클라이언트/서버 코드 생성,
    * 그리고 테스트 환경 제공을 통해 API 개발의 효율성과 정확성을 크게 향상시키기 위해 필요 */
    /* Swagger/OpenAPI를 사용하기 위한 설정 클래스 */

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(swaggerInfo());
    /* openAPI(): OpenAPI 객체를 빈으로 등록하고, swaggerInfo() 메소드를 통해 API의 제목, 설명, 버전 등의 문서 정보를 설정*/
    }

    private Info swaggerInfo() {
        return new Info()
                .title("Ohgiraffers API")
                .description("SpringBoot Swagger 연동 테스트")
                .version("1.0.0");
    }
}
