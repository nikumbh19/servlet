package com.model.persistence.trainee;

//DTO
public class Trainee {
	private int id;
	private String name;
	private BranchEnum branch;
	private double percentage;
	public Trainee(int id, String name, BranchEnum branch, double percentage) {
		this.id = id;
		this.name = name;
		this.branch = branch;
		this.percentage = percentage;
	}
	public Trainee(String name, BranchEnum branch, double percentage) {
		this.name = name;
		this.branch = branch;
		this.percentage = percentage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BranchEnum getBranch() {
		return branch;
	}
	public void setBranch(BranchEnum branch) {
		this.branch = branch;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Trainee [id=").append(id).append(", name=").append(name).append(", branch=").append(branch)
				.append(", percentage=").append(percentage).append("]");
		return builder.toString();
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
