package com.revature.stacklite.controllers;

import io.javalin.http.Handler;

/**
 * Contain methods that when implemented would define how
 * controllers handle http requests
 * @author MarielleNolasco
 *
 */
public interface IController {
	Handler getAll();
	Handler getById();
	Handler add();
	Handler update();
}
