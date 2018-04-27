package com.example.quang.ipharmacy.database;

import com.example.quang.ipharmacy.model.Chemical;
import com.example.quang.ipharmacy.model.Country;
import com.example.quang.ipharmacy.model.Customer;
import com.example.quang.ipharmacy.model.Disease;
import com.example.quang.ipharmacy.model.Doctor;
import com.example.quang.ipharmacy.model.Location;
import com.example.quang.ipharmacy.model.Medicine;
import com.example.quang.ipharmacy.model.MedicineType;
import com.example.quang.ipharmacy.model.Pharmacist;
import com.example.quang.ipharmacy.model.Provider;
import com.example.quang.ipharmacy.model.Unit;

import java.util.List;

/**
 * Created by VVLv on 04/27/2018.
 */

public class Database {
    private List<Chemical> chemicals;
    private List<Country> countries;
    private List<Customer> customers;
    private List<Disease> diseases;
    private List<Doctor> doctors;
    private List<Location> locations;
    private List<Medicine> medicines;
    private List<MedicineType> medicineTypes;
    private List<Pharmacist> pharmacists;
    private List<Provider> providers;
    private List<Unit> units;

    public Database() {
    }

    public Database(List<Chemical> chemicals, List<Country> countries, List<Customer> customers, List<Disease> diseases, List<Doctor> doctors, List<Location> locations, List<Medicine> medicines, List<MedicineType> medicineTypes, List<Pharmacist> pharmacists, List<Provider> providers, List<Unit> units) {
        this.chemicals = chemicals;
        this.countries = countries;
        this.customers = customers;
        this.diseases = diseases;
        this.doctors = doctors;
        this.locations = locations;
        this.medicines = medicines;
        this.medicineTypes = medicineTypes;
        this.pharmacists = pharmacists;
        this.providers = providers;
        this.units = units;
    }

    public List<Chemical> getChemicals() {
        return chemicals;
    }

    public Database setChemicals(List<Chemical> chemicals) {
        this.chemicals = chemicals;
        return this;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public Database setCountries(List<Country> countries) {
        this.countries = countries;
        return this;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public Database setCustomers(List<Customer> customers) {
        this.customers = customers;
        return this;
    }

    public List<Disease> getDiseases() {
        return diseases;
    }

    public Database setDiseases(List<Disease> diseases) {
        this.diseases = diseases;
        return this;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public Database setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
        return this;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public Database setLocations(List<Location> locations) {
        this.locations = locations;
        return this;
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public Database setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
        return this;
    }

    public List<MedicineType> getMedicineTypes() {
        return medicineTypes;
    }

    public Database setMedicineTypes(List<MedicineType> medicineTypes) {
        this.medicineTypes = medicineTypes;
        return this;
    }

    public List<Pharmacist> getPharmacists() {
        return pharmacists;
    }

    public Database setPharmacists(List<Pharmacist> pharmacists) {
        this.pharmacists = pharmacists;
        return this;
    }

    public List<Provider> getProviders() {
        return providers;
    }

    public Database setProviders(List<Provider> providers) {
        this.providers = providers;
        return this;
    }

    public List<Unit> getUnits() {
        return units;
    }

    public Database setUnits(List<Unit> units) {
        this.units = units;
        return this;
    }
}
