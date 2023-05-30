package com.jinpika.temp.ums.feign;

import com.jinpika.common.api.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient("temp-auth")
//告诉spring cloud这个接口是一个远程客户端，要调用coupon服务(nacos中找到)，具体是调用coupon服务的/coupon/coupon/member/list对应的方法
public interface AuthFeignService {
    // 远程服务的url
    @PostMapping("/oauth/token")//注意写全优惠券类上还有映射//注意我们这个地方不是控制层，所以这个请求映射请求的不是我们服务器上的东西，而是nacos注册中心的
    public ResponseEntity<CommonResult> postAccessToken(@RequestParam Map<String, String> parameters);
    // @FeignClient+@RequestMapping构成远程调用的坐标
    //
    //其他类中看似只是调用了CouponFeignService.membercoupons()，而实际上该方法跑去nacos里和rpc里调用了才拿到东西返回
}
