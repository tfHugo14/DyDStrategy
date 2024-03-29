package dd.core;

import java.util.Random;

public class ControlBasico {
    Random r = new Random();
    public Personaje[] ejercitoHumanos;
    public Personaje[] ejercitoTrolls;

    public ControlBasico(int Humanos, int Trolls){
        crearEjercito(Humanos, Trolls);
        combate(ejercitoHumanos,ejercitoTrolls);
    }

    void crearEjercito(int Humanos, int Trolls) {
        Random r = new Random();
        int cantidadHumanos = Humanos;
        int cantidadTrolls = Trolls;
        Personaje[] ejercitoHumanos = new Personaje[cantidadHumanos];
        Personaje[] ejercitoTrolls = new Personaje[cantidadTrolls];

        // Crear ejercito de humanos
        for (int i = 0; i < cantidadHumanos; i++) {
            int tipoPersonaje = r.nextInt(2);
            switch (tipoPersonaje) {
                case 0: ejercitoHumanos[i] = new Rey("Rey " + i); break;
                case 1: ejercitoHumanos[i] = new Caballero("Caballero " + i); break;
            }
        }
        // Crear ejercito de trolls
        for (int i = 0; i < cantidadTrolls; i++) {
            ejercitoTrolls[i] = new Troll("Troll " + i);
        }

        this.ejercitoHumanos = ejercitoHumanos;
        this.ejercitoTrolls = ejercitoTrolls;
    }

    void combate(Personaje[] ejercitoHumanos, Personaje[] ejercitoTrolls){
        boolean trollsVivos = true;
        boolean humanosVivos = true;
        int turnoHumanos = 0;
        int turnoTrolls = 0;
        setAtaquesEjercitos(ejercitoHumanos,ejercitoTrolls);

        while (trollsVivos & humanosVivos){
            int humanoRandom = r.nextInt(ejercitoHumanos.length);
            int trollRandom = r.nextInt(ejercitoTrolls.length);

            if (ejercitoHumanos[turnoHumanos].salud > 0)
                ejercitoHumanos[turnoHumanos].ataca(ejercitoTrolls[trollRandom]);

            if (ejercitoTrolls[turnoTrolls].salud > 0)
                ejercitoTrolls[turnoTrolls].ataca(ejercitoHumanos[humanoRandom]);

            // control de los turnos
            if (turnoHumanos+1 == ejercitoHumanos.length){
                turnoHumanos = 0;
            }else {
                turnoHumanos++;
            }
            if (turnoTrolls+1 == ejercitoTrolls.length){
                turnoTrolls = 0;
            }else {
                turnoTrolls++;
            }

            //
            if (ejercitosVivos(ejercitoHumanos,ejercitoTrolls).equalsIgnoreCase("Humanos Muertos")){
                System.out.println("El Ejercito Humano a perdido!");
                for (int i=0; i<ejercitoHumanos.length; i++){
                    System.out.println(ejercitoHumanos[i].nombre + " tiene " + ejercitoHumanos[i].salud + " de vida.");
                }
                for (int i=0; i<ejercitoTrolls.length; i++){
                    System.out.println(ejercitoTrolls[i].nombre + " tiene " + ejercitoTrolls[i].salud + " de vida.");
                }
                break;
            }else if ( ejercitosVivos(ejercitoHumanos,ejercitoTrolls).equalsIgnoreCase("Trolls Muertos") ){
                System.out.println("El Ejercito Troll a perdido!");
                for (int i=0; i<ejercitoHumanos.length; i++){
                    if (ejercitoHumanos[i].salud <= 0)
                        System.out.println(ejercitoHumanos[i].nombre + " ha muerto en la battalla.");
                    else
                        System.out.println(ejercitoHumanos[i].nombre + " tiene " + ejercitoHumanos[i].salud + " de vida.");
                }
                for (int i=0; i<ejercitoTrolls.length; i++){
                    if (ejercitoTrolls[i].salud <= 0)
                        System.out.println(ejercitoTrolls[i].nombre + " ha muerto en la batalla.");
                    else
                        System.out.println(ejercitoTrolls[i].nombre + " tiene " + ejercitoTrolls[i].salud + " de vida.");
                }
                break;
            }
        }
    }

    private void setAtaquesEjercitos(Personaje[] ejercitoHumanos, Personaje[] ejercitoTrolls){

        for (int i = 0; i<ejercitoHumanos.length; i++){
            int ataqueAleatorio = r.nextInt(3);
            if (ataqueAleatorio == 0)
                ejercitoHumanos[i].setAtaque(new AtaqueCuchillo());
            else  if (ataqueAleatorio == 1)
                ejercitoHumanos[i].setAtaque(new AtaqueEspada());
            else if (ataqueAleatorio == 2) {
                ejercitoHumanos[i].setAtaque(new AtaqueArco());
            }
        }

        for (int i = 0; i<ejercitoTrolls.length; i++){
            int ataqueAleatorio = r.nextInt(3);
            if (ataqueAleatorio == 0)
                ejercitoTrolls[i].setAtaque(new AtaqueCuchillo());
            else  if (ataqueAleatorio == 1)
                ejercitoTrolls[i].setAtaque(new AtaqueEspada());
            else if (ataqueAleatorio == 2) {
                ejercitoTrolls[i].setAtaque(new AtaqueArco());
            }
        }
    }

    private String ejercitosVivos(Personaje[] ejercitoHumanos, Personaje[] ejercitoTrolls) {
        int vidaHumanos = 0;
        int vidaTrolls = 0;
        for (int i=0; i<ejercitoHumanos.length; i++){
            if (ejercitoHumanos[i].salud < 0)
                ejercitoHumanos[i].salud = 0;
            vidaHumanos += ejercitoHumanos[i].salud;
        }
        for (int i=0; i<ejercitoTrolls.length; i++){
            if (ejercitoTrolls[i].salud < 0)
                ejercitoTrolls[i].salud = 0;
            vidaTrolls += ejercitoTrolls[i].salud;
        }

        if (vidaHumanos <= 0){
            return "Humanos Muertos";
        } else if (vidaTrolls <= 0) {
            return "Trolls Muertos";
        }

        return "";//Ambos bandos vivos
    }
}

