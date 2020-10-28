package muustack.com.mascotasgram.presentador;

import android.content.Context;

import java.util.ArrayList;

import muustack.com.mascotasgram.db.ConstructorMascotas;
import muustack.com.mascotasgram.fragments.iRecyclerViewFragment;
import muustack.com.mascotasgram.pojo.Mascota;

public abstract class RecyclerViewPresenter implements IRecyclerViewPresenter {

    private iRecyclerViewFragment iRecyclerViewFragment;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;


    public RecyclerViewPresenter(iRecyclerViewFragment iRecyclerViewFragment, Context context) {
        this.iRecyclerViewFragment = iRecyclerViewFragment;
        this.context = context;
        obtenerMascotasBaseDatos();
    }


    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewFragment.inicializarAdaptadorRV(iRecyclerViewFragment.crearAdaptador(mascotas));
        iRecyclerViewFragment.generarGridLayout();
    }
}
