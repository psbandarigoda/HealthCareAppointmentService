package com.appointment.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.appointment.database.DBConnection;
import com.appointment.model.AppointmentModel;

public class CanceledAppointmentService {
	
	// GetAll Canceled Appointments data
	public String readDeletedAppointment() {
		String output = "";
		try {
			Connection con = DBConnection.connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}

			// displaying HTML table
			output = "<table border=\"1\"><tr><th>id</th><th>user</th><th>hospital</th><th>doctor</th><th>date</th><th>Update</th><th>Delete</th></tr>";
			String query = "select * from rm_appointment";
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

	
	// Get Canceled Appointment data by ID
	public AppointmentModel readDeletedAppointmentById(String aId) {

		AppointmentModel appointment = new AppointmentModel();

		try {
			Connection con = DBConnection.connect();

			String query = "select * from rm_appointment where id=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setInt(1, Integer.parseInt(aId));

			ResultSet rs = preparedStmt.executeQuery();

			while (rs.next()) {
				appointment.setId(Integer.parseInt(aId));
				appointment.setPatientId(rs.getString("patientId").toString());
				appointment.setHospital(rs.getString("hospital"));
				appointment.setDoctor(rs.getString("doctor"));
				java.util.Date utilDate = rs.getDate("date");
				appointment.setDate(utilDate);
			}
			con.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return appointment;
	}

		
		// Get Canceled Appointment data by Hospital
		public AppointmentModel readDeletedAppointmentByHos(String hospital) {

			AppointmentModel appointment = new AppointmentModel();

			try {
				Connection con = DBConnection.connect();

				String query = "select * from rm_appointment where hospital=?";

				PreparedStatement preparedStmt = con.prepareStatement(query);
				preparedStmt.setString(1, hospital);

				ResultSet rs = preparedStmt.executeQuery();

				while (rs.next()) {
					appointment.setId(Integer.parseInt(rs.getString("id")));
					appointment.setPatientId(rs.getString("patientId"));
					appointment.setHospital(hospital);
					appointment.setDoctor(rs.getString("doctor"));
					java.util.Date utilDate = rs.getDate("date");
					appointment.setDate(utilDate);
				}

			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			return appointment;
		}

		// Get Canceled Appointment data by Doctor
		public AppointmentModel readDeletedAppointmentByDoc(String doctor) {

			AppointmentModel appointment = new AppointmentModel();

			try {
				Connection con = DBConnection.connect();

				String query = "select * from rm_appointment where doctor=?";

				PreparedStatement preparedStmt = con.prepareStatement(query);
				preparedStmt.setString(1, doctor);

				ResultSet rs = preparedStmt.executeQuery();

				while (rs.next()) {
					appointment.setId(Integer.parseInt(rs.getString("id")));
					appointment.setPatientId(rs.getString("patientId"));
					appointment.setHospital(rs.getString("hospital"));
					appointment.setDoctor(doctor);
					java.util.Date utilDate = rs.getDate("date");
					appointment.setDate(utilDate);

				}

			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			return appointment;
		}

}
