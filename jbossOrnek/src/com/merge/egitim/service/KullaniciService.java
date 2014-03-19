package com.merge.egitim.service;

import java.io.Serializable;
import java.util.List;
import com.merge.egitim.entity.Kullanici;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.merge.egitim.dao.KullaniciDao;



@Stateful
public class KullaniciService implements Serializable{

	@Inject KullaniciDao kullaniciDao;
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Boolean kaydet(Kullanici kullanici) throws Exception{
		kullaniciDao.kaydet(kullanici);
		return true;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Boolean sil(Kullanici kullanici) throws Exception{
		
		kullaniciDao.sil(kullanici);
		return true;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void guncelle (Kullanici kullanici) throws Exception{
		
		kullaniciDao.guncelle(kullanici);
		
	}

	public List<Kullanici> liste() {
		return kullaniciDao.list();
	}
	
}
