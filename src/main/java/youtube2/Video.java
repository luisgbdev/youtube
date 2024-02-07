package youtube2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Video {

    private String titulo;
    private int likes;
    private Date fechaCreacion;
    private ArrayList<Comentario> comentarios;

    public Video(String titulo) {
        this.titulo = titulo;
        this.likes = 0;
        this.fechaCreacion = new Date();
        this.comentarios = new ArrayList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public int getLikes() {
        return likes;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void darLike() {
        likes++;
    }
    public void agregarComentario(Comentario comentario) {
        comentarios.add(comentario);
    }

    public void mostrarComentarios() {
        System.out.println("Comentarios del video " + titulo);
        for (Comentario comentario : comentarios) {
            System.out.println(comentario);
        }
    }

  
    public void estadisticasVideo() {
        System.out.println("Estadísticas del video " + titulo);
        System.out.println("Likes: " + likes);
        System.out.println("Fecha de creación: " + fechaCreacion);
    }

    @Override
    public String toString() {
        return String.format("Video: %s (%d likes, %s)", titulo, likes, fechaCreacion);
    }
}
