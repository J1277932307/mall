package xyz.jiang.mall.service;

import com.github.pagehelper.PageInfo;
import xyz.jiang.mall.model.pojo.Product;
import xyz.jiang.mall.model.request.AddProductReq;
import xyz.jiang.mall.model.request.ProductListReq;

/**
 * @Program: mall
 * @Classname ProductService
 * @Description: 商品服务
 * @Author: JiangKan
 * @Create: 2020-10-11
 **/
public interface ProductService {
    public void add(AddProductReq addProductReq);

    void update(Product updateProduct);

    void delete(Integer id);

    void batchUpdateSellStatus(Integer[] ids, Integer sellStatus);

    PageInfo listForAdmin(Integer pageNum, Integer pageSize);

    Product detail(Integer id);

    PageInfo list(ProductListReq productListReq);
}
