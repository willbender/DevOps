package com.wb3.springbootdocker.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;

import com.wb3.springbootdocker.data.domain.schema1.Place;
import com.wb3.springbootdocker.repository.interfaces.PlacesRepository;

import lombok.Data;

@Named
@ViewScoped
@Data
public class PlacesView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1429930878144233003L;

	private List<Place> places;

	private List<Place> selectedPlaces;

	private Place selectedPlace;

	@Autowired
	private PlacesRepository placesRepository;

	@PostConstruct
	public void init() {
		this.places = placesRepository.findAll();
	}

	public void openNew() {
		this.selectedPlace = new Place();
	}

	public void savePlace() {
		if (this.selectedPlace.getId() == null) {
			placesRepository.save(this.selectedPlace);
			this.places.add(this.selectedPlace);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Place Added"));
		} else {
			Place placeToUpdate = placesRepository.findById(this.selectedPlace.getId()).orElseThrow(RuntimeException::new);
			placeToUpdate.setName(this.selectedPlace.getName());
			placeToUpdate.setVisited(this.selectedPlace.getVisited());
			placeToUpdate.setDescription(this.selectedPlace.getDescription());
			placesRepository.save(placeToUpdate);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Place Updated"));
		}
		PrimeFaces.current().executeScript("PF('managePlaceDialog').hide()");
		PrimeFaces.current().ajax().update("form:messages", "form:dt-places");
	}

	public void deletePlace() {
		placesRepository.delete(this.selectedPlace);
		this.places.remove(this.selectedPlace);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Place Removed"));
		PrimeFaces.current().ajax().update("form:messages", "form:dt-places");
	}

	public String getDeleteButtonMessage() {
		if (hasSelectedPlaces()) {
			int size = this.selectedPlaces.size();
			return size > 1 ? size + " places selected" : "1 place selected";
		}

		return "Delete";
	}

	public boolean hasSelectedPlaces() {
		return this.selectedPlaces != null && !this.selectedPlaces.isEmpty();
	}

	public void deleteSelectedPlaces() {
		this.places.removeAll(this.selectedPlaces);
		placesRepository.deleteAll(this.selectedPlaces);
		this.selectedPlaces = null;
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Places Removed"));
		PrimeFaces.current().ajax().update("form:messages", "form:dt-places");
		PrimeFaces.current().executeScript("PF('dtPlaces').clearFilters()");
	}
}