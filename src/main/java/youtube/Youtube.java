package youtube;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import youtube2.Canal;

public class Youtube {

	private ArrayList<Canal> canales;
	private Canal canalActual;
	private Scanner scanner;

	public Youtube() {
		this.canales = new ArrayList<>();
		this.scanner = new Scanner(System.in);
	}

	public void mostrarMenuPrincipal() {
		int opcion;
		do {
			System.out.println("________________________________________");
			System.out.println("|--- YOUTUBE---|");
			System.out.println("\nMenu Principal:");
			System.out.println("0) Salir");
			System.out.println("1) Nuevo canal");
			System.out.println("2) Seleccionar canal");
			System.out.println("3) Mostrar estadísticas");
			System.out.println("4) Mostrar estadísticas completas");
			System.out.println("|--------------------------------------|");

			System.out.print("Ingrese su opción: ");
			opcion = scanner.nextInt();

			switch (opcion) {
			case 1:
				crearNuevoCanal();
				break;
			case 2:
				seleccionarCanal();
				break;
			case 3:
				mostrarEstadisticas();
				break;
			case 4:
				mostrarEstadisticasCompletas();
				break;
			case 0:
				System.out.println("¡Gracias por usar Youtube!");
				break;
			default:
				System.out.println("Opción no válida. Inténtelo de nuevo.");
			}
		} while (opcion != 0);
	}

	private void crearNuevoCanal() {
		System.out.print("Ingrese el nombre del nuevo canal: ");
		String nombreCanal = scanner.next();
		Canal nuevoCanal = new Canal(nombreCanal);
		canales.add(nuevoCanal);
		Date fechaActual = new Date();
		System.out.println(nombreCanal + "." + " Creado el " + fechaActual);
		canalActual = nuevoCanal;
		menuCanal();
	}

	private void seleccionarCanal() {
		if (canales.isEmpty()) {
			System.out.println("No hay canales disponibles. Creando uno automáticamente...");
			crearNuevoCanal();
		} else {
			System.out.println("\nCanales disponibles:");
			for (int i = 0; i < canales.size(); i++) {
				System.out.println(i + ") " + canales.get(i));
			}

			System.out.print("Seleccione un canal (ingrese el número): ");
			int seleccion = scanner.nextInt();

			if (seleccion >= 0 && seleccion < canales.size()) {
				canalActual = canales.get(seleccion);
				System.out.println("Canal seleccionado: " + canalActual);
				menuCanal();
			} else {
				System.out.println("Selección no válida.");
			}
		}
	}

	private void mostrarEstadisticas() {
		if (canalActual != null) {
			System.out.println("\nEstadísticas del canal:");
			System.out.println(canalActual);
			// Agregar más estadísticas si es necesario
		} else {
			System.out.println("No hay canal seleccionado.");
		}
	}

	private void mostrarEstadisticasCompletas() {
		System.out.println("\nEstadísticas completas de Youtube:");

		for (Canal canal : canales) {
			System.out.println(canal);
			// Agregar más estadísticas específicas del canal si es necesario
		}
	}

	private void menuCanal() {
		int opcion;
		do {
			System.out.println("\nMenu Canal - " + canalActual);
			System.out.println("0) Salir al menú principal");
			System.out.println("1) Nuevo video");
			System.out.println("2) Seleccionar video");
			System.out.println("3) Mostrar estadísticas");
			System.out.println("4) Mostrar info videos");

			System.out.print("Ingrese su opción: ");
			opcion = scanner.nextInt();

			switch (opcion) {
			case 1:
				// Implementar la creación de un nuevo video
				canalActual.crearNuevoVideo();
				break;
			case 2:
				// Implementar la selección de un video
				canalActual.seleccionarVideo();
				break;
			case 3:
				// Implementar la visualización de estadísticas del canal
				canalActual.estadisticasCanal();
				break;
			case 4:
				// Implementar la visualización de estadísticas de los videos
				break;
			case 0:
				System.out.println("Volviendo al menú principal...");
				break;
			default:
				System.out.println("Opción no válida. Inténtelo de nuevo.");
			}
		} while (opcion != 0);
	}

	public static void main(String[] args) {
		Youtube youtube = new Youtube();
		youtube.mostrarMenuPrincipal();
	}

	private void menuVideo() {
		int opcion;
		do {
			System.out.println("\nMenu Video - " + canalActual.getVideoActual());
			System.out.println("0) Salir al menú principal");
			System.out.println("1) Nuevo comentario");
			System.out.println("2) Like");
			System.out.println("3) Mostrar comentarios");
			System.out.println("4) Mostrar estadísticas");

			System.out.print("Ingrese su opción: ");
			opcion = scanner.nextInt();

			switch (opcion) {
			case 1:
				// Implementar la creación de un nuevo comentario
				canalActual.crearNuevoComentario();
				break;
			case 2:
				// Implementar la selección de un like
				canalActual.darLike();
				break;
			case 3:
				// Implementar la visualización de comentarios del video
				canalActual.mostrarComentarios();
				break;
			case 4:
				// Implementar la visualización de estadísticas de los videos
				canalActual.estadisticasVideo();
				break;
			case 0:
				System.out.println("Volviendo al menú principal...");
				break;
			default:
				System.out.println("Opción no válida. Inténtelo de nuevo.");
			}
		} while (opcion != 0);
	}
}

