/* Class: Item
 * Author: Lane McSpadden
 * Company: Revature
 * Purpose: This class will handle item attributes in the store
 * Interactions: Employees will be able to add items to the store
 * 
 * 
 * 
 * 
 */
package com.revature.shopitems;

public class Item {
	private String sku;
	private String itemName;
	private String itemDesc;
	private float price;
	private float costLeft;
	private float[] bids;
	private ItemState itemState;
	
	
	public Item(String itemName, String itemDesc, float price, ItemState itemState) {
		super();
		this.itemName = itemName;
		this.itemDesc = itemDesc;
		this.price = price;
		this.costLeft = 0.0f;
		this.itemState = itemState;
	}
	@Override
	public String toString() {

		return 
				 itemName + "\t\t" + itemDesc + "\t\t" + price;
	}
	public ItemState getItemState() {
		return itemState;
	}
	public void setItemState(ItemState itemState) {
		this.itemState = itemState;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

	
}
