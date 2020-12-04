package xyz.jiang.mall.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.jiang.mall.common.ApiRestResponse;
import xyz.jiang.mall.model.pojo.Product;
import xyz.jiang.mall.model.request.ProductListReq;
import xyz.jiang.mall.service.ProductService;

import javax.annotation.Resource;

/**
 * @Program: mall
 * @Classname ProductController
 * @Description: 前台商品Controller
 * @Author: JiangKan
 * @Create: 2020-10-12
 **/
@RestController
public class ProductController {

    @Resource
    ProductService productService;

    @ApiOperation("商品详情")
    @GetMapping("/product/detail")
    public ApiRestResponse detail(@RequestParam Integer id) {
       Product product =  productService.detail(id);
        return ApiRestResponse.success(product);
    }

    @ApiOperation("商品详情")
    @GetMapping("/product/list")
    public ApiRestResponse list( ProductListReq productListReq) {
        PageInfo info = productService.list(productListReq);
        return ApiRestResponse.success(info);

    }


}
