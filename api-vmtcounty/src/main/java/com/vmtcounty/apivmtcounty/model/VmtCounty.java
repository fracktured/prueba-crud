package com.vmtcounty.apivmtcounty.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name = "vmt_county")
public class VmtCounty {
	@Id
	private Integer id;
	
	@Column(name = "county_fips")
	private Integer countyFips;
	
	@NotBlank(message = "Debe ingresar countyName")
	@Column(name = "county_name")
	private String countyName;

	@NotBlank(message = "Debe ingresar stateName")
	@Column(name = "state_name")
	private String stateName;

	@NotNull(message = "Debe ingresar date")
	@Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
	private Date date;
	
	@Column(name = "county_vmt")
	private Integer countyVmt;
	@Column(name = "baseline_jan_vmt")
	private Integer baselineJanVmt;
	@Column(name = "percent_change_from_jan")
	private BigDecimal percentChangeFromJan;
	@Column(name = "mean7_county_vmt")
	private BigDecimal mean7CountyVmt;
	@Column(name = "mean7_percent_change_from_jan")
	private BigDecimal mean7PercentChangeFromJan;

	@NotNull(message = "Debe ingresar dateAtLow")
	@Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "date_at_low")
	private Date dateAtLow;
	
	@Column(name = "mean7_county_vmt_at_low")
	private BigDecimal mean7CountyVmtAtLow;
	@Column(name = "percent_change_from_low")
	private BigDecimal percentChangeFromLow;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCountyFips() {
		return countyFips;
	}
	public void setCountyFips(Integer countyFips) {
		this.countyFips = countyFips;
	}
	public String getCountyName() {
		return countyName;
	}
	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getCountyVmt() {
		return countyVmt;
	}
	public void setCountyVmt(Integer countyVmt) {
		this.countyVmt = countyVmt;
	}
	public Integer getBaselineJanVmt() {
		return baselineJanVmt;
	}
	public void setBaselineJanVmt(Integer baselineJanVmt) {
		this.baselineJanVmt = baselineJanVmt;
	}
	public BigDecimal getPercentChangeFromJan() {
		return percentChangeFromJan;
	}
	public void setPercentChangeFromJan(BigDecimal percentChangeFromJan) {
		this.percentChangeFromJan = percentChangeFromJan;
	}
	public BigDecimal getMean7CountyVmt() {
		return mean7CountyVmt;
	}
	public void setMean7CountyVmt(BigDecimal mean7CountyVmt) {
		this.mean7CountyVmt = mean7CountyVmt;
	}
	public BigDecimal getMean7PercentChangeFromJan() {
		return mean7PercentChangeFromJan;
	}
	public void setMean7PercentChangeFromJan(BigDecimal mean7PercentChangeFromJan) {
		this.mean7PercentChangeFromJan = mean7PercentChangeFromJan;
	}
	public Date getDateAtLow() {
		return dateAtLow;
	}
	public void setDateAtLow(Date dateAtLow) {
		this.dateAtLow = dateAtLow;
	}
	public BigDecimal getMean7CountyVmtAtLow() {
		return mean7CountyVmtAtLow;
	}
	public void setMean7CountyVmtAtLow(BigDecimal mean7CountyVmtAtLow) {
		this.mean7CountyVmtAtLow = mean7CountyVmtAtLow;
	}
	public BigDecimal getPercentChangeFromLow() {
		return percentChangeFromLow;
	}
	public void setPercentChangeFromLow(BigDecimal percentChangeFromLow) {
		this.percentChangeFromLow = percentChangeFromLow;
	}
}
