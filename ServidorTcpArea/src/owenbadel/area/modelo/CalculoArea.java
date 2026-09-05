package owenbadel.area.modelo;

import java.io.Serializable;

public class CalculoArea implements Serializable {
    private float largo;
    private float ancho;

    public static class Area {
        public float resultado;
        public String mensaje;
    }

    private Area area;

    public CalculoArea() { }

    public CalculoArea(float largo, float ancho) {
        this.largo = largo;
        this.ancho = ancho;
    }

    public Area getArea() {
        area = new Area();
        if (largo <= 0 || ancho <= 0) {
            area.mensaje = "ERROR: El largo y el ancho deben ser mayores que 0";
            return area;
        } else {
            area.resultado = largo * ancho;
            area.mensaje = "Area calculada exitosamente: " + area.resultado + " m2";
            return area;
        }
    }

    public float getLargo() {
        return largo;
    }

    public void setLargo(float largo) {
        this.largo = largo;
    }

    public float getAncho() {
        return ancho;
    }

    public void setAncho(float ancho) {
        this.ancho = ancho;
    }
}
