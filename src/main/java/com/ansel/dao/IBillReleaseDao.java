package com.ansel.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ansel.bean.BillRelease;

public interface IBillReleaseDao extends JpaRepository<BillRelease, Long> {

}
