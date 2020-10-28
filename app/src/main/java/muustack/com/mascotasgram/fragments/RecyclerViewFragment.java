package muustack.com.mascotasgram.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import muustack.com.mascotasgram.R;
import muustack.com.mascotasgram.adaptador.MascotaAdaptador;
import muustack.com.mascotasgram.pojo.Mascota;
import muustack.com.mascotasgram.presentador.IRecyclerViewPresenter;
import muustack.com.mascotasgram.presentador.RecyclerViewPresenter;


public class RecyclerViewFragment extends Fragment implements iRecyclerViewFragment{
    private ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;
    private IRecyclerViewPresenter presentador;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);


        rvMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        presentador = new RecyclerViewPresenter(this, getContext()) {
            @Override
            public Object crearAdaptador(ArrayList<Mascota> mascotas) {
                return null;
            }

            @Override
            public void inicializarAdaptadorRV(Object crearAdaptador) {

            }
        };
        return v;
    }

    @Override
    public void generarGridLayout() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        rvMascotas.setAdapter(adaptador);
    }
}