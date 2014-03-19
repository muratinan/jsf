package com.merge.egitim.dao;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.merge.egitim.entity.Kullanici;


@Stateful
public class KullaniciDao {
	@PersistenceContext
	EntityManager entityManager;

	public void kaydet(Kullanici kullanici){
		entityManager.persist(kullanici);
	}
	public void sil(Kullanici kullanici){
		entityManager.remove(kullanici);
	}
	public void guncelle(Kullanici kullanici){
		entityManager.merge(kullanici);
	}
		
	public List<Kullanici> list() {
		return entityManager.createQuery("from Kullanici").getResultList();
	}
}
