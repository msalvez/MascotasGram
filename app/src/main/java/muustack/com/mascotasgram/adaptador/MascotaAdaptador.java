package muustack.com.mascotasgram.adaptador;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import muustack.com.mascotasgram.R;
import muustack.com.mascotasgram.db.ConstructorMascotas;
import muustack.com.mascotasgram.pojo.Mascota;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {
    ArrayList<Mascota> mascotas;
    Activity activity;


    public MascotaAdaptador(ArrayList<Mascota> mascotas, FragmentActivity activity){
        this.activity = activity;
        this.mascotas = mascotas;
    }

    //inflar el layout y lo pasara al view holder para que el obtenga los views
    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas, parent, false);
        return new MascotaViewHolder(v);
    }

    //asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgMascota.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreMascota.setText(mascota.getNombre());
        mascotaViewHolder.tvCounterLikes.setText(mascota.getLike());

        mascotaViewHolder.btnLikeMascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*mascota.addLikes(); comentar lineas */
                /*Toast.makeText(activity,"Diste Like a: "+mascota.getNombre() + " Cuenta con "+ mascota.getLike() +" Likes.",Toast.LENGTH_SHORT).show();
                mascotaViewHolder.tvCounterLikes.setText(mascota.getLike()); Comentar lineas*/
                ConstructorMascotas constructorMascota = new ConstructorMascotas(activity);
                constructorMascota.darLikeMascota(mascota);
                mascotaViewHolder.tvCounterLikes.setText(String.valueOf(constructorMascota.obtenerLikesMascota(mascota)));
            }
        });

    }

    @Override
    public int getItemCount() { // Cantidad de elementos que contiene mi lista de contactos
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgMascota;
        private TextView tvNombreMascota;
        private TextView tvCounterLikes;
        private ImageButton btnLikeMascota;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgMascota         = (ImageView) itemView.findViewById(R.id.imgMascota);
            tvNombreMascota    = (TextView) itemView.findViewById(R.id.tvNombreMascota);
            tvCounterLikes    = (TextView) itemView.findViewById(R.id.tvCounterLikes);
            btnLikeMascota = (ImageButton) itemView.findViewById(R.id.btnLikeMascota);
        }
    }
}
