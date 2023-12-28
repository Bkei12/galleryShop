package com.example.backend.repository;

import com.example.backend.entity.Cart;
import com.example.backend.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    /**
     * 특정 회원의 장바구니에 속한 모든 상품 목록을 조회합니다.
     *
     * @param memberId 조회할 회원의 식별자
     * @return 해당 회원의 장바구니에 속한 모든 상품 목록
     */
    List<Cart> findByMemberId(int memberId);

    /**
     * 특정 회원의 장바구니에서 특정 상품을 조회합니다.
     *
     * @param memberId 조회할 회원의 식별자
     * @param itemId   조회할 상품의 식별자
     * @return 해당 회원의 장바구니에서 특정 상품, 또는 null (상품이 없을 경우)
     */
    Cart findByMemberIdAndItemId(int memberId, int itemId);

    /**
     * 특정 회원의 장바구니에서 모든 상품을 삭제합니다.
     *
     * @param memberId 삭제할 회원의 식별자
     */
    void deleteByMemberId(int memberId);
}
