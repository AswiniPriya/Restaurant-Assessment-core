package com.aswini.dao;

import com.aswini.DAO.FunctionDAO;

public class TestFunctionDAO {
	public static void main(String[] args) {

		FunctionDAO functionDAO = new FunctionDAO();

		int itemId = functionDAO.getItemId("North Indian Meals");
		System.out.println("Item id is " + itemId);

}}
