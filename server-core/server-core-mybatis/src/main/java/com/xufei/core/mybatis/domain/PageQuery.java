package com.xufei.core.mybatis.domain;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Data
public class PageQuery implements Serializable {

    private Integer pageSize;

    private Integer pageNum;

    private String orderByColumn;

    private String isAsc;

    public static final int DEFAULT_PAGE_NUM = 1;

    public static final int DEFAULT_PAGE_SIZE = Integer.MAX_VALUE;

    public <T> Page<T> build() {
        Integer pageNum = ObjectUtil.defaultIfNull(getPageNum(), DEFAULT_PAGE_NUM);
        Integer pageSize = ObjectUtil.defaultIfNull(getPageSize(), DEFAULT_PAGE_SIZE);
        if (pageNum <= 0) {
            pageNum = DEFAULT_PAGE_NUM;
        }
        Page<T> page = new Page<>(pageNum, pageSize);

//        List<OrderItem> orderItems = buildOrderItem();
//        if (CollUtil.isNotEmpty(orderItems)) {
//            page.addOrder(orderItems);
//        }
        return page;
    }

//    private List<OrderItem> buildOrderItem() {
//        if (StringUtils.isBlank(orderByColumn) || StringUtils.isBlank(isAsc)) {
//            return null;
//        }
//        String orderBy = SqlUtil.escapeOrderBySql(orderByColumn);
//        orderBy = StringUtils.toUnderScoreCase(orderBy);
//
//        // 兼容前端排序类型
//        isAsc = StringUtils.replaceEach(isAsc, new String[]{"ascending", "descending"}, new String[]{"asc", "desc"});
//
//        String[] orderByArr = orderBy.split(StringUtils.SEPARATOR);
//        String[] isAscArr = isAsc.split(StringUtils.SEPARATOR);
//        if (isAscArr.length != 1 && isAscArr.length != orderByArr.length) {
//            throw new ServiceException("排序参数有误");
//        }
//
//        List<OrderItem> list = new ArrayList<>();
//        // 每个字段各自排序
//        for (int i = 0; i < orderByArr.length; i++) {
//            String orderByStr = orderByArr[i];
//            String isAscStr = isAscArr.length == 1 ? isAscArr[0] : isAscArr[i];
//            if ("asc".equals(isAscStr)) {
//                list.add(OrderItem.asc(orderByStr));
//            } else if ("desc".equals(isAscStr)) {
//                list.add(OrderItem.desc(orderByStr));
//            } else {
//                throw new ServiceException("排序参数有误");
//            }
//        }
//        return list;
//    }
}
