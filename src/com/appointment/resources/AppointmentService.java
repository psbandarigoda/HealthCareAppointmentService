package com.appointment.resources;

//For REST Service
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.appointment.service.Appointment;
//For JSON
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Path("/appointmentSRV")
public class AppointmentService {

	Appointment appointment = new Appointment();

	@GET
	@Path("/Test")
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		return "Hello world.";
	}

	// GetAll Appointments
	@GET
	@Path("/getAllAppointments")
	@Produces(MediaType.TEXT_HTML)
	public String readAppointment() {
		return appointment.readAppointment();
	}

	// Add Appointment
	@POST
	@Path("/addAppointment")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertItem(@FormParam("patientId") String patientId, @FormParam("hospital") String hospital,
			@FormParam("doctor") String doctor, @FormParam("date") String date) {
		String output = appointment.insertAppointment(patientId, hospital, doctor, date);
		return output;
	}

	// Update Appointment
	@PUT
	@Path("/updateAppointment")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateItem(String appointmentData) {
		JsonObject appointmentObject = new JsonParser().parse(appointmentData).getAsJsonObject();
		String id = appointmentObject.get("id").getAsString();
		String userId = appointmentObject.get("userId").getAsString();
		String hosId = appointmentObject.get("hosId").getAsString();
		String docId = appointmentObject.get("docId").getAsString();
		String date = appointmentObject.get("date").getAsString();
		String output = appointment.updateAppointment(id, userId, hosId, docId, date);
		return output;
	}

	// delete Appointment
	@DELETE
	@Path("/removeAppointment/{id}")
	public String deleteAppointment(@PathParam("id") String id) {
		String output = appointment.deleteAppointment(id);
		return output;
	}

	// Get Appointment By Id
	@GET
	@Path("/getAppointmentById/{id}")
	@Produces(MediaType.TEXT_HTML)
	public String getAppointmentById(@PathParam("id")String aId) {
		String output = appointment.getAppointmentById(aId);
		return output;
	}

}
