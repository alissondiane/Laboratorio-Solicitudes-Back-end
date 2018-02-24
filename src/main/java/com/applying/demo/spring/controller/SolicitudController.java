package com.applying.demo.spring.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.applying.demo.spring.bean.SolicitudBean;
import com.applying.demo.spring.service.SolicitudService;

@Controller
public class SolicitudController {

	@Autowired
	private SolicitudService solicitudService;

	@GetMapping("/vistaSolicitudes")
	public String userForm(Locale locale, Model model) {
		model.addAttribute("solicitudes", solicitudService.obtenerSolicitudes(null));
		return "vistaSolicitudes";
	}
	
	@GetMapping("/vistaSolicitud")
	public String vistaSolicitudID(@RequestParam(value="id" ,required=false) Long solicitudId,Model model,Locale locale) {
		SolicitudBean objSolicitudBean = new SolicitudBean();
		if(solicitudId!=null) {
			objSolicitudBean = solicitudService.obtenerSolicitud(solicitudId);
		}
		model.addAttribute("solicitud", objSolicitudBean);
		return "vistaSolicitud";
	}
	
	@GetMapping("/eliminarSolicitud/{id}")
	public String eliminarSolicitud(@PathVariable("id") Long solicitudId,Model model,Locale locale) {
		solicitudService.eliminarSolicitud(solicitudId);
		return "redirect:/vistaSolicitudes";
	}


	@PostMapping("/agregarSolicitud")
	public String agregarSolicitud(@ModelAttribute("solicitud") SolicitudBean objSolicitudBean, Model model) {
		solicitudService.agregarSolicitud(objSolicitudBean);
		return "redirect:/vistaSolicitudes";
	}
	
	@PostMapping("/modificarSolicitud")
	public String modificarSolicitud(@ModelAttribute("solicitud") SolicitudBean objSolicitudBean, Model model) {
		solicitudService.modificarSolicitud(objSolicitudBean);
		return "redirect:/vistaSolicitudes";
	}
	

}
