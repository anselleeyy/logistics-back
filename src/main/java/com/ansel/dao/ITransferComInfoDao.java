package com.ansel.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ansel.bean.TransferComInfo;

public interface ITransferComInfoDao extends JpaRepository<TransferComInfo, Long> {

	public TransferComInfo findByCity(String city);

}
