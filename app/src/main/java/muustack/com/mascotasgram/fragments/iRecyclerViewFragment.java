package muustack.com.mascotasgram.fragments;

import java.util.ArrayList;

import muustack.com.mascotasgram.adaptador.MascotaAdaptador;
import muustack.com.mascotasgram.pojo.Mascota;

public interface iRecyclerViewFragment {

    public void generarGridLayout();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);

}
