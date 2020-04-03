
### Cache를 사용할때 주의해야 할 것
 - 캐싱할 정보의 선택 -> 제일 중요
 - 캐싱할 정보의 유효기간 (TTL — Time To Live ) 설정
 - 캐싱한 정보의 갱신시점

### Java(로 쓰고 Spring으로 읽고, Springboot를 쓴다)에서 Redis를 사용하는 이유
 - 추상화된 API와 어노테이션을 제공
 - 어노테이션 사용만으로 일반 Service 메서드를 캐시 함수로 사용 가능
 - SpringBoot의 Auto Configuration 적용으로 Cache서버 설정이 간결
 - Springboot Starter Kit을 기본으로 제공함
    - spring-boot-starter-data-redis

### 설정하는 방법은 많이 복잡하거나 까다로울게 없음
 - 스프링부트 의존성 라이브러리 추가
 - Redis 커넥션 정보 설정
 - SpringBoot 메인클래스에 ‘나 캐시 사용할래’ 알려주기
 - 사용할 Method ( controller 메서드 or service 메서드)에 어노테이션 달아주기 -> 캐시전략에서 정해진 ‘서비스&정보’
사용


### Redis CacheServer 설정
- 의존성 라이브러리 추가

~~~groovy
    implementation 'org.springframework.boot:spring-boot-starter-data-redis'
~~~

### Redis 서버설정 — application.yml or application.properties 파일에 추가

~~~yaml
# spring cache redis
spring:
  cache:
    type: redis
  redis:
    host: 레디스 호스트
    port: 레디스 포트
~~~


### SpringBoot에 캐시사용하겠다고 알려주기 — Springboot Main Application Class에 @EnableCaching 어노테이션 추가

~~~java
package io.jmlim.springboot.rediscache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class JmRedisCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(JmRedisCacheApplication.class, args);
    }

}
~~~


### 사용할 서비스 메서드에 어노테이션 달아주기
 - 주요 어노테이션
    - @Cacheable @CachePut -> 캐시등록
    - @Cacheble은 캐시가 있으면 캐시의 정보를 가져오고, 없으면 등록한다.
    - @CacehPut은 무조건 캐시에 저장한다.
    - @CacheEvict -> 캐시삭제
 - 일반 메서드에 어노테이션만 붙여서 바로 사용, 별도의 Cache 메서드를 정의할 필요가 없음
 - @Controller 메서드에 적용하면 파라메터를 Redis의 키값으로 자동지정됨.
 - condition, unless 어노테이션 옵션으로 특정 조건에 따른 캐시적용여부 설정가능


출처 : 
 - https://medium.com/@yongkyu.jang/%EC%9A%B0%EB%A6%AC%EA%B0%80-%EC%84%9C%EB%B9%84%EC%8A%A4%EB%A5%BC-%EA%B0%9C%EB%B0%9C%ED%95%A0-%EB%95%8C-%EB%B0%B1%EC%95%A4%EB%93%9C-%EC%98%81%EC%97%AD%EC%97%90%EC%84%9C-cache%EB%A5%BC-%EC%A0%81%EA%B7%B9%EC%A0%81%EC%9C%BC%EB%A1%9C-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B2%8C-%EB%90%98%EB%A9%B4-%EC%83%9D%EA%B0%81%ED%96%88%EB%8D%98%EA%B2%83-%EB%B3%B4%EB%8B%A4-%EB%8D%94-%EB%93%9C%EB%9D%BC%EB%A7%88%ED%8B%B1%ED%95%9C-%EC%84%9C%EB%B9%84%EC%8A%A4-%EC%84%B1%EB%8A%A5-%EA%B0%9C%EC%84%A0%EC%9D%84-%EA%B0%80%EC%A0%B8%EC%98%AC-%EC%88%98-%EC%9E%88%EB%8B%A4-%EA%B3%A0-%EC%83%9D%EA%B0%81%ED%95%9C%EB%8B%A4-98ab99adfd69