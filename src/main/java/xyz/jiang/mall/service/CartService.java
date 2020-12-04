package xyz.jiang.mall.service;

import xyz.jiang.mall.model.VO.CartVO;

import java.util.List;

/**
 * 购物车Service
*/
public interface CartService {
    List<CartVO> list(Integer userId);

    public List<CartVO> add(Integer userId, Integer productId, Integer count);

    List<CartVO> update(Integer userId, Integer productId, Integer count);

    List<CartVO> delete(Integer userId, Integer productId);

    List<CartVO> selectOrNot(Integer userId, Integer productId, Integer selected);

    List<CartVO> selectAllOrNot(Integer userId, Integer selected);
}
