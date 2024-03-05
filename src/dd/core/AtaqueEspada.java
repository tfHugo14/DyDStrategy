package dd.core;

class AtaqueEspada implements Ataque {
    public int valorBase = 100;

    @Override
    public int getValorBase() {
        return this.valorBase;
    }

    @Override
    public void lanzarAtaque(Personaje atacante, Personaje enemigo, int valorAtaque) {
        if (enemigo.vivo == true){
            String verde = "\u001B[32m";
            String rojo = "\u001B[31m";
            String azul = "\u001B[34m";
            String violeta = "\u001B[35m";
            String reset = "\u001B[0m";

            System.out.println(" - " + verde + atacante.nombre + reset + " ataca haciendo: " + violeta + valorAtaque + reset + " de daño.");
            enemigo.salud = enemigo.salud - valorAtaque;
            if (enemigo.salud <= 0) {
                enemigo.vivo = false;
                System.out.println(" - " + verde + atacante.nombre + reset + " acabó con la vida de: "+ rojo + enemigo.nombre + reset + "!");
            } else {
                System.out.println(" - " + rojo + enemigo.nombre + reset + " ahora tiene: " + azul + enemigo.salud + reset + " de vida.");
            }
        }
    }
}
