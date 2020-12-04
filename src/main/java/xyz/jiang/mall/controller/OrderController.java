package xyz.jiang.mall.controller;

import com.github.pagehelper.PageInfo;
import com.google.zxing.WriterException;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.jiang.mall.common.ApiRestResponse;
import xyz.jiang.mall.model.VO.OrderVO;
import xyz.jiang.mall.model.pojo.Order;
import xyz.jiang.mall.model.request.CreateOrderReq;
import xyz.jiang.mall.service.OrderService;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @Program: mall
 * @Classname OrderController
 * @Description: 订单controller
 * @Author: JiangKan
 * @Create: 2020-10-15
 **/

@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @ApiOperation("创建订单")
    @PostMapping("order/create")
    public ApiRestResponse create(@RequestBody CreateOrderReq createOrderReq) {
        String orderNo = orderService.create(createOrderReq);
        return ApiRestResponse.success(orderNo);
    }

    @ApiOperation("前台订单详情")
    @GetMapping("/order/detail")
    public ApiRestResponse detail(@RequestParam String orderNo){
        OrderVO orderVO = orderService.detail(orderNo);
        return ApiRestResponse.success(orderVO);
    }

    @ApiOperation("前台订单列表")
    @GetMapping("/order/list")
    public ApiRestResponse list(@RequestParam Integer pageNum,@RequestParam Integer pageSize){
        PageInfo pageInfo = orderService.listForCustomer(pageNum,pageSize);
        return ApiRestResponse.success(pageInfo);
    }

    @ApiOperation("取消订单列表")
    @PostMapping("/order/cancle")
    public ApiRestResponse cancle(@RequestParam String orderNo){
        orderService.cancle(orderNo);
        return ApiRestResponse.success();
    }

    @ApiOperation("生成二维码")
    @GetMapping("/order/qrcode")
    public ApiRestResponse qrcode(@RequestParam String orderNo) throws IOException, WriterException {
        String pngAddress = orderService.qrcode(orderNo);
        return ApiRestResponse.success(pngAddress);
    }

    @ApiOperation("支付")
    @PostMapping("/order/pay")
    public ApiRestResponse pay(@RequestParam String orderNo){
        orderService.pay(orderNo);
        return ApiRestResponse.success();
    }




}



