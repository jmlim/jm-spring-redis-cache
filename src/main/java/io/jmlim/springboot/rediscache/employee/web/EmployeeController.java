package io.jmlim.springboot.rediscache.employee.web;

import io.jmlim.springboot.rediscache.cache.service.LocalCacheService;
import io.jmlim.springboot.rediscache.employee.domain.EmployeeSalary;
import io.jmlim.springboot.rediscache.employee.service.EmployeeSalaryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeSalaryService employeeSalaryService;

    private final LocalCacheService localCacheService;

    private final RedisCacheManager redisCacheManager;

    /**
     * gender 값에 따른 다른 캐시 데이터 값 가져오기 예제.
     *
     * @param model
     * @param gender
     * @return
     */
    @GetMapping(value = "/")
    public String main(Model model,
                       @RequestParam(required = false, defaultValue = "M") String gender) {

        List<EmployeeSalary> employeeSalaryGenderF = employeeSalaryService.getEmployeeSalaryGender("F");
        model.addAttribute("employeeSalaryGenderF", employeeSalaryGenderF);

        List<EmployeeSalary> employeeSalaryGenderM = employeeSalaryService.getEmployeeSalaryGender("M");
        model.addAttribute("employeeSalaryGenderM", employeeSalaryGenderM);

        return "index";
    }

    @GetMapping(value = "/test_cache_manager")
    public String testCacheManager(Model model) {
        Collection<String> cacheNames = redisCacheManager.getCacheNames();
        Cache getEmployeeSalaryGender = redisCacheManager.getCache("getEmployeeSalaryGender");
        if(getEmployeeSalaryGender instanceof RedisCache) {
            RedisCache redisCache = (RedisCache) getEmployeeSalaryGender;
            Cache.ValueWrapper m = redisCache.get("M");
            log.info("-----> data {} ",m.get());
            log.info(redisCache.getName());
        }

        return "department";
    }
}
