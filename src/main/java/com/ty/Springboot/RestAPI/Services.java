package com.ty.Springboot.RestAPI;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Services {
	
	private static List<SmartPhones> l1=new ArrayList<SmartPhones>();
	
	static {
	l1.add(new SmartPhones(100, "Apple", "13pro", 150000));
	l1.add(new SmartPhones(101, "Samsung", "S23ultra", 130000));
	l1.add(new SmartPhones(102, "Redmi", "A18", 60000));
	l1.add(new SmartPhones(103, "OnePlus", "8T", 80000));
	}
	
	public List<SmartPhones> getAllPhones()
	{
		return l1;
	}
	
	
	
	public SmartPhones getPhonesByID(int id)
	{
		for (SmartPhones smartPhones : l1) 
		{
			if(smartPhones.getId()==id)
			{
				return smartPhones;
			}	
		}
		return null;
	}
	
	
	public void addPhone(SmartPhones phones)
	{
		l1.add(phones);
	}
	
	
	
	public boolean deletePhone(int id)
	{
		for (SmartPhones smartPhones : l1) 
		{
			if(smartPhones.getId()==id)
			{
				l1.remove(smartPhones);
				return true;
			}
		}
		return false;
	}
	
	public SmartPhones updatePhone(SmartPhones phones,int id)
	{
		for (SmartPhones smartPhones : l1) {
			if(smartPhones.getId()==id)
			{
				smartPhones.setBrand(phones.getBrand());
				smartPhones.setModel(phones.getModel());
				smartPhones.setPrice(phones.getPrice());
				System.out.println("Row Updated");
				return smartPhones;
			}
		}
		return null;
	}
	
	
	

}
