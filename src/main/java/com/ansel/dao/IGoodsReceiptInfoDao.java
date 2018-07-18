package com.ansel.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ansel.bean.GoodsReceiptInfo;

public interface IGoodsReceiptInfoDao extends JpaRepository<GoodsReceiptInfo, Long> {

}