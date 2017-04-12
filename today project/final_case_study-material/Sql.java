package com.impetus.POJO;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.Statement;

import org.apache.log4j.Logger;



public class Sql 
{
	
	private static Logger logger = Logger.getLogger(Sql.class);
	public static void run(String query){

try {

Class.forName("com.mysql.jdbc.Driver");

Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/StockPortfolioDB","root","root123");

Statement stmt = conn.createStatement();

stmt.execute(query);

} catch (Exception e) {

// TODO Auto-generated catch block

logger.error(e.getMessage());

}

}

}

