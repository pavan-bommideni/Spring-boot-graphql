package com.example.demo.model;


import java.util.List;


public class Technology {
                      
    public String id;

    public String technologyName;
    public List<String> skillset;
    private Integer userId;
    
    public Technology() {}

	public Technology(String id, String technologyName, List<String> skillset) {
		super();
		this.id = id;
		this.technologyName = technologyName;
		this.skillset = skillset;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTechnologyName() {
		return technologyName;
	}

	public void setTechnologyName(String technologyName) {
		this.technologyName = technologyName;
	}

	public List<String> getSkillset() {
		return skillset;
	}

	public void setSkillset(List<String> skillset) {
		this.skillset = skillset;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
}