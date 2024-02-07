package youtube2;

import java.util.Date;
import java.util.Scanner;

public class Comentario {
	private String texto;
	private String usuario;
	private Date fecha;

	public Comentario(String texto, String usuario) {
		this.texto = texto;
		this.usuario = usuario;
		this.fecha = new Date(); // Fecha actual
	}

	@Override
	public String toString() {
		return String.format("[%s] %s: %s", fecha, usuario, texto);
	}

	public static Comentario crearNuevoComentario() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Ingrese su nombre de usuario: ");
		String nombreUsuario = scanner.nextLine();

		System.out.print("Escriba su comentario: ");
		String textoComentario = scanner.nextLine();

		return new Comentario(textoComentario, nombreUsuario);
	}

	public static void main(String[] args) {
		// Ejemplo de uso en el contexto de la clase Comentario
		Comentario nuevoComentario = Comentario.crearNuevoComentario();
		System.out.println("Nuevo Comentario creado: " + nuevoComentario);
	}

}
