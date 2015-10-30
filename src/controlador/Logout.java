package controlador;

import spark.*;

public class Logout implements TemplateViewRoute{

	@Override
	public ModelAndView handle(Request req, Response res) {
		//req.session().attribute("usuario_logado", null);
		req.session().invalidate();
		res.redirect("/index.html");
		return null;
	}

}
