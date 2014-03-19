package com.merge.egitim.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import com.merge.egitim.entity.Kullanici;
import com.merge.egitim.service.KullaniciService;


@Named
@SessionScoped
public class KullaniciBean implements Serializable {

	private Kullanici kullanici = new Kullanici();
	private List<Kullanici> kullaniciListesi;
	@Inject
	private KullaniciService kullaniciService;
	
	public void captchaKontrol(ActionEvent event) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "DOÐRU", "DOÐRU");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		try {
			kaydet();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void kaydet() throws Exception{
		
		Boolean kayitSonuc = kullaniciService.kaydet(kullanici);
		if(kayitSonuc == false){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Eksik Alanlarý Tamamlayýnýz...", ""));
			return;
		}
		kullanici = new Kullanici();
		listeYukle();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Kayit basari ile yapildi...", ""));
	}
	
	@PostConstruct
	public void listeYukle(){
		kullaniciListesi = kullaniciService.liste();
	}
	public void sec(Kullanici kullanici){
		this.kullanici = kullanici;
	}
	public void guncelle() throws Exception{
		kullaniciService.guncelle(kullanici);
	}
	
	public void sil() throws Exception {
		Boolean silmeSonuc = kullaniciService.sil(kullanici);
		
		if(silmeSonuc == false){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Silme tamamlanmadý...", ""));
			return;
		}
		listeYukle();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Silme basari ile yapildi...", ""));
	}


	public List<Kullanici> getKullaniciListesi() {
		return kullaniciListesi;
	}

	public void setKullaniciListesi(List<Kullanici> kullaniciListesi) {
		this.kullaniciListesi = kullaniciListesi;
	}

	public KullaniciService getKullaniciService() {
		return kullaniciService;
	}

	public void setKullaniciService(KullaniciService kullaniciService) {
		this.kullaniciService = kullaniciService;
	}

	public Kullanici getKullanici() {
		return kullanici;
	}

	public void setKullanici(Kullanici kullanici) {
		this.kullanici = kullanici;
	}
	
}
