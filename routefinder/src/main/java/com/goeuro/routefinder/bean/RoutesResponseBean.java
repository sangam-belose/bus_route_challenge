package com.goeuro.routefinder.bean;

import javax.validation.constraints.NotNull;

public class RoutesResponseBean {

	@NotNull
	private int dep_sid;
	@NotNull
	private int arr_sid;

	private boolean direct_bus_route;

	public RoutesResponseBean() {
		super();
	}

	public RoutesResponseBean(int dep_sid, int arr_sid, boolean direct_bus_route) {
		super();
		this.dep_sid = dep_sid;
		this.arr_sid = arr_sid;
		this.direct_bus_route = direct_bus_route;
	}

	public int getDep_sid() {
		return dep_sid;
	}

	public void setDep_sid(int dep_sid) {
		this.dep_sid = dep_sid;
	}

	public int getArr_sid() {
		return arr_sid;
	}

	public void setArr_sid(int arr_sid) {
		this.arr_sid = arr_sid;
	}

	public boolean isDirect_bus_route() {
		return direct_bus_route;
	}

	public void setDirect_bus_route(boolean direct_bus_route) {
		this.direct_bus_route = direct_bus_route;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RoutesResponseBean [dep_sid=").append(dep_sid).append(", arr_sid=").append(arr_sid)
				.append(", direct_bus_route=").append(direct_bus_route).append("]");
		return builder.toString();
	}

}
