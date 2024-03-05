package dd.core;

import java.util.Random;

class Rey extends Personaje {
    Rey(String nombre) {
        super(nombre);
        salud = 2000;
    }

    public boolean vivo = true;

    @Override
    public void ataca(Personaje enemigo) {//ataca 3 veces
        if (vivo == true) {
            String verde = "\u001B[32m";
            String rojo = "\u001B[31m";
            String azul = "\u001B[34m";
            String reset = "\u001B[0m";

            if (enemigo.salud > 0) {
                System.out.println("[" + verde + nombre + reset + ": " + azul + salud + reset + "]" + " lucha contra " + "[" + rojo + enemigo.nombre + reset + ": " + azul + enemigo.salud + reset + "]");
            } else {
                System.out.println(azul + nombre + " " + "intenta atacar a " + rojo + enemigo.nombre + reset + azul + " pero ya está muerto." + reset);
            }
            int[] ataques = new int[3];

            if (enemigo.salud > 0) {
                for (int i = 0; i < 3; i++) {
                    Random random = new Random();
                    int acierto = random.nextInt(2);
                    double factor = random.nextDouble(2);

                    ataques[i] = (int) (acierto * this.ataque.getValorBase() * factor);
                    this.ataque.lanzarAtaque(this, enemigo, ataques[i]);
                }
            }
        }
    }
}
