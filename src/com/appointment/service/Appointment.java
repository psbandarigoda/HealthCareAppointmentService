package com.appointment.service;

import java.sql.*;

import javax.ws.rs.QueryParam;

import com.appointment.database.DBConnection;

public class Appointment {
	

	// Insert method which insert data to Appointment table
	public String insertAppointment(String patientId, String hospital, String doctor, String date) {
		String output = "";
		try {
			Connection con = DBConnection.connect();
			if (con == null) {
				return "Error while connecting to the database";
			}

			String query = " insert into appointment(`id`,`patientId`,`hospital`,`doctor`,`date`)" + " values (?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, patientId);
			preparedStmt.setString(3, hospital);
			preparedStmt.setString(4, doctor);
			preparedStmt.setString(5, date);

			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";
		} catch (Exception e) {
			output = "Error while inserting";
			System.err.println(e.getMessage());
		}
		return output;
	}

	// GetAll inserted Appointments data
	public String readAppointment() {
		String output = "";
		try {
			Connection con = DBConnection.connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}

			// displaying HTML table
			output = "<table border=\"1\"><tr><th>id</th><th>user</th><th>hospital</th><th>doctor</th><th>date</th><th>Update</th><th>Delete</th></tr>";
			String query = "select * from appointment";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			// iterate through the rows in the result set
			while (rs.next()) {
				String id = Integer.toString(rs.getInt("id"));
				String user = rs.getString("patientId");
				String hospital = rs.getString("hospital");
				String doctor = rs.getString("doctor");
				String date = rs.getString("date");

				// Add into the HTML table
				output += "<tr><td>" + id + "</td>";
				output += "<td>" + user + "</td>";
				output += "<td>" + hospital + "</td>";
				output += "<td>" + doctor + "</td>";
				output += "<td>" + date + "</td>";

				// buttons
				output += "<td><input name=\"btnUpdate\" type=\"button\" value=\"Update\" class=\"btn btn-secondary\"></td>"
						+ "<td><form method=\"post\" action=\"items.jsp\">"
						+ "<input name=\"btnRemove\" type=\"submit\" value=\"Delete\"class=\"btn btn-danger\">"
						+ "<input name=\"itemID\" type=\"hidden\" value=\"" + id + "\">" + "</form></td></tr>";
			}
			con.close();
			// Complete the HTML table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the items.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	// Update Appointment table
	public String updateAppointment(String id, String userId, String hosId, String docId, String date) {
		String output = "";
		try {
			Connection con = DBConnection.connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}

			String query = "UPDATE appointment SET patientId=?,hospital=?,doctor=?,date=? WHERE id=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			preparedStmt.setString(1, userId);
			preparedStmt.setString(2, hosId);
			preparedStmt.setString(3, docId);
			preparedStmt.setString(4, date);
			preparedStmt.setInt(5, Integer.parseInt(id));

			preparedStmt.execute();
			con.close();
			output = "Updated successfully";
		} catch (Exception e) {
			output = "Error while updating the item.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	// Delete Appointment table
	public String deleteAppointment(String id) {
		String output = "";
		try {
			Connection con = DBConnection.connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement
			String query = "delete from appointment where id=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(id));
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Deleted successfully";
		} catch (Exception e) {
			e.printStackTrace();
			output = "Error while deleting the item.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	
	// Get Appointment data by ID
	public String getAppointmentById(@QueryParam("id") String aId) {
		String output = "";
		try {
			Connection con = DBConnection.connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
						 

			// displaying HTML table
			output = "<table border=\"1\"><tr><th>id</th><th>user</th><th>hospital</th><th>doctor</th><th>date</th><th>Update</th><th>Delete</th></tr>";
			String query = "select * from appointment where id=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(aId));
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			// iterate through the rows in the result set
			while (rs.next()) {
				String id = Integer.toString(rs.getInt("id"));
				String user = rs.getString("patientId");
				String hospital = rs.getString("hospital");
				String doctor = rs.getString("doctor");
				String date = rs.getString("date");

				// Add into the HTML table
				output += "<tr><td>" + id + "</td>";
				output += "<td>" + user + "</td>";
				output += "<td>" + hospital + "</td>";
				output += "<td>" + doctor + "</td>";
				output += "<td>" + date + "</td>";

				// buttons
				output += "<td><input name=\"btnUpdate\" type=\"button\" value=\"Update\" class=\"btn btn-secondary\"></td>"
						+ "<td><form method=\"post\" action=\"items.jsp\">"
						+ "<input name=\"btnRemove\" type=\"submit\" value=\"Delete\"class=\"btn btn-danger\">"
						+ "<input name=\"itemID\" type=\"hidden\" value=\"" + id + "\">" + "</form></td></tr>";
			}
			con.close();
			// Complete the HTML table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the items.";
			System.err.println(e.getMessage());
		}
		return output;
	}
}
