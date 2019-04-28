package com.app.csvdatatodb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "csv")
public class CsvDomain {

	private Long id;
	private String policyId;
	private String stateCode;
	private String county;
	private String eqSiteLimit;
	private String huSiteLimit;
	private String flSiteLimit;
	private String frSiteLimit;
	private String tiv2011;
	private String tiv2012;
	private String eqSiteDeductible;
	private String huSiteDeductible;
	private String flSiteDeductible;
	private String frSiteDeductible;
	private String pointLatitude;
	private String pointLongitude;
	private String line;
	private String construction;
	private String pointGranularity;
	
	public CsvDomain() {
		super();
	}

	public CsvDomain(Long id, String policyId, String stateCode, String county, String eqSiteLimit, String huSiteLimit,
			String flSiteLimit, String frSiteLimit, String tiv2011, String tiv2012, String eqSiteDeductible,
			String huSiteDeductible, String flSiteDeductible, String frSiteDeductible, String pointLatitude,
			String pointLongitude, String line, String construction, String pointGranularity) {
		super();
		this.id = id;
		this.policyId = policyId;
		this.stateCode = stateCode;
		this.county = county;
		this.eqSiteLimit = eqSiteLimit;
		this.huSiteLimit = huSiteLimit;
		this.flSiteLimit = flSiteLimit;
		this.frSiteLimit = frSiteLimit;
		this.tiv2011 = tiv2011;
		this.tiv2012 = tiv2012;
		this.eqSiteDeductible = eqSiteDeductible;
		this.huSiteDeductible = huSiteDeductible;
		this.flSiteDeductible = flSiteDeductible;
		this.frSiteDeductible = frSiteDeductible;
		this.pointLatitude = pointLatitude;
		this.pointLongitude = pointLongitude;
		this.line = line;
		this.construction = construction;
		this.pointGranularity = pointGranularity;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "policy_id")
	public String getPolicyId() {
		return policyId;
	}

	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}

	@Column(name = "state_code")
	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	@Column(name = "county")
	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	@Column(name = "eq_site_limit")
	public String getEqSiteLimit() {
		return eqSiteLimit;
	}

	public void setEqSiteLimit(String eqSiteLimit) {
		this.eqSiteLimit = eqSiteLimit;
	}

	@Column(name = "hu_site_limit")
	public String getHuSiteLimit() {
		return huSiteLimit;
	}

	public void setHuSiteLimit(String huSiteLimit) {
		this.huSiteLimit = huSiteLimit;
	}

	@Column(name = "fl_site_limit")
	public String getFlSiteLimit() {
		return flSiteLimit;
	}

	public void setFlSiteLimit(String flSiteLimit) {
		this.flSiteLimit = flSiteLimit;
	}

	@Column(name = "fr_site_limit")
	public String getFrSiteLimit() {
		return frSiteLimit;
	}

	public void setFrSiteLimit(String frSiteLimit) {
		this.frSiteLimit = frSiteLimit;
	}

	@Column(name = "tiv_2011")
	public String getTiv2011() {
		return tiv2011;
	}

	public void setTiv2011(String tiv2011) {
		this.tiv2011 = tiv2011;
	}

	@Column(name = "tiv_2012")
	public String getTiv2012() {
		return tiv2012;
	}

	public void setTiv2012(String tiv2012) {
		this.tiv2012 = tiv2012;
	}

	@Column(name = "eq_site_deductible")
	public String getEqSiteDeductible() {
		return eqSiteDeductible;
	}

	public void setEqSiteDeductible(String eqSiteDeductible) {
		this.eqSiteDeductible = eqSiteDeductible;
	}

	@Column(name = "hu_site_deductible")
	public String getHuSiteDeductible() {
		return huSiteDeductible;
	}

	public void setHuSiteDeductible(String huSiteDeductible) {
		this.huSiteDeductible = huSiteDeductible;
	}

	@Column(name = "fl_site_deductible")
	public String getFlSiteDeductible() {
		return flSiteDeductible;
	}

	public void setFlSiteDeductible(String flSiteDeductible) {
		this.flSiteDeductible = flSiteDeductible;
	}

	@Column(name = "fr_site_deductible")
	public String getFrSiteDeductible() {
		return frSiteDeductible;
	}

	public void setFrSiteDeductible(String frSiteDeductible) {
		this.frSiteDeductible = frSiteDeductible;
	}

	@Column(name = "point_latitude")
	public String getPointLatitude() {
		return pointLatitude;
	}

	public void setPointLatitude(String pointLatitude) {
		this.pointLatitude = pointLatitude;
	}

	@Column(name = "point_longitude")
	public String getPointLongitude() {
		return pointLongitude;
	}

	public void setPointLongitude(String pointLongitude) {
		this.pointLongitude = pointLongitude;
	}

	@Column(name = "line")
	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	@Column(name = "construction")
	public String getConstruction() {
		return construction;
	}

	public void setConstruction(String construction) {
		this.construction = construction;
	}

	@Column(name = "point_granularity")
	public String getPointGranularity() {
		return pointGranularity;
	}

	public void setPointGranularity(String pointGranularity) {
		this.pointGranularity = pointGranularity;
	}
}
