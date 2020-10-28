package muustack.com.mascotasgram.presentador;

import java.util.ArrayList;

import muustack.com.mascotasgram.pojo.Mascota;

public interface IRecyclerViewPresenter {

    public void obtenerMascotasBaseDatos();

    public void mostrarMascotasRV();

    Object crearAdaptador(ArrayList<Mascota> mascotas);

    void inicializarAdaptadorRV(Object crearAdaptador);
}
