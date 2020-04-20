package com.appointment.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.appointment.model.AppointmentModel;
import com.appointment.service.CanceledAppointmentService;

@Path("/canceledAppointmentSRV")
public class CanceledAppointmentResource {
	
	CanceledAppointmentService canceledAppointmentSRV = new CanceledAppointmentService();
	
	// GetAll Deleted Appointments
	@GET
	@Path("/getAllCanceledAppointments")
	@Produces(MediaType.TEXT_HTML)
	public String readDeletedAppointment() {
		return canceledAppointmentSRV.readDeletedAppointment();
	}

	
	// Get Deleted Appointments By Id
	@GET
	@Path("/getCanceledAppointmentById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public AppointmentModel readDeletedAppointmentById(@PathParam("id")String id) {
		AppointmentModel appointment = canceledAppointmentSRV.readDeletedAppointmentById(id);
		return appointment;
	}
	
	
	// Get Deleted Appointment By Hospital
	@GET
	@Path("/getCanceledAppointmentByHos/{hospital}")
	@Produces(MediaType.APPLICATION_JSON)
	public AppointmentModel readDeletedAppointmentByHos(@PathParam("hospital")String hospital) {
		AppointmentModel appointment = canceledAppointmentSRV.readDeletedAppointmentByHos(hospital);
		return appointment;
	}
	
	// Get Deleted Appointment By Doctor
	@GET
	@Path("/getCanceledAppointmentByDoc/{doctor}")
	@Produces(MediaType.APPLICATION_JSON)
	public AppointmentModel readDeletedAppointmentByDoc(@PathParam("doctor")String doctor) {
		AppointmentModel appointment = canceledAppointmentSRV.readDeletedAppointmentByDoc(doctor);
		return appointment;
	}


}
