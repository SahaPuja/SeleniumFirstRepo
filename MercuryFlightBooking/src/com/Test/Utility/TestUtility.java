package com.Test.Utility;

import java.util.ArrayList;

import com.excel.Utility.Xls_Reader;

public class TestUtility {
	
	static Xls_Reader reader;
	
	public static ArrayList<Object[]> getTestDataFromExcel()
	{
        ArrayList<Object[]> myData= new  ArrayList<Object[]>();
        
        try
        {
        	reader = new Xls_Reader("C:\\Selenium\\Workspace\\Practice\\FlightBooking\\src\\com\\TestData\\SampleTestData.xlsx");
        	
        }
        
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        
        
		
		//for(int RowNum =2; RowNum<=reader.getRowCount("TestData"); RowNum++)
        for(int RowNum =2; RowNum<= 4; RowNum++)
		{
			
			String firstName= reader.getCellData("TestData",  "First_Name", RowNum);
			
			String lastName= reader.getCellData("TestData", "Last_Name", RowNum);
			
			String phone= reader.getCellData("TestData", "Phone", RowNum);
			
			String email= reader.getCellData("TestData", "Email", RowNum);
			
			String address= reader.getCellData("TestData", "Address", RowNum);
			
			String city= reader.getCellData("TestData", "City", RowNum);
			
			String state= reader.getCellData("TestData", "State", RowNum);
			
			String p_code= reader.getCellData("TestData", "Postal_Code", RowNum);
			
			String country= reader.getCellData("TestData", "Country", RowNum);
			
			String u_name= reader.getCellData("TestData", "User_Name", RowNum);
			
			String password= reader.getCellData("TestData", "Password", RowNum);
			
			String c_password= reader.getCellData("TestData", "Confirm_Password", RowNum);
			
			Object ob[]= {firstName, lastName, phone, email, address, city, state, p_code, u_name, country, password, c_password};
			
			myData.add(ob);
			
		}
		return myData;
	}
}
