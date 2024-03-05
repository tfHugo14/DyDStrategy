package dd.core;

public interface Ataque{
    int getValorBase();
    void lanzarAtaque(Personaje atacante, Personaje enemigo, int valorAtaque);
}

