
package youtube2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Canal {

	private String nombre;
	private List<Video> videos;
	private Video videoActual;
	private Scanner scanner;

	public Canal(String nombre) {
		this.nombre = nombre;
		this.videos = new ArrayList<>();
		this.videoActual = null;
		this.scanner = new Scanner(System.in);
	}

	public void menuVideo() {
		int opcion;
		do {
			System.out.println("\nMenu Video - " + videoActual.getTitulo());
			System.out.println("0) Salir al menú del Canal");
			System.out.println("1) Crear nuevo comentario");
			System.out.println("2) Dar like al video");
			System.out.println("3) Mostrar comentarios");
			System.out.println("4) Estadísticas del video");

			System.out.print("Ingrese su opción: ");
			opcion = scanner.nextInt();

			switch (opcion) {
			case 1:
				crearNuevoComentario();
				break;
			case 2:
				darLike();
				break;
			case 3:
				mostrarComentarios();
				break;
			case 4:
				estadisticasVideo();
				break;
			case 0:
				System.out.println("Volviendo al menú del Canal...");
				break;
			default:
				System.out.println("Opción no válida. Inténtelo de nuevo.");
			}
		} while (opcion != 0);
	}

	public void crearNuevoVideo() {
		System.out.print("Ingrese el título del nuevo video: ");
		String tituloVideo = scanner.nextLine();
		Video nuevoVideo = new Video(tituloVideo);
		videos.add(nuevoVideo);
		videoActual = nuevoVideo;
		System.out.println("Video creado y seleccionado: " + nuevoVideo);
		menuVideo();
	}

	public void seleccionarVideo() {
		if (videos.isEmpty()) {
			System.out.println("No hay videos disponibles. Creando uno automáticamente...");
			crearNuevoVideo();
		} else {
			System.out.println("\nVideos disponibles:");
			for (int i = 0; i < videos.size(); i++) {
				System.out.println(i + ") " + videos.get(i));
			}

			System.out.print("Seleccione un video (ingrese el número): ");
			int seleccion = scanner.nextInt();

			if (seleccion >= 0 && seleccion < videos.size()) {
				videoActual = videos.get(seleccion);
				System.out.println("Video seleccionado: " + videoActual);
				menuVideo();
			} else {
				System.out.println("Selección no válida.");
			}
		}
	}

	public void estadisticasCanal() {
		// Implementar la visualización de estadísticas del canal
		System.out.println("Estadísticas del canal " + nombre);
	}

	public void crearNuevoComentario() {
		Comentario nuevoComentario = Comentario.crearNuevoComentario();
		videoActual.agregarComentario(nuevoComentario);
		System.out.println("Comentario creado y añadido al video.");

	}

	public void darLike() {
		// Implementar la asignación de un like al video actual
		System.out.println("Dando like al video " + videoActual.getTitulo());
	}

	public void mostrarComentarios() {
		// Implementar la visualización de comentarios del video actual
		System.out.println("Mostrando comentarios del video " + videoActual.getTitulo());
	}

	public void estadisticasVideo() {
		// Implementar la visualización de estadísticas del video actual
		System.out.println("Estadísticas del video " + videoActual.getTitulo());
	}

	@Override
	public String toString() {
		return "Canal{" + "nombre='" + nombre + '\'' + ", videos=" + videos + ", videoActual=" + videoActual + '}';
	}

	public String getVideoActual() {
		// TODO Auto-generated method stub
		return null;
	}

	public Date getFechaCreacion() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}
}