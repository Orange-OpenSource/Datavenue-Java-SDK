/**
 * Copyright (C) 2015 Orange
 * 
 * This software is distributed under the terms and conditions of the 'Apache-2.0'
 * license which can be found in the file 'LICENSE' in this package distribution 
 * or at 'http://www.apache.org/licenses/LICENSE-2.0'. 
 */

package com.orange.datavenue.client.model;

/**
 * Unit with name and symbol
 * 
 * @author MELIS Mathieu
 *
 */
public class Unit {

	/** Unit name */
	private String name = null;

	/** Unit symbol */
	private String symbol = null;

	/**
	 * Get the unit name
	 * @return name the unit name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the nunit name
	 * @param name the new unit name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the unit symbol
	 * @return symbol the unit symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * Set the unit symbol
	 * @param symbol the new unit symbol
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Unit {\n");
		sb.append("  name: ").append(name).append("\n");
		sb.append("  symbol: ").append(symbol).append("\n");
		sb.append("}\n");
		return sb.toString();
	}
}
