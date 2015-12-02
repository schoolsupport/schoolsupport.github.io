package controlador;

import java.io.File;

import modelo.Usuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class ZerarDesempenho implements TemplateViewRoute{

	@Override
	public ModelAndView handle(Request req, Response res) {
		Usuario user = req.session().attribute("usuario_logado");
		File dir = new File("banco/desempenhos/" + user.getMatricula()+"/acertos");
		if (dir.exists()){
			removerArquivos(dir);
		}
		File dir2 = new File("banco/desempenhos/" + user.getMatricula()+"/erros");
		if (dir2.exists()){
			removerArquivos(dir2);
		}
		res.redirect("/desempenho");
		return new ModelAndView("", "");
	}
	public void removerArquivos(File f) {
        // Se o arquivo passado for um diretório
        if (f.isDirectory()) {
                /* Lista todos os arquivos do diretório em um array
                   de objetos File */
                File[] files = f.listFiles();
                // Identa a lista (foreach) e deleta um por um
                for (File file : files) {
                        file.delete();
                }  
        }
	}
}
