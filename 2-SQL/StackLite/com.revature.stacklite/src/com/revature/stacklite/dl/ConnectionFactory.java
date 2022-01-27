package com.revature.stacklite.dl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionFactory {
	// eager loading - you create instance of connection factory as soon as the
	// program starts up
	private static final ConnectionFactory connectionFactory = new ConnectionFactory();
	// hold db config stuff
	private Properties prop = new Properties();
	private final Logger logger = LogManager.getLogger(this.getClass());

	// force load postgresql driver
	// static members of class get loaded into memory at the start of program
	// runtime
	// static blocks get run at the start
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// singletons are characterized by the private constructor
	private ConnectionFactory() {
		// loading properties file that contains db config
		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			prop.load(loader.getResourceAsStream("db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("Can't find db.props file");
		}
	}

	// as well as the getInstance method
	public static ConnectionFactory getInstance() {
		// lazy loading - create instance of connection factory when you call it
		// if(connectionFactory == null) connectionFactory = new ConnectionFactory();
		return connectionFactory;
	}

	// factories are characterized by some method that contains logic for object
	// creation
	public Connection getConnection() {
		Connection conn = null;
		// trying to get connection using db creds
		try {
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"),
					prop.getProperty("password"));
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("Can't get connection");
		}
		return conn;
	}
}
