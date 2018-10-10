package com.ocprojekt.app.escalade;

import com.ocprojekt.app.escalade.entities.*;
import com.ocprojekt.app.escalade.repository.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Iterator;
import java.util.List;

@SpringBootApplication
public class EscaladeApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(EscaladeApplication.class, args);

    }
}
