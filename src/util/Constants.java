package util;

public class Constants {
   
    public static final int RADIO_PONCHAR =50;
    public static final int RADIO_TARGET_BALL= 10;
    

    // Campo / cancha
    public static final int FIELD_WIDTH = 1200;
    public static final int FIELD_HEIGHT = 700;

    // Player/ jugador
    public static final int PLAYER_WIDTH = 100; // Ancho del jugador
    public static final int PLAYER_HEIGHT = 100; // Altura del jugador

    // Movimiento jugador 
    public static final int MOVEMENT_PLAYERS = 10;

     // Ball / Pelota
    public static final int BALL_WIDTH = 50; // Ancho del balon
    public static final int BALL_HEIGHT = 50; // Altura del balon

    // Coordenadas iniciales del jugador
    public static final int INITIAL_PLAYER_X = 300;
    public static final int INITIAL_PLAYER_Y = 370;

    // Coordenadas iniciales del jugador2
    public static final int INITIAL_PLAYER_X_2 = FIELD_WIDTH - INITIAL_PLAYER_X;
    public static final int INITIAL_PLAYER_Y_2 = 370;

     // Límites del campo para el jugador
     public static final int PLAYER_UPPER_LIMIT = 260; // En java a medida que subes, el valor en y disminuye
     public static final int PLAYER_LOWER_LIMIT = 525; // Entre mas alto sea, mas abajo está
     public static final int PLAYER_LEFT_LIMIT = 0;
     public static final int PLAYER_RIGHT_LIMIT = 535;

}
