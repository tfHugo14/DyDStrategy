package dd.core;

abstract class Personaje {
    public String nombre;
    public Ataque ataque;
    public int salud;
    public boolean vivo;

    Personaje(String nombre) {
        this.nombre = nombre;
    }

    public void setAtaque(Ataque ataque) {
        this.ataque = ataque;
    }

    public abstract void ataca(Personaje enemigo);
}
