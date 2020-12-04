package xyz.jiang.mall.model.query;

import java.util.List;

/**
 * @Program: mall
 * @Classname ProductListQuery
 * @Description: 查询商品列表的Query
 * @Author: JiangKan
 * @Create: 2020-10-12
 **/
public class ProductListQuery {
    private String keyword;
    private List<Integer> categoryIds;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List<Integer> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(List<Integer> categoryIds) {
        this.categoryIds = categoryIds;
    }
}
