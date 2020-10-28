package muustack.com.mascotasgram.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

import muustack.com.mascotasgram.R;
import muustack.com.mascotasgram.adaptador.MascotaAdaptador;
import muustack.com.mascotasgram.pojo.Mascota;


/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class PerfilFragment extends Fragment {

    ArrayList mascotas;
    RecyclerView rvPerfil;
    TextView nombreMascota;
    CircularImageView circularImageView;


    public PerfilFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_perfil, container, false);

        circularImageView = (CircularImageView) vista.findViewById(R.id.imagenCircular);
        rvPerfil  = (RecyclerView) vista.findViewById(R.id.rvMascotasGr);

        mascotas = new ArrayList <> ();
        mascotas.add(new Mascota("Puppy","1", R.drawable.perro1));
        mascotas.add(new Mascota("Ragnar", "0",R.drawable.perro2));
        mascotas.add(new Mascota("Laika", "5",R.drawable.perro3));
        mascotas.add(new Mascota("Scooby", "3",R.drawable.perro4));
        mascotas.add(new Mascota("Rambo", "2", R.drawable.perro5));
        mascotas.add(new Mascota("Floky", "6",R.drawable.perro7));

        GridLayoutManager glm= new GridLayoutManager(getActivity(),2,GridLayoutManager.VERTICAL,false);
        rvPerfil.setLayoutManager(glm);

        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        rvPerfil.setAdapter(adaptador);

        return vista;
    }

}
