package com.jinpika.temp.coupon.sms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jinpika.temp.coupon.sms.mapper.SmsHomeSubjectMapper;
import com.jinpika.temp.coupon.sms.model.SmsHomeSubject;
import com.jinpika.temp.coupon.sms.service.SmsHomeSubjectService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】 服务实现类
 * </p>
 *
 * @author macro
 * @since 2022-12-27
 */
@Service
public class SmsHomeSubjectServiceImpl extends ServiceImpl<SmsHomeSubjectMapper, SmsHomeSubject> implements SmsHomeSubjectService {

}
