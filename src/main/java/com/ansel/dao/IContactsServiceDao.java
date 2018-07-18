package com.ansel.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ansel.bean.ContactsService;

public interface IContactsServiceDao  extends JpaRepository<ContactsService, Long> {

	public ContactsService findByGoodsBillCode(String goodsBillCode);

}
